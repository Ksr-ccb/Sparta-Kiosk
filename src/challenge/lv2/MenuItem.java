package challenge.lv2;


/**
 * {@code MenuItem} 클래스는 선택할 메뉴 아이템 하나를 저장하는 역할을 합니다.
 * 메뉴마다 세트메뉴가 있을수 도 있고 없을수 도 있기 때문에 파라미터 타입에 따른 두개의 생성자가 존재합니다.
 */
public class MenuItem {

    /** 메뉴 이름 */
    private String name;

    /** 메뉴의 단품(디폴트) 가격 */
    private int singlePrice;

    /** 메뉴의 세트 가격 */
    private int setPrice;

    /** 메뉴 설명 */
    private String info;

    /**
     * 새로운 {@code MenuItem} 객체를 생성합니다
     *
     * @param name         저장될 메뉴 이름
     * @param singlePrice  디폴트 가격
     * @param info         메뉴 설명
     */
    MenuItem(String name, int singlePrice, String info){
        this.name = name;
        this.singlePrice = singlePrice;
        this.setPrice = 0;
        this.info = info;
    }

    /**
     * 새로운 {@code MenuItem} 객체를 생성합니다
     * 이 객체는 세트가격과 단품 가격을 포함하고 있습니다.
     *
     * @param name         저장될 메뉴 이름
     * @param singlePrice  디폴트 가격
     * @param setPrice     세트 가격
     * @param info         메뉴 설명
     */
    MenuItem(String name, int singlePrice, int setPrice, String info){
        this.name = name;
        this.singlePrice = singlePrice;
        this.setPrice = setPrice;
        this.info = info;
    }

    /**
     * 세트 가격을 반환합니다.
     *
     * @return 세트 가격
     */
    public int getSetPrice() {
        return setPrice;
    }

    /**
     * 디폴트 가격(단품 가격)을 반환합니다.
     *
     * @return 디폴트 가격(단품 가격)
     */
    public int getSinglePrice() {
        return singlePrice;
    }

    /**
     * 메뉴 설명을 반환합니다.
     *
     * @return 메뉴 설명
     */
    public String getInfo() {
        return info;
    }

    /**
     * 메뉴 이름을 반환합니다.
     *
     * @return 메뉴 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 현재 아이템의 메뉴 설명을 수정합니다.
     * @param info 바꿀 메뉴 설명 스트링
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     *  현재 아이템의 세트 가격을 수정합니다.
     * @param setPrice 세트 가겪
     */
    public void setSetPrice(int setPrice) {
        this.setPrice = setPrice;
    }

    /**
     *  현재 아이템의 단품 가격을 수정합니다.
     * @param singlePrice 단품 가격
     */
    public void setSinglePrice(int singlePrice) {
        this.singlePrice = singlePrice;
    }

    /**
     * 현재 아이템의 이름을 수정합니다.
     * @param name 수정할 메뉴 이름
     */
    public void setName(String name) {
        this.name = name;
    }


}

