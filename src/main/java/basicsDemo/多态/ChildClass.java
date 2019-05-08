package basicsDemo.多态;

public class ChildClass extends ParentClass {
	
	public int a=5;
	protected final String name="childClass";
	
	/*编译不通过
	 * public final void finalMethod(){
		System.out.println("final方法");
	}*/
	public static void monday(){//静态方法
		System.out.println("子类的ChildClass的monday()方法");
	}
	
	public void count(){//可继承的成员方法
		System.out.println("子类childClass的count方法");
		
	}
	class InnerClass{//内部类
        public InnerClass() {
            System.out.println("子类ChildClass的内部类");
        }
    }  
	public static void main(String[] args) {
		
		ChildClass child=new ChildClass();
		ParentClass parent=child;
		System.out.println("----------变量的隐藏测试-------------");
		child.a=10;
		System.out.println("Parent.a:"+parent.a);
		System.out.println("child.a"+child.a);
		System.out.println("---------静态方法的隐藏测试-------------");
		parent.monday();
		child.monday();
		System.out.println("--------方法的重写测试-------");
		parent.count();
		child.count();
		System.out.println("内部类的隐藏测试");
		ParentClass.InnerClass pa=parent.new InnerClass();
		ChildClass.InnerClass ch=child.new InnerClass();
	}
	

}
