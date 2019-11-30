package com.os.homework.UI;

import com.os.homework.process;
import com.os.homework.timearound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class _Process extends JPanel {
    JLabel process1Label = new JLabel("进程1");
    JLabel process2Label = new JLabel("进程2");
    JLabel process3Label = new JLabel("进程3");
    JLabel runTimeLabel = new JLabel("运行时间");
    JLabel S1waitTimeLabel = new JLabel("S1P时间");
    JLabel S1signalTimeLabel = new JLabel("S1V时间");
    JLabel S2waitTimeLabel = new JLabel("S2P时间");
    JLabel S2signalTimeLabel = new JLabel("S2V时间");
    JLabel IOStartTimeLabel = new JLabel("I/O开始时间");
    JLabel IOFinishTimeLabel = new JLabel("I/O结束时间");
    JLabel ArriveTimeLabel = new JLabel("到达时间");
    JTextField runTimeTF1 = new JTextField(4);
    JTextField runTimeTF2 = new JTextField(4);
    JTextField runTimeTF3 = new JTextField(4);
    JTextField S1waitTimeTF1 = new JTextField(4);
    JTextField S1waitTimeTF2 = new JTextField(4);
    JTextField S1waitTimeTF3 = new JTextField(4);
    JTextField S1signalTimeTF1 = new JTextField(4);
    JTextField S1signalTimeTF2 = new JTextField(4);
    JTextField S1signalTimeTF3 = new JTextField(4);
    JTextField S2waitTimeTF1 = new JTextField(4);
    JTextField S2waitTimeTF2 = new JTextField(4);
    JTextField S2waitTimeTF3 = new JTextField(4);
    JTextField S2signalTimeTF1 = new JTextField(4);
    JTextField S2signalTimeTF2 = new JTextField(4);
    JTextField S2signalTimeTF3 = new JTextField(4);
    JTextField IOStartTF1 = new JTextField(6);
    JTextField IOStartTF2 = new JTextField(6);
    JTextField IOStartTF3 = new JTextField(6);
    JTextField IOFinishTF1 = new JTextField(6);
    JTextField IOFinishTF2 = new JTextField(6);
    JTextField IOFinishTF3 = new JTextField(6);
    JTextField ArriveTimeTF1 = new JTextField(6);
    JTextField ArriveTimeTF2 = new JTextField(6);
    JTextField ArriveTimeTF3 = new JTextField(6);
    JButton JBT = new JButton("确定");
    JButton resetBtn = new JButton("重置");
    private static _Process instance;
    public static _Process getInstance(){
        if(instance==null){
            instance = new _Process();
        }
        return instance;
    }
    _Process(){
        JBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                process process1 = new process();
                process1.setPro_name("process1");
                process process2 = new process();
                process2.setPro_name("process2");
                process process3 = new process();
                process3.setPro_name("process3");
                process1.setServer_time(Integer.parseInt(runTimeTF1.getText()));
                process1.setP1_s_time(Integer.parseInt(S1waitTimeTF1.getText()));
                process1.setP1_e_time(Integer.parseInt(S1signalTimeTF1.getText()));
                process1.setP2_s_time(Integer.parseInt(S2waitTimeTF1.getText()));
                process1.setP2_e_time(Integer.parseInt(S2signalTimeTF1.getText()));
                process1.setIO_stime(Integer.parseInt(IOStartTF1.getText()));
                process1.setIO_etime(Integer.parseInt(IOFinishTF1.getText()));
                process1.setArrive_time(Integer.parseInt(ArriveTimeTF1.getText()));

                process2.setServer_time(Integer.parseInt(runTimeTF2.getText()));
                process2.setP1_s_time(Integer.parseInt(S1waitTimeTF2.getText()));
                process2.setP1_e_time(Integer.parseInt(S1signalTimeTF2.getText()));
                process2.setP2_s_time(Integer.parseInt(S2waitTimeTF2.getText()));
                process2.setP2_e_time(Integer.parseInt(S2signalTimeTF2.getText()));
                process2.setIO_stime(Integer.parseInt(IOStartTF2.getText()));
                process2.setIO_etime(Integer.parseInt(IOFinishTF2.getText()));
                process2.setArrive_time(Integer.parseInt(ArriveTimeTF2.getText()));

                process3.setServer_time(Integer.parseInt(runTimeTF3.getText()));
                process3.setP2_s_time(Integer.parseInt(S2waitTimeTF3.getText()));
                process3.setP2_e_time(Integer.parseInt(S2signalTimeTF3.getText()));
                process3.setIO_stime(Integer.parseInt(IOStartTF3.getText()));
                process3.setIO_etime(Integer.parseInt(IOFinishTF3.getText()));
                process3.setArrive_time(Integer.parseInt(ArriveTimeTF3.getText()));

                UI.tr.setProcess1(process1);
                UI.tr.setProcess2(process2);
                UI.tr.setProcess3(process3);
                UI.tr.RUN();

                JBT.setEnabled(false);
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runTimeTF1.setText("");
                runTimeTF2.setText("");
                runTimeTF3.setText("");

                S1waitTimeTF1.setText("");
                S1waitTimeTF2.setText("");
                S1waitTimeTF3.setText("");

                S1signalTimeTF1.setText("");
                S1signalTimeTF2.setText("");
                S1signalTimeTF3.setText("");

                S2waitTimeTF1.setText("");
                S2waitTimeTF2.setText("");
                S2waitTimeTF3.setText("");

                S2signalTimeTF1.setText("");
                S2signalTimeTF2.setText("");
                S2signalTimeTF3.setText("");

                IOStartTF1.setText("");
                IOStartTF2.setText("");
                IOStartTF3.setText("");

                IOFinishTF1.setText("");
                IOFinishTF2.setText("");
                IOFinishTF3.setText("");

                ArriveTimeTF1.setText("");
                ArriveTimeTF2.setText("");
                ArriveTimeTF3.setText("");
            }
        });
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        GridBagConstraints gbc =new GridBagConstraints();
        int counter=0;
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.gridx=counter++;
        gbc.gridy=0;
        this.add(Box.createHorizontalStrut(10),gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(runTimeLabel,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(S1waitTimeLabel,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(S1signalTimeLabel,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(S2waitTimeLabel,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(S2signalTimeLabel,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(IOStartTimeLabel,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(IOFinishTimeLabel,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(100),gbc);
        this.add(ArriveTimeLabel,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(100),gbc);

        counter=0;
        gbc.gridy=1;
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(10),gbc);
        gbc.gridx=counter++;
        this.add(process1Label,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(runTimeTF1,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(S1waitTimeTF1,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(S1signalTimeTF1,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(S2waitTimeTF1,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(S2signalTimeTF1,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(IOStartTF1,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(IOFinishTF1,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(100),gbc);
        this.add(ArriveTimeTF1,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;

        counter=0;
        gbc.gridy=2;
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(10),gbc);
        gbc.gridx=counter++;
        this.add(process2Label,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(runTimeTF2,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(S1waitTimeTF2,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(S1signalTimeTF2,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(S2waitTimeTF2,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(S2signalTimeTF2,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(IOStartTF2,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(IOFinishTF2,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(100),gbc);
        this.add(ArriveTimeTF2,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);

        this.add(resetBtn,gbc);

        counter=0;
        gbc.gridy=3;
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(10),gbc);
        gbc.gridx=counter++;
        this.add(process3Label,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(runTimeTF3,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(S2waitTimeTF3,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(S2signalTimeTF3,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(IOStartTF3,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
        gbc.gridx=counter++;
        this.add(IOFinishTF3,gbc);
        gbc.gridx=counter++;
        this.add(ArriveTimeTF3,gbc);
        gbc.gridx=counter++;
        this.add(Box.createHorizontalStrut(30),gbc);
//        gbc.gridx=counter++;

        this.add(JBT,gbc);

        counter = 0;


        this.setSize(750, 300);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBorder(BorderFactory.createTitledBorder ("设置进程"));
    }
}
