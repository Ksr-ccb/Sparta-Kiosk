package challenge.lv2;

import java.util.InputMismatchException;
import java.util.List;

/**
 * {@code Kiosk} 클래스는 키오스크의 전체적인 흐름을 관리합니다.
 * 모든 메뉴인 {@link Menu} 리스트와 키오스크 진행에 필요한 {@link ShoppingCart},{@link UserInputManager}을 가집니다.
 * 그 외에 키오스크 흐름을 제어할 수 있는 변수들을 global로 가집니다.
 */
public class Kiosk {
    /** 전체 메뉴를 담는 {@link Menu} 리스트  */
    private final List<Menu> menuList;

    /** 장바구니 객체 */
    private final ShoppingCart shoppingCart;

    /** 사용자 입력을 받는 객체 */
    private final UserInputManager userInputManager;

    /** 어떤 서비스 이용할 것인지 flag 역할을 하는 값  */
    private int categoryInput = 0; //어떤 서비스 이용할 것인지

    /** 어떤 메뉴를 입력 했는지 저장하는 값  */
    private int itemInput = 0; // 어떤 메뉴를 입력 했는지

    /** 장바구니가 비어있나? 확인 여부  */
    private boolean isCartEmpty = true; //장바구니가 비어있나?

    /**
     * 새로운 {@code Menu} 객체를 생성합니다.
     *
     * @param menuList     전체 메뉴를 담는 {@link Menu} 리스트
     * @param shoppingCart  카테고리 이름
     * @param userInputManager   카테고리 번호
     */
    Kiosk(List<Menu> menuList, ShoppingCart shoppingCart, UserInputManager userInputManager){
        this.menuList = menuList;
        this.shoppingCart = shoppingCart;
        this.userInputManager = userInputManager;
    }

    /**
     * 키오스크를 작동하는 함수
     * 작동 흐름은 <a href="https://github.com/Ksr-ccb/Sparta-Kiosk?tab=readme-ov-file">키오스크 readme.md</a> 의 아래에 정리해놓았습니다.
     */
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
                if(!inputMenu(selectedMenu)){ continue; }// 입력받은 카테고리에 맞는 메뉴 보여주고 메뉴 입력받기
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

    /**
     *  장바구니를 탐색하는 함수
     *  장바구니 서비스인 1.주문. 2.장바구니 수정. 0. 나가기를 선택할 수 있습니다.
     *  선택된 값에 따라서 대응하는 함수를 호출합니다.
     */
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
                    }
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

    /**
     *  수정할 아이템 고르는 인풋 받기
     *  장바구니 내용들을 출력하고 앞에 인덱스가 붇는데, 받은 숫자 값을 확인하고 장바구니 요소를 하나 삭제합니다.
     *  삭제 후에 다시 장바구니 목록을 불러와서 여러번 삭제할 수 있습니다.
     *  {@return boolean} -> false일시 장바구니 서비스 목록으로 되돌아갑니다.
     */
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

    /**
     * 전체 메뉴 카테고리를 출력하는 함수
     * 장바구니가 비어있는지 확인하는 하여 isCartEmpty의 값을 수정합니다.
     */
    private void printCategory(){
        int length = menuList.size();
        //카테고리 출력
        System.out.println("========================================< 맘스땃쥐 >============================================");
        menuList.forEach(value->{
                        System.out.println("|| " + value.getCategoryNum()+ ". " + value.getCategoryName());
                    }
                );
        System.out.println("|| 0. 나가기 ");
        System.out.println("===============================================================================================");
        isCartEmpty = shoppingCart.orderMenu(length+1);
    }

    /**
     * 어떤 카테고리 사용할지 입력 받기
     * userInputManager에서 받아온 '카테고리 혹은 장바구니 서비스 이용' 입력에 따라 오류 처리를 하는함수입니다.
     * isCartEmpty값에 따라서 사용자가 입력할 수 있는 바운더리를 넓힙니다.
     */
    private void inputCategory() {
        int length;

        while (true) {
            printCategory();
            if (isCartEmpty) {
                length = menuList.size();
            } else {
                length = menuList.size() + 2;
            }
            try {
                categoryInput = userInputManager.inputIntegerValue();
                if (categoryInput < 0 || categoryInput > length) {
                    throw new InputMismatchException();
                } else {
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴에 있는 번호를 입력해주세요!");
            }
        }
    }

    /**
     * 음식 메뉴를 선택하는 함수입니다.
     * userInputManager에게서 받아온 '메뉴 선택 값'에 따라 오류 처리를 하는함수입니다.
     * 리턴 값에 따라서 inputMenu를 호출한 함수가 다음으로 해야할 일을 결정할 수 있습니다.
     * @param selectedMenu 사용자가 선택한 메뉴 카테고리
     * @return {@code true} - 유효한 메뉴를 선택한 경우
     *         {@code false} - 사용자가 0을 입력하여 카테고리로 돌아간 경우
     */
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

    /**
     * 최종적으로 결제할지 여부를 결정하는 함수입니다.
     * 마찬가지로 userInputManager에게서 받아온 값으로 결제 출력과 돌아가기 기능을 합니다.
     */
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


    /**
     * 할인을 적용하는 함수입니다.
     * 할인목록을 출력하는 함수를 호출하고
     * userInputManager에서 받아온 값으로 어떤 할인을 적용할지 지정해줍니다.
     * 지정된 할인에 따라서 장바구니의 totalPrice값을 조정합니다.
     */
    private void hasDiscount(){
        DiscountType discountType;
        int discountInput;

        while (true) {
            printDiscount(); // 할인적용
            System.out.println("할인 적용이 있으신가요?");
            try {
                discountInput = userInputManager.inputIntegerValue();
                if (discountInput == 1) {
                    if(shoppingCart.getTotalPrice() > 10000){
                        discountType = DiscountType.Coupon;
                        break;
                    }else{
                        System.out.println("쿠폰은 10000원이상만 사용 가능해요");
                    }
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


    /**
     * 장바구니 담기 여부 입력받기
     * 카테고리가 선택이되고 해당 카테고리에 속하는 음식 메뉴들을 출력합니다.
     * 출력한 뒤 userInputManager에서 사용자가 선택한 메뉴(+ 나가기) 값에 대해 출력값을 다르게 합니다.
     * @param selectedMenu 선택한 카테고리 목록
     */
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

    /**
     * 할인 목록을 출력하는 함수
     */
    public void printDiscount(){
        System.out.println("=========================[ 주문하기 ]=============================");
        System.out.println("|| 1. 3000원 할인 쿠폰(1만원 이상 시 사용가능) ");
        System.out.println("|| 2. 현금 결제(10%) ");
        System.out.println("|| 3. 할인 적용 하지않기");
        System.out.println("=================================================================");
    }

}