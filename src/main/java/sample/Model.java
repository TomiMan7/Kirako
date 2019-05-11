package sample;

/**
 * This class creates the end game statistics for Kirako
 */
public class Model {

    /**Keeps track how many steps were made.*/
    static int stepCount = 0;

    /**Stores the time the game was started.*/
    static long gameTime =0;


    /**
     * Handles the creation of {@code gamestat} for the end game (still not that end game) screen.
     * @return {@code gamestat} the value of {@code gameTime} / {@code stepCount}, showing the average time between steps.
     * @param gameTime time passed in ns.
     * @param stepCount steps made.
     */
    public static double GameStat(long gameTime, int stepCount)
    {
        return Math.floor((gameTime /1_000_000_000.0 / 1000.0 /(double)stepCount) * 100) /1000; //ms to s
    }

}
