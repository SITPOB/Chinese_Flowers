package Chinese_Flower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class User_PI extends F_demo{
    private JPanel jptop, jpbottom;
    private JLabel name, nick, age, phone;
    private JTextField name_, nick_, age_, phone_;
    private JButton exit_login, exit;
    private User_PI This = this;
    public User_PI(String s) {
        setTitle(s);//设置标题
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//退出后关闭
        setSize(400, 300);
        setResizable(false);//不可缩放
        setLocationRelativeTo(null);//中心
        PIUI();
    }
    private void PIUI() {
        menuBar();
        //个人信息界面
        jptop = new JPanel();
        jptop.setLayout(new GridLayout(4, 2, 1, 3));
        name = new JLabel("登录名：");
        nick = new JLabel("昵称：");
        age = new JLabel("年龄：");
        phone = new JLabel("联系方式：");

        if(mainAdmin != null){
            buttonui_admin();
        }else{
            buttonui();
        }
        exit = new JButton("返回");
        exit.setOpaque(false);//透明
        exit.setContentAreaFilled(false);//透明
        //exit.setFocusPainted(false);//透明
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                This.dispose();
                pi = null;
            }
        });
        setInfo();

        jptop.add(nick);
        jptop.add(nick_);
        jptop.add(name);
        jptop.add(name_);
        jptop.add(age);
        jptop.add(age_);
        jptop.add(phone);
        jptop.add(phone_);

        jpbottom = new JPanel();
        jpbottom.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpbottom.add(exit_login);
        jpbottom.add(exit);
        add(jptop, BorderLayout.CENTER);
        add(jpbottom, BorderLayout.SOUTH);
    }
    private void buttonui_admin() {
        exit_login = new JButton("切换管理员账号");
        exit_login.setOpaque(false);//透明
        exit_login.setContentAreaFilled(false);//透明
        //exit_login.setFocusPainted(false);//透明
        exit_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(login != null){
                    login.dispose();
                }
                login = new Login("管理员");
                login.setVisible(true);
            }
        });
    }
    private void menuBar(){
        //菜单栏
        JMenuBar jmb = new JMenuBar();
        JMenu more = new JMenu("修改个人信息>>");
        JMenuItem jmi1 = new JMenuItem("修改密码");
        //点击
        jmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                This.dispose();
            }   
        });
        JMenuItem jmi2 = new JMenuItem("修改昵称");
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                This.dispose();
            }   
        });
        JMenuItem jmi3 = new JMenuItem("修改年龄");
        //点击
        jmi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                This.dispose();
            }   
        });
        JMenuItem jmi4 = new JMenuItem("修改用户名");
        jmi4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                This.dispose();
            }   
        });
        JMenuItem jmi5 = new JMenuItem("修改联系方式");
        jmi5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                This.dispose();
            }   
        });
        more.add(jmi1);
        more.add(jmi2);
        more.add(jmi3);
        more.add(jmi4);
        more.add(jmi5);
        jmb.add(more);
        setJMenuBar(jmb);
    }
    private void buttonui() {
        exit_login = new JButton("退出登录");
        exit_login.setOpaque(false);//透明
        exit_login.setContentAreaFilled(false);//透明
        //exit_login.setFocusPainted(false);//透明
        exit_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f2 = new File("src\\Chinese_Flower\\account.lzh");//文件
                try{
                    //覆盖写入
                    FileWriter fw = new FileWriter(f2);
                    fw.write("");
                    fw.close();
                }catch(IOException e1){
                    e1.printStackTrace();
                }
                dlcg = false;
                mainFrame1.dispose();
                mainFrame1 = new MainFrame("未登录");
                mainFrame1.setVisible(true);
                UserID = 0;
                UserAccount = "";
                NickName = "";
                UserPhone = "";
                UserAge = 0;
                This.dispose();
                pi = null;

            }
        });
    }
    private void setInfo() {
        name_ = new JTextField(UserAccount);
        //不可编辑
        name_.setEditable(false);
        //透明
        name_.setOpaque(false);
        name_.setBorder(null);//去掉边框
        //设置字体
        name_.setFont(new Font("宋体", Font.BOLD, 15));
        nick_ = new JTextField(NickName);
        //不可编辑
        nick_.setEditable(false);
        //透明
        nick_.setOpaque(false);
        nick_.setBorder(null);//去掉边框
        //设置字体
        nick_.setFont(new Font("宋体", Font.BOLD, 15));
        age_ = new JTextField(UserAge+"");
        //不可编辑
        age_.setEditable(false);
        //透明
        age_.setOpaque(false);
        age_.setBorder(null);//去掉边框
        //设置字体
        age_.setFont(new Font("宋体", Font.BOLD, 15));
        phone_ = new JTextField(UserPhone);
        //不可编辑
        phone_.setEditable(false);
        //透明
        phone_.setOpaque(false);
        phone_.setBorder(null);//去掉边框
        //设置字体
        phone_.setFont(new Font("宋体", Font.BOLD, 15));
    
    }
}