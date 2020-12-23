package com.xuzhaoju.frame;

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

import com.xuzhaoju.frame.puchase.PurchaseFrame;
import com.xuzhaoju.model.EmployeeModel;
import com.xuzhaoju.model.Student;
import com.xuzhaoju.service.EmployeeService;
import com.xuzhaoju.service.StudentService;
import com.xuzhaoju.util.DateUtil;

public class FromFjame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public static EmployeeModel stu;
	public static FromFjame frame;



	public FromFjame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 314, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("添加书籍");
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		label.setBounds(118, 20, 78, 39);
		contentPane.add(label);

		JLabel label_1 = new JLabel("书名");
		label_1.setBounds(23, 71, 40, 15);
		contentPane.add(label_1);

		textField = new JTextField();
		textField.setBounds(87, 68, 155, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label_2 = new JLabel("价格");
		label_2.setBounds(23, 128, 40, 15);
		contentPane.add(label_2);

		textField_1 = new JTextField();
		textField_1.setBounds(87, 125, 155, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_3 = new JLabel("作者");
		label_3.setBounds(23, 190, 32, 15);
		contentPane.add(label_3);

		textField_3 = new JTextField();
		textField_3.setBounds(87, 190, 155, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);


		//选择框添加内容
//		addBirth();

		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(FromFjame.stu==null) {
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
				FromFjame.stu=null;
				//退出
				dispose();
			}
		});
		button_1.setBounds(169, 275, 93, 23);
		contentPane.add(button_1);

		//当点击的行数的信息不为空时，进行下面操作
		if(FromFjame.stu!=null) {
			textField.setText(FromFjame.stu.getName());
			textField_1.setText(FromFjame.stu.getAge()+"");
			textField_3.setText(FromFjame.stu.getGender());
			textField_4.setText(FromFjame.stu.getGender());
			textField_5.setText(FromFjame.stu.getGender());
			button.setText("修改");
		}
	}

	//增加
	private void add() {
		String name=textField.getText();
		String strSouce=textField_1.getText();
		String city=textField_3.getText();
		Student s=new Student(name,Double.parseDouble(strSouce),null,city);
		int insert = new StudentService().insert(s);
		if(insert==0) {
			JOptionPane.showMessageDialog(null, "添加成功");
			textField.setText("");
			textField_1.setText("");
			textField_3.setText("");
			return;
		}else {
			JOptionPane.showMessageDialog(null, DateUtil.errors.get(insert));
		}
	}

	//修改
	private void update() {
		String name=textField.getText();
		String age =textField_1.getText();
		String gender =textField_3.getText();
		String postion =textField_4.getText();
		String department =textField_5.getText();

		FromFjame.stu.setName(name);
		FromFjame.stu.setAge(age);
		FromFjame.stu.setGender(gender);
		FromFjame.stu.setPostion(postion);
		FromFjame.stu.setDepartment(department);

		int i = new EmployeeService().update(FromFjame.stu);
		if(i==0) {
			JOptionPane.showMessageDialog(null, "修改成功");
			FromFjame.stu=null;
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
