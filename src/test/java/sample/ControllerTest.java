package sample;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void gameStat() { //todo finish test polishing

        Controller c = new Controller();

        long time = 1_000_000_000;
        int step = 2;

        double result = (long) c.GameStat(time, step);

        Assert.assertEquals( 0.5,result);
    }
}