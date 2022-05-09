package Chinese_Flower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class Loginch extends F_demo {
    private JButton user, ad, experts, VTL, no_ID, exit;
    private JPanel jp2;
    private JLabel jl1;
    private Loginch This = this;
    public Loginch(){
        setTitle("登录选择");//设置标题
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//退出后关闭
        //不能关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(mainFrame1 == null){
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
    // public Loginch(String s) {
    //     setTitle(s);
    //     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出后关闭
    //     setSize(440, 300);
    //     setResizable(false);//不可缩放
    //     //setUndecorated(true);//去掉窗口边框
    //     setLocationRelativeTo(null);//中心
    //     loginUI();
        
    // }
    public void gb() {
        this.dispose();
    }
    public void loginUI(){
        ImageIcon icon = new ImageIcon("src\\Chinese_Flower\\image\\load.jpg");
        icon.setImage(icon.getImage().getScaledInstance(getWidth()-150, getHeight(), Image.SCALE_DEFAULT));
        jl1 = new JLabel(icon);
        jp2 = new JPanel();
        jp2.setLayout(new VerticalFlowLayout(VerticalFlowLayout.CENTER, 10, 10));
        user = new JButton("用户    登录");
        ad = new JButton("管理员登录");
        experts = new JButton("专家    登录");
        no_ID = new JButton("没有账号？注册");
        exit = new JButton("退出");
        user.setOpaque(false);
        user.setContentAreaFilled(false);
        //user.setFocusPainted(false);//不可获取焦点
        ad.setOpaque(false);//透明
        ad.setContentAreaFilled(false);//透明
        //ad.setFocusPainted(false);//
        experts.setOpaque(false);
        experts.setContentAreaFilled(false);
        //experts.setFocusPainted(false);
        no_ID.setOpaque(false);
        no_ID.setContentAreaFilled(false);//透明
        no_ID.setFocusPainted(false);//不可获取焦点
        no_ID.setBorder(null);//去掉边框
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);//透明
        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                This.setEnabled(false);
                login = new Login("用户");
                login.setVisible(true);
                login.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        This.setEnabled(true);
                        login = null;
                        //放到屏幕最前面
                        if(mainFrame1 != null){
                            mainFrame1.toFront();
                        }
                        This.toFront();
                    }
                });
                //dispose();
            }
        });
        ad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                This.setEnabled(false);
                login = new Login("管理员");
                login.setVisible(true);
                login.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        This.setEnabled(true);
                        login = null;
                        //放到屏幕最前面
                        if(mainFrame1 != null){
                            mainFrame1.toFront();
                        }
                        This.toFront();
                    }
                });
                //dispose();
            }
        });
        experts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                This.setEnabled(false);
                login = new Login("专家");
                login.setVisible(true);
                login.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        This.setEnabled(true);
                        login = null;
                        //放到屏幕最前面
                        if(mainFrame1 != null){
                            mainFrame1.toFront();
                        }
                        This.toFront();
                    }
                });
                //dispose();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainFrame1 == null){
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
                Register register = new Register("注册");
                register.setVisible(true);
                register.toFront();
            }
        });
        if(dlcg == false) {
            yk();
        }
        jp2.add(user);
        jp2.add(experts);
        jp2.add(ad);
        jp2.add(exit);
        jp2.add(no_ID);
        add(jl1, BorderLayout.WEST);
        add(jp2, BorderLayout.EAST);
    }
    public void yk(){
        VTL = new JButton("游客    登录");
        VTL.setOpaque(false);//透明
        VTL.setContentAreaFilled(false);//透明
        //VTL.setFocusPainted(false);//
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
}