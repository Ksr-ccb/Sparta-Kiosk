package challenge.lv2;


//public enum DiscountType {
//    Coupon{
//        @Override
//        public int discountPrice(int price){
//            if(price > 10000){
//                return price-3000;
//            }else{
//                System.out.println("쿠폰은 10000원이상만 사용 가능해요");
//                return price;
//            }
//        }
//    }, //symbol말고 추상메서드도 입력가능
//    Cash{
//        @Override
//        public int discountPrice(int price){
//            return price - (price/10);
//        }
//    },
//    General{
//        @Override
//        public int discountPrice(int price){
//            return price;
//        }
//    };
//
//    public abstract int discountPrice(int price);
//}

@FunctionalInterface
interface DiscountStructure {
    int discountPrice(int price);
}

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