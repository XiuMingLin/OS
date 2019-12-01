package com.os.homework.UI;

import com.os.homework.process;
import com.os.homework.timearound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UtilInfos extends JPanel {
    JLabel cpuLabel = new JLabel("cpu");
    JLabel IOLabel = new JLabel("IO");
    JLabel timeLabel = new JLabel("当前时间");
    JButton resetBtn = new JButton("重置");
    JButton stopBtn = new JButton("停止");
    static JTextField cpuTF = new JTextField(6);
    static JTextField IOTF = new JTextField(6);
    static JTextField timeTF = new JTextField(6);

    private static UtilInfos instance;
    public static UtilInfos getInstance(){
        if(instance==null){
            instance = new UtilInfos();
        }
        return instance;
    }
    UtilInfos(){
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timearound.instance.timer != null) {
                    timearound.instance.timer.cancel();
                    cpuTF.setText("");
                    IOTF.setText("");
                    timeTF.setText("");
                    ProcessRuntime.resetTime();
                    Source.resetSource();
                }
            }
        });
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("停止了");
                if(timearound.instance.timer != null)
                    timearound.instance.timer.cancel();
            }
        });
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
        this.add(resetBtn,gbc);
        gbc.gridx=5;
        this.add(Box.createHorizontalStrut(width),gbc);
        this.add(stopBtn,gbc);
        gbc.gridx=6;
        this.add(Box.createHorizontalStrut(width),gbc);




        this.setSize(375, 80);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBorder(BorderFactory.createTitledBorder ("运行时间信息"));
    }

    public static void Updateinfo(process pro, int runtime)
    {
        if(pro != null) {
            cpuTF.setText(pro.getPro_name());
        }
        else
        {
            cpuTF.setText("");
        }
        timeTF.setText(String.valueOf(runtime + 1));
    }

    public static void UpdateIO(process IO)
    {
        IOTF.setText(IO.getPro_name());
    }
}
