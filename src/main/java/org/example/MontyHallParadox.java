package org.example;

/*
В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла (Парадокс Монти Холла — Википедия ) и наглядно убедиться в верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).
Необходимо:
Создать свой Java Maven или Gradle проект;
Самостоятельно реализовать прикладную задачу;
Сохранить результат в HashMap<шаг теста, результат>
Вывести на экран статистику по победам и поражениям
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {
    public static void main(String[] args) {
        Map<Integer, Boolean> results = new HashMap<>();
        Random random = new Random();

        int wins = 0;
        int losses = 0;

        for (int i = 1; i <= 1000; i++) {
            int carPosition = random.nextInt(3);
            int playerChoice = random.nextInt(3);

            int revealedDoor;
            do {
                revealedDoor = random.nextInt(3);
            } while (revealedDoor == carPosition || revealedDoor == playerChoice);

            int finalChoice;
            do {
                finalChoice = random.nextInt(3);
            } while (finalChoice == playerChoice || finalChoice == revealedDoor);

            if (finalChoice == carPosition) {
                wins++;
                results.put(i, true);
            } else {
                losses++;
                results.put(i, false);
            }
        }

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Results: " + results);
    }
}

