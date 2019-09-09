package org.java8;


import java.sql.Connection;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LambdaTest {

    final static String name = "hello";

    public static void main(String[] args) {


        GreetingService greetingService = message1 -> System.out.println(name + message1);
        greetingService.sayMessage("xinke");

//        List<Integer> list = Arrays.asList(2,3,4,5,2,1,2);
//        List<Integer> collect = list.stream().map(n -> n * n).distinct().collect(Collectors.toList());
//        System.out.println(collect);
//
//        List<String> strings = Arrays.asList("qw","","qqq","","w");
//        long count = strings.stream().filter(s -> s.isEmpty()).count();
//        System.out.println(count);
//        System.out.println("*************");
//
//        Random random = new Random(47);
//        random.ints(5, 10, 20).limit(10).sorted().forEach(System.out::println);

//        List<String> collect = list.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
//        System.out.println(collect);
        List<String> list = Arrays.asList("qw","","xx","cc","");
        String s = getMergedStringUsingJava7(list, ": ");
        System.out.println(s);
        System.out.println(LambdaTest.class);
//        String collect = list.stream().filter((s) -> !s.isEmpty()).collect(Collectors.joining(": "));
//        System.out.println(collect);
//
//
//        List<Integer> list1 = Arrays.asList(1,3,5,2,4,5,2,1,2);
//        IntSummaryStatistics intSummaryStatistics = list1.stream().mapToInt(x -> x).summaryStatistics();
//        System.out.println("max:" +intSummaryStatistics.getMax());
//        System.out.println("sum:" +intSummaryStatistics.getCount());
//        System.out.println(intSummaryStatistics.getAverage());


    }

    interface GreetingService {
        void sayMessage(String message1);
    }

    public static String getMergedStringUsingJava7(List<String> list, String sep){

        StringBuilder sb = new StringBuilder();

        for(String s : list){
            if(!s.isEmpty()){
                sb.append(s);
                sb.append(sep);
            }
        }
        String string = sb.toString().substring(0, sb.length() - 2);
        return string;
    }
}
