package essential.lv4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<Menu> menuList;
    Scanner sc = new Scanner(System.in);
    int inputInt = 0;
    boolean exitFlag = true;
    String selectMenu = "";

    Kiosk(List<Menu> menuList){
        this.menuList = menuList;
    }

    public void startKiosk() {
        System.out.println("===============================================< 맘스땃쥐 >===================================================");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println("|| " + (i + 1) + ". " + menuList.get(i).getCategoryName());
        }
        System.out.println("=============================================================================================================");
        System.out.println("주문하실 카테고리를 선택하세요.    |  " + menuList.length + "가지 메뉴 선택이 가능합니다.");


        while (exitFlag) {
            menu.printMenuItems();
            try {
                inputInt = sc.nextInt();
                if (inputInt < 0 || inputInt > menuItems.size()) {
                    throw new InputMismatchException();
                } else if (inputInt == 0) {
                    System.out.println("이용해주셔서 감사합니다.");
                    exitFlag = false;
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴에 있는 번호를 입력해주세요!");
                sc.nextLine();
                continue;
            }

            selectMenu = selectMenu(menuItems, inputInt - 1);
            System.out.println("구매하시겠습니까?");
            System.out.println("1. 구매하기   |   2. 메뉴판으로 ");

            while (true) {
                try {
                    inputInt = sc.nextInt();
                    if (inputInt == 1) {
                        System.out.println(selectMenu + "를 구매합니다.");
                        System.out.println("메뉴판으로 돌아갑니다.");
                        break;
                    } else if (inputInt == 2) {
                        System.out.println("구매를 진행하지 않고 메뉴판으로 돌아갑니다.");
                        break;
                    } else {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("메뉴에 있는 번호를 입력해주세요!");
                    sc.nextLine();
                }
            }
        }
    }
    public String selectMenu(List<MenuItem> menuItems, int index) {
        MenuItem selected = menuItems.get(index);
        System.out.println((index + 1) + ". " + selected.getName() + "를 선택하셨습니다. 단품 " + selected.getSinglePrice() + "원~ | 세트 " + selected.getSetPrice() + "원~ 입니다.");
        return menuItems.get(index).getName();
    }
}