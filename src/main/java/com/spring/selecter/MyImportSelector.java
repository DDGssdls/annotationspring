package com.spring.selecter;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 这个方法不要反悔的是null 而是反悔一个空数组 只需要返回 全限定类名就行
        return new String[]{"com.spring.entites.Color"};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
