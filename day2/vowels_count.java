package task;

import java.util.Scanner;

public class vowels_count {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Word: ");
        String vc = sc.nextLine().toLowerCase();

        int vowels = 0, consonants = 0;

        for (int i = 0; i < vc.length(); i++) {
            char ch = vc.charAt(i);

            // Check if it's a letter
            if (ch >= 'a' && ch <= 'z') {
                // Check for vowels
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        sc.close();
    }
}
