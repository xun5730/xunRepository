package basicsDemo.多态;

public class ParentClass {
	

	public int a=5;
	protected final String name="parentClass";
	public final void finalMethod(){// final 方法 ，子类既不能重写，也不能隐藏
		System.out.println("final方法");
	}
	public static void monday(){//静态方法
		System.out.println("父类parentclass的monday()方法");
	}
	public void count(){//可继承的成员方法
		System.out.println("父类parentclass的count()方法");
	}
	class InnerClass{//内部类
		public InnerClass(){
			System.out.println("父类parentClass的内部类");
		}
	}
	
	

}
