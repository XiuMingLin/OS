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
        this.setLayout(new FlowLayout());
        this.setSize(900,900);
//        JPanel bg = new Background();
        this.add(TimeClip.getInstance());
        this.add(_Process.getInstance());
        this.add(ProcessRuntime.getInstance());
        this.add(Source.getInstance());
        this.add(UtilInfos.getInstance());

        tr = new timearound();
        this.add(LogList.getInstance());
        this.add(Background.getInstance());

        //this.setLayout(new BorderLayout());

        //this.add(firstPanel,BorderLayout.WEST);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
