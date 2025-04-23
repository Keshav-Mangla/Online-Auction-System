package service;

import model.AuctionItem;
import model.User;
import java.util.Scanner;

public class AuctionSystem {
    private AuctionItem item;
    private User user;

    public AuctionSystem() {
        item = new AuctionItem("Antique Painting");
        user = new User(1, "John Doe");
    }

    public void startAuction() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Auction Menu ---");
            System.out.println("1. View Item");
            System.out.println("2. Place Bid");
            System.out.println("3. View Highest Bid");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Item: " + item.getName());
                    break;
                case 2:
                    System.out.print("Enter your bid amount: ");
                    double bidAmount = scanner.nextDouble();
                    item.placeBid(user.getName(), bidAmount);
                    break;
                case 3:
                    System.out.println("Highest Bidder: " + item.getHighestBidder());
                    System.out.println("Bid: $" + item.getHighestBid());
                    break;
                case 0:
                    System.out.println("Exiting auction. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
