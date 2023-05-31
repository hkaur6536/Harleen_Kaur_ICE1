package card;

import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * 
 * Author: Harleen Kaur
 * Student ID: 991707028
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

        // Fill the magicHand array with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(generateRandomValue());
            c.setSuit(Card.SUITS[generateRandomSuit()]);
            magicHand[i] = c;
        }

        // Ask the user for their card
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of your card: ");
        int userValue = scanner.nextInt();
        System.out.print("Enter the suit of your card (0-3): ");
        int userSuit = scanner.nextInt();
        scanner.close();

        // Create the user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[userSuit]);

        // Search for the user's card in magicHand
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Report the result
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }

    // Helper method to generate a random value (1-13)
    private static int generateRandomValue() {
        return (int) (Math.random() * 13) + 1;
    }

    // Helper method to generate a random suit (0-3)
    private static int generateRandomSuit() {
        return (int) (Math.random() * 4);
    }
}
