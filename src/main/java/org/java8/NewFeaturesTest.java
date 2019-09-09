package org.java8;



import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.function.Predicate;

public class NewFeaturesTest {

    public static void main(String[] args) {

//        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
//        eval(list, n -> true);
//
//        System.out.println("*****************");
//
//        eval(list, n-> n > 5);
//
//        System.out.println("*****************");
//
//        eval(list, n-> n % 2 == 0);
//
//        Learner student = new Student();
//        student.print();
//
//        LocalDateTime now = LocalDateTime.now();
//        LocalDate localDate = now.toLocalDate();
//        LocalTime localTime = now.toLocalTime();
//        LocalDateTime localDateTime = now.withDayOfMonth(10).withYear(2019);
//        System.out.println(localDate);
//        System.out.println(localDateTime);
//
//
//        LocalDate of = LocalDate.of(2018, Month.DECEMBER, 25);
//        System.out.println(of);

//        try {
//            String encoding = Base64.getEncoder().encodeToString("xinke".getBytes("utf-8"));
//            System.out.println(encoding);
//            byte[] decode = Base64.getDecoder().decode(encoding);
//            System.out.println("decode "+ new String(decode));
//
//            String enc = Base64.getEncoder().encodeToString("1213143424".getBytes("utf-8"));
//            System.out.println(enc.length());
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        test();

    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate){
        for(Integer n : list){
            if (predicate.test(n)){
                System.out.println(n);
            }
        }
    }

    interface Younger{
        default void print(){
            System.out.println("im younger");
        }

        static void say(){
            System.out.println("im capital");
        }
    }

    interface Learner{
        default void print(){
            System.out.println("im Learner");
        }
    }

    public static class Student implements Younger, Learner{
        @Override
        public void print() {
            Younger.super.print();
            Learner.super.print();
            Younger.say();
            System.out.println("im student");
        }
    }

    public static void test(){
        try {
            System.out.println("aa");
            return;
        }catch (Exception e){

        }
        try {

            System.out.println("bb");
            return;
        }catch (Exception e){

        }
    }
}
