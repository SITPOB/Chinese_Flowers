package Chinese_Flower.test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class ad {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    public static final String DB_URL = "jdbc:mysql://rm-2vcx009o71la8ri5f2o.mysql.cn-chengdu.rds.aliyuncs.com/flowers_data"; 
    // 数据库的用户名与密码，需要根据自己的设置
    public static final String USER = "root";
    public static final String PASS = "Lzh200199";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            //从文件中读取数据
            int i = 1,j = 0,k=0;
            String[] q = new String[99999];
            String[] a = new String[99999];
            String s="";
            try (BufferedReader br = new BufferedReader(new FileReader("src\\Chinese_Flower\\词库v2.4强化版.txt"))) {
                while((s = br.readLine())!=null){
                    if(i>=99999){
                        break;
                    }
                    if(s.equals("")){
                        i++;
                        continue;
                    }
                    if(i%2==1){
                        q[j] = s;
                        j++;
                    }
                    else{
                        a[k] = s;
                        k++;
                    }
                    i++;
                }
            }
            int m=j;
            i=0;
            j=0;
            k=0;
            PreparedStatement pstmt;
            while(i<m){
                i++;
                // System.out.println(q[j]+"\n"+a[k]);
                pstmt = conn.prepareStatement("insert into robot(AQ_ID,Query,Answer) values("+i+",'"+q[j]+"','"+a[k]+"')");
                pstmt.executeUpdate();
                j++;
                k++;
            }
            // 完成后关闭
                // pstmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

}