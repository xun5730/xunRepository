package basicsDemo;

public class StringPoolDemo {

	
/*	
	字符串常量池（String Pool）保存着所有字符串字面量（literal strings），这些字面量在编译时期就确定。不仅如此，还可以使用 String 的 intern() 方法在运行过程中将字符串添加到 String Pool 中。
	当一个字符串调用 intern() 方法时，
	如果 String Pool 中已经存在一个字符串和该字符串值相等（使用 equals() 方法进行确定），
	那么就会返回 String Pool 中字符串的引用；否则，就会在 String Pool 中添加一个新的字符串，并返回这个新字符串的引用。

	下面示例中，s1 和 s2 采用 new String() 的方式新建了两个不同字符串，
	而 s3 和 s4 是通过 s1.intern() 方法取得一个字符串引用。intern() 首先把 s1 引用的字符串放到 String Pool 中，
	然后返回这个字符串引用。因此 s3 和 s4 引用的是同一个字符串。*/
	
	public static void main(String[] args) {
		
		
		
		
		String s1=new String("aaa");
		String s2=new String("aaa");
		System.out.println(s1==s2);//false
		String s3=s1.intern();
		String s4=s1.intern();
		System.out.println(s3==s4); //true
		
		String s5="bbb";
		String s6="bbb";
		
		System.out.println(s5==s6);//true
		String s7=new String("bbb");
		System.out.println(s5==s7);
		
//		在 Java 7 之前，String Pool 被放在运行时常量池中，它属于永久代。而在 Java 7，String Pool 被移到堆中。这是因为永久代的空间有限，在大量使用字符串的场景下会导致 OutOfMemoryError 错误。
		
	}
	
	
}
