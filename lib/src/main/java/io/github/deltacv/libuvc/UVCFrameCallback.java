package io.github.deltacv.libuvc;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

public interface UVCFrameCallback extends Callback {
    void apply(UVCFrame frame, Pointer userPtr);
}