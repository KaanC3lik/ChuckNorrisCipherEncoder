import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] array = input.split(" ");

        String longestWord = longestWord = array[0];;

        for (int i = 0; i < array.length - 1; i++) {
            if (longestWord.length() < array[i + 1].length()) {
                longestWord = array[i + 1];
            }
        }
        System.out.println(longestWord);
    }
}