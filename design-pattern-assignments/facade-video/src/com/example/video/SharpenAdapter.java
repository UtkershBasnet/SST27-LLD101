package com.example.video;

import java.util.Objects;

public class SharpenAdapter {
    private final LegacySharpen legacy;

    public SharpenAdapter(LegacySharpen legacy) {
        this.legacy = Objects.requireNonNull(legacy);
    }

    public Frame[] applySharpen(Frame[] frames, int strength) {
        // Convert frames to some handle (fake for demo)
        String handle = "HANDLE:frames";

        // Call legacy API
        String resultHandle = legacy.applySharpen(handle, strength);

        // Convert result handle back to frames (stub for demo)
        System.out.println("Sharpen applied via legacy, got " + resultHandle);

        return frames; // In real code you'd return new processed frames
    }
}
