package com.education.ztu;

interface Human {
    void sayFullName();
    void sayAge();
    void sayLocation();
    void sayGender();
    default void whoIAm() {
        System.out.println("I am a human");
    }
}

