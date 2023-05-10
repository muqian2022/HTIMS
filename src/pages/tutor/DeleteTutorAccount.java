package pages.tutor;

import entity.Tutor;
import utils.Tool;

import javax.swing.*;
import java.awt.*;

public class DeleteTutorAccount extends JFrame {
    public DeleteTutorAccount(Tutor tutor){
        this.setTitle("家教信息管理系统");
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(650,200);
        this.setVisible(true);
        this.setLocation(400,400);

        JLabel deleteConfirm_Label = new JLabel("你确定删除你的账户吗？如果是，请输入“我确定”。删除账户后，程序将退出。");
        root.add(deleteConfirm_Label);
        deleteConfirm_Label.setBounds(50,50,550,20);
        deleteConfirm_Label.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JTextField deleteConfirm = new JTextField();
        root.add(deleteConfirm);
        deleteConfirm.setBounds(50,80,200,25);

        JButton confirm = new JButton("确定");
        root.add(confirm);
        confirm.setBounds(260,80,100,25);
        confirm.setFont(new Font("微软雅黑",Font.PLAIN,15));

        confirm.addActionListener(e -> {
            if (deleteConfirm.getText().equals("我确定")){
                String SQL = "DELETE FROM ht.tutor WHERE tutorId = "+tutor.getTutorId()+";";
                Tool.execute(SQL,"删除失败！","删除成功！");
                // Tool.showMessage("删除成功！");
                System.exit(0);
            }else {
                Tool.showMessage("你必须输入“我确定”才能删除账号！");
            }
        });
    }
}
