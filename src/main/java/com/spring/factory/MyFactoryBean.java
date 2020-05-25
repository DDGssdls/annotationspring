package com.spring.factory;

import com.spring.entites.Color;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Color> {
    // 创建实例
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }
    // 返回的是bean的class
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
    // 要是返回的是true表示的是单例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
