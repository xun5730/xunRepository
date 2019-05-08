package basicsDemo.深入解析基本类型;

public class ShenruJiBenLeiXing {
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
	
		
		
	/*	byte : 1字节
		char : 2字节
		short : 2字节
		int : 4字节
		long : 8字节
		float : 4字节
		double : 8字节
	*/
		
		
		
		
		
		
		
		
		int a=8;
		byte b=9;
		char c=9+5;
		short s=14+10;
		short s2=(short)(c+10);
		
/*		上面的代码是经过编译的，是正确的。b是byte类型，但b=9不需要显式地手动强制转换，这是因为9是字面常量，是由JVM自动完成。
				  我们再来看一下c=9+5，c是char类型，9+5得到结果是int类型，但也不需要显式地手动强制转换。
				这是因为 9+5是常量表达式，所以在编译期间已经由编译器计算出结果了，即经过编译后，相当于 c=14，也是字面常量，所以可以隐式转换。同理，short s = (short) (c+10); 
		子所以不能隐式转换，就是因为表达式不是常量表达式，包含了变量，只能在运行期间完成，所以就要手动强制转换。*/
		
		
//		byte b=128;
		byte c2=(byte)128;
		System.out.println(c2);
		
//		shortMethod(8);//变异错误
		shortMethod((short)8);//编译通过
		longMethod(8);//编译通过，因为这是小类型编程大类型，是不需要轻质类型转换的
		
		
		
		
		
		
		//====================
		//符合运算符的隐式转换
//		复合运算符（+=、-=、*=、/=、%=）是可以将右边表达式的类型自动强制转换成左边的类型
		int a3=8;
		short s3=5;
		s3+=a3;
		s3+=a3+5;
		
//		s+=a、s+=a+5;的表达式计算结果都是int类型，但都不需要手动强制转换。其实，如果是反编译这段代码的class文件，你会发现s+=a;，其实是被编译器处理成了
		/* char类型在基本类中是一个比较特殊的存在。这种特殊性在于char类型是一个无符号类型，所以char类型与其他基本类型不是子集与父集间的关系（其他类型都是有符号的类型）。也就是说，char类型与byte、short之间的转换都需要显式的强制类型转换（小类型自动转换成大类型失败）。

		  同时，由于char类型是一个无符号类型，所以对于整形字面常量的隐式转换的限制，不仅包括字面常量数值的大小不能超出2个字节，还包括字面常量数值不能为负数
*/
		
		
		byte bb=2;
		char cc=2;//编译通过
//		cc=1000000000000000;//编译不通过，超出char类型的范围
//		char dd=-2;//字符常量为负数，编译不通过
		char dd=(char)-100;//编译通过
		char ff=(char) bb;//编译通过
//		ff=bb;//编译不通过，不能隐式转换
		int i=cc;//编译通过，可以不需要强制类型转换
//		int i=dd;//编译不通过
		short ss=(short) cc;//编译通过，必须显示的强制类型转换
		
		short sss=-5;
		char ccc=(char)sss;
		System.out.println(c==s);
		System.out.println("(int)ccc="+(int)ccc);//转换成int类型，值为65531
		System.out.println("(short)c="+(short)ccc);//-5
		System.out.println("(int)s="+(int)sss);//-5
		
		
//		在Java中，一个运算结果的类型是与表达式中类型最高的相等，如：
		char c5=5;
		float d5=0.6f+cc;//最高类型是float，运算结果是float
		float e5=(float)(0.6d+cc);//最高类型是double，运算结果也是double
		int a5=5+c5;//最高类型是int，运算结果也是为int
		
//		但是，对于最高类型是byte、short、char的运算来说，则运行结果却不是最高类型，而是int类型。看下面的例子，c、d运算的最高类型都是char，但运算结果却是int，所以需要强制类型转换。
		byte b6=2;
		char a6=5;
		char c6=(char)(a+b);//byte +char ,运算结果的类型为int,需要强制类型转换
		int e6=a6+b6;//编译通过，不需要强制类型转换，可以证明是int
		char d6=(char) (a6+c6);//char+char
		int f6= a6+c6;
		short s6=5;
		short s7=6;
		short s8=(short)(s6+s7);
	/*	综上所述，java的运算结果的类型有两个性质：
		•运算结果的类型必须是int类型或int类型以上。
		•最高类型低于int类型的，运算结果都为int类型。否则，运算结果与表达式中最高类型一致。*/

		
		double d10=0.1;
		double d20=0.2;
		System.out.println(d10+d20==0.3);
		System.out.println(d10+d20);
		
		int aa10=3000000;
		int bb10=30000000;
		float f1=aa10;
		float f2=bb10;
		System.out.println("3000000==3000000"+(f1==f1+1));
		System.out.println("30000000=30000001"+(f2==f2+1));
		System.out.println("30000000有效二进制位数"+Integer.toBinaryString(aa10).length());
		System.out.println("30000000有效二进制位数"+Integer.toBinaryString(bb10).length());

		
		
	}
	
	public static void shortMethod(short c){
		System.out.println(c);
	}
	public static void longMethod(long l){
		System.out.println(l);
	}
	
	
	
	
	
	
	
	
	

}
