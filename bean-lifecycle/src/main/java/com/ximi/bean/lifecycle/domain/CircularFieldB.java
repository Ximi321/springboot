package com.ximi.bean.lifecycle.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class CircularFieldB {

    @Autowired
    private CircularFieldA circularFieldA;

    public CircularFieldA getCircularFieldA() {
        return circularFieldA;
    }

    public void setCircularFieldA(CircularFieldA circularFieldA) {
        this.circularFieldA = circularFieldA;
    }
}
