package myTools;

import java.util.concurrent.TimeUnit;

public class Delay {

	public void delay(double seconds) {
		int milliSeconds = ((int)(seconds*1000));
		try {
			TimeUnit.MILLISECONDS.sleep(milliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
