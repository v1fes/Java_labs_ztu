package com.education.ztu;
import java.lang.reflect.*;
public class ReflectionExample {
    public static void main(String[] args) {
        try {
            //три способи
            Class<?> customClass1 = CustomClass.class;
            Class<?> customClass2 = Class.forName("com.education.ztu.CustomClass");
            CustomClass instance = new CustomClass("Example");
            Class<?> customClass3 = instance.getClass();

            System.out.println("Об'єкти Class отримані трьома способами:");
            System.out.println(customClass1);
            System.out.println(customClass2);
            System.out.println(customClass3);

            System.out.println("\nПоля:");
            Field[] fields = customClass1.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("Назва: " + field.getName() + ", Тип: " + field.getType().getSimpleName());
            }

            System.out.println("\nМетоди:");
            Method[] methods = customClass1.getDeclaredMethods();
            for (Method method : methods) {
                System.out.print("Назва: " + method.getName() + ", Типи параметрів: ");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> paramType : parameterTypes) {
                    System.out.print(paramType.getSimpleName() + " ");
                }
                System.out.println(", Повертає: " + method.getReturnType().getSimpleName());
            }

            System.out.println("\nКонструктори:");
            Constructor<?>[] constructors = customClass1.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.print("Назва: " + constructor.getName() + ", Типи параметрів: ");
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                for (Class<?> paramType : parameterTypes) {
                    System.out.print(paramType.getSimpleName() + " ");
                }
                System.out.println();
            }

            Constructor<?> constructor = customClass1.getDeclaredConstructor(String.class);
            Object customInstance = constructor.newInstance("New Instance");
            System.out.println("\nСтворено екземпляр класу: " + customInstance);

            Method method = customClass1.getDeclaredMethod("publicMethod", String.class);
            method.invoke(customInstance, "Hello from Reflection!");

            Field privateField = customClass1.getDeclaredField("privateField");
            privateField.setAccessible(true);
            privateField.set(customInstance, "Modified Private Field");
            System.out.println("\nПриватне поле (нове значення): " + privateField.get(customInstance));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
