package com.ximi.dependency.lookup.domain;

import com.ximi.dependency.lookup.annotation.Super;

/**
 * 超级用户
 *
 * @author Ximi
 * @since 2020/10/09
 */
@Super
public class SuperUser extends User {

    public Integer vipLevel;

    public Integer getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(Integer vipLevel) {
        this.vipLevel = vipLevel;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "vipLevel=" + vipLevel +
                "} " + super.toString();
    }
}
