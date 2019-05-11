package sample;

import junit.framework.Assert;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Testing method for Model.GameStat
     */
    @Test
    void gameStat() {
        Assert.assertEquals( 0.055,Model.GameStat((long)6678110087991.0, 12));
        logger.info("Test runned.");
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
//gomb nyomas loggolas stb

//gitignore: intellij ALL kell!