package gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStopwatchLabels extends TestGUIAbstract {

    @org.junit.jupiter.api.Test
    public void testStopwatch1() {
    	c.left(); //simulate clicking on the left button
    	g.updateUI(c); //apply the effect on the user interface
    	Assertions.assertEquals("change mode", g.b1.getText());
    	Assertions.assertEquals("run", g.b2.getText());
    	Assertions.assertEquals("(unused)", g.b3.getText());
    	Assertions.assertEquals("totalTime = 0", g.myText1.getText());
    	Assertions.assertEquals("stopwatch", g.myText2.getText());
    	Assertions.assertEquals("ResetStopwatch", g.myText3.getText());
    }

    @Test
    public void testStopwatch2() {
    	c.left(); //simulate clicking on the left button
    	c.up(); //simulate clicking on the right button
    	g.updateUI(c); //apply the effect on the user interface
    	Assertions.assertEquals("change mode", g.b1.getText());
    	Assertions.assertEquals("split", g.b2.getText());
    	Assertions.assertEquals("reset", g.b3.getText());
    	Assertions.assertEquals("totalTime = 0", g.myText1.getText());
    	Assertions.assertEquals("stopwatch", g.myText2.getText());
    	Assertions.assertEquals("RunningStopwatch", g.myText3.getText());
    }

}
