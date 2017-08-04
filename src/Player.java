import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;
import static java.lang.System.console;


public class Player
{
    public String name;
    private Boolean playing = false;
    public int score = 0;
    private Stack stack;

    public Player (Stack s, int id)
    {
        name = "Player " + Integer.toString(id);
        stack = s;
    }

    private void action()
    {
        String input;

        while (true)
        {
            try
            {
                out.println("Draw or pass? Enter 'd' or 'p' and press return. ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                input = (br.readLine()).toUpperCase();
                break;
            }
            catch (IOException ioe)
            {
                out.println("Invalid input.");
            }
            catch (NumberFormatException nfe)
            {
                out.println("Invalid input.");
            }
        }

        if (input.equals("D"))
        {
            evaluate(stack.draw());
        }
        else if (input.equals("P"))
        {
            playing = false;
        }
        else
        {
            out.println("Invalid input. ");
            action();
        }
    }

    private void evaluate(Card c)
    {
        score += c.value;
        out.println("Score: " + Integer.toString((score)));
        if (score > 21)
        {
            out.println("You've lost!");
            playing = false;
        }

    }

    public void turn()
    {
        playing = true;

        out.println(name);
        while (playing)
        {
            action();
        }
    }
}
