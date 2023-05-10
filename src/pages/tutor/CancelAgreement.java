package pages.tutor;

import utils.Tool;

import javax.swing.*;
import java.awt.*;

public class CancelAgreement extends JFrame {
    public CancelAgreement(){
        this.setTitle("家教信息管理系统");
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400,300);
        this.setVisible(true);
        this.setLocation(700,400);

        JLabel pleaseInputForDisplay = new JLabel("请输入需要解除的协议号：");
        root.add(pleaseInputForDisplay);
        pleaseInputForDisplay.setBounds(20,20,200,40);
        pleaseInputForDisplay.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField inputAgreementId = new JTextField();
        root.add(inputAgreementId);
        inputAgreementId.setBounds(20,70,200,40);

        JButton CancelAgreement_Button = new JButton("解除");
        root.add(CancelAgreement_Button);
        CancelAgreement_Button.setBounds(230,70,80,40);
        CancelAgreement_Button.setFont(new Font("微软雅黑",Font.PLAIN,15));

        CancelAgreement_Button.addActionListener(e -> {
            if (Tool.notExists(Integer.parseInt(inputAgreementId.getText()),"agreement")){
                Tool.showMessage("未找到相应的协议！");
            }else {
                String SQL = "DELETE FROM ht.agreement WHERE agreementId = "+Integer.parseInt(inputAgreementId.getText())+";";
                System.out.println(SQL);
                Tool.execute(SQL,"协议取消失败","协议取消成功！");
            }
        });
    }
}
