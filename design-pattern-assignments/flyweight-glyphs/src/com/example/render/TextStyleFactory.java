package com.example.render;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TextStyleFactory {
    private static final TextStyleFactory INSTANCE = new TextStyleFactory();
    private final Map<String, TextStyle> cache = new ConcurrentHashMap<>();

    private TextStyleFactory() {
        if(INSTANCE != null) {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public static TextStyleFactory getInstance() {
        return INSTANCE;
    }

    public TextStyle getTextStyle(String font, int size, boolean bold) {
        String key = font + ":" + size + ":" + bold;
        cache.putIfAbsent(key, new TextStyle(font, size, bold));
        return cache.get(key);
    }
}
