import java.util.Scanner;

class EBBill {
    int consumerNumber;
    String consumerName;
    int prevReading;
    int currReading;
    String connectionType;
    double billAmount;

    void inputDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter consumer number: ");
        consumerNumber = sc.nextInt();

        System.out.print("Enter consumer name: ");
        consumerName = sc.next();

        System.out.print("Enter previous month reading: ");
        prevReading = sc.nextInt();

        System.out.print("Enter current month reading: ");
        currReading = sc.nextInt();

        System.out.print("Enter type of EB connection (domestic/commercial): ");
        connectionType = sc.next().toLowerCase();
    }

    void calculateBill() {
        int units = currReading - prevReading;

        if (connectionType.equals("domestic")) {
            if (units <= 100)
                billAmount = units * 1;
            else if (units <= 200)
                billAmount = 100 * 1 + (units - 100) * 2.50;
            else if (units <= 500)
                billAmount = 100 * 1 + 100 * 2.50 + (units - 200) * 4;
            else
                billAmount = 100 * 1 + 100 * 2.50 + 300 * 4 + (units - 500) * 6;

        } else if (connectionType.equals("commercial")) {
            if (units <= 100)
                billAmount = units * 2;
            else if (units <= 200)
                billAmount = 100 * 2 + (units - 100) * 4.50;
            else if (units <= 500)
                billAmount = 100 * 2 + 100 * 4.50 + (units - 200) * 6;
            else
                billAmount = 100 * 2 + 100 * 4.50 + 300 * 6 + (units - 500) * 7;
        } else {
            System.out.println("Invalid connection type!");
        }
    }

    void displayBill() {
        System.out.println("\n--- Electricity Bill ---");
        System.out.println("Consumer number     : " + consumerNumber);
        System.out.println("Consumer name       : " + consumerName);
        System.out.println("Type of connection  : " + connectionType);
        System.out.println("Units consumed      : " + (currReading - prevReading));
        System.out.printf("Total bill amount   : Rs. %.2f\n", billAmount);
    }
}
class Main {
    public static void main(String[] args) {
     EBBill bill = new EBBill();
        bill.inputDetails();
        bill.calculateBill();
        bill.displayBill();
    }
}
