package Chinese_Flower;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class WeAbout extends F_demo{
    private JLabel jptop;
    private JPanel jpbuttom;
    private JTextArea about;
    private JScrollPane jsp;
    private JButton exit;
    public WeAbout() {
        setTitle("关于我们");//设置标题
        setIconImage(icon_1.getImage());//设置图标
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//退出后关闭
        setSize(440, 300);
        // setResizable(false);//不可缩放
        // setUndecorated(true);//去掉窗口边框
        setLocationRelativeTo(null);//中心
        setLayout(new BorderLayout());
        aboutUI();
    }
    private void aboutUI() {
        jptop = new JLabel("关于我们");
        jptop.setFont(new Font("宋体", Font.BOLD, 20));
        jptop.setHorizontalAlignment(SwingConstants.CENTER);

        jpbuttom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        exit = new JButton("退出");
        exit.setFont(new Font("宋体", Font.BOLD, 20));
        //透明
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        jpbuttom.add(exit);

        about = new JTextArea();
        about.setFont(new Font("宋体", Font.PLAIN, 20));
        about.setLineWrap(true);//自动换行
        about.setEditable(false);//不可编辑
        about.setText("wddwadwadwadawdwadwadawdwadada6844685444444444444444444444444444441155555555555555555555555555555555555555555555555");
        jsp = new JScrollPane(about);

        add(jptop, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);
        add(jpbuttom, BorderLayout.SOUTH);


    }
}
