package com.company;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Set;
import java.util.HashSet;

public class Main {

    static String name; //was ist ein hartcodierter Name?
    static String geschlecht;
    static int alter;
    static int maxalter = 100;
    static int hunger = 50;
    static int energie = 50;
    static int laune;
    static String status;
    static Set<Integer> ZugelasseneEingabe = new HashSet<Integer>();



    

    public static void main(String[] args) {

        ZugelasseneEingabe.add(1);
        ZugelasseneEingabe.add(2);
        ZugelasseneEingabe.add(3);
        ZugelasseneEingabe.add(4);

        System.out.println("Bitte gib deinem Javagotchi einen Namen:");
        Scanner Nameeingabe = new Scanner(System.in);
        name = Nameeingabe.next();

        int a = (int) (Math.random() * 2); //zufälliger Wert (0 oder 1), der bestimmt, ob weiblich oder männlich
        if (a == 1) {
            geschlecht = "weiblich";

        } else {
            geschlecht = "männlich";
        }
        System.out.println("Dein Javagotchi ist " + geschlecht);

        laune = (int) (Math.random() * 101); //zufälliger Wert zwischen 0 und 100

        Statuseinstellung();

        while (status != "DEAD") {


            int hungererhöhung = (int) (Math.random() * 6) + 1; //zufälliger Wert zwischen 1 und 6, um den der Hunger erhöht wird
            if ((hunger + hungererhöhung) <= 100) {
                hunger = hunger + hungererhöhung;
            } else {
                hunger = 100;
            } //Maximum von 100 erreicht

            int energiereduktion = (int) (Math.random() * 6) + 1; //zufälliger Wert zwischen 1 und 6, um den die Energie reduziert wird
            if ((energie - energiereduktion) >= 0) {
                energie = energie - energiereduktion;
            } else {
                energie = 0;
            } //Damit nicht unter 0 fallen kann

            int launeänderung = (int) (Math.random() * 6) - 3; //zufälliger Wert zwischen -3 und 2 um den die Laune verändert wird
            if ((laune + launeänderung) <= 100) {
                laune = laune + launeänderung;
            } else {
                laune = 100;
            }

            double wahrscheinlichkeit = (double) Math.random();
            if (wahrscheinlichkeit <= 0.05) {
                status = "DEAD";
                System.out.println(name + " ist gestorben :(");
                break;
            }

            Statuseinstellung();

            System.out.println("Status = " + status);
            System.out.println("Hunger = " + hunger);
            System.out.println("Energie = " + energie);
            System.out.println("Laune = " + laune);
            System.out.println("Alter = " + alter);


            System.out.println("Bitte gib eine Zahl (1,2,3,4) ein, mit der folgende Aktionen durchgeführt werden können:");
            System.out.println("1: Füttern: Hunger -10, Energie -5; Laune +10");
            System.out.println("2: Schlafen: Hunger +2, Energie +10; Laune +5");
            System.out.println("3: Spielen: Hunger +5, Energie -3; Laune +20");
            System.out.println("4: Sport: Hunger +10, Energie -10; Laune +10, maximales Alter +50");
            Scanner eingabe = new Scanner(System.in);
            int e = eingabe.nextInt();

            if (ZugelasseneEingabe.contains(e)) {

                if (e == 1) {
                    if (hunger >= 10) { //damit der Hungerwert nicht unter 0 fallen kann
                        hunger -= 10;
                    } else {
                        hunger = 0;
                    }

                    if (energie >= 5) {
                        energie -= 5;
                    } else {
                        energie = 0;
                    }

                    if (laune <= 90) { //Damit der Launewert nicht über 100 steigen kann
                        laune += 10;
                    } else {
                        laune = 100;
                    }
                }

                if (e == 2) {

                    if (hunger <= 98) {
                        hunger += 2;
                    } else {
                        hunger = 100;
                    }

                    if (energie <= 90) {
                        energie += 10;
                    } else {
                        energie = 100;
                    }

                    if (laune <= 95) {
                        laune += 5;
                    } else {
                        laune = 100;
                    }
                }
                if (e == 3) {

                    if (hunger <= 95) {
                        hunger += 5;
                    } else {
                        hunger = 100;
                    }

                    if (energie >= 3) {
                        energie -= 3;
                    } else {
                        energie = 0;
                    }

                    if (laune <= 80) {
                        laune += 20;
                    } else {
                        laune = 100;
                    }
                }
                if (e == 4) {

                    if (hunger <= 90) {
                        hunger += 10;
                    } else {
                        hunger = 100;
                    }

                    if (energie >= 10) {
                        energie -= 10;
                    } else {
                        energie = 0;
                    }

                    if (laune >= 10) {
                        laune -= 10;
                    } else {
                        laune = 0;
                    }

                    maxalter += 50;
                }

                alter = alter + 5;
            } else { //es wurde etwas anderes als 1,2,3 oder 4 eingegeben
                System.out.println("Unzulässige Eingabe.");
            }

        }
    }

    public static void Statuseinstellung (){

        if (hunger > 99 || energie < 1 || alter > 600) {
            status = "DEAD";
        }

        if((hunger<51) && (energie>50) && (laune>50)){
                status = "HAPPY";
                System.out.println("Dein Javagotchi ist happy.");
            }
        else {
                System.out.println("Dein Javagotchi ist nicht happy.");
                status = "UNHAPPY";
                }
            }

    }

