package challenge.lv2;

import java.util.ArrayList;
import java.util.List;


/**
 * {@code Menu} 클래스는 지정된 카테고리의 메뉴 아이템들을 관리하는 역할을 합니다.
 * 각 메뉴는 {@link MenuItem} 리스트로 구성됩니다.
 */
public class Menu {

    /** 카테고리 이름 */
    private String categoryName = "";

    /** 카테고리 번호 */
    private int categoryNum;

    /** 관리할 메뉴 아이템 리스트  */
    private List<MenuItem> menuItems = new ArrayList<>();

    /**
     * 새로운 {@code Menu} 객체를 생성합니다.
     *
     * @param menuItems     해당 카테고리에 포함될 {@link MenuItem} 리스트
     * @param categoryName  카테고리 이름
     * @param categoryNum   카테고리 번호
     */
    Menu(List<MenuItem> menuItems, String categoryName, int categoryNum){
        this.menuItems = menuItems;
        this.categoryName = categoryName;
        this.categoryNum = categoryNum;
    }

    /**
     * 카테고리 번호를 반환합니다.
     *
     * @return 카테고리 번호
     */
    public int getCategoryNum() {
        return categoryNum;
    }

    /**
     * 카테고리 이름을 반환합니다.
     *
     * @return 카테고리 이름
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 현재 카테고리에 포함된 모든 메뉴 아이템 리스트를 반환합니다.
     *
     * @return {@link MenuItem} 리스트
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    /**
     * 특정 인덱스의 메뉴 아이템을 선택하고, 선택한 아이템의 정보를 출력합니다.
     *
     * @param index 선택할 메뉴의 인덱스 (0부터 시작)
     * @return 선택된 {@link MenuItem}
     */
    public MenuItem selectMenuItem(int index){
        MenuItem selected = menuItems.get(index);
        if(selected.getSetPrice() == 0){
            System.out.println((index + 1) + ". " + selected.getName() + "를 선택하셨습니다. 가격은 " + selected.getSinglePrice() + "원~ 입니다.");
        }else {
            System.out.println((index + 1) + ". " + selected.getName() + "를 선택하셨습니다. 단품 " + selected.getSinglePrice() + "원~ | 세트 " + selected.getSetPrice() + "원~ 입니다.");
        }
        return menuItems.get(index);
    }

    /**
     * 현재 카테고리에 포함된 모든 메뉴 아이템을 콘솔에 출력합니다.
     * 사용자가 선택할 수 있도록 메뉴 목록을 보여줍니다.
     */
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
