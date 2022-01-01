package curso.modelo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity(name="criteria")
@Component
@Scope(value="prototype")
public class Criteria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Value("skksksd")
	private Integer appId;
	@Value("skksksd")
	private String category;
	@Value("skksksd")
	private String key;
	@Value("skksksd")
	private String name;
	@Value("skksksd")
	private String subcategory;
	@Value("ksdks")
	private String app_label;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
	public String getApp_label() {
		return app_label;
	}
	public void setApp_label(String app_label) {
		this.app_label = app_label;
	}
	@Override
	public String toString() {
		return "Criteria [id=" + id + ", appId=" + appId + ", category=" + category + ", key=" + key + ", name=" + name
				+ ", subcategory=" + subcategory + "]";
	}
	
	
	
}
