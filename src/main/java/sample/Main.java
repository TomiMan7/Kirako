package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Arrays;

/**
 * Handles the GUI for Kirako.
 * @author Löki Tamás
 * @version 1.0
 * @since forever
 * */
public class Main extends Application implements EventHandler<ActionEvent> {

    /** FileChooser for saving and loading the game.*/
    static final JFileChooser fc = new JFileChooser();
    /**Label for showing how many steps were made.*/
    static Label stepCountLabel = new Label("Step counter: ");
    /**The matrix representation for the numbers on the buttons.*/
    static int[] finish = new int[9];
    /**Used to save the game status into json.*/
    int[] nonStaticfinish = new int[9];
    /**Used to save the game time into json.*/
    long nonStaticgameTime = 0;
    /**Stores the time the game was started.*/
    static long gameTime = 0;

    /**Keeps track how many button presses were made between steps.*/
    static int buttonPressCount = 0;
    /**Keeps track how many steps were made.*/
    static int stepCount = 0;
    /**Used to save the game step count into json.*/
    int nonStaticstepCount = 0;
    /**Stores witch button was pressed.*/
    static String pressedButtonText0 = "9";
    /**Stores witch button was pressed second.*/
    static String pressedButtonText1 = "9";

    /**Stores the first pressed buttons ID.*/
    static String buttonId;
    /**Button for starting a new game.*/
    static Button newGame = new Button("New Game!");
    /**Button for representing a number.*/
    static Button button0 = new Button("Press\nNew Game");
    /**Button for representing a number.*/
    static Button button1 = new Button("Press\nNew Game");
    /**Button for representing a number.*/
    static Button button2 = new Button("Press\nNew Game");
    /**Button for representing a number.*/
    static Button button3 = new Button("Press\nNew Game");
    /**Button for representing a number.*/
    static Button button4 = new Button("Press\nNew Game");
    /**Button for representing a number.*/
    static Button button5 = new Button("Press\nNew Game");
    /**Button for representing a number.*/
    static Button button6 = new Button("Press\nNew Game");
    /**Button for representing a number.*/
    static Button button7 = new Button("Press\nNew Game");
    /**Button for representing a number.*/
    static Button button8 = new Button("Press\nNew Game");

    /**Constructor.*/
    public Main()
    {}

    /**
     * Getter for the game time used to save the game time.
     * @return nonStaticgameTime the passed game time.
     */
    long getNonStaticgameTime() {
        return nonStaticgameTime;
    }

    /**
     * Setter for the game  time used to save the game time.
     * @param nonStaticgameTime the passed game time.
     */
    void setNonStaticgameTime(long nonStaticgameTime) {
        this.nonStaticgameTime = nonStaticgameTime;
    }

    /**
     * Getter for the game state used to save the game state.
     * @return nonStaticfinish is the representation of the game as a matrix.
     */
    int[] getNonStaticfinish() {
        return nonStaticfinish;
    }

    /**
     * Setter for the game state used to save the game state.
     * @param nonStaticfinish the representation of the game in a matrix.
     */
    void setNonStaticfinish(int[] nonStaticfinish) {
        this.nonStaticfinish = nonStaticfinish;
    }

    /**
     * To string for getting the data from the json.
     * @return nonStaticfinish is the representation of the current game as a matrix.
     */
    public String toString() {
        return "Main{" +
                "nonStaticfinish=" + Arrays.toString(nonStaticfinish) +
                '}';
    }

    /**
     * Getter for the step count used to save step count.
     * @return nonStaticstepCount is the number of the steps.
     */
    int getNonStaticstepCount() {
        return nonStaticstepCount;
    }

    /**
     * Setter for the step count used to save step count.
     * @param nonStaticstepCount s the number of the steps.
     */
    void setNonStaticstepCount(int nonStaticstepCount)
    {
        this.nonStaticstepCount = nonStaticstepCount;
    }

    /**
     * Handles the window creation.
     * Creates a new instance of Main in order to be able to save the game later into a json.
     * Initialises the buttons, their positions and their size.
     * Sets the title of the window.
     * Sets the event handlers.
     * @param primaryStage is the window.
     */
    public void start(Stage primaryStage) {
        Main a = new Main();
        primaryStage.setTitle("8 Puzzle");
        primaryStage.setResizable(false);

        stepCountLabel.setLayoutX(25);
        stepCountLabel.setLayoutY(75);

        newGame.setPrefSize(80,20);
        newGame.setLayoutX(190);
        newGame.setLayoutY(5);

        button0.setPrefSize(77,77);
        button0.setLayoutX(20);
        button0.setLayoutY(100);
        button0.setId("0");

        button1.setPrefSize(77,77);
        button1.setLayoutX(100);
        button1.setLayoutY(100);
        button1.setId("1");

        button2.setPrefSize(77,77);
        button2.setLayoutX(180);
        button2.setLayoutY(100);
        button2.setId("2");
        //
        button3.setPrefSize(77,77);
        button3.setLayoutX(20);
        button3.setLayoutY(180);
        button3.setId("3");

        button4.setPrefSize(77,77);
        button4.setLayoutX(100);
        button4.setLayoutY(180);
        button4.setId("4");

        button5.setPrefSize(77,77);
        button5.setLayoutX(180);
        button5.setLayoutY(180);
        button5.setId("5");
        //
        button6.setPrefSize(77,77);
        button6.setLayoutX(20);
        button6.setLayoutY(260);
        button6.setId("6");

        button7.setPrefSize(77,77);
        button7.setLayoutX(100);
        button7.setLayoutY(260);
        button7.setId("7");

        button8.setPrefSize(77,77);
        button8.setLayoutX(180);
        button8.setLayoutY(260);
        button8.setId("8");

        newGame.setOnAction(this);
        button0.setOnAction(this);
        button1.setOnAction(this);
        button2.setOnAction(this);
        button3.setOnAction(this);
        button4.setOnAction(this);
        button5.setOnAction(this);
        button6.setOnAction(this);
        button7.setOnAction(this);
        button8.setOnAction(this);

        Menu fileMenu = new Menu("_Game");
        Menu sugoMenu = new Menu("Info");
        MenuBar menuBar = new MenuBar();

        MenuItem mentes = new MenuItem("Save...");
        mentes.setId("m");
        MenuItem betoltes = new MenuItem("Load...");
        betoltes.setId("b");
        MenuItem sugo = new MenuItem("Info");
        sugo.setId("s");

        fileMenu.getItems().add(mentes);
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(betoltes);

        sugoMenu.getItems().add(sugo);

        mentes.setOnAction(e -> {
            try
            {
                Controller.Mentes(finish, stepCount, gameTime, a);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        betoltes.setOnAction(e -> {
            try
            {
                Controller.Betoltes(a);
            }
            catch (FileNotFoundException ex)
            {
                ex.printStackTrace();
            }
        });
        sugo.setOnAction(e -> Controller.Sugo());

        menuBar.getMenus().addAll(fileMenu,sugoMenu);

        Pane layout = new Pane();
        layout.getChildren().add(stepCountLabel);
        layout.getChildren().add(menuBar);
        layout.getChildren().add(newGame);
        layout.getChildren().add(button0);
        layout.getChildren().add(button1);
        layout.getChildren().add(button2);
        layout.getChildren().add(button3);
        layout.getChildren().add(button4);
        layout.getChildren().add(button5);
        layout.getChildren().add(button6);
        layout.getChildren().add(button7);
        layout.getChildren().add(button8);

        Scene scene = new Scene(layout, 280, 350); //x,y
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     *Handles the events whenever a button is pressed.
     * Events:New game, Step being made.
     * @param event is the even that happened to the button.
     */
    public void handle(ActionEvent event) {
        if (event.getSource() == newGame) {
            Controller.ButtonShuffle();
        }

        if (event.getSource() == button0) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button0.getText();
                Controller.Csere(pressedButtonText0, pressedButtonText1, buttonId, button0);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button0.getText();
                buttonId = button0.getId();
            }
        }

        if (event.getSource() == button1) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button1.getText();
                Controller.Csere(pressedButtonText0, pressedButtonText1, buttonId, button1);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button1.getText();
                buttonId = button1.getId();
            }
        }
        if (event.getSource() == button2) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button2.getText();
                Controller.Csere(pressedButtonText0, pressedButtonText1, buttonId, button2);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button2.getText();
                buttonId = button2.getId();
            }
        }
        if (event.getSource() == button3) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button3.getText();
                Controller.Csere(pressedButtonText0, pressedButtonText1, buttonId, button3);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button3.getText();
                buttonId = button3.getId();
            }
        }
        if (event.getSource() == button4) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button4.getText();
                Controller.Csere(pressedButtonText0, pressedButtonText1, buttonId, button4);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button4.getText();
                buttonId = button4.getId();
            }
        }
        if (event.getSource() == button5) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button5.getText();
                Controller.Csere(pressedButtonText0, pressedButtonText1, buttonId, button5);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button5.getText();
                buttonId = button5.getId();
            }
        }
        if (event.getSource() == button6) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button6.getText();
                Controller.Csere(pressedButtonText0, pressedButtonText1, buttonId, button6);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button6.getText();
                buttonId = button6.getId();
            }
        }
        if (event.getSource() == button7) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button7.getText();
                Controller.Csere(pressedButtonText0, pressedButtonText1, buttonId, button7);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button7.getText();
                buttonId = button7.getId();
            }
        }
        if (event.getSource() == button8) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button8.getText();
                Controller.Csere(pressedButtonText0, pressedButtonText1, buttonId, button8);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button8.getText();
                buttonId = button8.getId();
            }
        }
    }
}
/*
* JavaFx dependency for Maven and for IntelliJ:
* https://blog.cag.se/?p=752
* */
