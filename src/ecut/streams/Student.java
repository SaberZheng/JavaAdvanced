package ecut.streams;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
 
	private static final long serialVersionUID = 6570982037942763733L;//用于鉴别类，相当于身份证

	private Integer id;
	private String name;
	private char gender;
	
	private transient Date birthdate ;//birthdate被transient修饰的都不序列化操作
	
	public Student() {
		super();
	}

	public Student(Integer id, String name, char gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

}
