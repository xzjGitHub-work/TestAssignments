package com.xuzhaoju.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * java类作用描述
 */
public class login {

    public static MainFrame frame;
    public static JFrame frameBig;
    public static JTextField userText = null;
    public static String time ="";

    public static void main(String[] args) {
        // 创建 JFrame 实例
        frameBig = new JFrame("图书管理系统");
        // Setting the width and height of frame
        frameBig.setSize(650, 400);
        frameBig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /* 创建面板，这个类似于 HTML 的 div 标签
         * 可以创建多个面板并在 JFrame 中指定位置
         * 面板中可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();

        // 添加面板
        frameBig.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);
//        new Thread(new thread_one()).start();
        // 设置界面可见
        frameBig.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        ImageIcon imageIcon = new ImageIcon("F:\\img\\1.png");

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
        userLabel.setBounds(180, 100, 100, 25);
        panel.add(userLabel);

        /*
         * 创建文本域用于用户输入
         */
        userText = new JTextField(60);
        userText.setBounds(230, 100, 185, 25);
        panel.add(userText);

        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("密 码:");
        passwordLabel.setBounds(190, 140, 80, 25);
        panel.add(passwordLabel);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(240, 140, 175, 25);
        panel.add(passwordText);

        // 创建登录按钮
        JButton loginButton = new JButton("登录");
        loginButton.setBounds(290, 230, 80, 25);
        panel.add(loginButton);
        loginButton.addActionListener((new SubmitAction(passwordText, userText)));


        //背景
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setBounds(0,0,650,400);
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
