package io.github.deltacv.libuvc;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class UVCStreamCtrl extends Structure {
    public int bmHint;
    public int bFormatIndex;
    public int bFrameIndex;
    public int dwFrameInterval;
    public int wKeyFrameRate;
    public int wPFrameRate;
    public int wCompQuality;
    public int wCompWindowSize;
    public int wDelay;
    public int dwMaxVideoFrameSize;
    public int dwMaxPayloadTransferSize;
    
    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("bmHint", "bFormatIndex", "bFrameIndex", "dwFrameInterval",
                             "wKeyFrameRate", "wPFrameRate", "wCompQuality", "wCompWindowSize",
                             "wDelay", "dwMaxVideoFrameSize", "dwMaxPayloadTransferSize");
    }
}