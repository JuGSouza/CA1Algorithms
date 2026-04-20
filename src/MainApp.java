package com.mycompany.datastructures;

import java.util.Scanner;

public class MainApp {

    public static void stackMenu(Scanner sc) {
        System.out.print("Enter stack size: ");
        int size = sc.nextInt();
        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    int popped = stack.pop();
                    if (popped != -1) {
                        System.out.println("Popped: " + popped);
                    }
                    break;
                case 3:
                    int top = stack.peek();
                    if (top != -1) {
                        System.out.println("Top element: " + top);
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    public static void queueMenu(Scanner sc) {
        System.out.print("Enter queue size: ");
        int size = sc.nextInt();
        sc.nextLine();

        Queue q = new Queue(size);

        while (true) {
            System.out.println("\n--- Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display Queue");
            System.out.println("5. Size");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item to enqueue: ");
                    String item = sc.nextLine();
                    q.enqueue(item);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.peek();
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    q.size();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Use Stack");
            System.out.println("2. Use Queue");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    stackMenu(sc);
                    break;
                case 2:
                    queueMenu(sc);
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}