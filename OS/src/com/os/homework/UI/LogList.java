package com.os.homework.UI;

import javax.swing.*;
import java.awt.*;

public class LogList extends JPanel{
    public static LogList _instance;
//    JScrollPane jScrollPane = new JScrollPane();
    TextArea logList = new TextArea("Log:\n",16,40,TextArea.SCROLLBARS_VERTICAL_ONLY);
    LogList()
    {
        //logList.setSize(750,80);
        //logList.setPreferredSize(new Dimension(200, 100));
        logList.setFont(new Font("宋体",Font.PLAIN,20));
        logList.append("");
        this.add(logList);
        //this.add(Box.createHorizontalStrut(220));
        this.setSize(750, 800);
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
