package com.kms.example1;

public class ClassB extends ClassA {

    ClassB() {
        super();
        System.out.print('D');
    }

    void prn() {
        System.out.print('E');
    }

    void prn(int x) {
        System.out.print(x);
    }
}
