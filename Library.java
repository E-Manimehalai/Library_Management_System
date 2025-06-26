package Library;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void issueBook(String title, int userId) {
        Book book = findBookByTitle(title);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book is already issued.");
        } else {
            book.setIssued(true);
            System.out.println("Book issued to " + user.getName() + ".");
        }
    }

    public void returnBook(String title, int userId) {
        Book book = findBookByTitle(title);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        if (!book.isIssued()) {
            System.out.println("Book is not issued.");
        } else {
            book.setIssued(false);
            System.out.println("Book returned by " + user.getName() + ".");
        }
    }

    public void displayBooks() {
        System.out.println("\n--- Library Books ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
