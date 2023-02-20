package states;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import states.stopwatch.AbstractStopwatch;
import states.stopwatch.LaptimeStopwatch;
import states.stopwatch.ResetStopwatch;
import states.stopwatch.RunningStopwatch;
import states.timer.*;

public class TestScenarios {

	Context c;
	
    @BeforeEach
    public void setup() {
    	c = new Context();
     	//before each test, reset the timer values to avoid interference between tests:
    	AbstractTimer.resetInitialValues();
    	AbstractStopwatch.resetInitialValues();
    }
    
  //This is more a kind of integration test than a real unit test	
  @Test
  public void completeScenario() {
	  Assertions.assertEquals(IdleTimer.Instance(), c.currentState);
	  Assertions.assertEquals(0, AbstractTimer.getMemTimer());
	  
	  c.right(); // start incrementing the memTimer variable
	  c.tick();
	  Assertions.assertSame(SetTimer.Instance(), c.currentState);
	  Assertions.assertEquals(1, AbstractTimer.getMemTimer());
	  Assertions.assertEquals(0, AbstractTimer.getTimer());

	  c.tick();
	  Assertions.assertEquals(2, AbstractTimer.getMemTimer());
	  Assertions.assertEquals(0, AbstractTimer.getTimer());

	  c.right(); // stop incrementing the memTimer variable
	  c.tick();
	  Assertions.assertEquals(2, AbstractTimer.getMemTimer());
	  Assertions.assertEquals(0, AbstractTimer.getTimer());
	  
	  c.up(); // start running the timer
	  Assertions.assertEquals(2, AbstractTimer.getTimer(), "value of timer ");
	  c.tick();
	  Assertions.assertEquals(2, AbstractTimer.getMemTimer(), "value of memTimer ");
	  Assertions.assertEquals(1, AbstractTimer.getTimer(), "value of timer ");
	  
	  
	  c.up(); // pause the timer
	  c.tick();
	  Assertions.assertSame(PausedTimer.Instance(), c.currentState);
	  Assertions.assertEquals(2, AbstractTimer.getMemTimer(), "value of memTimer ");
	  Assertions.assertEquals(1, AbstractTimer.getTimer(), "value of timer ");
	  
	  c.left(); // go to stopwatch mode
	  c.tick();
	  Assertions.assertSame(ResetStopwatch.Instance(), c.currentState);
	  Assertions.assertEquals(0, AbstractStopwatch.getTotalTime(), "value of totalTime ");
	  Assertions.assertEquals(0, AbstractStopwatch.getLapTime(), "value of lapTime ");
	  
	  c.up(); //start running the stopwatch
	  c.tick();
	  Assertions.assertSame(RunningStopwatch.Instance(), c.currentState);
	  Assertions.assertEquals(1, AbstractStopwatch.getTotalTime(), "value of totalTime ");
	  Assertions.assertEquals(0, AbstractStopwatch.getLapTime(), "value of lapTime ");
	 
	  c.up(); // record stopwatch laptime
	  c.tick();
	  Assertions.assertSame(LaptimeStopwatch.Instance(), c.currentState);
	  Assertions.assertEquals(2, AbstractStopwatch.getTotalTime(), "value of totalTime ");
	  Assertions.assertEquals(1, AbstractStopwatch.getLapTime(), "value of lapTime ");

	  c.up();
	  c.tick();
	  Assertions.assertSame(RunningStopwatch.Instance(), c.currentState);
	  c.left(); // go back to timer mode (remembering history state)
	  c.tick();
	  Assertions.assertSame(PausedTimer.Instance(), c.currentState);
	  Assertions.assertEquals(2, AbstractTimer.getMemTimer(), "value of memTimer ");
	  Assertions.assertEquals(1, AbstractTimer.getTimer(), "value of timer ");
	  
	  c.up(); // continue running timer
	  Assertions.assertSame(RunningTimer.Instance(), c.currentState);
	  c.tick();
	  //automatic switch to ringing timer since timer has reached 0...
	  Assertions.assertSame(RingingTimer.Instance(), c.currentState);
	  Assertions.assertEquals(2, AbstractTimer.getMemTimer(), "value of memTimer ");
	  Assertions.assertEquals(0, AbstractTimer.getTimer(), "value of timer ");
	  
	  c.right(); // return to idle timer state
	  c.tick();
	  Assertions.assertSame(IdleTimer.Instance(), c.currentState);
	  Assertions.assertEquals(2, AbstractTimer.getMemTimer(), "value of memTimer ");
	  Assertions.assertEquals(0, AbstractTimer.getTimer(), "value of timer ");
	  }

}
