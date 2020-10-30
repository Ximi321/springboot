package com.ximi.bean.lifecycle.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class CircularFieldA {

    @Autowired
    private CircularFieldB circularFieldB;

    public CircularFieldB getCircularFieldB() {
        return circularFieldB;
    }

    public void setCircularFieldB(CircularFieldB circularFieldB) {
        this.circularFieldB = circularFieldB;
    }
}
