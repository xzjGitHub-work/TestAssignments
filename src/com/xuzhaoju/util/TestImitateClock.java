package com.xuzhaoju.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author YYCat
 */
public class TestImitateClock extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final int DEFAULT_HEIGHT = 200;                        //面板的高度
    public static final int DEFAULT_WIDTH = 200;                        //面板的宽度
    public static final int DEFAULT_X = 300;                            //面板初始位置
    public static final int DEFAULT_Y = 50;
    public static final int PADDING_X = 400;
    public static final int PADDING_Y = 60;
    public static final int clockRadius = (DEFAULT_WIDTH - 60) / 2;            //定义时钟圆的半径radius
    int xCenter = PADDING_X + clockRadius;                                 //时钟圆的圆心坐标
    int yCenter = PADDING_Y + clockRadius;

    /**
     * 定义时间变量，便于计算对应的时、分、秒针对应的位置
     */
    private int second, minute, hour;

    public TestImitateClock() {
        initTime();
    }


    public void paint(Graphics g) {
        /**
         * 画时钟轮廓
         * 定义半径clockRadius：120px;
         */

        //        int clockRadius = DEFAULT_WIDTH - 60;        //半径为 (300-600)/2
        g.drawOval(PADDING_X, PADDING_Y, clockRadius * 2, clockRadius * 2);

        paintClockNum(g);

        paintClockHands(g);


    }

    /**
     * 画时钟数字
     *
     * @param g
     */
    public void paintClockNum(Graphics g) {

        int strLength = xCenter - PADDING_X;
        Font afterFont = new Font("宋体", Font.BOLD, 14);
        Font beforeF = g.getFont();

        for (int i = 0; i < 12; i++) {
            if (i % 3 == 0) {            //固定位置数字加粗显示
                g.setFont(afterFont);
            }
            g.drawString(i * 1 + "", (int) (xCenter + strLength * Math.sin(2 * Math.PI / 12 * i)), (int) (yCenter + strLength * Math.cos(Math.PI + 2 * Math.PI / 12 * i)));
            g.setFont(beforeF);
        }

    }

    /**
     * 画时针、分针、秒针
     */
    public void paintClockHands(Graphics g) {

        /**
         * 设置时分秒针的长度、颜色、宽度
         */
        double secondLen = clockRadius * 0.85;
        double minuteLen = clockRadius * 0.75;
        double hourLen = clockRadius * 0.65;

        Color colorBefore = g.getColor();


        //秒针
        g.setColor(Color.RED);
        g.drawLine(xCenter, yCenter, (int) (xCenter + secondLen * Math.sin(2 * Math.PI / 60 * second)), (int) (yCenter + secondLen * Math.cos(Math.PI + 2 * Math.PI / 60 * second)));

        //分针
        g.setColor(Color.CYAN);
        g.drawLine(xCenter, yCenter, (int) (xCenter + minuteLen * Math.sin(2 * Math.PI / 60 * minute)), (int) (yCenter + minuteLen * Math.cos(Math.PI + 2 * Math.PI / 60 * minute)));

        //时针
        g.setColor(Color.DARK_GRAY);
        g.drawLine(xCenter, yCenter, (int) (xCenter + hourLen * Math.sin(2 * Math.PI / 12 * hour)), (int) (yCenter + hourLen * Math.cos(Math.PI + 2 * Math.PI / 12 * hour)));

        g.setColor(colorBefore);
    }

    /**
     * 获取时间
     */
    public void initTime() {
        Calendar calendar = new GregorianCalendar();
        second = calendar.get(Calendar.SECOND);
        minute = calendar.get(Calendar.MINUTE);
        hour = calendar.get(Calendar.HOUR_OF_DAY);            //24小时制

    }

    public static void main(String[] args) {

        final JFrame frame = new JFrame();
        frame.setTitle("Clock");
        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        frame.setLocation(DEFAULT_X, DEFAULT_Y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Thread thread = new Thread() {
            public void run() {
                while (true) {
                    TestImitateClock clock = new TestImitateClock();
                    frame.add(clock);
                    clock.setVisible(true);
                    frame.validate();        //接下来会每隔一秒重绘一次时钟——即（从frame中将clock组件删除），因此调用validate方法，使容器重新布置其子组件
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    clock.setVisible(false);
                    frame.remove(clock);     //在父容器中将其删除
                    clock.invalidate();        //使容器失效
                }
            }
        };

        thread.start();
    }

}