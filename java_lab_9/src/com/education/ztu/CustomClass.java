package com.education.ztu;

class CustomClass {
    private String privateField;
    public String publicField;

    public CustomClass(String value) {
        this.privateField = value;
        this.publicField = "Public " + value;
    }

    public void publicMethod(String message) {
        System.out.println("Public Method Called with message: " + message);
    }

    private void privateMethod() {
        System.out.println("Private Method Called");
    }

    @Override
    public String toString() {
        return "CustomClass { privateField=\"" + privateField + "\", publicField=\"" + publicField + "\" }";
    }
}
