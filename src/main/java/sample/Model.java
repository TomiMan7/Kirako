package sample;

/**
 * This class creates the end game statistics for Kirako
 */
public class Model {

    /**Keeps track how many steps were made.*/
    static int stepCount = 0;

    /**Stores the time the game was started.*/
    static long gameTime =0;

    /**The matrix representation for the numbers on the buttons.*/
    static int[] finish = new int[9];

    /**
     * Handles the text switches on the button when a valid step is made.
     * @param pressedButtonText0 the text on the first button.
     * @param pressedButtonText1 the text on the second button.
     * @param buttonId the id of the first button.
     * @param buttonId2 the id of the second button.
     * @return finish the matrix representation behind the buttons
     */
    public static int[] GombCsere(String pressedButtonText0, String pressedButtonText1, String buttonId, /*Button button*/String buttonId2) {
    String temp;
    temp = String.valueOf(finish[Integer.valueOf(/*button.getId()*/buttonId2)]);
    finish[Integer.valueOf(buttonId2/*button.getId() */)] = Integer.valueOf(pressedButtonText0);
    finish[Integer.valueOf(buttonId)] = Integer.valueOf(temp);

    return finish;
}

    /**
     * Handles the creation of {@code gamestat} for the end game (still not that end game) screen.
     * @return {@code gamestat} the value of {@code gameTime} / {@code stepCount}, showing the average time between steps.
     * @param gameTime time passed in ns.
     * @param stepCount steps made.
     */
    public static double GameStat(long gameTime, int stepCount)
    {
        return Math.floor((gameTime /1_000_000_000.0 / 1000.0 /(double)stepCount) * 100) /10; //ms to s
    }

}
