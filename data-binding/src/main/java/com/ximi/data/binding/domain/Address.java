package com.ximi.data.binding.domain;

/**
 * 地址
 *
 * @author Ximi
 * @since 2020/11/18
 */
public class Address {

    private String stress;

    public String getStress() {
        return stress;
    }

    public void setStress(String stress) {
        this.stress = stress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "stress='" + stress + '\'' +
                '}';
    }
}
