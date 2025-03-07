package essential.lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("싸이버거", 4900, 7300, "바삭하고 매콤한 치킨 패티와 신선한 양상추가 조화를 이루는 맘스터치 시그니처 버거."));
        menuItems.add(new MenuItem("불싸이버거", 5100, 7500, "화끈한 불맛이 살아있는 버거, 싸이버거의 매운맛 버전."));
        menuItems.add(new MenuItem("불불불불싸이버거", 6800, 9200, "불싸이버거를 압도하는 살벌한 매운맛!"));
        menuItems.add(new MenuItem("화이트갈릭싸이버거", 5500, 7900, "EST 화이트갈릭이 싸이버거로 재탄생! 더블햄, 통다리살, 화이트갈릭소스의 환상 조합"));
        menuItems.add(new MenuItem("딥치즈싸이버거", 5400, 7800, "BEST 딥치즈버거가 싸이버거로 재탄생! 진한 치즈소스와 통다리살 패티가 일품"));

        int inputInt = 0;
        boolean exitFlag = true;
        String selectMenu = "";

        while(exitFlag){
            System.out.println("===============================================< 맘스땃쥐 >===================================================");
            for(int i =0; i < menuItems.size(); i++){
                MenuItem tempItem = menuItems.get(i);
                System.out.println("|| " + (i+1) + ". " + tempItem.getName() + "\t | " + tempItem.getSinglePrice() + " | " + tempItem.getInfo());
            }
            System.out.println("|| 0. 나가기 ");
            System.out.println("=============================================================================================================");
            System.out.println("메뉴를 선택하세요." + menuItems.size() + "가지 메뉴 선택이 가능합니다.");

            try{
                inputInt = sc.nextInt();
                if(inputInt < 0 || inputInt > menuItems.size()){
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

            selectMenu = selectMenu(menuItems,inputInt-1);
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

    static String selectMenu(List<MenuItem> menuItems,int index){
        MenuItem selected = menuItems.get(index);
        System.out.println((index+1) + ". "+selected.getName()+ "를 선택하셨습니다. 단품 "+selected.getSinglePrice()+"원~ | 세트 "+selected.getSetPrice()+"원~ 입니다.");
        return menuItems.get(index).getName();
    }
}
