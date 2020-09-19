package com.example.h2functiontest.repository;

import org.apache.commons.text.similarity.LevenshteinDistance;

public class Similarity {
    public static int similarity(String a, String b) {
        return LevenshteinDistance.getDefaultInstance().apply(a, b);
    }
}
