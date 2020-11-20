package com.ximi.conversion.domain;

import java.math.BigDecimal;

/**
 * Money
 *
 * @author Ximi
 * @since 2020/11/19
 */
public class Money {

    /**
     * 币种
     */
    private String currency;

    /**
     * 金额
     */
    private BigDecimal amount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Money{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}
