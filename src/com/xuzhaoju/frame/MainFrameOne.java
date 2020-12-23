//package com.xuzhaoju.frame;
//
//import com.xuzhaoju.model.Student;
//import com.xuzhaoju.service.StudentService;
//import com.xuzhaoju.util.DateUtil;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
///**
// * java类作用描述
// *
// * @author xuzhaoju
// * @createDate 2020/12/23 9:19
// */
//public class MainFrameOne extends JFrame {
//    public MainFrame() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 764, 369);
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
//
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setBounds(29, 58, 692, 332);
//        contentPane.add(scrollPane);
//
//        table = new JTable();
//        scrollPane.setViewportView(table);
//
//        JButton button = new JButton("查询");
//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                quaryAll();
//            }
//        });
//        button.setBounds(58, 22, 93, 23);
//        contentPane.add(button);
//
//        JButton button_1 = new JButton("添加");
//        button_1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//                new FromFjame().setVisible(true);
//
//            }
//        });
//        button_1.setBounds(205, 22, 93, 23);
//        contentPane.add(button_1);
//        //全屏
////		setExtendedState(JFrame.MAXIMIZED_BOTH);
//
//        JButton button_2 = new JButton("修改");
//        button_2.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                update();
//                quaryAll();
//            }
//        });
//        button_2.setBounds(357, 22, 93, 23);
//        contentPane.add(button_2);
//
//        JButton button_3 = new JButton("删除");
//        button_3.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                remove();
//                quaryAll();
//            }
//        });
//        button_3.setBounds(539, 22, 93, 23);
//        contentPane.add(button_3);
//
//    }
//    //查询
//    public void quaryAll() {
//        StudentService ss=new StudentService();
//        list = ss.queryAll();
//        if(list==null) {
//            JOptionPane.showMessageDialog(null, "服务器繁忙");
//            return;
//        }
//        Object[][] data = DateUtil.listToArray(list);
//        table.setModel(new DefaultTableModel(data, columnCount));
//    }
//
//    //删除
//    private void remove() {
//        int i = table.getSelectedRow();
//        Student s = list.get(i);
//        int code = new StudentService().delete(s.getId());
//        if(code==0) {
//            JOptionPane.showMessageDialog(null, "删除成功");
//            return;
//        }else {
//            JOptionPane.showMessageDialog(null,DateUtil.errors.get(code) );
//        }
//        quaryAll();
//    }
//
//    //修改
//    private void update() {
//        int i = table.getSelectedRow();
//        stu = list.get(i);
//        new FromFjame().setVisible(true);
//    }
//}
