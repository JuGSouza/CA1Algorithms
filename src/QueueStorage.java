public class QueueStorage {
    private FoodItem[] queue;
    private int front, rear, size, capacity;

    public QueueStorage(int size) {
        this.capacity = capacity;
        this.queue = new FoodItem[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(FoodItem item) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) %capacity;
            queue[rear] = item;
        }
            size++;
            System.out.println(item.getName() + " added to the queue.");
        
    }

    public FoodItem dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        } 
            FoodItem item = queue[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) %capacity;
            }
            size--;
        return null;
    }

    public FoodItem peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        } else {
            return queue [front];
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue contents: ");
           int count = 0;
           int i = front;
            
            while (count < size) {
            queue[i].display();
            i = (i + i) %capacity;
            count++;
            }
        }
    }

   public void search (String name) {
        if (isEmpty()) {
            System.out.println ("Queue is empty.");
            return;
        }
        boolean found = false;
        int count = 0;
        int i = front;

        while (count < size) {
            if (queue [i].getName().equalsIgnoreCase(name)) {
                System.out.println ("Food item found: " + queue[i]);
                found = true;
            }
            i = (i + i) %capacity;
            count++;
        }
        if (!found) {
            System.out.println ("Food item not found.");
        }
   }
}