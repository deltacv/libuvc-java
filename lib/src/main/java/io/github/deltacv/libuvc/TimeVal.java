package io.github.deltacv.libuvc;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class TimeVal extends Structure {
    public long tv_sec;    // seconds
    public long tv_usec;   // microseconds

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("tv_sec", "tv_usec");
    }
}
