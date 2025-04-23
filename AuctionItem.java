package model;

public class AuctionItem {
    private String name;
    private double highestBid;
    private String highestBidder;

    public AuctionItem(String name) {
        this.name = name;
        this.highestBid = 0;
        this.highestBidder = "None";
    }

    public String getName() {
        return name;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public String getHighestBidder() {
        return highestBidder;
    }

    public void placeBid(String bidder, double amount) {
        if (amount > highestBid) {
            highestBid = amount;
            highestBidder = bidder;
            System.out.println("Bid placed successfully!");
        } else {
            System.out.println("Bid too low!");
        }
    }
}
