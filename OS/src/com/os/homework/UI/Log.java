package com.os.homework.UI;

import javax.swing.*;
import java.awt.*;

public class Log extends JPanel{
    private static Log instance;
//    JScrollPane jScrollPane = new JScrollPane();
    TextArea logList = new TextArea("log:",16,40,TextArea.SCROLLBARS_VERTICAL_ONLY);
    Log()
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

    public static Log getInstance(){
        if(instance == null)
            instance = new Log();
        return instance;
    }
}
