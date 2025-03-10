package challenge.lv1;

public class MenuItem {
    private String name;
    private int singlePrice;
    private int setPrice;
    private String info;

    //생성자
    MenuItem(String name, int singlePrice, String info){
        this.name = name;
        this.singlePrice = singlePrice;
        this.setPrice = 0;
        this.info = info;
    }
    MenuItem(String name, int singlePrice, int setPrice, String info){
        this.name = name;
        this.singlePrice = singlePrice;
        this.setPrice = setPrice;
        this.info = info;
    }

    //겟셋
    public int getSetPrice() {
        return setPrice;
    }

    public int getSinglePrice() {
        return singlePrice;
    }

    public String getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setSetPrice(int setPrice) {
        this.setPrice = setPrice;
    }

    public void setSinglePrice(int singlePrice) {
        this.singlePrice = singlePrice;
    }

    public void setName(String name) {
        this.name = name;
    }


}

