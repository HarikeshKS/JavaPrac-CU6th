import java.util.*;

class Card {
    String symbol;
    int number;

    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }
}

public class ArrayListCollectCards {
    public static void main(String[] args) {
        Map<String, List<Card>> cardsMap = collectCards();

        printCardDetails(cardsMap);
    }

    public static Map<String, List<Card>> collectCards() {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Card>> cardsMap = new HashMap<>();

        System.out.print("Enter the number of cards: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the symbol for the card: ");
            String symbol = scanner.nextLine();

            System.out.print("Enter the number for the card: ");
            int number = scanner.nextInt();
            scanner.nextLine();

            Card card = new Card(symbol, number);

            if (cardsMap.containsKey(symbol)) {
                cardsMap.get(symbol).add(card);
            } else {
                List<Card> cardList = new ArrayList<>();
                cardList.add(card);
                cardsMap.put(symbol, cardList);
            }
        }

        return cardsMap;
    }

    public static void printCardDetails(Map<String, List<Card>> cardsMap) {
        List<String> symbols = new ArrayList<>(cardsMap.keySet());
        Collections.sort(symbols);

        for (String symbol : symbols) {
            System.out.println("\nSymbol: " + symbol);

            List<Card> cards = cardsMap.get(symbol);
            int totalCards = cards.size();
            int cardSum = cards.stream().mapToInt(card -> card.number).sum();

            for (Card card : cards) {
                System.out.println("Number: " + card.number);
            }

            System.out.println("Number of cards: " + totalCards);
            System.out.println("Sum of card numbers: " + cardSum);
        }
    }
}
