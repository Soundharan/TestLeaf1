package org.student;

import org.department.Department;

public class Student extends Department {

	public void studentName() {
		System.out.println("Student name : Soundharan");
	}
	public void studentDept() {
		System.out.println("Departmet of student is : Computer Science");
	}
	public void studentId() {
		System.out.println("Student Id :RA14390625");
	}

	public static void main(String[] args) {

		Student report = new Student();
		report.collagename();
		report.collagecode();
		report.collagerank();
		report.departmentname();
		report.studentName();
		report.studentId();
		report.studentDept();

	}

}
