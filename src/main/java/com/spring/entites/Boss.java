package com.spring.entites;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Boss {
    @Autowired
    private Car car;

    //@Autowired
    public Boss(Car car) {
        this.car = car;
    }

    public Boss() {
    }

    public Car getCar() {
        return car;
    }

    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
