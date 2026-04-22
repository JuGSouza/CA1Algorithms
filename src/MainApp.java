// import current date and time 
// import scanner. it reads what the user type in the keyboard
import java.time.LocalDateTime;
import java.util.Scanner;

// Main class that shows the menu to user and connect the classes
// using the house example: the rooms are done. the house is built.
//the public class 'main' is not a room in this house. Main is more like the main circuit breaker.
public class MainApp {
    
//creates a new food item from the user input
    public static FoodItem createFoodItem(Scanner sc) {
        sc.nextLine();
        
        //shows the message and get the answer from the kwyboard
        // store/save in those attributes in FoodItem
        System.out.print("Enter food name: ");
        String name = sc.nextLine();
        StackStorage stack = new StackStorage(10);
            
        // do not except anything apart from those words/food
        if (!(name.equalsIgnoreCase("Burger") ||
              name.equalsIgnoreCase("Fries") ||
              name.equalsIgnoreCase("Sandwich") ||
              name.equalsIgnoreCase("Hotdog")
              )) {
            
             // if it is not one of those four item, it will show it
            System.out.println("Invalid food. Choose:  burger, pizza, fries, sandwich hotdog");
            return null;
        }
        
        // same thing
        System.out.println("Enter food weight (g): ");
        double weight = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter BestBefore date: ");
        String bestBeforeDate = sc.nextLine();
        
         // Gets the current date and time. put it in text because of (.tostring)
        String timePlaced = LocalDateTime.now().toString();
        
        return new FoodItem(name, weight, bestBeforeDate, timePlaced);
    }
    
    // display of stack menu
    public static void stackMenu(Scanner sc) {
        
        // user can input up to 10 item
        StackStorage stack = new StackStorage(10);
        
         //the options available to user choose
        while (true) {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("5. Search");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            // choice is to be read as a number
            int choice = sc.nextInt();

            // command to each case chosen
            switch (choice) {
                case 1:
                    // if push, collect the input text to store as a food
                    // if not null, add to stack.
                    FoodItem newItem = createFoodItem(sc);
                    if (newItem != null) {
                      stack.push(newItem);
                    }
                    break;
               
                case 2:
                    // if remove, pop the item from stack
                    // if not null, remove.
                    FoodItem removedStackItem = stack.pop();
                    if (removedStackItem != null) {
                        System.out.println("Removed " + removedStackItem);
                     }
                    break;
                    
                case 3:
                    // peek the top item. if not null, show the top item
                    FoodItem topItem = stack.peek();
                    if (topItem != null) {
                        System.out.println("Top item: " + topItem);
                    }
                    break;
                 
                case 4:
                    //if choose display, call the display method
                    stack.display();
                    break;
                
                case 5:
                     // input a name, it compares. if exist. call search methoda and shows.
                    sc.nextLine();
                    System.out.println("Enter food name to search: ");
                    String stackkSearchName = sc.nextLine();
                    stack.search(stackkSearchName);
                    break;
                case 6:
                      // exit
                    return;
                default:
                      //otherwise...
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    // same idea of menu but for queue menu.
    public static void queueMenu(Scanner sc) {
        // user can input up to 10 item
        QueueStorage queue = new QueueStorage(10);

        while (true) {
            System.out.println("\n--- Queue Menu ---");
            System.out.println("1. Add");
            System.out.println("2. Romeve");
            System.out.println("3. Peek");
            System.out.println("4. Display Queue");
            System.out.println("5. Search");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
             // choice is to be read as a number
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

    // the first menu displayed for the user
    // it can be stack menu or queue menu. it depends if the user wants to use FIFO or LIFO.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Use Stack");
            System.out.println("2. Use Queue");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            // if choose stack, it will open stack menu.
            // if choose queue, it eill open queue menu.
            // important part: stackmenu and queuemenu are already written (before this menu) because
            //the program has to have the instructions f how to operate/work. otherwise the program would not work
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