package service;

import model.AuctionItem;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuctionFrame extends JFrame {
    private AuctionItem item;
    private User user;
    private JLabel itemLabel;
    private JLabel highestBidLabel;
    private JTextField bidField;
    private JButton bidButton;
    private JLabel messageLabel;

    public AuctionFrame() {
        // Set user and item
        item = new AuctionItem("Antique Painting");
        user = new User(1, "John Doe");

        // Frame settings
        setTitle("Online Auction System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        // GUI Components
        itemLabel = new JLabel("Item: " + item.getName());
        highestBidLabel = new JLabel("Highest Bid: $" + item.getHighestBid());
        bidField = new JTextField();
        bidButton = new JButton("Place Bid");
        messageLabel = new JLabel("");

        // Add action to button
        bidButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double bidAmount = Double.parseDouble(bidField.getText());
                    double currentBid = item.getHighestBid();

                    if (bidAmount > currentBid) {
                        item.placeBid(user.getName(), bidAmount);
                        highestBidLabel.setText("Highest Bid: $" + item.getHighestBid());
                        messageLabel.setText("Bid placed successfully!");
                    } else {
                        messageLabel.setText("Your bid is too low!");
                    }

                } catch (NumberFormatException ex) {
                    messageLabel.setText("Please enter a valid number.");
                }
            }
        });

        // Add components to frame
        add(itemLabel);
        add(highestBidLabel);
        add(new JLabel("Enter your bid:"));
        add(bidField);
        add(bidButton);
        add(messageLabel);

        // Show frame
        setVisible(true);
    }
}
