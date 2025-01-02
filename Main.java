import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerList cl = new CustomerList();
        VideoBinaryTree bt = new VideoBinaryTree();
        Scanner scan = new Scanner(System.in);
        boolean active = true;

        bt.insert("086162113031", "Star Wars");
        bt.insert("091837179471", "Interstellar");
        bt.insert("108576381921", "Oppenheimer");
        bt.insert("197726654642", "Hacksaw Ridge");
        bt.insert("476628545284", "Avatar");
        bt.insert("466862651538", "The Batman");
        bt.insert("009776169611", "The Revenant");

        while (active) {
            System.out.println();
            System.out.println("---Choose an option---");
            System.out.println();
            System.out.println("1. Contact Information");
            System.out.println("2. All Movies");
            System.out.println("3. Search");
            System.out.println("4. Rent");
            System.out.println("5. Return");
            System.out.println("6. Add Video");
            System.out.println("7. Quit");

            System.out.println();
            String cmd = scan.nextLine().trim();

            if (cmd.equalsIgnoreCase("Add Video") || cmd.equals("6")) {
                System.out.println("Enter 12 digit Movie Barcode: ");
                String barcode = scan.nextLine();
                System.out.println("Enter Movie Title: ");
                String title = scan.nextLine();
                bt.insert(barcode, title);
                System.out.println("Video added successfully.");

            } else if (cmd.equalsIgnoreCase("Search") || cmd.equals("3")) {
                System.out.println("Enter Movie Title: ");
                String title = scan.nextLine();
                bt.findWhoHasVideoRented(cl, title);

            } else if (cmd.equalsIgnoreCase("Rent") || cmd.equals("4")) {
                System.out.println("Enter Phone Number: ");
                String number = scan.nextLine();
                System.out.println("Enter 12 digit Movie Barcode: ");
                String barcode = scan.nextLine();
                bt.rent(cl, number, barcode);

            } else if (cmd.equalsIgnoreCase("Return") || cmd.equals("5")) {
                System.out.println("Enter Phone Number: ");
                String number = scan.nextLine();
                System.out.println("Enter 12 digit Movie Barcode: ");
                String barcode = scan.nextLine();
                bt.returnVideo(cl, number, barcode);

            } else if (cmd.equalsIgnoreCase("Contact Information") || cmd.equals("1")) {
                System.out.println("Enter Phone Number: ");
                String number = scan.nextLine();
                System.out.println("Enter First Name: ");
                String first = scan.nextLine();
                System.out.println("Enter Last Name: ");
                String last = scan.nextLine();

                Customer c = new Customer(number, first, last);
                cl.add(c);
                System.out.println("Contact information added successfully.");

            } else if (cmd.equalsIgnoreCase("All Movies") || cmd.equals("2")) {
                bt.printInOrder();

            } else if (cmd.equalsIgnoreCase("Quit") || cmd.equals("7")) {
                active = false;
                System.out.println("Exiting the program...");

            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
        scan.close();
    }
}
