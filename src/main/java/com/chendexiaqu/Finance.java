package com.chendexiaqu;

import com.google.common.base.Stopwatch;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;

public class Finance {

    private Runnable r1 = () -> { System.out.println(this); };
    private Runnable r2 = () -> { System.out.println(toString()); };

    public String toString() {  return "Hello, world"; }

    public static int getPrice(final String ticker) {
        try {
            return Tickers.symbolMaps.get(ticker);
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch().start();
        test_one();
//        test_two();

//        test_three();
//        test_four();
//        test_five();
//        test_six();
        System.out.println(stopwatch.stop().elapsedTime(TimeUnit.SECONDS));
    }

    private static void test_three() {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        outputStream.filter(e -> e > 2).forEach(System.out::println);
    }

    private static void test_four() {
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }

    private static void test_five() {
//        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::sum).get());
        Stream.generate(new MySupplier()).
                limit(10).
                forEach(System.out::println);
    }

    private static void test_six() {
        new Finance().r1.run();
        new Finance().r2.run();
    }


    private static void test_one() {
        System.out.println("Stocks priced over $20 are " +
                Tickers.symbols
                        .parallelStream()
                        .filter(symbol -> Finance.getPrice(symbol) > 20)
                        .collect(joining(", ")));
    }

    private static void test_two() {
        final List<StockInfo> stocks = Tickers.symbols.stream().map(StockUtil::getPrice).collect(Collectors.toList());


        final List<StockInfo> stocksPricedUnder500 = new ArrayList<>();
        final Predicate<StockInfo> isPriceLessThan500 = StockUtil.isPriceLessThan(500);
        for(StockInfo stock : stocks) {
            if(isPriceLessThan500.test(stock))
                stocksPricedUnder500.add(stock);
        }

        StockInfo highPriced = new StockInfo("", 0);
        for(StockInfo stock : stocksPricedUnder500) {
            highPriced = StockUtil.pickHigh(highPriced, stock);
        }

        System.out.println("High priced under $500 is " + highPriced);
    }

    private static class MySupplier implements Supplier<Integer> {
        private Random random = new Random();
        @Override
        public Integer get() {
            return random.nextInt(100);
        }
    }


}
