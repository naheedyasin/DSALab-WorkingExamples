import java.util.Scanner;

public class sumOfN{
    public static void main(String[] args) {
        int sum = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a positive integer: ");
        int num = sc.nextInt();

        for(int i = 1;i<= num;i++){
            sum += i;
        }

        System.out.println("The sum of the first "+num+" natural numbers is = "+sum);

    }
}