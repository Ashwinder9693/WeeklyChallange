import java.util.Scanner;

public class DateConverter {

    public static void main(String[] args) {
        // Array of month names
        String[] months = {
            "January", "February", "March", "April", "May", "June", 
            "July", "August", "September", "October", "November", "December"
        };

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Main loop for input and conversion
        while (true) {
            System.out.print("Date (e.g., January 01, 2023): ");
            String date = scanner.nextLine();
            try {
                // Extracting date components
                String mm, dd, yyyy;
                if (date.contains("/")) {
                    String[] parts = date.split("/");
                    mm = parts[0];
                    dd = parts[1];
                    yyyy = parts[2];
                } else if (date.contains(",")) {
                    String[] parts = date.split(", ");
                    String[] mmdd = parts[0].trim().split(" ");
                    String monthName = mmdd[0];
                    // Checking if month name is abbreviated
                    if (monthName.length() <= 3) {
                        throw new IllegalArgumentException("Please enter the full month name.");
                    }
                    mm = String.format("%02d", findMonthIndex(monthName, months));
                    dd = mmdd[1];
                    yyyy = parts[1].trim();
                } else {
                    throw new IllegalArgumentException("Invalid date format. Please use either MM/DD/YYYY or Month DD, YYYY format.");
                }
                // Parsing date components
                int month = Integer.parseInt(mm);
                int day = Integer.parseInt(dd);
                int year = Integer.parseInt(yyyy);

                // Validating date components
                if (month < 1 || month > 12 || day < 1 || day > daysInMonth(month, year)) {
                    throw new IllegalArgumentException("Invalid date. Please enter a valid date.");
                }
                
                // Printing formatted date
                System.out.printf("%s-%s-%s\n", yyyy, mm, dd);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values for date components.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    // Function to find the index of the month
    private static int findMonthIndex(String monthName, String[] months) {
        for (int i = 0; i < months.length; i++) {
            if (months[i].startsWith(monthName)) {
                return i + 1;
            }
        }
        throw new IllegalArgumentException("Invalid month name. Please enter a valid month name.");
    }

    // Function to determine the number of days in a month
    private static int daysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
}
