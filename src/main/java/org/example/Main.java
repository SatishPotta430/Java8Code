package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("HarshaRoyal","Sathish","Anji","Ganesh");
        String a = list.stream().max(Comparator.comparing(String::length)).get();
        System.out.println("Highest length " + a);

        List<Integer> list1 = Arrays.asList(10,20,30,40,50);
        OptionalDouble avg = list1.stream().mapToInt(Integer::intValue).average();
        System.out.println("average " + avg.getAsDouble());

        List<Integer> list3 = Arrays.asList(1, 2, 3, 5, 7, 9);
        List<Integer> list4 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> mergedList = Stream.concat(list3.stream(), list4.stream())
                .sorted()
                .distinct().toList();
        System.out.println("sortred " + mergedList);

        List<Integer> list5 = Arrays.asList(1, 2, 3, 5, 7, 9);
        List<Integer> list6 = Arrays.asList(2, 4 ,5 , 6 , 7 ,8, 10);
        List<Integer> commonList = list5.stream().filter(lista->list6.contains(lista)).toList();
        System.out.println("commonList " + commonList);

        List<Integer> list7 = Arrays.asList(1, 2, 3, 5, 7, 9);
        int sum =  list7.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum of integer " + sum);

        List<student> studentList = Arrays.asList(
                new student("Harsha",34,"kurnool") ,
                new student("Satish",38,"Vizag"),
                new student("Satish",38,"Vizag"),
                new student("Satish",38,"Vizag"),
                new student("Harsha",34,"kurnool") ,
                new student("Satish",38,"Vizag"));

        Map<String, Integer> map = studentList.stream().collect(Collectors.groupingBy(student :: getName,
                Collectors.summingInt(student ::getAge)));
        System.out.println("sum of ages for the stuents  " + map);
        List<String> name = studentList.stream().map(student :: getName).toList();
        System.out.println("names in the list " + name);


        List<Integer> list8 = Arrays.asList(1, 2, 3, 5, 7, 9);
        int min = list8.stream().sorted().skip(5).findFirst().get();

        System.out.println("min value " + min);


        int max = list8.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        System.out.println("max value " + max);

        int max1 = list8.stream().max(Integer::compareTo).get();
        System.out.println("max value " + max1);
        int min1 = list8.stream().skip(1).min(Integer::compareTo).get();
        System.out.println("min value " + min1);

        Map<String,Long> map2 = studentList.stream().collect(Collectors.groupingBy(student::getName,Collectors.counting()));
        System.out.println("Name lenght counting " + map2);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partitioned = numbers
                .stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0));
        List<Integer> evenNumbers = partitioned.get(true);
        List<Integer> oddNumbers = partitioned.get(false);
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
    }

}