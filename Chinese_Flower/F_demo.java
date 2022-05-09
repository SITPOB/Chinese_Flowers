package Chinese_Flower;

import javax.swing.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class F_demo extends JFrame {

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    public static final String DB_URL = "jdbc:mysql://47.113.190.60:3306/data"; 
    // 数据库的用户名与密码，需要根据自己的设置
    public static final String USER = "data";
    public static final String PASS = "200199";

    public static Connection conn = null;
    // public static Statement stmt = null;
    // public static PreparedStatement pstmt = null;

    public static int UserID = 0, UserAge = 0;
    public static String UserAccount = "", UserPWD = "", NickName = "", UserPhone = "";

    public static Loginch loginch = null;
    public static Login login = null;
    public static MainFrame mainFrame1 = null;
    public static MainAdmin mainAdmin = null;
    public static ForgetPassword fgpw = null;
    public static User_PI pi = null;
    //反馈
    public static Feedback feedback = null;
    public static boolean dlcg = false;//判断是否登录成功
    public static boolean BG = false;//判断是是否黑色模式
    public static void main(String[] args) {
        Load load = new Load();
        load.setVisible(true);
        //界面等待2秒
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        //关闭当前窗口
        Connect();//连接数据库
        load.dispose();
        //读取文件账号和密码
        try{
            BufferedReader br = new BufferedReader(new FileReader("src\\Chinese_Flower\\account.lzh"));
            String line = br.readLine();
            if(line == null){
                loginch = new Loginch();
                loginch.setVisible(true);
            }else{
                String[] str = line.split(" ");//分割字符串
                UserAccount = str[0];
                UserPWD = str[1];
                login = new Login("用户");
                login.loginUser(false, UserAccount, UserPWD);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据文件错误！\n未找到account.dat文件！", "提示", JOptionPane.WARNING_MESSAGE);
        }
        //创建主窗口 
    }
    public static void Connect(){
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "连接数据库失败!", "错误", JOptionPane.WARNING_MESSAGE);
            //关闭
            System.exit(0);
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "连接数据库失败!", "错误", JOptionPane.WARNING_MESSAGE);
            //关闭
            System.exit(0);
        }
    }
}