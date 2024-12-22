package com.education.ztu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> {
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println("To the team " + name + " was added participant " + participant.getName());
    }

    public void playWith(Team<T> otherTeam) {
        Random random = new Random();
        String winner = random.nextBoolean() ? this.name : otherTeam.name;
        System.out.println("The team " + winner + " is the winner!");
    }

    public Team<T> deepClone() {
        Team<T> clonedTeam = new Team<>(this.name);
        for (T participant : this.participants) {
            clonedTeam.addNewParticipant((T) participant.clone());
        }
        return clonedTeam;
    }

    @Override
    public String toString() {
        return "Team{name='" + name + "', participants=" + participants + "}";
    }
}