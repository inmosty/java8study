package me.java8study.java8to11.interfacehistory;

public interface Foo {

    void printName();

    /**
     * @impSpec
     * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    //A default method cannot override a method from java.lang.Object
//	default String toString() {
//
//	}



    String getName();
}