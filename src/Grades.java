
import java.util.Scanner;

public class Grades {
	public static void main(String[] args) {
		
		// 1) input 8 grades for 1 student
		Scanner sc = new Scanner(System.in);
		int[] studentGrades = new int[8];
		for(int i=0;i<8;i++)
		{
			if(i < 4) {
				System.out.print("Enter next exam (max 50): ");
			}
			else {
				System.out.print("Enter next assignment (max 75): ");
			}
			int grade = sc.nextInt();
			studentGrades[i] = grade;
		}
		
		// 2) display final grade for students
		int total = 0;
		for(int i=0;i<8;i++) {
			total = total + studentGrades[i];
		}
		System.out.println("Final score: " + total);
		
		if(total >= 450) {
			System.out.println("A");
		}
		else if(total >= 400) {
			System.out.println("B");
		}
		else if(total >= 350) {
			System.out.println("C");
		}
		else if(total >= 300) {
			System.out.println("D");			
		}
		else {
			System.out.println("F");			
		}
			
		
		// 3) ask the user how many OTHER student grades there are
		System.out.print("Lets input some more students final scores, how many TOTAL students are in the class? ");
		int totalStudents = sc.nextInt();
		int[] allGrades = new int[totalStudents];
		allGrades[0] = total; //total is from prior student
		
		// 4) input ONLY final grades for those students
		for(int i=1;i<totalStudents;i++)
		{
			System.out.print("What was the FINAL grade for the next student? ");
			allGrades[i] = sc.nextInt();
		}
		
		System.out.println("Including the student you entered at the beginning, all final grades are");
		for(int i=0;i<totalStudents;i++)
		{
			System.out.print(allGrades[i] + " ");
		}
		System.out.println("");
		
		// 5) Calculate and display standard deviation of all scores
		double grandTotal = 0.0;		
		for(int i=0;i<totalStudents;i++)
		{
			grandTotal = grandTotal + allGrades[i];
		}
		double mean = grandTotal/totalStudents;
		System.out.println("Mean: " + mean);
		
		double totalVariance = 0.0;
		for(int i=0;i<totalStudents;i++)
		{
			double diffFromMean = allGrades[i] - mean;
			double variance = diffFromMean*diffFromMean;
			totalVariance = totalVariance + variance;
		}
		double varianceMean = totalVariance/totalStudents;
		double stdDev = Math.sqrt(varianceMean);
		System.out.println("Std Dev: " + stdDev);
				
		// 6) display grade using 2nd criterion.
		System.out.println("Lucky you!  Your grade is now:");
		if(total >= mean + 2*stdDev) {
			System.out.println("A");
		}
		else if(total >= mean + stdDev) {
			System.out.println("B");
		}
		else if(total >= mean) {
			System.out.println("C");
		}
		else if(total >= mean - stdDev) {
			System.out.println("D");
		}
		else {
			System.out.println("F");
		}
			
		
	}
}
