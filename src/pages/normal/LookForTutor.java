package pages.normal;

import javax.swing.*;
import java.awt.*;

public class LookForTutor extends JFrame {
    public LookForTutor(){
        this.setTitle("家教信息管理系统");
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
        this.setLocation(700,400);

        JLabel subjectLabelForDisplay = new JLabel("科目");
        root.add(subjectLabelForDisplay);
        subjectLabelForDisplay.setBounds(50,50,100,20);
        subjectLabelForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JComboBox<String> toSelectSubject = new JComboBox<>();
        root.add(toSelectSubject);
        toSelectSubject.setBounds(150,50,100,20);
        toSelectSubject.addItem("数学");
        toSelectSubject.addItem("物理");
        toSelectSubject.addItem("化学");
        toSelectSubject.addItem("英语");

        JLabel genderLabelForDisplay = new JLabel("性别");
        root.add(genderLabelForDisplay);
        genderLabelForDisplay.setBounds(50,80,100,20);
        genderLabelForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JComboBox<String> toSelectGender = new JComboBox<>();
        root.add(toSelectGender);
        toSelectGender.setBounds(150,80,100,20);
        toSelectGender.addItem("男");
        toSelectGender.addItem("女");

        JLabel freeTimeLabelForDisplay = new JLabel("辅导时间");
        root.add(freeTimeLabelForDisplay);
        freeTimeLabelForDisplay.setBounds(50,110,100,20);
        freeTimeLabelForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JComboBox<String> toSelectFreeTime = new JComboBox<>();
        root.add(toSelectFreeTime);
        toSelectFreeTime.setBounds(150,110,100,20);
        toSelectFreeTime.addItem("8:00-10:00");
        toSelectFreeTime.addItem("11:00-13:00");
        toSelectFreeTime.addItem("14:00-16:00");
        toSelectFreeTime.addItem("17:00-19:00");
        toSelectFreeTime.addItem("20:00-22:00");

        JLabel backgroundForDisplay = new JLabel("学历背景");
        root.add(backgroundForDisplay);
        backgroundForDisplay.setBounds(50,140,100,20);
        backgroundForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JComboBox<String> toSelectBackground = new JComboBox<>();
        root.add(toSelectBackground);
        toSelectBackground.setBounds(150,140,100,20);
        toSelectBackground.addItem("大学本科在读");
        toSelectBackground.addItem("大学生（本科）");
        toSelectBackground.addItem("大学生（硕士）");
        toSelectBackground.addItem("教师（高中）");

        JButton toSelectTutor_Button = new JButton("查找");
        root.add(toSelectTutor_Button);
        toSelectTutor_Button.setBounds(120,180,100,20);
        toSelectTutor_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));

        toSelectTutor_Button.addActionListener(e -> {
            String QuerySQL = "select * from tutor where gender = '"+toSelectGender.getSelectedItem()+"' and subject = '"+
                    toSelectSubject.getSelectedItem()+"' and freeTime = '"+toSelectFreeTime.getSelectedItem()+"' and background = '"+
                    toSelectBackground.getSelectedItem()+"';";
            System.out.println(QuerySQL);
            new ResultPageOfTutorSelecting(QuerySQL);
        });


    }
}
