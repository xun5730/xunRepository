package designPatternDemo.stimulate策略模式.demo1.oo;

public class StoneDuck  extends Duck{

	@Override
	public void display() {

		System.out.println("***stone duck***");
	}

	@Override
	public void Quack() {

		System.out.println("no gaga");
	}

	@Override
	public void swim() {

		System.out.println("no swim ");
	}

	@Override
	public void fly() {

		System.out.println("no fly");
	}
	
	

}
