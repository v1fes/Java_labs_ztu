package com.education.ztu;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        Game game = new Game("Any", 11);

        String filePath = "game.ser";

        // Серіалізація
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(game);
            System.out.println("Об'єкт серіалізовано: " + game);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десеріалізація
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Game deserializedGame = (Game) ois.readObject();
            System.out.println("Об'єкт десеріалізовано: " + deserializedGame);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
