import java.util.Scanner;

public class Game {

    final int x = 1;
    final int o = -1;
    char draw;
    int turn = 1;


    public int[][] gameBoard;

    public Game() {
        gameBoard = new int[3][3]; // Initialize the game board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.gameBoard[i][j] = 0;
            }
        }
    }

    public void seeValues() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(this.gameBoard[i][j]);
            }
        }
    }

    public void drawBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                if (gameBoard[i][j] == 0) {
                    draw = ' ';
                } else if (gameBoard[i][j] == 1) {
                    draw = 'X';
                } else if (gameBoard[i][j] == -1) {
                    draw = 'O';
                }
                System.out.print(" " + draw + " ");
                if (j < gameBoard[0].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < gameBoard.length - 1) {
                System.out.println("---|---|---");
            }
        }
    }

    public int[][] placeLetter(){


        Scanner scan_row = new Scanner(System.in);
        System.out.print("Which row: ");
        int _scan_row = scan_row.nextInt() - 1;

        Scanner scan_column = new Scanner(System.in);
        System.out.print("Which column: ");
        int _scan_column = scan_column.nextInt() - 1;

        if (gameBoard[_scan_row][_scan_column] == 0) {
            if (turn == 1) {
                gameBoard[_scan_row][_scan_column] = x;
                turn *= -1;
            }else if (turn == -1) {
                gameBoard[_scan_row][_scan_column] = o;
                turn *= -1;
            }
        } else {
            System.out.println("That cell is already occupied. Please try again.");
        }
        return gameBoard;
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2] && gameBoard[i][0] != 0)
                return true;
            if (gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i] && gameBoard[0][i] != 0)
                return true;
        }

        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != 0)
            return true;
        if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0] && gameBoard[0][2] != 0)
            return true;
        return false;
    }

}
