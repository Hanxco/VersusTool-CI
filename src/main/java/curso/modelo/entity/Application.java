package curso.modelo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity(name="application")
@Component
@Scope(value="prototype")
public class Application {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Value("skksksd")
	private String link;
	@Value("skksksd")
	private Integer type;
	@Value("skksksd")
	private String description;
	@Value("skksksd")
	private String name;
	@Value("kdskks")
	private String type_label;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType_label() {
		return type_label;
	}
	public void setType_label(String type_label) {
		this.type_label = type_label;
	}
	@Override
	public String toString() {
		return "Application [id=" + id + ", link=" + link + ", type=" + type + ", description=" + description
				+ ", name=" + name + ", getId()=" + getId() + ", getLink()=" + getLink() + ", getType()=" + getType()
				+ ", getDescription()=" + getDescription() + ", getName()=" + getName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

	
}
