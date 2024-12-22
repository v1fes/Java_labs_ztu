package com.education.ztu;

import java.lang.annotation.*;
import java.lang.reflect.*;

// анотація(власна)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface CustomAnnotation {
    String description() default "Default description";
    int version() default 1;
}

// клас з анотацією
@CustomAnnotation(description = "Class-level annotation", version = 2)
public class CustomAnnotationExample {

    @CustomAnnotation(description = "Method-level annotation", version = 1)
    public void annotatedMethod() {
        System.out.println("Annotated method executed.");
    }

    public static void main(String[] args) {
        try {
            // отримуємо анотацію з класу
            Class<?> clazz = CustomAnnotationExample.class;
            if (clazz.isAnnotationPresent(CustomAnnotation.class)) {
                CustomAnnotation annotation = clazz.getAnnotation(CustomAnnotation.class);
                System.out.println("Class Annotation: description=" + annotation.description() + ", version=" + annotation.version());
            }

            // з методу
            Method method = clazz.getDeclaredMethod("annotatedMethod");
            if (method.isAnnotationPresent(CustomAnnotation.class)) {
                CustomAnnotation annotation = method.getAnnotation(CustomAnnotation.class);
                System.out.println("Method Annotation: description=" + annotation.description() + ", version=" + annotation.version());
            }

            // викликаємо анотований метод
            CustomAnnotationExample instance = new CustomAnnotationExample();
            method.invoke(instance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
