package basicsDemo;

import java.util.HashSet;

public class EqualExample {
	
	private int x;
	private int y;
	private int z;
	public EqualExample(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		System.out.println(result+"哈希值");
		return result;
	}*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EqualExample other = (EqualExample) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		
		EqualExample e1=new EqualExample(1, 1, 1);
		EqualExample e2=new EqualExample(1, 1, 1);

		System.out.println(e1.equals(e2));
		HashSet<EqualExample> set=new HashSet<EqualExample>();
		set.add(e2);
		set.add(e1);
		System.out.println(set.size());
		
	}
	

}
