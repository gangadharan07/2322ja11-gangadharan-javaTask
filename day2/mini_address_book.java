package task;

import java.util.Scanner;

public class mini_address_book {
	public static void main(String[] args) {
        final int MAX_CONTACTS = 100;

        String[] names = new String[MAX_CONTACTS];
        String[] phones = new String[MAX_CONTACTS];
        String[] emails = new String[MAX_CONTACTS];

        Scanner in = new Scanner(System.in);
        int contactCount = 0;
        int choice;

        do {
            System.out.println("\nMini Address Book");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Delete Contact");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            in.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    if (contactCount < MAX_CONTACTS) {
                        System.out.print("Enter name: ");
                        names[contactCount] = in.nextLine();

                        System.out.print("Enter phone: ");
                        phones[contactCount] = in.nextLine();

                        System.out.print("Enter email: ");
                        emails[contactCount] = in.nextLine();

                        System.out.println("✅ Contact added.");
                        contactCount++;
                    } else {
                        System.out.println("⚠️ Address book is full.");
                    }
                    break;

                case 2:
                    if (contactCount == 0) {
                        System.out.println("No contacts to display.");
                    } else {
                        System.out.println("\n📋 Contacts:");
                        for (int i = 0; i < contactCount; i++) {
                            System.out.println((i + 1) + ". " + names[i] + " | " + phones[i] + " | " + emails[i]);
                        }
                    }
                    break;

                case 3:
                    if (contactCount == 0) {
                        System.out.println("Address book is empty. Nothing to delete.");
                        break;
                    }

                    System.out.print("Enter name of contact to delete: ");
                    String nameToDelete = in.nextLine();
                    boolean found = false;

                    for (int i = 0; i < contactCount; i++) {
                        if (names[i].equalsIgnoreCase(nameToDelete)) {
                            // Shift remaining contacts left
                            for (int j = i; j < contactCount - 1; j++) {
                                names[j] = names[j + 1];
                                phones[j] = phones[j + 1];
                                emails[j] = emails[j + 1];
                            }

                            // Nullify last slot
                            names[contactCount - 1] = null;
                            phones[contactCount - 1] = null;
                            emails[contactCount - 1] = null;

                            contactCount--;
                            found = true;
                            System.out.println("🗑️ Contact deleted successfully.");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("❌ Contact not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Address Book. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        in.close();
    }

}
