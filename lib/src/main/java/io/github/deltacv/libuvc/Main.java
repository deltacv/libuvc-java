package io.github.deltacv.libuvc;

import java.io.IOException;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

public class Main {
    
    static {
        try {
            Native.extractFromResourcePath("/libuvc.so");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PointerByReference ctx = new PointerByReference();
        int res = LibUVC.INSTANCE.uvc_init(ctx, null);
        if (res < 0) {
            System.err.println("Failed to initialize libuvc");
            return;
        }

        UVCContext uvcContext = new UVCContext(ctx.getValue());

        PointerByReference dev = new PointerByReference();

        res = LibUVC.INSTANCE.uvc_find_device(uvcContext, dev, 0, 0, null);  // Use VID/PID as needed
        
        if (res < 0) {
            System.err.println("No UVC devices found");
            LibUVC.INSTANCE.uvc_exit(uvcContext);
            return;
        }

        PointerByReference devh = new PointerByReference();
        res = LibUVC.INSTANCE.uvc_open(new UVCDevice(dev.getValue()), devh);
        if (res < 0) {
            System.err.println("Failed to open device");
            LibUVC.INSTANCE.uvc_unref_device(new UVCDevice(dev.getValue()));
            LibUVC.INSTANCE.uvc_exit(uvcContext);
            return;
        }

        UVCDeviceHandle deviceHandle = new UVCDeviceHandle(devh.getValue());

        UVCStreamCtrl ctrl = new UVCStreamCtrl();
        res = LibUVC.INSTANCE.uvc_get_stream_ctrl_format_size(deviceHandle, ctrl, 0, 640, 480, 30);
        if (res < 0) {
            System.err.println("Failed to get stream control");
            LibUVC.INSTANCE.uvc_close(deviceHandle);
            LibUVC.INSTANCE.uvc_unref_device(new UVCDevice(dev.getValue()));
            LibUVC.INSTANCE.uvc_exit(uvcContext);
            return;
        }

        UVCFrameCallback frameCallback = new UVCFrameCallback() {
            @Override
            public void apply(UVCFrame frame, Pointer userPtr) {
                System.out.println("Frame received: " + frame.width + "x" + frame.height);
            }
        };

        res = LibUVC.INSTANCE.uvc_start_streaming(deviceHandle, ctrl, frameCallback, null, (byte) 0);
        if (res < 0) {
            System.err.println("Failed to start streaming");
        }

        // Stream for 10 seconds
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LibUVC.INSTANCE.uvc_stop_streaming(deviceHandle);
        LibUVC.INSTANCE.uvc_close(deviceHandle);
        LibUVC.INSTANCE.uvc_unref_device(new UVCDevice(dev.getValue()));
        LibUVC.INSTANCE.uvc_exit(uvcContext);
    }
    
}
