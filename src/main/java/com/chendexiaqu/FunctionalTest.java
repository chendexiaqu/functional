package com.chendexiaqu;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalTest {

    public static void main(String[] args) {
//        testPredicate();
//        testSupplier();
//        testConsumer();
//        testFunction();
//        testUnaryOperator();
//        testBinaryOperator();
        testMethodReference();
    }

    private static void testBinaryOperator() {
        BinaryOperator<Integer> binaryOperator = BinaryOperator.maxBy((x, y) -> (x - y));
        System.out.println(binaryOperator.apply(3, 8));
    }

    private static void testUnaryOperator() {
        UnaryOperator<String> operator = UnaryOperator.identity();
        System.out.println(operator.apply("haha"));
    }

    private static void testFunction() {
        Function<Integer, Integer> function = integer -> integer * 9;
        System.out.println(function.apply(9));
    }

    private static void testConsumer() {
        IntConsumer intConsumer = (int x) -> System.out.println(x * 3);
        intConsumer.accept(9);
    }

    private static void testSupplier() {
        Supplier<Integer> supplier = () -> 1 + 2;
        System.out.println(supplier.get());
    }

    private static void testMethodReference() {
        List<String> strings = Arrays.asList("1", "2", "3", "4");
        strings.forEach(System.out::println);
        System.out.println("-------------------------------");
        strings.forEach(x -> System.out.println(x));
    }

    private static void testPredicate() {
        Predicate<Integer> intPredicate = x -> (x > 3);
        System.out.println(intPredicate.test(8));
        Predicate<String> stringPredicate1 = e -> e.equals("haha");
        Predicate<String> stringPredicate2 = e -> e.equals("lala");
        Predicate<String> testOrPredicate = stringPredicate1.or(stringPredicate2);
        System.out.println(testOrPredicate.test("lala"));
    }
}
