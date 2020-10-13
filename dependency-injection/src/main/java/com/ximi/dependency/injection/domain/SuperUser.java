package com.ximi.dependency.injection.domain;

/**
 * 超级用户
 *
 * @author Ximi
 * @since 2020/10/13
 */
public class SuperUser extends User {

    private Integer vipLevel;

    public Integer getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(Integer vipLevel) {
        this.vipLevel = vipLevel;
    }
}
