package main;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsOperations {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,4,5,6,7,8,9,24,5,6734,56,76);

        System.out.println("Even Numbers");
        System.out.println("=================================");
        numbers.stream()
                .filter(n->n%2 == 0)
                .forEach(System.out::println);
        System.out.println("=================================");
        System.out.println("Numbers starting with 1");
        List<Integer> numberStart = Arrays.asList(1,2,34,13,16,1134,56,67,14,178,55);

        numberStart.stream()
                .map(n-> n+"")
                .filter(n-> n.startsWith("1"))
                .forEach(System.out::println);


        System.out.println("=================================");
        System.out.println("Duplicates Using Set and Filter");
        List<Integer> numberDuplicate = Arrays.asList(1,2,34,1,16,2,56,56,14,178,16);
        HashSet<Integer> set = new HashSet<>();

        numberDuplicate.stream()
                .filter(n-> !set.add(n))
                .forEach(System.out::println);

        System.out.println("=================================");
        System.out.println("Duplicates Using GroupingBy");
        List<Integer> numberDuplicateGroupBy = Arrays.asList(1,2,34,1,16,2,56,56,14,178,16);

        numberDuplicateGroupBy.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(e-> e.getValue()>1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        System.out.println("=================================");
        System.out.println("Duplicates Using Collection Frequency");
        List<Integer> numberDuplicateFrequency = Arrays.asList(1,2,34,1,16,2,56,56,14,178,16);

        numberDuplicateFrequency.stream()
                .filter(n-> Collections.frequency(numberDuplicateFrequency,n)>1)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        long size =numberDuplicateFrequency.stream().count();
        System.out.println("List size :"+ size);

        Integer max = numberDuplicateFrequency.stream()
                .max(Integer::compare)
                .get();
        System.out.println("Max number:"+ max);

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        System.out.println("Sort List");
        System.out.println("=================================");
        myList.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("Reverse Sort");
        System.out.println("=================================");
        myList.stream()
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);

    }
}
