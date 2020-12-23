package com.xuzhaoju.frame.puchase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.xuzhaoju.model.EmployeeModel;
import com.xuzhaoju.service.EmployeeService;
import com.xuzhaoju.util.DateUtil;

public class AddPurchaseFrame extends JFrame {
    public static void main(String[] args) {
        AddPurchaseFrame addPurchaseFrame = new AddPurchaseFrame();
        addPurchaseFrame.setVisible(true);
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;//姓名
    private JTextField textField_1;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;

    public AddPurchaseFrame() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 314, 400);
        contentPane = new JPanel();
        contentPane.setName("添加员工信息");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("添加员工");
        label.setFont(new Font("宋体", Font.PLAIN, 17));
        label.setBounds(118, 20, 78, 39);
        contentPane.add(label);

        JLabel label_1 = new JLabel("姓名");
        label_1.setBounds(23, 61, 40, 15);
        contentPane.add(label_1);

        textField = new JTextField();
        textField.setBounds(87, 61, 155, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel label_2 = new JLabel("年龄");
        label_2.setBounds(23, 91, 40, 15);
        contentPane.add(label_2);

        textField_1 = new JTextField();
        textField_1.setBounds(87, 91, 155, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);


        JLabel label_3 = new JLabel("性别");
        label_3.setBounds(23, 121, 32, 15);
        contentPane.add(label_3);

        textField_3 = new JTextField();
        textField_3.setBounds(87, 121, 155, 21);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JLabel label_4 = new JLabel("职位");
        label_4.setBounds(23, 151, 32, 15);
        contentPane.add(label_4);

        textField_4 = new JTextField();
        textField_4.setBounds(87, 151, 155, 21);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        JLabel label_5 = new JLabel("部门");
        label_5.setBounds(23, 181, 32, 15);
        contentPane.add(label_5);

        textField_5 = new JTextField();
        textField_5.setBounds(87, 181, 155, 21);
        contentPane.add(textField_5);
        textField_5.setColumns(10);


        //选择框添加内容

        JButton button = new JButton("添加");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(PurchaseFrame.stu==null) {
                    add();
                }else {
                    update();
                }
            }
        });
        button.setBounds(37, 275, 93, 23);
        contentPane.add(button);

        JButton button_1 = new JButton("返回");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //每次返回清空信息
                PurchaseFrame.stu=null;
                //退出
                dispose();
            }
        });
        button_1.setBounds(169, 275, 93, 23);
        contentPane.add(button_1);

        //当点击的行数的信息不为空时，进行下面操作
        if(PurchaseFrame.stu!=null) {
            textField.setText(PurchaseFrame.stu.getName());
            textField_1.setText(PurchaseFrame.stu.getAge()+"");
            textField_3.setText(PurchaseFrame.stu.getGender());
            textField_4.setText(PurchaseFrame.stu.getPostion());
            textField_5.setText(PurchaseFrame.stu.getDepartment());
            button.setText("修改");
        }
    }


    //增加
    private void add() {
        String name=textField.getText();
        String age=textField_1.getText();
        String gender=textField_3.getText();
        String postion = textField_4.getText();
        String department = textField_5.getText();
        int insert = new EmployeeService().insert(new EmployeeModel(name, age, gender, postion, department));
        if(insert==0) {
            JOptionPane.showMessageDialog(null, "添加成功");
            textField.setText("");
            textField_1.setText("");
            textField_3.setText("");
            textField_4.setText("");
            textField_5.setText("");
            return;
        }else {
            JOptionPane.showMessageDialog(null, DateUtil.errors.get(insert));
        }
    }

    //修改
    private void update() {
        String name=textField.getText();
        String age=textField_1.getText();
        String gender=textField_3.getText();
        String postion = textField_4.getText();
        String department = textField_5.getText();
        PurchaseFrame.stu.setName(name);
        PurchaseFrame.stu.setAge(age);
        PurchaseFrame.stu.setGender(gender);
        PurchaseFrame.stu.setPostion(postion);
        PurchaseFrame.stu.setDepartment(department);
        int i = new EmployeeService().update(PurchaseFrame.stu);
        if(i==0) {
            JOptionPane.showMessageDialog(null, "修改成功");
            PurchaseFrame.stu=null;
            textField.setText("");
            textField_1.setText("");
            textField_3.setText("");
            textField_4.setText("");
            textField_5.setText("");
            PurchaseFrame.frame.quaryAll();
            dispose();
            return;
        }else {
            JOptionPane.showMessageDialog(null, DateUtil.errors.get(i));
        }
    }
}
