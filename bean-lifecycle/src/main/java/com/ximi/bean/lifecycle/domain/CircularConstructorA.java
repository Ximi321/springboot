package com.ximi.bean.lifecycle.domain;

public class CircularConstructorA {

    private CircularConstructorB circularConstructorB;

    public CircularConstructorA(CircularConstructorB circularConstructorB) {
        this.circularConstructorB = circularConstructorB;
    }
}
