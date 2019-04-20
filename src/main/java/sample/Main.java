package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends Application implements EventHandler<ActionEvent> {

    public final JFileChooser fc = new JFileChooser();
    public Label stepCountLabel = new Label("Step counter: ");
    public List<Integer> list = new ArrayList<>();
    public int[] finish = new int[9];

    public int buttonPressCount = 0;
    public int stepCount = 0;
    public String pressedButtonText0 = "9";
    public String pressedButtonText1 = "9";

    public String buttonId;

    public Button newGame = new Button("New Game!");
    public Button button0 = new Button("Press\nNew Game");
    public Button button1 = new Button("Press\nNew Game");
    public Button button2 = new Button("Press\nNew Game");
    public Button button3 = new Button("Press\nNew Game");
    public Button button4 = new Button("Press\nNew Game");
    public Button button5 = new Button("Press\nNew Game");
    public Button button6 = new Button("Press\nNew Game");
    public Button button7 = new Button("Press\nNew Game");
    public Button button8 = new Button("Press\nNew Game");

    public void ButtonShuffle()
    {
        list.clear();
        for(int i = 0; i< 9; i++)
            list.add(i);

        Collections.shuffle(list);

        for(int i = 0; i<9; i++)
            finish[i] = list.get(i);

//        for(int i = 0; i<9; i++){
//           System.out.print(finish[i] + " ");}
//
//        System.out.print("\n");

        button0.setText(String.valueOf(list.get(0)));
        button1.setText(String.valueOf(list.get(1)));
        button2.setText(String.valueOf(list.get(2)));
        button3.setText(String.valueOf(list.get(3)));
        button4.setText(String.valueOf(list.get(4)));
        button5.setText(String.valueOf(list.get(5)));
        button6.setText(String.valueOf(list.get(6)));
        button7.setText(String.valueOf(list.get(7)));
        button8.setText(String.valueOf(list.get(8)));
    }

    public void Csere(String pressedButtonText0, String pressedButtonText1, String buttonId, Button button) //siker ellenorzese meg hianyzik
    {
        buttonPressCount = 0;
        stepCountLabel.setText("Step counter: " + ++stepCount);

    if( Math.abs( Integer.valueOf(buttonId) - Integer.valueOf(button.getId()) ) == 1 ||  Math.abs( Integer.valueOf(buttonId) - Integer.valueOf(button.getId()) ) == 3)
    {
        if (pressedButtonText0.equals("0") || pressedButtonText1.equals("0")) {

            String temp;
            temp = String.valueOf(finish[Integer.valueOf(button.getId())]);
            finish[Integer.valueOf(button.getId())] = Integer.valueOf(pressedButtonText0);
            finish[Integer.valueOf(buttonId)] = Integer.valueOf(temp);

            button.setText(pressedButtonText0);

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
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid step!");
            alert.setContentText("You can't move diagonally, or use the '0' tile to move!");

            alert.showAndWait();;
        }
    }
    else{
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid step!");
        alert.setContentText("You can't move diagonally, or use the '0' tile to move!");

        alert.showAndWait();
    }
    }

    public int[] Mentes(int[] finish) //allapot mentese hianyzik
    {
        fc.setDialogTitle("Mentes");
        fc.showSaveDialog(null);
        fc.requestFocus(true);

        String file = fc.getSelectedFile().getAbsolutePath();

        return finish;
    }

    public int[] Betoltes(int[] finish ) //allapot betoltese hianyzik
    {
        fc.setDialogTitle("Betoltes");
        fc.showOpenDialog(null);
        fc.requestFocus(true);

        String file = fc.getSelectedFile().getAbsolutePath();

        return finish;

    }

    public void Sugo()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeight(300);
        alert.setContentText("Use the '0' tile to move. Your goal is to move the numbers into order from 1-8-0 moving the '0' tile.\n" +
                "You can only move one tile at a time. Cannot move diagonally.\n" +
                "Click on a tile You wanna move then click on a tile where You wanna move it.");

        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("8 Kirako");
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
        Menu sugoMenu = new Menu("_Sugo");
        MenuBar menuBar = new MenuBar();

        MenuItem mentes = new MenuItem("_Mentes...");
        mentes.setId("m");
        MenuItem betoltes = new MenuItem("_Betoltes...");
        betoltes.setId("b");
        MenuItem sugo = new MenuItem("Sugo");
        sugo.setId("s");

        fileMenu.getItems().add(mentes);
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(betoltes);

        sugoMenu.getItems().add(sugo);

        mentes.setOnAction(e -> Mentes(finish));
        betoltes.setOnAction(e -> Betoltes(finish));
        sugo.setOnAction(e -> Sugo());

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

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == newGame) {
            ButtonShuffle();
        }

        if (event.getSource() == button0) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button0.getText();
                Csere(pressedButtonText0, pressedButtonText1, buttonId, button0);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button0.getText();
                buttonId = button0.getId();
            }
        }

        if (event.getSource() == button1) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button1.getText();
                Csere(pressedButtonText0, pressedButtonText1, buttonId, button1);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button1.getText();
                buttonId = button1.getId();
            }
        }
        if (event.getSource() == button2) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button2.getText();
                Csere(pressedButtonText0, pressedButtonText1, buttonId, button2);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button2.getText();
                buttonId = button2.getId();
            }
        }
        if (event.getSource() == button3) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button3.getText();
                Csere(pressedButtonText0, pressedButtonText1, buttonId, button3);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button3.getText();
                buttonId = button3.getId();
            }
        }
        if (event.getSource() == button4) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button4.getText();
                Csere(pressedButtonText0, pressedButtonText1, buttonId, button4);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button4.getText();
                buttonId = button4.getId();
            }
        }
        if (event.getSource() == button5) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button5.getText();
                Csere(pressedButtonText0, pressedButtonText1, buttonId, button5);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button5.getText();
                buttonId = button5.getId();
            }
        }
        if (event.getSource() == button6) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button6.getText();
                Csere(pressedButtonText0, pressedButtonText1, buttonId, button6);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button6.getText();
                buttonId = button6.getId();
            }
        }
        if (event.getSource() == button7) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button7.getText();
                Csere(pressedButtonText0, pressedButtonText1, buttonId, button7);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button7.getText();
                buttonId = button7.getId();
            }
        }
        if (event.getSource() == button8) {
            if (buttonPressCount == 1) {
                pressedButtonText1 = button8.getText();
                Csere(pressedButtonText0, pressedButtonText1, buttonId, button8);
            } else {
                buttonPressCount++;
                pressedButtonText0 = button8.getText();
                buttonId = button8.getId();
            }
        }
    }
}
