package essential.lv4And5;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private String categoryName = "";
    private int categoryNum;
    private List<MenuItem> menuItems = new ArrayList<>();

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

    public String selectMenuItem(int index){
        MenuItem selected = menuItems.get(index);
        if(selected.getSetPrice() == 0){
            System.out.println((index + 1) + ". " + selected.getName() + "를 선택하셨습니다. 가격은 " + selected.getSinglePrice() + "원~ 입니다.");
        }else {
            System.out.println((index + 1) + ". " + selected.getName() + "를 선택하셨습니다. 단품 " + selected.getSinglePrice() + "원~ | 세트 " + selected.getSetPrice() + "원~ 입니다.");
        }
        return menuItems.get(index).getName();
    }

    public void printMenuItems(){
        System.out.println("===============================================< 맘스땃쥐 >===================================================");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem tempItem = menuItems.get(i);
            System.out.println("|| " + (i + 1) + ". " + tempItem.getName() + "\t | " + tempItem.getSinglePrice() + " | " + tempItem.getInfo());
        }
        System.out.println("|| 0. 카테고리로 돌아가기 ");
        System.out.println("=============================================================================================================");
        System.out.println("메뉴를 선택하세요.    |  " + menuItems.size() + "가지 메뉴 선택이 가능합니다.");
    }

}
