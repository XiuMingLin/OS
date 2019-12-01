package com.os.homework.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogList extends JPanel{
    public static LogList _instance;
//    JScrollPane jScrollPane = new JScrollPane();
    TextArea logList = new TextArea("Log:\n",10,40,TextArea.SCROLLBARS_VERTICAL_ONLY);
    JButton resetBtn = new JButton("Reset");
    LogList()
    {
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logList.setText("Log:\n");
            }
        });
        //logList.setSize(750,80);
        //logList.setPreferredSize(new Dimension(200, 100));
        logList.setFont(new Font("宋体",Font.PLAIN,20));
        logList.append("");
        this.add(logList);
        //this.add(Box.createHorizontalStrut(220));
        this.add(resetBtn);
        this.setSize(750, 900);
        logList.setEditable(false);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBorder(BorderFactory.createTitledBorder ("log"));
    }

    public  TextArea getLogList(){
        return logList;
    }

    public static LogList getInstance(){
        if(_instance == null)
            _instance = new LogList();
        return _instance;
    }
}
