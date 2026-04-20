package com.mycompany.datastructures;

public class Queue {
    private String[] queue;
    private int front, rear, size;

    public Queue(int size) {
        this.size = size;
        this.queue = new String[size];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void enqueue(String item) {
        if (isFull()) {
            System.out.println("Queue is full!");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            queue[rear] = item;
            System.out.println(item + " added to the queue.");
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            String item = queue[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front++;
            }
            System.out.println(item + " removed from the queue.");
        }
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Front of the queue: " + queue[front]);
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue contents: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public void size() {
        if (isEmpty()) {
            System.out.println("Queue size: 0");
        } else {
            System.out.println("Queue size: " + (rear - front + 1));
        }
    }
}