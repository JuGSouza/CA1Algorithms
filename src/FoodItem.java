// Public class is a class where others class can access. Like Main class can access FoodItem class because it is public.
// Private is exclusive atrributes to that specific public class where it is inserted.
// Example: a house = project. rooms inside the house = public classes. bed/pillow = private attributes of public class 'bedroom'.
// oven/fridge = private attributes of public class 'kitchen'.

public class FoodItem {
    // attributes to keep/save the name, weight, bbe and time when the user input the item.
    // string is to be read/saved as a text.
    private String name;
    private double weight;
    private String bestBeforeDate;
    private String timePlaced;

    public FoodItem(String name, double weight, String bestBeforeDate, String timePlaced) {
        // it receives the values and store in each attribute.
        this.name = name;
        this.weight = weight;
        this.bestBeforeDate = bestBeforeDate;
        this.timePlaced = timePlaced;
    }

    // Get is a method that access private variables and shows a copy of the value to other classes read it. 
        // Example: When the public class 'Main' requires the name variable, getName will return a copy of the value.
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getBestBeforeDate() {
        return bestBeforeDate;
    }

    public String getTimePlaced() {
        return timePlaced;
    }

    // it is showing how each value will be displayed. As a string, it will be printed out name: + value stored in attribute 'name'
    public void display() {
    System.out.println("Name: " + name);
    System.out.println("Weight: " + weight);
    System.out.println("Best Before: " + bestBeforeDate);
    System.out.println("Time Placed: " + timePlaced);
}
}