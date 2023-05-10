package pages.normal;

import entity.Normal;
import utils.Tool;

import javax.swing.*;
import java.awt.*;

public class ChangeNormalPassword extends JFrame {
    public ChangeNormalPassword(Normal normal){
        this.setTitle("家教信息管理系统");
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(420,200);
        this.setVisible(true);
        this.setLocation(400,400);

        JLabel newPassword_Label = new JLabel("请输入你的新密码！");
        root.add(newPassword_Label);
        newPassword_Label.setBounds(50,50,550,20);
        newPassword_Label.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField newPassword = new JTextField();
        root.add(newPassword);
        newPassword.setBounds(50,80,200,25);

        JButton confirm = new JButton("确定");
        root.add(confirm);
        confirm.setBounds(260,80,100,25);
        confirm.setFont(new Font("微软雅黑",Font.PLAIN,15));

        confirm.addActionListener(e -> {
            String SQL = "UPDATE ht.normal t SET t.password = '"+newPassword.getText()+"' WHERE t.normalId = "+normal.getNormalId()+";";
            // System.out.println(SQL);
            Tool.execute(SQL,"密码修改失败！","密码修改成功！");
            //Tool.showMessage("密码修改成功！");
            this.dispose();
        });
    }
}
