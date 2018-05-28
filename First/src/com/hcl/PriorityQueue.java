package com.hcl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Student {
	private int id;
	private String name;
	private double cgpa;

	public Student(int id, String name, double cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getCgpa() {
		return cgpa;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cgpa=" + cgpa + "]";
	}

}

class Priorities {
	public static Comparator<Student> studentComparator = new Comparator<Student>() {

		@Override
		public int compare(Student s1, Student s2) {
			if (s1.getCgpa() == s2.getCgpa()) {
				if (s1.getName().equals(s2.getName())) {
					return (((Integer) s1.getId()).compareTo((Integer) s2.getId()));
				} else {
					return s1.getName().compareTo(s1.getName());
				}
			} else {
				return -((Double) s1.getCgpa()).compareTo((Double) s2.getCgpa());// (int)
																					// (((Double)s1.getCgpa())-(Double)s2.getCgpa());
			}

		}
	};

	// public static java.util.PriorityQueue<Student> pQueue=new
	// java.util.PriorityQueue<>(studentComparator);
	// java.util.PriorityQueue<Student> pQueue= new
	// java.util.PriorityQueue<Student>(12,Comparator.comparing(Student::getCgpa));

	Queue<Student> pQueue = new LinkedList<Student>();

	List<Student> getStudents(List<String> events) {
		for (String str : events) {
			String[] stringArray = str.split(" ");

			if (stringArray[0].equals("ENTER")) {
				pQueue.offer(new Student(Integer.parseInt(stringArray[3]), stringArray[1],
						Double.parseDouble(stringArray[2])));
			} else {
				Collections.sort((List<Student>) pQueue, studentComparator);
				// Collections.sort(pQueue,studentComparator);

				pQueue.poll();
			}
		}
		List<Student> resultList = new ArrayList(pQueue);
		return resultList;
	}
}

public class PriorityQueue {

	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}

		List<Student> students = priorities.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student st : students) {
				System.out.println(st.getName());
			}
		}
	}
}
