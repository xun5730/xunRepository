package designPatternDemo.组合模式.idemo1.standard;

public  abstract class Node {
	
	protected String name;//名称
	

	public Node(String name){
		this.name=name;
	}
	//新增节点：文件节点无此方法，目录节点重写此方法
	public void addNode(Node ndoe) throws Exception{
		throw new Exception("Invalid exception");
	}
	//显示节点：文件与目录均实现此方法
	abstract void display();
	

}
