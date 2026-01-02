package com.klu.store;

import com.klu.store.dao.ProductDAO;
import com.klu.store.entity.Product;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();
        int choice;

        do {
            System.out.println("\n=== PRODUCT MENU ===");
            System.out.println("1. Insert Product");
            System.out.println("2. View Product by ID");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. List All Products");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    if (price < 0 || qty < 0) {
                        System.out.println("Invalid values.");
                        break;
                    }

                    Product p = new Product(name, desc, price, qty);
                    dao.save(p);
                    System.out.println("Product saved.");
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();

                    Product prod = dao.getById(id);
                    if (prod != null)
                        System.out.println(prod);
                    else
                        System.out.println("Product not found.");
                    break;

                case 3:
                    System.out.print("Enter product ID: ");
                    int uid = sc.nextInt();

                    Product up = dao.getById(uid);
                    if (up == null) {
                        System.out.println("Product not found.");
                        break;
                    }

                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();

                    System.out.print("Enter new quantity: ");
                    int newQty = sc.nextInt();

                    up.setPrice(newPrice);
                    up.setQty(newQty);
                    dao.update(up);

                    System.out.println("Product updated.");
                    break;

                case 4:
                    System.out.print("Enter product ID: ");
                    int did = sc.nextInt();

                    Product del = dao.getById(did);
                    if (del != null) {
                        dao.delete(del);
                        System.out.println("Product deleted.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 5:
                    List<Product> list = dao.getAll();
                    if (list.isEmpty()) {
                        System.out.println("No products found.");
                    } else {
                        for (Product pr : list) {
                            System.out.println(pr);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}