package challenge.lv2;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code ShoppingCart} 클래스는 장바구니 객체입니다.
 * 장바구니가 가질 수 있는 속성들인 {@link MenuItem} 리스트와 각각의 물품 갯수를 저장하는 count 리스트, 가격을 계산하는 price리스트가 있습니다.
 * 그 외에도 간단하게 get함수로 값을 얻기 위해 totalPrice, totalCount을 global로 사용합니다.
 */
public class ShoppingCart {
    /** 장바구니 목록 리스트 */
    private final List<MenuItem> menuList = new ArrayList<>(); //장바구니에 담은 메뉴

    /** 각 메뉴를 몇개씩 샀는지 저장하는 리스트 */
    private final List<Integer> count; // 메뉴 몇개씩 샀나

    /** 각 메뉴의 가격을 갯수에 맞게 저장하는 리스트*/
    private final List<Integer> price;

    /** 최종 계산에서 쓰이는 합계 가격*/
    private int totalPrice =0;

    /** 장바구니 안에 들어간 메뉴의 개수*/
    private int totalCount = 0;

    /**
     * 장바구니를 생성자
     */
    ShoppingCart() {
        count = new ArrayList<>();
        price = new ArrayList<>();
    }

    /**
     * 장바구니에 메뉴를 추가합니다.
     * @param item 이 추가됩니다.
     *             만약 같은 메뉴가 이미 담겨있다면 갯수와 가격 변동만 해줍니다.
     */
    public void addCart(MenuItem item){

        if(menuList.contains(item)){
            int index = menuList.indexOf(item);
            count.set(index, count.get(index) + 1);
            price.set( index, price.get(index) + item.getSinglePrice());
        }
        else{
            menuList.add(item);
            count.add(1);
            price.add(item.getSinglePrice());
        }

        totalCount++;
    }

    /**
     * 장바구니에 들어간 메뉴의 가짓수를 제공합니다.
     * @return 메뉴리스트의 길이를 리턴합니다.
     */
    public int getCartLength(){
        return menuList.size();
    }

    /**
     * 장바구니 목록을 출력합니다.
     * 목록과 담겨있는 메뉴들의 총 금액도 출력합니다.
     */
    public void printCart(){ //장바구니 목록 출력
        totalPrice=0;
        System.out.println("========================<장바구니 목록>==========================");
        for(int i = 0; i<menuList.size(); i++){
            System.out.println("||" + menuList.get(i).getName() +"\t "+menuList.get(i).getSinglePrice()+"원 \t  X " + count.get(i) + "\t \t " + price.get(i) +"원");
        }
        System.out.println("\n =========================<총 금액>===========================");
        totalPrice = price.stream().mapToInt(Integer::intValue).sum();
        System.out.println("||\t 총 \t " + totalPrice + "원");
        System.out.println("=============================================================");
    }

    /**
     * 총 금액을 반환합니다.
     * @return 총 금액
     */
    public int getTotalPrice(){
        return totalPrice;
    }

    /**
     * 카테고리 화면에서 장바구니 관련 내용을 출력
     * 만약 장바구니에 담긴 메뉴가 없다면 넘어가고, 있으면 카테고리 개수 +1에는 주문하기, +2에는 주문 취소하기를 출력합니다.
     * @param num 출력하고 잇는 카테고리의 총 개수
     * @return {@code true} - 장바구니 선택이 불가능한 경우
     *         {@code false} - 장바구니 선택이 가능한 경우 (사용자 입력 바운더리를 나중에 조정)
     */
    public boolean orderMenu(int num){ // 장바구니 메뉴있으면 밑에꺼, 없으면 출력안하게 해줌
        if(menuList.isEmpty()){
            System.out.println("주문하실 카테고리를 선택하세요.");
            System.out.println("===============================================================================================");
            return true;
        }else{
            System.out.println("=========================================[ 주문하기 ]===========================================");
            System.out.println("|| "+num+". 주문하기" + "\t\t || 총 "+ totalCount+"개의 메뉴를 담았습니다.");
            System.out.println("|| "+(num+1)+". 주문 취소하기"+ "\t\t || 주문 목록을 초기화합니다.");
            System.out.println("===============================================================================================");
            return false;
        }
    }

    /**
     * 할인 금액을 계산하고 출력.
     * @param discountType 들어온 타입에 맞게 할인을 진행하고 총 금액을 조정합니다.
     */
    public void applyDiscount(DiscountType discountType){ // 할인종류 받아서 전체금액 조정
        totalPrice = discountType.discountPrice(totalPrice);
        System.out.println("======================<결제하실 금액>===========================");
        System.out.println("||\t 총 \t " + totalPrice + "원");
        System.out.println("=============================================================");
    }

    /**
     * 장바구니를 초기화합니다(안의 내용을 모두 비워줍니다.
     * totalPrice같은 경우 장바구니 목록에 들어가야지 볼 수 있는데, 목록에 들어갈때 새롭게 계산하기 때문에 초기화 필요가 없습니다.
     */
    public void resetCart(){ //장바구니 초기화
        menuList.clear();
        count.clear();
        price.clear();
        totalCount = 0;
    }

    /**
     * 장바구니 수정 화면을 출력.
     * 기존의 목록 출력과 다르게 앞에 사용자 입력을 받을 수 있게 번호가 붙습니다.
     */
    public void printEditMenu(){
        totalPrice=0;
        System.out.println("========================<장바구니 목록>==========================");
        for(int i = 0; i<menuList.size(); i++){
            System.out.println("||" + (i+1) +". "+ menuList.get(i).getName() +"\t "+menuList.get(i).getSinglePrice()+"원 \t  X " + count.get(i) + "\t \t " + price.get(i) +"원");
        }
        System.out.println("||0. 돌아가기 ");
        System.out.println("\n =========================<총 금액>===========================");
        totalPrice = price.stream().mapToInt(Integer::intValue).sum();
        System.out.println("||\t 총 \t " + totalPrice + "원");
        System.out.println("=============================================================");
    }

    /**
     * 장바구니 수정 메서드
     * @param index 를 가지는 menuList를 제거해주고 그것에 맞게 수량과 금액을 조정합니다.
     */
    public void setCartItem(int index){
        System.out.println((index+1) + "번 "+menuList.get(index).getName() + "을 장바구니에서 제외합니다.");

        totalPrice -= price.get(index);
        totalCount -= count.get(index);

        menuList.remove(index);
        count.remove(index);
        price.remove(index);
    }
}
