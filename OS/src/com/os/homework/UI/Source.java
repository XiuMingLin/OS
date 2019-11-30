package com.os.homework.UI;

import com.os.homework.process;

import javax.swing.*;
import java.awt.*;

public class Source extends JPanel {
    JLabel source1Label = new JLabel("使用资源1的进程");
    JLabel source2Label = new JLabel("使用资源2的进程");
    static JTextField source1TF = new JTextField(6);
    static JTextField source2TF = new JTextField(6);
    private static Source instance;
    public static Source getInstance(){
        if(instance==null){
            instance = new Source();
        }
        return instance;
    }
    Source(){
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        GridBagConstraints gbc =new GridBagConstraints();
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.gridx=0;
        gbc.gridy=0;
        this.add(Box.createHorizontalStrut(10),gbc);
        gbc.gridx=1;
        this.add(source1Label,gbc);
        gbc.gridx=2;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=3;
        this.add(source1TF,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        this.add(Box.createHorizontalStrut(10),gbc);
        gbc.gridx=1;
        this.add(source2Label,gbc);
        gbc.gridx=2;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=3;
        this.add(source2TF,gbc);


        this.setSize(750, 80);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBorder(BorderFactory.createTitledBorder ("资源使用情况"));
    }

    public static void UpdateSouce(int index, process pro)
    {
        switch (index) {
            case 1:
                source1TF.setText(pro.getPro_name());break;
            case 2:
                source2TF.setText(pro.getPro_name());break;
            case 3:
            {
                source1TF.setText(pro.getPro_name());
                source2TF.setText(pro.getPro_name());break;
            }
        }
    }

    public static void resetSource()
    {
        source1TF.setText("");
        source2TF.setText("");
    }
}
