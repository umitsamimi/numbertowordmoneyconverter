package com.tr.converter.convermoneynumbertotext.model.enumerated;

import java.util.Arrays;

public enum Tens {

    ZERO		(0,""),
    TEN		    (1,"ten"),
    TWENTY		(2,"twenty"),
    THIRTY		(3,"thirty"),
    FORTY       (4,"forty"),
    FIFTY		(5,"fifty"),
    SIXTY		(6,"sixty"),
    SEVENTY		(7,"seventy"),
    EIGHTY		(8,"eighty"),
    NINETY		(9,"ninety");

    private int key;
    private String value;

    Tens(int key, String value){
        this.key = key;
        this.value = value;
    }

    public static String getValueFromKey(int key){
        return Arrays.stream(Tens.values())
                .filter(item-> item.getKey() == key)
                .map(Tens::getValue).reduce("", String::concat);
    }
    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
