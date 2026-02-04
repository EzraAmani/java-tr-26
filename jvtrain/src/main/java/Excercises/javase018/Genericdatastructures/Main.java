package Excercises.javase018.Genericdatastructures;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing with String ===");
        testString();

        System.out.println("\n=== Testing with Integer ===");
        testInteger();

        System.out.println("\n=== Testing with Custom Objects ===");
        testCustomObjects();
    }

    private static void testString() {
        // Test Stack with String
        Stack<String> stringStack = new Stack<>();
        stringStack.push("First");
        stringStack.push("Second");
        stringStack.push("Third");

        System.out.println("Stack peek: " + stringStack.peek());
        System.out.println("Stack pop: " + stringStack.pop());
        System.out.println("Stack size: " + stringStack.size());

        // Test Queue with String
        Queue<String> stringQueue = new Queue<>();
        stringQueue.enqueue("First");
        stringQueue.enqueue("Second");
        stringQueue.enqueue("Third");

        System.out.println("Queue peek: " + stringQueue.peek());
        System.out.println("Queue dequeue: " + stringQueue.dequeue());
        System.out.println("Queue size: " + stringQueue.size());

        // Test Tree with String
        TreeNode<String> stringTree = new TreeNode<>("Root");
        stringTree.left = new TreeNode<>("Left");
        stringTree.right = new TreeNode<>("Right");

        System.out.print("Tree in-order: ");
        stringTree.inOrderTraversal();
        System.out.println();
    }

    private static void testInteger() {
        // Test Stack with Integer
        Stack<Integer> intStack = new Stack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        System.out.println("Stack peek: " + intStack.peek());
        System.out.println("Stack pop: " + intStack.pop());
        System.out.println("Stack size: " + intStack.size());

        // Test Queue with Integer
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(10);
        intQueue.enqueue(20);
        intQueue.enqueue(30);

        System.out.println("Queue peek: " + intQueue.peek());
        System.out.println("Queue dequeue: " + intQueue.dequeue());
        System.out.println("Queue size: " + intQueue.size());

        // Test Tree with Integer
        TreeNode<Integer> intTree = new TreeNode<>(50);
        intTree.left = new TreeNode<>(25);
        intTree.right = new TreeNode<>(75);

        System.out.print("Tree in-order: ");
        intTree.inOrderTraversal();
        System.out.println();
    }

    private static void testCustomObjects() {
        // Test Stack with Person
        Stack<Person> personStack = new Stack<>();
        personStack.push(new Person("Alice", 25));
        personStack.push(new Person("Bob", 30));
        personStack.push(new Person("Charlie", 35));

        System.out.println("Stack peek: " + personStack.peek());
        System.out.println("Stack pop: " + personStack.pop());
        System.out.println("Stack size: " + personStack.size());

        // Test Queue with Person
        Queue<Person> personQueue = new Queue<>();
        personQueue.enqueue(new Person("Alice", 25));
        personQueue.enqueue(new Person("Bob", 30));
        personQueue.enqueue(new Person("Charlie", 35));

        System.out.println("Queue peek: " + personQueue.peek());
        System.out.println("Queue dequeue: " + personQueue.dequeue());
        System.out.println("Queue size: " + personQueue.size());

        // Test Tree with Person
        TreeNode<Person> personTree = new TreeNode<>(new Person("Root", 40));
        personTree.left = new TreeNode<>(new Person("Left", 20));
        personTree.right = new TreeNode<>(new Person("Right", 60));

        System.out.print("Tree in-order: ");
        personTree.inOrderTraversal();
        System.out.println();
    }
}