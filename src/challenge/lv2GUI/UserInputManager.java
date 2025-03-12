package challenge.lv2GUI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputManager {
    private final Scanner sc = new Scanner(System.in);

    public int inputIntegerValue() throws InputMismatchException{
            //정수만 입력받아야 함.
        String inputStr = sc.nextLine().trim();
        if (!inputStr.matches("\\d+")) {
            throw new InputMismatchException("숫자만 입력이 가능해요");
        }
        return Integer.parseInt(inputStr);
    }
}
