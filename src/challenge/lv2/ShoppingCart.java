package challenge.lv2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<MenuItem> menuList = new ArrayList<MenuItem>(); //장바구니에 담은 메뉴
    private List<Integer> count = new ArrayList<Integer>(); // 메뉴 몇개씩 샀나
    private List<Integer> price = new ArrayList<Integer>();
    private int totalPrice =0;
    private int totalCount = 0;

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

    public int getCartLength(){
        return menuList.size();
    }

    public void printCart(){ //장바구니 목록 출력
        totalPrice=0;
        System.out.println("========================<장바구니 목록>==========================");
        for(int i = 0; i<menuList.size(); i++){
            System.out.println("||" + menuList.get(i).getName() +"\t "+menuList.get(i).getSinglePrice()+"원 \t  X " + count.get(i) + "\t \t " + price.get(i) +"원");
        }
        System.out.println("\n =========================<총 금액>===========================");
        for (Integer integer : price) {
            totalPrice += integer;
        }
        System.out.println("||\t 총 \t " + totalPrice + "원");
        System.out.println("=============================================================");
    }


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

    public void applyDiscount(DiscountType discountType){ // 할인종류 받아서 전체금액 조정
        totalPrice = discountType.discountPrice(totalPrice);
        System.out.println("======================<결제하실 금액>===========================");
        System.out.println("||\t 총 \t " + totalPrice + "원");
        System.out.println("=============================================================");
    }

    public void resetCart(){ //장바구니 초기화
        menuList.clear();
        count.clear();
        price.clear();
        totalCount = 0;
    }

    public void printEditMenu(){
        totalPrice=0;
        System.out.println("========================<장바구니 목록>==========================");
        for(int i = 0; i<menuList.size(); i++){
            System.out.println("||" + (i+1) +". "+ menuList.get(i).getName() +"\t "+menuList.get(i).getSinglePrice()+"원 \t  X " + count.get(i) + "\t \t " + price.get(i) +"원");
        }
        System.out.println("||0. 돌아가기 ");
        System.out.println("\n =========================<총 금액>===========================");
        for (Integer integer : price) {
            totalPrice += integer;
        }
        System.out.println("||\t 총 \t " + totalPrice + "원");
        System.out.println("=============================================================");

    }


    public void setCartItem(int index){
        System.out.println((index+1) + "번 "+menuList.get(index).getName() + "을 장바구니에서 제외합니다.");

        totalPrice -= price.get(index);
        totalCount -= count.get(index);

        menuList.remove(index);
        count.remove(index);
        price.remove(index);
    }
}
