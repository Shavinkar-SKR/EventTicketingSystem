package CLI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private Vendor[] vendors;
    private Customer[] customers;

    public void startSimulation(
            int totalTickets, int ticketsReleaseRate, int customerRetrievalRate, int maxTicketCapacity,
            int numberOfVendors, int numberOfCustomers, int maximumTicketsCanBePurchased
    )
    {
        Configuration config = new Configuration(totalTickets, ticketsReleaseRate,
                customerRetrievalRate, maxTicketCapacity, numberOfVendors,
                numberOfCustomers, maximumTicketsCanBePurchased
        );

        Configuration configLoad = config.loadConfiguration();
        vendors = new Vendor[numberOfVendors];
        customers = new Customer[numberOfCustomers];

        TicketPool ticketPool = new TicketPool(configLoad);

        for (int i = 0; i<vendors.length; i++) {
            Configuration configVendor = new Configuration(totalTickets/ vendors.length, ticketsReleaseRate);
            vendors[i] = new Vendor(ticketPool, configVendor, configVendor);
            Thread vendorThread = new Thread(vendors[i], "Vendor ID: "+i);
            vendorThread.start();
        }

        for (int i = 0; i < customers.length; i++) {
            Configuration configCust = new Configuration(customerRetrievalRate);
            customers[i] = new Customer(ticketPool, maximumTicketsCanBePurchased, configCust);
            Thread customerThread = new Thread(customers[i], "Customer ID: " + i);
            customerThread.start();
        }
    }

    public void stopSimulation(){
        for(int i=0; i<vendors.length; i++){
            vendors[i].stopThread();
        }

        for(int i=0; i<customers.length; i++){
            customers[i].stopThread();
        }
        System.out.println();
        System.out.println("Simulation aborted!!!!!!!!!!!!!!!");
        System.out.println("System exited successfully.");
        System.out.println();
        System.exit(0);
    }

    public static void main(String[] args) {
        int totalTickets = 0;
        int ticketsReleaseRate = 0;
        int customerRetrievalRate = 0;
        int maxTicketCapacity = 0;
        int numberOfVendors = 0;
        int numberOfCustomers = 0;
        int maximumTicketsCanBePurchased = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("                ----------------Real-time Event Ticketing System----------------                ");

        while(true){
            try{
                System.out.print("Enter the number of total tickets: ");
                totalTickets = input.nextInt();
                if(totalTickets>=1) {
                    break;
                }else{
                    System.out.println("Total Tickets must be greater than 0");
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter a number.");
                input.nextLine();
            }
        }

        while(true){
            try{
                System.out.print("Enter the tickets release rate (in seconds): ");
                ticketsReleaseRate = input.nextInt();
                if(ticketsReleaseRate>=1) {
                    break;
                }else{
                    System.out.println("Tickets release rate must be greater than 0");
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter a number.");
                input.nextLine();
            }
        }

        while(true){
            try{
                System.out.print("Enter the customer retrieval rate (in seconds): ");
                customerRetrievalRate = input.nextInt();
                if(customerRetrievalRate>=1) {
                    break;
                }else {
                    System.out.println("Customer retrieval rate must be greater than 0");
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter a number less than 10.");
                input.nextLine();
            }
        }

        while(true){
            try{
                System.out.print("Enter the maximum ticket capacity: ");
                maxTicketCapacity = input.nextInt();
                if(maxTicketCapacity>=1 && maxTicketCapacity<=totalTickets) {
                    break;
                }else {
                    System.out.println("Maximum ticket capacity must be greater than 0 and less than total tickets");
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter a number.");
                input.nextLine();
            }
        }

        while(true){
            try{
                System.out.print("Enter number of vendors: ");
                numberOfVendors = input.nextInt();
                if(numberOfVendors>=1) {
                    break;
                }else {
                    System.out.println("Number of vendors must be greater than 0");
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter a number.");
                input.nextLine();
            }
        }

        while(true){
            try{
                System.out.print("Enter number of customers: ");
                numberOfCustomers = input.nextInt();
                if(numberOfCustomers>=1) {
                    break;
                }else {
                    System.out.println("Number of customers must be greater than 0");
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter a number.");
                input.nextLine();
            }
        }

        while(true){
            try{
                System.out.print("Enter maximum number of tickets a customer can buy: ");
                maximumTicketsCanBePurchased = input.nextInt();
                if(maximumTicketsCanBePurchased>=1) {
                    break;
                }else {
                    System.out.println("Number of tickets must be greater than 0");
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter a number.");
                input.nextLine();
            }
        }

        System.out.println();

        System.out.println("totalTicket: The total number of tickets the vendors decides to release is " + totalTickets);
        System.out.println("ticketsReleaseRate: Each ticket will be released in " + ticketsReleaseRate + " seconds interval.");
        System.out.println("customerRetrievalRate: Each customer retrieves a ticket in " + customerRetrievalRate + " seconds interval.");
        System.out.println("maxTicketCapacity: The maximum number of tickets the ticket pool can hold is " + maxTicketCapacity);
        System.out.println("numberOfVendor: The number of vendors willing to release the tickets is " + numberOfVendors);
        System.out.println("numberOfCustomers: The number of customers willing to purchase the tickets is " + numberOfCustomers);

        Configuration config = new Configuration(totalTickets, ticketsReleaseRate,
                customerRetrievalRate, maxTicketCapacity,
                numberOfCustomers, numberOfVendors,
                maximumTicketsCanBePurchased
        );

        System.out.println();
        config.saveConfigurationJson();
        config.saveConfigurationText();

        System.out.println();
        System.out.println("REMAINDER!!! You can stop the simulation by pressing option 2 while threads are running.");
        System.out.println();

        System.out.println("Start the simulation by entering option 1.");
        System.out.println("Stop the simulation by entering option 2.");
        System.out.print("Enter an option: ");
        Main main = new Main();
        while(true){
            int option = input.nextInt();
            System.out.println();
            switch(option){
                case 1:
                    System.out.println("Simulation started........................................");
                    System.out.println();
                    main.startSimulation(totalTickets, ticketsReleaseRate, customerRetrievalRate, maxTicketCapacity, numberOfVendors, numberOfCustomers, maximumTicketsCanBePurchased);
                    break;
                case 2:
                    main.stopSimulation();
                    break;
                default:
                    System.out.println("Enter a valid option");
            }
        }
    }
}
