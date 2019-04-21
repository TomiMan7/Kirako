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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends Application implements EventHandler<ActionEvent> {

    public static final JFileChooser fc = new JFileChooser();
    public static Label stepCountLabel = new Label("Step counter: ");
    public static List<Integer> list = new ArrayList<>();
    public static int[] finish = new int[9];
    public int[] nonStaticfinish = new int[9];

    public static int buttonPressCount = 0;
    public static int stepCount = 0;
    public int nonStaticstepCount = 0;
    public static String pressedButtonText0 = "9";
    public static String pressedButtonText1 = "9";

    public static String buttonId;

    public static Button newGame = new Button("New Game!");
    public static Button button0 = new Button("Press\nNew Game");
    public static Button button1 = new Button("Press\nNew Game");
    public static Button button2 = new Button("Press\nNew Game");
    public static Button button3 = new Button("Press\nNew Game");
    public static Button button4 = new Button("Press\nNew Game");
    public static Button button5 = new Button("Press\nNew Game");
    public static Button button6 = new Button("Press\nNew Game");
    public static Button button7 = new Button("Press\nNew Game");
    public static Button button8 = new Button("Press\nNew Game");

    public Main()
    {}

    public int[] getNonStaticfinish() {
        return nonStaticfinish;
    }

    public void setNonStaticfinish(int[] nonStaticfinish) {
        this.nonStaticfinish = nonStaticfinish;
    }

    @Override
    public String toString() {
        return "Main{" +
                "nonStaticfinish=" + Arrays.toString(nonStaticfinish) +
                '}';
    }

    public int getNonStaticstepCount() {
        return nonStaticstepCount;
    }

    public void setNonStaticstepCount(int nonStaticstepCount) {
        this.nonStaticstepCount = nonStaticstepCount;
    }

    @Override
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
                Controller.Mentes(finish, stepCount);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        betoltes.setOnAction(e -> {
            try
            {
                Controller.Betoltes(finish);
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

    @Override
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

/*<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>hu.unideb.inf</groupId>
	<artifactId>gson-example</artifactId>
	<version>1.0</version>
	<properties>
		<maven.compiler.source>9</maven.compiler.source>
		<maven.compiler.target>9</maven.compiler.target>
	</properties>
	<dependencies>
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.5</version>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-lang3</artifactId>
			<version>3.8.1</version>
			<scope>compile</scope>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>com.github.johnpoth</groupId>
				<artifactId>jshell-maven-plugin</artifactId>
				<version>1.1</version>
			</plugin>
		</plugins>
	</build>
</project>
*/