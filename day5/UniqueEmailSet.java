package day5;
import java.util.HashSet;
import java.util.Scanner;

public class UniqueEmailSet {
    public static void main(String[] args) {
        HashSet<String> emailSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter email addresses (type 'done' to finish):");

        while (true) {
            System.out.print("Email: ");
            String email = sc.nextLine().trim();

            if (email.equalsIgnoreCase("done")) {
                break;
            }

            if (emailSet.add(email)) {
                System.out.println("Added: " + email);
            } else {
                System.out.println("Duplicate! Already exists.");
            }
        }

        System.out.println("\nUnique Email Addresses:");
        for (String e : emailSet) {
            System.out.println(e);
        }

        sc.close();
    }
}
