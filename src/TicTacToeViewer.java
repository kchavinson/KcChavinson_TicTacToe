import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    private Image xImage;
    private Image oImage;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private TicTacToe t;
    private final int BOX_HEIGHT, FIRST_X, FIRST_Y, NUMBER_X, NUMBER_Y, NUMBER_Y_OFFSET, PRINT_WINNER_X, PRINT_WINNER_Y;

    public TicTacToeViewer(TicTacToe t) {

        this.xImage = new ImageIcon("Resources/X.png").getImage();
        this.oImage = new ImageIcon("Resources/O.png").getImage();

        this.t = t;

        FIRST_X = 200;
        FIRST_Y = 200;
        NUMBER_X = 250;
        NUMBER_Y = 150;
        NUMBER_Y_OFFSET = 15;
        PRINT_WINNER_X = 275;
        PRINT_WINNER_Y = 550;

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

    public void paint(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        for (int i = 0; i < 3; i++) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.drawString(Integer.toString(i), NUMBER_X + BOX_HEIGHT * i, NUMBER_Y); // Column numbers
            g.drawString(Integer.toString(i), NUMBER_Y - NUMBER_Y_OFFSET, NUMBER_X + BOX_HEIGHT * i); // Row numbers
            g.setColor(Color.BLACK);
            for (int j = 0; j < 3; j++) {
                Square sq = t.getBoard()[i][j];
                int x = i * BOX_HEIGHT + FIRST_X;
                int y = j * BOX_HEIGHT + FIRST_Y;

                g.drawRect(FIRST_X + BOX_HEIGHT * i, FIRST_Y + BOX_HEIGHT * j, BOX_HEIGHT , BOX_HEIGHT );
                if (sq.getMarker().equals("X")) {
                    g.drawImage(xImage,FIRST_X + BOX_HEIGHT * i, FIRST_Y + BOX_HEIGHT * j, BOX_HEIGHT, BOX_HEIGHT, this);
                } else if (sq.getMarker().equals("O")) {
                    g.drawImage(oImage,FIRST_X + BOX_HEIGHT * i, FIRST_Y + BOX_HEIGHT * j, BOX_HEIGHT, BOX_HEIGHT, this);
                }
                if (sq.isWinningSquare()) {
                    g.setColor(Color.GREEN); // Green transparent
                    g.fillRect(i * BOX_HEIGHT + FIRST_X, j * BOX_HEIGHT + FIRST_Y,
                            BOX_HEIGHT, BOX_HEIGHT);
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
                    g.drawString("O wins!", PRINT_WINNER_X , PRINT_WINNER_Y);
                }

            }
        }
    }
}