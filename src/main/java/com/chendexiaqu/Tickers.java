package com.chendexiaqu;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tickers {
    public static final Map<String, Integer> symbolMaps = ImmutableMap.of("AMD", 88, "HPQ", 98, "IBM", 105, "TXN", 66, "VMW", 1);
    public static final List<String> symbols = Arrays.asList("AMD", "HPQ", "IBM", "TXN", "VMW");
}
