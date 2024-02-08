package com.api.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerExm {
    public static void main(String[] args) {


        List<String> names = Arrays.asList("Abhi", "adam", "prakhar");
       Consumer<String> val = name-> System.out.println(name);
       names.forEach(val);


        List<Integer> numbers = Arrays.asList(4, 23, 52, 12, 47, 63, 25, 1);
      Consumer<Integer>  result= number-> System.out.println(number);
      numbers.forEach(result);


        List<String> str = Arrays.asList("Abhi", "Shivam", "Roshan");
       Consumer<String> val1 = name-> System.out.println(name);
       str.forEach(val1);


        List<String> names1 = Arrays.asList("abhi", "adam", "Kiran", "priya", "vishal", "prakhar");
        List<String> a = names1.stream().filter(name -> name.matches("['']+$")).collect(Collectors.toList());
        System.out.println(a);

    }
}
