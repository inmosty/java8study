package me.java8study.java8to11.functionalinterfaceandlambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java가 기본으로 제공하는 함수형 인터페이스
 - java.lang.funcation 패키지
 - 자바에서 미리 정의해둔 자주 사용할만한 함수 인터페이스
 - Function<T, R>
 - BiFunction<T, U, R>
 - Consumer<T>
 - Supplier<T>
 - Predicate<T>
 - UnaryOperator<T>
 - BinaryOperator<T>

 * Function<T, R>
 - T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
 - R apply(T t)
 - 함수 조합용 메소드
    andThen
    compose

 * BiFunction<T, U, R>
 - 두 개의 값(T, U)를 받아서 R 타입을 리턴하는 함수 인터페이스
    R apply(T t, U u)

 * Consumer<T>
 - T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
    void Accept(T t)
 - 함수 조합용 메소드
    andThen
 *
 * Supplier<T>
 - T 타입의 값을 제공하는 함수 인터페이스
    T get()
 *
 * Predicate<T>
 - T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
    boolean test(T t)
 - 함수 조합용 메소드
    And
    Or
    Negate

 * UnaryOperator<T>
 - Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스
 *
 * BinaryOperator<T>
 - BiFunction<T, U, R>의 특수한 형태로, 동일한 타입의 입렵값 두개를 받아 리턴하는 함수 인터페이스
 * */


public class Lambda02 {
    public static void main(String[] args) {
        int testNum = 20;

        Plus10 plus10 = new Plus10();
        System.out.println(" ============================================================= ");
        System.out.println("plus10 = " + plus10.apply(1));

        //람다를 사용하는 방법 01
        Function<Integer,Integer> plus10Lambda = (i) -> {
          return i+20;
        };

        System.out.println(" ============================================================= ");
        System.out.println("plus10Lambda = " + plus10Lambda.apply(20));

        //람다를 사용하는 방법 02
        Function<Integer,Integer> plus10Lambda02 = (i) -> i+20;
        System.out.println(" ============================================================= ");
        System.out.println("plus10Lambda02.apply(20) = " + plus10Lambda02.apply(20));
        
        //함수 조합
        Function<Integer,Integer> multiply2 = (i)-> i*2;
        System.out.println(" ============================================================= ");
        System.out.println("multiply2.apply(2) = " + multiply2.apply(2));

        //compose : 뒤에 오는 함수를 작용(multiply2) 한 후 이 값을 가지고
        //plus10의 입력값으로 사용한다.
        Function<Integer,Integer> multiply2Plus10 = plus10.compose(multiply2);
        System.out.println(" ============================================================= ");
        System.out.println("multiply2Plus10.apply(10) = " + multiply2Plus10.apply(3));
        System.out.println("plus10 = " + plus10.andThen(multiply2).apply(3));

        //comsumer
        System.out.println(" ============================================================= ");
        Consumer<Integer> printT = (i)-> System.out.println("i = " + i);
        printT.accept(30);

        //supplier
        Supplier<Integer> get10 = () ->10;
        System.out.println(" ============================================================= ");
        System.out.println("get10.get() = " + get10.get());

        //predicate
        Predicate<String> startWithJk = (s) -> s.startsWith("jk");
        System.out.println(" ============================================================= ");
        System.out.println("startWithJk.test(\"jk\") = " + startWithJk.test("jk"));


    }
}
