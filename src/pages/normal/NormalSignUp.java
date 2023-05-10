package pages.normal;

import utils.Tool;

import javax.swing.*;
import java.awt.*;

public class NormalSignUp extends JFrame {
    public NormalSignUp(){
        this.setTitle("家教信息管理系统");
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
        this.setLocation(400,400);

        JLabel NameForDisplay = new JLabel("你的名字");
        root.add(NameForDisplay);
        NameForDisplay.setBounds(50,50,100,20);
        NameForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField NameTextField = new JTextField();
        root.add(NameTextField);
        NameTextField.setBounds(150,50,200,25);

        JLabel PasswordForDisplay = new JLabel("你的密码");
        root.add(PasswordForDisplay);
        PasswordForDisplay.setBounds(50,80,100,20);
        PasswordForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField PasswordTextField = new JTextField();
        root.add(PasswordTextField);
        PasswordTextField.setBounds(150,80,200,25);

        JLabel GenderForDisplay = new JLabel("你的性别");
        root.add(GenderForDisplay);
        GenderForDisplay.setBounds(50,110,100,20);
        GenderForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JComboBox<String> GenderComboBox = new JComboBox<>();
        root.add(GenderComboBox);
        GenderComboBox.setBounds(150,110,200,25);
        GenderComboBox.setFont(new Font("微软雅黑",Font.PLAIN,15));
        GenderComboBox.addItem("男");
        GenderComboBox.addItem("女");

        JLabel PhoneForDisplay = new JLabel("你的电话");
        root.add(PhoneForDisplay);
        PhoneForDisplay.setBounds(50,140,100,20);
        PhoneForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField PhoneTextField = new JTextField();
        root.add(PhoneTextField);
        PhoneTextField.setBounds(150,140,200,25);

        JLabel AddressForDisplay = new JLabel("你的地址");
        root.add(AddressForDisplay);
        AddressForDisplay.setBounds(50,170,100,20);
        AddressForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField AddressTextField = new JTextField();
        root.add(AddressTextField);
        AddressTextField.setBounds(150,170,200,25);

        JButton buttonToSubmit = new JButton("注册");
        root.add(buttonToSubmit);
        buttonToSubmit.setBounds(100,200,200,25);
        buttonToSubmit.setFont(new Font("微软雅黑",Font.PLAIN,15));

        var secondConfirm = new Object() {
            boolean t = true;
        };
        buttonToSubmit.addActionListener(e -> {
            if (secondConfirm.t){
                Tool.showMessage("注意：请保管好自己的ID和密码。账号一旦创建，将无法修改姓名与性别！再次提交将完成注册！",800);
                secondConfirm.t = false;
            }else {
                int id = Tool.createNewId("normal");
                String SQL = "INSERT INTO ht.normal (normalId, password, name, gender, phoneNumber, address) VALUES ("+id+", '"+PasswordTextField.getText()+
                        "', '"+NameTextField.getText()+"', '"+GenderComboBox.getSelectedItem()+"', '"+PhoneTextField.getText()+"', '"+AddressTextField.getText()+"')";
                System.out.println(SQL);
                Tool.execute(SQL,"注册失败！","注册成功！你的用户ID为 "+id);
                this.dispose();
            }

        });
    }
}
