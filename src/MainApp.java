import java.time.LocalDateTime;
import java.util.Scanner;

public class MainApp {

    public static FoodItem createFoodItem(Scanner sc) {
        sc.nextLine();
        
        System.out.print("Enter food name: ");
        String name = sc.nextLine();
        StackStorage stack = new StackStorage(10);
            
        if (!(name.equalsIgnoreCase("Burger") ||
              name.equalsIgnoreCase("Fries") ||
              name.equalsIgnoreCase("Sandwich") ||
              name.equalsIgnoreCase("Hotdog")
              )) {
            System.out.println("Invalid food. Choose:  burger, pizza, fries, sandwich hotdog");
            return null;
        }
        System.out.println("Enter food weight (g): ");
        double weight = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter BestBefore date: ");
        String bestBeforeDate = sc.nextLine();
        String timePlaced = LocalDateTime.now().toString();
        
        return new FoodItem(name, weight, bestBeforeDate, timePlaced);
    }
    
    public static void stackMenu(Scanner sc) {
        StackStorage stack = new StackStorage(10);
        while (true) {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("5. Search");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    FoodItem newItem = createFoodItem(sc);
                    if (newItem != null) {
                      stack.push(newItem);
                    }
                    break;
               
                case 2:
                    FoodItem removedStackItem = stack.pop();
                    if (removedStackItem != null) {
                        System.out.println("Removed " + removedStackItem);
                     }
                    break;
                    
                case 3:
                    FoodItem topItem = stack.peek();
                    if (topItem != null) {
                        System.out.println("Top item: " + topItem);
                    }
                    break;
                 
                case 4:
                    stack.display();
                    break;
                
                case 5:
                    sc.nextLine();
                    System.out.println("Enter food name to search: ");
                    String stackkSearchName = sc.nextLine();
                    stack.search(stackkSearchName);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    public static void queueMenu(Scanner sc) {
        QueueStorage queue = new QueueStorage(10);

        while (true) {
            System.out.println("\n--- Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display Queue");
            System.out.println("5. Search");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    FoodItem newItem = createFoodItem(sc);
                    if (newItem != null) {
                        queue.enqueue(newItem);
                    }
                    break;
                case 2:
                    FoodItem removedQueueItem = queue.dequeue();
                    if (removedQueueItem != null) {
                       System.out.println("Removed: " + removedQueueItem);
                    }
                    break;
                case 3:
                    FoodItem frontItem = queue.peek();
                    if (frontItem != null) {
                       System.out.println("Front item: " + frontItem);
                    }
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Enter food name to search: ");
                    String queueSearchName = sc.nextLine();
                    queue.search(queueSearchName);
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