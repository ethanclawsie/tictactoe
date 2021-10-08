
// Tic Tac Toe
import java.util.*;

class Main {
    public static char playAgain() {

        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.print("Do you want to play again (Y,y)?  ");

        String answer = input.nextLine().toUpperCase();

        if (answer.equals("Y")) {
            return 'Y';
        }
        System.out.println();

        return 'N';
    }

    public static boolean isWinner(char[][] board, char player) {

        for (int r = 0; r < board.length; r++) {
            if (board[r][0] == player && board[r][1] == player && board[r][2] == player) {
                return true;
            }
        }

        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == player && board[1][c] == player && board[2][c] == player) {
                return true;
            }

        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void resetBoard(char[][] board) {

        for (int r = 0; r < board.length; r++) {

            for (int c = 0; c < board[0].length; c++) {

                board[r][c] = '-';
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println();

        for (int r = 0; r < 3; r++) {
            System.out.print("row " + (r + 1) + " ");

            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c]);
            }

            System.out.println();
        }

        System.out.println();
    }

    public static char makeMove(char[][] board, char player) {

        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(player + ", it is your turn.");
                System.out.print("Enter the row and column (Ex: 1 2 or 12 or Q to quit): ");

                String inputRC = input.nextLine().toUpperCase();

                if (inputRC.equals("Q")) {
                    return 'Q';
                }

                int r = -1;
                int c = -1;

                if (inputRC.length() == 2) {

                    r = inputRC.charAt(0) - 48 - 1;
                    c = inputRC.charAt(1) - 48 - 1;
                } else {

                    String[] rc = inputRC.split("\\s+");

                    r = Integer.parseInt(rc[0]) - 1;
                    c = Integer.parseInt(rc[1]) - 1;
                }

                if (!(r <= 2 && r >= 0) || !(c <= 2 && c >= 0)) {
                    System.out.println(player + ", your row or column is not correct.");
                }

                else if (board[r][c] == '-') {
                    board[r][c] = player;
                    printBoard(board);
                    break;
                } else {
                    System.out.println(player + ", you have to play on an empty space (-).");
                }
            } catch (Exception e1) {
                System.out.println(player + ", you have an entry problem.  Off the board issue.");
            }
        }
        return 'C';
    }

    public static boolean checkForWinner(char[][] board, char player) {

        if (isWinner(board, player)) {
            System.out.println(player + ", you are the winner!!!");
            System.out.println();
            System.out.println();

            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("Hello!");
        System.out.println();


        System.out.println("Valid positions are 1..3 for the row and the column");
        System.out.println();
        System.out.println();

        char[][] board = new char[3][3];

        resetBoard(board);

        printBoard(board);

        System.out.println();

        char player1 = 'X';
        char player2 = 'O';

        while (true) {
            System.out.println();

            char ch = makeMove(board, player1);

            if (ch == 'q') {
                break;
            }

            if (checkForWinner(board, player1)) {
                if (playAgain() == 'N') {
                    break;
                } else {

                    resetBoard(board);

                    printBoard(board);

                    continue;
                }
            }

            ch = makeMove(board, player2);

            if (ch == '2') {
                break;
            }

            if (checkForWinner(board, player2)) {
                if (playAgain() == 'N') {
                    break;
                } else {

                    resetBoard(board);

                    printBoard(board);

                    continue;
                }
            }

        }

        System.out.println();
        System.out.println("Thanks for playing tic tac toe!!!");
        System.out.println();

    }

}
