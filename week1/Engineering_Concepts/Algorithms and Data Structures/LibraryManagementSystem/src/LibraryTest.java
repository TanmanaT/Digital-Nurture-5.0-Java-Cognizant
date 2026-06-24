import java.util.Arrays;
import java.util.Comparator;

public class LibraryTest {
    public static void main(String[] args) {
        Book[] books = {
            new Book("B003", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B005", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B001", "1984", "George Orwell"),
            new Book("B004", "Moby Dick", "Herman Melville"),
            new Book("B002", "Pride and Prejudice", "Jane Austen")
        };

        String targetTitle = "Moby Dick";

        System.out.println("=== 1. Linear Search (Unsorted Array) ===");
        System.out.println("Searching for: \"" + targetTitle + "\"");
        Book foundLinear = LibrarySearch.linearSearchByTitle(books, targetTitle);
        System.out.println("Found: " + foundLinear);

        System.out.println("\n=== 2. Sorting Books by Title for Binary Search ===");
        Arrays.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\n=== 3. Binary Search (Sorted Array) ===");
        System.out.println("Searching for: \"" + targetTitle + "\"");
        Book foundBinary = LibrarySearch.binarySearchByTitle(books, targetTitle);
        System.out.println("Found: " + foundBinary);

        System.out.println("\n=== 4. Test Missing Book ===");
        String missingTitle = "The Hobbit";
        System.out.println("Linear Search for \"" + missingTitle + "\": " + LibrarySearch.linearSearchByTitle(books, missingTitle));
        System.out.println("Binary Search for \"" + missingTitle + "\": " + LibrarySearch.binarySearchByTitle(books, missingTitle));
    }
}
