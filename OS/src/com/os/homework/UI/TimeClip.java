package com.os.homework.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeClip extends JPanel {
    JLabel timeClipLable = new JLabel("时间片大小:");
    JTextField timeClipTF = new JTextField(6);
    JButton timeClipButton = new JButton("确定");
    private static TimeClip instance;
    public static TimeClip getInstance(){
        if(instance == null)

            instance = new TimeClip();
        return instance;
    }
    TimeClip(){
        timeClipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI.tr.setTime_size(Integer.parseInt(timeClipTF.getText()));
            }
        });
        this.add(Box.createHorizontalStrut(220));
        this.add(timeClipLable);
        this.add(Box.createHorizontalStrut(50));
        this.add(timeClipTF);
        this.add(Box.createHorizontalStrut(50));
        this.add(timeClipButton);
        this.add(Box.createHorizontalStrut(220));



        this.setSize(750, 80);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBorder(BorderFactory.createTitledBorder ("设置时间片"));
    }

    public JLabel getTimeClipLable() {
        return timeClipLable;
    }

    public JTextField getTimeClipTF() {
        return timeClipTF;
    }

    public JButton getTimeClipButton() {
        return timeClipButton;
    }

}
