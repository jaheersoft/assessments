package com.workouts.problems.producerconsumer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PatientQueue {

	public static void main(String[] args) {

		// Priority
		// NORMAL 1
		// Emergency 2

		boolean exit = false;

		String pName;
		int pPriority;
		int pId;
		// Create Patient priority comparator, so,
		// priorityQueue class can decide
		// whom to put on head of the list.
		Comparator<Patient> queueComparator = new PatientPriorityComparator();

		// Create a priory queue and assign a comparator to its constructor.
		// Set the initial capacity of the queue to 10 or something.
		Queue<Patient> priorityQueue = new PriorityQueue<>(10, queueComparator);

		do {
			// Display options for input data, display list
			// and exit application
			System.out.println("1.Input");
			System.out.println("2.Display list");
			System.out.println("3.Exit");

			// Read option from console
			Scanner option = new Scanner(System.in);
			System.out.println("enter your choice");
			int num = option.nextInt();

			switch (num) {
			case 1:
				// Enter patient name and priority
				Scanner input = new Scanner(System.in);
				System.out.println("Enter Patient ID:");
				pId = (input.nextInt());
				input.nextLine();
				System.out.println("Enter Patient name:");
				pName = input.nextLine();
				System.out.println("Enter priority:");
				pPriority = (input.nextInt());

				Patient obj = new Patient(pId, pName, pPriority);
				priorityQueue.add(obj);
				break;

			case 2:
				// Display patients list1

				while (priorityQueue.size() != 0) {
					// poll () method will display the list
					// and remove head element from the list.
					System.out.println("Patient\t" + priorityQueue.poll().getName());
				}
				break;

			case 3:
				exit = true;
				break;
			}
		} while (!exit);
	}
}
