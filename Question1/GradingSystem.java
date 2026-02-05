

package groupm.gradingsystem;

import java.util.Scanner;
public class GradingSystem {
   
    public static void main(String[] args) {

        int grade1 = 0, grade2 = 0, grade3 = 0, grade4 = 0, grade5 = 0;
        int grade6 = 0, grade7 = 0, grade8 = 0, grade9 = 0;

        int count = 1;
        Scanner input = new Scanner(System.in);

        while (count <= 5) {
            System.out.print("Enter score for student " + count + ": ");
            int score = input.nextInt();

            int grade = 0;
            String remark = "";

            if (score >= 80 && score <= 100) {
                grade = 1;
                remark = "D1";
                grade1++;
            } else if (score >= 75) {
                grade = 2;
                remark = "D2";
                grade2++;
            } else if (score >= 66) {
                grade = 3;
                remark = "C3";
                grade3++;
            } else if (score >= 60) {
                grade = 4;
                remark = "C4";
                grade4++;
            } else if (score >= 50) {
                grade = 5;
                remark = "C5";
                grade5++;
            } else if (score >= 45) {
                grade = 6;
                remark = "C6";
                grade6++;
            } else if (score >= 35) {
                grade = 7;
                remark = "P7";
                grade7++;
            } else if (score >= 30) {
                grade = 8;
                remark = "P8";
                grade8++;
            } else {
                grade = 9;
                remark = "F";
                grade9++;
            }

            System.out.println("Score: " + score);
            System.out.println("Grade: " + grade);
            System.out.println("Remark: " + remark);
            System.out.println("---------------------");

            count++;
        }

        // Summary
        System.out.println("\n--- SUMMARY ---");
        System.out.println("Grade 1: " + grade1);
        System.out.println("Grade 2: " + grade2);
        System.out.println("Grade 3: " + grade3);
        System.out.println("Grade 4: " + grade4);
        System.out.println("Grade 5: " + grade5);
        System.out.println("Grade 6: " + grade6);
        System.out.println("Grade 7: " + grade7);
        System.out.println("Grade 8: " + grade8);
        System.out.println("Grade 9: " + grade9);

        input.close();
    }
}
    