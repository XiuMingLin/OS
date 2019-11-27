package com.os.homework.UI;

import javax.swing.*;
import java.awt.*;

public class UtilInfos extends JPanel {
    JLabel cpuLabel = new JLabel("cpu");
    JLabel IOLabel = new JLabel("进程");
    JLabel timeLabel = new JLabel("当前时间");
    JTextField cpuTF = new JTextField(6);
    JTextField IOTF = new JTextField(6);
    JTextField timeTF = new JTextField(6);

    private static UtilInfos instance;
    public static UtilInfos getInstance(){
        if(instance==null){
            instance = new UtilInfos();
        }
        return instance;
    }
    UtilInfos(){
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        GridBagConstraints gbc =new GridBagConstraints();
        gbc.weightx=0;
        gbc.weighty=0;
        int width=110;
        gbc.gridx=0;
        gbc.gridy=0;
        this.add(Box.createHorizontalStrut(width),gbc);
        gbc.gridx=1;
        this.add(cpuLabel,gbc);
        gbc.gridx=2;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=3;
        this.add(cpuTF,gbc);
        gbc.gridx=4;
        this.add(Box.createHorizontalStrut(width),gbc);
        gbc.gridy=1;
        gbc.gridx=0;
        this.add(Box.createHorizontalStrut(width),gbc);
        gbc.gridx=1;
        this.add(IOLabel,gbc);
        gbc.gridx=2;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=3;
        this.add(IOTF,gbc);
        gbc.gridx=4;
        this.add(Box.createHorizontalStrut(width),gbc);
        gbc.gridy=2;
        gbc.gridx=0;
        this.add(Box.createHorizontalStrut(width),gbc);
        gbc.gridx=1;
        this.add(timeLabel,gbc);
        gbc.gridx=2;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=3;
        this.add(timeTF,gbc);
        gbc.gridx=4;
        this.add(Box.createHorizontalStrut(width),gbc);




        this.setSize(375, 80);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBorder(BorderFactory.createTitledBorder ("运行时间信息"));
    }
}
