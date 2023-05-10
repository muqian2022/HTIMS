package pages.normal;

import utils.Tool;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ResultPageOfTutorSelecting extends JFrame {
    public ResultPageOfTutorSelecting(String QuerySQL){
        this.setTitle("家教信息管理系统");
        JPanel root = new JPanel();
        this.setContentPane(root);
        //root.setLayout(null);
        root.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000,400);
        this.setVisible(true);
        this.setLocation(400,400);


        String[] index = {"家教ID","姓名","学科","性别","辅导时间","收费（每小时）","学历背景","电话号码"};
        Object[][] data = Tool.SearchTutor(Tool.letSuitableTutorsIntoArrayList(QuerySQL));

        JTable table;
        DefaultTableModel defaultModel = new DefaultTableModel(data, index);
        table=new JTable(defaultModel);
        table.setFont(new Font("微软雅黑",Font.PLAIN,15));

        // 表格内部单元格居中
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, cr);

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);

        root.add(jScrollPane);


    }
}
