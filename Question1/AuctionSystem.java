/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package groupm.auctionsystem;

import java.util.Scanner;

/**
 *
 * @author Kamaal Ali Barre
 */
public class AuctionSystem {

    

    
    public static void main(String[] args) {

        // Vehicle details
        try (Scanner sc = new Scanner(System.in)) {
            // Vehicle details
            System.out.print("Enter Vehicle Registration Number: ");
            String regNumber = sc.nextLine();
            
            System.out.print("Enter Vehicle Cost: ");
            double vehicleCost = sc.nextDouble();
            
            System.out.print("Enter Deposit Amount: ");
            double deposit = sc.nextDouble();
            
            System.out.print("Enter Expenses Incurred: ");
            double expenses = sc.nextDouble();
            
            System.out.print("Enter Balance Left on Vehicle: ");
            double balanceLeft = sc.nextDouble();
            
            // Bidders
            System.out.println("\n--- Enter Bidders Details ---");
            
            System.out.print("Bidder 1 Price: ");
            double bid1 = sc.nextDouble();
            
            System.out.print("Bidder 2 Price: ");
            double bid2 = sc.nextDouble();
            
            System.out.print("Bidder 3 Price: ");
            double bid3 = sc.nextDouble();
            
            // Determine highest bidder
            double highestBid = bid1;
            int winner = 1;
            
            if (bid2 > highestBid) {
                highestBid = bid2;
                winner = 2;
            }
            
            if (bid3 > highestBid) {
                highestBid = bid3;
                winner = 3;
            }
            
            // Calculations
            double totalCost = vehicleCost + expenses + balanceLeft;
            
            double profitOrLoss = highestBid - totalCost;
            
            // Output
            System.out.println("\n--- Auction Result ---");
            System.out.println("Vehicle Registration: " + regNumber);
            System.out.println("Winning Bidder: Bidder " + winner);
            System.out.println("Winning Price: " + highestBid);
            System.out.println("Balance Cleared: " + balanceLeft);
            
            if (profitOrLoss > 0) {
                System.out.println("Profit Made: " + profitOrLoss);
            } else if (profitOrLoss < 0) {
                System.out.println("Loss Made: " + Math.abs(profitOrLoss));
            } else {
                System.out.println("No Profit No Loss");
            }
        }
    }
}
    


