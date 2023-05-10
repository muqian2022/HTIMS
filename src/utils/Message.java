package utils;

import javax.swing.*;
import java.awt.*;

public class Message extends JFrame {
    public Message(String message, int width){
        this.setTitle("提醒");
        JPanel root = new JPanel();
        this.setContentPane(root);
        root.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(width,200);
        this.setVisible(true);
        this.setLocation(500,400);

        JLabel messageLabel = new JLabel(message);
        root.add(messageLabel);
        messageLabel.setBounds(20,20,800,40);
        messageLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));

        JButton clinkToClose = new JButton("确定");
        root.add(clinkToClose);
        clinkToClose.setBounds((width/2-40),100,80,40);
        clinkToClose.setFont(new Font("微软雅黑",Font.PLAIN,15));

        clinkToClose.addActionListener(e -> this.dispose());
    }
}
