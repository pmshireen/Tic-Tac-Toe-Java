import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[][] board = new char[3][3];
        for(int row = 0;row < board.length;row++){
            for(int col = 0;col< board.length;col++){
                board[row][col] =' ';
            }
        }
        // To get input
        // lets say the first player is X
        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);


        while(!gameOver){
            //first we have to print the board
            Main.printboard(board);
            System.out.println("Player "+player+"enter: ");
            //Get the co-ordinate
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            //check whether the given co-ordinate is empty or not
            if(board[row][col] == ' '){
                //place the element
                board[row][col] = player;
                gameOver = haveWon(board,player);
                if(gameOver){                                            // if game is over
                    System.out.println("Player "+player+"has Won: ");
                }else{
                    if(player == 'X'){
                        player = 'O';
                    }else{
                        player = 'X';
                    }
                }
              //  player = (player == 'X')? 'O':'X';

            }else{
                System.out.println("Invalid Move. Try Again !");
            }
        }
        printboard(board);
    }
    public static boolean haveWon(char[][] board,char player){
        // we need to check the diagnols , rows and cols

        // check the row
        for(int row = 0;row < board.length;row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                 return true;
            }
        }

        // check for columns
        for(int col = 0;col < board[0].length;col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        //diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }

         return false;
    }

    public static void printboard(char[][] board){
        for(int row = 0;row < board.length;row++){
            for(int col = 0;col< board.length;col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}