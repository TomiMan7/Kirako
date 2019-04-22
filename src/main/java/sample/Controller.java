package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller extends Main{

    public Controller() {
    }

    public static void ButtonShuffle()
    {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< 9; i++)
            list.add(i);

        Collections.shuffle(list);

        for(int i = 0; i<9; i++)
            finish[i] = list.get(i);

        stepCount = 0;

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
    }

    public static void Csere(String pressedButtonText0, String pressedButtonText1, String buttonId, Button button)
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

                Win();
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

    public static void Win()
    {
        int win = 0;

        for(int i = 0; i < finish.length - 1; i++)
            if(finish[i] == i+1)
                win++;

        if(win == finish.length - 1)
        {        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You won!");
            alert.setContentText("You won! Steps needed: " + stepCount);
            button0.setText("You won!");
            button1.setText("You won!");
            button2.setText("You won!");
            button3.setText("You won!");
            button4.setText("You won!");
            button5.setText("You won!");
            button6.setText("You won!");
            button7.setText("You won!");
            button8.setText("You won!");

            alert.showAndWait();}
    }

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

    public static int[] Mentes(int[] finish, int stepCount) throws IOException
    {
        Main main = new Main();

        main.setNonStaticfinish(finish);
        main.setNonStaticstepCount(stepCount);

        fc.setDialogTitle("Save");
        fc.showSaveDialog(null);
        fc.requestFocus(true);

        String file = fc.getSelectedFile().getAbsolutePath();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter writer = new FileWriter(file+".json");

        gson.toJson(main,writer);

        writer.close();

        return finish;
    }

    public static int[] Betoltes() throws FileNotFoundException
    {
        Main main = new Main();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        fc.setDialogTitle("Load");
        fc.showOpenDialog(null);
        fc.requestFocus(true);

        String file = fc.getSelectedFile().getAbsolutePath();

        main = gson.fromJson(new FileReader(file), Main.class);

        finish = main.getNonStaticfinish();

        stepCountLabel.setText("Step counter: " + main.getNonStaticstepCount());

        button0.setText(String.valueOf(finish[0]));
        button1.setText(String.valueOf(finish[1]));
        button2.setText(String.valueOf(finish[2]));
        button3.setText(String.valueOf(finish[3]));
        button4.setText(String.valueOf(finish[4]));
        button5.setText(String.valueOf(finish[5]));
        button6.setText(String.valueOf(finish[6]));
        button7.setText(String.valueOf(finish[7]));
        button8.setText(String.valueOf(finish[8]));

        return finish;
    }
}