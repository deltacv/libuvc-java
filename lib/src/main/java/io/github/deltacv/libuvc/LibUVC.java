package io.github.deltacv.libuvc;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

public interface LibUVC extends Library {

    LibUVC INSTANCE = Native.load("uvc", LibUVC.class);

    // uvc_error_t uvc_init(uvc_context_t **ctx, struct libusb_context *usb_ctx);
    int uvc_init(PointerByReference ctx, Pointer usbCtx);

    // void uvc_exit(uvc_context_t *ctx);
    void uvc_exit(UVCContext ctx);

    // uvc_error_t uvc_find_device(uvc_context_t *ctx, uvc_device_t **dev, int vid, int pid, const char *sn);
    int uvc_find_device(UVCContext ctx, PointerByReference dev, int vid, int pid, String sn);

    // uvc_error_t uvc_open(uvc_device_t *dev, uvc_device_handle_t **devh);
    int uvc_open(UVCDevice dev, PointerByReference devh);

    // void uvc_close(uvc_device_handle_t *devh);
    void uvc_close(UVCDeviceHandle devh);

    // uvc_error_t uvc_get_stream_ctrl_format_size(uvc_device_handle_t *devh, uvc_stream_ctrl_t *ctrl, uvc_frame_format format, int width, int height, int fps);
    int uvc_get_stream_ctrl_format_size(UVCDeviceHandle devh, UVCStreamCtrl ctrl, int format, int width, int height, int fps);

    // uvc_error_t uvc_start_streaming(uvc_device_handle_t *devh, uvc_stream_ctrl_t *ctrl, uvc_frame_callback_t *cb, void *user_ptr, uint8_t flags);
    int uvc_start_streaming(UVCDeviceHandle devh, UVCStreamCtrl ctrl, UVCFrameCallback cb, Pointer userPtr, byte flags);

    // void uvc_stop_streaming(uvc_device_handle_t *devh);
    void uvc_stop_streaming(UVCDeviceHandle devh);

    // uvc_error_t uvc_unref_device(uvc_device_t *dev);
    void uvc_unref_device(UVCDevice dev);
}