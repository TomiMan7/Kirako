package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends Application implements EventHandler<ActionEvent> {

    List<Integer> list = new ArrayList<>();

    int buttonPressCount = 0;

    Button newGame = new Button("New Game!");
    Button button0 = new Button("0");
    Button button1 = new Button("1");
    Button button2 = new Button("2");
    Button button3 = new Button("3");
    Button button4 = new Button("4");
    Button button5 = new Button("5");
    Button button6 = new Button("6");
    Button button7 = new Button("7");
    Button button8 = new Button("8");

    public void ButtonShuffle()
    {
        for(int i = 0; i< 9; i++)
            list.add(i);

        Collections.shuffle(list);

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


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("8 Kirako");

        newGame.setPrefSize(100,30);
        newGame.setLayoutX(90);
        newGame.setLayoutY(40);

        button0.setPrefSize(77,77);
        button0.setLayoutX(20);
        button0.setLayoutY(100);

        button1.setPrefSize(77,77);
        button1.setLayoutX(100);
        button1.setLayoutY(100);

        button2.setPrefSize(77,77);
        button2.setLayoutX(180);
        button2.setLayoutY(100);
        //
        button3.setPrefSize(77,77);
        button3.setLayoutX(20);
        button3.setLayoutY(180);

        button4.setPrefSize(77,77);
        button4.setLayoutX(100);
        button4.setLayoutY(180);

        button5.setPrefSize(77,77);
        button5.setLayoutX(180);
        button5.setLayoutY(180);
        //
        button6.setPrefSize(77,77);
        button6.setLayoutX(20);
        button6.setLayoutY(260);

        button7.setPrefSize(77,77);
        button7.setLayoutX(100);
        button7.setLayoutY(260);

        button8.setPrefSize(77,77);
        button8.setLayoutX(180);
        button8.setLayoutY(260);




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



        Pane layout = new Pane();

        layout.getChildren().addAll(newGame);
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

    //When button is clicked, handle() gets called
    //Button click is an ActionEvent (also MouseEvents, TouchEvents, etc...)
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == newGame){
            ButtonShuffle();
        }

        if (event.getSource() == button0){
//            System.out.println(button0.getText());

        }


    }
}
