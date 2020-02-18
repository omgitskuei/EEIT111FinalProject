package model;

public class Members {
	private String memberName;
	private String gender;
	private int age;
	private int height;
	
	// Constructors
	public Members() {		
	}

	public Members(String memberName, String gender, int age) {
		this.memberName = memberName;
		this.gender = gender;
		this.age = age;
	}

	// Get/Set
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
