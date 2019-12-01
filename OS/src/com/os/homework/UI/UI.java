package com.os.homework.UI;
import com.os.homework.timearound;
import javafx.scene.layout.BackgroundImage;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {
    public static timearound tr;
    private static UI instance;
    public static UI getInstance(){
        if(instance==null){
            instance = new UI();
        }
        return instance;
    }

    public UI(){
        super("∏¥‘”Ã‚ƒø1");
        //JPanel firstPanel = new JPanel(new FlowLayout());
        //firstPanel.setSize(480,480);

        JLayeredPane layeredPane = new JLayeredPane();
        JPanel jPanel = new JPanel();
//        JPanel jPanel1 = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setSize(900,900);
//        JPanel bg = new Background();
        jPanel.add(TimeClip.getInstance());
        jPanel.add(_Process.getInstance());
        jPanel.add(ProcessRuntime.getInstance());
        jPanel.add(Source.getInstance());
        jPanel.add(UtilInfos.getInstance());

        tr = new timearound();
        jPanel.add(LogList.getInstance());
//        jPanel1.add(Background.getInstance());
        //this.setLayout(new BorderLayout());

        //this.add(firstPanel,BorderLayout.WEST);
        ImageIcon bg = new ImageIcon("src/bg.jpg");
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0,700,bg.getIconWidth(),bg.getIconHeight());
        this.getLayeredPane().add(bgLabel,-1);

        JPanel top = new JPanel();
        top = (JPanel)this.getContentPane();

        top.setOpaque(false);
        jPanel.setOpaque(true);
        this.add(jPanel);
//        layeredPane.add(jPanel, 100);
//
//        this.setContentPane(layeredPane);
        this.setSize(900,1000);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
