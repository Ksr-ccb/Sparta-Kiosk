package essential.lv4And5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menuList;
    private Scanner sc = new Scanner(System.in);
    private int categoryInput = 0;
    private int itemInput = 0;
    private int paymentInput = 0;

    private boolean exitFlag = true;
    private String selectMenu = "";

    Kiosk(List<Menu> menuList){
        this.menuList = menuList;
    }

    public void startKiosk() {
        System.out.println("방문을 환영합니다. 서비스를 시작합니다.");
        exitFlag =true;
        boolean cont;
        boolean showMenu = false;

        while(exitFlag){
            inputCategory();
            Menu selectedMenu = menuList.get(categoryInput-1);
            
            cont = inputMenu(selectedMenu);
            if(!cont){
                continue;
            }
            selectMenu = selectedMenu.selectMenuItem(itemInput - 1);
            System.out.println("구매하시겠습니까?");
            System.out.println("1. 구매하기   |   2. 메뉴판으로 ");
            inputPayment();
        }
    }

    private void printCategory(){
        //카테고리 출력
        System.out.println("===============================================< 맘스땃쥐 >===================================================");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println("|| " + (i + 1) + ". " + menuList.get(i).getCategoryName());
        }
        System.out.println("|| 0. 나가기 ");
        System.out.println("=============================================================================================================");
        System.out.println("주문하실 카테고리를 선택하세요.");
        System.out.println("=============================================================================================================");
    }

    private void inputCategory(){
        boolean flag = true;
        while (flag) {
            printCategory();

            try {
                categoryInput = sc.nextInt();
                if (categoryInput < 0 || categoryInput > menuList.size()) {
                    throw new InputMismatchException();
                } else if (categoryInput == 0) {
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                }else{
                    System.out.println(menuList.get(categoryInput-1).getCategoryName()+"(이)가 선택되었습니다.");
                    flag=false;
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴에 있는 번호를 입력해주세요!");
                sc.nextLine();
            }
        }
    }

    private boolean inputMenu(Menu selectedMenu){
        boolean flag = true;
        while (flag) {
            selectedMenu.printMenuItems(); //해당 카테고리의 음식 출력
            try {
                itemInput = sc.nextInt();
                if (itemInput < 0 || itemInput > selectedMenu.getMenuItems().size()) {
                    throw new InputMismatchException();
                } else if (itemInput == 0) {
                    System.out.println("카테고리로 돌아갑니다.");
                    return false;
                }
                return true;
            } catch (InputMismatchException e) {
                System.out.println("메뉴에 있는 번호를 입력해주세요!");
                sc.nextLine();
            }
        }
        return true;
    }

    private void inputPayment(){
        while (true) {
            try {
                paymentInput = sc.nextInt();
                if (paymentInput == 1) {
                    System.out.println(selectMenu + "를 구매합니다.");
                    System.out.println("초기화면으로 돌아갑니다.");
                    break;
                } else if (paymentInput == 2) {
                    System.out.println("구매를 진행하지 않고 초기화면으로 돌아갑니다.");
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