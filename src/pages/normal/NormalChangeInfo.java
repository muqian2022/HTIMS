package pages.normal;

import entity.Normal;
import utils.Tool;

import javax.swing.*;
import java.awt.*;

public class NormalChangeInfo extends JFrame {
    public NormalChangeInfo(Normal normal){
        this.setTitle("家教信息管理系统");
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
        this.setLocation(400,400);

        JLabel newNameForDisplay = new JLabel("你的名字");
        root.add(newNameForDisplay);
        newNameForDisplay.setBounds(50,50,100,20);
        newNameForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JLabel name = new JLabel(normal.getName());
        root.add(name);
        name.setBounds(150,50,200,25);
        name.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JLabel newGenderForDisplay = new JLabel("你的性别");
        root.add(newGenderForDisplay);
        newGenderForDisplay.setBounds(50,80,100,20);
        newGenderForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JLabel gender = new JLabel(normal.getGender());
        root.add(gender);
        gender.setBounds(150,80,200,25);
        gender.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JLabel newPhoneForDisplay = new JLabel("新的电话");
        root.add(newPhoneForDisplay);
        newPhoneForDisplay.setBounds(50,110,100,20);
        newPhoneForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField newPhoneTextField = new JTextField();
        root.add(newPhoneTextField);
        newPhoneTextField.setBounds(150,110,200,25);

        JLabel newAddressForDisplay = new JLabel("新的地址");
        root.add(newAddressForDisplay);
        newAddressForDisplay.setBounds(50,140,100,20);
        newAddressForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField newAddressTextField = new JTextField();
        root.add(newAddressTextField);
        newAddressTextField.setBounds(150,140,200,25);

        JButton buttonToSubmit = new JButton("提交");
        root.add(buttonToSubmit);
        buttonToSubmit.setBounds(100,170,200,25);
        buttonToSubmit.setFont(new Font("微软雅黑",Font.PLAIN,15));

        buttonToSubmit.addActionListener(e -> {
            String SQL = "UPDATE ht.normal t SET t.phoneNumber = '"+newPhoneTextField.getText()+"', t.address = '"+newAddressTextField.getText()+"' WHERE t.normalId = "+normal.getNormalId()+";";
            Tool.execute(SQL,"修改失败！","信息修改成功！重新登陆后你主页显示的信息将会更改！");
            this.dispose();
        });



    }
}
