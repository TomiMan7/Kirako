package sample;

import junit.framework.Assert;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * Tester class for Model.java
 */
@RunWith(JUnitPlatform.class)
@SelectPackages("sample")
public class ModelTest {

    /**
     * Contructor for ModelTest, inicialising JavaFx
     */
    public ModelTest(){/*new JFXPanel()*/;}

    /**
     * Testing method for Model.GameStat
     */
    @Test
    void gameStat() {
        Assert.assertEquals( 1.8,Model.GameStat((long)3523645814005.0, 19));
        Assert.assertEquals(1.7, Model.GameStat((long)3598610524161.0, 20));
        Assert.assertEquals(4.0, Model.GameStat((long)3672732534145.0, 9));
    }

    /**
     * Instances ModelTest and tests Model.GameStat.
     * @param args args.
     */
    public static void main(String[] args) {

        ModelTest c = new ModelTest();
        c.gameStat();
    }
}