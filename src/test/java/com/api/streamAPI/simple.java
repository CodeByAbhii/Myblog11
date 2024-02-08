package com.api.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class simple {

    public static void main(String[] args) {

        List<Integer> out = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect = out.stream().filter(x -> x % 2 != 0).map(y -> y * y).collect(Collectors.toList());

        System.out.println(collect);

        List<String> strings = Arrays.asList("hello", "World","Exmaple","abhishek");
        List<String> result = strings.stream().filter(x ->! x.toLowerCase().contains("o")).collect(Collectors.toList());
        System.out.println(result);


        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> reduce = num.stream().filter(x -> x % 2 == 0).reduce((a, b) -> a * b);
        System.out.println(reduce);

        List<String> string = Arrays.asList("java", "is","and","pawerful","stream","flexible");
        List<String> list = string.stream().filter(x -> x.length() >= 5).collect(Collectors.toList());
        System.out.println(list);

        List<Integer> num1 = Arrays.asList(10,20,30,40,50);
        OptionalDouble average = num1.stream().mapToInt(Integer::intValue).average();
        System.out.println(average);

        List<Integer> num2= Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = num2.stream().filter(x -> x % 2 != 0).mapToInt(x -> x*x).sum();
        System.out.println(sum);


        List<String> word2 = Arrays.asList("Apple", "Banana", "Avocado", "Orange", "Grapes");
        String a1 = word2.stream().filter(x -> !x.toUpperCase().contains("A")).map(y -> y.toLowerCase()).collect(Collectors.joining("-"));
        System.out.println(a1);
    }
}
