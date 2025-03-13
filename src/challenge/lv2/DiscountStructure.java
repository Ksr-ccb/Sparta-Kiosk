package challenge.lv2;

/**
 * 할인 구조를 정의하는 함수형 인터페이스입니다.
 * 이 인터페이스를 구현하면 특정 가격에 대한 할인 로직을 정의할 수 있습니다.
 * 이 인터페이스는 할인 목록을 관리하는 enum 클래스에서 사용이됩ㄴ다.
 *
 * <h4>예제:</h4>
 * <pre>{@code
 * Coupon(price -> (price > 10000) ? price - 3000 : price)
 * ...
 * int finalPrice = discount.discountPrice(13000); // 결과: 10000
 * }</pre>
 */
@FunctionalInterface
interface DiscountStructure {
    int discountPrice(int price);
}
