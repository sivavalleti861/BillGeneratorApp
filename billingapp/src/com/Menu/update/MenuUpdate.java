package com.Menu.update;
import com.Service.ItemService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuUpdate {

    public static void main(String[] args) {
        ItemService itemService = new ItemService();

        // Show Menu from Database
        itemService.showMenu();

        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> order = new HashMap<>();

        while (true) {
            System.out.print("Enter Item ID to order (0 to finish): ");
            int itemId = scanner.nextInt();

            if (itemId == 0) {
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            order.put(itemId, quantity);
        }

        System.out.println("Order Summary:");
        System.out.println("Item ID\tQuantity");

        double totalAmount = 0;

        for (Map.Entry<Integer, Integer> entry : order.entrySet()) {
            int itemId = entry.getKey();
            int quantity = entry.getValue();
            double itemPrice = itemService.getItemPrice(itemId);
            double itemTotal = itemPrice * quantity;
            totalAmount += itemTotal;

            System.out.println(itemId + "\t" + quantity);
        }

        System.out.println("Total Amount: $" + totalAmount);

        scanner.close();
    }
}