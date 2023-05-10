package pages.normal;

import entity.*;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NormalMain extends JFrame{
    public NormalMain(Normal normalObject){
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

        JLabel userNameForDisplay = new JLabel(normalObject.getName()+"，欢迎你！  "+dataStr);
        root.add(userNameForDisplay);
        userNameForDisplay.setBounds(60,60,400,40);
        userNameForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JLabel userInfoForDisplay = new JLabel("性别："+normalObject.getGender() +" | 电话："+normalObject.getPhoneNumber()+"  | 地址："+normalObject.getAddress());
        root.add(userInfoForDisplay);
        userInfoForDisplay.setBounds(60,100,400,40);
        userInfoForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JButton toLookForTutor_Button = new JButton("查找家教");
        root.add(toLookForTutor_Button);
        toLookForTutor_Button.setBounds(80,140,140,30);
        toLookForTutor_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JButton toOrderTutor_Button = new JButton("发起协议");
        root.add(toOrderTutor_Button);
        toOrderTutor_Button.setBounds(240,140,140,30);
        toOrderTutor_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JButton toChangeInfoOfNormal_Button = new JButton("修改信息");
        root.add(toChangeInfoOfNormal_Button);
        toChangeInfoOfNormal_Button.setBounds(80,180,140,30);
        toChangeInfoOfNormal_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JButton toDeleteNormalAccount_Button = new JButton("删除账号");
        root.add(toDeleteNormalAccount_Button);
        toDeleteNormalAccount_Button.setBounds(240,180,140,30);
        toDeleteNormalAccount_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JButton toChangePasswordOfNormal = new JButton("修改密码");
        root.add(toChangePasswordOfNormal);
        toChangePasswordOfNormal.setBounds(80,220,140,30);
        toChangePasswordOfNormal.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JButton toCheckAppointment_Button = new JButton("查看协议");
        root.add(toCheckAppointment_Button);
        toCheckAppointment_Button.setBounds(240,220,140,30);
        toCheckAppointment_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));

        // todo 待完善，如监听器，等等
        // todo 查看协议？？？修改类？修改数据库？
        toLookForTutor_Button.addActionListener(e -> new LookForTutor());

        toOrderTutor_Button.addActionListener(e -> new OrderTutor(normalObject));

        toChangeInfoOfNormal_Button.addActionListener(e -> new NormalChangeInfo(normalObject));

        toDeleteNormalAccount_Button.addActionListener(e -> new DeleteNormalAccount(normalObject));

        toChangePasswordOfNormal.addActionListener(e -> new ChangeNormalPassword(normalObject));

        toCheckAppointment_Button.addActionListener(e -> {
            String SQL = "select * from agreement where normalIdInAgreement = "+normalObject.getNormalId()+";";
            new Appointment(SQL);
        });

    }
}
