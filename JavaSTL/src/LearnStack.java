import java.util.Stack;

public class LearnStack {
    public static void main(String[] args) {

        Stack<String> animals = new Stack<>();  //Last in first out method
        animals.push("Lion");
        animals.push("Tiger");
        animals.push("Dog");
        animals.push("Horse");

        System.out.println(animals);
        System.out.println(animals.peek()); //The element which we see on the top.
        animals.pop(); // pops the last element as it goes first out.
        System.out.println(animals);
        System.out.println(animals.peek()); //The element which we see on the top
    }
}
