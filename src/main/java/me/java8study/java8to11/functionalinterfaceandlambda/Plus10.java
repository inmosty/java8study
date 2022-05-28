package me.java8study.java8to11.functionalinterfaceandlambda;

import java.util.function.Function;

public class Plus10 implements Function<Integer,Integer> {

    @Override
    public Integer apply(Integer t) {
        return t + 10;
    }
}
