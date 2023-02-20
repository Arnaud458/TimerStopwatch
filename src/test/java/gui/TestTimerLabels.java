package gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import states.timer.*;

public class TestTimerLabels extends TestGUIAbstract {

	@org.junit.jupiter.api.Test
	public void testIdleTimerLabels() {
		c.currentState = IdleTimer.Instance();
		g.updateUI(c);
		Assertions.assertEquals(g.b1.getText(), c.getLeftText(), "button 1 for state IdleTimer ");
		Assertions.assertEquals(g.b2.getText(), c.getUpText(), "button 2 for state IdleTimer ");
		Assertions.assertEquals(g.b3.getText(), c.getRightText(), "button 3 for state IdleTimer ");
	}
	
	@org.junit.jupiter.api.Test
	public void testPausedTimerLabels() {
		c.currentState = PausedTimer.Instance();
		g.updateUI(c);
		Assertions.assertEquals(g.b1.getText(), c.getLeftText(), "button 1 for state PausedTimer ");
		Assertions.assertEquals(g.b2.getText(), c.getUpText(), "button 2 for state IdleTimer ");
		Assertions.assertEquals(g.b3.getText(), c.getRightText(), "button 3 for state IdleTimer ");
	}
	
	@org.junit.jupiter.api.Test
	public void testRingingTimerLabels() {
		c.currentState = RingingTimer.Instance();
		g.updateUI(c);
		Assertions.assertEquals(g.b1.getText(), c.getLeftText(), "button 1 for state RingingTimer ");
		Assertions.assertEquals(g.b2.getText(), c.getUpText(), "button 2 for state RingingTimer ");
		Assertions.assertEquals(g.b3.getText(), c.getRightText(), "button 3 for state RingingTimer ");
	}
	
	@Test
	public void testRunningTimerLabels() {
		c.currentState = RunningTimer.Instance();
		g.updateUI(c);
		Assertions.assertEquals(g.b1.getText(), c.getLeftText(), "button 1 for state RunningTimer ");
		Assertions.assertEquals(g.b2.getText(), c.getUpText(), "button 2 for state RunningTimer ");
		Assertions.assertEquals(g.b3.getText(), c.getRightText(), "button 3 for state RunningTimer ");
	}
	
	@org.junit.jupiter.api.Test
	public void testSetTimerLabels() {
		c.currentState = SetTimer.Instance();
		g.updateUI(c);
		Assertions.assertEquals(g.b1.getText(), c.getLeftText(), "button 1 for state SetTimer ");
		Assertions.assertEquals(g.b2.getText(), c.getUpText(), "button 2 for state SetTimer ");
		Assertions.assertEquals(g.b3.getText(), c.getRightText(), "button 3 for state SetTimer ");
	}
	
	   @org.junit.jupiter.api.Test
	    public void testTimerButtonLabels1() {
	    	g.updateUI(c);
	    	Assertions.assertEquals("change mode", g.b1.getText());
	    	Assertions.assertEquals("run", g.b2.getText());
	    	Assertions.assertEquals("set", g.b3.getText());
	    	Assertions.assertEquals("IdleTimer", g.myText3.getText());
	    	Assertions.assertEquals("timer", g.myText2.getText());
	    	Assertions.assertEquals("memTimer = 0", g.myText1.getText());
	    }

	    @org.junit.jupiter.api.Test
	    public void testTimerButtonLabels2() {
	    	c.right(); //simulate clicking on the left button
	    	g.updateUI(c); //apply the effect on the user interface
	    	Assertions.assertEquals("reset", g.b1.getText());
	    	Assertions.assertEquals("inc 5", g.b2.getText());
	    	Assertions.assertEquals("done", g.b3.getText());
	    	Assertions.assertEquals("SetTimer", g.myText3.getText());
	    	Assertions.assertEquals("timer", g.myText2.getText());
	    	Assertions.assertEquals("memTimer = 0", g.myText1.getText());
	    }

	    @org.junit.jupiter.api.Test
	    public void testStopwatchButtonLabels1() {
	    	c.left(); //simulate clicking on the left button
	    	g.updateUI(c); //apply the effect on the user interface
	    	Assertions.assertEquals("change mode", g.b1.getText());
	    	Assertions.assertEquals("run", g.b2.getText());
	    	Assertions.assertEquals("(unused)", g.b3.getText());
	    }

	    @org.junit.jupiter.api.Test
	    public void testStopwatchButtonLabels2() {
	    	c.left(); //simulate clicking on the left button
	    	c.up(); //simulate clicking on the right button
	    	g.updateUI(c); //apply the effect on the user interface
	    	Assertions.assertEquals("change mode", g.b1.getText());
	    	Assertions.assertEquals("split", g.b2.getText());
	    	Assertions.assertEquals("reset", g.b3.getText());
	    }


}
