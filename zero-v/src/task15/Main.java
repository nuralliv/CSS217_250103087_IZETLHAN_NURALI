package task15;

public class Main {
    public static void main(String[] args) {
        StackAdapter stack = new StackAdapter(new LegacyArrayStack());
        System.out.println("Empty? " + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Empty? " + stack.isEmpty());
    }
}
