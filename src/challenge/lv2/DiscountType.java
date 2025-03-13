package challenge.lv2;

/**
 * 다양한 할인 유형을 정의하는 열거형(enum) 클래스
 * 각 할인 유형은 가격에 따라 다른 할인 정책을 적용합니다.
 *
 * <h4>할인 유형:</h4>
 * <ul>
 *     <li>{@link #Coupon} - 10,000원 이상일 때 3,000원 할인</li>
 *     <li>{@link #Cash} - 10% 할인</li>
 *     <li>{@link #General} - 할인 없음</li>
 * </ul>
 *
 * 할인이 적용되는 함수인 discountPrice는 {@link DiscountStructure}를 구현했습니다.
 * 각 할인 유형별로 다른 할인 방식이 적용되도록 람다식을 활용했습니다.
 */
public enum DiscountType {
    Coupon(price -> (price > 10000) ? price - 3000 : price),
    Cash(price -> price - (price / 10)),
    General(price -> price);

    private final DiscountStructure discountStructure;

    DiscountType(DiscountStructure discountStructure) {
        this.discountStructure = discountStructure;
    }

    public int discountPrice(int price) {
        return discountStructure.discountPrice(price);
    }
}