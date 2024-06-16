import java.util.Scanner;

public class Main {
    public static  void main(String[] args){
        Scanner readInput = new Scanner(System.in);
        
        System.out.print("Enter grades: ");
        String[] userInput = readInput.nextLine().split(" ");
        readInput.close();

        int[] grades = new int[userInput.length];
        for (int i = 0; i < grades.length; i++) {
            grades[i]= Integer.parseInt(userInput[i]);
        }

        int minGrade = 100;
        int maxGrade = 0;
        double sum = 0;
        for (int grade : grades) {
            if (grade > maxGrade)
                maxGrade = grade;
            if (grade < minGrade)
                minGrade = grade;
            sum+=grade;
        }
        double averageGrade = sum/(grades.length);

        int[] stats = new int[5];
        for (int grade : grades) {
            if (grade > 80) {
                stats[4]++;
            } else if (grade >= 61) {
                stats[3]++;
            } else if (grade >= 41) {
                stats[2]++;
            } else if (grade >= 21) {
                stats[1]++;
            } else {
                stats[0]++;
            }
        }
        int highestFrequency = 0;
        for (int stat:stats){
            if (stat>highestFrequency)
                highestFrequency=stat;
        }
        System.out.println("Maximum grade: " + maxGrade);
        System.out.println("Minimum grade: " + minGrade);
        System.out.println("Average grade: " + averageGrade);

        System.out.println("Graph:\n");
        for (int i = highestFrequency+2; i > 0; i--) {
            System.out.print(i + "\t>\t");

            for (int frequency : stats) {
                if (frequency >= i) {
                    System.out.print("####### \t");
                } else {
                    System.out.print("        \t");
                }
            }
            System.out.println();
        }
        System.out.println("\t+------------+-----------+-----------+-----------+------------+");
        System.out.println("\tI    0-20    I   21-40   I   41-60   I   61-80   I   81-100   I");

    }
}