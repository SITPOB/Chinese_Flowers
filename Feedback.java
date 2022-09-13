package Chinese_Flower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Feedback extends F_demo {
    private JPanel jp2_in_1;
    private JTextArea jta;
    private JPanel jp1, jp2;
    //提交
    private JButton submit, exit, submit_jl, back;
    //输入框
    private JTextArea text;
    //标签
    private JLabel txt, jl;
    //gundong
    private JScrollPane jsp1, jsp2;
    private String s = "", sql = "";

    public Feedback() {
        setTitle("意见反馈");//设置标题
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//退出后关闭
        setSize(440, 300);
        // setResizable(false);//不可缩放
        // setUndecorated(true);//去掉窗口边框
        setLocationRelativeTo(null);//中心
        setIconImage(icon_1.getImage());//设置图标
        setLayout(cl);

        jp1 = new JPanel(new BorderLayout());
        jp1UI();
        jp2 = new JPanel(new BorderLayout());
        jp2UI();

        add(jp1, "jp1");
        add(jp2, "jp2");

    }
    private void jp2UI() {
        jp2_in_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // String s = "您的反馈有:\n\n";
        jta = new JTextArea();
        //设置字体
        jta.setFont(new Font("宋体", Font.PLAIN, 14));
        //设置只读
        jta.setEditable(false);
        jta.setLineWrap(true);
        // try{
        //     String sql;
        //     sql = "SELECT * FROM Feedback";
        //     PreparedStatement pstmt = conn.prepareStatement(sql);//创建游标2
        //     ResultSet rs = pstmt.executeQuery();//执行查询
        //     while(rs.next()){
        //         if(rs.getInt("UserID") == UserID){
        //             if(rs.getInt("IsTDW") == 0){
        //                 s = s + "提交时间："+rs.getString("FeedbackTime")+"(未回复)"+"\n"+"反馈内容："+rs.getString("FeedbackContent")+"\n\n";
        //                 jta.setText(s);
        //             }else{
        //                 s = s + "提交时间："+rs.getString("FeedbackTime")+"(已回复)"+"\n"+"反馈内容："+rs.getString("FeedbackContent")+"\n"+"回复时间："+rs.getString("ReplyTime")+"\n"+"回复内容："+rs.getString("ReplyContent")+"\n\n";
        //                 jta.setText(s);
        //             }
        //         }
        //     }
        //     rs.close();
        //     pstmt.close();
        // }catch(SQLException e){
        //     e.printStackTrace();

        // }catch(Exception e){
        //     e.printStackTrace();
        // }

        jsp2 = new JScrollPane(jta);
        //设置滚动条速度
        jsp2.getVerticalScrollBar().setUnitIncrement(20);

        back = new JButton("返回");
        //透明
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        //back.setBorderPainted(false);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(getContentPane(), "jp1");
            }
        });
        jl = new JLabel("");

        jp2_in_1.add(back);
        jp2_in_1.add(jl);
        jp2.add(jsp2, BorderLayout.CENTER);
        jp2.add(jp2_in_1, BorderLayout.SOUTH);
    }
    private String getFKnum() {
        String s = "";
        try {
            String sql;
            sql = "SELECT count(UserID) num,UserID FROM feedback where IsTDW = 0 group by UserID having UserID = " + user_model.getUserID();
            PreparedStatement pstmt = conn.prepareStatement(sql);//创建游标2
            ResultSet rs = pstmt.executeQuery();//执行查询
            if (rs.next()) {
                s = "您有" + rs.getInt("num") + "条未回复的反馈";
            }
            sql = "SELECT count(UserID) num,UserID FROM feedback where IsTDW = 1 group by UserID having UserID = " + user_model.getUserID();
            pstmt = conn.prepareStatement(sql);//创建游标2
            rs = pstmt.executeQuery();//执行查询
            if (rs.next()) {
                s = s + "，" + rs.getInt("num") + "条已回复的反馈";
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    private void jp1UI() {
        JPanel jp1_in_1 = new JPanel(new BorderLayout());
        JPanel jp1_in_2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txt = new JLabel("请输入您的意见：");
        //设置字体大小
        txt.setFont(new Font("宋体", Font.PLAIN, 20));
        text = new JTextArea();
        text.setFont(new Font("宋体", Font.PLAIN, 15));
        //自动换行
        text.setLineWrap(true);
        jsp1 = new JScrollPane(text);

        submit = new JButton("提交");
        submit.setFont(new Font("宋体", Font.PLAIN, 20));
        //提交
        submit.setBackground(Color.white);
        submit.setForeground(Color.black);
        submit.setBorder(BorderFactory.createLineBorder(Color.black));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = text.getText();
                if (s.equals("")) {
                    JOptionPane.showMessageDialog(null, "请输入反馈内容！");
                } else {
                    try {
                        //插入数据
                        sql = "INSERT INTO Feedback(IsTDW,FeedbackContent,FeedbackTime,UserID) VALUES(?,?,?,?)";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setInt(1, 0);
                        pstmt.setString(2, s);
                        //写入时间timestamp
                        Date date = new Date();
                        Timestamp time = new Timestamp(date.getTime());
                        pstmt.setTimestamp(3, time);
                        pstmt.setInt(4, user_model.getUserID());
                        // pstmt.setString(6, "");
                        // pstmt.setTimestamp(7, time);
                        //pstmt.setInt(8, 0);
                        pstmt.executeUpdate();
                        pstmt.close();
                        JOptionPane.showMessageDialog(null, "提交成功！");
                        text.setText("");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "提交失败！");
                    }
                }
            }
        });
        //退出
        exit = new JButton("退出");
        exit.setFont(new Font("宋体", Font.PLAIN, 20));
        exit.setBackground(Color.white);
        exit.setForeground(Color.black);
        exit.setBorder(BorderFactory.createLineBorder(Color.black));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        //提交记录
        submit_jl = new JButton("提交记录");
        submit_jl.setFont(new Font("宋体", Font.PLAIN, 20));
        submit_jl.setBackground(Color.white);
        submit_jl.setForeground(Color.black);
        submit_jl.setBorder(BorderFactory.createLineBorder(Color.black));
        submit_jl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = "您的反馈有:\n\n";
                try{
                    sql = "SELECT * FROM Feedback WHERE UserID = '"+user_model.getUserID()+"'";
                    PreparedStatement pstmt = conn.prepareStatement(sql);//创建游标2
                    ResultSet rs = pstmt.executeQuery();//执行查询
                    while(rs.next()){
                        if(rs.getInt("IsTDW") == 0){
                            s = s + "提交时间："+rs.getString("FeedbackTime")+"(未回复)"+"\n"+"反馈内容："+rs.getString("FeedbackContent")+"\n\n";
                            jta.setText(s);
                        }else{
                            s = s + "提交时间："+rs.getString("FeedbackTime")+"(已回复)"+"\n"+"反馈内容："+rs.getString("FeedbackContent")+"\n"+"回复时间："+rs.getString("ReplyTime")+"\n"+"回复内容："+rs.getString("ReplyContent")+"\n\n";
                            jta.setText(s);
                        }
                    }
                    jl.setText(getFKnum());
                    rs.close();
                    pstmt.close();
                }catch(SQLException e2){
                    e2.printStackTrace();
        
                }catch(Exception e2){
                    e2.printStackTrace();
                }
                cl.show(getContentPane(), "jp2");
            }
        });
        jp1_in_1.add(txt, BorderLayout.NORTH);
        jp1_in_1.add(jsp1, BorderLayout.CENTER);
        jp1_in_2.add(submit);
        jp1_in_2.add(exit);
        jp1_in_2.add(submit_jl);
        jp1.add(jp1_in_1, BorderLayout.CENTER);
        jp1.add(jp1_in_2, BorderLayout.SOUTH);
    }
}
