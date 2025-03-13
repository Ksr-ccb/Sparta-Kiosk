package challenge.lv2;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * {@code UserInputManager} 클래스는 장바구니 객체입니다.
 * 키오스크에서 필요한 입력값을 바로 해당되는 자료형으로 받기 위해서, 입력값의 형태를 검증합니다.
 * inputIntegerValue 함수이외에도 다른 입력값이 피필요다하면 inputDoubleValue, inputStringValue 등 여러 함수가 추가될 수 있습니다.
 */
public class UserInputManager {
    /** 사용자 인풋을 받기위한 스캐너 */
    private final Scanner sc = new Scanner(System.in);

    /**
     * 받아온 입력값이 정수인지 확인하는 함수입니다.
     * @return {@code Integer.parseInt(inputStr)} - 정수값을 입력한 경우
     * @throws InputMismatchException - 그 외의 입력값은 모두 오류로 취급하여 throws 합니다.
     * 오류 처리는 kiosk에서 합니다.
     * 인풋 값의 바운더리가 상황에 따라서 계속 변동되기 때문에 try-catch문이 Kiosk에서 필요하기 떄문입니다.
     */
    public int inputIntegerValue() throws InputMismatchException{
            //정수만 입력받아야 함.
        String inputStr = sc.nextLine().trim();
        if (!inputStr.matches("\\d+")) {
            throw new InputMismatchException("숫자만 입력이 가능해요");
        }
        return Integer.parseInt(inputStr);
    }
}
