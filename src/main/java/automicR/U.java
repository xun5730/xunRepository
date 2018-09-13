package automicR;

import java.util.HashMap;
import java.util.Map;

public class U {
	
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
	return 100;
	}
	public static void main(String[] args) {
		System.out.println("dfa");
	/*	U u1=new U();
		u1.setId("df");
		U u2=new U();
		u2.setId("df22");
		Map<U,String> map=new HashMap<U,String>();
		map.put(u1, "u1");
		map.put(u2, "u2");
		System.out.println(map.size());*/
	}
	

}
