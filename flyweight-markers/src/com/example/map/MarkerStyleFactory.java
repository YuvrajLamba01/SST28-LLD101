package com.example.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * TODO (student):
 * Implement Flyweight factory that caches MarkerStyle by a stable key.
 *
 * Suggested key format:
 *   shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O")
 *
 * After refactor:
 * - MapDataSource should call this factory to obtain shared MarkerStyle instances.
 */
public class MarkerStyleFactory {

    private final Map<String, MarkerStyle> cache = new HashMap<>();

    public MarkerStyle get(String shape, String color, int size, boolean filled) {
        Objects.requireNonNull(shape, "shape");
        Objects.requireNonNull(color, "color");
        String key = shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");
        return cache.computeIfAbsent(key, k -> new MarkerStyle(shape, color, size, filled));
    }

    public int cacheSize() {
        return cache.size();
    }
}
