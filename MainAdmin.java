package Chinese_Flower;

import javax.swing.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

public class MainAdmin extends F_demo implements ActionListener {
    private Elements elements_1 = null, elements_2 = null , name_zw = null, other_name = null, keshu = null, fenlei = null, xttz = null, shxx = null;
    private JList<String> feedback_list, flowers_list, users_list;
    private JRadioButton jrb1, flower_tp;
    private JTextField fb_back, flower_name, flower_other_name, flower_class, flower_fg, flower_zdtj;
    private JTextArea feedback_text, flower_introduce, flower_MC, flower_Life_Habit;
    private JLabel Jlb0, JLb1, JLb2, JLb3, fb_text1, flower_name_lb, flower_other_name_lb, flower_class_lb, flower_fg_lb, flower_introduce_lb, flower_MC_lb, flower_Life_Habit_lb;
    private JScrollPane jsp_fb1, jsp_fb2, jsp_flower, flower_introduce_jsp, flower_MC_jsp, flower_Life_Habit_jsp;
    private JButton login_1, exit, user_gl, fb_send, feedback_gl, flowers_gl, expert_gl, push_gl, back_fb, all_fb, unreply_fb, dele_fb, reply_fb, flower_tj, flower_sc, flower_xg, back_flowers, tj_flower, zdtj_flower, back_user;
    private JPanel jpour, jpall, jpfb1, jpfb2, list_jp_all, list_jp_top, list_jp_buttom, jpfb2_c, jpfb2_c_buttom, jp21_buttom, jp4_addall, jp4_addall_1, jp4_addall_2, jp4_addall_3, jp4_addall_4, jp4_addall_5, jp4_addall_6, jp4_addall_7, jp4_add_1234567, jp4_buttom, jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8, jp9, jp10, jp11, jp12, jp13, jp14, jp15, jp16, jp17, jp18, jp19, jp20, jp21, jp22, jp23;
    private JMenuBar menuBar;
    private JPanel jp1_add_buttom, jp1_add_1234567, jp1_addall_1, jp1_addall_2, jp1_addall_3, jp1_addall_4, jp1_addall_5, jp1_addall_6, jp1_addall_7;
    private JLabel user_id_lb, user_Account_lb, user_PWD_lb, user_Nick_lb, user_IsActive_lb, user_Phone_lb, user_Age_lb;
    private JTextField user_id, user_Account, user_PWD, user_Nick, user_IsActive, user_Phone, user_Age;
    private JButton tj_user, user_tj;
    private JMenu jm1, jm2, jm3, jm4, jm5, jm6;
    private JMenuItem jmi1, jmi2, jmi3, jmi4, jmi5, jmi6, jmi7, jmi8, jmi9, jmi10, jmi11, jmi12, jmi13, jmi14, jmi15, jmi16, jmi17, jmi18;
    private boolean all = false;
    private String fb_send_time, fb_reply_time, fb_reply;
    private int reply_id;
    public void setLogin(String nick){
        login_1.setText(nick);
    }
    public MainAdmin(String s) {
        setTitle("中国花卉大全-"+s+"端");
        setIconImage(icon_1.getImage());//设置图标
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭当前窗口
        setSize(1000, 700);
        // setResizable(false);//不可缩放
        //setUndecorated(true);//去掉窗口边框
        setLocationRelativeTo(null);//中心
        setLayout(new BorderLayout());
        menuBar();//菜单栏
        adminUI();//界面
    }
    private void adminUI() {
        jpall = new JPanel(cl);
        jp1 = new JPanel(new BorderLayout());
        jp1UI();
        jp2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp4 = new JPanel(new BorderLayout());
        jp4ui();
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
        jp19 = new JPanel(new BorderLayout());
        jp20 = new JPanel(new BorderLayout());

        jp21 = new JPanel(new BorderLayout());
        jp22 = new JPanel(new BorderLayout());
        jp23 = new JPanel(new BorderLayout());

        jp1.add(new JLabel("添加用户", JLabel.CENTER), BorderLayout.NORTH);
        jp2.add(new JLabel("删除用户"));
        jp3.add(new JLabel("修改用户"));
        jp4.add(new JLabel("添加花卉", JLabel.CENTER), BorderLayout.NORTH);
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
        jp19.add(new JLabel("用户管理", JLabel.CENTER), BorderLayout.NORTH);
        jp19ff();
        jp20.add(new JLabel("专家管理", JLabel.CENTER), BorderLayout.NORTH);

        jp21ff();
        jp22.add(new JLabel("推送管理", JLabel.CENTER), BorderLayout.NORTH);
        jp23.add(new JLabel("反馈管理", JLabel.CENTER), BorderLayout.NORTH);
        jp23ff();

        jpall.add(jp19, "19");
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
        jpall.add(jp20, "20");

        jpall.add(jp21, "21");
        jpall.add(jp22, "22");
        jpall.add(jp23, "23");


        jpour = new JPanel(new GridLayout(11, 1, 0, 5));
        //设置颜色
        jpour.setBackground(new Color(135,206,250));

        Jlb0 = new JLabel("中国花卉大全");
        Jlb0.setFont(new Font("宋体", Font.BOLD, 25));
        Jlb0.setForeground(Color.WHITE);

        JLb1 = new JLabel("管理员界面", JLabel.CENTER);
        JLb1.setFont(new Font("宋体", Font.BOLD, 20));
        JLb1.setForeground(Color.WHITE);

        JLb2 = new JLabel("—————————", JLabel.CENTER);
        JLb3 = new JLabel("—————————", JLabel.CENTER);

        login_1 = new JButton(user_model.getNickName());
        //设置长度
        login_1.setPreferredSize(new Dimension(100, 30));
        //透明
        login_1.setOpaque(false);
        login_1.setFont(new Font("宋体", Font.PLAIN, 20));
        login_1.setBorder(null);//去掉边框
        login_1.setContentAreaFilled(false);//去掉背景色
        login_1.setFocusPainted(false);
        login_1.addActionListener(this);
        //鼠标移入
        login_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                login_1.setOpaque(true);
                login_1.setBackground(new Color(65,105,225));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                login_1.setOpaque(false);
            }
        });
        exit = new JButton("退出");
        exit.setFont(new Font("宋体", Font.PLAIN, 20));
        exit.setBorder(null);//去掉边框
        exit.setContentAreaFilled(false);//去掉背景色
        exit.setFocusPainted(false);
        exit.addActionListener(this);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exit.setOpaque(true);
                exit.setBackground(new Color(65,105,225));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                exit.setOpaque(false);
            }
        });
        user_gl = new JButton("用户管理");
        user_gl.setFont(new Font("宋体", Font.PLAIN, 20));
        user_gl.setBorder(null);//去掉边框
        user_gl.setContentAreaFilled(false);//去掉背景色
        user_gl.setFocusPainted(false);
        user_gl.addActionListener(this);
        user_gl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                user_gl.setOpaque(true);
                user_gl.setBackground(new Color(65,105,225));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                user_gl.setOpaque(false);
            }
        });
        user_gl.setOpaque(true);
        user_gl.setBackground(new Color(65,105,225));

        feedback_gl = new JButton("反馈管理");
        feedback_gl.setFont(new Font("宋体", Font.PLAIN, 20));
        feedback_gl.setBorder(null);//去掉边框
        feedback_gl.setContentAreaFilled(false);//去掉背景色
        feedback_gl.setFocusPainted(false);
        feedback_gl.addActionListener(this);
        feedback_gl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                feedback_gl.setOpaque(true);
                feedback_gl.setBackground(new Color(65,105,225));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                feedback_gl.setOpaque(false);
            }
        });
        expert_gl = new JButton("专家管理");
        expert_gl.setFont(new Font("宋体", Font.PLAIN, 20));
        expert_gl.setBorder(null);//去掉边框
        expert_gl.setContentAreaFilled(false);//去掉背景色
        expert_gl.setFocusPainted(false);
        expert_gl.addActionListener(this);
        expert_gl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                expert_gl.setOpaque(true);
                expert_gl.setBackground(new Color(65,105,225));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                expert_gl.setOpaque(false);
            }
        });
        flowers_gl = new JButton("花卉管理");
        flowers_gl.setFont(new Font("宋体", Font.PLAIN, 20));
        flowers_gl.setBorder(null);//去掉边框
        flowers_gl.setContentAreaFilled(false);//去掉背景色
        flowers_gl.setFocusPainted(false);
        flowers_gl.addActionListener(this);
        flowers_gl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                flowers_gl.setOpaque(true);
                flowers_gl.setBackground(new Color(65,105,225));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                flowers_gl.setOpaque(false);
            }
        });
        push_gl = new JButton("推送管理");
        push_gl.setFont(new Font("宋体", Font.PLAIN, 20));
        push_gl.setBorder(null);//去掉边框
        push_gl.setContentAreaFilled(false);//去掉背景色
        push_gl.setFocusPainted(false);
        push_gl.addActionListener(this);
        push_gl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                push_gl.setOpaque(true);
                push_gl.setBackground(new Color(65,105,225));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                push_gl.setOpaque(false);
            }
        });



        jpour.add(Jlb0);
        jpour.add(JLb1);
        jpour.add(login_1);
        jpour.add(JLb2);
        jpour.add(user_gl);
        jpour.add(expert_gl);
        jpour.add(flowers_gl);
        jpour.add(push_gl);
        jpour.add(feedback_gl);

        jpour.add(JLb3);
        jpour.add(exit);
        add(jpour, BorderLayout.WEST);
        add(jpall, BorderLayout.CENTER);

        
    }
    private void jp1UI() {
        jp1_add_buttom = new JPanel();
        jp1_add_buttom.setOpaque(false);

        back_user = new JButton("返回到用户管理");
        back_user.setFont(new Font("宋体", Font.PLAIN, 20));
        //back_user.setBorder(null);//去掉边框
        back_user.setContentAreaFilled(false);//去掉背景色
        back_user.setFocusPainted(false);
        back_user.addActionListener(this);

        jp1_add_buttom.add(back_user);

        jp1_add_1234567 = new JPanel(new GridLayout(7, 1));
        jp1_add_1234567.setOpaque(false);//设置透明

        jp1_addall_1 = new JPanel(new BorderLayout());
        jp1_addall_1.setOpaque(false);//设置透明

        user_id_lb = new JLabel("用户ID:");
        user_id_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        user_id_lb.setOpaque(false);
        user_id = new JTextField();
        user_id.setFont(new Font("宋体", Font.PLAIN, 17));
        //flower_id.setColumns(10);//设置输入框的长度
        user_id.setEditable(false);//不可编辑
        jp1_addall_1.add(user_id_lb, BorderLayout.WEST);
        jp1_addall_1.add(user_id, BorderLayout.CENTER);

        jp1_addall_2 = new JPanel(new BorderLayout());
        jp1_addall_2.setOpaque(false);//设置透明
        user_Account_lb = new JLabel("用户名：");
        user_Account_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        user_Account_lb.setOpaque(false);
        user_Account = new JTextField();
        user_Account.setFont(new Font("宋体", Font.PLAIN, 17));
        //user_Account.setColumns(10);//设置输入框的长度
        jp1_addall_2.add(user_Account_lb, BorderLayout.WEST);
        jp1_addall_2.add(user_Account, BorderLayout.CENTER);

        jp1_addall_3 = new JPanel(new BorderLayout());
        jp1_addall_3.setOpaque(false);//设置透明
        user_PWD_lb = new JLabel("用户密码：");
        user_PWD_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        user_PWD_lb.setOpaque(false);
        user_PWD = new JTextField();
        user_PWD.setFont(new Font("宋体", Font.PLAIN, 17));
        //user_PWD.setColumns(10);//设置输入框的长度
        jp1_addall_3.add(user_PWD_lb, BorderLayout.WEST);
        jp1_addall_3.add(user_PWD, BorderLayout.CENTER);

        jp1_addall_4 = new JPanel(new BorderLayout());
        jp1_addall_4.setOpaque(false);//设置透明
        user_Nick_lb = new JLabel("用户昵称：");
        user_Nick_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        user_Nick_lb.setOpaque(false);
        user_Nick = new JTextField();
        user_Nick.setFont(new Font("宋体", Font.PLAIN, 17));
        //user_Nick.setColumns(10);//设置输入框的长度
        jp1_addall_4.add(user_Nick_lb, BorderLayout.WEST);
        jp1_addall_4.add(user_Nick, BorderLayout.CENTER);

        jp1_addall_5 = new JPanel(new BorderLayout());
        jp1_addall_5.setOpaque(false);//设置透明
        user_IsActive_lb = new JLabel("用户是否激活：");
        user_IsActive_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        user_IsActive_lb.setOpaque(false);
        user_IsActive = new JTextField();
        user_IsActive.setFont(new Font("宋体", Font.PLAIN, 17));
        //user_IsActive.setColumns(10);//设置输入框的长度
        jp1_addall_5.add(user_IsActive_lb, BorderLayout.WEST);
        jp1_addall_5.add(user_IsActive, BorderLayout.CENTER);

        jp1_addall_6 = new JPanel(new BorderLayout());
        jp1_addall_6.setOpaque(false);//设置透明
        user_Phone_lb = new JLabel("用户电话：");
        user_Phone_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        user_Phone_lb.setOpaque(false);
        user_Phone = new JTextField();
        user_Phone.setFont(new Font("宋体", Font.PLAIN, 17));
        //user_Phone.setColumns(10);//设置输入框的长度
        jp1_addall_6.add(user_Phone_lb, BorderLayout.WEST);
        jp1_addall_6.add(user_Phone, BorderLayout.CENTER);

        jp1_addall_7 = new JPanel(new BorderLayout());
        jp1_addall_7.setOpaque(false);//设置透明
        user_Age_lb = new JLabel("用户年龄：");
        user_Age_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        user_Age_lb.setOpaque(false);
        user_Age = new JTextField();
        user_Age.setFont(new Font("宋体", Font.PLAIN, 17));
        //user_Age.setColumns(10);//设置输入框的长度
        jp1_addall_7.add(user_Age_lb, BorderLayout.WEST);
        jp1_addall_7.add(user_Age, BorderLayout.CENTER);

        tj_user = new JButton("添加");
        tj_user.setFont(new Font("宋体", Font.PLAIN, 20));
        tj_user.setOpaque(false);
        tj_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user_Account_str = user_Account.getText();
                String user_PWD_str = user_PWD.getText();
                String user_Nick_str = user_Nick.getText();
                String user_IsActive_str = user_IsActive.getText();
                String user_Phone_str = user_Phone.getText();
                String user_Age_str = user_Age.getText();
                int user_IsActive_int = Integer.parseInt(user_IsActive_str);
                int user_Age_int = Integer.parseInt(user_Age_str);
                if (user_Account_str.equals("") || user_PWD_str.equals("") || user_Nick_str.equals("") || user_IsActive_str.equals("") || user_Phone_str.equals("") || user_Age_str.equals("")) {
                    JOptionPane.showMessageDialog(null, "请将信息填写完整！");
                }else if(user_Phone_str.length()!=11){
                    JOptionPane.showMessageDialog(null, "请输入正确的电话号码！");
                }else if(user_Age_int<0||user_Age_int>120){
                    JOptionPane.showMessageDialog(null, "请输入正确的年龄！");
                }else {
                    String sql = "";
                    if(tj_user.getText().equals("修改")){
                        String user_id_str = user_id.getText();
                        int user_id_int = Integer.parseInt(user_id_str);
                        sql = "update userinfo set UserAccount = '"+user_Account_str+"',UserPWD = '"+user_PWD_str+"',NickName = '"+user_Nick_str+"',IsActive = '"+user_IsActive_int+"',UserPhone = '"+user_Phone_str+"',UserAge = '"+user_Age_int+"' where UserID = '"+user_id_int+"'";
                        try{
                            PreparedStatement pstmt2 = conn.prepareStatement(sql);
                            pstmt2.executeUpdate();
                            pstmt2.close();
                            JOptionPane.showMessageDialog(null, "修改成功！");
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                            JOptionPane.showMessageDialog(null, "修改失败！");
                        }
                    }else{
                        sql = "insert into userinfo(UserAccount,UserPWD,NickName,IsActive,UserPhone,UserAge) values('"+user_Account_str+"','"+user_PWD_str+"','"+user_Nick_str+"','"+user_IsActive_int+"','"+user_Phone_str+"','"+user_Age_int+"')";
                        try{
                            PreparedStatement ps = conn.prepareStatement(sql);
                            ps.executeUpdate();
                            ps.close();
                            JOptionPane.showMessageDialog(null, "添加成功！");
                            user_id.setText("");
                            user_Account.setText("");
                            user_PWD.setText("");
                            user_Nick.setText("");
                            user_IsActive.setText("");
                            user_Phone.setText("");
                            user_Age.setText("");
                        }catch(SQLException e1){
                            e1.printStackTrace();
                            JOptionPane.showMessageDialog(null, "添加失败！");
                        }
                    }
                }
            }
        });
        jp1_add_buttom.add(tj_user);

        jp1_add_1234567.add(jp1_addall_1);
        jp1_add_1234567.add(jp1_addall_2);
        jp1_add_1234567.add(jp1_addall_3);
        jp1_add_1234567.add(jp1_addall_4);
        jp1_add_1234567.add(jp1_addall_5);
        jp1_add_1234567.add(jp1_addall_6);
        jp1_add_1234567.add(jp1_addall_7);

        jp1.add(jp1_add_1234567, BorderLayout.CENTER);
        jp1.add(jp1_add_buttom, BorderLayout.SOUTH);

    }
    private void jp4ui() {
        back_flowers = new JButton("返回到花卉管理");
        back_flowers.setFont(new Font("宋体", Font.PLAIN, 20));
        //back_flowers.setBorder(null);//去掉边框
        back_flowers.setContentAreaFilled(false);//去掉背景色
        back_flowers.setFocusPainted(false);
        back_flowers.addActionListener(this);

        jp4_add_1234567 = new JPanel(new GridLayout(5, 1));
        jp4_add_1234567.setOpaque(false);//设置透明

        jp4_addall_1 = new JPanel(new BorderLayout());
        jp4_addall_1.setOpaque(false);//设置透明
        flower_name_lb = new JLabel("花卉名称 并且输入其拼音(用空格隔开)：");
        flower_name_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        flower_name_lb.setOpaque(false);
        flower_name = new JTextField();
        flower_name.setFont(new Font("宋体", Font.PLAIN, 17));
        //flower_name.setColumns(10);//设置输入框的长度
        jp4_addall_1.add(flower_name_lb, BorderLayout.WEST);
        jp4_addall_1.add(flower_name, BorderLayout.CENTER);

        jp4_addall_2 = new JPanel(new BorderLayout());
        jp4_addall_2.setOpaque(false);//设置透明
        flower_other_name_lb = new JLabel("花卉别名：");
        flower_other_name_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        flower_other_name_lb.setOpaque(false);
        flower_other_name = new JTextField();
        flower_other_name.setFont(new Font("宋体", Font.PLAIN, 17));
        //flower_other_name.setColumns(10);//设置输入框的长度
        jp4_addall_2.add(flower_other_name_lb, BorderLayout.WEST);
        jp4_addall_2.add(flower_other_name, BorderLayout.CENTER);

        jp4_addall_3 = new JPanel(new BorderLayout());
        jp4_addall_3.setOpaque(false);//设置透明
        flower_class_lb = new JLabel("花卉类型：");
        flower_class_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        flower_class_lb.setOpaque(false);
        flower_class = new JTextField();
        flower_class.setFont(new Font("宋体", Font.PLAIN, 17));
        //flower_class.setColumns(10);//设置输入框的长度
        jp4_addall_3.add(flower_class_lb, BorderLayout.WEST);
        jp4_addall_3.add(flower_class, BorderLayout.CENTER);

        jp4_addall_4 = new JPanel(new BorderLayout());
        jp4_addall_4.setOpaque(false);//设置透明
        flower_fg_lb = new JLabel("花卉科属：");
        flower_fg_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        flower_fg_lb.setOpaque(false);
        flower_fg = new JTextField();
        flower_fg.setFont(new Font("宋体", Font.PLAIN, 17));
        //flower_fg.setColumns(10);//设置输入框的长度
        jp4_addall_4.add(flower_fg_lb, BorderLayout.WEST);
        jp4_addall_4.add(flower_fg, BorderLayout.CENTER);

        JPanel jp4_addall_lei = new JPanel(new BorderLayout());
        jp4_addall_lei.setOpaque(false);//设置透明
        JLabel flower_lei_lb = new JLabel("花卉类别：");
        flower_lei_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        flower_lei_lb.setOpaque(false);
        //下拉列表
        JComboBox<String> flower_lei = new JComboBox<String>();
        flower_lei.setFont(new Font("宋体", Font.PLAIN, 17));
        flower_lei.addItem("趣味类");
        flower_lei.addItem("芳香类");
        flower_lei.addItem("观果类");
        flower_lei.addItem("观花类");
        flower_lei.addItem("观叶类");
        flower_lei.addItem("观茎类");
        flower_lei.addItem("节庆类");
        flower_lei.addItem("垂吊类");
        flower_lei.addItem("果蔬类");
        flower_lei.addItem("水培类");
        flower_lei.addItem("盆栽类");
        flower_lei.addItem("地被草坪");
        //flower_area.setColumns(10);//设置输入框的长度
        jp4_addall_lei.add(flower_lei_lb, BorderLayout.WEST);
        jp4_addall_lei.add(flower_lei, BorderLayout.CENTER);


        jp4_add_1234567 .add(jp4_addall_1);
        jp4_add_1234567.add(jp4_addall_2);
        jp4_add_1234567.add(jp4_addall_3);
        jp4_add_1234567.add(jp4_addall_4);
        jp4_add_1234567.add(jp4_addall_lei);

        jp4_addall_5 = new JPanel(new BorderLayout());
        jp4_addall_5.setOpaque(false);//设置透明
        //jp4_addall_5.setSize(0, 300);
        flower_introduce_lb = new JLabel("花卉简介：");
        flower_introduce_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        // flower_introduce_lb.setOpaque(false);
        flower_introduce = new JTextArea();
        // flower_introduce.setOpaque(false);
        flower_introduce.setFont(new Font("宋体", Font.PLAIN, 17));
        flower_introduce.setLineWrap(true);//设置自动换行
        flower_introduce_jsp = new JScrollPane();
        flower_introduce_jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        flower_introduce_jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        flower_introduce_jsp.setOpaque(false);
        flower_introduce_jsp.getViewport().setOpaque(false);
        flower_introduce_jsp.setViewportView(flower_introduce);
        flower_introduce_jsp.setPreferredSize(new Dimension(0, 200));
        jp4_addall_5.add(flower_introduce_lb, BorderLayout.NORTH);
        jp4_addall_5.add(flower_introduce_jsp, BorderLayout.CENTER);

        jp4_addall_6 = new JPanel(new BorderLayout());
        jp4_addall_6.setOpaque(false);//设置透明
        flower_MC_lb = new JLabel("花卉形态特征：");
        flower_MC_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        // flower_MC_lb.setOpaque(false);
        flower_MC = new JTextArea();
        // flower_MC.setOpaque(false);
        flower_MC.setFont(new Font("宋体", Font.PLAIN, 17));
        flower_MC.setLineWrap(true);//设置自动换行
        flower_MC_jsp = new JScrollPane();
        flower_MC_jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        flower_MC_jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        flower_MC_jsp.setOpaque(false);
        flower_MC_jsp.getViewport().setOpaque(false);
        flower_MC_jsp.setViewportView(flower_MC);
        flower_MC_jsp.setPreferredSize(new Dimension(0, 200));
        jp4_addall_6.add(flower_MC_lb, BorderLayout.NORTH);
        jp4_addall_6.add(flower_MC_jsp, BorderLayout.CENTER);

        jp4_addall_7 = new JPanel(new BorderLayout());
        jp4_addall_7.setOpaque(false);//设置透明
        flower_Life_Habit_lb = new JLabel("花卉生活习性：");
        flower_Life_Habit_lb.setFont(new Font("宋体", Font.PLAIN, 20));
        // flower_Life_Habit_lb.setOpaque(false);
        flower_Life_Habit = new JTextArea();
        // flower_Life_Habit.setOpaque(false);
        flower_Life_Habit.setFont(new Font("宋体", Font.PLAIN, 17));
        flower_Life_Habit.setLineWrap(true);//设置自动换行
        flower_Life_Habit_jsp = new JScrollPane();
        flower_Life_Habit_jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        flower_Life_Habit_jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        flower_Life_Habit_jsp.setOpaque(false);
        flower_Life_Habit_jsp.getViewport().setOpaque(false);
        flower_Life_Habit_jsp.setViewportView(flower_Life_Habit);
        flower_Life_Habit_jsp.setPreferredSize(new Dimension(0, 200));
        jp4_addall_7.add(flower_Life_Habit_lb, BorderLayout.NORTH);
        jp4_addall_7.add(flower_Life_Habit_jsp, BorderLayout.CENTER);

        jp4_buttom = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        jp4_buttom.setOpaque(false);

        tj_flower = new JButton("添加");
        tj_flower.setFont(new Font("宋体", Font.PLAIN, 20));
        //tj_flower.setOpaque(false);
        //tj_flower.setBorderPainted(false);
        tj_flower.setContentAreaFilled(false);
        tj_flower.setFocusPainted(false);
        tj_flower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //分割花卉名称
                String[] flower_name_ = flower_name.getText().split(" ");
                String flower_other_name_ = flower_other_name.getText();
                String flower_class_ = flower_class.getText();
                String flower_fg_ = flower_fg.getText();
                String flower_introduce_ = flower_introduce.getText();
                String flower_MC_ = flower_MC.getText();
                String flower_Life_Habit_ = flower_Life_Habit.getText();
                if (flower_name_[0].equals("") || flower_name_[1].equals("") || flower_class_.equals("") || flower_fg_.equals("") || flower_introduce_.equals("") || flower_MC_.equals("") || flower_Life_Habit_.equals("")) {
                    JOptionPane.showMessageDialog(null, "请将信息填写完整！");
                } else {
                    String sql = "";
                    if(tj_flower.getText().equals("修改")){
                        sql = "update flowersinfo set FlowersImage = '"+flower_name_[1]+"',FlowersName = '"+flower_name_[0]+"',FlowersOtherName = '"+flower_other_name_+"',FlowersClass = '"+flower_class_+"',Flowers_FG = '"+flower_fg_+"',Flowers_Introduce = '"+flower_introduce_+"',Flowers_MC = '"+flower_MC_+"',Flowers_Life_Habit = '"+flower_Life_Habit_+"', AdminID = '"+user_model.getUserID()+"' where FlowersImage = '"+flower_name_[1]+"'";
                        try{
                            PreparedStatement pstmt2 = conn.prepareStatement(sql);
                            pstmt2.executeUpdate();
                            pstmt2.close();
                            JOptionPane.showMessageDialog(null, "修改成功！");
                        }catch(Exception e1){
                            JOptionPane.showMessageDialog(null, "修改失败！");
                        }
                    }else{
                        try{
                            sql = "insert into flowersinfo(FlowersImage,FlowersName,FlowersOtherName,FlowersClass,Flowers_FG,Flowers_Introduce,Flowers_MC,Flowers_Life_Habit,AdminID) values(?,?,?,?,?,?,?,?,?)";
                            PreparedStatement ps = conn.prepareStatement(sql);
                            ps.setString(1,flower_name_[1]);
                            ps.setString(2,flower_name_[0]);
                            ps.setString(3,flower_other_name_);
                            ps.setString(4,flower_class_);
                            ps.setString(5,flower_fg_);
                            ps.setString(6,flower_introduce_);
                            ps.setString(7,flower_MC_);
                            ps.setString(8,flower_Life_Habit_);
                            ps.setInt(9,user_model.getUserID());
                            ps.executeUpdate();
                            ps.close();
                            JOptionPane.showMessageDialog(null, "添加成功！");
                            flower_name.setText("");
                            flower_other_name.setText("");
                            flower_class.setText("");
                            flower_fg.setText("");
                            flower_introduce.setText("");
                            flower_MC.setText("");
                            flower_Life_Habit.setText("");
                        }catch(Exception e1){
                            JOptionPane.showMessageDialog(null, "添加失败！\n可能数据库已存在该花卉信息！");
                        }
                    }
                }
            }
        });
        jp4_addall = new JPanel(new GridLayout(4, 1, 0, 10));
        jp4_addall.setOpaque(false);//设置透明
        //设置长宽
        jp4_addall.setPreferredSize(new Dimension(0, 0));

        jp4_addall.add(jp4_add_1234567);
        jp4_addall.add(jp4_addall_5);
        jp4_addall.add(jp4_addall_6);
        jp4_addall.add(jp4_addall_7);

        // jp4_addall_jsp = new JScrollPane(jp4_addall);
        // jp4_addall_jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // jp4_addall_jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // jp4_addall_jsp.setOpaque(false);
        // jp4_addall_jsp.getViewport().setOpaque(false);
        // jp4_addall_jsp.getVerticalScrollBar().setUnitIncrement(20);//设置滚动条滚动时候的步长

        flower_zdtj = new JTextField(18);
        flower_zdtj.addFocusListener(new JTextFieldHintListener(flower_zdtj, "输入花卉拼音"));
        flower_zdtj.setFont(new Font("宋体", Font.PLAIN, 18));
        flower_zdtj.setOpaque(false);
        // flower_zdtj.setColumns(10);//设置文本框的列数

        zdtj_flower = new JButton("自动添加");
        zdtj_flower.setFont(new Font("宋体", Font.PLAIN, 20));
        zdtj_flower.setOpaque(false);
        //zdtj_flower.setBorderPainted(false);
        zdtj_flower.setContentAreaFilled(false);
        zdtj_flower.setFocusPainted(false);
        zdtj_flower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pachong();
            }
        });

        flower_tp = new JRadioButton("是否添加图片");
        flower_tp.setOpaque(false);
        flower_tp.setFont(new Font("宋体", Font.PLAIN, 15));
        flower_tp.setSelected(true);//默认选中


        jp4_buttom.add(back_flowers);
        jp4_buttom.add(tj_flower);

        jp4_buttom.add(flower_zdtj);
        jp4_buttom.add(zdtj_flower);
        jp4_buttom.add(flower_tp);

        jp4.add(jp4_addall, BorderLayout.CENTER);
        jp4.add(jp4_buttom, BorderLayout.SOUTH);
    }
    protected void pachong() {
        String zdtj = flower_zdtj.getText(), name_name, d_url;
        if(zdtj.equals("") || zdtj.equals("输入花卉拼音")){
            JOptionPane.showMessageDialog(null, "请输入花卉拼音！");
            return;
        }
        try{
            Document document;
            document = Jsoup.connect("http://www.aihuhua.com/huahui/"+zdtj+".html").get();
            document = Jsoup.connect("http://www.aihuhua.com/huahui/"+zdtj+".html").get();
            if(document.toString().contains("该信息不存在或已被删除")){
                JOptionPane.showMessageDialog(null, "该信息不存在或已被删除！");
                flower_zdtj.setText("");
                return;
            }
            elements_1 = document.select("#main-box > div.content > div.infodata > div.img > img");
            elements_2 = document.select("#doc-content > dd");
            name_zw = document.select("#main-box > div.content > div.infodata > div.cont > h1");
            other_name = document.select("#main-box > div.content > div.infodata > div.cont > label:nth-child(2)");
            keshu = document.select("#main-box > div.content > div.infodata > div.cont > label:nth-child(4)");
            fenlei = document.select("#main-box > div.content > div.infodata > div.cont > label:nth-child(3) > a");
            xttz = document.select("#doc-9b51f49757644682f44c681fd327fe9b > dd");
            shxx = document.select("#doc-2353e0b8be52db129e7205b21a5b11d2 > dd");
            if(shxx.size() == 0){
                shxx = document.select("#doc-16f73fe40ddd57f00e829531a272d688 > dd");
            }
            d_url = elements_1.attr("src");
            name_name = name_zw.attr("title");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "请检查网络连接！或者搜索失败！");
            flower_zdtj.setText("");
            return;
        }
        flower_name.setText(name_name+" "+zdtj);
        flower_other_name.setText(other_name.text().substring(3));
        flower_class.setText(fenlei.text());
        flower_fg.setText(keshu.text().substring(3));
        flower_introduce.setText(elements_2.text());
        flower_MC.setText(xttz.text().replace(" ","\n"));
        flower_Life_Habit.setText(shxx.text().replace(" ","\n"));
        //是否下载图片
        if(flower_tp.isSelected()){
            try{
                File file = new File("src\\Chinese_Flower\\image\\"+zdtj+".jpg");
                if(file.exists()){
                    file.delete();
                }//删除原来的图片
                URL url = new URL(d_url);
                InputStream is = url.openStream();
                OutputStream os = new FileOutputStream(file);
                byte[] b = new byte[2048];
                int length;
                while ((length = is.read(b)) != -1) {
                    os.write(b, 0, length);
                }
                is.close();
                os.close();
                JOptionPane.showMessageDialog(null, "下载完成！");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "下载失败！");
            }
        }
        flower_zdtj.setText("");
    }
    private void jp19ff() {
        JPanel user_noth = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        user_noth.setOpaque(false);
        JLabel user_gl = new JLabel("用户管理                                                ");

        JTextField user_sr_name = new JTextField(20);
        user_sr_name.addFocusListener(new JTextFieldHintListener(user_sr_name, "请输入搜索内容"));
        //键盘回车搜索
        user_sr_name.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String name = user_sr_name.getText();
                    if(name.equals("请输入搜索内容")){
                        JOptionPane.showMessageDialog(null, "请输入用户名称！");
                        return;
                    }
                    getuserList(true, name);
                    user_sr_name.setText("");
                }
            }
        });
        JButton user_sr = new JButton("搜索");
        user_sr.setFont(new Font("宋体", Font.PLAIN, 15));
        // user_sr.setOpaque(false);
        user_sr.setContentAreaFilled(false);
        user_sr.setBorder(null);
        user_sr.setFocusPainted(false);
        user_sr.setForeground(Color.gray);
        user_sr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = user_sr_name.getText();
                if(name.equals("请输入搜索内容")){
                    JOptionPane.showMessageDialog(null, "请输入用户名称！");
                    return;
                }
                getuserList(true, name);
                user_sr_name.setText("");
            }
        });

        user_noth.add(user_gl);
        user_noth.add(user_sr_name);
        user_noth.add(user_sr);

        JScrollPane jsp_user = new JScrollPane();
        //透明
        jsp_user.setOpaque(false);
        jsp_user.getViewport().setOpaque(false);
        jsp_user.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp_user.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp_user.setViewportBorder(null);//去掉边框

        users_list = new JList<>();
        users_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//设置可以多选
        users_list.setFont(new Font("宋体", Font.PLAIN, 20));
        users_list.setSelectionBackground(new Color(127,255,212));//选中颜色
        users_list.setOpaque(false);//透明

        getuserList(false,"");

        JPanel jp19_buttom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp19_buttom.setOpaque(false);//透明

        JButton user_xg = new JButton("修改用户");
        user_xg.setFont(new Font("宋体", Font.PLAIN, 20));
        //user_xg.setBorder(null);//去掉边框
        user_xg.setContentAreaFilled(false);//去掉背景色
        user_xg.setFocusPainted(false);
        user_xg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(users_list.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(null, "请选择要修改的用户！");
                }else if(users_list.getSelectedIndices().length > 1){
                    JOptionPane.showMessageDialog(null, "只能选择一个用户进行修改！");
                }else{
                    int index = users_list.getSelectedIndex();
                    String name = users_list.getModel().getElementAt(index).substring(users_list.getModel().getElementAt(index).indexOf("号用户：")+4,users_list.getModel().getElementAt(index).indexOf(" "));
                    try{
                        String sql = "select * from userinfo where UserAccount = '"+name+"'";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        ResultSet rs = pstmt.executeQuery();
                        if(rs.next()){
                            user_id.setText(rs.getInt("UserID")+"");
                            user_Account.setText(rs.getString("UserAccount"));
                            user_PWD.setText(rs.getString("UserPWD"));
                            user_Nick.setText(rs.getString("NickName"));
                            user_IsActive.setText(rs.getInt("IsActive")+"");
                            user_Phone.setText(rs.getString("UserPhone"));
                            user_Age.setText(rs.getInt("UserAge")+"");
                        }
                        rs.close();
                        pstmt.close();
                    }catch(Exception e1){
                        JOptionPane.showMessageDialog(null, "查询失败！");
                    }
                    tj_user.setText("修改");
                    cl.show(jpall, "1");
                }
            }
        });

        JButton user_sc = new JButton("删除用户");
        user_sc.setFont(new Font("宋体", Font.PLAIN, 20));
        //user_sc.setBorder(null);//去掉边框
        user_sc.setContentAreaFilled(false);//去掉背景色
        user_sc.setFocusPainted(false);
        user_sc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(users_list.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(null, "请选择要删除的用户", "提示", JOptionPane.WARNING_MESSAGE);
                }else{
                    int[] index = users_list.getSelectedIndices();//获取选中的索引
                    String[] users_ = new String[index.length];
                    String url = "";
                    int j;
                    for(j=0;j<index.length;j++){
                        users_[j] = users_list.getModel().getElementAt(index[j]).substring(0, users_list.getModel().getElementAt(index[j]).indexOf("号"));
                        
                        if(j==index.length-1){
                            url += users_[j];
                        }else{
                            url += users_[j]+",";
                        }
                    }//获取选中的内容
                    int w = JOptionPane.showConfirmDialog(null, users_[0]!=users_[j-1]? ("确定要删除“"+users_[0]+"~"+users_[j-1]+"号用户”吗？"):("确定要删除“"+ users_list.getModel().getElementAt(index[0]).substring(users_list.getModel().getElementAt(index[0]).indexOf("号用户：")+4, users_list.getModel().getElementAt(index[0]).indexOf(" "))+"”吗？"), "提示", JOptionPane.YES_NO_OPTION);
                    if(w == 0){
                        try{
                            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM userinfo WHERE UserID in ("+url+")");
                            pstmt.executeUpdate();
                            pstmt.close();
                            JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.WARNING_MESSAGE);
                            getuserList(false,"");
                        }catch(SQLException e2){
                            e2.printStackTrace();
                        }catch(Exception e2){
                            e2.printStackTrace();
                        }
                    }
                }

            }
        });

        user_tj = new JButton("添加用户");
        user_tj.setFont(new Font("宋体", Font.PLAIN, 20));
        //user_tj.setBorder(null);//去掉边框
        user_tj.setContentAreaFilled(false);//去掉背景色
        user_tj.setFocusPainted(false);
        user_tj.addActionListener(this);

        jp19_buttom.add(user_xg);
        jp19_buttom.add(user_sc);
        jp19_buttom.add(user_tj);

        jsp_user.setViewportView(users_list);

        jp19.add(user_noth, BorderLayout.NORTH);
        jp19.add(jsp_user, BorderLayout.CENTER);
        jp19.add(jp19_buttom, BorderLayout.SOUTH);
    }
    protected void getuserList(boolean is_search, String search_name) {
        int i = 0;
        String[] user = new String[999];
        if(search_name.equals("all") || search_name.equals("ALL") || search_name.equals("")){
            is_search = false;
        }
        if(is_search){
            try{
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM userinfo WHERE UserAccount like '%"+search_name+"%'");
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    user[i] = rs.getInt("UserID") +"号用户："+ rs.getString("UserAccount")+" 昵称："+rs.getString("NickName");
                    i++;
                }
                pstmt.close();
                rs.close();
                user = Arrays.copyOf(user, i);
                users_list.setListData(user);
            }catch(SQLException e2){
                e2.printStackTrace();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }else{
            try {
                PreparedStatement stmt = conn.prepareStatement("select * from userinfo");
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    user[i] = rs.getInt("UserID") +"号用户："+ rs.getString("UserAccount")+" 昵称："+rs.getString("NickName");
                    i++;
                }
                stmt.close();
                rs.close();
                user = Arrays.copyOf(user, i);//把数组中的元素复制到新数组中
                users_list.setListData(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void jp21ff() {
        JPanel flower_noth = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        flower_noth.setOpaque(false);
        JLabel flower_gl = new JLabel("花卉管理                                                ");

        JTextField flower_sr_name = new JTextField(20);
        flower_sr_name.addFocusListener(new JTextFieldHintListener(flower_sr_name, "请输入搜索内容"));
        //键盘回车搜索
        flower_sr_name.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String name = flower_sr_name.getText();
                    if(name.equals("请输入搜索内容")){
                        JOptionPane.showMessageDialog(null, "请输入花卉名称！");
                        return;
                    }
                    getflowerList(true, name);
                    flower_sr_name.setText("");
                }
            }
        });
        JButton flower_sr = new JButton("搜索");
        flower_sr.setFont(new Font("宋体", Font.PLAIN, 15));
        // flower_sr.setOpaque(false);
        flower_sr.setContentAreaFilled(false);
        flower_sr.setBorder(null);
        flower_sr.setFocusPainted(false);
        flower_sr.setForeground(Color.gray);
        flower_sr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = flower_sr_name.getText();
                if(name.equals("请输入搜索内容")){
                    JOptionPane.showMessageDialog(null, "请输入花卉名称！");
                    return;
                }
                getflowerList(true, name);
                flower_sr_name.setText("");
            }
        });

        flower_noth.add(flower_gl);
        flower_noth.add(flower_sr_name);
        flower_noth.add(flower_sr);

        jsp_flower = new JScrollPane();
        //透明
        jsp_flower.setOpaque(false);
        jsp_flower.getViewport().setOpaque(false);
        jsp_flower.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp_flower.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp_flower.setViewportBorder(null);//去掉边框

        flowers_list = new JList<>();
        flowers_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//设置可以多选
        flowers_list.setFont(new Font("宋体", Font.PLAIN, 20));
        flowers_list.setSelectionBackground(new Color(127,255,212));//选中颜色
        flowers_list.setOpaque(false);//透明

        getflowerList(false,"");

        jp21_buttom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp21_buttom.setOpaque(false);//透明

        flower_xg = new JButton("修改花卉");
        flower_xg.setFont(new Font("宋体", Font.PLAIN, 20));
        //flower_xg.setBorder(null);//去掉边框
        flower_xg.setContentAreaFilled(false);//去掉背景色
        flower_xg.setFocusPainted(false);
        flower_xg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flowers_list.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(null, "请选择要修改的花卉！");
                }else if(flowers_list.getSelectedIndices().length > 1){
                    JOptionPane.showMessageDialog(null, "只能选择一个花卉进行修改！");
                }else{
                    int index = flowers_list.getSelectedIndex();
                    String name = flowers_list.getModel().getElementAt(index).substring(flowers_list.getModel().getElementAt(index).indexOf("号花卉：")+4);
                    tj_flower.setText("修改");
                    try{
                        String sql = "select * from flowersinfo where FlowersName = '"+name+"'";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        ResultSet rs = pstmt.executeQuery();
                        while(rs.next()){
                            flower_name.setText(rs.getString("FlowersName")+" "+rs.getString("FlowersImage"));
                            flower_other_name.setText(rs.getString("FlowersOtherName"));
                            flower_class.setText(rs.getString("FlowersClass"));
                            flower_fg.setText(rs.getString("Flowers_FG"));
                            flower_introduce.setText(rs.getString("Flowers_Introduce"));
                            flower_MC.setText(rs.getString("Flowers_MC"));
                            flower_Life_Habit.setText(rs.getString("Flowers_Life_Habit"));
                        }
                        rs.close();
                        pstmt.close();
                    }catch(Exception e1){
                        JOptionPane.showMessageDialog(null, "查询失败！");
                    }
                    jp4_buttom.removeAll();
                    jp4_buttom.add(back_flowers);
                    jp4_buttom.add(tj_flower);
                    jp4_buttom.updateUI();
                    cl.show(jpall, "4");
                }
            }
        });

        flower_sc = new JButton("删除花卉");
        flower_sc.setFont(new Font("宋体", Font.PLAIN, 20));
        //flower_sc.setBorder(null);//去掉边框
        flower_sc.setContentAreaFilled(false);//去掉背景色
        flower_sc.setFocusPainted(false);
        flower_sc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flowers_list.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(null, "请选择要删除的花卉", "提示", JOptionPane.WARNING_MESSAGE);
                }else{
                    int[] index = flowers_list.getSelectedIndices();//获取选中的索引
                    String[] flowers_ = new String[index.length];
                    String url = "";
                    int j;
                    for(j=0;j<index.length;j++){
                        flowers_[j] = flowers_list.getModel().getElementAt(index[j]).substring(0, flowers_list.getModel().getElementAt(index[j]).indexOf("号"));
                        
                        if(j==index.length-1){
                            url += flowers_[j];
                        }else{
                            url += flowers_[j]+",";
                        }
                    }//获取选中的内容
                    int w = JOptionPane.showConfirmDialog(null, flowers_[0]!=flowers_[j-1]? ("确定要删除“"+flowers_[0]+"~"+flowers_[j-1]+"号花卉”吗？"):("确定要删除“"+ flowers_list.getModel().getElementAt(index[0]).substring(flowers_list.getModel().getElementAt(index[0]).indexOf("号花卉：")+4)+"”吗？"), "提示", JOptionPane.YES_NO_OPTION);
                    if(w == 0){
                        try{
                            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM flowersinfo WHERE FlowersID in ("+url+")");
                            pstmt.executeUpdate();
                            pstmt.close();
                            JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.WARNING_MESSAGE);
                            getflowerList(false,"");
                        }catch(SQLException e2){
                            e2.printStackTrace();
                        }catch(Exception e2){
                            e2.printStackTrace();
                        }
                    }
                }

            }
        });

        flower_tj = new JButton("添加花卉");
        flower_tj.setFont(new Font("宋体", Font.PLAIN, 20));
        //flower_tj.setBorder(null);//去掉边框
        flower_tj.setContentAreaFilled(false);//去掉背景色
        flower_tj.setFocusPainted(false);
        flower_tj.addActionListener(this);

        jp21_buttom.add(flower_xg);
        jp21_buttom.add(flower_sc);
        jp21_buttom.add(flower_tj);

        jsp_flower.setViewportView(flowers_list);

        jp21.add(flower_noth, BorderLayout.NORTH);
        jp21.add(jsp_flower, BorderLayout.CENTER);
        jp21.add(jp21_buttom, BorderLayout.SOUTH);
    }
    private void getflowerList(boolean is_search, String search_name) {
        int i = 0;
        String[] flower = new String[199];
        if(search_name.equals("all") || search_name.equals("ALL") || search_name.equals("")){
            is_search = false;
        }
        if(is_search){
            try{
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM flowersinfo WHERE FlowersName like '%"+search_name+"%'");
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    flower[i] = rs.getInt("FlowersID") +"号花卉："+ rs.getString("FlowersName");
                    i++;
                }
                pstmt.close();
                rs.close();
                flower = Arrays.copyOf(flower, i);
                flowers_list.setListData(flower);
            }catch(SQLException e2){
                e2.printStackTrace();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }else{
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from flowersinfo");
                while (rs.next()) {
                    flower[i] = rs.getInt("FlowersID") +"号花卉："+ rs.getString("FlowersName");
                    i++;
                }
                stmt.close();
                rs.close();
                flower = Arrays.copyOf(flower, i);//把数组中的元素复制到新数组中
                flowers_list.setListData(flower);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void getList() {
        int i=0;
        String[] FBContent = new String[100];
        try{
            String sql;
            if(all){
                sql = "select * from feedback where IsTDW = 1";
            }else{
                sql = "SELECT * FROM Feedback where IsTDW = 0";
            }
            PreparedStatement pstmt = conn.prepareStatement(sql);//创建游标2
            ResultSet rs = pstmt.executeQuery();//执行查询
            while(rs.next()){
                FBContent[i] = "反馈号："+rs.getInt("FeedbackID") +" 用户ID："+ rs.getInt("UserID") +" 反馈内容："+ rs.getString("FeedbackContent");
                i++;
                if(i>=99){
                    break;
                }
            }
            rs.close();
            pstmt.close();
        }catch(SQLException e2){
            e2.printStackTrace();
        }catch(Exception e2){
            e2.printStackTrace();
        }
        FBContent = Arrays.copyOf(FBContent, i);//把FBContent的长度设置为i
        feedback_list.setListData(FBContent);
        FBContent = null;
    }
    private void jp23ff() {
        jpfb1 = new JPanel(cl);

        list_jp_all = new JPanel(new BorderLayout());
        list_jp_all.setOpaque(false);//透明

        list_jp_top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        list_jp_top.setOpaque(false);

        list_jp_buttom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        list_jp_buttom.setOpaque(false);

        all_fb = new JButton("已回复反馈");
        all_fb.setFont(new Font("宋体", Font.PLAIN, 20));
        //all_fb.setBorder(null);//去掉边框
        // all_fb.setContentAreaFilled(false);//去掉背景色
        all_fb.setBackground(Color.white);
        all_fb.setFocusPainted(false);//去掉焦点
        all_fb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                all = true;
                unreply_fb.setBackground(Color.white);
                all_fb.setBackground(Color.LIGHT_GRAY);
                reply_fb.setText("查看回复");
                getList();
            }
        });

        unreply_fb = new JButton("未回复反馈");
        unreply_fb.setFont(new Font("宋体", Font.PLAIN, 20));
        //unreply_fb.setBorder(null);//去掉边框
        // unreply_fb.setContentAreaFilled(false);//去掉背景色
        unreply_fb.setBackground(Color.LIGHT_GRAY);
        unreply_fb.setFocusPainted(false);
        unreply_fb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                all = false;
                all_fb.setBackground(Color.white);
                unreply_fb.setBackground(Color.LIGHT_GRAY);
                reply_fb.setText("回复反馈");
                getList();
            }
        });

        list_jp_top.add(all_fb);
        list_jp_top.add(unreply_fb);

        jsp_fb1 = new JScrollPane();
        //透明
        jsp_fb1.setOpaque(false);
        jsp_fb1.getViewport().setOpaque(false);
        jsp_fb1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp_fb1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        feedback_list = new JList<String>();
        feedback_list.setFont(new Font("宋体", Font.PLAIN, 20));
        feedback_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//设置可以多选
        //feedback_list.setVisibleRowCount(5);//设置可见行数
        
        
        getList();

        jsp_fb1.setViewportView(feedback_list);


        dele_fb = new JButton("删除反馈");
        dele_fb.setFont(new Font("宋体", Font.PLAIN, 20));
        //dele_fb.setBorder(null);//去掉边框
        dele_fb.setContentAreaFilled(false);//去掉背景色
        dele_fb.setFocusPainted(false);
        dele_fb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = feedback_list.getSelectedIndex();//获取选中的行
                if(i==-1){
                    JOptionPane.showMessageDialog(null, "请选择要删除的反馈！", "提示", JOptionPane.WARNING_MESSAGE);
                }else{
                    int[] index = feedback_list.getSelectedIndices();//获取选中的索引
                    String[] FBContent = new String[index.length];
                    String url = "";
                    int j;
                    for(j=0;j<index.length;j++){
                        FBContent[j] = feedback_list.getModel().getElementAt(index[j]).substring(4, feedback_list.getModel().getElementAt(index[j]).indexOf(" "));
                        
                        if(j==index.length-1){
                            url += FBContent[j];
                        }else{
                            url += FBContent[j]+",";
                        }
                    }//获取选中的内容
                    int w = JOptionPane.showConfirmDialog(null, "确定要删除“"+FBContent[0]+"~"+FBContent[j-1]+"号反馈”吗？", "提示", JOptionPane.YES_NO_OPTION);
                    if(w == 0){
                        try{
                            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM feedback WHERE FeedbackID in ("+url+")");
                            pstmt.executeUpdate();
                            pstmt.close();
                            JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.WARNING_MESSAGE);
                            getList();
                        }catch(SQLException e2){
                            e2.printStackTrace();
                        }catch(Exception e2){
                            e2.printStackTrace();
                        }
                    }
                }
            }
        });

        reply_fb = new JButton("回复反馈");
        reply_fb.setFont(new Font("宋体", Font.PLAIN, 20));
        //reply_fb.setBorder(null);//去掉边框
        reply_fb.setContentAreaFilled(false);//去掉背景色
        reply_fb.setFocusPainted(false);
        reply_fb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取选中的行的内容
                String str = feedback_list.getSelectedValue();//获取选中的行的内容
                //判断选择是否是多行
                if(feedback_list.getSelectedIndices().length>1){
                    JOptionPane.showMessageDialog(null, "请选择一行！", "提示", JOptionPane.WARNING_MESSAGE);
                }else if(str==null){
                    JOptionPane.showMessageDialog(null, "请选择要回复的反馈！", "提示", JOptionPane.WARNING_MESSAGE);
                }else{
                    //截取"反馈号："到" 反馈内容："之间的内容
                    String str1 = str.substring(str.indexOf("反馈号："), str.indexOf(" 反馈内容："));
                    String str2 = str.substring(str.indexOf("反馈内容：")+5);//截取"反馈内容："到最后的内容

                    fb_text1.setText(str1);
                    //获取回复内容
                    try{
                        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM feedback WHERE FeedbackID = ?");
                        pstmt.setInt(1, Integer.parseInt(str1.substring(4, str1.indexOf(" "))));
                        ResultSet rs = pstmt.executeQuery();
                        if(rs.next()){
                            fb_send_time = rs.getString("FeedbackTime");
                            reply_id = rs.getInt("AdminID");
                            fb_reply_time = rs.getString("ReplyTime");
                            fb_reply = rs.getString("ReplyContent");
                        }
                        rs.close();
                        pstmt.close();
                    }catch(SQLException e2){
                        e2.printStackTrace();
                    }
                    if(all){
                        feedback_text.setText(fb_send_time+"\n"+str2+"\n\n"+reply_id+"号管理员\n"+fb_reply_time+"\n"+fb_reply);
                        fb_back.setEditable(false);//设置不可编辑
                        fb_send.setEnabled(false);
                    }else{
                        feedback_text.setText(fb_send_time+"\n"+str2);
                        fb_back.setEditable(true);//设置可编辑
                        fb_send.setEnabled(true);
                    }
                    cl.show(jpfb1, "jsp2");
                }
            }
        });

        list_jp_buttom.add(dele_fb);
        list_jp_buttom.add(reply_fb);

        list_jp_all.add(list_jp_top, BorderLayout.NORTH);
        list_jp_all.add(jsp_fb1, BorderLayout.CENTER);
        list_jp_all.add(list_jp_buttom, BorderLayout.SOUTH);

        jpfb1.add(list_jp_all, "jsp_fb1");

        jpfb2 = new JPanel(new BorderLayout());
        back_fb = new JButton("返回");
        back_fb.setFont(new Font("宋体", Font.PLAIN, 20));
        //透明
        back_fb.setOpaque(false);
        back_fb.setBorder(null);//去掉边框
        back_fb.setContentAreaFilled(false);//去掉背景色
        back_fb.setFocusPainted(false);
        back_fb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(jpfb1, "jsp_fb1");
            }
        });


        fb_text1 = new JLabel();
        fb_text1.setFont(new Font("宋体", Font.PLAIN, 20));

        feedback_text = new JTextArea();
        feedback_text.setFont(new Font("宋体", Font.PLAIN, 15));
        //透明
        feedback_text.setOpaque(false);
        //设置不可编辑
        feedback_text.setEditable(false);
        feedback_text.setBorder(null);//去掉边框
        feedback_text.setLineWrap(true);//自动换行

        jsp_fb2 = new JScrollPane();
        //透明
        jsp_fb2.setOpaque(false);
        jsp_fb2.getViewport().setOpaque(false);
        jsp_fb2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp_fb2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp_fb2.setViewportView(feedback_text);

        jpfb2_c = new JPanel(new BorderLayout());
        //透明
        jpfb2_c.setOpaque(false);
        jpfb2_c.add(jsp_fb2, BorderLayout.CENTER);

        fb_back = new JTextField(40);
        fb_back.setOpaque(false);//透明

        fb_send = new JButton("发送");
        //透明
        fb_send.setOpaque(false);
        fb_send.setBorder(null);//去掉边框
        fb_send.setContentAreaFilled(false);//去掉背景色
        fb_send.setFocusPainted(false);
        fb_send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = fb_text1.getText();
                int fb_id = Integer.parseInt(str.substring(4, str.indexOf(" 用户ID：")));
                String str1 = fb_back.getText();
                if(str1.equals("")){
                    JOptionPane.showMessageDialog(null, "请输入回复内容！");
                }else{
                    try{
                        PreparedStatement pstmt1 = conn.prepareStatement("UPDATE Feedback SET IsTDW = ?, ReplyContent = ?, ReplyTime = ?, AdminID = ? WHERE FeedbackID = ?");//创建游标2
                        if(jrb1.isSelected()){
                            pstmt1.setInt(1, 1);
                        }else{
                            pstmt1.setInt(1, 0);
                        }
                        pstmt1.setString(2, str1);
                        Date date = new Date();
                        Timestamp time = new Timestamp(date.getTime());
                        pstmt1.setTimestamp(3, time);
                        pstmt1.setInt(4, user_model.getUserID());
                        pstmt1.setInt(5, fb_id);
                        pstmt1.executeUpdate();
                        pstmt1.close();
                        //JOptionPane.showMessageDialog(null, "回复成功！");
                        fb_back.setText("");
                        feedback_text.setText(feedback_text.getText()+"\n"+"回复内容："+str1+"\n"+"回复时间："+time);
                        getList();
                    }catch(SQLException e2){
                        e2.printStackTrace();
                    }
                }
            }
        });
        jrb1 = new JRadioButton("完成回复");
        //jrb1.setFont(new Font("宋体", Font.PLAIN, 20));
        jrb1.setOpaque(false);
        jrb1.setSelected(true);//默认选中

        jpfb2_c_buttom = new JPanel(new FlowLayout());
        //透明
        jpfb2_c_buttom.setOpaque(false);

        jpfb2_c_buttom.add(back_fb);
        jpfb2_c_buttom.add(fb_back);
        jpfb2_c_buttom.add(fb_send);
        jpfb2_c_buttom.add(jrb1);


        jpfb2_c.add(jpfb2_c_buttom, BorderLayout.SOUTH);


        jpfb2.add(fb_text1, BorderLayout.NORTH);
        jpfb2.add(jpfb2_c, BorderLayout.CENTER);
        // jpfb2.add(back_fb, BorderLayout.SOUTH);



        jpfb1.add(jpfb2, "jsp2");
        jp23.add(jpfb1, BorderLayout.CENTER);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == jmi1 || e.getSource() == user_tj) {
            tj_user.setText("添加");
            opaqueall();
            cl.show(jpall, "1");
        } else if (e.getSource() == jmi2) {
            opaqueall();
            cl.show(jpall, "2");
        } else if (e.getSource() == jmi3) {
            opaqueall();
            cl.show(jpall, "3");
        } else if (e.getSource() == jmi4 || e.getSource() == flower_tj) {
            tj_flower.setText("添加");
            jp4_buttom.removeAll();
            jp4_buttom.add(back_flowers);
            jp4_buttom.add(tj_flower);
            jp4_buttom.add(flower_zdtj);
            jp4_buttom.add(zdtj_flower);
            jp4_buttom.add(flower_tp);
            jp4_buttom.updateUI();
            opaqueall();//透明
            cl.show(jpall, "4");
        } else if (e.getSource() == jmi5) {
            opaqueall();
            cl.show(jpall, "5");
        } else if (e.getSource() == jmi6) {
            opaqueall();
            cl.show(jpall, "6");
        } else if (e.getSource() == jmi7) {
            opaqueall();
            cl.show(jpall, "7");
        } else if (e.getSource() == jmi8) {
            opaqueall();
            cl.show(jpall, "8");
        } else if (e.getSource() == jmi9) {
            opaqueall();
            cl.show(jpall, "9");
        } else if (e.getSource() == jmi10) {
            opaqueall();
            cl.show(jpall, "10");
        } else if (e.getSource() == jmi11) {
            opaqueall();
            cl.show(jpall, "11");
        } else if (e.getSource() == jmi12) {
            opaqueall();
            cl.show(jpall, "12");
        } else if (e.getSource() == jmi13) {
            opaqueall();
            cl.show(jpall, "13");
        } else if (e.getSource() == jmi14) {
            opaqueall();
            cl.show(jpall, "14");
        } else if (e.getSource() == jmi15) {
            opaqueall();
            cl.show(jpall, "15");
        } else if (e.getSource() == jmi16) {
            opaqueall();
            cl.show(jpall, "16");
        } else if (e.getSource() == jmi17) {
            opaqueall();
            cl.show(jpall, "17");
        } else if (e.getSource() == jmi18) {
            opaqueall();
            cl.show(jpall, "18");
        }else if (e.getSource() == exit) {
            System.exit(0);
        }else if (e.getSource() == login_1) {
            if(pi != null){
                pi.dispose();
            }
            pi = new User_PI();
            pi.setVisible(true);
        }else if (e.getSource() == user_gl || e.getSource() == back_user) {
            user_gl.setEnabled(true);
            user_gl.setEnabled(false);
            user_gl.setOpaque(true);
            user_gl.setBackground(new Color(65,105,225));
            expert_gl.setOpaque(false);//设置为透明
            flowers_gl.setOpaque(false);
            push_gl.setOpaque(false);
            feedback_gl.setOpaque(false);
            expert_gl.setEnabled(true);
            flowers_gl.setEnabled(true);
            push_gl.setEnabled(true);
            feedback_gl.setEnabled(true);

            user_id.setText("");
            user_Account.setText("");
            user_PWD.setText("");
            user_Nick.setText("");
            user_Phone.setText("");
            user_Age.setText("");
            user_IsActive.setText("");
            cl.show(jpall, "19");
        }else if (e.getSource() == expert_gl) {
            expert_gl.setEnabled(true);
            expert_gl.setEnabled(false);
            expert_gl.setOpaque(true);
            expert_gl.setBackground(new Color(65,105,225));
            user_gl.setOpaque(false);
            flowers_gl.setOpaque(false);
            push_gl.setOpaque(false);
            feedback_gl.setOpaque(false);
            user_gl.setEnabled(true);
            flowers_gl.setEnabled(true);
            push_gl.setEnabled(true);
            feedback_gl.setEnabled(true);
            getuserList(false, "");

            cl.show(jpall, "20");
        }else if (e.getSource() == flowers_gl || e.getSource() == back_flowers) {
            flowers_gl.setEnabled(true);
            flowers_gl.setEnabled(false);
            flowers_gl.setOpaque(true);
            flowers_gl.setBackground(new Color(65,105,225));
            expert_gl.setOpaque(false);
            user_gl.setOpaque(false);
            push_gl.setOpaque(false);
            feedback_gl.setOpaque(false);
            expert_gl.setEnabled(true);
            user_gl.setEnabled(true);
            push_gl.setEnabled(true);
            feedback_gl.setEnabled(true);

            flower_name.setText("");
            flower_other_name.setText("");
            flower_class.setText("");
            flower_fg.setText("");
            flower_introduce.setText("");
            flower_MC.setText("");
            flower_Life_Habit.setText("");
            getflowerList(false,"");
            cl.show(jpall, "21");
        }else if (e.getSource() == push_gl) {
            push_gl.setEnabled(true);
            push_gl.setEnabled(false);
            push_gl.setOpaque(true);
            push_gl.setBackground(new Color(65,105,225));
            expert_gl.setOpaque(false);
            flowers_gl.setOpaque(false);
            user_gl.setOpaque(false);
            feedback_gl.setOpaque(false);
            expert_gl.setEnabled(true);
            flowers_gl.setEnabled(true);
            user_gl.setEnabled(true);
            feedback_gl.setEnabled(true);

            cl.show(jpall, "22");
        }else if (e.getSource() == feedback_gl) {
            feedback_gl.setEnabled(true);
            feedback_gl.setEnabled(false);
            feedback_gl.setOpaque(true);
            feedback_gl.setBackground(new Color(65,105,225));
            expert_gl.setOpaque(false);
            flowers_gl.setOpaque(false);
            push_gl.setOpaque(false);
            user_gl.setOpaque(false);
            expert_gl.setEnabled(true);
            flowers_gl.setEnabled(true);
            push_gl.setEnabled(true);
            user_gl.setEnabled(true);
            
            cl.show(jpall, "23");
        }

        
    }
    private void opaqueall() {
        feedback_gl.setOpaque(false);
        expert_gl.setOpaque(false);
        flowers_gl.setOpaque(false);
        push_gl.setOpaque(false);
        user_gl.setOpaque(false);
        feedback_gl.setEnabled(true);
        expert_gl.setEnabled(true);
        flowers_gl.setEnabled(true);
        push_gl.setEnabled(true);
        user_gl.setEnabled(true);
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
