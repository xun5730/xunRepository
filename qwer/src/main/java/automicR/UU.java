package automicR;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UU {
	
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
		final int prime = 31;
		int result = 1;
		Random r=new Random();
		result = prime * result + ((id == null) ? 0 : id.hashCode())  ;
		return result;
	}
	
	
	
/*	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UU other = (UU) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}*/
	public static void main(String[] args) {
		UU u1=new UU();
		u1.setId("df");
		System.out.println(u1.hashCode());
		UU u2=new UU();
		u2.setId("df");
		System.out.println(u2.hashCode());
		Map<UU,String> map=new HashMap<UU,String>();
		map.put(u1, "u1");
		map.put(u2, "u2");
		System.out.println(u1.equals(u2));
		System.out.println(map.size());
	}
	

}
