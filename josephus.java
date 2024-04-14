import java.util.InputMismatchException;
import java.util.Scanner;

public class JosephusProblemSolver {

    public static int findWinningPosition(int numberOfPeople, int eliminationCount, int startingIndex) {
        // Validate input parameters to ensure they are valid
        if (numberOfPeople <= 0 || eliminationCount <= 0 || startingIndex <= 0)
            throw new IllegalArgumentException("Invalid input. Ensure all values are positive integers.");

        // Validate startingIndex to ensure it's within the range of numberOfPeople
        if (startingIndex > numberOfPeople)
            throw new IllegalArgumentException("Starting index cannot be greater than the number of people.");

        // Initialize the last person standing
        int lastPersonStanding = 0;
        // Adjust the starting position based on 1-indexing
        startingIndex = (startingIndex - 1 + eliminationCount) % numberOfPeople;

        // Calculate the winning position
        for (int i = 2; i <= numberOfPeople; i++)
            lastPersonStanding = (lastPersonStanding + eliminationCount) % i;

        // Adjust the winning position to match 1-indexing
        return (lastPersonStanding + startingIndex) % numberOfPeople == 0 ?
                numberOfPeople : (lastPersonStanding + startingIndex) % numberOfPeople;
    }

    
    public static void main(String[] args) {
        // Use try-with-resources to automatically close the Scanner object
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of people: ");
            int numberOfPeople = scanner.nextInt();

            System.out.print("Enter the elimination count: ");
            int eliminationCount = scanner.nextInt();

            System.out.print("Enter the starting index: ");
            int startingIndex = scanner.nextInt();

            // Calculate the winning position using the findWinningPosition method
            int winningPosition = findWinningPosition(numberOfPeople, eliminationCount, startingIndex);
            // Display the winning position
            System.out.println("The winning position is: " + winningPosition);
        } catch (InputMismatchException e) {
            // Handle the case when the input is not an integer
            System.out.println("Input should only be an integer. Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            // Handle the case when an illegal argument is provided
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
