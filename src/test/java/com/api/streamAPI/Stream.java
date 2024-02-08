package com.api.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {

        List<String> word2 = Arrays.asList("Apple", "Banana", "Avocado", "Orange", "Grapes");
        List<String> list = word2.stream().filter(x -> !x.toLowerCase().startsWith("a")).map(y -> y.toLowerCase()).collect(Collectors.toList());
        System.out.println(list);
    }
}
