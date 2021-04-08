package com.jerin.javaprogramming.designpatterns;

import com.jerin.javaprogramming.designpatterns.Student.StudentBuilder;

public class SimpleBuilder {

	public static void main(String[] args) {
		Student std1 = StudentBuilder.getInstance().setId("1").setName("Jerin").setPhone("111111")
				.setAddress("Trivandrum").build();

		Student std2 = StudentBuilder.getInstance().setId("2").setName("Staphy").setPhone("222222").setAddress("Mumbai")
				.build();

		System.out.println(std1);
		System.out.println(std2);
	}

}

class Student {
	private String id;
	private String name;
	private String address;
	private String phone;

	public Student(StudentBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.address = builder.address;
		this.phone = builder.phone;
	}

	public static class StudentBuilder {
		private String id;
		private String name;
		private String address;
		private String phone;

		public static StudentBuilder getInstance() {
			return new StudentBuilder();
		}

		public StudentBuilder setId(String id) {
			this.id = id;
			return this;
		}

		public StudentBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public StudentBuilder setAddress(String address) {
			this.address = address;
			return this;
		}

		public StudentBuilder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public Student build() {
			return new Student(this);
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.name);
		sb.append(" , " + this.id);
		sb.append(" , " + this.address);
		sb.append(" , " + this.phone);
		return sb.toString();
	}
}
