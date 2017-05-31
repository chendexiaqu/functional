package com.chendexiaqu;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
//        testMap();
//        testFilter();
//        testReduce();

        String[] strArray = {"abc", "mno", "xyz"};
        List<String> strList = Arrays.asList(strArray);

//        testThreeReduce(strList);
//        reduceTest(strList);

        parallelReduceTest(strList);

//        parallelReduceTest2(strList);
    }

    private static void testThreeReduce(List<String> strList) {

        String reduce = strList.stream().reduce("", (x, y) -> {
            System.out.println("x value: " + x);
            System.out.println("y value: " + y);
            return x + y;
        });
        System.out.println(reduce);

    }

    private static void reduceTest(List<String> strList) {
        System.out.println("stream test");
        int streamResult = strList.stream().reduce(
                0,
                (total, s) -> {
                    System.out.println("accumulator: total[" + total + "] s[" + s + "] s.codePointAt(0)[" + s.codePointAt(0) + "]");
                    return total + s.codePointAt(0);
                },
                (a, b) -> {
                    System.out.println("combiner: a[" + a + "] b[" + b + "]");
                    return 1000000;
                }
        );
        System.out.println("streamResult: " + streamResult);
    }

    private static void parallelReduceTest(List<String> strList) {
        System.out.println("parallelStream test");
        int parallelStreamResult = strList.parallelStream().reduce(
                0,
                (total, s) -> {
                    System.out.println("accumulator: total[" + total + "] s[" + s + "] s.codePointAt(0)[" + s.codePointAt(0) + "]");
                    return total + s.codePointAt(0);
                },
                (a, b) -> {
                    System.out.println("combiner: a[" + a + "] b[" + b + "]");
                    return 100000;
                }
        );
        System.out.println("parallelStreamResult: " + parallelStreamResult);
    }

    private static void parallelReduceTest2(List<String> strList) {
        System.out.println("parallelStream test2");
        int parallelStreamResult2 = strList.parallelStream().reduce(
                0,
                (total, s) -> {
                    System.out.println("accumulator: total[" + total + "] s[" + s + "] s.codePointAt(0)[" + s.codePointAt(0) + "]");
                    return total + s.codePointAt(0);
                },
                (a, b) -> {
                    System.out.println("combiner: a[" + a + "] b[" + b + "] a+b[" + (a + b) + "]");
                    return a + b;
                }
        );
        System.out.println("parallelStreamResult2: " + parallelStreamResult2);
    }

    private static void testReduce() {
        List<String> strings = Arrays.asList("haha", "hehe", "sssss", "nojklj");
//        Optional<String> reduce = strings.stream().reduce((result, element) -> result = result + element);
//        System.out.println(reduce.get());
//        String reduce = strings.stream().reduce("", (result,element)-> result=result+element);
        String reduce = strings.stream().reduce("",
                (result, element) -> result = result + element
                , (u, t) -> {
                    System.out.println("u:" + u + ", t:" + t);
                    return t + "123";
                });
        System.out.println(reduce);

    }

    private static void testFilter() {
        List<String> strings = Arrays.asList("haha", "hehe", "sssss", "nojklj");
        List<String> outPut = strings.stream().filter(x -> x.startsWith("h")).collect(Collectors.toList());
        System.out.println(outPut);
    }

    private static void testMap() {
        List<String> strings = Arrays.asList("haha", "hehe", "sssss", "nojklj");
        List<String> outPut = strings.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(outPut);
    }

    static class XX {
        public static String bla(String a) {
            return a.toUpperCase();
        }
    }


}
