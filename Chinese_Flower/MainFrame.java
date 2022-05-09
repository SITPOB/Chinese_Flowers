package Chinese_Flower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MainFrame extends F_demo implements ActionListener {

    private JPanel jpwest, jpall_first, jpall_second, jpall_second_top, jpall_second_button, jpin_Flowers_H, jpin2_Flowers_H, jp_Push, jp_east, jp_first, jp_second, jp_third, jp_fourth;
    private JLabel jl, jlline1, jlline2;
    private JButton exit, jbImage, search_btu, jb_first, jb_second, jb_third, jb_fourth;
    private JButton next_btu;
    private JButton previous_btu;
    private JButton Login_or_Pi;
    private JTextField jtf, search_tf;
    private JMenuBar jmb1Bar;
    private JMenu leibie;
    private JMenuItem jmI1, jmI2, jmI3, jmI4, jmI5, jmI6, jmI7, jmI8, jmI9, jmI10, jmI11, jmI12;
    private JScrollPane JSP_Flowers_H, JSP_Flowers_Push, JSP_Flowers;

    private int num = 24;
    public String flower_name = "", flowers_image = "";
    public String name = "登录";//用户名
    private CardLayout cl = new CardLayout();
    public WeAbout about = null;
    public FlowersInfo flowersInfo = null;
    private Dimension size_1 = new Dimension(900, 600);
    MainFrame This = this;

    public MainFrame(){}
    public MainFrame(String s){
        setTitle(s);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭当前窗口
        setSize(1100, 750);
        setResizable(false);//不可缩放
        //setUndecorated(true);//去掉窗口边框
        setLocationRelativeTo(null);//中心
        setLayout(new BorderLayout());
        name = s;
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
        jpwest.setLayout(new GridLayout(14, 1,0,16));
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
                jb_first.setOpaque(true);
                jb_first.setBackground(new Color(100,149,237));
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
                jb_second.setOpaque(true);
                jb_second.setBackground(new Color(100,149,237));
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
        jb_second.addActionListener(this);
        jpwest.add(jb_second);

        jb_third = new JButton("推送");
        jb_third.setFont(new Font("宋体", Font.BOLD, 20));
        //设置鼠标移动
        jb_third.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                jb_third.setOpaque(true);
                jb_third.setBackground(new Color(100,149,237));
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
        jb_third.addActionListener(this);
        jpwest.add(jb_third);

        jb_fourth = new JButton("答疑");
        jb_fourth.setFont(new Font("宋体", Font.BOLD, 20));
        //设置鼠标移动
        jb_fourth.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                jb_fourth.setOpaque(true);
                jb_fourth.setBackground(new Color(100,149,237));
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
        jb_fourth.addActionListener(this);
        jpwest.add(jb_fourth);
        jpwest.add(jlline2);

        exit = new JButton("退出");
        exit.setFont(new Font("宋体", Font.BOLD, 20));
        //设置鼠标移动
        exit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                exit.setOpaque(true);
                exit.setBackground(new Color(100,149,237));
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
        jp_third.setBackground(new Color(189,183,107));
        jp_third.setPreferredSize(size_1); //设置大小
        jp_thirdUI();//推送

        //创建答疑面板
        jp_fourth = new JPanel();
        // 设置面板背景色
        jp_fourth.setBackground(new Color(188,143,143));
        jp_fourth.setPreferredSize(size_1); //设置大小
        jp_fourthUI();//答疑

        

        jp_east.add(jp_first, "first");
        jp_east.add(jp_second, "second");
        jp_east.add(jp_third, "third");
        jp_east.add(jp_fourth, "fourth");
        

        add(jpwest, BorderLayout.WEST);
        add(jp_east, BorderLayout.EAST);
    }
    private void jp_fourthUI() {
        jp_fourth.setLayout(new BorderLayout());
    }
    private void jp_thirdUI() {
    }
    private void jp_secondUI() {
        jp_second.setLayout(new BorderLayout());

        JSP_Flowers = new JScrollPane();//滚动面板
        JSP_Flowers.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//设置滚动条
        JSP_Flowers.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//设置滚动条
        //JSP_Flowers.setPreferredSize(size_1); //设置大小
        
        jpall_second = new JPanel(new FlowLayout());//面板
        jpall_second.setPreferredSize(size_1); //设置大小
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
        search_btu.setBorderPainted(false);//不显示边框
        search_btu.addActionListener(this);

        search_tf = new JTextField(20);


        jmb1Bar = new JMenuBar();
        leibie = new JMenu();
        leibie.setText("类别 >>");
        // leibie.setFont(new Font("宋体", Font.BOLD, 20));
        //leibie.setForeground(Color.black);
        // //透明
        leibie.setOpaque(false);
        leibie.setContentAreaFilled(false);
        leibie.setBorderPainted(false);//不显示边框
        jmI1 = new JMenuItem("花卉 >");
        jmI1.addActionListener(this);
        jmI2 = new JMenuItem("蔬菜 >");
        jmI2.addActionListener(this);
        jmI3 = new JMenuItem("水果 >");
        jmI3.addActionListener(this);
        jmI4 = new JMenuItem("肉类 >");
        jmI4.addActionListener(this);
        jmI5 = new JMenuItem("蛋类 >");
        jmI5.addActionListener(this);
        jmI6 = new JMenuItem("水产 >");
        jmI6.addActionListener(this);
        jmI7 = new JMenuItem("豆类 >");
        jmI7.addActionListener(this);
        jmI8 = new JMenuItem("调味品 >");
        jmI8.addActionListener(this);
        jmI9 = new JMenuItem("其他 >");
        jmI9.addActionListener(this);
        jmI10 = new JMenuItem("全部 >");
        jmI10.addActionListener(this);
        jmI11 = new JMenuItem("推荐 >");
        jmI11.addActionListener(this);
        jmI12 = new JMenuItem("热门 >");
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
        //next_btu.setBorderPainted(false);//不显示边框
        next_btu.addActionListener(this);

        previous_btu = new JButton("上一页");
        //设置颜色
        previous_btu.setBackground(new Color(144,238,144));
        //previous_btu.setBorderPainted(false);//不显示边框
        previous_btu.addActionListener(this);

        jpall_second_button.add(previous_btu);
        jpall_second_button.add(next_btu);

        jpall_second_top.add(jmb1Bar);
        jpall_second_top.add(search_tf);
        jpall_second_top.add(search_btu);

        connection(false);

        JSP_Flowers.setViewportView(jpall_second);
        //透明
        JSP_Flowers.setOpaque(false);
        JSP_Flowers.getViewport().setOpaque(false);
        JSP_Flowers.getVerticalScrollBar().setUnitIncrement(20);

        jp_second.add(jpall_second_top, BorderLayout.NORTH);
        jp_second.add(JSP_Flowers, BorderLayout.CENTER);
        jp_second.add(jpall_second_button, BorderLayout.SOUTH);

    }
    private void jp_firstUI() {
        jp_first.setLayout(new BorderLayout());

        jpall_first = new JPanel(new BorderLayout());
        //透明
        jpall_first.setOpaque(false);

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

        jpin_Flowers_H.setLayout(new GridLayout(1, num+1,0,0));

        connection(true);//连接数据库
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

        jpall_first.add(JSP_Flowers_H,BorderLayout.CENTER);
        
        jp_Push = new JPanel();
        //透明
        jp_Push.setOpaque(false);
        jp_Push.setLayout(new GridLayout(num+1,1,0,0));
        for(int i=0;i<num;i++){
            String flower_name = "";
            //随机生成一个0到11数字
            int num = (int)(Math.random()*11);
            switch(num){
                case 0:flower_name = "mudan";break;
                case 1:flower_name = "dingxiang";break;
                case 2:flower_name = "jiguanhua";break;
                case 3:flower_name = "lamei";break;
                case 4:flower_name = "lianqiao";break;
                case 5: flower_name = "pugongying";break;
                case 6:flower_name = "shegan";break;
                case 7:flower_name = "taohua";break;
                case 8:flower_name = "yueji";break;
                case 9:flower_name = "yumeiren";break;
                case 10:flower_name = "zhizihua";break;
                default:flower_name = "mudan";break;
            }
            getPush(flower_name);//获取图片和文字
            jp_Push.add(jpin2_Flowers_H);
        }
        JButton jb_more2 = new JButton("更多");
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
        jp_Push.add(jb_more2);

        jpall_first.add(jp_Push,BorderLayout.SOUTH);

        JSP_Flowers_Push.getViewport().setOpaque(false);
        JSP_Flowers_Push.setViewportView(jpall_first);
        JSP_Flowers_Push.getVerticalScrollBar().setUnitIncrement(20);

        jp_first.add(JSP_Flowers_Push,BorderLayout.CENTER);

    }
    private void getPush(String flower_name) {

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
        Login_or_Pi = new JButton(NickName);
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
        Login_or_Pi.setForeground(Color.blue);
        //透明
        Login_or_Pi.setOpaque(false);
        Login_or_Pi.setContentAreaFilled(false);
        Login_or_Pi.setBorderPainted(false);//不显示边框
        Login_or_Pi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pi != null){
                    pi.dispose();
                }
                pi = new User_PI(NickName+"-个人信息");
                pi.setVisible(true);
            }
        });
        jpwest.add(Login_or_Pi);//添加登录按钮
    }
    public void getImageandTxt(String name1){
        ImageIcon icon = new ImageIcon("src\\Chinese_Flower\\image\\"+name1+".jpg");//获取图片
        icon.setImage(icon.getImage().getScaledInstance(120, 110, Image.SCALE_DEFAULT));
        jbImage = new JButton(icon);
        //透明
        jbImage.setOpaque(false);//透明
        jbImage.setContentAreaFilled(false);//不显示边框
        jbImage.setBorderPainted(false);//不显示边框

        jtf = new JTextField();
        //透明
        jtf.setOpaque(false);
        jtf.setEditable(false);//设置文本域不可编辑
        jtf.setText(flower_name);//设置文本域文字
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
                jtf.setForeground(Color.blue);
            }//鼠标进入
            public void mouseExited(MouseEvent e) {
                //jtf字体变成黑色
                jtf.setForeground(Color.black);
            }//鼠标移出
        });
        
        jpin2_Flowers_H = new JPanel(new BorderLayout());
        //透明
        jpin2_Flowers_H.setOpaque(false);
        jpin2_Flowers_H.add(jbImage, BorderLayout.NORTH);//添加按钮
        jpin2_Flowers_H.add(jtf, BorderLayout.SOUTH);//添加文本域
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
            //搜索
            search(search_content);
        }
    }
    private void search(String search_content) {
        if(search_content.equals("")){
            JOptionPane.showMessageDialog(null, "请输入搜索内容");
            return;
        }
        //搜索
        try {
            //获取查询语句
            String sql = "select * from flowersinfo where FlowersName like '%"+search_content+"%'";
            //获取查询结果
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            //循环获取查询结果
            if(rs.next()){
                if(flowersInfo != null){
                    flowersInfo.dispose();
                }
                flowers_image = rs.getString("FlowersImage");
                flowersInfo = new FlowersInfo(flowers_image);
                flowersInfo.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "没有搜索到相关内容");
                return;
            }

            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "搜索失败");
        }
    }
    private void connection(boolean is_H) {
        int i = 0;
        try {
            String sql = "select * from flowersinfo limit "+i+","+(i+20);
            PreparedStatement pstmt = conn.prepareStatement(sql);//创建游标2
            ResultSet rs = pstmt.executeQuery();//执行查询
            while(rs.next()) {
                i++;
                flowers_image = rs.getString("FlowersImage");//获取名称
                flower_name = rs.getString("FlowersName");//获取名称
                getImageandTxt(flowers_image);//获取图片和文字
                if(is_H){
                    jpin_Flowers_H.add(jpin2_Flowers_H);
                }else{
                    jpall_second.add(jpin2_Flowers_H);//添加面板
                }
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
}