package pages.tutor;

import utils.Tool;

import javax.swing.*;
import java.awt.*;

public class TutorSignUp extends JFrame {
    public TutorSignUp(){
        this.setTitle("家教信息管理系统");
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
        this.setLocation(400,400);

        // 修改信息改的注册页面
        JLabel newNameForDisplay = new JLabel("你的名字");
        root.add(newNameForDisplay);
        newNameForDisplay.setBounds(50,50,100,20);
        newNameForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField newNameTextField = new JTextField();
        root.add(newNameTextField);
        newNameTextField.setBounds(150,50,200,25);

        JLabel newPasswordForDisplay = new JLabel("你的密码");
        root.add(newPasswordForDisplay);
        newPasswordForDisplay.setBounds(50,80,100,20);
        newPasswordForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField newPasswordTextField = new JTextField();
        root.add(newPasswordTextField);
        newPasswordTextField.setBounds(150,80,200,25);

        // 设置

        JLabel newGenderForDisplay = new JLabel("你的性别");
        root.add(newGenderForDisplay);
        newGenderForDisplay.setBounds(50,110,100,20);
        newGenderForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JComboBox<String> newGenderComboBox = new JComboBox<>();
        root.add(newGenderComboBox);
        newGenderComboBox.setBounds(150,110,200,25);
        newGenderComboBox.setFont(new Font("微软雅黑",Font.PLAIN,15));
        newGenderComboBox.addItem("男");
        newGenderComboBox.addItem("女");

        JLabel newPhoneForDisplay = new JLabel("你的电话");
        root.add(newPhoneForDisplay);
        newPhoneForDisplay.setBounds(50,140,100,20);
        newPhoneForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField newPhoneTextField = new JTextField();
        root.add(newPhoneTextField);
        newPhoneTextField.setBounds(150,140,200,25);

        JLabel newSubjectForDisplay = new JLabel("所教学科");
        root.add(newSubjectForDisplay);
        newSubjectForDisplay.setBounds(50,170,100,20);
        newSubjectForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JComboBox<String> subjectComboBox = new JComboBox<>();
        root.add(subjectComboBox);
        subjectComboBox.setBounds(150,170,200,25);
        subjectComboBox.setFont(new Font("微软雅黑",Font.PLAIN,15));
        subjectComboBox.addItem("数学");
        subjectComboBox.addItem("物理");
        subjectComboBox.addItem("化学");
        subjectComboBox.addItem("英语");

        JLabel newHourlyWageForDisplay = new JLabel("你的时薪");
        root.add(newHourlyWageForDisplay);
        newHourlyWageForDisplay.setBounds(50,200,100,20);
        newHourlyWageForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField newHWTextField = new JTextField();
        root.add(newHWTextField);
        newHWTextField.setBounds(150,200,200,25);

        JLabel backgroundForDisplay = new JLabel("你的学历");
        root.add(backgroundForDisplay);
        backgroundForDisplay.setBounds(50,230,100,20);
        backgroundForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JComboBox<String> backgroundComboBox = new JComboBox<>();
        root.add(backgroundComboBox);
        backgroundComboBox.setBounds(150,230,200,25);
        backgroundComboBox.setFont(new Font("微软雅黑",Font.PLAIN,15));
        backgroundComboBox.addItem("大学本科在读");
        backgroundComboBox.addItem("大学生（本科）");
        backgroundComboBox.addItem("大学生（硕士）");
        backgroundComboBox.addItem("教师（高中）");

        JLabel newFTForDisplay = new JLabel("辅导时间");
        root.add(newFTForDisplay);
        newFTForDisplay.setBounds(50,260,100,20);
        newFTForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JComboBox<String> newFTTextField = new JComboBox<>();
        root.add(newFTTextField);
        newFTTextField.setBounds(150,260,200,25);
        newFTTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
        newFTTextField.addItem("8:00-10:00");
        newFTTextField.addItem("11:00-13:00");
        newFTTextField.addItem("14:00-16:00");
        newFTTextField.addItem("17:00-19:00");
        newFTTextField.addItem("20:00-22:00");

        JButton buttonToSubmit = new JButton("注册");
        root.add(buttonToSubmit);
        buttonToSubmit.setBounds(100,290,200,25);
        buttonToSubmit.setFont(new Font("微软雅黑",Font.PLAIN,15));

        var secondConfirm = new Object() {
            boolean t = true;
        };
        buttonToSubmit.addActionListener(e -> {
            if (secondConfirm.t){
                Tool.showMessage("注意：请保管好自己的ID和密码。账号一旦创建，将无法修改姓名与性别！再次提交将完成注册！",800);
                secondConfirm.t = false;
            }else {
                int id = Tool.createNewId("tutor");
                String SQL = "INSERT INTO ht.tutor (tutorId, password, name, gender, phoneNumber, subject, hourlyWage, freeTime, background) VALUES ("+id+", '"+
                        newPasswordTextField.getText()+"', '"+newNameTextField.getText()+"', '"+newGenderComboBox.getSelectedItem()+"', '"+newPhoneTextField.getText()+
                        "', '"+subjectComboBox.getSelectedItem()+"', "+Integer.parseInt(newHWTextField.getText())+", '"+newFTTextField.getSelectedItem()
                        +"', '"+backgroundComboBox.getSelectedItem()+"');";
                System.out.println(SQL);
                Tool.execute(SQL,"注册失败！","注册成功！你的用户ID为 "+id);
                this.dispose();
            }
        });

    }
}
