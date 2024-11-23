package com.education.ztu;

class Car {
    private String brand;
    private Engine engine;

    Car(String brand) {
        this.brand = brand;
        this.engine = new Engine();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Engine getEngine() {
        return engine;
    }

    class Engine {
        private boolean engineWorks;

        Engine() {
            this.engineWorks = false;
        }

        void startEngine() {
            engineWorks = true;
            System.out.println("Engine started.");
        }

        void stopEngine() {
            engineWorks = false;
            System.out.println("Engine stopped.");
        }

        boolean isEngineWorks() {
            return engineWorks;
        }
    }
}
