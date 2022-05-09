package Chinese_Flower;

import javax.swing.*;
import java.awt.*;

public class Load extends F_demo {
    
    private JLabel image, text;
    public Load(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出后关闭
        setSize(400, 300);
        setUndecorated(true);//去掉窗口边框
        setResizable(false);//不可缩放
        setLocationRelativeTo(null);//中心
        winUI();
    }
    public void winUI(){
        ImageIcon icon = new ImageIcon("src\\Chinese_Flower\\image\\load.jpg");
        icon.setImage(icon.getImage().getScaledInstance(getWidth(), getHeight()-20, Image.SCALE_DEFAULT));
        image = new JLabel(icon);
        text = new JLabel("连接数据库...");
        add(image, BorderLayout.NORTH);
        add(text, BorderLayout.SOUTH);
    }
}
//启动界面