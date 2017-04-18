public class Student extends Person {
	private double grade;
	public Student() {
		super();
		grade = 0.0;
	}
	
	public double getGrade() { return grade; }
	public void setGrade(double grade) {
		this.grade = grade;
	}
}