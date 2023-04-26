/**
 * @class: Cipher
 * @author: Kevin Vergara
 * @verison 1.0
 * @course: ITEC 2140 - 04, Spring 20023
 * @written: April 24, 23
 * description: This program takes inputs from the user to make a caesar cipher that shifts
 * the string by the amount the user wants.
 */
package Cipher;
import java.util.Scanner;

public class Main {
    public static String abc (){
        String Alphabet = "abcdefghijklmnopqrstuvwxyz";
        return Alphabet;
    }
    public static String Cipher (String message,int amount,String temp){
        String newMessage = "";
        if (temp.charAt(0) == 'E' || temp.charAt(0) == 'e') {
            for (int i = 0; i < message.length(); i++) {
                int charNum = abc().indexOf(message.charAt(i));
                if (message.indexOf(i) == ' ') {
                    char txt = ' ';
                    newMessage += txt;
                } else {
                    int shift = (charNum + amount) % 26;
                    char txt = abc().charAt(shift);
                    newMessage += txt;
                }
            }
        }else if (temp.charAt(0) == 'D' || temp.charAt(0) == 'd') {
            for (int i = 0; i < message.length(); i++) {
                int charNum = abc().indexOf(message.charAt(i));
                int shift = (charNum - amount) % 26;
                char txt = abc().charAt(shift);
                newMessage += txt;
            }
        } else {
            return "Invalid input";
        }
        return newMessage;
    }
    public static void main(String[] args) {
        System.out.println("Enter a message to encrypt or decrypt: ");
        Scanner input = new Scanner(System.in);
        String message = input.nextLine();
        System.out.println("Enter E to encrypt or D to decrypt: ");
        String temp = input.nextLine();
        System.out.println("Enter an integer key value that will be used to encrypt or decrypt: ");
        int amount = input.nextInt();

        System.out.println(Cipher(message,amount,temp));
    }
}