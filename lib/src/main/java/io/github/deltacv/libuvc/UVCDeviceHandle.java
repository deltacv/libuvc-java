package io.github.deltacv.libuvc;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

public class UVCDeviceHandle extends PointerType {
    public UVCDeviceHandle(Pointer address) {
        super(address);
    }

    public UVCDeviceHandle() {
        super();
    }
}