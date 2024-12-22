package com.education.ztu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {
    private static final Logger logger = LoggerFactory.getLogger(Game.class);

    private String name;
    private int players;

    public Game(String name, int players) {
        this.name = name;
        this.players = players;
        logger.info("Створено гру: {}, гравців: {}", name, players);
    }

    public void start() {
        logger.info("Гра {} почалася", name);
    }

    public void end() {
        logger.warn("Гра {} завершилася", name);
    }

    public void errorOccurred() {
        logger.error("Сталася помилка у грі {}", name);
    }
}
