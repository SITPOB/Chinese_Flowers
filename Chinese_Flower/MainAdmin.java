package Chinese_Flower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MainAdmin extends F_demo implements ActionListener {
    private CardLayout cl = new CardLayout();
    private JButton login_1, exit;
    private JPanel jpour, jpall, jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8, jp9, jp10, jp11, jp12, jp13, jp14, jp15, jp16, jp17, jp18;
    private JMenuBar menuBar;
    private JMenu jm1, jm2, jm3, jm4, jm5, jm6;
    private JMenuItem jmi1, jmi2, jmi3, jmi4, jmi5, jmi6, jmi7, jmi8, jmi9, jmi10, jmi11, jmi12, jmi13, jmi14, jmi15, jmi16, jmi17, jmi18;
    public MainAdmin(String s) {
        setTitle(s);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭当前窗口
        setSize(800, 600);
        //setResizable(false);//不可缩放
        //setUndecorated(true);//去掉窗口边框
        setLocationRelativeTo(null);//中心
        setLayout(new BorderLayout());
        menuBar();//菜单栏
        adminUI();//界面
    }
    private void adminUI() {
        jpall = new JPanel(cl);
        jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp5 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        jp6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp9 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp10 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        jp11 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp12 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp13 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp14 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp15 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        jp16 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp17 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp18 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        jp1.add(new JLabel("添加用户"));
        jp2.add(new JLabel("删除用户"));
        jp3.add(new JLabel("修改用户"));
        jp4.add(new JLabel("添加花卉"));
        jp5.add(new JLabel("删除花卉"));

        jp6.add(new JLabel("修改花卉"));
        jp7.add(new JLabel("添加专家"));
        jp8.add(new JLabel("删除专家"));
        jp9.add(new JLabel("修改专家"));
        jp10.add(new JLabel("添加花卉类型"));

        jp11.add(new JLabel("删除花卉类型"));
        jp12.add(new JLabel("修改花卉类型"));
        jp13.add(new JLabel("添加栽培方式"));
        jp14.add(new JLabel("删除栽培方式"));
        jp15.add(new JLabel("修改栽培方式"));

        jp16.add(new JLabel("添加养花常识"));
        jp17.add(new JLabel("删除养花常识"));
        jp18.add(new JLabel("修改养花常识"));

        jpall.add(jp1, "1");
        jpall.add(jp2, "2");
        jpall.add(jp3, "3");
        jpall.add(jp4, "4");
        jpall.add(jp5, "5");

        jpall.add(jp6, "6");
        jpall.add(jp7, "7");
        jpall.add(jp8, "8");
        jpall.add(jp9, "9");
        jpall.add(jp10, "10");

        jpall.add(jp11, "11");
        jpall.add(jp12, "12");
        jpall.add(jp13, "13");
        jpall.add(jp14, "14");
        jpall.add(jp15, "15");

        jpall.add(jp16, "16");
        jpall.add(jp17, "17");
        jpall.add(jp18, "18");

        jpour = new JPanel(new BorderLayout());
        //设置颜色
        jpour.setBackground(new Color(135,206,250));
        login_1 = new JButton(NickName);
        //透明
        login_1.setOpaque(false);
        login_1.setFont(new Font("宋体", Font.PLAIN, 20));
        login_1.setBorder(null);//去掉边框
        login_1.setContentAreaFilled(false);//去掉背景色
        login_1.addActionListener(this);
        exit = new JButton("退出");
        exit.setFont(new Font("宋体", Font.PLAIN, 20));
        exit.setBorder(null);//去掉边框
        exit.setContentAreaFilled(false);//去掉背景色
        exit.addActionListener(this);

        jpour.add(login_1, BorderLayout.NORTH);
        jpour.add(exit, BorderLayout.SOUTH);
        add(jpour, BorderLayout.WEST);
        add(jpall, BorderLayout.CENTER);

        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == jmi1) {
            cl.show(jpall, "1");
        } else if (e.getSource() == jmi2) {
            cl.show(jpall, "2");
        } else if (e.getSource() == jmi3) {
            cl.show(jpall, "3");
        } else if (e.getSource() == jmi4) {
            cl.show(jpall, "4");
        } else if (e.getSource() == jmi5) {
            cl.show(jpall, "5");
        } else if (e.getSource() == jmi6) {
            cl.show(jpall, "6");
        } else if (e.getSource() == jmi7) {
            cl.show(jpall, "7");
        } else if (e.getSource() == jmi8) {
            cl.show(jpall, "8");
        } else if (e.getSource() == jmi9) {
            cl.show(jpall, "9");
        } else if (e.getSource() == jmi10) {
            cl.show(jpall, "10");
        } else if (e.getSource() == jmi11) {
            cl.show(jpall, "11");
        } else if (e.getSource() == jmi12) {
            cl.show(jpall, "12");
        } else if (e.getSource() == jmi13) {
            cl.show(jpall, "13");
        } else if (e.getSource() == jmi14) {
            cl.show(jpall, "14");
        } else if (e.getSource() == jmi15) {
            cl.show(jpall, "15");
        } else if (e.getSource() == jmi16) {
            cl.show(jpall, "16");
        } else if (e.getSource() == jmi17) {
            cl.show(jpall, "17");
        } else if (e.getSource() == jmi18) {
            cl.show(jpall, "18");
        }else if (e.getSource() == exit) {
            System.exit(0);
        }else if (e.getSource() == login_1) {
            if(pi != null){
                pi.dispose();
            }
            pi = new User_PI(NickName+"-个人信息");
            pi.setVisible(true);
        }

        
    }
    private void menuBar() {
        //菜单栏
        menuBar = new JMenuBar();
        jm1 = new JMenu("管理用户>>");
        jm2 = new JMenu("管理花卉>>");
        jm3 = new JMenu("管理专家>>");
        jm4 = new JMenu("管理花卉类型>>");
        jm5 = new JMenu("管理栽培方式>>");
        jm6 = new JMenu("管理养花常识>>");

        jmi1 = new JMenuItem("添加用户");
        jmi1.addActionListener(this);
        jmi2 = new JMenuItem("删除用户");
        jmi2.addActionListener(this);
        jmi3 = new JMenuItem("修改用户");
        jmi3.addActionListener(this);
        jmi4 = new JMenuItem("添加花卉");
        jmi4.addActionListener(this);
        jmi5 = new JMenuItem("删除花卉");
        jmi5.addActionListener(this);
        jmi6 = new JMenuItem("修改花卉");
        jmi6.addActionListener(this);
        jmi7 = new JMenuItem("添加专家");
        jmi7.addActionListener(this);
        jmi8 = new JMenuItem("删除专家");
        jmi8.addActionListener(this);
        jmi9 = new JMenuItem("修改专家");
        jmi9.addActionListener(this);               
        jmi10 = new JMenuItem("添加花卉类型");
        jmi10.addActionListener(this);
        jmi11 = new JMenuItem("删除花卉类型");
        jmi11.addActionListener(this);
        jmi12 = new JMenuItem("修改花卉类型");
        jmi12.addActionListener(this);
        jmi13 = new JMenuItem("添加栽培方式");
        jmi13.addActionListener(this);
        jmi14 = new JMenuItem("删除栽培方式");
        jmi14.addActionListener(this);
        jmi15 = new JMenuItem("修改栽培方式");
        jmi15.addActionListener(this);
        jmi16 = new JMenuItem("添加养花常识");
        jmi16.addActionListener(this);
        jmi17 = new JMenuItem("删除养花常识");
        jmi17.addActionListener(this);
        jmi18 = new JMenuItem("修改养花常识");
        jmi18.addActionListener(this);

        jm1.add(jmi1);
        jm1.add(jmi2);
        jm1.add(jmi3);
        jm2.add(jmi4);
        jm2.add(jmi5);
        jm2.add(jmi6);
        jm3.add(jmi7);
        jm3.add(jmi8);
        jm3.add(jmi9);
        jm4.add(jmi10);
        jm4.add(jmi11);
        jm4.add(jmi12);
        jm5.add(jmi13);
        jm5.add(jmi14);
        jm5.add(jmi15);
        jm6.add(jmi16);
        jm6.add(jmi17);
        jm6.add(jmi18);
        menuBar.add(jm1);
        menuBar.add(jm2);
        menuBar.add(jm3);
        menuBar.add(jm4);
        menuBar.add(jm5);
        menuBar.add(jm6);
        setJMenuBar(menuBar);
    }
}
