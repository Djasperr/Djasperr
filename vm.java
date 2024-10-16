import java.util.Scanner;

public class vm {

    static void items() {
        System.out.println("Available Items");
        System.out.println("1. Soda - $25");
        System.out.println("2. Chips - $15");
        System.out.println("3. Chocolate - $20");
    }

    static int order() {
        int order = 0;
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the item number you want to buy: ");
            order = s.nextInt();
            if (order >= 1 && order <= 3) {
                break;
            } else {
                System.out.println("Invalid item. Please enter a number between 1 and 3.");
            }          
        }
        return order;
    }

    static boolean checkBalance(int bal, int order) {
        switch (order) {
            case 1:
                return bal >= 25;
            case 2:
                return bal >= 15;
            case 3:
                return bal >= 20;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        int bal = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your initial balance: ");
        bal = s.nextInt();

        if(bal >= 15){
            while (bal >= 15) {
                items();
                int order = order();

                if (checkBalance(bal, order)) {
                    switch (order) {
                        case 1:
                            bal -= 25;
                            System.out.println("You purchased Soda.");
                            break;
                        case 2:
                            bal -= 15;
                            System.out.println("You purchased Chips.");
                            break;
                        case 3:
                            bal -= 20;
                            System.out.println("You purchased Chocolate.");
                            break;
                    }
                    System.out.println("Remaining balance is $" + bal);
                    if (bal < 15){
                        System.out.println("You have no remaining balance. Ending purchase");
                        break;
                    }
                    System.out.print("Do you want to buy another item? (yes/no): ");
                    String ask = s.next();
                    if (ask.equalsIgnoreCase("yes")) {
                        continue;
                    }else{
                        break;
                    }
                } else {
                    System.out.println("Insufficient balance for this item.");
                }

                if (bal < 15) {
                    System.out.println("You have no remaining balance. Ending purchase.");
                    break;
                }
            }
        }else{
            System.out.println("Insufficient balance");
        }
        System.out.println("Thank you for using the vending machine!");
    }
}
