package Chinese_Flower;

import javax.swing.*;

import Chinese_Flower.Encryption.Encryption;
import Chinese_Flower.Encryption.EncryptionImpl;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class Loginch extends F_demo implements ActionListener {
    private JButton login, back, forgetPassword;
    private JTextField jtf1;
    private JPasswordField jpf2;
    private JRadioButton jrb1;
    private JButton user, ad, VTL, no_ID, exit;
    private JPanel jp2, jpwest, jp_login, jp_center, jp_butom;
    private JLabel jl1, jl_user_ad_experts, jl_user_name, jl_user_password;
    private Register register = null;
    private String type;
    private Loginch This = this;
    public Loginch(){
        setTitle("登录选择");//设置标题
        setIconImage(icon_1.getImage());//设置图标
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//退出后关闭
        //不能关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(mainFrame1 == null && mainAdmin == null){
                    try {
                        conn.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    System.exit(0);
                }else{
                    This.dispose();
                }
            }
        });//退出后关闭

        setSize(440, 300);
        setResizable(false);//不可缩放
        //setUndecorated(true);//去掉窗口边框
        setLocationRelativeTo(null);//中心
        loginUI();
    }
    public void gb() {
        this.dispose();
    }
    public void loginUI(){
        icon_1.setImage(icon_1.getImage().getScaledInstance(309, 263, Image.SCALE_DEFAULT));

        jpwest = new JPanel(cl);
        //设置颜色
        jpwest.setBackground(new Color(210,210,210));

        jl1 = new JLabel(icon_1);
        jp2 = new JPanel();
        jp2.setLayout(new VerticalFlowLayout(VerticalFlowLayout.CENTER, 10, 10));
        jp2.setBackground(new Color(210,210,210));
        // jp2.setOpaque(false);
        user = new JButton("用户    登录");
        ad = new JButton("管理员登录");
        // experts = new JButton("专家    登录");
        no_ID = new JButton("没有账号？注册");
        exit = new JButton("退出");
        user.setOpaque(false);
        user.setContentAreaFilled(false);
        user.setFocusPainted(false);//不可获取焦点
        ad.setOpaque(false);//透明
        ad.setContentAreaFilled(false);//透明
        ad.setFocusPainted(false);//
        // experts.setOpaque(false);
        // experts.setContentAreaFilled(false);
        // experts.setFocusPainted(false);
        no_ID.setOpaque(false);
        no_ID.setContentAreaFilled(false);//透明
        no_ID.setFocusPainted(false);//不可获取焦点
        no_ID.setBorder(null);//去掉边框
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);//透明
        exit.setFocusPainted(false);//不可获取焦点
        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp_login.removeAll();
                jp_ui("用户");
                jp_login.updateUI();
                cl.show(jpwest, "login");
                jtf1.grabFocus();
            }
        });
        ad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp_login.removeAll();
                jp_ui("管理员");
                jp_login.updateUI();
                cl.show(jpwest, "login");
                jtf1.grabFocus();
            }
        });
        // experts.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         jp_login.removeAll();
        //         jp_ui("专家");
        //         jp_login.updateUI();
        //         cl.show(jpwest, "login");
        //         jtf1.grabFocus();
        //     }
        // });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainFrame1 == null && mainAdmin == null){
                    try {
                        conn.close();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    System.exit(0);
                }else{
                    This.dispose();
                }
            }
        });
        no_ID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                This.setVisible(false);
                register = new Register("注册");
                register.setVisible(true);
                register.toFront();
            }
        });
        no_ID.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                no_ID.setForeground(Color.blue);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                no_ID.setForeground(Color.black);
            }
        });
        if(dlcg == false) {
            yk();
        }
        jp2.add(user);
        // jp2.add(experts);
        jp2.add(ad);
        jp2.add(exit);
        jp2.add(no_ID);

        jp_login = new JPanel(new BorderLayout());
        jp_login.setOpaque(false);
        jpwest.add(jl1, "jl1");
        jpwest.add(jp_login, "login");
        add(jpwest, BorderLayout.CENTER);
        add(jp2, BorderLayout.EAST);
    }

    private void jp_ui(String s) {
        type = s;
        jl_user_ad_experts = new JLabel(s+"登录");
        jl_user_ad_experts.setOpaque(false);
        jl_user_ad_experts.setFont(new Font("宋体", Font.BOLD, 40));
        jl_user_ad_experts.setForeground(Color.black);
        jl_user_ad_experts.setHorizontalAlignment(JLabel.CENTER);
        jl_user_ad_experts.setVerticalAlignment(JLabel.CENTER);

        jp_center = new JPanel(new GridLayout(5, 2, 0, 6));
        jp_center.setOpaque(false);

        jl_user_name = new JLabel(s+"号:");
        jl_user_name.setOpaque(false);
        jl_user_name.setFont(new Font("宋体", Font.BOLD, 15));

        jl_user_password = new JLabel("密码:");
        jl_user_password.setOpaque(false);
        jl_user_password.setFont(new Font("宋体", Font.BOLD, 15));

        jtf1 = new JTextField();
        // jtf1.setOpaque(false);
        // jtf1.setFont(new Font("宋体", Font.BOLD, 20));
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

        jpf2 = new JPasswordField();
        jpf2.setEchoChar('*');//设置密码框不可见
        // jpf2.setOpaque(false);
        // jpf2.setFont(new Font("宋体", Font.BOLD, 20));
        jpf2.addKeyListener(new KeyListener(){
            //键盘回车
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == 10){
                    loginUser(true, "", "", type);
                }
            }
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });

        jp_butom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp_butom.setOpaque(false);

        login = new JButton("登录");
        //透明
        login.setOpaque(false);
        login.setContentAreaFilled(false);
        //login.setBorderPainted(false);
        login.setFocusPainted(false);

        login.addActionListener(this);

        back = new JButton("返回");
        //透明
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        //back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.addActionListener(this);

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
        forgetPassword.setFont(new Font("宋体", Font.PLAIN, 11));
        forgetPassword.addActionListener(this);

        jp_center.add(jl_user_name);
        jp_center.add(jtf1);
        jp_center.add(jl_user_password);
        jp_center.add(jpf2);

        if(s.equals("用户")){
            jrb1 = new JRadioButton("自动登录");
            jrb1.setOpaque(false);
            jrb1.setSelected(true);//默认选中
            jp_butom.add(jrb1);
        }
        jp_butom.add(back);
        jp_butom.add(login);
        jp_butom.add(forgetPassword);


        jp_login.add(jl_user_ad_experts, BorderLayout.NORTH);
        jp_login.add(jp_center, BorderLayout.CENTER);
        jp_login.add(jp_butom, BorderLayout.SOUTH);
    }

    public void yk(){
        VTL = new JButton("游客    登录");
        VTL.setOpaque(false);//透明
        VTL.setContentAreaFilled(false);//透明
        VTL.setFocusPainted(false);//
        VTL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainFrame1 != null){
                    mainFrame1.dispose();
                }
                mainFrame1 = new MainFrame("游客,请登录");
                mainFrame1.setVisible(true);
                This.dispose();
            }
        });
        jp2.add(VTL);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == login){
            loginUser(true,"","",type);
        }
        if(e.getSource() == back){
            //退出当前窗口
            cl.show(jpwest, "jl1");
        }
        if(e.getSource() == forgetPassword){
            //找回密码
            if(fgpw != null){
                fgpw.dispose();
            }
            fgpw = new ForgetPassword(type+"找回密码");
            fgpw.setVisible(true);
            // This.setVisible(false);
        }
    }
    public void loginUser(boolean isLogin, String userName, String password, String type){
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
            if(type.equals("用户")||type.equals("用户自动登录")){
                try {
                    //stmt = conn.createStatement();//创建游标1
                    PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM userinfo WHERE UserAccount = '"+name+"'");//创建游标2
                    ResultSet rs = pstmt.executeQuery();//执行查询

                    // 展开结果集数据库
                    if(rs.next()){
                        String pwd2 = rs.getString("UserPWD");
                        if(pwd1.equals(pwd2)){//密码正确
                            String isActive = rs.getString("IsActive");
                            if(isActive.equals("1")){//激活
                                //读入个人信息
                                user_model.setUserID(rs.getInt("UserID"));
                                user_model.setUserAccount(rs.getString("UserAccount"));
                                user_model.setUserPWD(rs.getString("UserPWD"));
                                user_model.setUserPhone(rs.getString("UserPhone"));
                                user_model.setUserAge(rs.getInt("UserAge"));
                                user_model.setNickName(rs.getString("NickName"));
                                dlcg = true;
                                //jrb1是否选中
                                if(isLogin){
                                    if(jrb1.isSelected()){
                                        //记住密码
                                        //将用户名和密码写入文件
                                        File f2 = new File("src\\Chinese_Flower\\account.lzh");//文件
                                        try{
                                            //覆盖写入
                                            FileWriter fw = new FileWriter(f2);
                                            Encryption e = new EncryptionImpl();
                                            fw.write(e.encryption(name)+" ");
                                            fw.write(e.encryption(pwd1));
                                            fw.close();
                                        }catch(IOException e){
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                if(mainFrame1 != null){
                                    mainFrame1.dispose();
                                    mainFrame1 = null;
                                }
                                if(mainAdmin != null){
                                    mainAdmin.dispose();
                                    mainAdmin = null;
                                }
                                if(pi != null){
                                    pi.dispose();
                                    pi = null;
                                }
                                mainFrame1 = new MainFrame("用户");
                                mainFrame1.setVisible(true);
                                pstmt.close();
                                rs.close();
                                //stmt.close();
                                //conn.close();
                                //pstmt.close();
                                this.dispose();
                                return;
                            }else{
                                JOptionPane.showMessageDialog(null, "该账号已被禁用，请联系管理员！", "提示", JOptionPane.WARNING_MESSAGE);
                                if(type.equals("用户")){
                                    jtf1.setText("");
                                    jpf2.setText("");
                                }else{
                                    loginch.setVisible(true);
                                    //删除文件内容
                                    setFile();
                                }
                                return;//结束方法
                            }
                        }else{
                            if(type.equals("用户自动登录")){
                                loginch.setVisible(true);
                                //删除文件内容
                                setFile();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "密码错误！", "提示", JOptionPane.WARNING_MESSAGE);
                                jpf2.setText("");
                            }
                            return;
                        }
                    }else{
                        if(type.equals("用户自动登录")){
                            loginch.setVisible(true);
                            //删除文件内容
                            setFile();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "用户名不存在！", "提示", JOptionPane.WARNING_MESSAGE);
                            jtf1.setText("");
                            jpf2.setText("");
                        }
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
                    PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM admininfo WHERE AdminName = '"+name+"'");//创建游标2
                    ResultSet rs = pstmt.executeQuery();//执行查询
                
                    // 展开结果集数据库
                    if(rs.next()){
                        String pwd2 = rs.getString("AdminPWD");
                        if(pwd1.equals(pwd2)){
                            //JOptionPane.showMessageDialog(this, "登录成功！");
                            //读入个人信息
                            user_model.setUserID(rs.getInt("AdminID"));
                            user_model.setUserAccount(rs.getString("AdminName"));
                            user_model.setUserPWD(rs.getString("AdminPWD"));
                            user_model.setUserPhone(rs.getString("AdminPhone"));
                            user_model.setUserAge(rs.getInt("AdminAge"));
                            user_model.setNickName(rs.getString("AdminNick"));

                            dlcg = true;
                            if(mainFrame1 != null){
                                mainFrame1.dispose();
                                mainFrame1 = null;
                            }
                            if(mainAdmin != null){
                                mainAdmin.dispose();
                                mainAdmin = null;
                            }
                            if(pi != null){
                                pi.dispose();
                                pi = null;
                            }
                            mainAdmin = new MainAdmin("管理员界面");
                            mainAdmin.setVisible(true);
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
                    }else{
                        JOptionPane.showMessageDialog(null, "管理员名不存在！", "提示", JOptionPane.WARNING_MESSAGE);
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
    private void setFile() {
        File f2 = new File("src\\Chinese_Flower\\account.lzh");//文件
        try{
            //覆盖写入
            FileWriter fw = new FileWriter(f2);
            fw.write("");
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}