package pages.tutor;

import entity.Tutor;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TutorMain extends JFrame {
    public TutorMain(Tutor tutorObject){
        this.setTitle("家教信息管理系统");
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,400);
        this.setVisible(true);

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
        Date date = new Date(System.currentTimeMillis());
        // System.out.println();
        String dataStr ="今天是" + formatter.format(date)+"！";

        JLabel userNameForDisplay = new JLabel(tutorObject.getName()+"，欢迎你！  "+dataStr);
        root.add(userNameForDisplay);
        userNameForDisplay.setBounds(60,60,400,40);
        userNameForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JLabel userInfoForDisplay = new JLabel("性别："+tutorObject.getGender() +" | 电话："+tutorObject.getPhoneNumber()+"  | 科目："+tutorObject.getSubject());
        root.add(userInfoForDisplay);
        userInfoForDisplay.setBounds(60,100,400,40);
        userInfoForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JButton toCheckAppointment_Button = new JButton("查看协议");
        root.add(toCheckAppointment_Button);
        toCheckAppointment_Button.setBounds(80,140,140,30);
        toCheckAppointment_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JButton toCancelAppointment_Button = new JButton("解除协议");
        root.add(toCancelAppointment_Button);
        toCancelAppointment_Button.setBounds(240,140,140,30);
        toCancelAppointment_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JButton toChangeInfoOfTutor_Button = new JButton("修改信息");
        root.add(toChangeInfoOfTutor_Button);
        toChangeInfoOfTutor_Button.setBounds(80,180,140,30);
        toChangeInfoOfTutor_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JButton toDeleteTutorAccount_Button = new JButton("删除账号");
        root.add(toDeleteTutorAccount_Button);
        toDeleteTutorAccount_Button.setBounds(240,180,140,30);
        toDeleteTutorAccount_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JButton toChangePasswordOfTutor = new JButton("修改密码");
        root.add(toChangePasswordOfTutor);
        toChangePasswordOfTutor.setBounds(80,220,140,30);
        toChangePasswordOfTutor.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JButton agreementEnd = new JButton("完成协议");
        root.add(agreementEnd);
        agreementEnd.setBounds(240,220,140,30);
        agreementEnd.setFont(new Font("微软雅黑",Font.PLAIN,15));

        toCheckAppointment_Button.addActionListener(e -> {
            String SQL = "select * from agreement where tutorIdInAgreement = "+tutorObject.getTutorId()+";";
            System.out.println(SQL);
            new DisplayAppointment(SQL);
        });

        toCancelAppointment_Button.addActionListener(e -> new CancelAgreement());

        toChangePasswordOfTutor.addActionListener(e -> new ChangeTutorPassword(tutorObject));

        toChangeInfoOfTutor_Button.addActionListener(e -> new TutorChangeInfo(tutorObject));

        toDeleteTutorAccount_Button.addActionListener(e -> new DeleteTutorAccount(tutorObject));

        agreementEnd.addActionListener(e -> new EndAgreement());

    }
}
