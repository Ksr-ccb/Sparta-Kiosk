package challenge.lv2GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;

public class KioskGUI extends JFrame{
    public KioskGUI()
    {

        setTitle("맘스땃쥐");
        setLayout(new BorderLayout(100, 10));

        //setPreferredSize(new Dimension( 840/12*9 , 840));
        setResizable(false);
        setSize(840/12*9, 840);
        makeElements();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[])
    {
        // 버튼 생성자
        new KioskGUI();
    }


    void makeElements() {
        List<java.awt.Menu> menuList = new ArrayList<Menu>();
        String[] categoryArr=  {"버거", "치킨", "사이드"};
        int length = 3;

        JPanel categoryPanel = new JPanel(new GridLayout(2,1,10,10));
        JPanel cartPanel = new JPanel(new GridLayout(2,1,10,10));
        JPanel menuListPanel = new JPanel(new GridLayout(0,2,10,10));
        JScrollPane menuPanel = new JScrollPane(menuListPanel);

        categoryPanel.setBackground(Color.orange);
        cartPanel.setBackground(Color.gray);
        menuPanel.setBackground(Color.pink);

        //setCategoryPanel(categoryPanel);
        JLabel title = new JLabel("맘 스 땃 쥐");
        title.setBorder(BorderFactory.createEmptyBorder(10 , 280 , 10 , 10));
        JButton[] num = new JButton[length];

        JPanel catPanel = new JPanel(new GridLayout(1, length, 10, 10));
        for(int i = 0; i < num.length; i++) {
            num[i] = new JButton(categoryArr[i]);
            num[i].setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
            catPanel.add(num[i]);
        }

        categoryPanel.add(title);
        categoryPanel.add(catPanel);

        //setCartPanel
        JPanel cartListPanel = new JPanel(new GridLayout(0,1,10,10));
        JScrollPane cartScrollPanel = new JScrollPane(menuListPanel);
        JPanel infoPanel = new JPanel(new GridLayout(1,4,10,10));


        JLabel totalCount = new JLabel("총  N 개");
        JLabel totalPrice = new JLabel("총  100000 원");
        JButton resetCart = new JButton("장바구니 초기화");
        JButton gotoPurchase = new JButton(" 결제하기 ");

        totalCount.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
        totalPrice.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
        resetCart.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
        gotoPurchase.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));

        infoPanel.add(totalCount);
        infoPanel.add(totalPrice);
        infoPanel.add(resetCart);
        infoPanel.add(gotoPurchase);

        cartPanel.add(cartScrollPanel);
        cartPanel.add(infoPanel);

        //btn.addActionListener(new MyActionListener(num, text));

        add(menuPanel, BorderLayout.CENTER);
        add(categoryPanel, BorderLayout.NORTH);
        add(cartPanel, BorderLayout.SOUTH);

    }

}
