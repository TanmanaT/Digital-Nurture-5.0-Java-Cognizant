public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo_of_dog.png");
        Image image2 = new ProxyImage("scenic_mountain.jpg");

        // Image 1 will be loaded from remote server (first display)
        System.out.println("--- Displaying Image 1 for the first time (should trigger load) ---");
        long startTime = System.currentTimeMillis();
        image1.display();
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + "ms");

        System.out.println("\n--- Displaying Image 1 for the second time (should NOT trigger load) ---");
        startTime = System.currentTimeMillis();
        image1.display();
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + "ms");

        System.out.println("\n--- Displaying Image 2 for the first time (should trigger load) ---");
        startTime = System.currentTimeMillis();
        image2.display();
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
