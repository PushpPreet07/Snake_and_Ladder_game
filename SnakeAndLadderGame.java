import java.util.Random;

public class SnakeAndLadderGame {
    // Constants for board size and winning position
    private static final int BOARD_SIZE = 100;
    private static final int WINNING_POSITION = 100;

    // Arrays to represent snakes and ladders
    private static final int[] SNAKES = {16, 47, 49, 56, 62, 64, 87, 93, 95, 98};
    private static final int[] LADDERS = {1, 4, 9, 21, 28, 36, 51, 71, 80};

    public static void main(String[] args) {
        System.out.println("WELCOME TO SNAKE AND LADDERS GAME");
        SnakeAndLadderGame game = new SnakeAndLadderGame();

        game.playGame();
    }

    /*
     @desc-Method to simulate the game
     */
    private void playGame() {
        int position = 0;
        int diceValue;
        int newPosition=0;
        diceValue = rollDice();
        System.out.println("Dice rolled: " + diceValue);
        int option = checkOption();
            
            switch (option) {
                case 1:
                    System.out.println("No Play. Player stays in the same position.");
                    break;
                case 2:
                    newPosition = position + diceValue;
                    newPosition = handleSnakeAndLadder(newPosition);
                    System.out.println("Ladder. Player moves ahead by " + diceValue + " positions.");
                    break;
                case 3:
                    newPosition = position - diceValue;
                    newPosition = handleSnakeAndLadder(newPosition);
                    System.out.println("Snake. Player moves behind by " + diceValue + " positions.");
                    break;
            }
        position = newPosition;
    }
    /*
     @desc-Method to simulate the game
     @param-None
     @return-random number between 1-6
     */
    private int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
    /*
     @desc-Simulate the player's choice using random numbers
     @param-None
     @return-random number between 1-3
     */
    private int checkOption() {
        Random random = new Random();
        return random.nextInt(3) + 1; // 1 for No Play, 2 for Ladder, 3 for Snake
    }
     /*
     @desc-Handle snakes and ladders as before
     @param-(int position, int numberOnDice)
     @return-random number between 1-3
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

}
