import java.util.Scanner;

public class Readability {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Text: ");
        String text = scanner.nextLine();
        scanner.close();
        
        int letterCount = countLetters(text);
        int wordCount = countWords(text);
        int sentenceCount = countSentences(text);
        
        double L = calculateL(letterCount, wordCount);
        double S = calculateS(sentenceCount, wordCount);
        int readabilityIndex = calculateReadabilityIndex(L, S);
        
        displayGrade(readabilityIndex);
    }
    
    // Function to count the number of letters in the text
    private static int countLetters(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }
    
    // Function to count the number of words in the text
    private static int countWords(String text) {
        return text.split("\\s+").length;
    }
    
    // Function to count the number of sentences in the text
    private static int countSentences(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == '.' || c == '!' || c == '?') {
                count++;
            }
        }
        return count;
    }
    
    // Function to calculate L value
    private static double calculateL(int letterCount, int wordCount) {
        return ((double) letterCount / wordCount) * 100;
    }
    
    // Function to calculate S value
    private static double calculateS(int sentenceCount, int wordCount) {
        return ((double) sentenceCount / wordCount) * 100;
    }
    
    // Function to calculate readability index
    private static int calculateReadabilityIndex(double L, double S) {
        return (int) Math.round(0.0588 * L - 0.296 * S - 15.8);
    }
    
    // Function to display the grade based on the readability index
    private static void displayGrade(int index) {
        if (index < 1) {
            System.out.println("Before Grade 1");
        } else if (index >= 16) {
            System.out.println("Grade 16+");
        } else {
            System.out.println("Grade " + index);
        }
    }
}