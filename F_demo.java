package Chinese_Flower;

import javax.swing.*;

import Chinese_Flower.Encryption.*;
import Chinese_Flower.Model.User_model;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class F_demo extends JFrame {

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    public static final String DB_URL = "jdbc:mysql://rm-2vcx009o71la8ri5f2o.mysql.cn-chengdu.rds.aliyuncs.com/flowers_data"; 
    // 数据库的用户名与密码，需要根据自己的设置
    public static final String USER = "root";
    public static final String PASS = "Lzh200199";

    public static Connection conn = null;
    // public static Statement stmt = null;
    // public static PreparedStatement pstmt = null;

    // public static int UserID = 0, UserAge = 0;
    // public static String UserAccount = "", UserPWD = "", NickName = "", UserPhone = "", Others_ = "";
    public static Loginch loginch = null;
    // public static Login login = null;
    public static MainFrame mainFrame1 = null;
    public static MainAdmin mainAdmin = null;
    public static ForgetPassword fgpw = null;
    public static User_PI pi = null;
    //反馈
    public static Feedback feedback = null;
    public static String Others_ = "";
    public static boolean dlcg = false;//判断是否登录成功
    public static boolean BG = false;//判断是是否黑色模式
    public static ImageIcon icon_1 = new ImageIcon("src/Chinese_Flower/icon/R-C.jpg");
    public CardLayout cl = new CardLayout();
    public static User_model user_model = new User_model();
    public FlowersInfo flowersInfo = null;
    public static void main(String[] args) {
        Load load = new Load();
        load.setVisible(true);
        Connect();//连接数据库
        //读取文件账号和密码
        try{
            BufferedReader br = new BufferedReader(new FileReader("src\\Chinese_Flower\\account.lzh"));
            String line = br.readLine();
            loginch = new Loginch();
            if(line == null){
                loginch.setVisible(true);
                load.dispose();
            }else{
                String[] str = line.split(" ");//分割字符串
                Encryption encryptionKey = new EncryptionImpl();
                loginch.loginUser(false, encryptionKey.decryption(str[0]), encryptionKey.decryption(str[1]), "用户自动登录");
                load.dispose();
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据文件错误！\n未找到account.lzh文件！", "提示", JOptionPane.WARNING_MESSAGE);
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