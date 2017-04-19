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
	
	@Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) {
            return false;
        }
        Student st = (Student) o;
        return age == st.age && name.equals(st.name) && grade == st.grade;
    }
}