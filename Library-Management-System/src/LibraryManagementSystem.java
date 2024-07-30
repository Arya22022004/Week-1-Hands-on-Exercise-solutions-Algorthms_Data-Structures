/*
Search Algorithms:
1. Linear Search: A linear search algorithm iterates through the entire list of elements, checking each element until it finds the desired element
   or reaches the end of the list. Time complexity: O(n), where n is the number of elements in the list.
2. Binary Search: A binary search algorithm works by dividing the list of elements in half and repeatedly searching for the desired element in one 
   of the two halves until it is found. Time complexity: O(log n), where n is the number of elements in the list.
 */





import java.util.Arrays;
import java.util.Scanner;

public class LibraryManagementSystem {
    private Book[] books;

    public LibraryManagementSystem(Book[] books) {
        this.books = books;
    }

    public void linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void binarySearchByTitle(String title) {
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (books[mid].getTitle().equals(title)) {
                System.out.println("Book found: " + books[mid].getTitle() + " by " + books[mid].getAuthor());
                return;
            } else if (books[mid].getTitle().compareTo(title) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Book not found");
    }

    public static void main(String[] args) {
        Book[] books = new Book[] {
                new Book(1, "Book 1", "Author 1"),
                new Book(2, "Book 2", "Author 2"),
                new Book(3, "Book 3", "Author 3"),
                new Book(4, "Book 4", "Author 4"),
                new Book(5, "Book 5", "Author 5")
        };

        LibraryManagementSystem lms = new LibraryManagementSystem(books);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Linear Search by Title");
            System.out.println("2. Binary Search by Title");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title to search: ");
                    String title = scanner.next();
                    lms.linearSearchByTitle(title);
                    break;
                case 2:
                    System.out.print("Enter book title to search: ");
                    String binarySearchTitle = scanner.next();
                    lms.binarySearchByTitle(binarySearchTitle);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

/*

Analysis:

Time Complexity: 
 -> Linear search has a time complexity of O(n), while binary search has a time complexity of O(log n).

When to use each algorithm:
-> Linear search is suitable for small datasets or when the data is not sorted.
-> Binary search is suitable for large datasets that are sorted, as it is much faster than linear search.

*/