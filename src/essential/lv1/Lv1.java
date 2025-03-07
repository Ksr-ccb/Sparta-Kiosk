package essential.lv1;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Lv1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputInt = 0;
        boolean exitFlag = true;
        String selectMenu = "";

        while(exitFlag){
            System.out.println("////////////////////////////////////////////////< 맘스땃쥐 >///////////////////////////////////////////////////");
            System.out.println("/// 1. 싸이버거         | 4,900~ | 바삭하고 매콤한 치킨 패티와 신선한 양상추가 조화를 이루는 맘스터치 시그니처 버거.     ///");
            System.out.println("/// 2. 불싸이버거       | 5,100~ | 화끈한 불맛이 살아있는 버거, 싸이버거의 매운맛 버전.                             ///");
            System.out.println("/// 3. 불불불불싸이버거  | 6,800~ | 불싸이버거를 압도하는 살벌한 매운맛!                                           ///");
            System.out.println("/// 4. 화이트갈릭싸이버거 | 5,500~ | BEST 화이트갈릭이 싸이버거로 재탄생! 더블햄, 통다리살, 화이트갈릭소스의 환상 조합    ///");
            System.out.println("/// 5. 딥치즈싸이버거    | 5,400~ | BEST 딥치즈버거가 싸이버거로 재탄생! 진한 치즈소스와 통다리살 패티가 일품           ///");
            System.out.println("/// 0. 나가기                                                                                              ///");
            System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////");

            System.out.println("메뉴를 선택하세요.");

            try{
                inputInt = sc.nextInt();
                if(inputInt < 0 || inputInt > 5){
                    throw new InputMismatchException();
                }else if( inputInt == 0){
                    System.out.println("이용해주셔서 감사합니다.");
                    exitFlag = false;
                    continue;
                }
            }catch (InputMismatchException e) {
                System.out.println("메뉴에 있는 번호를 입력해주세요!");
                sc.nextLine();
                continue;
            }

            switch (inputInt){
                case 1 :
                    selectMenu = "싸이버거";
                    System.out.println("1. 싸이버거를 선택하셨습니다. 단품 4,900원~ | 세트 7,300원~ 입니다.");
                    break;
                case 2 :
                    selectMenu = "불싸이버거";
                    System.out.println("2. 불싸이버거를 선택하셨습니다. 단품 5,100원~ | 세트 7,500원~ 입니다.");
                    break;
                case 3 :
                    selectMenu = "불불불불싸이버거";
                    System.out.println("3. 불불불불싸이버거를 선택하셨습니다. 단품 6,800원~ | 세트 9,200원~ 입니다.");
                    break;
                case 4 :
                    selectMenu = "화이트갈릭싸이버거";
                    System.out.println("4. 화이트갈릭싸이버거를 선택하셨습니다. 단품 5,500원~ | 세트 7,900원~ 입니다.");
                    break;
                case 5 :
                    selectMenu = "딥치즈싸이버거";
                    System.out.println("5. 딥치즈싸이버거를 선택하셨습니다. 단품 5,400원~ | 세트 7,800원~ 입니다.");
                    break;
            }

            System.out.println("구매하시겠습니까?");
            System.out.println("1. 구매하기   |   2. 메뉴판으로 ");

            while(true){
                try{
                    inputInt = sc.nextInt();
                    if(inputInt == 1){
                        System.out.println(selectMenu + "를 구매합니다.");
                        System.out.println("메뉴판으로 돌아갑니다.");
                        break;
                    }else if( inputInt == 2){
                        System.out.println("구매를 진행하지 않고 메뉴판으로 돌아갑니다.");
                        break;
                    }else{
                        throw new InputMismatchException();
                    }
                }catch (InputMismatchException e) {
                    System.out.println("메뉴에 있는 번호를 입력해주세요!");
                    sc.nextLine();
                }
            }
        }
    }
}
