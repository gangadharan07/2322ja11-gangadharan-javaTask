package day3;
import java.util.Scanner;

public class Post_LibrarySystem {

    static class Book {
        int id;
        String title;
        String author;
        boolean isIssued;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isIssued = false;
        }

        void display() {
            System.out.println("ID: " + id + " | Title: " + title + " | Author: " + author + " | Status: " + (isIssued ? "Issued" : "Available"));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[100];
        int count = 0;

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Issue Book");
            System.out.println("4. View All Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    books[count++] = new Book(id, title, author);
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = sc.nextInt();
                    boolean foundRemove = false;
                    for (int i = 0; i < count; i++) {
                        if (books[i].id == removeId) {
                            for (int j = i; j < count - 1; j++) {
                                books[j] = books[j + 1];
                            }
                            books[--count] = null;
                            foundRemove = true;
                            System.out.println("Book removed.");
                            break;
                        }
                    }
                    if (!foundRemove) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    boolean foundIssue = false;
                    for (int i = 0; i < count; i++) {
                        if (books[i].id == issueId) {
                            if (!books[i].isIssued) {
                                books[i].isIssued = true;
                                System.out.println("Book issued successfully.");
                            } else {
                                System.out.println("Book already issued.");
                            }
                            foundIssue = true;
                            break;
                        }
                    }
                    if (!foundIssue) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.println("\nAvailable Books in Library:");
                    for (int i = 0; i < count; i++) {
                        books[i].display();
                    }
                    break;

                case 5:
                    System.out.println("Exiting Library System. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
