import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputSplitted = input.split("-");
        System.out.println(inputSplitted[1] + "/" + inputSplitted[2] + "/" + inputSplitted[0]);
    }
}