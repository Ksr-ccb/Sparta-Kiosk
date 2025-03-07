package essential.lv4;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("싸이버거",4900,7300,"바삭하고 매콤한 치킨 패티와 신선한 양상추가 조화를 이루는 맘스터치 시그니처 버거."));
        menuItems.add(new MenuItem("불싸이버거",5100,7500,"화끈한 불맛이 살아있는 버거, 싸이버거의 매운맛 버전."));
        menuItems.add(new MenuItem("불불불불싸이버거",6800,9200,"불싸이버거를 압도하는 살벌한 매운맛!"));
        menuItems.add(new MenuItem("화이트갈릭싸이버거",5500,7900,"EST 화이트갈릭이 싸이버거로 재탄생! 더블햄, 통다리살, 화이트갈릭소스의 환상 조합"));
        menuItems.add(new MenuItem("딥치즈싸이버거",5400,7800,"BEST 딥치즈버거가 싸이버거로 재탄생! 진한 치즈소스와 통다리살 패티가 일품"));
        menuItems.add(new MenuItem("트리플딥치즈싸이버거",5700,8100,"BEST 딥치즈버거가 싸이버거로 재탄생! 진한 치즈소스와 통다리살 패티가 일품"));
        menuItems.add(new MenuItem("싸이플렉스버거",8300,10700,"통다리살 싸이패티가 2장! 압도적 사이즈의 FLEX, 리얼 입찢버거 싸이플렉스버거"));

        Kiosk kiosk = new Kiosk(menuItems);

        kiosk.startKiosk();
    }
}
