package states;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import states.stopwatch.AbstractStopwatch;
import states.stopwatch.ResetStopwatch;
import states.timer.AbstractTimer;

public class StopwatchTests {

	private static Context context;
	private ClockState current;

	@BeforeEach
	public void setup() {
        context = new Context(); // create the state machine context
        AbstractStopwatch.resetInitialValues();
        context.currentState = AbstractStopwatch.Instance();
	}
		
	@Test
	public void testInitialState() {
		//context.tick(); //no tick() needed for this test;
		/* When initialising the context (see setup() method above)
		 * its currentState will be inialised with the initial state
		 * of timer, i.e. the IdleTimer state.
		 */
		current = context.currentState;
		
	    Assertions.assertEquals(Mode.stopwatch, current.getMode());
	    Assertions.assertSame(ResetStopwatch.Instance(), current);
	    Assertions.assertEquals(0, AbstractStopwatch.getTotalTime(), "For the value of totalTime we ");
	    Assertions.assertEquals(0, AbstractStopwatch.getLapTime(), "For the value of lapTime we ");
	}

	@org.junit.jupiter.api.Test
	public void testInitialAbstractStopwatch() {
		// The initial state of composite state AbstractStopwatch should be ResetStopwatch
		Assertions.assertSame(AbstractStopwatch.Instance(), ResetStopwatch.Instance());
	}
	
	@org.junit.jupiter.api.Test
	public void testHistoryState() {		
		current = AbstractStopwatch.Instance();
		// after processing the left() event, we should arrive in the initial state of AbstractStopwatch
		ClockState newState = current.left();
		Assertions.assertEquals(AbstractTimer.Instance(), newState);
		/* after another occurrence of the left() event, we should return to the original state
		 * because we used history states		
		 */
		Assertions.assertEquals(current, newState.left());
	}

}
