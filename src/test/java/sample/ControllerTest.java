package sample;

import javafx.embed.swing.JFXPanel;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;


/**
 * Tester class for Controller.java
 */
public class ControllerTest {

    /**
     * Contructor for ControllerTest, inicialising JavaFx
     */
    public ControllerTest(){new JFXPanel();}

//    @Test
//    void asd() {Assert.assertEquals(2.0, Controller.asd(1,1));}

    /**
     * Testing method for Controller.GameStat
     */
    @Test
    void gameStat() {
        Assert.assertEquals( 0.55,Controller.GameStat((long)6678110087991.0, 12));
    }

    /**
     * Instances ControllerTest and tests Controller.GameStat.
     * @param args args.
     */
    public static void main(String[] args) {

        ControllerTest c = new ControllerTest();
//        c.asd();
        c.gameStat();
    }
}