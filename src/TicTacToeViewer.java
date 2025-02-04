import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    private Image xImage;
    private Image oImage;
    private Image jfImage;

    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private TicTacToe t;
    private final int BOX_HEIGHT, NUMBER_X, NUMBER_Y, PRINT_WINNER_X, PRINT_WINNER_Y, NUMBER_Y_OFFSET, NUMBER_X_OFFSET;

    public TicTacToeViewer(TicTacToe t) {

        this.xImage = new ImageIcon("Resources/X.png").getImage();
        this.oImage = new ImageIcon("Resources/O.png").getImage();
        this.jfImage = new ImageIcon("Resources/Jf.png").getImage();

        this.t = t;

        NUMBER_X = 145;
        NUMBER_Y = 75;
        NUMBER_Y_OFFSET = 10;
        NUMBER_X_OFFSET = 20;
        PRINT_WINNER_X = 200;
        PRINT_WINNER_Y = 450;

        BOX_HEIGHT = 100;


        // Setup the window and the buffer strategy.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image getxImage() {
        return xImage;
    }

    public Image getoImage() {
        return oImage;
    }

    public Image getJfImage() {
        return jfImage;
    }

    public void paint(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        for (int i = 0; i < 3; i++) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.drawString(Integer.toString(i), NUMBER_X + BOX_HEIGHT * i, NUMBER_Y); // Column numbers
            g.drawString(Integer.toString(i), NUMBER_Y - NUMBER_X_OFFSET,
                    NUMBER_X + BOX_HEIGHT * i + NUMBER_Y_OFFSET); // Row numbers
            g.setColor(Color.BLACK);
            for (int j = 0; j < 3; j++) {
                Square sq = t.getBoard()[j][i];
                sq.draw(i, j, g);
            }
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 30));

        if(t.checkTie())
        {
            g.drawString("Cat's Game", PRINT_WINNER_X , PRINT_WINNER_Y);
        }
        else if (t.getWinner().equals("X"))
        {
            g.drawString("X Wins!", PRINT_WINNER_X , PRINT_WINNER_Y);
        }
        else if (t.getWinner().equals("O"))
        {
            g.drawString("O Wins!", PRINT_WINNER_X , PRINT_WINNER_Y);
        }
    }
}
