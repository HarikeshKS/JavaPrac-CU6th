import java.util.*;

class Card {
    String symbol;
    int number;

    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }
}

public class CardGame {
    public static void main(String[] args) {
        Set<Card> cardSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        // Collecting card details from the user
        while (cardSet.size() < 4) {
            System.out.print("Enter symbol for card: ");
            String symbol = scanner.next().toUpperCase();
            boolean symbolExists = cardSet.stream().anyMatch(card -> card.symbol.equals(symbol));

            if (symbolExists) {
                System.out.print("Enter number for card: ");
                int number = scanner.nextInt();
                continue;
            }

            System.out.print("Enter number for card: ");
            int number = scanner.nextInt();

            Card card = new Card(symbol, number);
            cardSet.add(card);
        }

        // Sorting the cards by symbol in alphabetical order
        List<Card> sortedCards = new ArrayList<>(cardSet);
        sortedCards.sort(Comparator.comparing(card -> card.symbol));

        // Displaying the first occurrence of card details in alphabetical order
        System.out.println("\nFirst occurrence of card details in alphabetical order:");
        System.out.println("Symbol\tNumber");
        for (int i = 0; i < sortedCards.size(); i++) {
            System.out.println(sortedCards.get(i).symbol + "\t\t" + sortedCards.get(i).number);
        }

        scanner.close();
    }
}
