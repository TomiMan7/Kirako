package sample;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    @Test
    void gameStat() { //todo finish test polishing
        Assert.assertEquals( 1.6306362170138238,Controller.GameStat((long)27720815689235.0, 17));
    }
}