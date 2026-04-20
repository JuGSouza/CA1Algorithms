public class StackStorage {
    private FoodItem[] arr;
    private int top;
    private int capacity;

    public StackStorage(int size) {
        arr = new FoodItem[size];
        capacity = size;
        top = -1;
    }

    public void push(FoodItem item) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = item;
        System.out.println(item.getName() + " pushed to stack.");
    }

    public FoodItem pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return null;
        }
        return arr[top--];
    }

    public FoodItem peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        }
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
        for (int i = 0; i <= top; i++) {
            if (arr[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Food item found: " + arr[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Food item not found.");
        }
    }
}