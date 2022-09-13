package Chinese_Flower;

import javax.swing.*;
import java.awt.*;

public class Load extends F_demo {
    
    private JLabel image, text;
    public Load(){
        setTitle("加载中...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出后关闭
        setIconImage(icon_1.getImage());//设置图标
        setSize(400, 300);
        setUndecorated(true);//去掉窗口边框
        setResizable(false);//不可缩放
        setLocationRelativeTo(null);//中心
        winUI();
    }
    public void winUI(){
        icon_1.setImage(icon_1.getImage().getScaledInstance(getWidth(), getHeight()-20, Image.SCALE_DEFAULT));
        image = new JLabel(icon_1);
        text = new JLabel("连接数据库...");
        add(image, BorderLayout.NORTH);
        add(text, BorderLayout.SOUTH);
    }
}
//启动界面