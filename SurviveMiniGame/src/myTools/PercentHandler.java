package myTools;
import java.util.Random;
public class PercentHandler {
	private Random random = new Random();
	
	public boolean inThisRange100(int max){
		if(random.nextInt(100) < max) return true;
		else return false;
	}
	
	public boolean notInThisRange100(int max){
		if(random.nextInt(100) >= max) return true;
		else return false;
	}
	
	public boolean inThisRange200(int max){
		if(random.nextInt(200) < max) return true;
		else return false;
	}
	
	public boolean notInThisRange200(int max){
		if(random.nextInt(200) >= max) return true;
		else return false;
	}
	
	public boolean inThisRange300(int max){
		if(random.nextInt(300) < max) return true;
		else return false;
	}
	
	public boolean notInThisRange300(int max){
		if(random.nextInt(300) >= max) return true;
		else return false;
	}
	
	public boolean inThisRange400(int max){
		if(random.nextInt(400) < max) return true;
		else return false;
	}
	
	public boolean notInThisRange400(int max){
		if(random.nextInt(400) >= max) return true;
		else return false;
	}
	
	public boolean inThisRange500(int max){
		if(random.nextInt(500) < max) return true;
		else return false;
	}
	
	public boolean notInThisRange500(int max){
		if(random.nextInt(500) >= max) return true;
		else return false;
	}
}
