package com.chendexiaqu;

public class StockInfo {
    public final String ticker;
    public final int price;
    public StockInfo(final String symbol, final int thePrice) {
        ticker = symbol;
        price = thePrice;
    }
    public String toString() {
        return String.format("ticker: %s price: %g", ticker, price);
    }
}
