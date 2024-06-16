import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] bookNames = new String[100];
        String[][] bookDetails = new String[100][3];
        int bookCount = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSwitch Case Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Display the list of books");
            System.out.println("3. Search for a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.next();

            switch (choice) {
                case "1":
                    addBook(bookNames, bookDetails, bookCount, scanner);
                    bookCount++;
                    break;
                case "2":
                    displayBooks(bookNames, bookDetails, bookCount);
                    break;
                case "3":
                    searchBook(bookNames, bookDetails, bookCount, scanner);
                    break;
                case "4":
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void addBook(String[] bookNames, String[][] bookDetails, int bookCount, Scanner scanner) {
        System.out.print("Enter the name of the book: ");
        String bookName = scanner.next();
        bookNames[bookCount] = bookName;

        System.out.print("Enter the author of the book: ");
        bookDetails[bookCount][0] = scanner.next();

        System.out.print("Enter the title of the book: ");
        bookDetails[bookCount][1] = scanner.next();

        System.out.print("Enter the ISBN of the book: ");
        bookDetails[bookCount][2] = scanner.next();

        System.out.println("Book added successfully!");
    }

    private static void displayBooks(String[] bookNames, String[][] bookDetails, int bookCount) {
        System.out.println("List of books:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". " + bookNames[i] + " - Author: " + bookDetails[i][0] + ", Title: " + bookDetails[i][1] + ", ISBN: " + bookDetails[i][2]);
        }
    }

    private static void searchBook(String[] bookNames, String[][] bookDetails, int bookCount, Scanner scanner) {
        System.out.print("Enter the name or title of the book you want to search: ");
        String searchQuery = scanner.next();
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (bookNames[i].equalsIgnoreCase(searchQuery) || bookDetails[i][1].toLowerCase().contains(searchQuery.toLowerCase())) {
                found = true;
                System.out.println(searchQuery + " found in the list. Details: Author: " + bookDetails[i][0] + ", Title: " + bookDetails[i][1] + ", ISBN: " + bookDetails[i][2]);
            }
        }
        if (!found) {
            System.out.println(searchQuery + " not found in the list.");
        }
    }

}