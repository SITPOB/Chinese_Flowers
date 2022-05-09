package Chinese_Flower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

public class Register extends F_demo{
    private JPanel jptop, jpbottom, jpcenter, age;
    private JLabel Text, nickname_label, username_label, phone_label, password_label, password_label2, age_label;
    private JTextField nickname, username, phone;
    private JPasswordField Password, Password2;
    private JButton register, back;
    private JComboBox<String> jcb, year, month, day;
    private Register This = this;
    private Calendar c = Calendar.getInstance();
    public Register(String s) {
        setTitle(s);//设置标题
        //RG = true;
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//退出后关闭
        //不能关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginch.setVisible(true);
                if(mainFrame1 != null){
                    loginch.toFront();
                }
                //RG = false;
                This.dispose();
                register = null;
            }
        });//退出后关闭
        setSize(400, 300);
        setResizable(false);//不可缩放
        setLocationRelativeTo(null);//中心显示
        //设置背景颜色为黑色
        //getContentPane().setBackground(Color.black);
        RegisterUI();
    }
    private void RegisterUI() {
        Text = new JLabel("请选择您注册的身份：");
        jcb = new JComboBox<String>();
        jcb.addItem("用户");
        jcb.addItem("专家");
        jcb.addItem("管理员");
        jptop = new JPanel();
        jptop.add(Text);
        jptop.add(jcb);
        //设置透明
        jptop.setOpaque(false);

        add(jptop, "North");
        jpcenter = new JPanel(new GridLayout(6, 2));
        nickname_label = new JLabel("昵称：");
        username_label = new JLabel("用户名：");
        phone_label = new JLabel("手机号：");
        password_label = new JLabel("密码：");
        password_label2 = new JLabel("确认密码：");
        age_label = new JLabel("年龄：");
        nickname = new JTextField(20);
        username = new JTextField(20);
        phone = new JTextField(20);
        Password = new JPasswordField(20);
        Password2 = new JPasswordField(20);
        age = new JPanel(new GridLayout(1, 3));
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
        //透明
        age_label.setOpaque(false);
        //透明
        nickname.setOpaque(false);
        nickname.addKeyListener(new KeyListener(){
            //键盘回车
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    username.grabFocus();
                }
            }
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        username.setOpaque(false);
        username.addKeyListener(new KeyListener(){
            //键盘回车
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    phone.grabFocus();
                }
            }
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        phone.setOpaque(false);
        phone.addKeyListener(new KeyListener(){
            //键盘回车
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    Password.grabFocus();
                }
            }
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        Password.setOpaque(false);
        Password.addKeyListener(new KeyListener(){
            //键盘回车
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    Password2.grabFocus();
                }
            }
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        Password2.setOpaque(false);
        Password2.addKeyListener(new KeyListener(){
            //键盘回车
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    registeruser();
                }
            }
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        age.add(year);
        age.add(month);
        age.add(day);
        jpcenter.add(nickname_label);
        jpcenter.add(nickname);
        jpcenter.add(username_label);
        jpcenter.add(username);
        jpcenter.add(phone_label);
        jpcenter.add(phone);
        jpcenter.add(password_label);
        jpcenter.add(Password);
        jpcenter.add(password_label2);
        jpcenter.add(Password2);
        jpcenter.add(age_label);
        jpcenter.add(age);
        //透明
        jpcenter.setOpaque(false);
        add(jpcenter, "Center");
        jpbottom = new JPanel(new FlowLayout());
        register = new JButton("注册");
        //透明
        register.setOpaque(false);
        register.setContentAreaFilled(false);
        //register.setBorderPainted(false);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registeruser();
            }
        });
        back = new JButton("返回");
        //透明
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        //back.setBorderPainted(false);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginch.setVisible(true);
                if(mainFrame1 != null){
                    loginch.toFront();
                }
                //RG = false;
                This.dispose();
                register = null;
            }
        });
        jpbottom.add(register);
        jpbottom.add(back);
        //透明
        jpbottom.setOpaque(false);
        add(jpbottom, "South");
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
    private void registeruser(){
        int x = c.get(Calendar.YEAR);//获取当前年份
        int y = c.get(Calendar.MONTH) + 1;//获取当前月份
        int z = c.get(Calendar.DATE);//获取当前日
        String name = nickname.getText();
        String user = username.getText();
        String phone_num = phone.getText();
        String password = String.valueOf(Password.getPassword());
        String password2 = String.valueOf(Password2.getPassword());
        //计算年龄
        int age_str = x - Integer.parseInt(year.getSelectedItem().toString());
        if(y < Integer.parseInt(month.getSelectedItem().toString())){
            age_str--;
        }else if(y == Integer.parseInt(month.getSelectedItem().toString()) && z < Integer.parseInt(day.getSelectedItem().toString())){
            age_str--;
        }

        if (name.equals("") || user.equals("") || phone_num.equals("") || password.equals("") || password2.equals("")) {
            JOptionPane.showMessageDialog(null, "请输入完整信息！", "提示", JOptionPane.WARNING_MESSAGE);
        } else if (!password.equals(password2)) {
            JOptionPane.showMessageDialog(null, "两次密码不一致！", "提示", JOptionPane.WARNING_MESSAGE);
        } else if (phone_num.length() != 11) {
            JOptionPane.showMessageDialog(null, "手机号码长度不正确！", "提示", JOptionPane.WARNING_MESSAGE);
        } else {
            try{
                String identity = jcb.getSelectedItem().toString();
                String sql_1;
                if (identity.equals("用户")) {
                    identity = "userinfo";
                    sql_1 = "insert into userinfo values(?,?,?,?,?,?,?)";
                    //stmt = conn.createStatement();//创建游标1
                    //判断用户名是否存在
                    String sql_2 = "select * from userinfo where UserAccount = ?";
                    PreparedStatement pstmt_1 = conn.prepareStatement(sql_2);
                    pstmt_1.setString(1, user);
                    ResultSet rs = pstmt_1.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "用户名已存在！", "提示", JOptionPane.WARNING_MESSAGE);
                        username.setText("");
                    } else {
                        PreparedStatement pstme_2 = conn.prepareStatement(sql_1);//创建游标2
                        Statement stmt = conn.createStatement();
                        String sql = "SELECT * FROM userinfo";
                        ResultSet rs_1 = stmt.executeQuery(sql);
                        int count = 1;
                        while(rs_1.next()){
                            if(count < rs_1.getInt("UserID")){
                                break;
                            }
                            count++;
                        }//判断id号是否顺序且连续，如果缺少就在当前缺少的序号上加入
                        pstme_2.setInt(1, count);
                        pstme_2.setString(2, user);
                        pstme_2.setString(3, password);
                        pstme_2.setString(4, name);
                        pstme_2.setInt(5, 1);
                        pstme_2.setString(6, phone_num);
                        pstme_2.setInt(7, age_str);
                        pstme_2.executeUpdate();

                        pstmt_1.close();
                        pstme_2.close();
                        stmt.close();
                        rs.close();
                        rs_1.close();
                        JOptionPane.showMessageDialog(null, "注册成功！", "提示", JOptionPane.INFORMATION_MESSAGE);//
                        NickName = name;
                        UserID = count;
                        UserAccount = user;
                        UserPhone = phone_num;
                        UserAge = age_str;
                        dlcg = true;
                        if(mainFrame1 != null){
                            mainFrame1.dispose();
                        }
                        mainFrame1 = new MainFrame("用户");
                        mainFrame1.setVisible(true);
                        This.dispose();
                    }
                } else if (identity.equals("专家")) {
                    identity = "expertinfo";
                    //sql_1 = "insert into expertinfo values(?,?,?,?,?,?)";
                } else if (identity.equals("管理员")) {
                    identity = "admininfo";
                    //sql_1 = "insert into admininfo values(?,?,?,?,?,?)";
                }
            }catch (Exception e1){
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "注册失败！", "提示", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}