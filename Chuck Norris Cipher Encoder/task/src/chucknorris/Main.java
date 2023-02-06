package chucknorris;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            boolean error = false;
            System.out.println();
            System.out.println("Please input operation (encode/decode/exit):");
            String inputOperation = scanner.nextLine();

            if (inputOperation.equals("encode")) {
                System.out.println("Input string:");

                String input = scanner.nextLine();

                System.out.println("Encoded string:");


                int oneCounter = 0;
                int zeroCounter = 0;
                for (int i = 0; i < input.length(); i++) {
                    String charachter = input.substring(i, i+1);
                    byte[] bytes = charachter.getBytes();

                    StringBuilder binary = new StringBuilder();
                    for (byte b : bytes) {
                        int val = b;
                        for (int j = 0; j < 8; j++)
                        {
                            binary.append((val & 128) == 0 ? 0 : 1);
                            val <<= 1;
                        }
                        binary.append(' ');
                    }
                    String subBinary = binary.substring(1,8);
                    for (int k = 0; k < subBinary.length(); k++) {
                        if (subBinary.charAt(k) == '1') {
                            if (zeroCounter == 0) {
                                oneCounter++;
                            }else {
                                System.out.print("00 ");
                                for (int l = 0; l < zeroCounter; l++) {
                                    System.out.print("0");
                                }
                                System.out.print(" ");
                                zeroCounter = 0;
                                oneCounter++;
                            }

                        }else {
                            if (oneCounter == 0) {
                                zeroCounter++;
                            }else {
                                System.out.print("0 ");
                                for (int l = 0; l < oneCounter; l++) {
                                    System.out.print("0");
                                }
                                System.out.print(" ");
                                oneCounter = 0;
                                zeroCounter++;
                            }
                        }
                    }
                    if (i == input.length() -1) {
                        if (zeroCounter < oneCounter) {
                            System.out.print("0 ");
                            for (int l = 0; l < oneCounter; l++) {
                                System.out.print("0");
                            }
                        }else {
                            System.out.print("00 ");
                            for (int l = 0; l < zeroCounter; l++) {
                                System.out.print("0");
                            }
                            oneCounter = 0;
                            zeroCounter++;
                        }
                    }
                }
            }else if (inputOperation.equals("decode")) {
                System.out.println("Input encoded string:");
                String code = scanner.nextLine();
                for (int i = 0; i < code.length(); i++) {
                    if (code.charAt(i) != ' ' && code.charAt(i) !='0') {
                        System.out.println("Encoded string is not valid.");
                        error = true;
                        break;
                    }
                }
                if (error) {
                    continue;
                }
                StringBuilder binary = new StringBuilder();
                int encoded = 0;
                int count = 0;
                char result;
                String[] codeArray = code.split(" ");
                if (codeArray.length % 2 != 0) {
                    System.out.println("Encoded string is not valid.");
                    continue;
                }
                for (int i = 0; i < codeArray.length; i += 2) {
                    if (codeArray[i].length() > 2) {
                        System.out.println("Encoded string is not valid.");
                        error = true;
                    }
                    boolean one = codeArray[i].length() == 1;
                    int howMany = codeArray[i+1].length();
                    if (one) {
                        binary.append("1".repeat(howMany));
                    }else {
                        binary.append("0".repeat(howMany));
                    }
                }
                if (error) {
                    continue;
                }
                if (binary.length() % 7 != 0) {
                    System.out.print("Encoded string is not valid.");
                    continue;
                }
                System.out.println();
                System.out.println("Decoded string:");
                for(int i = 0; i < binary.length(); i++) {
                    count++;
                    if (binary.charAt(i) == '1') {
                        encoded += (int) Math.pow(2, (6 - (i % 7)));
                    }
                    if (count % 7 == 0) {
                        result = (char) encoded;
                        System.out.print(result);
                        encoded = 0;
                    }
                }
            }else if (inputOperation.equals("exit")) {
                System.out.print("Bye!");
                exit = true;
            }else {
                System.out.println("There is no '" + inputOperation + "' operation");
            }
        }
    }
}