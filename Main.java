package Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        System.out.print("Enter number of users: ");
        int uCount = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < uCount; i++) {
            System.out.print("Enter user name: ");
            String name = sc.nextLine();
            System.out.print("Enter user ID: ");
            int id = sc.nextInt(); sc.nextLine();
            library.addUser(new User(name, id));
        }

        System.out.print("\nEnter number of books: ");
        int bCount = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < bCount; i++) {
            System.out.print("Enter book title: ");
            String title = sc.nextLine();
            System.out.print("Enter book author: ");
            String author = sc.nextLine();
            library.addBook(new Book(title, author));
        }

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Display Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    String issueTitle = sc.nextLine();
                    System.out.print("Enter user ID: ");
                    int issueId = sc.nextInt(); sc.nextLine();
                    library.issueBook(issueTitle, issueId);
                    break;
                case 3:
                    System.out.print("Enter book title: ");
                    String returnTitle = sc.nextLine();
                    System.out.print("Enter user ID: ");
                    int returnId = sc.nextInt(); sc.nextLine();
                    library.returnBook(returnTitle, returnId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

