package com.xuzhaoju.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java类作用描述
 */
public class login {

    public static MainFrame frame;
    public static JFrame frameBig;
    public static JLabel timeButton;
    public static JTextField userText;
    public static final int DEFAULT_WIDTH = 300;                        //面板的宽度
    public static final int PADDING_X = 30;
    public static final int PADDING_Y = 60;
    public static final int clockRadius = (DEFAULT_WIDTH - 60) / 2;            //定义时钟圆的半径radius
    int xCenter = PADDING_X + clockRadius;                                 //时钟圆的圆心坐标
    int yCenter = PADDING_Y + clockRadius;

    public static void main(String[] args) {
        frameBig = new JFrame("超市管理系统");
        frameBig.setSize(699, 400);
        frameBig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frameBig.add(panel);
        placeComponents(panel);
        // 设置界面可见
        new Thread(new OneThread()).start();
        frameBig.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        ImageIcon imageIcon = new ImageIcon("D:\\imageformats\\img.png");

        /*
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建 JLabel
        JLabel userLabel = new JLabel("用户名:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(140, 230, 100, 25);
        panel.add(userLabel);

        /*
         * 创建文本域用于用户输入
         */
        userText = new JTextField(60);
        userText.setBounds(190, 230, 185, 25);
        panel.add(userText);

        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("密 码:");
        passwordLabel.setBounds(150, 270, 80, 25);
        panel.add(passwordLabel);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(190, 270, 185, 25);
        panel.add(passwordText);

        // 创建登录按钮
        JButton loginButton = new JButton("登录");
//        loginButton.
        loginButton.setBounds(530, 230, 80, 25);
        panel.add(loginButton);
        loginButton.addActionListener((new SubmitAction(passwordText, userText)));

        //时间按钮
        timeButton = new JLabel(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        timeButton.setBounds(520, 45, 150, 25);
        panel.add(timeButton);



        //背景
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setBounds(0,0,699,400);
        panel.add(jLabel);

    }


    static class SubmitAction extends JFrame implements ActionListener {
        JPasswordField passwordField;
        JTextField jTextField;

        public SubmitAction(JPasswordField jPasswordField, JTextField jTextField) {
            this.passwordField = jPasswordField;
            this.jTextField = jTextField;

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String userName = jTextField.getText();
            String password = passwordField.getText();
            ;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library?useSSL=false&serverTimezone=UTC", "root", "root");
                Statement st = conn.createStatement();
                System.out.println("select * from user where account = '" + userName + "'");
                ResultSet rs = st.executeQuery("select * from user where account = '" + userName + "'");
                if (!rs.next()) {
                    System.out.println("当用户名不存在");
                    JOptionPane.showMessageDialog(null,"当用户名不存在");
                } else {
                    System.out.println(                    "select * from user where account = '" + userName + "' and password = '" + password + "'");
                    ResultSet verify = st.executeQuery("select * from user where account = '" + userName + "' and password = '" + password + "'");
                    if (!verify.next()) {
                        System.out.println( "当前用户密码不正确" );
                        JOptionPane.showMessageDialog( null , "当前用户密码不正确" );
                   
                    } else {
                        EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                try {
                                    frameBig.setVisible(false);
                                    frame = new MainFrame();
                                    //窗口居中
                                    frame.setLocationRelativeTo(null);
                                    frame.setVisible(true);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                   }
                }
                setIsView();
                rs.close();
                st.close();
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("报错了");
            }
        }

        private void setIsView() {
        }

    }

}
