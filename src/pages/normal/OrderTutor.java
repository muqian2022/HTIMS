package pages.normal;

import entity.Normal;
import utils.Tool;

import javax.swing.*;
import java.awt.*;

public class OrderTutor extends JFrame {
    public OrderTutor(Normal normal){
        this.setTitle("家教信息管理系统");
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
        this.setLocation(700,400);

        JLabel pleaseInputForDisplay = new JLabel("请输入签订协议的家教ID：");
        root.add(pleaseInputForDisplay);
        pleaseInputForDisplay.setBounds(20,20,200,40);
        pleaseInputForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField inputTutorId = new JTextField();
        root.add(inputTutorId);
        inputTutorId.setBounds(20,70,200,40);

        JButton OrderTutor_Button = new JButton("预约");
        root.add(OrderTutor_Button);
        OrderTutor_Button.setBounds(230,70,80,40);
        OrderTutor_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));

        OrderTutor_Button.addActionListener(e -> {
            String SQL = "select * from tutor where tutorId = "+Integer.parseInt(inputTutorId.getText())+";";
            System.out.println(SQL);
            Tool.OrderTutor(normal,SQL);
            Tool.showMessage("协议签订成功");
        });
    }
}
