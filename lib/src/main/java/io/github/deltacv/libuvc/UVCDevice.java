package io.github.deltacv.libuvc;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

public class UVCDevice extends PointerType {
    public UVCDevice(Pointer address) {
        super(address);
    }

    public UVCDevice() {
        super();
    }
}