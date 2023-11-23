import java.util.Random;

public class SnakeAndLadderGame {

    private static final int BOARD_SIZE = 100;
    private static final int WINNING_POSITION = 100;

    private static final int[] SNAKES = {16, 47, 49, 56, 62, 64, 87, 93, 95, 98};
    private static final int[] LADDERS = {1, 4, 9, 21, 28, 36, 51, 71, 80};

    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game!");

        SnakeAndLadderGame game = new SnakeAndLadderGame();
        game.playGame();
    }
     /*
     @desc-Method to simulate the game
     */
    private void playGame() {
        int player1Position = 0;
        int player2Position = 0;
        int diceValue;
        int newPosition;

        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
            // Player 1's turn
            System.out.println("\nPlayer 1's Turn:");
            diceValue = rollDice();
            System.out.println("Dice rolled: " + diceValue);
            newPosition = handleTurn(player1Position, diceValue);
            player1Position = newPosition;
            reportPosition("Player 1", player1Position);

            // Check if Player 1 got a ladder and can play again
            if (newPosition == handleSnakeAndLadder(newPosition)) {
                System.out.println("Player 1 got a ladder and plays again!");
                continue;
            }

            // Player 2's turn
            System.out.println("\nPlayer 2's Turn:");
            diceValue = rollDice();
            System.out.println("Dice rolled: " + diceValue);
            newPosition = handleTurn(player2Position, diceValue);
            player2Position = newPosition;
            reportPosition("Player 2", player2Position);

            // Check if Player 2 got a ladder and can play again
            if (newPosition == handleSnakeAndLadder(newPosition)) {
                System.out.println("Player 2 got a ladder and plays again!");
                continue;
            }
        }

        // Report the winner
        if (player1Position >= WINNING_POSITION) {
            System.out.println("\nPlayer 1 wins!");
        } else {
            System.out.println("\nPlayer 2 wins!");
        }
    }
     /*
     @desc-Method to roll dice
     @param-None
     @return-random number between 1-6
     */
    private int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
    /*
     @desc-Handle turns for player 1 and 2
     @param-(int position)
     @return-position of selected player
     */
    private int handleTurn(int position, int diceValue) {
        int newPosition = position + diceValue;
        return handleSnakeAndLadder(newPosition);
    }
/*
     @desc-Handle snakes and ladders as before
     @param-(int position)
     @return-]position of player
     */
    private int handleSnakeAndLadder(int position) {
        for (int snake : SNAKES) {
            if (position == snake) {
                return position - 10;
            }
        }

        for (int ladder : LADDERS) {
            if (position == ladder) {
                return position + 10;
            }
        }

        return position;
    }
    /*
     @desc-Tells about the current game stats
     @param-(string playerName,int position)
     @return-prints game state
     */
    private void reportPosition(String playerName, int position) {
        System.out.println(playerName + "'s New Position: " + position);
    }
}
