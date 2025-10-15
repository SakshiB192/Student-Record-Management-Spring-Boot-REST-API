package com.studentmanagement.student_recored_management.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class StudentManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    @Size(min = 3,message = "Name must be atleast 3 character")
    private String name;
    @Min(5)@Max(25)
    private int age;
    @Min(0)@Max(100)
    private int mark1;
    @Min(0)@Max(100)
    private int mark2;
    @Min(0)@Max(100)
    private int mark3;
    @Min(0)@Max(100)
    private int mark4;
    @Min(0)@Max(100)
    private int mark5;
    private double percentage;
    private String division;
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	
	
	@Override
	public String toString() {
		return "StudentManagement [id=" + id + ", name=" + name + ", age=" + age + ", mark1=" + mark1 + ", mark2="
				+ mark2 + ", mark3=" + mark3 + ", mark4=" + mark4 + ", mark5=" + mark5 + ", percentage=" + percentage
				+ ", division=" + division + "]";
	}
	public StudentManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentManagement(Long id,
			@NotBlank(message = "Name is required") @Size(min = 3, message = "Name must be atleast 3 character") String name,
			@Min(5) @Max(25) int age, @Min(0) @Max(100) int mark1, @Min(0) @Max(100) int mark2,
			@Min(0) @Max(100) int mark3, @Min(0) @Max(100) int mark4, @Min(0) @Max(100) int mark5, double percentage,
			String division) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
		this.mark4 = mark4;
		this.mark5 = mark5;
		this.percentage = percentage;
		this.division = division;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMark1() {
		return mark1;
	}
	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}
	public int getMark2() {
		return mark2;
	}
	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}
	public int getMark3() {
		return mark3;
	}
	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}
	public int getMark4() {
		return mark4;
	}
	public void setMark4(int mark4) {
		this.mark4 = mark4;
	}
	public int getMark5() {
		return mark5;
	}
	public void setMark5(int mark5) {
		this.mark5 = mark5;
	}
}



