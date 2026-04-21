// using the same analogy/example, this is one more room of the house it is possible to access 'public class'
// This class is used to create the stack storage for food items 
public class StackStorage {
    
    //private means that array and int can only be used inside the public class 'stackstorage'
    //array can keep/storage many elements. so, it is saying that stackstorage will storage many elements/items coming from FoodItem
    private FoodItem[] arr;
    // int (integer) means the input is numbers, not text.
    private int top;
    private int capacity;

    public StackStorage(int size) {
        // it controls the limit. the capacity is equal size and the size of the array is defined in public class 'Main'
        // one more example of why the classes are public. they need to be seen for each other
        arr = new FoodItem[size];
        capacity = size;
        // it says the stack starts empty. if 0 = first item, -1 means empty.
        top = -1;
    }

    // Methods used to add, remove, peek, show,and search food item into stackstorage
    public void push(FoodItem item) {
        // capacity and index are different. for example if the capacity is 5. index is 4.
        //so, if top is equal capacity-1 it means every spaces are written.
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        // otherwise add one more item to top
        arr[++top] = item;
        System.out.println(item.getName() + " pushed to stack.");
    }

    public FoodItem pop() {
        // if top is equal 0 it means there is one element written. so. if to equals -1 means empty
        if (top == -1) {
            System.out.println("Stack Underflow");
            return null;
        }
        //otherwise, removes 1 from the top
        return arr[top--];
    }

    public FoodItem peek() {
        //same idea
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        }
        //otherwise, returns the element on top
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        
         // i means the size/capacity. if i more or equal 0 it means there
        // is/are elements. so, displayed each food (arr[i] item storage since the top to the first one added.
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            arr[i].display();
        }
    }
    
    public void search(String name) {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        // otherwise, check from 0 (first element) to the last inserted (top), if name input by the user is the same
        //name as the item, it will show it
        boolean found = false;
        for (int i = 0; i <= top; i++) {
            if (arr[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Food item found: " + arr[i]);
                found = true;
            }
        }
        // if not found, display this message
        if (!found) {
            System.out.println("Food item not found.");
        }
    }
}