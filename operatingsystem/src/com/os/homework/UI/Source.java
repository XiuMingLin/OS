package com.os.homework.UI;

import javax.swing.*;
import java.awt.*;

public class Source extends JPanel {
    JLabel source1Label = new JLabel("使用资源1的进程");
    JLabel source2Label = new JLabel("使用资源2的进程");
    JTextField source1TF = new JTextField(3);
    JTextField source2TF = new JTextField(3);
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
        this.add(Box.createHorizontalStrut(70),gbc);
        gbc.gridx=1;
        this.add(source1Label,gbc);
        gbc.gridx=2;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=3;
        this.add(source1TF,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        this.add(Box.createHorizontalStrut(70),gbc);
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
}
