package com.xuzhaoju.frame.puchase;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.xuzhaoju.frame.MainFrameOne;
import com.xuzhaoju.frame.login;
import com.xuzhaoju.model.EmployeeModel;
import com.xuzhaoju.service.EmployeeService;
import com.xuzhaoju.util.DateUtil;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PurchaseFrame extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private String[] columnCount= {"序号","姓名","年龄","性别","职位","部门"};
    private List<EmployeeModel> list;
    public static EmployeeModel stu;
    public static PurchaseFrame frame;


    public static void main(String[] args) {
        PurchaseFrame purchaseFrame = new PurchaseFrame();
        purchaseFrame.setVisible(true);
    }
    /**
     * Create the frame.
     */
    public PurchaseFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 760, 369);
        contentPane = new JPanel();
        contentPane.setName("部门管理");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 30, 700, 200);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton button = new JButton("查询");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quaryAll(null);
            }
        });
        button.setBounds(150, 230, 60, 23);
        contentPane.add(button);

        JButton button_1 = new JButton("添加");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddPurchaseFrame().setVisible(true);

            }
        });
        button_1.setBounds(250, 230, 60, 23);
        contentPane.add(button_1);

        JButton button_2 = new JButton("修改");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update();
                quaryAll(null);
            }
        });
        button_2.setBounds(350, 230, 60, 23);
        contentPane.add(button_2);

        JButton button_3 = new JButton("删除");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove();
                quaryAll(null);
            }
        });
        button_3.setBounds(450, 230, 60, 23);
        contentPane.add(button_3);


        JButton button_5 = new JButton("返回");
        button_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrameOne.purchaseFrame.setVisible(false);
                login.mainFrameOne.setVisible(true);
            }
        });
        button_5.setBounds(550, 230, 60, 23);
        contentPane.add(button_5);
    }
    //查询
    public void quaryAll(EmployeeModel model) {
        EmployeeService ss=new EmployeeService();
        list = ss.queryAll(model);
        if(list==null) {
            JOptionPane.showMessageDialog(null, "服务器繁忙");
            return;
        }
        Object[][] data = DateUtil.listToArrayByEmployee(list);
        table.setModel(new DefaultTableModel(data, columnCount));
    }

    //删除
    private void remove() {
        int i = table.getSelectedRow();
        EmployeeModel s = list.get(i);
        int code = new EmployeeService().delete(s.getId());
        if(code==0) {
            JOptionPane.showMessageDialog(null, "删除成功");
            return;
        }else {
            JOptionPane.showMessageDialog(null,DateUtil.errors.get(code) );
        }
        quaryAll(null);
    }

    //修改
    private void update() {
        int i = table.getSelectedRow();
        stu = list.get(i);
        new AddPurchaseFrame().setVisible(true);
    }
}
