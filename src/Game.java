import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

public class Game {

    public List<Player> players = new ArrayList<>();
    public Stack stack;

    public Game()
    {
        stack = new Stack();
        stack.shuffle();
    }

    private void setup()
    {
        int playerCount = 0;

        while (true)
        {
            try
            {
                out.println("Enter number of players (2-4) and press return.\n");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String input = br.readLine();
                playerCount = Integer.parseInt(input);
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

        if (playerCount < 2 || playerCount > 4)
        {
            out.println("Invalid input.");
            setup();
        }
        else
        {
            for (int i = 0; i < playerCount; i++)
            {
                players.add(new Player(stack, (i+1)));
            }
        }
    }

    private void run()
    {
        int winningScore = 0;
        String winner = "... no one! Everyone lost!";

        for (int i = 0; i < (players.size()); i++)
        {
            players.get(i).turn();
        }

        for (int i = 0; i < (players.size()); i++)
        {
            Player p = players.get(i);
            if (p.score < 22 && p.score > winningScore)
            {
                winningScore = p.score;
                winner = p.name;
            }
        }

        out.println("The winner is " + winner);
    }

    public void play()
    {
        setup();
        run();
    }
}
