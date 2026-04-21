// using the same analogy/example, this is one more room of the house it is possible to access 'public class'
// This class is used to create the queue storage for food items 
 //array can keep/storage many elements. so, it is saying that stackstorage will storage many elements/items coming from FoodItem
  // int (integer) means the input is numbers, not text.
public class QueueStorage {
    private FoodItem[] queue;
    private int front, rear, size, capacity;

    public QueueStorage(int size) {
         // it controls the limit. the capacity of the array is defined in public class 'Main'
        this.capacity = capacity;
        this.queue = new FoodItem[capacity];
         //same idea. front rear and size starts empty. size is 0 and index is -1
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    // if empty the return is size =0 because there is no element inside. 
    public boolean isEmpty() {
        return size == 0;
    }

    //if full the return will be the size = capacity which means it is full. iff capacity is 10 and size return 10.
    //so size = capcity. ehich means full
    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(FoodItem item) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        } else {
            //showing where it needs to start. if front -1 it means empty so front will start in position 0.
            if (front == -1) {
                front = 0;
            }
        // every new element is insert in rear. so if the user insert one item, this will be the rear and
        // the front because is the first one inserted. when the user insert a second item. the first element
        // goes to front and the last item inserted is the rear.
            rear = (rear + 1) %capacity;
            queue[rear] = item;
        }
        // each element added, increase the size
            size++;
            System.out.println(item.getName() + " added to the queue.");
        
    }

    public FoodItem dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        } 
            FoodItem item = queue[front];
            
            // queue storage is like the queue in the bank. the last person arrived
        //will be the last in the queue. if the first person is called to enter
        //the bank, the second person becomes the first, the therd is now the second, and so on.
        // or if someone give up/remove, the person behind takes the position of the person that was in your front.
        // that 'if' 'else' is the code for that.
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) %capacity;
            }
              // each item removed, decreased the size
            size--;
        return null;
    }

    public FoodItem peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        } else {
            // using the same bank example, peek is when the cashier look over the counter and look to see who
        // is the next person to be called. front oof the queue.
            return queue [front];
        }
    }

    public void display() {
        if (isEmpty()) {
            // look the storage. if empty, shows message empty, if not, it will count from rear (size 0) to front (size i)
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue contents: ");
           int count = 0;
           int i = front;
            // it will keep counting while count is minor than size
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

          // the same idea of stack
        while (count < size) {
            if (queue [i].getName().equalsIgnoreCase(name)) {
                System.out.println ("Food item found: " + queue[i]);
                found = true;
            }
            i = (i + i) %capacity;
            
            //add one element
            count++;
        }
        if (!found) {
            System.out.println ("Food item not found.");
        }
   }
}