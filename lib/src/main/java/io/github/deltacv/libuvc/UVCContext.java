package io.github.deltacv.libuvc;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

public class UVCContext extends PointerType {
    public UVCContext(Pointer address) {
        super(address);
    }

    public UVCContext() {
        super();
    }
}