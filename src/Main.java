import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Declare value for number of months in a year and a percent.
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        //Open a user input scanner
        Scanner scanner = new Scanner(System.in);

        //Declare the variable the PRINCIPAL loan of the user's input.
        int PRINCIPAL;

        //Creating a while loop for error control during input in the PRINCIPAL value.
        while (true) {
            System.out.print("Principal ($1k - $1M): ");
            PRINCIPAL = scanner.nextInt();

            if (PRINCIPAL >= 1000 && PRINCIPAL <= 1000000) {
                break;
            } else {
                //A prompt asking the user to enter a valid number between 1000 and 1000000 until right.
                System.out.println("Enter a number between 1,000 and 1,000,000.");
            }

        }

        //Declare the variable INTEREST from the user's input.
        float INTEREST;

        //Creating a while loop for error control during input in the INTEREST value.
        while (true) {
            System.out.print("Annual Interest Rate: ");
            INTEREST = scanner.nextFloat();

            if (INTEREST > 0 && INTEREST <= 30){
                break;
            } else {
                //A prompt asking the user to enter a valid number greater than 0 or less than 30 (inclusive) until right.
                System.out.println("Enter a value greater than 0 or equal to 30.");
            }
        }
        //Declare the variable YEARS from the user's input.
        byte YEARS;

        //Creating a while loop for error control during input in the YEARS value.
        while (true){
            System.out.print("Period (Years Given): ");
            YEARS = scanner.nextByte();

            if (YEARS >= 1 && YEARS <= 30){
                break;
            }else {
                //A prompt asking the user to enter a valid number between 1 and 30(inclusive) until right.
                System.out.println("Enter a value between 1 and 30.");
            }
        }

        // From now on we basically perform this calculation:
        // Mortgage = PRINCIPAL * INTEREST(1 + INTEREST)^CALCULATED YEAR / (1 + INTEREST)^CALCULATED YEAR - 1

        float CALCULATED_INTEREST = INTEREST / PERCENT / MONTHS_IN_YEAR; // We now have our calculated interest.
        int CALCULATED_YEAR = YEARS * MONTHS_IN_YEAR; // We now have our calculated total years.

        double UPPER_BRACKET = Math.pow(CALCULATED_INTEREST + 1, CALCULATED_YEAR) * CALCULATED_INTEREST;
        double LOWER_BRACKET = Math.pow(CALCULATED_INTEREST + 1, CALCULATED_YEAR) - 1;

        double HALF_SOLUTION = UPPER_BRACKET / LOWER_BRACKET;
        double MORTGAGE = Math.round(HALF_SOLUTION * PRINCIPAL);

        System.out.println("MORTGAGE: $" + MORTGAGE);

    }
}