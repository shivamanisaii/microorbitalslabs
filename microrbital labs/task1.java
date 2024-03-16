/**
 * task1
 */
import java.util.Scanner;
 public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string :-");
        String word= sc.nextLine();
        System.out.print("your string is ");
        System.out.println(word);
        int count=0;
        for(int i=0; i<word.length(); i++){
            count++;
        }
        System.out.print("your string has " +count);
        System.out.println(" characters");
    }
    
}