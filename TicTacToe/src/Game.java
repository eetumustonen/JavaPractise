import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};

        System.out.println("Welcome to Tic Tac Toe!\n" +
                           "The goal of the game is to get three X's in a row horizontally, vertically or diagonally in a 3x3 board.\n" +
                           "The opponent is trying to stop you and get their own three symbols (this symbol is 'O') in a row, in which case you'll lose.\n" +
                           "You'll take turns until either one wins or the board is full and the game ends in a tie.\n" +
                           "The board is numbered 1-9 like such:\n" +
                           "1|2|3\n" +
                           "-+-+-\n" +
                           "4|5|6\n" +
                           "-+-+-\n" +
                           "7|8|9\n" +
                           "So as your input give the corresponding number to the cell you want to place your X.\n" +
                           "Good luck!\n");
        Scanner scanner = new Scanner(System.in);
        printBoard(board);
        while(true){
            playerTurn(board, scanner);
            printBoard(board);
            if(gameOver(board)){
                break;
            }
            computerTurn(board);
            printBoard(board);
            if(gameOver(board)){
                break;
            }
        }
        scanner.close();
    }

    private static boolean gameOver(char[][] board) {
        if (hasContestantWon(board, 'X')) {
            System.out.println("Player wins!");
            return true;
        }
        if (hasContestantWon(board, 'O')) {
            System.out.println("Computer wins!");
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        System.out.println("The game ended in a tie!");
        return true;
    }

    private static boolean hasContestantWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
            (board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
            (board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||

            (board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
            (board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
            (board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||

            (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
            (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
            return true;
        }
        return false;
    }

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerPlay;
        while(true){
            computerPlay = rand.nextInt(9) + 1;
            if(checkValidity(board, Integer.toString(computerPlay))){
                placeMove(board, Integer.toString(computerPlay), 'O');
                System.out.println("Computer played " + computerPlay);
                break;
            }
        }
    }

    private static boolean checkValidity(char[][] board, String cell) {
        switch(cell) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }


    private static void playerTurn(char[][] board, Scanner scanner) {
        String userInput;
        while(true){
            System.out.println("Where would you like to play?");
            userInput = scanner.nextLine();
            if(checkValidity(board, userInput)){
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
            placeMove(board, userInput, 'X');
    }

    private static void placeMove(char[][] board, String position, char symbol) {
        switch(position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println(":(");
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
}