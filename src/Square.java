import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    private final int BOX_HEIGHT, FIRST_X, FIRST_Y;
    private TicTacToeViewer t;


    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer t) {
        this.row = row;
        this.col = col;
        this.t = t;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;

        FIRST_X = 100;
        FIRST_Y = 100;

        BOX_HEIGHT = 100;

    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    public boolean isWinningSquare() {
        return isWinningSquare;
    }
    public void draw(int i, int j, Graphics g)
    {
        int x = i * BOX_HEIGHT + FIRST_X;
        int y = j * BOX_HEIGHT + FIRST_Y;

        g.drawRect(FIRST_X + BOX_HEIGHT * i, FIRST_Y + BOX_HEIGHT * j, BOX_HEIGHT , BOX_HEIGHT);
        if (this.isWinningSquare()) {
            g.setColor(Color.GREEN); // Green transparent
            g.fillRect(i * BOX_HEIGHT + FIRST_X, j * BOX_HEIGHT + FIRST_Y,
                    BOX_HEIGHT, BOX_HEIGHT);
        }
        if (this.getMarker().equals("X")) {
            g.drawImage(t.getJfImage(),FIRST_X + BOX_HEIGHT * i, FIRST_Y + BOX_HEIGHT * j, BOX_HEIGHT, BOX_HEIGHT, t);
        } else if (this.getMarker().equals("O")) {
            g.drawImage(t.getoImage(),FIRST_X + BOX_HEIGHT * i, FIRST_Y + BOX_HEIGHT * j, BOX_HEIGHT, BOX_HEIGHT, t);
        }


    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
}
