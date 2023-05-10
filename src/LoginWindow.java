import entity.*;
import pages.normal.NormalMain;
import pages.normal.NormalSignUp;
import pages.tutor.TutorMain;
import pages.tutor.TutorSignUp;
import utils.*;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame{
    public LoginWindow() {
        this.setTitle("家教信息管理系统");
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(570,600);
        this.setVisible(true);

        JLabel textAccount = new JLabel("账号：");
        root.add(textAccount);
        textAccount.setFont(new Font("微软雅黑",Font.PLAIN,25));
        textAccount.setBounds(80,60,75,40);

        JTextField inputAccount = new JTextField();
        root.add(inputAccount);
        inputAccount.setBounds(160,60,300,40);

        JLabel textPassword = new JLabel("密码：");
        root.add(textPassword);
        textPassword.setFont(new Font("微软雅黑",Font.PLAIN,25));
        textPassword.setBounds(80,110,75,40);

        JTextField inputPassword = new JTextField();
        root.add(inputPassword);
        inputPassword.setBounds(160,110,300,40);


        JCheckBox normal = new JCheckBox("普通用户");
        root.add(normal);
        normal.setBounds(80,160,100,30);
        normal.setSelected(true);

        JCheckBox tutor = new JCheckBox("家庭教师");
        root.add(tutor);
        tutor.setBounds(200,160,100,30);


        JCheckBox agreement = new JCheckBox("我已阅读并同意本系统的使用协议");
        root.add(agreement);
        agreement.setBounds(80,200,250,30);


        JButton submit = new JButton("登录");
        root.add(submit);
        submit.setBounds(355,200,100,30);
        submit.setEnabled(false);
        submit.setFont(new Font("微软雅黑",Font.PLAIN,15));


        JButton signUpForNormal = new JButton("以普通身份注册");
        root.add(signUpForNormal);
        signUpForNormal.setBounds(80,240,184,30);
        signUpForNormal.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JButton signUpForTutor = new JButton("以家教身份注册");
        root.add(signUpForTutor);
        signUpForTutor.setBounds(280,240,184,30);
        signUpForTutor.setFont(new Font("微软雅黑",Font.PLAIN,15));


        agreement.addActionListener(e -> submit.setEnabled(agreement.isSelected()));

        normal.addActionListener(e -> {
            normal.setSelected(true);
            tutor.setSelected(false);
        });
        tutor.addActionListener(e -> {
            tutor.setSelected(true);
            normal.setSelected(false);
        });

        submit.addActionListener(e -> {
            if (normal.isSelected()){
                Normal normalObjectForLogin = Tool.normalLogin(inputAccount.getText(), inputPassword.getText());
                System.out.println(normalObjectForLogin.getNormalId());
                System.out.println(normalObjectForLogin.getName());

                JFrame normalMain = new NormalMain(normalObjectForLogin);
                Tool.showMessage("登录成功！");
            }
            if (tutor.isSelected()){
                // todo
                Tutor tutorObjectForLogin = Tool.tutorLogin(inputAccount.getText(), inputPassword.getText());
                System.out.println(tutorObjectForLogin.getTutorId());
                System.out.println(tutorObjectForLogin.getName());

                JFrame tutorMain = new TutorMain(tutorObjectForLogin);
                Tool.showMessage("登录成功！");
            }
            this.dispose();
            // todo tutor 设计尚未实现。。。
            // todo 两个注册按钮没写
        });

        // todo 更广泛的细节优化
        var secondConfirm = new Object() {
            boolean t = true;
        };
        signUpForNormal.addActionListener(e -> new NormalSignUp());
        signUpForTutor.addActionListener(e -> new TutorSignUp());

    }
}
