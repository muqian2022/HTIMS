package pages.tutor;

import utils.Tool;

import javax.swing.*;
import java.awt.*;

public class EndAgreement extends JFrame {
    public EndAgreement(){
        this.setTitle("家教信息管理系统");
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(450,400);
        this.setVisible(true);
        this.setLocation(400,400);

        JLabel label_AgreementId = new JLabel("请输入你的协议号：");
        root.add(label_AgreementId);
        label_AgreementId.setBounds(50,50,550,20);
        label_AgreementId.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField agreementId_ = new JTextField();
        root.add(agreementId_);
        agreementId_.setBounds(50,80,200,25);

        JLabel label_totalFee = new JLabel("请输入本次家教的全部费用：");
        root.add(label_totalFee);
        label_totalFee.setBounds(50,110,550,20);
        label_totalFee.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField totalFee_ = new JTextField();
        root.add(totalFee_);
        totalFee_.setBounds(50,140,200,25);

        JButton confirm = new JButton("确定");
        root.add(confirm);
        confirm.setBounds(260,170,100,25);
        confirm.setFont(new Font("微软雅黑",Font.PLAIN,15));

        confirm.addActionListener(e -> {
            String SQL = "UPDATE ht.agreement t SET t.totalFee = '"+Integer.parseInt(totalFee_.getText())+"' WHERE t.agreementId = "+Integer.parseInt(agreementId_.getText())+";";
            System.out.println(SQL);
            Tool.execute(SQL,"对协议的完成操作失败！","协议完成！");
            // Tool.showMessage("协议完成！");
            this.dispose();
        });
    }
}
