package com.chendexiaqu;

import java.util.function.Predicate;

public class StockUtil {
    public static StockInfo getPrice(final String ticker) {
        return new StockInfo(ticker, Finance.getPrice(ticker));
    }

    public static Predicate<StockInfo> isPriceLessThan(final int price) {
        return stockInfo -> stockInfo.price - price < 0;
    }

    public static StockInfo pickHigh(
            final StockInfo stockInfo1, final StockInfo stockInfo2) {
        return stockInfo1.price - stockInfo2.price > 0 ? stockInfo1 : stockInfo2;
    }
}
