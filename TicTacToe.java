import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    char[][] board = new char[3][3];
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        board[row][col] = ' ';
      }
    }

    char player = 'X';
    boolean gameOver = false;
    Scanner scanner = new Scanner(System.in);
    int moveCount = 0; // This is to check if all the cell is filled

    while (!gameOver && moveCount < 9) {
      PrintBoard(board);
      int row, col;
      while (true) {
        System.out.print("Player " + player + ", enter row and column (0, 1, or 2): ");
        row = scanner.nextInt();
        col = scanner.nextInt();
        System.out.println();
        
        // Check if the cell is empty for insertion of user input
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
          if (board[row][col] == ' ') {
            break;
          } 
          else {
            System.out.println("Invalid move! Cell already occupied. Try again!");
          }
        }

        else {
          System.out.println("Invalid input! Row and column must be between 0 and 2. Try again!");
        }
      }

      board[row][col] = player;
      moveCount++;
      gameOver = HaveWon(board, player);
      
      if (gameOver) {
        System.out.println("Player " + player + " has won!");
      } 
      else if (moveCount == 9) {
        System.out.println("The game is a draw!");
      } 
      else {
        player = (player == 'X') ? 'O' : 'X';
      }
    }
    PrintBoard(board);
    scanner.close();
  }

  public static boolean HaveWon(char[][] board, char player) {
    
    // Checking row wise 
    for (int row = 0; row < board.length; row++) {
      if (board[row][0] == player && board[row][1] == player && board[row][2] == player) 
        return true;
    }

    // Checking column wise
    for (int col = 0; col < board[0].length; col++) {
      if (board[0][col] == player && board[1][col] == player && board[2][col] == player)
        return true;
    }

    //Checking the Diagonals
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }

    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
      return true;
    }

    return false;
  }

  public static void PrintBoard(char[][] board) {
    
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print(board[row][col]);
        if (col < board[row].length - 1) {
          System.out.print(" | ");
        }
      }
      System.out.println();
      if (row < board.length - 1) {
        System.out.println("---------");
      }
    }
  }
}
