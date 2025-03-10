package challenge.lv2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<MenuItem> menuList = new ArrayList<MenuItem>(); //장바구니에 담은 메뉴
    private List<Integer> count = new ArrayList<Integer>(); // 메뉴 몇개씩 샀나
    private List<Integer> price = new ArrayList<Integer>();
    private int totalPrice =0;

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

    }

    public void printCart(){
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
        System.out.println("위 장바구니를 주문 하시겠습니까?");
        System.out.println("1. 주문하기  |   2. 나가기 ");
    }

    public boolean orderMenu(int num){
        if(menuList.isEmpty()){
            System.out.println("주문하실 카테고리를 선택하세요.");
            System.out.println("===============================================================================================");
            return true;
        }else{
            System.out.println("=========================================[ 주문하기 ]===========================================");
            System.out.println("|| "+num+". 주문하기" + "\t\t || 총 "+ menuList.size()+"개의 메뉴를 담았습니다.");
            System.out.println("|| "+(num+1)+". 주문 취소하기"+ "\t\t || 주문 목록을 초기화합니다.");
            System.out.println("===============================================================================================");
            return false;
        }
    }

    public void applyDiscount(DiscountType discountType){
        totalPrice = discountType.discountPrice(totalPrice);
        System.out.println("======================<결제하실 금액>===========================");
        System.out.println("||\t 총 \t " + totalPrice + "원");
        System.out.println("=============================================================");
    }

    public void resetCart(){
        menuList.clear();
        count.clear();
    }
}
