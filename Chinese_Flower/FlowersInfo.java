package Chinese_Flower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FlowersInfo extends MainFrame {
    private JPanel jpbottom, jp_info, jp_image_text, jp_info_text, jp_introduce, jp_mc, jp_l_h;
    private JLabel image, introduce, mc, l_h;
    private JButton collect, exit;
    private JScrollPane jsp_info;
    private JTextArea FlowersName, FlowersOtherName, FlowersClass, Flowers_FG, introduce_text, mc_text, l_h_text;
    private int Flowers_ID = 0;
    private boolean isCollect = false;
    private String flower_name = "", flower_other_name = "", flower_class = "", flower_fg = "", flowers_introduce = "", flowers_mc = "", flowers_life_habit = "", flowers_image = "";
    public FlowersInfo(String s) {
        setTitle(s+"-信息");//设置标题
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//退出后关闭
        setSize(800, 550);
        setResizable(false);//不可缩放
        setLocationRelativeTo(null);//中心
        setLayout(new BorderLayout());
        
        flowers_image = s;
        //当窗口大小改变时
        // addComponentListener(new ComponentAdapter() {
        //     @Override
        //     public void componentResized(ComponentEvent e) {
        //         super.componentResized(e);
        //         //通过内部组件高度来设置外部组件高度
        //         jp_info.setPreferredSize(new Dimension(getWidth() - 20, jp_info.getHeight()));
        //         //jp_image_text.setPreferredSize(new Dimension(getWidth() - 20, getHeight() - 100));
        //         //jp_info_text.setPreferredSize(new Dimension(getWidth() - 20, getHeight() - 100));
        //         // jp_introduce.setPreferredSize(new Dimension(getWidth() - 20, getHeight() - 100));
        //         // jp_mc.setPreferredSize(new Dimension(getWidth() - 20, getHeight() - 100));
        //         // jp_l_h.setPreferredSize(new Dimension(getWidth() - 20, getHeight() - 100));
        //         jp_info.revalidate();
        //         jp_info.repaint();
        //     }
        // });
        flowersInfoUI();
    }
    private void flowersInfoUI() {
        jpbottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //透明
        jpbottom.setBackground(new Color(143,188,143));
        
        exit = new JButton("返回");
        exit.setOpaque(false);//透明
        exit.setContentAreaFilled(false);//透明
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                flowersInfo = null;
            }//返回
        });
        jp_info = new JPanel(new GridLayout(4, 1, 0, 10));
        jp_info.setBackground(new Color(143,188,143));
        
        Connect_f();
        collect = new JButton();
        collect.setOpaque(false);//透明
        //collect.setBorderPainted(false);//不绘制边框
        collect.setContentAreaFilled(false);//透明
        if(isCollect) {
            collect.setText("取消收藏");
        }else {
            collect.setText("添加收藏");
        }
        collect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isCollect){
                    collect_f();
                }else{
                    collectFlowers();
                }
            }
        });
        //鼠标移入
        collect.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(isCollect){
                    collect.setForeground(Color.red);
                }
                else{
                    collect.setForeground(Color.yellow);
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                collect.setForeground(Color.black);
            }
        });
        getinfo();

        jsp_info = new JScrollPane();//滚动条
        jsp_info.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//水平不显示
        jsp_info.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//垂直显示
        jsp_info.setViewportView(jp_info);
        jsp_info.getVerticalScrollBar().setUnitIncrement(20);
        jsp_info.setOpaque(false);//透明
        jsp_info.getViewport().setOpaque(false);//透明

        jpbottom.add(collect);
        jpbottom.add(exit);//返回
        add(jsp_info, BorderLayout.CENTER);
        add(jpbottom, BorderLayout.SOUTH);
    }
    private void getinfo() {
        image = new JLabel(new ImageIcon("src\\Chinese_Flower\\image\\"+flowers_image+".jpg"));//加入图片
        jp_image_text = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp_image_text.setOpaque(false);//透明

        //加入信息
        jp_info_text = new JPanel(new GridLayout(4, 1, 0, 2));
        jp_info_text.setOpaque(false);//透明
        FlowersName = new JTextArea(flower_name);
        //透明
        FlowersName.setOpaque(false);
        FlowersName.setEditable(false);
        //FlowersName.setLineWrap(true);
        FlowersName.setFont(new Font("宋体", Font.BOLD, 20));
        FlowersOtherName = new JTextArea("别名："+flower_other_name);
        //透明
        FlowersOtherName.setOpaque(false);
        FlowersOtherName.setEditable(false);
        //FlowersOtherName.setLineWrap(true);
        FlowersOtherName.setFont(new Font("宋体", Font.BOLD, 15));
        FlowersClass = new JTextArea("种类："+flower_class);
        //透明
        FlowersClass.setOpaque(false);
        FlowersClass.setEditable(false);
        FlowersClass.setLineWrap(true);
        FlowersClass.setFont(new Font("宋体", Font.BOLD, 15));
        Flowers_FG = new JTextArea("科属："+flower_fg);
        //透明
        Flowers_FG.setOpaque(false);
        Flowers_FG.setEditable(false);
        //Flowers_FG.setLineWrap(true);
        Flowers_FG.setFont(new Font("宋体", Font.BOLD, 15));
        jp_info_text.add(FlowersName);
        jp_info_text.add(FlowersOtherName);
        jp_info_text.add(FlowersClass);
        jp_info_text.add(Flowers_FG);

        jp_image_text.add(image);
        jp_image_text.add(jp_info_text);

        jp_introduce = new JPanel(new BorderLayout());
        //透明
        jp_introduce.setOpaque(false);
        introduce = new JLabel(flower_name+"的简介：");
        introduce.setFont(new Font("宋体", Font.BOLD, 20));
        introduce.setForeground(Color.blue);
        //透明
        introduce.setOpaque(false);
        introduce_text = new JTextArea(flowers_introduce);
        //透明
        introduce_text.setOpaque(false);
        introduce_text.setEditable(false);
        introduce_text.setLineWrap(true);
        introduce_text.setFont(new Font("宋体", Font.BOLD, 15));
        jp_introduce.add(introduce, BorderLayout.NORTH);
        jp_introduce.add(introduce_text, BorderLayout.CENTER);

        jp_mc = new JPanel(new BorderLayout());
        //透明
        jp_mc.setOpaque(false);
        mc = new JLabel(flower_name+"的形状特征：");
        mc.setFont(new Font("宋体", Font.BOLD, 20));
        mc.setForeground(Color.blue);
        //透明
        mc.setOpaque(false);
        mc_text = new JTextArea(flowers_mc);
        //透明
        mc_text.setOpaque(false);
        mc_text.setEditable(false);
        mc_text.setLineWrap(true);
        mc_text.setFont(new Font("宋体", Font.BOLD, 15));
        jp_mc.add(mc, BorderLayout.NORTH);
        jp_mc.add(mc_text, BorderLayout.CENTER);


        jp_l_h = new JPanel(new BorderLayout());
        //透明
        jp_l_h.setOpaque(false);
        l_h = new JLabel(flower_name+"的生活习性：");
        l_h.setFont(new Font("宋体", Font.BOLD, 20));
        l_h.setForeground(Color.blue);
        //透明
        l_h.setOpaque(false);
        l_h_text = new JTextArea(flowers_life_habit);
        //透明
        l_h_text.setOpaque(false);
        l_h_text.setEditable(false);
        l_h_text.setLineWrap(true);
        l_h_text.setFont(new Font("宋体", Font.BOLD, 15));
        jp_l_h.add(l_h, BorderLayout.NORTH);
        jp_l_h.add(l_h_text, BorderLayout.CENTER);

        jp_info.add(jp_image_text);
        jp_info.add(jp_introduce);
        jp_info.add(jp_mc);
        jp_info.add(jp_l_h);
    }
    private void Connect_f() {
        try {
            //获取查询语句
            String sql = "select * from flowersinfo where FlowersImage like '%"+flowers_image+"%'";
            //获取查询结果
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            //循环获取查询结果
            if(rs.next()){
                Flowers_ID = rs.getInt("FlowersID");
                flower_name = rs.getString("FlowersName");
                flower_other_name = rs.getString("FlowersOtherName");
                flower_class = rs.getString("FlowersClass");
                flower_fg = rs.getString("Flowers_FG");
                flowers_introduce = rs.getString("Flowers_Introduce");
                flowers_mc = rs.getString("Flowers_MC");
                flowers_life_habit = rs.getString("Flowers_Life_Habit");

            }
            sql = "select * from Collect where FlowersID like '%"+Flowers_ID+"%'";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()){
                isCollect = true;
            }else{
                isCollect = false;
            }
            //关闭连接
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "搜索失败");
        }
    }
    protected void collect_f() {
        try {
            //获取查询语句
            String sql = "delete from Collect where FlowersID = '"+Flowers_ID+"'";
            //获取查询结果
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            //关闭连接
            pstmt.close();

            JOptionPane.showMessageDialog(null, "取消收藏成功");
            isCollect = false;
            collect.setText("添加收藏");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "取消收藏失败");
        }
    }
    protected void collectFlowers() {
        try{
            String sql_1 = "insert into Collect values(?,?,?)";
            PreparedStatement pstme_2 = conn.prepareStatement(sql_1);//创建游标2
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Collect";
            ResultSet rs_1 = stmt.executeQuery(sql);
            int count = 1;
            while(rs_1.next()){
                if(count < rs_1.getInt("CollectID")){
                    break;
                }
                count++;
            }//判断id号是否顺序且连续，如果缺少就在当前缺少的序号上加入
            pstme_2.setInt(1, count);
            pstme_2.setInt(2, UserID);
            pstme_2.setInt(3, Flowers_ID);
            pstme_2.executeUpdate();
            pstme_2.close();
            stmt.close();
            rs_1.close();
            JOptionPane.showMessageDialog(null, "收藏成功");
            isCollect = true;
            collect.setText("取消收藏");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "收藏失败");
        }
    }

}
