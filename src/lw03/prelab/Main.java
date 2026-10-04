package lw03.prelab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
    problem1();
    System.out.println();
    problem2();
    System.out.println();
    problem3();
    }
    
    static void problem1() {
        Scanner sg = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        List<String> playlist = new ArrayList<>();

        while (sg.hasNext()) {
            String type = sg.next(); 

            if (type.equals("ADD")) {
                String song = sg.nextLine().trim(); 
                playlist.add(song);

            } else if (type.equals("INSERT")) {
                int index = sg.nextInt();
                String song = sg.nextLine().trim();
                playlist.add(index, song);

            } else if (type.equals("REMOVE")) {
                String song = sg.nextLine().trim();
                playlist.remove(song);
            }
        }
        sg.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
    }

    static void problem2() {
        Scanner sg = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        Set<String> participants = new LinkedHashSet<>();
        int duplicates = 0;

        while (sg.hasNextLine()) {
            String name = sg.nextLine();

            if (participants.contains(name)) {
                duplicates++;
            } else {
                participants.add(name);
            }
        }
        sg.close();

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());
        int number = 1;
        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }
        System.out.println("Duplicate registrations: " + duplicates);
    }

    static void problem3() {
        Scanner sg = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        Map<String, Integer> stock = new LinkedHashMap<>();
        int failedSales = 0;

        while (sg.hasNext()) {
            String type = sg.next(); 
            String product = sg.next();
            int quantity = sg.nextInt();

            if (type.equals("ADD")) {
                if (stock.containsKey(product)) {
                    int oldStock = stock.get(product);
                    stock.put(product, oldStock + quantity);
                } else {
                    stock.put(product, quantity);
                }

            } else if (type.equals("SELL")) {
                if (stock.containsKey(product)) {
                    int oldStock = stock.get(product);
                    if (oldStock >= quantity) {
                        stock.put(product, oldStock - quantity);
                    } else {
                        failedSales++;
                    }
                } else {
                    failedSales++;
                }
            }
        }
        sg.close();

        System.out.println("===== Problem 3 =====");
        for (String product : stock.keySet()) {
            System.out.println(product + ": " + stock.get(product));
        }
        System.out.println("Failed sales: " + failedSales);
    }
}