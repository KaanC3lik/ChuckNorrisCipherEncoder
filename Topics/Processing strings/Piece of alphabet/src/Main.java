import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean test = true;
        for (int i = 0; i < input.length() - 1; i++) {
            int intChar;
            int intChar2;
            intChar = input.charAt(i);
            intChar2 = input.charAt(i + 1);
            if (intChar + 1 != intChar2){
                test = false;
                break;
            }
        }
        System.out.println(test);
    }
}