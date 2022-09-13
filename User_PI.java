package Chinese_Flower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.awt.event.*;

public class User_PI extends F_demo{
    private JPanel jptop, jpbottom, jpall, jpA, jpP, jpN, jpG, jpH, jpA2, jpP2, jpN2, jpG2, jtG, jpH2, jpA3, jpP3, jpN3, jpG3, jpH3;
    private JLabel name, nick, age, phone, jlA, jlP, jlN, jlG, jlH, jlA2, jlP2, jlN2, jlH2, jlP3;
    private JTextField name_, nick_, age_, phone_, jtA, jtP, jtN, jtH, jtA2, jtP2, jtN2, jtH2, jtP3;
    private JButton exit_login, exit, jbA, jbP, jbN, jbG, jbH;
    private JComboBox<String> year, month, day;
    private Calendar c = Calendar.getInstance();
    private User_PI This = this;

    public User_PI() {
        setTitle(user_model.getNickName()+"-个人信息");//设置标题
        setIconImage(icon_1.getImage());//设置图标
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//退出后关闭
        setSize(400, 300);
        setResizable(false);//不可缩放
        setLocationRelativeTo(null);//中心
        PIUI();
    }
    private void PIUI() {
        jpall = new JPanel(cl);
        //透明
        jpall.setOpaque(false);
        setJP();
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

        jpall.add(jptop,"jptop");
        jpall.add(jpA,"jpA");
        jpall.add(jpP,"jpP");
        jpall.add(jpN,"jpN");
        jpall.add(jpG,"jpG");
        jpall.add(jpH,"jpH");

        add(jpall, BorderLayout.CENTER);
        add(jpbottom, BorderLayout.SOUTH);
    }
    private void setJP() {
        jpA = new JPanel(new BorderLayout());
        jpA2 = new JPanel(new GridLayout(2, 2, 1, 1));
        jpA3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpA.setOpaque(false);
        jpA2.setOpaque(false);
        jpA3.setOpaque(false);
        jtA = new JTextField(20);
        jlA = new JLabel("请输入您的新用户名：");
        jtA2 = new JTextField(20);
        jlA2 = new JLabel("请再次输入您的新用户名：");
        jbA = new JButton("确认修改用户名");
        jbA.setOpaque(false);//透明
        jbA.setContentAreaFilled(false);//透明
        jbA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = jtA.getText();
                String s2 = jtA2.getText();
                if(s.equals("") || s.equals(s2) == false){
                    JOptionPane.showMessageDialog(null, "请输入您的新用户名！");
                }else{
                    if(mainAdmin != null){
                        Others_ = "AdminName";
                    }else{
                        Others_ = "UserAccount";
                    }
                    change_pi(Others_, s, -2);
                    jtA.setText("");
                    jtA2.setText("");
                }
            }
        });
        jpA2.add(jlA);
        jpA2.add(jtA);
        jpA2.add(jlA2);
        jpA2.add(jtA2);
        jpA3.add(jbA);
        jpA.add(jpA2, BorderLayout.NORTH);
        jpA.add(jpA3, BorderLayout.SOUTH);

        //修改用户名
        jpP = new JPanel(new BorderLayout());
        jpP2 = new JPanel(new GridLayout(3, 2, 1, 1));
        jpP3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpP.setOpaque(false);
        jpP2.setOpaque(false);
        jpP3.setOpaque(false);
        jtP = new JTextField(20);
        jlP = new JLabel("请输入您的密码：");
        jtP2 = new JTextField(20);
        jlP2 = new JLabel("请输入您的新密码：");
        jtP3 = new JTextField(20);
        jlP3 = new JLabel("请再次输入您的新密码：");
        jbP = new JButton("确认修改密码");
        jbP.setOpaque(false);//透明
        jbP.setContentAreaFilled(false);//透明
        jbP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = jtP.getText();
                String s2 = jtP2.getText();
                String s3 = jtP3.getText();
                if(s.equals("") || s2.equals("") || s3.equals("")){
                    JOptionPane.showMessageDialog(null, "请输入您的新密码！");
                }else if(user_model.getUserPWD().equals(s) == false){
                    JOptionPane.showMessageDialog(null, "您的密码输入错误！"); 
                }else if(s2.equals(s3) == false){
                    JOptionPane.showMessageDialog(null, "两次输入的密码不一致！");
                }else{
                    if(mainAdmin != null){
                        Others_ = "AdminPWD";
                    }else{
                        Others_ = "UserPWD";
                    }
                    change_pi(Others_, s3, -2);
                    exit_login_();
                }
            }
        });
        jpP2.add(jlP);
        jpP2.add(jtP);
        jpP2.add(jlP2);
        jpP2.add(jtP2);
        jpP2.add(jlP3);
        jpP2.add(jtP3);
        jpP3.add(jbP);
        jpP.add(jpP2, BorderLayout.NORTH);
        jpP.add(jpP3, BorderLayout.SOUTH);
        //修改昵称
        jpN = new JPanel(new BorderLayout());
        jpN2 = new JPanel(new GridLayout(2, 2, 1, 1));
        jpN3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpN.setOpaque(false);
        jpN2.setOpaque(false);
        jpN3.setOpaque(false);
        jtN = new JTextField(20);
        jlN = new JLabel("请输入您的新昵称：");
        jtN2 = new JTextField(20);
        jlN2 = new JLabel("请再次输入您的新昵称：");
        jbN = new JButton("确认修改昵称");
        jbN.setOpaque(false);//透明
        jbN.setContentAreaFilled(false);//透明
        jbN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = jtN.getText();
                String s2 = jtN2.getText();
                if(s.equals("") || s2.equals("")){
                    JOptionPane.showMessageDialog(null, "请输入您的新昵称！");
                }else if(s.equals(s2) == false){
                    JOptionPane.showMessageDialog(null, "两次输入的昵称不一致！");
                }else{
                    if(mainAdmin != null){
                        Others_ = "AdminNick";
                    }else{
                        Others_ = "NickName";
                    }
                    change_pi(Others_, s2, -2);
                    jtN.setText("");
                    jtN2.setText("");
                    if(mainAdmin != null){
                        mainAdmin.setLogin(s2);
                    }else if(mainFrame1 != null){
                        mainFrame1.setLogin(s2);
                    }
                }
            }
        });
        jpN2.add(jlN);
        jpN2.add(jtN);
        jpN2.add(jlN2);
        jpN2.add(jtN2);
        jpN3.add(jbN);
        jpN.add(jpN2, BorderLayout.NORTH);
        jpN.add(jpN3, BorderLayout.SOUTH);
        //修改年龄
        jpG = new JPanel(new BorderLayout());
        jpG2 = new JPanel(new GridLayout(1, 2, 1, 1));
        jpG3 = new JPanel(new FlowLayout(FlowLayout.CENTER));


        jtG = new JPanel(new GridLayout(1, 3));
        year = new JComboBox<String>();
        //透明
        year.setOpaque(false);
        month = new JComboBox<String>();
        month.setOpaque(false);
        day = new JComboBox<String>();
        day.setOpaque(false);
        //设置年
        int nian = c.get(Calendar.YEAR);
        for(int i = nian; i >= 1900; i--){
            year.addItem(i + "");
        }
        for(int i = 1; i <= 12; i++){
            month.addItem(i + "");
        }
        for(int i = 1; i <= 31; i++){
            day.addItem(i + "");
        }
        //设置月
        year.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDay();
            }
        });
        month.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDay();
            }
        });

        jpG.setOpaque(false);
        jpG2.setOpaque(false);
        jpG3.setOpaque(false);
        jlG = new JLabel("请选择您的新年龄：");
        jbG = new JButton("确认修改年龄");
        jbG.setOpaque(false);
        jbG.setContentAreaFilled(false);
        jbG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = c.get(Calendar.YEAR);//获取当前年份
                int y = c.get(Calendar.MONTH) + 1;//获取当前月份
                int z = c.get(Calendar.DATE);//获取当前日
                
                //计算年龄
                int age_str = x - Integer.parseInt(year.getSelectedItem().toString());
                if(y < Integer.parseInt(month.getSelectedItem().toString())){
                    age_str--;
                }else if(y == Integer.parseInt(month.getSelectedItem().toString()) && z < Integer.parseInt(day.getSelectedItem().toString())){
                    age_str--;
                }
                if(mainAdmin != null){
                    Others_ = "AdminAge";
                }else{
                    Others_ = "UserAge";
                }
                change_pi(Others_, "", age_str);
            }
        });
        jtG.add(year);
        jtG.add(month);
        jtG.add(day);

        jpG2.add(jlG);
        jpG2.add(jtG);
        jpG3.add(jbG);
        jpG.add(jpG2, BorderLayout.NORTH);
        jpG.add(jpG3, BorderLayout.SOUTH);

        //修改联系方式
        jpH = new JPanel(new BorderLayout());
        jpH2 = new JPanel(new GridLayout(2, 2, 1, 1));
        jpH3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpH.setOpaque(false);
        jpH2.setOpaque(false);
        jpH3.setOpaque(false);
        jtH = new JTextField(20);
        jtH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });
        jlH = new JLabel("请输入您的新联系方式：");
        jtH2 = new JTextField(20);
        jtH2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });
        jlH2 = new JLabel("请再次输入您的新联系方式：");
        jbH = new JButton("确认修改联系方式");
        jbH.setOpaque(false);
        jbH.setContentAreaFilled(false);
        jbH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = jtH.getText();
                String s2 = jtH2.getText();
                if(s.equals("") || s2.equals("")){
                    JOptionPane.showMessageDialog(null, "请输入您的新联系方式！");
                }else if(s.length() != 11 || s2.length() != 11){
                    JOptionPane.showMessageDialog(null, "请输入正确的联系方式！");
                }else if(!s.equals(s2)){
                    JOptionPane.showMessageDialog(null, "两次输入的联系方式不一致！");
                }else{
                    if(mainAdmin != null){
                        Others_ = "AdminPhone";
                    }else{
                        Others_ = "UserPhone";
                    }
                    change_pi(Others_, s, -2);
                    jtH.setText("");
                    jtH2.setText("");
                }
            }
        });
        jpH2.add(jlH);
        jpH2.add(jtH);
        jpH2.add(jlH2);
        jpH2.add(jtH2);
        jpH3.add(jbH);
        jpH.add(jpH2, BorderLayout.NORTH);
        jpH.add(jpH3, BorderLayout.SOUTH);


    }
    private void buttonui_admin() {
        exit_login = new JButton("切换账号");
        exit_login.setOpaque(false);//透明
        exit_login.setContentAreaFilled(false);//透明
        //exit_login.setFocusPainted(false);//透明
        exit_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loginch != null){
                    loginch.dispose();
                }
                loginch = new Loginch();
                loginch.setVisible(true);
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
                cl.show(jpall, "jpP");
            }   
        });
        JMenuItem jmi2 = new JMenuItem("修改昵称");
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cl.show(jpall, "jpN");
            }   
        });
        JMenuItem jmi3 = new JMenuItem("修改年龄");
        //点击
        jmi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cl.show(jpall, "jpG");
            }   
        });
        JMenuItem jmi4 = new JMenuItem("修改用户名");
        jmi4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cl.show(jpall, "jpA");
            }   
        });
        JMenuItem jmi5 = new JMenuItem("修改联系方式");
        jmi5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cl.show(jpall, "jpH");
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
    protected void change_pi(String string, String string2, int age_1) {
        // TODO Auto-generated method stub
        try {
            String sql2 = "";
            if(mainAdmin != null){
                sql2 = "update admininfo set " + string + " = ? where AdminID = "+user_model.getUserID()+"";
            }else{
                sql2 = "update userinfo set "+ string+" = ? where UserID = "+user_model.getUserID()+"";
            }
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            if(age_1 == -2){
                pstmt2.setString(1, string2);
                if(string.equals("AdminPhone") || string.equals("UserPhone")){
                    user_model.setUserPhone(string2);
                }else if(string.equals("AdminName") || string.equals("UserAccount")){
                    user_model.setUserAccount(string2);
                }else if(string.equals("AdminNick") || string.equals("NickName")){
                    user_model.setNickName(string2);
                }else if(string.equals("AdminPWD") || string.equals("UserPWD")){
                    user_model.setUserPWD(string2);
                }
            }else{
                pstmt2.setInt(1, age_1);
                user_model.setUserAge(age_1);
            }
            pstmt2.executeUpdate();
            JOptionPane.showMessageDialog(null, "修改成功！");
            //关闭连接
            pstmt2.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "修改失败！用户名或已存在！");
        }
    }
    private void buttonui() {
        exit_login = new JButton("退出登录");
        exit_login.setOpaque(false);//透明
        exit_login.setContentAreaFilled(false);//透明
        //exit_login.setFocusPainted(false);//透明
        exit_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit_login_();
            }
        });
    }
    protected void exit_login_() {
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
        if(mainFrame1 != null){
            mainFrame1.dispose();
        }if(mainAdmin != null){
            mainAdmin.dispose();
        }
        mainFrame1 = new MainFrame("未登录");
        mainFrame1.setVisible(true);
        user_model.setNULL();
        This.dispose();
        pi = null;
    }
    private void setDay(){
        int y = Integer.parseInt(year.getSelectedItem().toString());
        int m = Integer.parseInt(month.getSelectedItem().toString());
        day.removeAllItems();
        if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){
            for(int i = 1; i <= 31; i++){
                day.addItem(i + "");
            }
        }else if(m == 2){
            if(y % 4 == 0 && y % 100 != 0 || y % 400 == 0){
                for(int i = 1; i <= 29; i++){
                    day.addItem(i + "");
                }
            }else{
                for(int i = 1; i <= 28; i++){
                    day.addItem(i + "");
                }
            }
        }else{
            for(int i = 1; i <= 30; i++){
                day.addItem(i + "");
            }
        }
    }
    private void setInfo() {
        name_ = new JTextField(user_model.getUserAccount());
        //不可编辑
        name_.setEditable(false);
        //透明
        name_.setOpaque(false);
        name_.setBorder(null);//去掉边框
        //设置字体
        name_.setFont(new Font("宋体", Font.BOLD, 15));
        nick_ = new JTextField(user_model.getNickName());
        //不可编辑
        nick_.setEditable(false);
        //透明
        nick_.setOpaque(false);
        nick_.setBorder(null);//去掉边框
        //设置字体
        nick_.setFont(new Font("宋体", Font.BOLD, 15));
        age_ = new JTextField(user_model.getUserAge()+"");
        //不可编辑
        age_.setEditable(false);
        //透明
        age_.setOpaque(false);
        age_.setBorder(null);//去掉边框
        //设置字体
        age_.setFont(new Font("宋体", Font.BOLD, 15));
        phone_ = new JTextField(user_model.getUserPhone());
        //不可编辑
        phone_.setEditable(false);
        //透明
        phone_.setOpaque(false);
        phone_.setBorder(null);//去掉边框
        //设置字体
        phone_.setFont(new Font("宋体", Font.BOLD, 15));
    
    }
}