package com.api.streamAPI;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class simpleClass {

    public static void main(String[] args) {

        List<String> strs = Arrays.asList("abhi","vishal","prakhar","viswas","anil");
        List<String> collect1 = strs.stream().filter(str->str.startsWith("p")).collect(Collectors.toList());
        List<String> collect2= strs.stream().filter(str->str.endsWith("l")).collect(Collectors.toList());

        System.out.println(collect1);
        System.out.println(collect2);

        //You are given a list of strings containing both words and numbers.
        // Create a method that filters out the numbers from the list and returns a new list containing only the words.

        List<String> mixedList = Arrays.asList("apple", "123", "orange", "456", "ABHISHEK","banana");
        List<String> rs = mixedList.stream().filter(s -> s.matches("[0-9A-Z]+$")).collect(Collectors.toList());
        List<String> rs1 = mixedList.stream().filter(s -> s.matches("[a-z]+$")).collect(Collectors.toList());
        System.out.println(rs);
        System.out.println(rs1);

     //   Given a list of strings, convert each string to its uppercase form and concatenate
        //   them into a single string, separated by a comma.

        List<String> stringList = Arrays.asList("apple", "orange", "banana", "grape");
        List<String> collect = stringList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect);
    }

    // consumer -->

   // Consumer is a functional Interface That Takes input And No Produce output  it taks inly input

    //                                  program - 1

    List<String> names = Arrays.asList("apple", "orange", "banana", "grape");
  Consumer<String> val= name->  System.out.println(name);


}
