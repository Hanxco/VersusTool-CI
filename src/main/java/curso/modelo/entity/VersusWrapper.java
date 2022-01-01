package curso.modelo.entity;

import java.util.List;

public class VersusWrapper {
	
	public Integer key;
	public String criteriaName;
	public String res1;
	public String res2;
	public String typeData;
	
	
	public VersusWrapper(Integer key, String criteriaName, String res1, String res2, String typeData) {
		super();
		this.key = key;
		this.criteriaName = criteriaName;
		this.res1 = res1;
		this.res2 = res2;
		this.typeData = typeData;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	
	public String getCriteriaName() {
		return criteriaName;
	}
	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}
	public String getRes1() {
		return res1;
	}
	public void setRes1(String res1) {
		this.res1 = res1;
	}
	public String getRes2() {
		return res2;
	}
	public void setRes2(String res2) {
		this.res2 = res2;
	}
	public String getTypeData() {
		return typeData;
	}
	public void setTypeData(String typeData) {
		this.typeData = typeData;
	}
	@Override
	public String toString() {
		return "VersusWrapper [key=" + key + ", criteriaName=" + criteriaName + ", res1=" + res1 + ", res2=" + res2
				+ ", typeData=" + typeData + "]";
	}
	
	
	
	
}