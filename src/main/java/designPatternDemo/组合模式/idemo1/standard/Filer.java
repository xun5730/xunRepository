package designPatternDemo.组合模式.idemo1.standard;

public class Filer extends Node {

	public Filer(String name) {
		super(name);
	}

	@Override
	void display() {
		System.out.println(name);
	}

}
