package challenge.lv2GUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>();

        List<MenuItem> burgerItems = new ArrayList<>(Arrays.asList(
            new MenuItem("싸이버거",4900,7300,"바삭하고 매콤한 치킨 패티와 신선한 양상추가 조화를 이루는 맘스터치 시그니처 버거."),
            new MenuItem("불싸이버거",5100,7500,"화끈한 불맛이 살아있는 버거, 싸이버거의 매운맛 버전."),
            new MenuItem("불불불불싸이버거",6800,9200,"불싸이버거를 압도하는 살벌한 매운맛!"),
            new MenuItem("화이트갈릭싸이버거",5500,7900,"BEST 화이트갈릭이 싸이버거로 재탄생! 더블햄, 통다리살, 화이트갈릭소스의 환상 조합"),
            new MenuItem("딥치즈싸이버거",5400,7800,"BEST 딥치즈버거가 싸이버거로 재탄생! 진한 치즈소스와 통다리살 패티가 일품"),
            new MenuItem("트리플딥치즈싸이버거",5700,8100,"BEST 딥치즈버거가 싸이버거로 재탄생! 진한 치즈소스와 통다리살 패티가 일품"),
            new MenuItem("싸이플렉스버거",8300,10700,"통다리살 싸이패티가 2장! 압도적 사이즈의 FLEX, 리얼 입찢버거 싸이플렉스버거")
        ));
        Menu burgerMenu = new Menu(burgerItems, "버거", 1);

        List<MenuItem> chickenItems = new ArrayList<>(Arrays.asList(
                new MenuItem("후라이드치킨",10000,"후라이드 치킨의 고소함과 바삭바삭함이 그대로! 쌀눈 함유 오일로 튀겨내어 필수영양성분과 육즙이 풍부한 치킨."),
                new MenuItem("케이준떡강정",5000,"100% 닭다리살과 쫀득한 쌀떡,매콤달콤한 케이준소스의 환상적인 조화!"),
                new MenuItem("간장마늘떡강정",5200,"알싸한 마늘과 특제 간장소스로 단짠의 매력과 크리스피한 식감이 조화로운 순살떡강정!"),
                new MenuItem("맘스양념치킨",11000,"매콤하고 달콤한 소스와 치킨"),
                new MenuItem("간장마늘치킨",11000,"BEST 딥치즈버거가 싸이버거로 재탄생! 진한 치즈소스와 통다리살 패티가 일품"),
                new MenuItem("후라이드 빅싸이순살",13000,"케이준 양념레시피로 더 바삭하고 스파이시한 닭다리살 순살 치킨을 더 크게~ 육즙을 더 풍부하게 즐길 수 있는 빅싸이 순살"),
                new MenuItem("간장마늘 빅싸이순살",15000,"알싸한 마늘 향의 매콤함, 특제 간장소스의 단짠이 조화로운 닭다리살 순살치킨"),
                new MenuItem("맘스양념 빅싸이순살",15000,"매콤달콤 특제 양념소스로 닭다리살 순살치킨을 더 크게~ 육즙을 더 풍부하게 즐길 수 있는 빅싸이순살")
        ));
        Menu chickenMenu = new Menu(chickenItems, "치킨", 2);

        List<MenuItem> sideItems = new ArrayList<>(Arrays.asList(
                new MenuItem("케이준 양념감자",2000,3500,"맘스터치의 베스트 사이드메뉴! 케이준스타일의 바삭한 양념감자."),
                new MenuItem("치즈감자",3500,7500,"케이준 양념감자와 깊고 진한 딥치즈 소스를 함께 즐길 수 있는 치즈감자."),
                new MenuItem("치즈스틱 (2개)",3800,"고단백 영양만점의 모짜렐라 치즈스틱~"),
                new MenuItem("바삭크림치즈볼",2700,""),
                new MenuItem("할라피뇨너겟",5400,7800,"콕콕 박힌 할라피뇨로 매콤하게 즐기는 할라피뇨 너겟")
        ));
        Menu sideMenu = new Menu(sideItems, "사이드", 3);

        menuList.add(burgerMenu);
        menuList.add(chickenMenu);
        menuList.add(sideMenu);

        ShoppingCart shoppingCart = new ShoppingCart();
        UserInputManager userInputManager = new UserInputManager();

        Kiosk kiosk = new Kiosk(menuList, shoppingCart, userInputManager);
        kiosk.startKiosk();
    }
}
