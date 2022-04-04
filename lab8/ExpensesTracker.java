import java.io.FileReader;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import java.util.Scanner;

public class ExpensesTracker {
    public static void main(String[] args) throws IOException {
        String name, object, answer, summary, display;
        double money;

        try {
            // Create FileWriter & Scanner objects & y/n string
            Scanner scan = new Scanner(System.in);
            FileWriter fw = new FileWriter("expenses.txt", true);

            // Start gathering information inside the loop you will start
            do {
                System.out.println("Input your name: ");
                name = scan.nextLine();
                System.out.println("What did you purchase?");
                object = scan.nextLine();
                System.out.println("How much did you pay? (in USD)");
                money = scan.nextDouble();

                fw.write(name + " purchased " + object + " for " + money + " US Dollars" + "\n");

                System.out.println("Would you like to log another purchase? (y/n)");
                scan.nextLine();
                answer = scan.nextLine();

            } while (answer.equals("y"));

            System.out.println("Get off of ZoodMall!");
            System.out.println("Would you like to read a summary of your purchases?");
            summary = scan.nextLine();

            FileReader reader = new FileReader("expenses.txt");

            if (summary.equals("y")) {
                String data = reader.read();
                System.out.println(data);

            }

            // Close ClassWriter & Scanner objects
            fw.close();
            scan.close();
            reader.close();

            // If you have already have a expenses.txt file, you need to delete it
            // before you compile your code again

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}