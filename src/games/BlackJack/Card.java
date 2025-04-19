package src.games.BlackJack;

public class Card {
    String value;
    String type;

    public Card(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String toString() {
        return value + "-" + type;
    }

    // get card values- Ace or >=10 or int values
    public int getValue() {
        if ("AJQK".contains(value)) {
            if (value == "A") {
                return 11;
            }
            return 10;
        }
        // 2-10 from string
        return Integer.parseInt(value);
    }

    public boolean isAce() {
        return value == "A";
    }
}
