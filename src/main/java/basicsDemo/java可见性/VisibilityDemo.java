package basicsDemo.java可见性;

public class VisibilityDemo  extends Thread {
	
	private boolean stop=true;

	@Override
	public void run() {

		int i=0;
		while(stop){
			i++;
			System.out.println(i);
		}
		System.out.println("finish "+i);
	}
	
	public void stoplt(){
		stop=false;
	}
	
	public boolean getStop(){
		return stop;
	}
	public static void main(String[] args) throws Exception {
		
		VisibilityDemo v=new VisibilityDemo();
		v.start();
		Thread.sleep(2000);
		v.stoplt();
		Thread.sleep(2000);
		System.out.println("finish main "+v.getStop());
	}
	
	

}
