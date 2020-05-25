package com.spring.typefilter;

import com.spring.selecter.MyImportSelector;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类的注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前类的信息类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前类的 路径信息（也就是类的路径）
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("<------"+ className);

        if (className.contains("ers")){
            return true;
        }
        return false;
    }
}
