package edu.fra.uas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Notenmain {

    public static void main(String[] args) {
        SpringApplication.run(Notenmain.class, args); // Spring Boot Initialisierung
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            List<Double> grades = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            String input;

            System.out.println("Geben Sie Ihre Noten ein (oder 'exit' zum Beenden):");

            // Noten einlesen
            while (true) {
                System.out.print("Note eingeben: ");
                input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                try {
                    double grade = Double.parseDouble(input);
                    grades.add(grade);
                } catch (NumberFormatException e) {
                    System.out.println("Ungültige Eingabe. Bitte eine Zahl eingeben.");
                }
            }

            scanner.close();

            // Durchschnitt berechnen und ausgeben
            if (!grades.isEmpty()) {
                double average = calculateAverage(grades);
                System.out.println("Der Notendurchschnitt ist: " + average);
            } else {
                System.out.println("Keine Noten eingegeben.");
            }
        };
    }

    // Methode zur Berechnung des Durchschnitts
    public static double calculateAverage(List<Double> grades) {
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
