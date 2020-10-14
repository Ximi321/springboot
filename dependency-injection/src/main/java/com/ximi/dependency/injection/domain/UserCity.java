package com.ximi.dependency.injection.domain;

import java.util.Arrays;
import java.util.List;

/**
 * 用户城市
 *
 * @author Ximi
 * @since 2020/10/14
 */
public class UserCity {

    private City city;

    private City[] lifeCity;

    private List<City> workCity;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City[] getLifeCity() {
        return lifeCity;
    }

    public void setLifeCity(City[] lifeCity) {
        this.lifeCity = lifeCity;
    }

    public List<City> getWorkCity() {
        return workCity;
    }

    public void setWorkCity(List<City> workCity) {
        this.workCity = workCity;
    }

    @Override
    public String toString() {
        return "UserCity{" +
                "city=" + city +
                ", lifeCity=" + Arrays.toString(lifeCity) +
                ", workCity=" + workCity +
                '}';
    }
}
