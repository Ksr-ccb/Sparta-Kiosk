package challenge.lv2;

import java.util.InputMismatchException;
import java.util.List;

public class Kiosk {
    private final List<Menu> menuList;
    private final ShoppingCart shoppingCart;
    private final UserInputManager userInputManager;

    private int categoryInput = 0; //어떤 서비스 이용할 것인지
    private int itemInput = 0; // 어떤 메뉴를 입력 했는지

    private boolean isCartEmpty = true; //장바구니가 비어있나?

    Kiosk(List<Menu> menuList, ShoppingCart shoppingCart, UserInputManager userInputManager){
        this.menuList = menuList;
        this.shoppingCart = shoppingCart;
        this.userInputManager = userInputManager;
    }

    public void startKiosk() {
        System.out.println("방문을 환영합니다. 서비스를 시작합니다.");

        while(true){
            inputCategory(); //카테고리 보여주고 입력받기

            //카테고리화면에서 나가기햇음
            if(categoryInput == 0){
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }

            //카테고리 입력란
            if( categoryInput <= menuList.size()){
                //<메뉴선택>
                System.out.println(menuList.get(categoryInput-1).getCategoryName()+"(이)가 선택되었습니다.");

                Menu selectedMenu;
                selectedMenu = menuList.get(categoryInput-1);// 카테고리 맞는 메뉴가져오기
                if(!inputMenu(selectedMenu)){ continue; };// 입력받은 카테고리에 맞는 메뉴 보여주고 메뉴 입력받기
                inputOrder(selectedMenu); // 장바구니 담을까?

            }else if (categoryInput == menuList.size() +1){ // 장바구니 들어감
                // <장바구니 출력>
                System.out.println("장바구니(이)가 선택되었습니다. 장바구니를 출력합니다.");
                browseCart();
            }else{
                //<장바구니 초기화>
                System.out.println("주문 취소 하기(이)가 선택되었습니다. 장바구니를 초기화합니다.");
                shoppingCart.resetCart();
            }
        }
    }

    //장바구니 탐색하기
    private void browseCart() {
        while (true) {
            shoppingCart.printCart(); //장바구니 내용출력
            System.out.println("이용하실 서비스를 선택해주세요.");
            System.out.println("1. 주문하기  |  2. 장바구니 수정하기  |  0. 나가기 ");
            try {
                itemInput = userInputManager.inputIntegerValue();
                if (itemInput < 0 || itemInput > 3) {
                    throw new InputMismatchException();
                } else if (itemInput == 1) { //구매
                    System.out.println("결제 화면으로 이동합니다.");
                    hasDiscount(); //할인적용
                    purchaseCart();
                    return;
                } else if (itemInput == 2 ){
                    //장바구니 수정
                    if(inputEditItem()){
                        return;
                    };
                } else{
                    System.out.println("카테고리로 돌아갑니다.");
                    return;
                    // 돌아가기
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴에 있는 번호를 입력해주세요!");
            }
        }
    }

    // 수정할 아이템 고르는 인풋 받기
    private boolean inputEditItem() {
        while (true) {
            shoppingCart.printEditMenu(); //장바구니 내용출력
            System.out.println("삭제할 메뉴를 선택해주세요.");
            try {
                itemInput = userInputManager.inputIntegerValue();
                if (itemInput < 0 || itemInput > shoppingCart.getCartLength()) {
                    throw new InputMismatchException();
                } else if (itemInput == 0) {
                    System.out.println("장바구니로 돌아갑니다.");
                    return false;
                }else{
                    shoppingCart.setCartItem(itemInput -1 );
                    // 돌아가기
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴에 있는 번호를 입력해주세요!");
            }
        }
    }

    private void printCategory(){
        int length = menuList.size();
        //카테고리 출력
        System.out.println("========================================< 맘스땃쥐 >============================================");

        menuList.stream()
                .forEach(value->{
                        System.out.println("|| " + value.getCategoryNum()+ ". " + value.getCategoryName());
                    }
                );
        System.out.println("|| 0. 나가기 ");
        System.out.println("===============================================================================================");
        isCartEmpty = shoppingCart.orderMenu(length+1);
    }

    // 어떤 카테고리 사용할지 입력 받기
    private void inputCategory(){
        int length=0;

        while (true) {
            printCategory();
            if(isCartEmpty){
                length = menuList.size();
            }else{
                length = menuList.size()+2;
            }
            try{
                categoryInput = userInputManager.inputIntegerValue();
                if (categoryInput < 0 || categoryInput > length) {
                    throw new InputMismatchException();
                }else{
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴에 있는 번호를 입력해주세요!");
            }
        }
    }

    // 음식 메뉴를 선택하기
    private boolean inputMenu(Menu selectedMenu){
        while (true) {
            selectedMenu.printMenuItems(); //해당 카테고리의 음식 출력
            try {
                itemInput = userInputManager.inputIntegerValue();
                if (itemInput < 0 || itemInput > selectedMenu.getMenuItems().size()) {
                    throw new InputMismatchException();
                } else if (itemInput == 0) {
                    System.out.println("카테고리로 돌아갑니다.");
                    return false;
                }
                return true;
            } catch (InputMismatchException e) {
                System.out.println("메뉴에 있는 번호를 입력해주세요!");
            }
        }
    }

    // 결제하기
    private void purchaseCart(){
        int purchaseInput;

        System.out.println("위 메뉴를 구매 하시겠습니까?");
        System.out.println("1. 결제하기   |   0. 돌아가기 ");
        while (true) {
            try {
                purchaseInput = userInputManager.inputIntegerValue();
                if (purchaseInput == 1){
                    System.out.println("장바구니 목록을 구매합니다.");
                    //구매
                    shoppingCart.resetCart(); //장바구니 초기화
                    System.out.println("초기화면으로 돌아갑니다.");
                    break;
                } else if (purchaseInput == 0) {
                    System.out.println("구매를 진행하지 않습니다.");
                    break;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴에 있는 번호를 입력해주세요!");
            }
        }
    }

    //할인 적용하기
    private void hasDiscount(){
        DiscountType discountType;
        int discountInput;

        while (true) {
            printDiscount(); // 할인적용
            System.out.println("할인 적용이 있으신가요?");
            try {
                discountInput = userInputManager.inputIntegerValue();
                if (discountInput == 1) {
                    discountType = DiscountType.Coupon;
                    break;
                } else if (discountInput == 2) {
                    discountType = DiscountType.Cash;
                    break;
                } else if (discountInput ==3 ){
                    discountType = DiscountType.General;
                    break;
                } else{
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴에 있는 번호를 입력해주세요!");
            }
        }
        shoppingCart.applyDiscount(discountType);
    }


    //장바구니 담기 여부 입력받기
    private void inputOrder(Menu selectedMenu){
        MenuItem selectMenu = selectedMenu.selectMenuItem(itemInput - 1);
        int orderInput ;
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 장바구니에 담기   |   0. 메뉴판으로 ");

        while (true) {
            try {
                orderInput = userInputManager.inputIntegerValue();
                if (orderInput == 1) {
                    shoppingCart.addCart(selectMenu);
                    System.out.println(selectMenu.getName() + "를 장바구니에 담습니다.");
                    System.out.println("초기화면으로 돌아갑니다.");
                    break;
                } else if (orderInput == 0) {
                    System.out.println("구매를 진행하지 않고 초기화면으로 돌아갑니다.");
                    break;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴에 있는 번호를 입력해주세요!");
            }
        }
    }
    public void printDiscount(){
        System.out.println("=========================[ 주문하기 ]=============================");
        System.out.println("|| 1. 3000원 할인 쿠폰(1만원 이상 시 사용가능) ");
        System.out.println("|| 2. 현금 결제(10%) ");
        System.out.println("|| 3. 할인 적용 하지않기");
        System.out.println("=================================================================");
    }

}