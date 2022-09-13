// package Chinese_Flower.test;

// import org.jsoup.Jsoup;
// import org.jsoup.nodes.Document;
// import org.jsoup.select.Elements;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.InputStream;
// import java.net.URL;
// import java.net.URLConnection;
// import java.util.Scanner;

// public class pa {
//     public static void main(String[] args) throws IOException {
//         Elements elements_1 = null, elements_2 = null , name_zw = null, other_name = null, keshu = null, fenlei = null, xttz = null, shxx = null;
//         boolean f = false;
//         String name = "";
//         String  d_url, name_name;
//         while(true){
//             //输入name
//             System.out.println("请输入您要下载的图片名称：");
//             name = new Scanner(System.in).nextLine();
//             Document document;
//             document = Jsoup.connect("http://www.aihuhua.com/huahui/"+name+".html").get();
//             if(f == false){
//                 document = Jsoup.connect("http://www.aihuhua.com/huahui/"+name+".html").get();
//                 f = true;
//             }
//             if(document.toString().contains("该信息不存在或已被删除")){
//                 System.out.println("抱歉，没有找到您要的结果");
//                 continue;
//             }
//             elements_1 = document.select("#main-box > div.content > div.infodata > div.img > img");
//             elements_2 = document.select("#doc-content > dd");
//             name_zw = document.select("#main-box > div.content > div.infodata > div.cont > h1");
//             other_name = document.select("#main-box > div.content > div.infodata > div.cont > label:nth-child(2)");
//             keshu = document.select("#main-box > div.content > div.infodata > div.cont > label:nth-child(4)");
//             fenlei = document.select("#main-box > div.content > div.infodata > div.cont > label:nth-child(3) > a");
//             xttz = document.select("#doc-9b51f49757644682f44c681fd327fe9b > dd");
//             shxx = document.select("#doc-2353e0b8be52db129e7205b21a5b11d2 > dd");
//             //如果没有
//             if(shxx.size() == 0){
//                 shxx = document.select("#doc-16f73fe40ddd57f00e829531a272d688 > dd");
//             }
//             d_url = elements_1.attr("src");
//             name_name = name_zw.attr("title");
//             //String d_name = elements_2.text();
//             System.out.println(d_url);
//             System.out.println(name_name);
//             System.out.println(other_name.text().substring(3));
//             System.out.println(keshu.text().substring(3));
//             System.out.println(fenlei.text());
//             System.out.println(elements_2.text());
//             System.out.println(xttz.text().replace(" ", "\n"));
//             System.out.println(shxx.text().replace(" ", "\n"));
//             //是否下载
//             System.out.println("是否下载图片？(y/n)");
//             String s = new Scanner(System.in).nextLine();
//             if(s.equals("y")){
//                 //下载
//                 String path = "src\\Chinese_Flower\\image\\"+name+".jpg";
//                 URL url = new URL(d_url);
//                 URLConnection conn = url.openConnection();
//                 //conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
//                 InputStream in = conn.getInputStream();
//                 FileOutputStream out = new FileOutputStream(path);
//                 byte[] b = new byte[1024];
//                 int len = 0;
//                 while((len = in.read(b)) != -1){
//                     out.write(b, 0, len);
//                 }
//                 out.close();
//                 in.close();
//                 System.out.println("下载完成");
//             }
//             else{
//                 System.out.println("已取消下载");
//             }
//         }
//     }
// }
