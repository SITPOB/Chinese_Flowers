package Chinese_Flower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class MainFrame extends F_demo implements ActionListener {

    private JPanel pi_icon, collect_jp, jp_collect_top, jp_collect_center, jpall_first_list, jpall_first_1, jpall_first_2, jp_Flowers_ye, jp_Flowers_fan, jpall_first_3;
    private JPanel jpwest, jpall_first, jpall_second, jpall_second_1_all, jpall_second_1, jpall_second_2, jpall_second_top, jpall_second_button, jpin_Flowers_H, jp_Push, jp_Push_in, jp_east, jp_first, jp_second, jp_third, jp_fourth;
    private JLabel jl, jlline1, jlline2, yeshu, icon_pi, collect_T, ts;
    private JButton exit, jbImage, search_btu, jb_first, jb_second, jb_third, jb_fourth, jb_second_;
    private JButton jb_collect_back;
    private JButton next_btu;
    private JButton previous_btu;
    private JButton Login_or_Pi;
    private JTextField search_tf;
    private JTextArea jta_third_center;
    private JList<String> yhcs,zpfs;
    private JMenuBar jmb1Bar, jmb2Bar;
    private JMenu leibie, PI_list;
    private JMenuItem jmI1, jmI2, jmI3, jmI4, jmI5, jmI6, jmI7, jmI8, jmI9, jmI10, jmI11, jmI12, details, login_out,collection;
    private JScrollPane JSP_Flowers_H, JSP_Flowers_Push, JSP_Flowers, JSP_second_2, JSP_Flowers_collect, jsp_third_center;
    private int num_H = 24, num_Push = 11, num_Flowers = 0, num_Flowers_gs = 4, yiye_flower = 30, flower_count = 0, ye_count = 0, num_collect = 0;
    public boolean num_second = false;
    public String flower_name = "", flowers_image = "";
    public String[] zpfs_title = new String[90] , yhcs_title = new String[90];
    public String name = "登录";//用户名
    public WeAbout about = null;
    public FlowersInfo flowersInfo = null;
    private Dimension size_1 = new Dimension(897, 600);
    MainFrame This = this;

    public MainFrame(){}
    public void setLogin(String nickname){
        PI_list.setText(nickname);
    }
    public MainFrame(String s){
        setTitle("中国花卉大全-"+s+"端");
        setIconImage(icon_1.getImage());//设置图标
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭当前窗口
        setSize(1100, 750);
        setResizable(false);//不可缩放
        //setUndecorated(true);//去掉窗口边框
        setLocationRelativeTo(null);//中心
        setLayout(new BorderLayout());
        name = s;
        flowers_count();
        //窗口大小变化时，调整大小
        // addComponentListener(new ComponentAdapter() {
        //     @Override
        //     public void componentResized(ComponentEvent e) {
        //         super.componentResized(e);
        //         int width = getWidth();
        //         int height = getHeight();
        //         size_1 = new Dimension(width - 200, height - 150);
        //         jp_first.setPreferredSize(size_1);//设置首页大小
        //         jp_second.setPreferredSize(size_1);//设置第二页大小
        //         jpall_second.setPreferredSize(size_1);//设置第二页大小
        //         jp_first.revalidate();
        //         jp_second.revalidate();
        //         jpall_second.revalidate();//重新绘制
        //     }
        // });
        //窗口最小不超过1000*700
        // addComponentListener(new ComponentAdapter() {
        //     @Override
        //     public void componentResized(ComponentEvent e) {
        //         super.componentResized(e);
        //         int width = getWidth();
        //         int height = getHeight();
        //         if (width < 1000) {
        //             setSize(1000, height);
        //         }
        //         if (height < 700) {
        //             setSize(width, 700);
        //         }
        //     }
        // });
        menuBar();//菜单栏
        winUI();//界面
    }

    public void winUI(){
        //创建主面板
        jpwest = new JPanel();
        jpwest.setLayout(new GridLayout(13, 1,0,21));
        jpwest.setBackground(new Color(176,196,222));


        jl = new JLabel("中国花卉大全", JLabel.CENTER);
        jl.setFont(new Font("宋体", Font.BOLD, 30));
        jl.setForeground(Color.white);//设置字体颜色

        jlline1 = new JLabel("————————————", JLabel.CENTER);
        jlline2 = new JLabel("————————————", JLabel.CENTER);

        jpwest.add(jl);

        if(dlcg == true){
            PI();
        }else{
            login_button();
        }

        jpwest.add(jlline1);

        jb_first = new JButton("首页");
        jb_first.setFont(new Font("宋体", Font.BOLD, 20));
        //设置鼠标移动
        jb_first.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if(jb_first.isEnabled()){
                    jb_first.setOpaque(true);
                    jb_first.setBackground(new Color(72,209,204));
                }
            }//鼠标进入
            public void mouseExited(MouseEvent e) {
                jb_first.setOpaque(false);
            }//鼠标移出
        });


        jb_first.setForeground(Color.black);
        //透明
        //jb_first.setOpaque(false);//设置按钮透明
        jb_first.setContentAreaFilled(false);//设置按钮内部透明
        jb_first.setBorderPainted(false);//不显示边框
        jb_first.setFocusPainted(false);
        jb_first.addActionListener(this);
        
        jb_first.setEnabled(false);
        //不透明
        jb_first.setOpaque(true);
        jb_first.setBackground(new Color(100,149,237));
        
        jpwest.add(jb_first);

        jb_second = new JButton("花卉");
        jb_second.setFont(new Font("宋体", Font.BOLD, 20));
        //设置鼠标移动
        jb_second.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if(jb_second.isEnabled()){
                    jb_second.setOpaque(true);
                    jb_second.setBackground(new Color(72,209,204));
                }
            }//鼠标进入
            public void mouseExited(MouseEvent e) {
                jb_second.setOpaque(false);
            }//鼠标移出
        });

        jb_second.setForeground(Color.black);
        //透明
        jb_second.setOpaque(false);
        jb_second.setContentAreaFilled(false);
        jb_second.setBorderPainted(false);//不显示边框
        jb_second.setFocusPainted(false);
        jb_second.addActionListener(this);
        jpwest.add(jb_second);

        jb_third = new JButton("推送");
        jb_third.setFont(new Font("宋体", Font.BOLD, 20));
        //设置鼠标移动
        jb_third.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if(jb_third.isEnabled()){
                    jb_third.setOpaque(true);
                    jb_third.setBackground(new Color(72,209,204));
                }
            }//鼠标进入
            public void mouseExited(MouseEvent e) {
                jb_third.setOpaque(false);
            }//鼠标移出
        });

        jb_third.setForeground(Color.black);
        //透明
        jb_third.setOpaque(false);
        jb_third.setContentAreaFilled(false);
        jb_third.setBorderPainted(false);//不显示边框
        jb_third.setFocusPainted(false);
        jb_third.addActionListener(this);
        jpwest.add(jb_third);

        jb_fourth = new JButton("答疑");
        jb_fourth.setFont(new Font("宋体", Font.BOLD, 20));
        //设置鼠标移动
        jb_fourth.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if(jb_fourth.isEnabled()){
                    jb_fourth.setOpaque(true);
                    jb_fourth.setBackground(new Color(72,209,204));
                }
            }//鼠标进入
            public void mouseExited(MouseEvent e) {
                jb_fourth.setOpaque(false);
            }//鼠标移出
        });
        jb_fourth.setForeground(Color.black);
        //透明
        jb_fourth.setOpaque(false);
        jb_fourth.setContentAreaFilled(false);
        jb_fourth.setBorderPainted(false);//不显示边框
        jb_fourth.setFocusPainted(false);
        jb_fourth.addActionListener(this);
        jpwest.add(jb_fourth);
        jpwest.add(jlline2);

        exit = new JButton("退出");
        exit.setFont(new Font("宋体", Font.BOLD, 20));
        //设置鼠标移动
        exit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if(exit.isEnabled()){
                    exit.setOpaque(true);
                    exit.setBackground(new Color(72,209,204));
                }
                // exit.setOpaque(true);
                // exit.setBackground(Color.gray);
            }//鼠标进入
            public void mouseExited(MouseEvent e) {
                exit.setOpaque(false);
            }//鼠标移出
        });
        exit.setForeground(Color.black);
        //透明
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);//不显示边框
        exit.setFocusPainted(false);
        exit.addActionListener(this);//添加退出按钮

        jpwest.add(exit);


        //创建主面板
        jp_east = new JPanel(cl);

        //创建首页面板
        jp_first = new JPanel();
        // 设置面板背景色
        jp_first.setBackground(new Color(0,206,209));
        jp_first.setPreferredSize(size_1); //设置大小
        jp_firstUI();//首页

        //创建花卉面板
        jp_second = new JPanel();
        // 设置面板背景色
        jp_second.setBackground(new Color(143,188,143));
        jp_second.setPreferredSize(size_1); //设置大小
        jp_secondUI();//花卉

        //创建推送面板
        jp_third = new JPanel();
        // 设置面板背景色
        jp_third.setBackground(new Color(72,209,204));
        jp_third.setPreferredSize(size_1); //设置大小
        jp_thirdUI();//推送

        //创建答疑面板
        jp_fourth = new JPanel();
        // 设置面板背景色
        jp_fourth.setBackground(new Color(211,211,211));
        jp_fourth.setPreferredSize(size_1); //设置大小
        jp_fourthUI();//答疑

        //创建收藏面板
        collect_jp = new JPanel();
        // 设置面板背景色
        collect_jp.setBackground(new Color(188,143,143));
        collect_jp.setPreferredSize(size_1); //设置大小
        collect_jpUI();//收藏

        

        jp_east.add(jp_first, "first");
        jp_east.add(jp_second, "second");
        jp_east.add(jp_third, "third");
        jp_east.add(jp_fourth, "fourth");
        jp_east.add(collect_jp, "collect");
        

        add(jpwest, BorderLayout.WEST);
        add(jp_east, BorderLayout.EAST);
    }
    private void collect_jpUI() {
        collect_jp.setLayout(new BorderLayout());
        jp_collect_top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp_collect_top.setOpaque(false);
        jb_collect_back = new JButton("<- 返回到首页");
        jb_collect_back.setFont(new Font("宋体", Font.BOLD, 14));
        jb_collect_back.setForeground(Color.black);
        jb_collect_back.setOpaque(false);
        jb_collect_back.setContentAreaFilled(false);//不显示边框
        jb_collect_back.setBorderPainted(false);//不显示边框
        jb_collect_back.setFocusPainted(false);//不显示焦点
        jb_collect_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jb_first.setEnabled(false);
                jb_second.setEnabled(true);
                jb_third.setEnabled(true);
                jb_fourth.setEnabled(true);
                jb_second.setOpaque(false);
                jb_third.setOpaque(false);
                jb_fourth.setOpaque(false);
                jb_first.setOpaque(true);//设置为不透明
                jb_first.setBackground(new Color(100,149,237));

                cl.show(jp_east,"first");//显示第一个面板
            }
        });
        jb_collect_back.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                jb_collect_back.setForeground(Color.blue);
            }//鼠标进入
            public void mouseExited(MouseEvent e) {
                jb_collect_back.setForeground(Color.black);
            }//鼠标移出
        });

        collect_T = new JLabel("                     收藏夹");
        collect_T.setFont(new Font("宋体", Font.BOLD, 25));
        collect_T.setForeground(Color.black);

        jp_collect_top.add(jb_collect_back);
        jp_collect_top.add(collect_T);

        jp_collect_center = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp_collect_center.setOpaque(false);//设置为透明

        JSP_Flowers_collect = new JScrollPane(jp_collect_center);//滚动面板
        JSP_Flowers_collect.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//设置滚动条
        JSP_Flowers_collect.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//设置滚动条
        JSP_Flowers_collect.setOpaque(false);//设置透明
        JSP_Flowers_collect.getViewport().setOpaque(false);//设置透明
        JSP_Flowers_collect.setBorder(null);//设置边框
        JSP_Flowers_collect.setViewportBorder(null);//设置边框
        JSP_Flowers_collect.getVerticalScrollBar().setUnitIncrement(20);

        collect_jp.add(jp_collect_top, BorderLayout.NORTH);
        collect_jp.add(JSP_Flowers_collect, BorderLayout.CENTER);
    }
    public void getcollect() {
        num_collect_();//收藏数量
        try {
            this.jp_collect_center.removeAll();
            jp_collect_center.setPreferredSize(new Dimension(700, num_collect%5 == 0 ? (num_collect/5)*150 : ((num_collect/5)+1)*150)); //设置大小
            num_second = false;//设置为false
            PreparedStatement pstmt = conn.prepareStatement("select f.FlowersImage,f.FlowersName from collect c,flowersinfo f where c.UserID =  '"+user_model.getUserID()+"' and c.FlowersID = f.FlowersID");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                num_second = true;
                flowers_image = rs.getString("FlowersImage");//获取名称
                flower_name = rs.getString("FlowersName");//获取名称
                //获取图片和文字
                jp_collect_center.add(getImageandTxt(flowers_image, flower_name));//添加到面板
            }
            if(!num_second) {
                JLabel jl_collect_null = new JLabel("您还没有收藏任何花卉！");
                jl_collect_null.setFont(new Font("宋体", Font.BOLD, 20));
                jl_collect_null.setForeground(Color.red);
                jp_collect_center.add(jl_collect_null);
            }
            pstmt.close();
            rs.close();
            jp_collect_center.updateUI();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void jp_fourthUI() {
        //聊天界面
        jp_fourth.setLayout(new BorderLayout());
        JLabel jl_fourth_top = new JLabel("聊天机器人",JLabel.CENTER);
        jl_fourth_top.setFont(new Font("宋体", Font.BOLD, 25));

        JTextArea jta_fourth_center = new JTextArea();
        jta_fourth_center.setFont(new Font("宋体", Font.BOLD, 20));
        jta_fourth_center.setLineWrap(true);//自动换行
        jta_fourth_center.setWrapStyleWord(true);//激活断行不断字
        jta_fourth_center.setOpaque(false);//设置透明
        jta_fourth_center.setBorder(null);//设置边框

        JScrollPane jsp_fourth_center = new JScrollPane(jta_fourth_center);//滚动面板
        jsp_fourth_center.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//设置滚动条
        jsp_fourth_center.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//设置滚动条
        jsp_fourth_center.setOpaque(false);//设置透明
        jsp_fourth_center.getViewport().setOpaque(false);//设置透明
        // jsp_fourth_center.setBorder(null);//设置边框
        jsp_fourth_center.setViewportBorder(null);//设置边框
        // jsp_fourth_center.getVerticalScrollBar().setUnitIncrement(20);

        JPanel jp_fourth_bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp_fourth_bottom.setOpaque(false);

        JButton jb_fourth_claer = new JButton("清空");
        jb_fourth_claer.setFont(new Font("宋体", Font.BOLD, 15));
        jb_fourth_claer.setBackground(Color.white);
        jb_fourth_claer.setForeground(Color.black);
        jb_fourth_claer.setFocusPainted(false);//设置按钮无边框
        //鼠标移入
        jb_fourth_claer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jb_fourth_claer.setBackground(Color.gray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                jb_fourth_claer.setBackground(Color.white);
            }
        });
        //鼠标点击
        jb_fourth_claer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta_fourth_center.setText("");
            }
        });
 
        JTextField jtf_fourth_bottom = new JTextField();
        jtf_fourth_bottom.setFont(new Font("宋体", Font.BOLD, 20));//设置字体
        jtf_fourth_bottom.setPreferredSize(new Dimension(700, 30));//设置大小
        // jtf_fourth_bottom.setOpaque(false);//设置透明
        // jtf_fourth_bottom.setBorder(null);//设置边框
        jtf_fourth_bottom.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String str = jtf_fourth_bottom.getText();
                    if(str.equals("")) {
                        JOptionPane.showMessageDialog(null, "请输入内容！");
                    } else {
                        jta_fourth_center.setText(setTextforjtf(jtf_fourth_bottom, jta_fourth_center));
                        jta_fourth_center.setText(getTextforsql(jtf_fourth_bottom, jta_fourth_center));
                        jtf_fourth_bottom.setText("");
                    }
                }
            }
        });

        JButton jb_fourth_send = new JButton("发送");
        jb_fourth_send.setFont(new Font("宋体", Font.BOLD, 20));
        jb_fourth_send.setBackground(Color.white);
        jb_fourth_send.setForeground(Color.black);
        jb_fourth_send.setFocusPainted(false);//设置按钮无边框

        //鼠标移入
        jb_fourth_send.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jb_fourth_send.setBackground(Color.gray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                jb_fourth_send.setBackground(Color.white);
            }
        });
        jb_fourth_send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jtf_fourth_bottom.getText();
                if(str.equals("")) {
                    JOptionPane.showMessageDialog(null, "请输入内容！");
                } else {
                    jta_fourth_center.setText(setTextforjtf(jtf_fourth_bottom, jta_fourth_center));
                    jta_fourth_center.setText(getTextforsql(jtf_fourth_bottom, jta_fourth_center));
                    jtf_fourth_bottom.setText("");
                }
            }

        });

        jp_fourth_bottom.add(jb_fourth_claer);
        jp_fourth_bottom.add(jtf_fourth_bottom);
        jp_fourth_bottom.add(jb_fourth_send);

        jp_fourth.add(jl_fourth_top, BorderLayout.NORTH);
        jp_fourth.add(jsp_fourth_center, BorderLayout.CENTER);
        jp_fourth.add(jp_fourth_bottom, BorderLayout.SOUTH);
    }
    protected String getTextforsql(JTextField jtf_fourth_bottom, JTextArea jta_fourth_center) {
        String str = jtf_fourth_bottom.getText();
        try { 
            //or Query like '%"+str+"%'
            String sql = "select Answer from robot where Query = '"+str+"'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
             rs = pstmt.executeQuery();
            if(rs.next()) {
                str = rs.getString("Answer");
            } else {
                PreparedStatement pstmt_ = conn.prepareStatement("select Answer from robot where Query like '%"+str+"%'");//模糊查询
                ResultSet rs_ = pstmt_.executeQuery();
                if(rs_.next()) {
                    str = rs_.getString("Answer");
                } else {
                    str = "抱歉，听不懂您说的话！";
                }
                pstmt_.close();
                rs_.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String str1 = jta_fourth_center.getText(); 
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String time = sd.format(new java.util.Date());
        String text = str1+"["+time+"]"+"机器人："+str+"\n\n";
        return text;
    }
    protected String setTextforjtf(JTextField jtf_fourth_bottom, JTextArea jta_fourth_center) {
        String str = jtf_fourth_bottom.getText();
        String str1 = jta_fourth_center.getText();  //获取文本框内容
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String time = sd.format(new java.util.Date());
        String text = str1+"["+time+"]"+user_model.getNickName()+"："+str+"\n";
        return text;
    }
    private void jp_thirdUI() {
        jp_third.setLayout(new BorderLayout());

        JPanel jp_third_top = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jp_third_top.setOpaque(false);

        //单选按钮
        JRadioButton jrb_third_one = new JRadioButton("栽培方式");
        jrb_third_one.setOpaque(false);

        JRadioButton jrb_third_two = new JRadioButton("养花常识");
        jrb_third_two.setOpaque(false);

        jrb_third_one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jrb_third_one.isSelected()) {
                    jrb_third_two.setSelected(false);
                }else {
                    jrb_third_one.setSelected(true);
                }
            }
        });

        jrb_third_two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jrb_third_two.isSelected()) {
                    jrb_third_one.setSelected(false);
                }else {
                    jrb_third_two.setSelected(true);
                }
            }
        });

        JTextField jtf_third_top = new JTextField(20);

        JButton jb_third_top = new JButton("搜索");
        jb_third_top.setOpaque(false);//设置透明
        jb_third_top.setFocusPainted(false);//设置按钮无边框


        jp_third_top.add(jrb_third_one);
        jp_third_top.add(jrb_third_two);
        jp_third_top.add(jtf_third_top);
        jp_third_top.add(jb_third_top);

        jta_third_center = new JTextArea();
        jta_third_center.setFont(new Font("宋体", Font.BOLD, 20));//设置字体
        jta_third_center.setLineWrap(true);//设置自动换行
        jta_third_center.setWrapStyleWord(true);//设置文本在换行时是否显示换行符
        jta_third_center.setEditable(false);//设置文本是否可编辑
        jta_third_center.setOpaque(false);//设置透明

        jsp_third_center = new JScrollPane(jta_third_center);
        jsp_third_center.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//设置滚动条
        jsp_third_center.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//设置滚动条
        jsp_third_center.setOpaque(false);//设置透明
        jsp_third_center.getViewport().setOpaque(false);//设置透明
        // jsp_third_center.setBorder(null);//设置边框
        jsp_third_center.setViewportBorder(null);//设置边框
        jsp_third_center.getVerticalScrollBar().setUnitIncrement(20);//设置滚动条滚动速度

        JPanel jp_third_left = new JPanel(new GridLayout(2, 1, 0, 10));
        jp_third_left.setOpaque(false);

        yhcs = new JList<String>();
        yhcs.setListData(getList_yhcs());
        yhcs.setBackground(new Color(72,209,204));
        //点击
        yhcs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标点击事件
                int index = yhcs.getSelectedIndex();//获取选中的索引
                String str = yhcs.getModel().getElementAt(index);//获取选中的内容
                jta_third_center.setText(setText_sql_yhcs(str));
            }
        });


        JScrollPane jsp_third_yhcs = new JScrollPane(yhcs);
        jsp_third_yhcs.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//设置滚动条
        jsp_third_yhcs.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//设置滚动条
        jsp_third_yhcs.setOpaque(false);//设置透明
        jsp_third_yhcs.getViewport().setOpaque(false);//设置透明   
        // jsp_third_yhcs.setBorder(null);//设置边框
        jsp_third_yhcs.setViewportBorder(null);//设置边框
        // jsp_third_yhcs.getVerticalScrollBar().setUnitIncrement(20);

        zpfs = new JList<String>();
        zpfs.setListData(getList_zpfs());
        zpfs.setBackground(new Color(72,209,204));
        zpfs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标点击事件
                int index = zpfs.getSelectedIndex();//获取选中的索引
                String str = zpfs.getModel().getElementAt(index);//获取选中的内容
                jta_third_center.setText(setText_sql_zpfs(str));
            }
        });

        JScrollPane jsp_third_zpfs = new JScrollPane(zpfs);
        jsp_third_zpfs.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//设置滚动条
        jsp_third_zpfs.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//设置滚动条
        jsp_third_zpfs.setOpaque(false);//设置透明
        jsp_third_zpfs.getViewport().setOpaque(false);//设置透明   
        // jsp_third_zpfs.setBorder(null);//设置边框
        jsp_third_zpfs.setViewportBorder(null);//设置边框
        // jsp_third_zpfs.getVerticalScrollBar().setUnitIncrement(20);

        jb_third_top.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jtf_third_top.getText();
                if(str.equals("")) {
                    JOptionPane.showMessageDialog(null, "请输入内容！");
                } else {
                    if(jrb_third_one.isSelected()) {
                        jta_third_center.setText(setText_sql_yhcs(str));
                    } else if(jrb_third_two.isSelected()) {
                        jta_third_center.setText(setText_sql_zpfs(str));
                    }
                    jtf_third_top.setText("");
                }
            }
        });

        jp_third_left.add(jsp_third_yhcs);
        jp_third_left.add(jsp_third_zpfs);

        jp_third.add(jp_third_top, BorderLayout.NORTH);
        jp_third.add(jsp_third_center, BorderLayout.CENTER);
        jp_third.add(jp_third_left, BorderLayout.WEST);
    }
    protected String setText_sql_zpfs(String str) {
        String text = "";
        try{
            String sql = "select * from cultivation where CultivationTitle like '%"+str+"%'";
            PreparedStatement pstmt = conn.prepareStatement(sql);//预编译sql语句
            ResultSet rs = pstmt.executeQuery();//执行sql语句
            if(rs.next()){
                text = "                "+rs.getString("CultivationTitle")+"\n              "+rs.getTimestamp("Ctime") +"\n  "+rs.getString("CultivationContent");
            }
            pstmt.close();
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return text;
    }
    protected String setText_sql_yhcs(String str) {
        String text = "";
        try{
            String sql = "select * from flowerscs where FlowersCSTitle like '%"+str+"%'";
            PreparedStatement pstmt = conn.prepareStatement(sql);//预编译sql语句
            ResultSet rs = pstmt.executeQuery();//执行sql语句
            if(rs.next()){
                text = "                "+rs.getString("FlowersCSTitle")+"\n              "+rs.getTimestamp("Ftime") +"\n  "+rs.getString("FlowersCSContent");
            }
            pstmt.close();
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return text;
    }
    private String[] getList_zpfs() {
        String[] str = new String[999];
        try {
            String sql = "select CultivationTitle from cultivation";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int i = 0;
            while(rs.next()) {
                if(i >= 999) {
                    break;
                }
                str[i] = rs.getString("CultivationTitle");
                i++;
            }
            str = Arrays.copyOf(str, i);//把FBContent的长度设置为i
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }
    private String[] getList_yhcs() {
        String[] str = new String[999];
        try {
            String sql = "select FlowersCSTitle from flowerscs";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int i = 0;
            while(rs.next()) {
                if(i >= 999) {
                    break;
                }
                str[i] = rs.getString("FlowersCSTitle");
                i++;
            }
            str = Arrays.copyOf(str, i);//把FBContent的长度设置为i
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }
    private void jp_secondUI() {
        jp_second.setLayout(new BorderLayout());

        JSP_Flowers = new JScrollPane();//滚动面板
        JSP_Flowers.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//设置滚动条
        JSP_Flowers.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//设置滚动条
        //JSP_Flowers.setPreferredSize(size_1); //设置大小
        
        jpall_second = new JPanel(new FlowLayout(FlowLayout.CENTER));//面板
        jpall_second.setPreferredSize(new Dimension(600,(yiye_flower/5)*150)); //设置大小
        //透明
        jpall_second.setOpaque(false);

        jpall_second_top = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //透明
        jpall_second_top.setOpaque(false);

        search_btu = new JButton("搜索");
        search_btu.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                search_btu.setForeground(Color.blue);
            }//鼠标进入
            public void mouseExited(MouseEvent e) {
                search_btu.setForeground(Color.black);
            }//鼠标移出
        });
        //透明
        search_btu.setOpaque(false);
        search_btu.setContentAreaFilled(false);
        //search_btu.setBorderPainted(false);//不显示边框
        search_btu.addActionListener(this);

        search_tf = new JTextField(20);
        search_tf.addFocusListener(new JTextFieldHintListener(search_tf, "请输入搜索内容"));
        
        jmb1Bar = new JMenuBar();
        jmb1Bar.setOpaque(false);
        leibie = new JMenu();
        leibie.setText("类别 >>");
        // leibie.setFont(new Font("宋体", Font.BOLD, 20));
        //leibie.setForeground(Color.black);
        // //透明
        leibie.setOpaque(false);
        leibie.setContentAreaFilled(false);
        leibie.setBorderPainted(false);//不显示边框
        jmI1 = new JMenuItem("趣味类 >");
        jmI1.addActionListener(this);
        jmI2 = new JMenuItem("芳香类 >");
        jmI2.addActionListener(this);
        jmI3 = new JMenuItem("观果类 >");
        jmI3.addActionListener(this);
        jmI4 = new JMenuItem("观花类 >");
        jmI4.addActionListener(this);
        jmI5 = new JMenuItem("观叶类 >");
        jmI5.addActionListener(this);
        jmI6 = new JMenuItem("观茎类 >");
        jmI6.addActionListener(this);
        jmI7 = new JMenuItem("节庆类 >");
        jmI7.addActionListener(this);
        jmI8 = new JMenuItem("垂吊类 >");
        jmI8.addActionListener(this);
        jmI9 = new JMenuItem("果蔬类 >");
        jmI9.addActionListener(this);
        jmI10 = new JMenuItem("水培类 >");
        jmI10.addActionListener(this);
        jmI11 = new JMenuItem("盆栽类 >");
        jmI11.addActionListener(this);
        jmI12 = new JMenuItem("地被草坪 >");
        jmI12.addActionListener(this);

        leibie.add(jmI1);
        leibie.add(jmI2);
        leibie.add(jmI3);
        leibie.add(jmI4);
        leibie.add(jmI5);
        leibie.add(jmI6);
        leibie.add(jmI7);
        leibie.add(jmI8);
        leibie.add(jmI9);
        leibie.add(jmI10);
        leibie.add(jmI11);
        leibie.add(jmI12);

        jmb1Bar.add(leibie);

        jpall_second_button = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //透明
        jpall_second_button.setOpaque(false);

        next_btu = new JButton("下一页");
        //设置颜色
        next_btu.setBackground(new Color(144,238,144));
        next_btu.setFocusPainted(false);//透明
        next_btu.addActionListener(this);

        if(flower_count%yiye_flower == 0){
            ye_count = flower_count/yiye_flower;
        }else{
            ye_count = flower_count/yiye_flower + 1;
        }
        yeshu = new JLabel("第1页/共"+ye_count+"页");
        //透明
        yeshu.setOpaque(false);

        previous_btu = new JButton("上一页");
        //设置颜色
        previous_btu.setBackground(new Color(144,238,144));
        previous_btu.setFocusPainted(false);//透明
        previous_btu.addActionListener(this);

        ts = new JLabel();
        //透明
        ts.setOpaque(false);
        ts.setFont(new Font("宋体", Font.BOLD, 20));


        jpall_second_button.add(previous_btu);
        jpall_second_button.add(yeshu);
        jpall_second_button.add(next_btu);

        jpall_second_top.add(ts);
        jpall_second_top.add(jmb1Bar);
        jpall_second_top.add(search_tf);
        jpall_second_top.add(search_btu);

        connection(false,0,yiye_flower,1);

        JSP_Flowers.setViewportView(jpall_second);
        //透明
        JSP_Flowers.setOpaque(false);
        JSP_Flowers.getViewport().setOpaque(false);
        JSP_Flowers.getVerticalScrollBar().setUnitIncrement(20);

        jpall_second_1 = new JPanel(new BorderLayout());
        //透明
        jpall_second_1.setOpaque(false);


        jpall_second_1.add(JSP_Flowers, BorderLayout.CENTER);
        jpall_second_1.add(jpall_second_button, BorderLayout.SOUTH);

        jpall_second_1_all = new JPanel(cl);
        //透明
        jpall_second_1_all.setOpaque(false);

        jpall_second_1_all.add(jpall_second_1, "jpall_second_1");

        jpall_second_2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpall_second_2.setPreferredSize(new Dimension(600, 0));
        //透明
        jpall_second_2.setOpaque(false);

        JSP_second_2 = new JScrollPane(jpall_second_2);
        //透明
        JSP_second_2.setOpaque(false);
        JSP_second_2.getViewport().setOpaque(false);
        JSP_second_2.getVerticalScrollBar().setUnitIncrement(20);
        JSP_second_2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JSP_second_2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        jb_second_ = new JButton("返回");
        //设置字体
        jb_second_.setFont(new Font("宋体", Font.BOLD, 20));
        //透明
        jb_second_.setOpaque(false);
        jb_second_.setContentAreaFilled(false);//不绘制内容区域
        jb_second_.setBorderPainted(false);//不显示边框
        jb_second_.addActionListener(this);
        //鼠标移入移出
        jb_second_.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jb_second_.setForeground(Color.blue);
            }//鼠标移入
            @Override
            public void mouseExited(MouseEvent e) {
                jb_second_.setForeground(Color.black);
            }
        });
        jpall_second_1_all.add(JSP_second_2, "jpall_second_2");

        jp_second.add(jpall_second_top, BorderLayout.NORTH);
        jp_second.add(jpall_second_1_all, BorderLayout.CENTER);

    }
    private void jp_firstUI() {
        jp_first.setLayout(new BorderLayout());

        jpall_first = new JPanel(new BorderLayout());
        jpall_first.setOpaque(false);//透明


        jpall_first_1 = new JPanel(new BorderLayout());
        jpall_first_1.setOpaque(false);//透明


        JSP_Flowers_Push = new JScrollPane();
        JSP_Flowers_Push.setOpaque(false);
        JSP_Flowers_Push.getViewport().setOpaque(false);
        JSP_Flowers_Push.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        JSP_Flowers_Push.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        jpin_Flowers_H = new JPanel();
        //透明
        jpin_Flowers_H.setOpaque(false);

        JSP_Flowers_H = new JScrollPane();
        JSP_Flowers_H.setOpaque(false);
        JSP_Flowers_H.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        JSP_Flowers_H.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        jpin_Flowers_H.setLayout(new GridLayout(1, num_H+1,0,0));

        connection(true,0,10,-1);//连接数据库
        JButton jb_more = new JButton("更多");
        jb_more.setFont(new Font("宋体", Font.BOLD, 20));
        jb_more.setForeground(Color.blue);
        jb_more.setContentAreaFilled(false);
        jb_more.setBorderPainted(false);//不显示边框

        jb_more.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jb_second.setEnabled(false);
                //其他的按钮可用
                jb_first.setEnabled(true);
                jb_third.setEnabled(true);
                jb_fourth.setEnabled(true);
                jb_first.setOpaque(false);
                jb_third.setOpaque(false);
                jb_fourth.setOpaque(false);
                //设置背景色
                jb_second.setOpaque(true);
                jb_second.setBackground(new Color(100,149,237));

                cl.show(jp_east,"second");//显示第二个面板
            }
        });
        jpin_Flowers_H.add(jb_more);
        JSP_Flowers_H.setPreferredSize(new Dimension(924,167)); //设置大小
        //设置滚动条透明
        JSP_Flowers_H.getViewport().setOpaque(false);
        JSP_Flowers_H.setViewportView(jpin_Flowers_H);
        JSP_Flowers_H.getHorizontalScrollBar().setUnitIncrement(20);

        JLabel jl_Flowers_H = new JLabel("百花齐放");
        jl_Flowers_H.setFont(new Font("宋体", Font.BOLD, 20));
        jl_Flowers_H.setForeground(Color.BLUE);
        jl_Flowers_H.setOpaque(false);

        jpall_first_1.add(jl_Flowers_H,BorderLayout.NORTH);
        jpall_first_1.add(JSP_Flowers_H,BorderLayout.CENTER);
        
        jpall_first_list = new JPanel(new GridLayout(2,1,10,0));
        jpall_first_list.setOpaque(false);//透明

        jpall_first_2 = new JPanel(new BorderLayout());
        jpall_first_2.setOpaque(false);//透明

        
        JButton jb_Flowers_ye = new JButton("观叶类·枝繁叶茂 共"+getleibienum(5)+"个花>");
        jb_Flowers_ye.setFont(new Font("宋体", Font.BOLD, 20));
        jb_Flowers_ye.setForeground(Color.blue);
        jb_Flowers_ye.setContentAreaFilled(false);
        jb_Flowers_ye.setBorderPainted(false);//不显示边框
        jb_Flowers_ye.setFocusPainted(false);//不显示焦点边框
        jb_Flowers_ye.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jb_second.setEnabled(false);
                //其他的按钮可用
                jb_first.setEnabled(true);
                jb_third.setEnabled(true);
                jb_fourth.setEnabled(true);
                jb_first.setOpaque(false);
                jb_third.setOpaque(false);
                jb_fourth.setOpaque(false);
                //设置背景色
                jb_second.setOpaque(true);
                jb_second.setBackground(new Color(100,149,237));

                cl.show(jp_east,"second");//显示第二个面板
                getleibie("5", 1);
            }
        });

        jp_Flowers_ye = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp_Flowers_ye.setOpaque(false);//透明
        jp_Flowers_ye.setPreferredSize(new Dimension(0,300));
        getleibie("5",2);

        jpall_first_2.add(jb_Flowers_ye,BorderLayout.NORTH);
        jpall_first_2.add(jp_Flowers_ye,BorderLayout.CENTER);


        jpall_first_3 = new JPanel(new BorderLayout());
        jpall_first_3.setOpaque(false);//透明

        JButton jb_Flowers_fan = new JButton("芳香类·芳香四溢 共"+getleibienum(2)+"个花>");
        jb_Flowers_fan.setFont(new Font("宋体", Font.BOLD, 20));
        jb_Flowers_fan.setForeground(Color.blue);
        jb_Flowers_fan.setContentAreaFilled(false);
        jb_Flowers_fan.setBorderPainted(false);//不显示边框
        jb_Flowers_fan.setFocusPainted(false);//不显示焦点边框
        jb_Flowers_fan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jb_second.setEnabled(false);
                //其他的按钮可用
                jb_first.setEnabled(true);
                jb_third.setEnabled(true);
                jb_fourth.setEnabled(true);
                jb_first.setOpaque(false);
                jb_third.setOpaque(false);
                jb_fourth.setOpaque(false);
                //设置背景色
                jb_second.setOpaque(true);
                jb_second.setBackground(new Color(100,149,237));

                cl.show(jp_east,"second");//显示第二个面板
                getleibie("2", 1);
            }
        });

        jp_Flowers_fan = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jp_Flowers_fan.setOpaque(false);//透明
        jp_Flowers_fan.setPreferredSize(new Dimension(0,300));
        getleibie("2",3);

        jpall_first_3.add(jb_Flowers_fan,BorderLayout.NORTH);
        jpall_first_3.add(jp_Flowers_fan,BorderLayout.CENTER);

        jpall_first_list.add(jpall_first_2);
        jpall_first_list.add(jpall_first_3);


        jp_Push = new JPanel(new BorderLayout());
        //透明
        jp_Push.setOpaque(false);

        jp_Push_in = new JPanel(new GridLayout(num_Push,2,0,0));
        jp_Push_in.setOpaque(false);

        JButton cs = new JButton("养花常识 >");
        cs.setFont(new Font("宋体", Font.BOLD, 20));
        cs.setForeground(Color.blue);
        cs.setOpaque(false);
        cs.setContentAreaFilled(false);
        cs.setBorderPainted(false);//不显示边框
        cs.setFocusPainted(false);//不显示焦点边框
        cs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        JButton fs = new JButton("栽培方式 >");
        fs.setFont(new Font("宋体", Font.BOLD, 20));
        fs.setForeground(Color.blue);
        fs.setOpaque(false);//透明
        fs.setContentAreaFilled(false);
        fs.setBorderPainted(false);//不显示边框
        fs.setFocusPainted(false);//不显示焦点边框
        fs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        jp_Push_in.add(cs);
        jp_Push_in.add(fs);
        getPush_1();

        JButton jb_more2 = new JButton("更多推送 >");
        jb_more2.setFont(new Font("宋体", Font.BOLD, 20));
        jb_more2.setForeground(Color.blue);
        jb_more2.setContentAreaFilled(false);
        jb_more2.setBorderPainted(false);//不显示边框

        jb_more2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jb_third.setEnabled(false);
                //其他的按钮可用且透明
                jb_first.setEnabled(true);
                jb_second.setEnabled(true);
                jb_fourth.setEnabled(true);
                jb_first.setOpaque(false);
                jb_second.setOpaque(false);
                jb_fourth.setOpaque(false);
                //设置背景色
                jb_third.setOpaque(true);
                jb_third.setBackground(new Color(100,149,237));

                cl.show(jp_east,"third");//显示第三个面板
            }
        });
        jp_Push.add(jb_more2,BorderLayout.SOUTH);
        jp_Push.add(jp_Push_in,BorderLayout.CENTER);

        jpall_first.add(jpall_first_1,BorderLayout.NORTH);
        jpall_first.add(jpall_first_list,BorderLayout.CENTER);
        jpall_first.add(jp_Push,BorderLayout.SOUTH);

        JSP_Flowers_Push.getViewport().setOpaque(false);
        JSP_Flowers_Push.setViewportView(jpall_first);
        JSP_Flowers_Push.getVerticalScrollBar().setUnitIncrement(20);

        jp_first.add(JSP_Flowers_Push,BorderLayout.CENTER);
    }
    private int getleibienum(int leibie) {
        int num = 0;
        try {
            String sql = "select count(*) from containli where TypeID = "+leibie;
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
    private void getPush_1() {
        String[] cs = new String[99];
        String[] fs = new String[99];
        int i = 0;
        try {
            PreparedStatement pstmt1 = conn.prepareStatement("select * from cultivation");
            ResultSet rs1 = pstmt1.executeQuery();
            PreparedStatement pstmt2 = conn.prepareStatement("select * from flowerscs");
            ResultSet rs2 = pstmt2.executeQuery();
            while(rs1.next()){
                fs[i] = rs1.getString("CultivationTitle");
                i++;
                if(i == num_Push-1){
                    break;
                }
            }
            i = 0;
            while(rs2.next()){
                cs[i] = rs2.getString("FlowersCSTitle");
                i++;
                if(i == num_Push-1){
                    break;
                }
            }
            i = 0;
            //随机排列fs，cs
            for(int j = 0;j < num_Push-1;j++){
                int r = (int)(Math.random()*(num_Push-1));
                String temp = fs[j];
                fs[j] = fs[r];
                fs[r] = temp;
                temp = cs[j];
                cs[j] = cs[r];
                cs[r] = temp;
            }
            while(i<num_Push-1){
                jp_Push_in.add(setPush_zpfs(fs[i]));
                jp_Push_in.add(setPush_yhcs(cs[i]));
                i++;
            }
            pstmt1.close();
            pstmt2.close();
            rs1.close();
            rs2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private JButton setPush_yhcs(String title) {
        JButton jb_cs = new JButton(title);
        //透明
        jb_cs.setOpaque(false);
        jb_cs.setFont(new Font("宋体", Font.BOLD, 15));
        jb_cs.setContentAreaFilled(false);
        jb_cs.setBorderPainted(false);//不显示边框
        jb_cs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // jb_third.setForeground(Color.blue);
                jb_third.setEnabled(false);
                //其他的按钮可用且透明
                jb_first.setEnabled(true);
                jb_second.setEnabled(true);
                jb_fourth.setEnabled(true);
                jb_first.setOpaque(false);
                jb_second.setOpaque(false);
                jb_fourth.setOpaque(false);
                //设置背景色
                jb_third.setOpaque(true);
                jb_third.setBackground(new Color(100,149,237));

                jta_third_center.setText(setText_sql_yhcs(title));
                cl.show(jp_east,"third");//显示第三个面板
            }
        });
        jb_cs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jb_cs.setForeground(Color.blue);
            }//鼠标进入
            @Override
            public void mouseExited(MouseEvent e) {
                jb_cs.setForeground(Color.black);
            }
        });
        return jb_cs;
    }
    private JButton setPush_zpfs(String title) {
        JButton jb_fs = new JButton(title);
        //透明
        jb_fs.setOpaque(false);
        jb_fs.setFont(new Font("宋体", Font.BOLD, 15));
        jb_fs.setContentAreaFilled(false);
        jb_fs.setBorderPainted(false);//不显示边框
        jb_fs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // jb_third.setForeground(Color.blue);
                jb_third.setEnabled(false);
                //其他的按钮可用且透明
                jb_first.setEnabled(true);
                jb_second.setEnabled(true);
                jb_fourth.setEnabled(true);
                jb_first.setOpaque(false);
                jb_second.setOpaque(false);
                jb_fourth.setOpaque(false);
                //设置背景色
                jb_third.setOpaque(true);
                jb_third.setBackground(new Color(100,149,237));

                jta_third_center.setText(setText_sql_zpfs(title));
                cl.show(jp_east,"third");//显示第三个面板
            }
        });
        jb_fs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jb_fs.setForeground(Color.blue);
            }//鼠标进入
            @Override
            public void mouseExited(MouseEvent e) {
                jb_fs.setForeground(Color.black);
            }
        });
        return jb_fs;
    }
    private void num_collect_() {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select count(1) from collect where UserID = '"+user_model.getUserID()+"'");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                num_collect = rs.getInt(1);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //定义菜单栏
    private void menuBar(){
        JMenuBar jmb = new JMenuBar();
        JMenu jm1 = new JMenu("操作    ");
        JMenu jm2 = new JMenu("帮助    ");
        JMenuItem jmi1 = new JMenuItem("刷新");
        //点击
        jmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    String sql = "select * from userinfo where UserID = '"+user_model.getUserID()+"'";
                    PreparedStatement pstmt = conn.prepareStatement(sql);//创建游标2
                    ResultSet rs = pstmt.executeQuery();//执行查询
                    if(rs.next()) {
                        user_model.setUserAccount(rs.getString("UserAccount"));
                        user_model.setUserPWD(rs.getString("UserPWD"));
                        user_model.setNickName(rs.getString("NickName"));
                        user_model.setUserPhone(rs.getString("UserPhone"));
                        user_model.setUserAge(rs.getInt("UserAge"));
                    }
                    pstmt.close();
                    rs.close();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                mainFrame1 = new MainFrame(name);
                mainFrame1.setVisible(true);
                This.dispose();
            }   
        });
        JMenuItem jmi2 = new JMenuItem("反馈");
        //点击
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(dlcg == true){
                    if(feedback != null){
                        feedback.dispose();
                    }
                    feedback = new Feedback();
                    feedback.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "请先登录！");
                }
            }
        });
        JMenuItem jmi3 = new JMenuItem("退出");
        //点击
        jmi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }   
        });
        JMenuItem jmi4 = new JMenuItem("关于");
        //点击
        jmi4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(about != null){
                    about.dispose();
                }
                about = new WeAbout();
                about.setVisible(true);
            }
        });
        jm1.add(jmi1);
        jm1.add(jmi2);
        jm1.addSeparator();
        jm1.add(jmi3);
        jm2.add(jmi4);
        jmb.add(jm1);
        jmb.add(jm2);
        setJMenuBar(jmb);
    }
    public void login_button(){
        Login_or_Pi = new JButton(name);
        Login_or_Pi.setFont(new Font("宋体", Font.BOLD, 20));
        Login_or_Pi.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                Login_or_Pi.setOpaque(true);
                Login_or_Pi.setBackground(new Color(100,149,237));
            }//鼠标进入
            public void mouseExited(MouseEvent e) {
                Login_or_Pi.setOpaque(false);
            }//鼠标移出
        });
        Login_or_Pi.setForeground(Color.red);
        //透明
        Login_or_Pi.setOpaque(false);
        Login_or_Pi.setContentAreaFilled(false);
        Login_or_Pi.setBorderPainted(false);//不显示边框
        Login_or_Pi.setFocusPainted(false);//不显示焦点边框
        Login_or_Pi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                This.setEnabled(false);
                loginch = new Loginch();
                loginch.setVisible(true);
                loginch.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        This.setEnabled(true);
                        loginch = null;
                        This.toFront();
                    }
                });
            }
        });
        jpwest.add(Login_or_Pi);//添加登录按钮
    }
    public void PI(){
        pi_icon = new JPanel();
        pi_icon.setOpaque(false);

        ImageIcon icon = new ImageIcon("src/Chinese_Flower/icon/pi.png");//获取图片
        icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

        icon_pi = new JLabel(icon);
        jmb2Bar = new JMenuBar();
        // 透明
        jmb2Bar.setOpaque(false);
        //长度  
        PI_list = new JMenu(user_model.getNickName());
        PI_list.setPreferredSize(new Dimension(141, 30));
        PI_list.setFont(new Font("宋体", Font.BOLD, 20));
        PI_list.setHorizontalAlignment(JMenu.LEFT);//设置菜单内容居左
        PI_list.setForeground(Color.blue);
        //透明
        PI_list.setOpaque(false);
        PI_list.setContentAreaFilled(false);
        PI_list.setBorderPainted(false);//不显示边框

        details = new JMenuItem("详细资料");
        details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pi != null){
                    pi.dispose();
                }
                pi = new User_PI();
                pi.setVisible(true);
            }
        });
        collection = new JMenuItem("个人收藏");
        collection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置蓝色字体
                // jb_first.setForeground(Color.blue);
                jb_first.setEnabled(true);
                jb_second.setEnabled(true);
                jb_third.setEnabled(true);
                jb_fourth.setEnabled(true);
                jb_first.setOpaque(false);
                jb_second.setOpaque(false);
                jb_third.setOpaque(false);
                jb_fourth.setOpaque(false);

                getcollect();
                cl.show(jp_east, "collect");
            }
        });
        login_out = new JMenuItem("退出登录");
        login_out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //确定是否退出
                int i = JOptionPane.showConfirmDialog(null, "确定要退出登录吗？", "提示", JOptionPane.YES_NO_OPTION);
                if(i == 0){
                    //退出登录
                    exit_login_();
                }
            }
        });

        PI_list.add(details);
        PI_list.add(collection);
        PI_list.add(login_out);
        jmb2Bar.add(PI_list);
        pi_icon.add(icon_pi);
        pi_icon.add(jmb2Bar);
        jpwest.add(pi_icon);//添加登录按钮
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
        user_model.setNULL();//清空用户信息
        This.dispose();
        pi = null;
    }
    public JPanel getImageandTxt(String name1,String name2){
        ImageIcon icon = new ImageIcon("src\\Chinese_Flower\\image\\"+name1+".jpg");//获取图片
        icon.setImage(icon.getImage().getScaledInstance(120, 110, Image.SCALE_DEFAULT));
        jbImage = new JButton(icon);
        //透明
        jbImage.setOpaque(false);//透明
        jbImage.setContentAreaFilled(false);//不显示边框
        jbImage.setBorderPainted(false);//不显示边框

        JTextField jtf = new JTextField();
        jtf.setFont(new Font("宋体", Font.BOLD, 18));
        //透明
        jtf.setOpaque(false);
        jtf.setEditable(false);//设置文本域不可编辑
        jtf.setText(name2);//设置文本域文字
        jtf.setBorder(null);//去掉边框
        jtf.setHorizontalAlignment(JTextField.CENTER);

        jbImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flowersInfo != null){
                    flowersInfo.dispose();
                }
                flowersInfo = new FlowersInfo(name1);
                flowersInfo.setVisible(true);
            }
        });
        
        jbImage.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                //jtf字体变成蓝色
                jtf.setForeground(Color.green);
            }//鼠标进入
            public void mouseExited(MouseEvent e) {
                //jtf字体变成黑色
                jtf.setForeground(Color.black);
            }//鼠标移出
        });
        JPanel jpin2_Flowers_H = new JPanel(new BorderLayout());
        //透明
        jpin2_Flowers_H.setOpaque(false);
        jpin2_Flowers_H.add(jbImage, BorderLayout.NORTH);//添加按钮
        jpin2_Flowers_H.add(jtf, BorderLayout.SOUTH);//添加文本域
        return jpin2_Flowers_H;
    }
    private void getleibie(String url, int b) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select f.FlowersImage,f.FlowersName from containli c,flowersinfo f where c.TypeID = "+url+" and c.FlowersID = f.FlowersID;");//创建游标2
            ResultSet rs = pstmt.executeQuery();//执行查询
            if(b == 1){ 
                jpall_second_2.removeAll();
                while(rs.next()){
                    flowers_image = rs.getString("FlowersImage");//获取名称
                    flower_name = rs.getString("FlowersName");//获取名称
                    jpall_second_2.add(getImageandTxt(flowers_image,flower_name));//添加图片和文本域
                }
                jpall_second_2.add(jb_second_);
                jpall_second_2.updateUI();
                cl.show(jpall_second_1_all,"jpall_second_2");//显示搜索面板
            }else if(b == 2){
                int a=0;
                String[] flowers_image_list = new String[99];
                String[] flower_name_list = new String[99];
                while(rs.next()){
                    flowers_image_list[a] = rs.getString("FlowersImage");//获取名称
                    flower_name_list[a] = rs.getString("FlowersName");//获取名称
                    a++;
                }
                //随机排列
                for(int i = 0; i < a; i++){
                    int r = (int)(Math.random()*a);
                    String temp = flowers_image_list[i];
                    flowers_image_list[i] = flowers_image_list[r];
                    flowers_image_list[r] = temp;
                    temp = flower_name_list[i];
                    flower_name_list[i] = flower_name_list[r];
                    flower_name_list[r] = temp;
                }
                for(int i = 0; i < 10; i++){
                    jp_Flowers_ye.add(getImageandTxt(flowers_image_list[i],flower_name_list[i]));//添加图片和文本域
                }
            }else{
                int a=0;
                String[] flowers_image_list = new String[99];
                String[] flower_name_list = new String[99];
                while(rs.next()){
                    flowers_image_list[a] = rs.getString("FlowersImage");//获取名称
                    flower_name_list[a] = rs.getString("FlowersName");//获取名称
                    a++;
                }
                //随机排列
                for(int i = 0; i < a; i++){
                    int r = (int)(Math.random()*a);
                    String temp = flowers_image_list[i];
                    flowers_image_list[i] = flowers_image_list[r];
                    flowers_image_list[r] = temp;
                    temp = flower_name_list[i];
                    flower_name_list[i] = flower_name_list[r];
                    flower_name_list[r] = temp;
                }
                for(int i = 0; i < 10; i++){
                    jp_Flowers_fan.add(getImageandTxt(flowers_image_list[i],flower_name_list[i]));
                }
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jmI1){
            getleibie("1",1);
            ts.setText("趣味类");
        }
        if(e.getSource() == jmI2){
            getleibie("2",1);
            ts.setText("芳香类");
        }
        if(e.getSource() == jmI3){
            getleibie("3",1);
            ts.setText("观果类");
        }
        if(e.getSource() == jmI4){
            getleibie("4",1);
            ts.setText("观花类");
        }
        if(e.getSource() == jmI5){
            getleibie("5",1);
            ts.setText("观叶类");
        }
        if(e.getSource() == jmI6){
            getleibie("6",1);
            ts.setText("观茎类");
        }
        if(e.getSource() == jmI7){
            getleibie("7",1);
            ts.setText("节庆类");
        }
        if(e.getSource() == jmI8){
            getleibie("8",1);
            ts.setText("垂吊类");
        }
        if(e.getSource() == jmI9){
            getleibie("9",1);
            ts.setText("果蔬类");
        }
        if(e.getSource() == jmI10){
            getleibie("11",1);
            ts.setText("水培类");
        }
        if(e.getSource() == jmI11){
            getleibie("12",1);
            ts.setText("盆栽类");
        }
        if(e.getSource() == jmI12){
            getleibie("10",1);
            ts.setText("地被草坪");
        }
        
        if(e.getSource() == exit){
            if(dlcg == true){
                try {
                    conn.close();//关闭连接
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            System.exit(0);
        }//退出
        //点击第一个按钮
        if(e.getSource() == jb_first){
            //设置蓝色字体
            // jb_first.setForeground(Color.blue);
            jb_first.setEnabled(false);
            //其他的按钮可用
            jb_second.setEnabled(true);
            jb_third.setEnabled(true);
            jb_fourth.setEnabled(true);
            jb_second.setOpaque(false);
            jb_third.setOpaque(false);
            jb_fourth.setOpaque(false);
            //不透明
            jb_first.setOpaque(true);//设置为不透明
            jb_first.setBackground(new Color(100,149,237));

            cl.show(jp_east,"first");//显示第一个面板
        }
        //点击第二个按钮
        if(e.getSource() == jb_second){
            //设置蓝色字体
            // jb_second.setForeground(Color.blue);
            jb_second.setEnabled(false);
            //其他的按钮可用
            jb_first.setEnabled(true);
            jb_third.setEnabled(true);
            jb_fourth.setEnabled(true);
            jb_first.setOpaque(false);
            jb_third.setOpaque(false);
            jb_fourth.setOpaque(false);
            //设置背景色
            jb_second.setOpaque(true);
            jb_second.setBackground(new Color(100,149,237));

            cl.show(jp_east,"second");//显示第二个面板
        }
        //点击第三个按钮
        if(e.getSource() == jb_third){
            //设置蓝色字体
            // jb_third.setForeground(Color.blue);
            jb_third.setEnabled(false);
            //其他的按钮可用且透明
            jb_first.setEnabled(true);
            jb_second.setEnabled(true);
            jb_fourth.setEnabled(true);
            jb_first.setOpaque(false);
            jb_second.setOpaque(false);
            jb_fourth.setOpaque(false);
            //设置背景色
            jb_third.setOpaque(true);
            jb_third.setBackground(new Color(100,149,237));

            cl.show(jp_east,"third");//显示第三个面板
        }
        //点击第四个按钮
        if(e.getSource() == jb_fourth){
            //设置蓝色字体
            // jb_fourth.setForeground(Color.blue);
            jb_fourth.setEnabled(false);
            //其他的按钮可用
            jb_first.setEnabled(true);
            jb_second.setEnabled(true);
            jb_third.setEnabled(true);
            jb_first.setOpaque(false);
            jb_second.setOpaque(false);
            jb_third.setOpaque(false);
            //设置背景色
            jb_fourth.setOpaque(true);//设置不透明
            jb_fourth.setBackground(new Color(100,149,237));

            cl.show(jp_east,"fourth");//显示第四个面板

        }
        //点击搜索按钮
        if(e.getSource() == search_btu){
            //获取搜索内容
            String search_content = search_tf.getText();
            //清空搜索内容
            search_tf.setText("");
            jpall_second_2.removeAll();
            //搜索
            search(search_content);
        }
        if(e.getSource() == next_btu){
            previous_btu.setEnabled(true);//上一页按钮可用
            jpall_second.removeAll();
            connection(false, num_Flowers, yiye_flower, 1);
            jpall_second.updateUI();//重绘
        }
        if(e.getSource() == previous_btu){
            next_btu.setEnabled(true);//下一页按钮可用
            jpall_second.removeAll();
            num_Flowers -= num_Flowers_gs;
            connection(false, num_Flowers, yiye_flower, 0);
            jpall_second.updateUI();//重绘
        }
        if(e.getSource() == jb_second_){
            cl.show(jpall_second_1_all,"jpall_second_1");//显示第一个面板
            ts.setText("");
        }
    }
    private void connection(boolean is_H, int num_Flowers_start, int num_Flowers_num, int is_next) {
        num_Flowers_gs = 0;
        try {
            if(is_next == 0){
                num_Flowers_start -= yiye_flower;
            }
            PreparedStatement pstmt = conn.prepareStatement("select * from flowersinfo limit "+num_Flowers_start+", "+num_Flowers_num);//创建游标2
            ResultSet rs = pstmt.executeQuery();//执行查询
            while(rs.next()) {
                if(is_next == 1){
                    num_Flowers++;
                }
                num_Flowers_gs++;
                flowers_image = rs.getString("FlowersImage");//获取名称
                flower_name = rs.getString("FlowersName");//获取名称
                if(is_H){
                    jpin_Flowers_H.add(getImageandTxt(flowers_image, flower_name));
                }else{
                    jpall_second.add(getImageandTxt(flowers_image, flower_name));//添加面板
                }
            }
            if((num_Flowers_gs != yiye_flower && is_H == false) || num_Flowers == flower_count){
                next_btu.setEnabled(false);
            }
            if(num_Flowers == yiye_flower){
                previous_btu.setEnabled(false);
            }if(is_H == false){
                yeshu.setText("第"+(num_Flowers%yiye_flower == 0 ? num_Flowers/yiye_flower : num_Flowers/yiye_flower+1)+"页"+"/共"+ye_count+"页");
            }
            // System.out.print(num_Flowers+"   ");
            // System.out.println(num_Flowers_gs);
            pstmt.close();
            rs.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e1){
            // 处理 Class.forName 错误
            e1.printStackTrace();
        }
    }
    private void flowers_count() {
        try {
            //获取花卉总数
            PreparedStatement pstmt = conn.prepareStatement("select count(*) from flowersinfo");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                flower_count = rs.getInt(1);
            }
            pstmt.close();
            rs.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e1){
            // 处理 Class.forName 错误
            e1.printStackTrace();
        }
    }
    private void search(String search_content) {
        if(search_content.equals("") || search_content.equals(" ") || search_content.equals("请输入搜索内容")){
            JOptionPane.showMessageDialog(null, "请输入搜索内容");
            return;
        }
        //搜索
        try {
            //获取查询结果
            PreparedStatement pstmt = conn.prepareStatement("select * from flowersinfo where FlowersName like '%"+search_content+"%'");
            ResultSet rs = pstmt.executeQuery();
            num_second = false;
            //循环获取查询结果
            while(rs.next()){
                num_second = true;
                flowers_image = rs.getString("FlowersImage");
                flower_name = rs.getString("FlowersName");
                jpall_second_2.add(getImageandTxt(flowers_image, flower_name));
            }
            //判断是否有查询结果
            if(num_second == false){
                JLabel jl_no_result = new JLabel("没有查询到“"+search_content+"”相关的花卉!");
                jl_no_result.setFont(new Font("宋体", Font.BOLD, 25));
                jl_no_result.setForeground(Color.red);
                jpall_second_2.add(jl_no_result);
            }
            jpall_second_2.add(jb_second_);
            jpall_second_2.updateUI();
            pstmt.close();
            rs.close();
            cl.show(jpall_second_1_all,"jpall_second_2");//显示搜索面板
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "搜索失败");
        }
    }
}