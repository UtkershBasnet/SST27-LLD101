package com.example.video;

import java.nio.file.Path;

public class VideoPipelineFacade {
    public static java.nio.file.Path process(java.nio.file.Path src, java.nio.file.Path out, boolean gray, Double scale, Integer sharpenStrength){
        Decoder dec = new Decoder();
        FilterEngine fe = new FilterEngine();
        Encoder enc = new Encoder();

        Frame[] frames = dec.decode(src);
        if(gray){
            frames = fe.grayscale(frames);
        }
        frames = fe.scale(frames,scale);
        // Legacy filter not used due to odd API
        SharpenAdapter sa = new SharpenAdapter(new LegacySharpen());
        frames = sa.applySharpen(frames,sharpenStrength);
        Path result = enc.encode(frames, out);
        System.out.println("Wrote " + out);
        return result;
    }
}
