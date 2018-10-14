package zm.village.controller.backstage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 生成随机图片，用来作为验证码
 */
@Controller
@RequestMapping("/DrawImage")
public class DrawImageController implements Serializable {
    private static final long serialVersionUID = 3038623696184546092L;
    
    public static final int WIDTH = 120;//生成的图片的宽度
    public static final int HEIGHT = 30;//生成的图片的高度

    @RequestMapping(value = "/draw")
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String createTypeFlag = request.getParameter("createTypeFlag");//接收客户端传递的createTypeFlag标识
        //1.在内存中创建�?张图�?
        BufferedImage bi = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
        //2.得到图片
        Graphics g = bi.getGraphics();
        //3.设置图片的背影色
        setBackGround(g);
        //4.设置图片的边�?
        setBorder(g);
        //5.在图片上画干扰线
        drawRandomLine(g);
        String random = drawRandomNum((Graphics2D) g,createTypeFlag);//根据客户端传递的createTypeFlag标识生成验证码图�?
        //7.将随机数存在session�?
        request.getSession().setAttribute("checkcode", random);
        //8.设置响应头�?�知浏览器以图片的形式打�?
        response.setContentType("image/jpeg");//等同于response.setHeader("Content-Type", "image/jpeg");
        //9.设置响应头控制浏览器不要缓存
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        //10.将图片写给浏览器
        ImageIO.write(bi, "jpg", response.getOutputStream());
    }

    /**
     * 设置图片的背景色
     * @param g
     */
    private void setBackGround(Graphics g) {
        // 设置颜色
        g.setColor(Color.WHITE);
        // 填充区域
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    /**
     * 设置图片的边�?
     * @param g
     */
    private void setBorder(Graphics g) {
        // 设置边框颜色
        g.setColor(Color.BLUE);
        // 边框区域
        g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
    }

    /**
     * 在图片上画随机线�?
     * @param g
     */
    private void drawRandomLine(Graphics g) {
        // 设置颜色
        g.setColor(Color.GREEN);
        // 设置线条个数并画�?
        for (int i = 0; i < 5; i++) {
            int x1 = new Random().nextInt(WIDTH);
            int y1 = new Random().nextInt(HEIGHT);
            int x2 = new Random().nextInt(WIDTH);
            int y2 = new Random().nextInt(HEIGHT);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 画随机字�?
     * @param g
     * @param createTypeFlag
     * @return
     * String... createTypeFlag是可变参数，
     * Java1.5增加了新特�?�：可变参数：�?�用于参数个数不确定，类型确定的情况，java把可变参数当做数组处理�?�注意：可变参数必须位于�?后一�?
     */
    private String drawRandomNum(Graphics2D g,String... createTypeFlag) {
        // 设置颜色
        g.setColor(Color.RED);
        // 设置字体
        g.setFont(new Font("宋体", Font.BOLD, 20));
        //数字和字母的组合
        String baseNumLetter = "0123456789ABCDEFGHJKLMNOPQRSTUVWXYZ";
        //纯数�?
        String baseNum = "0123456789";
        //纯字�?
        String baseLetter = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
        //createTypeFlag[0]==null表示没有传�?�参�?
        if (createTypeFlag.length > 0 && null != createTypeFlag[0]) {
            if (createTypeFlag[0].equals("nl")) {
                // 截取汉字
            	return createRandomChar(g, baseNumLetter);
            }
        }else {
            // 默认截取数字和字母的组合
            return createRandomChar(g, baseNumLetter);
        }
        
        return "";
    }

    /**
     * 创建随机字符
     * @param g
     * @param baseChar
     * @return 随机字符
     */
    private String createRandomChar(Graphics2D g,String baseChar) {
        StringBuffer sb = new StringBuffer();
        int x = 5;
        String ch ="";
        // 控制字数
        for (int i = 0; i < 4; i++) {
            // 设置字体旋转角度
            int degree = new Random().nextInt() % 30;
            ch = baseChar.charAt(new Random().nextInt(baseChar.length())) + "";
            sb.append(ch);
            // 正向角度
            g.rotate(degree * Math.PI / 180, x, 20);
            g.drawString(ch, x, 20);
            // 反向角度
            g.rotate(-degree * Math.PI / 180, x, 20);
            x += 30;
        }
        return sb.toString();
    }
}
