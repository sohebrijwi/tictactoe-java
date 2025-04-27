import java.util.Random;
import java.util.Scanner;

class TicTacToe {

    static char[][] board;

    public TicTacToe() {
        board = new char[3][3];
        initboard();
    }

    void initboard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

     static void dispboard() {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    static void Placemark(int row, int col, char mark) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3){
            board[row][col] = mark;
        } else {
            System.out.println("invalid position");
        }
    }
    static boolean checkcolwin(){
        for (int j = 0; j < 3; j++ ){
            if (board[0][j] != ' ' &&   board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }
    static boolean checkrowwin(){
        for (int i = 0; i < 3; i++ ){
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }
    static boolean checkdiagonalwin(){
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }
    static boolean isBoardFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
}

abstract class Player{
    String name;
    char mark;

    abstract void makeMove();

    boolean isValidMove( int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 ) {
            if (TicTacToe.board[row][col] == ' ') {
                return true;
                
            }
        }
        return false;
    }
}
 class HumanPlayer extends Player {
    
     HumanPlayer(String name,char mark) {
        this.name = name;
        this.mark = mark;
    }
    void makeMove() {
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
            do {
                System.out.println("Enter row and col");
                row = scan.nextInt();
                col = scan.nextInt();
            } while (!isValidMove(row, col));
            TicTacToe.Placemark(row, col, mark);
        } 
}

class AIPlayer extends Player {

    AIPlayer(String name,char mark) {
        this.name = name;
        this.mark = mark;
    }
    void makeMove() {
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
            do {
                System.out.println("Enter row and col");
                Random r = new Random();
                row = r.nextInt(3);
                col = r.nextInt(3);
            } while (!isValidMove(row, col));
            TicTacToe.Placemark(row, col, mark);
        }
}

public class LounchGame {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        HumanPlayer p1 = new HumanPlayer("Bob", 'X');
        AIPlayer p2 = new AIPlayer("AI", 'O');
        Player cp;
        cp = p1;
        while (true) {
            System.out.println(cp.name + " turn");
        cp.makeMove();
        TicTacToe.dispboard();
        if (TicTacToe.checkcolwin() || TicTacToe.checkrowwin() || TicTacToe.checkdiagonalwin()) {
            System.out.println(cp.name + " wins");
            break;           
        } else if (TicTacToe.isBoardFull()) {
            System.out.println("It's a tie"); 
            break;
        } else {
            if (cp == p1) {
                cp = p2;
            } else {
                cp = p1;
            }
        }
        }        
    }
}
