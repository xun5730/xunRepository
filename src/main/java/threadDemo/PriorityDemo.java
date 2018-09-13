package threadDemo;

public class PriorityDemo implements Comparable<PriorityDemo> {
	
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PriorityDemo [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int compareTo(PriorityDemo o) {
		return this.id-o.getId();
	}
	

}
