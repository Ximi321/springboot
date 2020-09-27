package com.ximi.ioc.contain.overview.domain;

import com.ximi.ioc.contain.overview.annotation.Super;

/**
 * 超级用户
 *
 * @author Ximi
 * @since 2020/09/27
 */
@Super
public class SuperUser extends User{

    private Integer vipLevel;

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
                '}' + super.toString();
    }
}
