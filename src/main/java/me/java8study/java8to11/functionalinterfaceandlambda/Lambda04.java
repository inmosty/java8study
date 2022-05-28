package me.java8study.java8to11.functionalinterfaceandlambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

/**
 * 메소드 레퍼런스
 * 람다가 하는 일이 기존 메소드 또는 생성자를 호출하는 거라면, 메소드 레퍼런스를 사용해서 매우 간결하게 표현할 수 있다.
 *
 * 메소드 참조하는 방법
 - 스태틱 메소드 참조 -> 타입::스태틱 메소스
 - 특정 객체의 인스턴스 메소스 참조 -> 객체 레퍼런스::인스턴스 메소드
 - 임의 객체의 인스턴스 메소스 참조 -> 타입::인스턴스 메소드
 - 생성자 참조 -> 타입::new
 *
 * 메소드 또는 생성자의 매개변수로 람다의 입력값을 받는다.
 * 리턴값 또는 생성한 객체는 람다의 리턴값이다.
 *
 * https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
 * */


public class Lambda04 {
    public static void main(String[] args) {
        //Greeting의 함수를 사용
        UnaryOperator<String> hi = (s) -> "hi "+s;
        UnaryOperator<String> hi2 = Greeting::hi;
        System.out.println("hi = " + hi.apply("jk"));
        System.out.println("hi2.apply(\"\") = " + hi2.apply("하이2"));


        Greeting greeting = new Greeting();

        //hello 참조
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(" ============================================================= ");
        System.out.println("hello.apply(\"\") = " + hello.apply("캬캬캬캬"));
        
        //파라미터 있는 생성자
        Function<String,Greeting> jkGreeting = Greeting::new;
        Greeting jk = jkGreeting.apply("jkjk");
        System.out.println("jk.getName() = " + jk.getName());

        //파라미터 없는 생성자 참조
        Supplier<Greeting> newGreeting = Greeting::new;

        //임의 객체의 인스턴스 메소드 참조(불특정 다수)
        String[] names = {"jk","ea","sa"};

        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //여기서 두개의 값을 비교하여 return
                return 0;
            }
        });

        Arrays.sort(names,String::compareToIgnoreCase);
        System.out.println(" ============================================================= ");
        System.out.println(Arrays.toString(names));

    }
}
