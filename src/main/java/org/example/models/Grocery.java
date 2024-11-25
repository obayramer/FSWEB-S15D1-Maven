package org.example.models;

import java.util.*;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n0: Çıkış");
            System.out.println("1: Ürün Ekle");
            System.out.println("2: Ürün Çıkar");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme

            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz: ");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;
                case 2:
                    System.out.print("Çıkarılmasını istediğiniz elemanları giriniz: ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
            printSorted();
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim().toLowerCase();
            if (!checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
                Collections.sort(groceryList);
            }
        }
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim().toLowerCase();
            if (checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
                Collections.sort(groceryList);
            }
        }
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.toLowerCase());
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("\nGüncel Liste:");
        for (String item : groceryList) {
            System.out.println("- " + item);
        }
    }
}
