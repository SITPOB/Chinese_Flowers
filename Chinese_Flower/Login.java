package Chinese_Flower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class Login extends F_demo implements ActionListener{//登录界面

    private JPanel jp1, jp2;
    private JLabel jl1, jl2;
    private JButton login, exit, forgetPassword;
    private JTextField jtf1;
    private JPasswordField jpf2;
    private JRadioButton jrb1;
    private String type;
    private Login This = this;

    public Login(String s) {
        type = s;
        setTitle(s+"登录");//设置标题
        setSize(300, 130);//设置窗口大小
        setLocationRelativeTo(null);//居中
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭当前窗口
        //setUndecorated(true);//去掉窗口边框
        //设置窗口背景颜色为黑色
        //getContentPane().setBackground(Color.black);//设置窗口背景颜色
        setResizable(false);//不可缩放
        loginUI();//界面
    }

    public void loginUI() {
        //输入框
        jp1 = new JPanel();
        jp1.setLayout(new GridLayout(2, 2, 1, 6));
        jl1 = new JLabel("用户名：");
        jl2 = new JLabel("密    码：");
        jtf1 = new JTextField(20);//设置长度
        jpf2 = new JPasswordField(20);//设置密码框
        jpf2.setEchoChar('*');//设置密码框不可见
        jtf1.addKeyListener(new KeyListener(){
            //键盘回车
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    jpf2.grabFocus();
                }
            }
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        jpf2.addKeyListener(new KeyListener(){
            //键盘回车
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    loginUser(true, "", "");
                }
            }
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        jp1.add(jl1);
        jp1.add(jtf1);
        jp1.add(jl2);
        jp1.add(jpf2);
        //按钮
        jrb1 = new JRadioButton("自动登录");
        jrb1.setSelected(true);//默认选中
        //登录按钮
        jp2 = new JPanel();
        jp2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        login = new JButton("登录");
        //透明
        login.setOpaque(false);
        login.setContentAreaFilled(false);
        //login.setBorderPainted(false);
        login.setFocusPainted(false);

        exit = new JButton("返回");
        //透明
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        //exit.setBorderPainted(false);
        exit.setFocusPainted(false);

        forgetPassword = new JButton("找回密码");
        forgetPassword.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                forgetPassword.setForeground(Color.blue);
            }//鼠标进入
            public void mouseExited(MouseEvent e) {
                //设置字体颜色
                forgetPassword.setForeground(Color.black);
            }//鼠标移出
        });
        //透明
        forgetPassword.setOpaque(false);//透明
        forgetPassword.setContentAreaFilled(false);//透明
        forgetPassword.setBorderPainted(false);//去掉边框
        forgetPassword.setFocusPainted(false);//不可获取焦点
        //设置字体大小
        forgetPassword.setFont(new Font("宋体", Font.PLAIN, 9));

        exit.addActionListener(this);
        login.addActionListener(this);
        forgetPassword.addActionListener(this);
        jp2.add(jrb1);
        jp2.add(login);
        jp2.add(exit);
        jp2.add(forgetPassword);
        //添加到主面板
        add(jp1, BorderLayout.CENTER);
        add(jp2, BorderLayout.SOUTH);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == login){
            loginUser(true,"","");
        }
        if(e.getSource() == exit){
            //退出当前窗口
            This.dispose();
        }
        if(e.getSource() == forgetPassword){
            //找回密码
            fgpw = new ForgetPassword(type+"找回密码");
            fgpw.setVisible(true);
            This.setVisible(false);
        }
    }
    
    public void loginUser(boolean isLogin, String userName, String password){
        String name = "";
        char[] pwd;
        String pwd1 = "";
        if(isLogin){
            name = jtf1.getText();//获取用户名
            pwd = jpf2.getPassword();//获取密码
            pwd1 = new String(pwd);//转换为字符串
        }else{
            name = userName;
            pwd1 = password;
        }
        if(name.equals("") || pwd1.equals("")){
            JOptionPane.showMessageDialog(null, "用户名或密码不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
            if(type.equals("用户")){
                try {
                    //stmt = conn.createStatement();//创建游标1
                    String sql;
                    sql = "SELECT * FROM userinfo";
                    PreparedStatement pstmt = conn.prepareStatement(sql);//创建游标2
                    ResultSet rs = pstmt.executeQuery();//执行查询
                
                    // 展开结果集数据库
                    while(rs.next()){
                        // 通过字段检索
                        String account = rs.getString("UserAccount");
                        if(account.equals(name)){//判断用户名是否存在
                            String pwd2 = rs.getString("UserPWD");
                            if(pwd1.equals(pwd2)){//密码正确
                                String isActive = rs.getString("IsActive");
                                if(isActive.equals("1")){//激活
                                    if(isLogin){
                                        JOptionPane.showMessageDialog(this, "登录成功！");
                                    }
                                    //读入个人信息
                                    UserID = rs.getInt("UserID");
                                    UserAccount = rs.getString("UserAccount");
                                    NickName = rs.getString("NickName");
                                    UserPhone = rs.getString("UserPhone");
                                    UserAge = rs.getInt("UserAge");

                                    dlcg = true;

                                    //jrb1是否选中
                                    if(jrb1.isSelected()){
                                        //记住密码
                                        //将用户名和密码写入文件
                                        File f2 = new File("src\\Chinese_Flower\\account.lzh");//文件
                                        try{
                                            //覆盖写入
                                            FileWriter fw = new FileWriter(f2);
                                            fw.write(name+" ");
                                            fw.write(pwd1);
                                            fw.close();
                                        }catch(IOException e){
                                            e.printStackTrace();
                                        }
                                    }
                                    if(mainFrame1 != null){
                                        mainFrame1.dispose();
                                    }
                                    if(mainAdmin != null){
                                        mainAdmin.dispose();
                                    }
                                    if(pi != null){
                                        pi.dispose();
                                    }
                                    mainFrame1 = new MainFrame("用户");
                                    mainFrame1.setVisible(true);
                                    if(loginch != null){
                                        loginch.dispose();
                                    }
                                    pstmt.close();
                                    rs.close();
                                    //stmt.close();
                                    // conn.close();
                                    // pstmt.close();
                                    this.dispose();
                                    return;
                                }else{
                                    JOptionPane.showMessageDialog(null, "该账号已被禁用，请联系管理员！", "提示", JOptionPane.WARNING_MESSAGE);
                                    jtf1.setText("");
                                    jpf2.setText("");
                                    return;//结束方法
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "密码错误！", "提示", JOptionPane.WARNING_MESSAGE);
                                jpf2.setText("");
                                return;
                            }
                        }
                    }
                    if(rs.next()==false){
                        JOptionPane.showMessageDialog(null, "用户名不存在！", "提示", JOptionPane.WARNING_MESSAGE);
                        jtf1.setText("");
                        jpf2.setText("");
                        return;
                    }
                }catch(SQLException se){
                    // 处理 JDBC 错误
                    se.printStackTrace();
                }catch(Exception e1){
                    // 处理 Class.forName 错误
                    e1.printStackTrace();
                }
            }
            if(type.equals("管理员")){
                try {
                    //stmt = conn.createStatement();//创建游标
                    String sql;
                    sql = "SELECT * FROM admininfo";
                    PreparedStatement pstmt = conn.prepareStatement(sql);//创建游标2
                    ResultSet rs = pstmt.executeQuery();//执行查询
                
                    // 展开结果集数据库
                    while(rs.next()){
                        // 通过字段检索
                        String account = rs.getString("AdminName");
                        if(account.equals(name)){
                            String pwd2 = rs.getString("AdminPWD");
                            if(pwd1.equals(pwd2)){
                                JOptionPane.showMessageDialog(this, "登录成功！");
                                //读入个人信息
                                UserID = rs.getInt("AdminID");
                                UserAccount = rs.getString("AdminName");
                                NickName = rs.getString("AdminNick");
                                UserPhone = rs.getString("AdminPhone");
                                UserAge = rs.getInt("AdminAge");

                                dlcg = true;
                                if(mainFrame1 != null){
                                    mainFrame1.dispose();
                                }
                                if(mainAdmin != null){
                                    mainAdmin.dispose();
                                }
                                if(pi != null){
                                    pi.dispose();
                                }
                                mainAdmin = new MainAdmin("管理员界面");
                                mainAdmin.setVisible(true);
                                if(loginch != null){
                                    loginch.dispose();
                                }
                                pstmt.close();
                                rs.close();
                                // stmt.close();
                                // conn.close();
                                //pstmt.close();
                                this.dispose();
                                return;
                            }else{
                                JOptionPane.showMessageDialog(null, "密码错误！", "提示", JOptionPane.WARNING_MESSAGE);
                                jpf2.setText("");
                                return;
                            }
                        }
                    }
                    if(rs.next()==false){
                        JOptionPane.showMessageDialog(null, "管理员号不存在！", "提示", JOptionPane.WARNING_MESSAGE);
                        jtf1.setText("");
                        jpf2.setText("");
                        return;
                    }
                }catch(SQLException se){
                    // 处理 JDBC 错误
                    se.printStackTrace();
                }catch(Exception e1){
                    // 处理 Class.forName 错误
                    e1.printStackTrace();
                }
            }
        }
    }
}
//登录界面结束