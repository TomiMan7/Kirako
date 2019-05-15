package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import org.dom4j.rule.Mode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Controller class provides methods for Main.java to handle the events in {@code primaryStage}.
 */
public class Controller extends Main {

    /**
     * Constructor for Controller
     */
    public Controller()
    {}

    /**
     * ButtonShuffle takes care of the randomization of the numbers on the buttons.
     * Also keeps track of time played in {@code gameTime}.
     * Resets {@code stepCount} in case a player starts a new game.
     * Sets the value of {@code setCountLabel}.
     * Sets the values of {@code button0} to {@code button8}
     */
    public static void ButtonShuffle()
    {
        Model.gameTime = System.nanoTime();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< 9; i++)
            list.add(i);

        Collections.shuffle(list);

        for(int i = 0; i<9; i++)
            Model.finish[i] = list.get(i);

        Model.stepCount = 0;

        stepCountLabel.setText("Step counter: ");
        button0.setText(String.valueOf(list.get(0)));
        button1.setText(String.valueOf(list.get(1)));
        button2.setText(String.valueOf(list.get(2)));
        button3.setText(String.valueOf(list.get(3)));
        button4.setText(String.valueOf(list.get(4)));
        button5.setText(String.valueOf(list.get(5)));
        button6.setText(String.valueOf(list.get(6)));
        button7.setText(String.valueOf(list.get(7)));
        button8.setText(String.valueOf(list.get(8)));

        Main.logger.info("New game has been started.");
    }

    /**
     * Handles the events when the Info button is pressed. Shows a popup window with informations regarding the game.
     */
    public static void Sugo()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeight(300);
        alert.setContentText("Use the '0' tile to move. Your goal is to move the numbers into order from 1-8-0 moving the '0' tile.\n" +
                "You can only move one tile at a time. Cannot move diagonally.\n" +
                "Click on a tile You wanna move then click on a tile where You wanna move it.");

        alert.showAndWait();
    }

    /**
     * Handles saving of the current state of the game.
     * Calculates the time passed since the start of the game into the variable {@code currgametime}.
     * After getting the correct values for {@code finish} {@code stepCount} and {@code currgametime} writes these datas to a json file.
     *
     * @param finish is the matrix representation of the values found on the buttons.
     * @param stepCount is the value of {@code stepCountLabel} showing how many steps have been made.
     * @param gameTime is the time passed since the start of the game.
     * @param main is an instance of Main used to save the games state.
     * @throws IOException throws exceptions.
     */
    public static void Mentes(int[] finish, int stepCount, long gameTime, Main main) throws IOException
    {
        long currgametime = System.nanoTime();

        main.setNonStaticfinish(finish);
        main.setNonStaticstepCount(stepCount);
        main.setNonStaticgameTime(currgametime - gameTime);

        fc.setDialogTitle("Save");
        fc.showSaveDialog(null);
        fc.requestFocus(true);

        String file = fc.getSelectedFile().getAbsolutePath();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter writer = new FileWriter(file+".json");

        gson.toJson(main,writer);

        writer.close();
    }

    /**
     * Handles loading the game from a saved state using a correctly saved json file.
     * Sets the values of {@code finish} {@code gameTime} {@code stepCountLabel} {@code stepCount} and {@code button0} to {@code button8} to the correct value.
     * @param main is an instance of Main used to save the games state.
     * @throws FileNotFoundException throws exceptions.
     */
    public static void Betoltes(Main main) throws FileNotFoundException
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        fc.setDialogTitle("Load");
        fc.showOpenDialog(null);
        fc.requestFocus(true);

        String file = fc.getSelectedFile().getAbsolutePath();

        main = gson.fromJson(new FileReader(file), Main.class);

        Model.finish = main.getNonStaticfinish();
        Model.gameTime = main.getNonStaticgameTime();

        stepCountLabel.setText("Step counter: " + main.getNonStaticstepCount());
        Model.stepCount = main.getNonStaticstepCount();

        button0.setText(String.valueOf(Model.finish[0]));
        button1.setText(String.valueOf(Model.finish[1]));
        button2.setText(String.valueOf(Model.finish[2]));
        button3.setText(String.valueOf(Model.finish[3]));
        button4.setText(String.valueOf(Model.finish[4]));
        button5.setText(String.valueOf(Model.finish[5]));
        button6.setText(String.valueOf(Model.finish[6]));
        button7.setText(String.valueOf(Model.finish[7]));
        button8.setText(String.valueOf(Model.finish[8]));
    }


//    public static void Csere(String pressedButtonText0, String pressedButtonText1, String buttonId, Button button)
//    {
//        buttonPressCount = 0;
//        stepCountLabel.setText("Step counter: " + ++Model.stepCount);
//
//        if( Math.abs( Integer.valueOf(buttonId) - Integer.valueOf(button.getId()) ) == 1 ||  Math.abs( Integer.valueOf(buttonId) - Integer.valueOf(button.getId()) ) == 3)
//        {
//            if (pressedButtonText0.equals("0") || pressedButtonText1.equals("0")) {
//
//                String temp;
//                temp = String.valueOf(finish[Integer.valueOf(button.getId())]);
//                finish[Integer.valueOf(button.getId())] = Integer.valueOf(pressedButtonText0);
//                finish[Integer.valueOf(buttonId)] = Integer.valueOf(temp);
//
//                button.setText(pressedButtonText0);
//
//                if (button0.getId() == buttonId)
//                    button0.setText(pressedButtonText1);
//
//                if (button1.getId() == buttonId)
//                    button1.setText(pressedButtonText1);
//
//                if (button2.getId() == buttonId)
//                    button2.setText(pressedButtonText1);
//
//                if (button3.getId() == buttonId)
//                    button3.setText(pressedButtonText1);
//
//                if (button4.getId() == buttonId)
//                    button4.setText(pressedButtonText1);
//
//                if (button5.getId() == buttonId)
//                    button5.setText(pressedButtonText1);
//
//                if (button6.getId() == buttonId)
//                    button6.setText(pressedButtonText1);
//
//                if (button7.getId() == buttonId)
//                    button7.setText(pressedButtonText1);
//
//                if (button8.getId() == buttonId)
//                    button8.setText(pressedButtonText1);
//
//                Win();
//            }
//            else {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Invalid step!");
//                alert.setContentText("You can't move diagonally, or use the '0' tile to move!");
//                Main.logger.error("Invalid step made");
//                alert.showAndWait();
//            }
//        }
//        else{
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Invalid step!");
//            alert.setContentText("You can't move diagonally, or use the '0' tile to move!");
//            Main.logger.error("Invalid step made");
//
//            alert.showAndWait();
//        }
//    }
    /**
     * Calls Model.GombCsere() to handle the switch on the buttons, checks if a win condition is present. Also warns if an invalid step has been made.
     * Resets {@code buttonPressCount}.
     * Sets {@code stepCountLabel} to the correct value.
     *
     * @param pressedButtonText0 is the value on the first pressed button
     * @param pressedButtonText1 is the value on the second pressed button
     * @param buttonId is the first pressed button ID.
     * @param buttonId2 is the second button itself.
     */
    public static void Csere(String pressedButtonText0, String pressedButtonText1, String buttonId, /*Button button*/String buttonId2)
    {
        buttonPressCount = 0;
        stepCountLabel.setText("Step counter: " + ++Model.stepCount);

        if( Math.abs( Integer.valueOf(buttonId) - Integer.valueOf(buttonId2/*button.getId()*/) ) == 1 ||  Math.abs( Integer.valueOf(buttonId) - Integer.valueOf(/*button.getId()*/buttonId2) ) == 3)
        {
            if (pressedButtonText0.equals("0") || pressedButtonText1.equals("0")) {

                Model.GombCsere(pressedButtonText0, pressedButtonText1, buttonId, buttonId2);
//                String temp;
//                temp = String.valueOf(finish[Integer.valueOf(/*button.getId()*/buttonId2)]);
//                finish[Integer.valueOf(buttonId2/*button.getId() */)] = Integer.valueOf(pressedButtonText0);
//                finish[Integer.valueOf(buttonId)] = Integer.valueOf(temp);

//                button.setText(pressedButtonText0);

                if (button0.getId() == buttonId2)
                    button0.setText(pressedButtonText0);

                if (button1.getId() == buttonId2)
                    button1.setText(pressedButtonText0);

                if (button2.getId() == buttonId2)
                    button2.setText(pressedButtonText0);

                if (button3.getId() == buttonId2)
                    button3.setText(pressedButtonText0);

                if (button4.getId() == buttonId2)
                    button4.setText(pressedButtonText0);

                if (button5.getId() == buttonId2)
                    button5.setText(pressedButtonText0);

                if (button6.getId() == buttonId2)
                    button6.setText(pressedButtonText0);

                if (button7.getId() == buttonId2)
                    button7.setText(pressedButtonText0);

                if (button8.getId() == buttonId2)
                    button8.setText(pressedButtonText0);

                if (button0.getId() == buttonId)
                    button0.setText(pressedButtonText1);

                if (button1.getId() == buttonId)
                    button1.setText(pressedButtonText1);

                if (button2.getId() == buttonId)
                    button2.setText(pressedButtonText1);

                if (button3.getId() == buttonId)
                    button3.setText(pressedButtonText1);

                if (button4.getId() == buttonId)
                    button4.setText(pressedButtonText1);

                if (button5.getId() == buttonId)
                    button5.setText(pressedButtonText1);

                if (button6.getId() == buttonId)
                    button6.setText(pressedButtonText1);

                if (button7.getId() == buttonId)
                    button7.setText(pressedButtonText1);

                if (button8.getId() == buttonId)
                    button8.setText(pressedButtonText1);

                Win();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid step!");
                alert.setContentText("You can't move diagonally, or use the '0' tile to move!");
                Main.logger.error("Invalid step made");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid step!");
            alert.setContentText("You can't move diagonally, or use the '0' tile to move!");
            Main.logger.error("Invalid step made");

            alert.showAndWait();
        }
    }

    /*
    * Adjust this function to lower the win threshold
    * */
    /**
     * Checks if a win condition is presented on the buttons. If so it sets the values on {@code button0} to {@code button8} to the correct value. Shows the end game(not that end game) screen with some statistics
     */
    public static void Win()
    {
        int win = 0;

        for(int i = 0; i < /*finish.length - 1*/2; i++) //adjust this for lowering the win threshold
            if(Model.finish[i] == i+1)
                win++;

        if(win == /*finish.length - 1*/2) //adjust this for lowering the win threshold
        {        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You won!");
            alert.setHeight(150);
            alert.setContentText("You won! Steps needed: " + Model.stepCount + "\nAvarage sec. between steps: " + Model.GameStat(Model.gameTime,Model.stepCount));
//            System.out.println(Model.gameTime); //prints the exact time that it took to finish the game
//            System.out.println(Model.GameStat(Model.gameTime,Model.stepCount));
            button0.setText("You won!");
            button1.setText("You won!");
            button2.setText("You won!");
            button3.setText("You won!");
            button4.setText("You won!");
            button5.setText("You won!");
            button6.setText("You won!");
            button7.setText("You won!");
            button8.setText("You won!");

            alert.showAndWait();
        }
    }
    /*Just for testing purposes*/
//    public static double asd(int a, int b){return a+b;}
}