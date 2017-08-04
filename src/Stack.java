import java.util.ArrayList;
import java.util.List;

public class Stack {

    private List<Card> cards = new ArrayList<>();

    public Stack()
    {
    }

    public Card draw()
    {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public void shuffle()
    {
        cards.clear();

        for (int i = 1; i < 5; i++)
        {
            for (int j = 1; j < 14; j++)
            {
                int card_value = j;
                if (j > 10)
                {
                    card_value = 10;
                }

                Card card = new Card(card_value);
                cards.add(card);
            }
        }
    }
}
