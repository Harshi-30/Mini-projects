import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
   static String []board; 
   static String turn;

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for(int a =0;a < board.length;a++){
            board[a]=String.valueOf(a+1);
        }

        System.out.println("Welcome to Tic Tac Toe game!!");
        printBoard();
        System.out.println("X will play first");

        while( winner == null){
            int numInput ;

            try {
                numInput = src.nextInt();
                if(!(numInput > 0 && numInput <= 9)){
                    System.out.println("Invalid input; pleas re-enter slot number: ");
                    continue;
                }
                if(board[numInput-1].equals(String.valueOf(numInput))){
                    board[numInput-1] = turn;
                

                turn = turn.equals("X")?"0":"X";

                printBoard();
                winner = checkWinner();
            }else{
                System.out.println("Slot already taken; re-enter sloat number:");
            }
        }catch(InputMismatchException e){
            System.out.println("Tnvalid input; re-enter sloat number:");
            src.nextLine();
        }

        }
        if(winner.equalsIgnoreCase("draw")){
            System.out.println("It's a draw1 Thanks for playing.");
        }else{
            System.out.println("Congratulation!"+winner+"'s have won!Thanku for playing");
        }
    
    }
    static String checkWinner(){
        for(int a = 0;a<8;a++){
            String line = null;
            switch(a){
                case 0:
                line =board[0]+board[1]+board[2];
                break;

                case 1:
                line =board[3]+board[4]+board[5];
                break;
            

                case 2:
                line =board[6]+board[7]+board[8];
                break;
            

                case 3:
                line =board[0]+board[4]+board[8];
                break;
            

                case 4:
                line =board[2]+board[4]+board[6];
                break;
            

                case 5:
                line =board[0]+board[3]+board[6];
                break;
            
                case 6:
                line =board[1]+board[4]+board[7];
                break;
            

                case 7:
                line =board[2]+board[5]+board[8];
                break;
            
            }
            if(line.equals("XXX")){
                return "X";
            }else if(line.equals("000")){
                return "0";
            }
        }

        for(int a = 0;a<9;a++){
            if(Arrays.asList(board).contains(String.valueOf(a+1))){
                break;
            }else if(a == 8){
                return"draw";
            }
            
        }
        System.out.println(turn + "'s trun;enter a sloat number to place"+turn+"in;");
        return null;
    }
    public static void printBoard(){
        System.out.println("|---|---|---|");
        System.out.println("| "+board[0]+" | "+board[1]+" | "+board[2]+" |");

        System.out.println("|---|---|---|");
        System.out.println("| "+board[3]+" | "+board[4]+" | "+board[5]+" |");
    
        System.out.println("|---|---|---|");
        System.out.println("| "+board[6]+" | "+board[7]+" | "+board[8]+" |");
        System.out.println("|---|---|---|");
    
    }
}
