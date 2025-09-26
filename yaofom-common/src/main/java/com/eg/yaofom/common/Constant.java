package com.eg.yaofom.common;

public class Constant {

    public static final int MIN_STOCK_COUNT_FOR_LIVE = 5;
    public static final int STOCK_PRICE_MIN_INTEGER_PART = 5;
    public static final int STOCK_PRICE_MIN_FRACTIONAL_PART = 4;
    public static final int STOCK_PRICE_DB_PRECISION = Constant.STOCK_PRICE_MIN_INTEGER_PART + Constant.STOCK_PRICE_MIN_FRACTIONAL_PART;

    public static final int  MIN_NAME_SIZE = 3;
    public static final int MAX_NAME_SIZE = 10;

    public static final String OOPS_SOMETHING_UNEXPECTED_HAPPENED = "Something unexpected happened, sorry :(";

}