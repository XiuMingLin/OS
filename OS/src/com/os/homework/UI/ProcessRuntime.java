package com.os.homework.UI;

import javax.swing.*;
import java.awt.*;

public class ProcessRuntime extends JPanel {
    JLabel process1Label = new JLabel("进程1运行时间");
    JLabel process2Label = new JLabel("进程2运行时间");
    JLabel process3Label = new JLabel("进程3运行时间");
    static JTextField process1TF = new JTextField(6);
    static JTextField process2TF = new JTextField(6);
    static JTextField process3TF = new JTextField(6);

    private static ProcessRuntime instance;
    public static ProcessRuntime getInstance(){
        if(instance == null){
            instance = new ProcessRuntime();
        }
        return instance;
    }
    ProcessRuntime(){
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        GridBagConstraints gbc =new GridBagConstraints();
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.gridx=0;
        gbc.gridy=0;
        int width=100;
        this.add(Box.createHorizontalStrut(width),gbc);
        gbc.gridx=1;
        this.add(process1Label,gbc);
        gbc.gridx=2;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=3;
        this.add(process1TF,gbc);
        gbc.gridx=4;
        this.add(Box.createHorizontalStrut(width),gbc);
        gbc.gridy=1;
        gbc.gridx=0;
        this.add(Box.createHorizontalStrut(width),gbc);
        gbc.gridx=1;
        this.add(process2Label,gbc);
        gbc.gridx=2;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=3;
        this.add(process2TF,gbc);
        gbc.gridx=4;
        this.add(Box.createHorizontalStrut(width),gbc);
        gbc.gridy=2;
        gbc.gridx=0;
        this.add(Box.createHorizontalStrut(width),gbc);
        gbc.gridx=1;
        this.add(process3Label,gbc);
        gbc.gridx=2;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=3;
        this.add(process3TF,gbc);
        gbc.gridx=4;
        this.add(Box.createHorizontalStrut(width),gbc);




        this.setSize(375, 80);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBorder(BorderFactory.createTitledBorder ("进程运行时间"));
    }

    public static void UpdateTime()
    {
        process1TF.setText(String.valueOf(UI.tr.getProcess1().getRuntime()));
        process2TF.setText(String.valueOf(UI.tr.getProcess2().getRuntime()));
        process3TF.setText(String.valueOf(UI.tr.getProcess3().getRuntime()));
    }
}
