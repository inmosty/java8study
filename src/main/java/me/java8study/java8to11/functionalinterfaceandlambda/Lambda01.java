package me.java8study.java8to11.functionalinterfaceandlambda;
/**
 * 함수형 인터페이스(Funtional Interface)
 - 추상 메소드를 딱 하나만 가지고 있는 인터페이스
 - SAM(Single Abstract Method) 인터페이스
 - @FunctionalInterface 애노테이션을 가지고 있는 인터페이스

 람다 표현식(Lambda Expressions)
 - 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
 - 코드를 줄일 수 있다.
 - 메소드 매개변수, 리턴타입, 변수로 만들어 사용할 수 있다.

 자바에서 함수형 프로그래밍
 - 함수를 First class object로 사용할 수 있다.
 - 순수함수(Pure function)
    사이드 이펙트를 만들 수 없다.(함수 밖에 있는 값을 변경하지 못한다.)
    상태가 없다.(함수 밖에 정의되어있는)
 - 고차 함수(High-Order Fucntion)
    함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수도 있다.
 - 불변성
 * */


public class Lambda01 {
    public static void main(String[] args) {
        int testNum = 20;

        // 기존에 사용하는 방법
        RunSomething runSomething = new RunSomething() {
            @Override
            public int doIt(int number) {
                // testNum ++ ; 사이드 이펙트를 만들 수 없다.(함수 밖에 있는 값을 변경하지 못한다.)
                return number + 10;
            }
        };

        System.out.println("runSomething = " + runSomething.doIt(10));

        //람다 사용시
        RunSomething runSomethingLambda = (number) -> {
            // testNum ++ ; 사이드 이펙트를 만들 수 없다.(함수 밖에 있는 값을 변경하지 못한다.)
           return number +20 +testNum;
        } ;
        System.out.println("runSomethingLambda = " + runSomethingLambda.doIt(10));

    }
}
