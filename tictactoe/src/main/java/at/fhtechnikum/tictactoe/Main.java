package at.fhtechnikum.tictactoe;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            Game game = new Game();

            while(!game.hasWinner() && !game.isDraw()) {
                System.out.println("\nCurrent player: " + game.getCurrentPlayer().getMarker() + "\n");
                try {
                    System.out.print("Enter row (0-2): ");
                    int row = scanner.nextInt();

                    System.out.print("Enter column (0-2): ");
                    int col = scanner.nextInt();

                    if (row < 0 || row > 2 || col < 0 || col > 2) {
                        System.out.println("Invalid input! Row and column must be between 0 and 2.");
                        continue;
                    }

                    game.makeMove(row, col);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid move: " + e.getMessage() + "\n");
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter numbers between 0 and 2.\n");
                    scanner.nextLine();
                }
            }
            scanner.nextLine();
            System.out.println();
            System.out.print("Play again? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("y")) {
                playAgain = false;
            }
        }
        scanner.close();
        System.out.println("Thanks for playing.");

    }
}