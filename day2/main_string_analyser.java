package task;

import java.util.Scanner;

public class main_string_analyser { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        // Word count
        String[] words = sentence.split(" ");
        int wordCount = words.length;

        // Character count (excluding spaces)
        int charCount = 0;
        for (char c : sentence.toCharArray()) {
            if (c != ' ') charCount++;
        }

        // Reverse string
        String reversed = new StringBuilder(sentence).reverse().toString();

        // Longest word
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count (no spaces): " + charCount);
        System.out.println("Reversed Sentence: " + reversed);
        System.out.println("Longest Word: " + longest);
        sc.close();
    }
}