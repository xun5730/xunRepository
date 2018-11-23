package designPatternDemo.命令模式.demo;

public interface Control {
	
	public void onButton(int slot);
	
	public void offButton(int slot);
	
	public void undoButton();

}
