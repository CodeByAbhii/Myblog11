package com.api.streamAPI;

import java.util.Arrays;

import java.util.List;

import java.util.stream.Collectors;

public class SimpleJavaClass {


    public static <Function> void main(String[] args) {

                          // program - 1

//       Predicate<Integer> val= y->y%2==0;
//       boolean result =  val.test(10);
//        System.out.println(result);

                            // program - 2

        // campring Two string is equal or not using Functional Interface using java interface

//        Predicate<String> val = str->str.equals("mike");
//        boolean result = val.test("stallin");
//        System.out.println(result);

                            // program - 3

        // Using array list find the even Number using fuctional Interface

//        List<Integer> number = Arrays.asList(4, 05, 10, 6, 14, 32, 65, 17, 33);
//        List<Integer> evenNumber = number.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
//        System.out.println(evenNumber);

                            // program - 4

// find odd No using Stream API

//        List<Integer> numbers = Arrays.asList(1, 25, 4, 3, 6, 5, 12, 7, 9);
//        List<Integer> oddNum = numbers.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
//        System.out.println(oddNum);

                            // program - 5

        //fina the name in witch start letter m using stream api

        List<String> name = Arrays.asList("mike", "adam", "mike", "Stallin");
        List<String> data1 = name.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
        List<String> data2 = name.stream().filter(s -> s.equals("mike")).collect(Collectors.toList());
        List<String> data3 = name.stream().filter(s -> s.endsWith("n")).collect(Collectors.toList());
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);

                             // program - 6

        // find the string length using Stream API

        List<Integer> numbers = Arrays.asList(1, 3, 4, 6,5,7,3, 12, 7, 17, 23, 9);
        List<Integer> collect = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);


        // remove the duplicate array using stream API
        List<Integer> collect1 = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);


    }
}
