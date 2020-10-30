package com.ximi.bean.lifecycle.domain;

public class CircularConstructorB {

    private CircularConstructorA circularConstructorA;

    public CircularConstructorB(CircularConstructorA circularConstructorA) {
        this.circularConstructorA = circularConstructorA;
    }
}
