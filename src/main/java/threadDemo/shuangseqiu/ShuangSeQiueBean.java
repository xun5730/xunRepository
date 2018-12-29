package threadDemo.shuangseqiu;

import java.util.Set;

public class ShuangSeQiueBean {
	
	private Set<Integer> hongQiuSet;
	
	private Integer lanQiu;

	public Set<Integer> getHongQiuSet() {
		return hongQiuSet;
	}

	public void setHongQiuSet(Set<Integer> hongQiuSet) {
		this.hongQiuSet = hongQiuSet;
	}

	public Integer getLanQiu() {
		return lanQiu;
	}

	public void setLanQiu(Integer lanQiu) {
		this.lanQiu = lanQiu;
	}

/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hongQiuSet == null) ? 0 : hongQiuSet.hashCode());
		result = prime * result + ((lanQiu == null) ? 0 : lanQiu.hashCode());
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
		ShuangSeQiueBean other = (ShuangSeQiueBean) obj;
		if (hongQiuSet == null) {
			if (other.hongQiuSet != null)
				return false;
		} else if (!hongQiuSet.equals(other.hongQiuSet))
			return false;
		if (lanQiu == null) {
			if (other.lanQiu != null)
				return false;
		} else if (!lanQiu.equals(other.lanQiu))
			return false;
		return true;
	}

	
	
	
	
	
	
	
	

}
