package Chinese_Flower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends F_demo{
    private JPanel jptop, jpbottom;
    private JLabel name, nick, age, phone, new_password, new_password2, text;
    private JTextField name_, nick_, age_, phone_, new_password_, new_password_2;
    private JButton refer, exit;
    private ForgetPassword This = this;
    private String type = "";
    public ForgetPassword(String s) {
        type = s;
        setTitle(s);//设置标题
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//退出后关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                This.dispose();
                login.dispose();
            }
        });//退出后关闭
        setSize(400, 300);
        setResizable(false);//不可缩放
        setLocationRelativeTo(null);//中心
        ForgetPasswordUI();
    }
    private void ForgetPasswordUI() {
        //忘记密码
        jptop = new JPanel();
        jptop.setLayout(new GridLayout(6, 2, 1, 3));
        name = new JLabel("登录名：");
        nick = new JLabel("昵称：");
        age = new JLabel("年龄：");
        phone = new JLabel("联系方式：");
        new_password = new JLabel("新密码：");
        new_password2 = new JLabel("确认新密码：");
        name_ = new JTextField(10);
        name_.addKeyListener(new KeyListener(){
            //键盘回车
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    nick_.grabFocus();
                }
            }
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        nick_ = new JTextField(10);
        nick_.addKeyListener(new KeyListener(){
            //键盘回车
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    age_.grabFocus();
                }
            }
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        age_ = new JTextField(10);
        age_.addKeyListener(new KeyListener(){
            //键盘回车
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    phone_.grabFocus();
                }
            }
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        phone_ = new JTextField(10);
        phone_.addKeyListener(new KeyListener(){
            //键盘回车
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    new_password_.grabFocus();
                }
            }
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        new_password_ = new JTextField(10);
        new_password_.addKeyListener(new KeyListener(){
            //键盘回车
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    new_password_2.grabFocus();
                }
            }
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        new_password_2 = new JTextField(10);
        new_password_2.addKeyListener(new KeyListener(){
            //键盘回车
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    referOK();
                }
            }
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        text = new JLabel("请输入您的完整信息以确认身份");
        // 设置字体大小以及颜色
        text.setFont(new Font("宋体", Font.BOLD, 20));
        text.setForeground(Color.red);


        jptop.add(name);
        jptop.add(name_);
        jptop.add(nick);
        jptop.add(nick_);
        jptop.add(age);
        jptop.add(age_);
        jptop.add(phone);
        jptop.add(phone_);
        jptop.add(new_password);
        jptop.add(new_password_);
        jptop.add(new_password2);
        jptop.add(new_password_2);

        jpbottom = new JPanel();

        refer = new JButton("提交");
        exit = new JButton("返回");
        refer.setOpaque(false);//透明
        refer.setContentAreaFilled(false);//透明
        //refer.setFocusPainted(false);//透明
        exit.setOpaque(false);//透明
        exit.setContentAreaFilled(false);//透明
        //exit.setFocusPainted(false);//透明

        refer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                referOK();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                This.dispose();
                login.dispose();
            }
        });
        jpbottom.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpbottom.add(refer);
        jpbottom.add(exit);
        add(text, BorderLayout.NORTH);
        add(jptop, BorderLayout.CENTER);
        add(jpbottom, BorderLayout.SOUTH);
    }
    protected void referOK() {
        // TODO Auto-generated method stub
        String name_1 = name_.getText();
        String nick_1 = nick_.getText();
        String age_1 = age_.getText();
        String phone_1 = phone_.getText();
        String new_password_1 = new_password_.getText();
        String new_password_2_1 = new_password_2.getText();
        if(name_1.equals("")||nick_1.equals("")||age_1.equals("")||phone_1.equals("")||new_password_1.equals("")){
            JOptionPane.showMessageDialog(null, "请填写完整信息！", "提示", JOptionPane.WARNING_MESSAGE);
        }else{
            int age_2;
            try{
                age_2 = Integer.parseInt(age_1);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "请填写正确格式的信息！", "提示", JOptionPane.WARNING_MESSAGE);
                age_.setText("");
                return;
            }
            if(age_2<0||age_2>150){
                JOptionPane.showMessageDialog(null, "请填写正确格式的信息！", "提示", JOptionPane.WARNING_MESSAGE);
                age_.setText("");
            }if(phone_1.length()!=11){
                JOptionPane.showMessageDialog(null, "请填写正确格式的信息！", "提示", JOptionPane.WARNING_MESSAGE);
                phone_.setText("");
            }if(!new_password_1.equals(new_password_2_1)){
                JOptionPane.showMessageDialog(null, "两次密码不一致！", "提示", JOptionPane.WARNING_MESSAGE);
                new_password_.setText("");
                new_password_2.setText("");
            }else{
                int i = JOptionPane.showConfirmDialog(null, "确定提交？", "提示", JOptionPane.YES_NO_OPTION);
                if(i==0){
                    //修改
                    try{
                        String sql = "";
                        String w1 = "", w2 = "", w3 = "", w4 = "";
                        String sql_1 = "";
                        if(type.equals("用户找回密码")){
                            sql = "SELECT * FROM userinfo";
                            sql_1 = "UPDATE userinfo SET UserPWD = ? WHERE UserAccount = ?";
                            w1 = "UserAccount";
                            w2 = "NickName";
                            w3 = "UserPhone";
                            w4 = "UserAge";
                        }else if(type.equals("管理员找回密码")){
                            sql = "SELECT * FROM admininfo";
                            sql_1 = "UPDATE admininfo SET AdminPWD = ? WHERE AdminAccount = ?";
                            w1 = "AdminName";
                            w2 = "AdminNick";
                            w3 = "AdminPhone";
                            w4 = "AdminAge";
                        }else if(type.equals("专家找回密码")){
                            sql = "SELECT * FROM expertinfo";
                            sql_1 = "UPDATE expertinfo SET ExpertPWD = ? WHERE ExpertAccount = ?";
                            w1 = "ExpertName";
                            w2 = "ExpertNick";
                            w3 = "ExpertPhone";
                            w4 = "ExpertAge";
                        }
                        PreparedStatement pstmt_1 = conn.prepareStatement(sql);//创建游标2
                        ResultSet rs = pstmt_1.executeQuery();//执行查询
                        while(rs.next()){
                            if(rs.getString(w1).equals(name_1)){
                                if(rs.getString(w2).equals(nick_1)&&rs.getString(w3).equals(phone_1)&&rs.getString(w4).equals(age_1)){
                                    PreparedStatement pstmt_2 = conn.prepareStatement(sql_1);//创建游标2
                                    pstmt_2.setString(1, new_password_1);
                                    pstmt_2.setString(2, name_1);
                                    pstmt_2.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "提交并更改成功！", "提示", JOptionPane.WARNING_MESSAGE);
                                    pstmt_2.close();
                                    pstmt_1.close();
                                    rs.close();
                                    This.dispose();
                                    login.dispose();
                                    return;
                                }else{
                                    JOptionPane.showMessageDialog(null, "验证错误！", "提示", JOptionPane.WARNING_MESSAGE);
                                    
                                    pstmt_1.close();
                                    rs.close();
                                    return;
                                }
                            }
                        }
                        pstmt_1.close();
                        rs.close();

                        JOptionPane.showMessageDialog(null, "请输入正确的用户名！", "提示", JOptionPane.WARNING_MESSAGE);
                        name_.setText("");
                    }catch(Exception e){
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "操作数据库失败！", "提示", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }
}
