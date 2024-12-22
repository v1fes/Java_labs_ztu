package com.education.ztu;

public class StringBuilderExample {
    public static void main(String[] args) {
        int a = 4;
        int b = 36;

        // Складання рядків за допомогою java.lang.StringBuilder.append()
        java.lang.StringBuilder addition = new java.lang.StringBuilder();
        addition.append(a).append(" + ").append(b).append(" = ").append(a + b);
        System.out.println("Addition: " + addition);

        java.lang.StringBuilder subtraction = new java.lang.StringBuilder();
        subtraction.append(a).append(" - ").append(b).append(" = ").append(a - b);
        System.out.println("Subtraction: " + subtraction);

        java.lang.StringBuilder multiplication = new java.lang.StringBuilder();
        multiplication.append(a).append(" * ").append(b).append(" = ").append(a * b);
        System.out.println("Multiplication: " + multiplication);

        // Замінити "=" на "рівно" за допомогою insert() і deleteCharAt()
        java.lang.StringBuilder replaceInsertDelete = new java.lang.StringBuilder(addition);
        replaceInsertDelete.deleteCharAt(replaceInsertDelete.indexOf("="));
        replaceInsertDelete.insert(replaceInsertDelete.indexOf(" "), " рівно");
        System.out.println("Insert/Delete Replace: " + replaceInsertDelete);

        // Замінити "=" на "рівно" за допомогою replace()
        java.lang.StringBuilder replaceMethod = new java.lang.StringBuilder(subtraction);
        replaceMethod.replace(replaceMethod.indexOf("="), replaceMethod.indexOf("=") + 1, " рівно");
        System.out.println("Replace Method: " + replaceMethod);

        // Змінити послідовність символів у рядку на протилежну
        java.lang.StringBuilder reverseString = new java.lang.StringBuilder(multiplication);
        reverseString.reverse();
        System.out.println("Reversed: " + reverseString);

        // Визначити довжину та capacity
        System.out.println("Length: " + addition.length());
        System.out.println("Capacity: " + addition.capacity());
    }
}
