import java.util.Scanner;

public class CreditCardValidator  {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for credit card number and validate input
        long cardNumber = getCreditCardNumber(scanner);
        
        // Validate credit card using Luhn's algorithm
        if (isValidCreditCard(cardNumber)) {
            // Determine and print the type of credit card
            String cardType = getCreditCardType(cardNumber);
            System.out.println("Card type: " + cardType);
        } else {
            System.out.println("Invalid credit card number.");
        }
    }
    
    // Function to get a valid credit card number from the user
    private static long getCreditCardNumber(Scanner scanner) {
        long cardNumber;
        do {
            System.out.print("Enter your credit card number: ");
            while (!scanner.hasNextLong()) {
                System.out.println("Invalid input. Please enter a valid numeric credit card number.");
                System.out.print("Enter your credit card number: ");
                scanner.next(); // Consume invalid input
            }
            cardNumber = scanner.nextLong();
            if(cardNumber <= 0) {
                System.out.println("Invalid input. Credit card number cannot be zero or negative.");
            }
        } while (cardNumber <= 0);
        return cardNumber;
    }
    
    // Function to check if a credit card number is valid using Luhn's algorithm
    private static boolean isValidCreditCard(long cardNumber) {
        int sum = 0;
        boolean alternate = false;
        long temp = cardNumber;
        while (temp != 0) {
            int digit = (int) (temp % 10);
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit = digit % 10 + digit / 10;
                }
            }
            sum += digit;
            alternate = !alternate;
            temp /= 10;
        }
        return sum % 10 == 0;
    }
    
    // Function to determine the type of credit card
    private static String getCreditCardType(long cardNumber) {
        String cardType;
        String cardNumberStr = Long.toString(cardNumber);
        if (cardNumberStr.startsWith("4")) {
            cardType = "VISA";
        } else if (cardNumberStr.startsWith("5")) {
            char secondDigit = cardNumberStr.charAt(1);
            if (secondDigit >= '1' && secondDigit <= '5') {
                cardType = "Mastercard";
            } else {
                cardType = "Unknown";
            }
        } else if (cardNumberStr.startsWith("34") || cardNumberStr.startsWith("37")) {
            cardType = "American Express";
        } else {
            cardType = "Unknown";
        }
        return cardType;
    }
}
