package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	private int id;
	private String name;
	private int age;
	private String course;

	public Student(String name, int age, String course) {
		super();
		this.name = name;
		this.age = age;
		this.course = course;
	}

}
