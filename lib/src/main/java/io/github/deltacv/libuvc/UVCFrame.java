package io.github.deltacv.libuvc;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class UVCFrame extends Structure {
    public Pointer data;
    public int dataBytes;
    public int width;
    public int height;
    public int frameFormat;
    
    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("data", "dataBytes", "width", "height", "frameFormat");
    }
}