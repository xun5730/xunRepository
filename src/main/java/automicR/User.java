package automicR;

import java.util.HashSet;
import java.util.Set;

public class User {
	private String id;
	private String name;
	private Integer age;
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public static void main(String[] args) {
		
		User u=new User();
		u.setId("1");
		u.setName("1");
		User u2=new User();
		u2.setId("1");
		u2.setName("1");
		User u3=new User();
		u3.setId("2");
		u3.setName("1222");
		User u4=new User();
		u4.setId("1");
		u4.setName("1");
		System.out.println(u.equals(u2));
		System.out.println(u==u2);
		System.out.println(u==u3);
		
		/*	Set<User> s=new HashSet<User>();
		System.out.println(u.hashCode());
		System.out.println(u2.hashCode());
		System.out.println(u3.hashCode());
		System.out.println(u.hashCode());
		s.add(u);
		s.add(u2);
		s.add(u3);
		s.add(u4);
		System.out.println(s.size());*/
		System.out.println(u.equals(u2));
		
	}
	
	
	

}
