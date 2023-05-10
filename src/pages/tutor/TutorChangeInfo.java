package pages.tutor;

import entity.Tutor;
import utils.Tool;

import javax.swing.*;
import java.awt.*;

public class TutorChangeInfo extends JFrame {
    public TutorChangeInfo(Tutor tutor){
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

        JLabel name = new JLabel(tutor.getName());
        root.add(name);
        name.setBounds(150,50,200,25);
        name.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JLabel newGenderForDisplay = new JLabel("你的性别");
        root.add(newGenderForDisplay);
        newGenderForDisplay.setBounds(50,80,100,20);
        newGenderForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JLabel gender = new JLabel(tutor.getGender());
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

        JLabel newSubjectForDisplay = new JLabel("新的学科");
        root.add(newSubjectForDisplay);
        newSubjectForDisplay.setBounds(50,140,100,20);
        newSubjectForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JComboBox<String> subjectComboBox = new JComboBox<>();
        root.add(subjectComboBox);
        subjectComboBox.setBounds(150,140,200,25);
        subjectComboBox.setFont(new Font("微软雅黑",Font.PLAIN,15));
        subjectComboBox.addItem("数学");
        subjectComboBox.addItem("物理");
        subjectComboBox.addItem("化学");
        subjectComboBox.addItem("英语");

        JLabel newHourlyWageForDisplay = new JLabel("新的时薪");
        root.add(newHourlyWageForDisplay);
        newHourlyWageForDisplay.setBounds(50,170,100,20);
        newHourlyWageForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField newHWTextField = new JTextField();
        root.add(newHWTextField);
        newHWTextField.setBounds(150,170,200,25);

        JLabel newBackgroundForDisplay = new JLabel("新的学历");
        root.add(newBackgroundForDisplay);
        newBackgroundForDisplay.setBounds(50,200,100,20);
        newBackgroundForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JComboBox<String> backgroundComboBox = new JComboBox<>();
        root.add(backgroundComboBox);
        backgroundComboBox.setBounds(150,200,200,25);
        backgroundComboBox.setFont(new Font("微软雅黑",Font.PLAIN,15));
        backgroundComboBox.addItem("大学本科在读");
        backgroundComboBox.addItem("大学生（本科）");
        backgroundComboBox.addItem("大学生（硕士）");
        backgroundComboBox.addItem("教师（高中）");

        JLabel newFTForDisplay = new JLabel("辅导时间");
        root.add(newFTForDisplay);
        newFTForDisplay.setBounds(50,230,100,20);
        newFTForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JComboBox<String> newFTTextField = new JComboBox<>();
        root.add(newFTTextField);
        newFTTextField.setBounds(150,230,200,25);
        newFTTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
        newFTTextField.addItem("8:00-10:00");
        newFTTextField.addItem("11:00-13:00");
        newFTTextField.addItem("14:00-16:00");
        newFTTextField.addItem("17:00-19:00");
        newFTTextField.addItem("20:00-22:00");

        JButton buttonToSubmit = new JButton("提交");
        root.add(buttonToSubmit);
        buttonToSubmit.setBounds(100,260,200,25);
        buttonToSubmit.setFont(new Font("微软雅黑",Font.PLAIN,15));

        buttonToSubmit.addActionListener(e -> {
            String SQL = "UPDATE ht.tutor t SET t.phoneNumber = '"+newPhoneTextField.getText()+"', t.subject = '"+subjectComboBox.getSelectedItem()+"', t.hourlyWage = "+Integer.parseInt(newHWTextField.getText())+
                    ", t.freeTime = '"+newFTTextField.getSelectedItem()+"', t.background = '"+backgroundComboBox.getSelectedItem()+"' WHERE t.tutorId = "+tutor.getTutorId()+";";
            System.out.println(SQL);
            Tool.execute(SQL,"修改失败！","信息修改成功！重新登陆后你主页显示的信息将会更改！");
            this.dispose();
        });
    }
}
