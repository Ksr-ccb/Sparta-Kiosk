package essential.lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    String categoryName = "";
    int categoryNum;
    List<MenuItem> menuItems = new ArrayList<>();

    Menu(List<MenuItem> menuItems, String categoryName, int categoryNum){
        this.menuItems = menuItems;
        this.categoryName = categoryName;
        this.categoryNum = categoryNum;
    }

    public int getCategoryNum() {
        return categoryNum;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public List<MenuItem> selectCategory(int index){
        return switch (index){
            case 0 -> bugers;
            case 1 -> sides;
            case 2 -> chickens;
            default -> throw new IllegalStateException("Unexpected value: " + index);
        };
    }

    public void printMenuList(){

    }

    public void printMenuItems(){
        System.out.println("===============================================< 맘스땃쥐 >===================================================");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem tempItem = menuItems.get(i);
            System.out.println("|| " + (i + 1) + ". " + tempItem.getName() + "\t | " + tempItem.getSinglePrice() + " | " + tempItem.getInfo());
        }
        System.out.println("|| 0. 나가기 ");
        System.out.println("=============================================================================================================");
        System.out.println("메뉴를 선택하세요.    |  " + menuItems.size() + "가지 메뉴 선택이 가능합니다.");
    }
}
