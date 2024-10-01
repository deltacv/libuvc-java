package io.github.deltacv.libuvc;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

// uvc_frame_t structure
public class UVCFrame extends Structure {
    public Pointer data; // Image data for this frame
    public int data_bytes; // Size of image data buffer
    public int width; // Width of image in pixels
    public int height; // Height of image in pixels
    public int frame_format; // Pixel data format (use int for enum)
    public int step; // Number of bytes per horizontal line
    public int sequence; // Frame number
    public TimeVal capture_time; // Capture start time
    public TimeSpec capture_time_finished; // Capture end time
    public UVCDeviceHandle source; // Device handle
    public byte library_owns_data; // Ownership flag for data buffer
    public Pointer metadata; // Metadata for this frame if available
    public int metadata_bytes; // Size of metadata buffer

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("data", "data_bytes", "width", "height", "frame_format",
                "step", "sequence", "capture_time", "capture_time_finished",
                "source", "library_owns_data", "metadata", "metadata_bytes");
    }
}