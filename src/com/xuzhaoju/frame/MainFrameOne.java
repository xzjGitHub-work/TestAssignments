package com.xuzhaoju.frame;

import com.xuzhaoju.frame.puchase.PurchaseFrame;
import com.xuzhaoju.model.Student;
import com.xuzhaoju.util.Chooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2020/12/23 9:19
 */
public class MainFrameOne extends JFrame {
    public static void main(String[] args) {
        MainFrameOne mainFrameOne = new MainFrameOne();
        mainFrameOne.setVisible(true);
    }
    private JPanel contentPane;
    private JTable table;
    private String[] columnCount= {"基本档案","采购订货","仓库入库","仓库出库","人员管理","部门管理"};
    private List<Student> list;
    public static Student stu;
    public static MainFrame frame;
    public static JButton text = new JButton();
    public static PurchaseFrame purchaseFrame;


    public MainFrameOne() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 80, 880, 480);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(20,144,255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        //左侧时间
        //上部滚动事件
        JScrollPane timelPane = new JScrollPane();
        timelPane .setBounds(10, 100, 180, 332);
        contentPane.add(timelPane);
        text.setBounds(10, 10, 160, 30);
        timelPane.add(text);
        //下部日历
        JScrollPane calderlPane = new JScrollPane();
        calderlPane .setBounds(10, 130, 180, 332);
        timelPane.add(Chooser.getInstance(new Date()));
        contentPane.add(calderlPane);

        //右侧主题
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(200, 100, 660, 332);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        JPanel jPanel = new JPanel();

        //上部变体栏
        JButton button = new JButton("基本档案");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                quaryAll();
            }
        });
        button.setBounds(140, 22, 100, 50);
        contentPane.add(button);

        JButton button_1 = new JButton("采购订货");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        button_1.setBounds(240, 22, 100, 50);
        contentPane.add(button_1);
        //全屏
//		setExtendedState(JFrame.MAXIMIZED_BOTH);

        JButton button_2 = new JButton("仓库入库");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button_2.setBounds(340, 22, 100, 50);
        contentPane.add(button_2);

        JButton button_3 = new JButton("仓库出库");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button_3.setBounds(440, 22, 100, 50);
        contentPane.add(button_3);

        JButton button_4 = new JButton("人员管理");
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                purchaseFrame = new PurchaseFrame();
                PurchaseFrame.frame = purchaseFrame;
                purchaseFrame.setVisible(true);
                login.mainFrameOne.setVisible(false);
            }
        });
        button_4.setBounds(540, 22, 100, 50);
        contentPane.add(button_4);

        JButton button_5 = new JButton("部门管理");
        button_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        button_5.setBounds(640, 22, 100, 50);
        contentPane.add(button_5);

    }
}
