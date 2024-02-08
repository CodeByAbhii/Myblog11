package com.api.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {

        // program 1

        //Given a list of integers, write a Java program using the Stream API to
        // find and print the sum of all even numbers in the list.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = numbers.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        // program 2

        //Given a list of strings, write a Java program using the Stream API to
        // filter out the strings that start with the letter 'A' (case-insensitive) and concatenate
        // the remaining strings into a single comma-separated string.

        List<String> words = Arrays.asList("Apple", "Banana", "Orange", "Avocado", "Grapes");
        List<String> a = words.stream().filter(word -> !word.toUpperCase().startsWith("A")).collect(Collectors.toList());
        System.out.println(a);


        // program 3

        //Given a list of integers, write a Java program using the Stream API to
        // find and print the square of each odd number in the list.


        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect = number.stream().filter(num -> num % 2 != 0).map(n -> n * n).collect(Collectors.toList());
        System.out.println(collect);

        // program 4

        //Given a list of strings, write a Java program using the Stream API to
        // filter out the strings containing the letter 'o' (case-insensitive) and concatenate
        // the remaining strings into a single space-separated string.

        List<String> num = Arrays.asList("Hello", "Exmaple", "Java", "stream", "world");
        String str = num.stream().filter(word -> !word.toLowerCase().contains("o")).collect(Collectors.joining(" "));
        System.out.println(str);

        // program 5

        //Given a list of integers, write a Java program using the Stream API to
        // find and print the product of all even numbers in the list.

        List<Integer> num2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = num2.stream().filter(x -> x % 2 == 0).reduce(1, (acc, x) -> acc * x);
        System.out.println(reduce);


        // Program 6

        //Given a list of strings, write a Java program using the Stream API
        // to count and print the number of strings whose length is greater than 5.

        List<String> var = Arrays.asList("Java", "Stream", "API", "is", "powerful", "and", "flexible");
        long count = var.stream().filter(strs -> strs.length() > 5).count();

        System.out.println(count);

        // Program 7

        //Given a list of integers, write a Java program using the Stream API to
        // find and print the average of all the numbers in the list

        List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50);
        double v = nums.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println(v);

        // Program   8

        //Given a list of integers, write a Java program using the Stream API to
        // find and print the sum of the square of each odd number in the list.

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer i = list.stream().filter(n -> n % 2 != 0).reduce((x, y) -> x + y).map(z -> z * z).get();
        int sum1 = list.stream().filter(n -> n % 2 != 0).mapToInt(x -> x * x).sum();
        System.out.println(i);
        System.out.println(sum1);

        // Program   9

        //Question:
        //Given a list of strings, write a Java program using the Stream API to filter out the strings that have
        // a length less than 5, convert the remaining strings to lowercase, and then concatenate them into a single space-separated string.


        List<String> word = Arrays.asList("Java", "Stream", "API", "is", "powerful", "and", "flexible");


        List<String> collect1 = word.stream().filter(x -> x.length() >= 5).map(j -> j.toLowerCase()).collect(Collectors.toList());
        System.out.println(collect1);


        // program 10

        //Question:
        //Given a list of integers, write a Java program using the Stream API to
        // find and print the product of all numbers in the list, excluding the number 1.

        List<Integer> n1 = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 7, 8, 9);

        int i1 = n1.stream().filter(x -> x != 1).reduce(1, (k, b) -> k * b).intValue();
        System.out.println(i1);

        // program 11

        //Question:
        //Given a list of strings, write a Java program using the Stream API to filter out the strings that contain
        // the letter 'e' (case-insensitive), sort the remaining strings in alphabetical order, and then
        // concatenate them into a single comma-separated string.

        List<String> w1 = Arrays.asList("Java", "Stream", "API", "is", "powerful", "and", "flexible");

        String e = w1.stream().filter(x -> !x.toLowerCase().contains("e")).sorted().collect(Collectors.joining(","));

        System.out.println(e);

        //program 12

        //Question:
        //Given a list of integers, write a Java program using the Stream API
        // to filter out the duplicate values and print the distinct values in sorted order.

        List<Integer> n2 = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        List<Integer> collect2 = n2.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(collect2);


        //program 13

        //Question:
        //Given a list of strings, write a Java program using the Stream API
        // to filter out the strings that have an odd length, convert
        // the remaining strings to uppercase, and then concatenate them into a single string.

        List<String> w2 = Arrays.asList("Java", "Stream", "API", "is", "powerful", "and", "flexible");
        List<String> collect3 = w2.stream().filter(st -> st.length() % 2 == 0).map(l -> l.toUpperCase()).collect(Collectors.toList());

        System.out.println(collect3);


        // program 14
        //Question:
        //Given a list of integers, write a Java program using the Stream API to filter out the even numbers, square the remaining odd numbers, and then find the sum of all the squared odd numbers.

        List<Integer> out = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum2 = out.stream().filter(x -> x % 2 != 0).mapToInt(y -> y * y).sum();
        System.out.println(sum2);


        List<String> w3 = Arrays.asList("Hellow", "Would", "Java", "Stream", "API", "is", "powerful", "and", "flexible");

        String out1 = w3.stream().filter(x -> !x.toUpperCase().contains("o")).map(k -> new StringBuilder(k).reverse().toString()).collect(Collectors.joining(","));
        System.out.println(out1);


        List<Integer> numbers1 = Arrays.asList(13, 7, 22, 9, 31, 18, 5);
        OptionalInt max = numbers1.stream().mapToInt(x -> x.intValue()).max();
        OptionalInt min = numbers1.stream().mapToInt(x -> x*x).min();

        System.out.println(max);
        System.out.println(min);




    }
}