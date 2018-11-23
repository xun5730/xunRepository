package designPatternDemo.工厂模式demo.idemo.factoryDemo;

public class MainBoardFactory {
	
	
	
	public static MainBoard cereateMainBoard(int type){
		
		MainBoard mainBoard=null;
		
		if(type==1){
			mainBoard=new IntelMainBoard(755);
		}else if(type==2){
			mainBoard=new AmdMainBoard(938);
		}
		return mainBoard;
		
	}
	

}
