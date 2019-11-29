package com.os.homework.UI;
import com.os.homework.timearound;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {
    public static timearound tr;
    public UI(){
        tr = new timearound();
        this.setSize(960,480);
        this.setLayout(new FlowLayout());
        this.add(TimeClip.getInstance());
        this.add(_Process.getInstance());
        this.add(ProcessRuntime.getInstance());
        this.add(UtilInfos.getInstance());
        this.add(Source.getInstance());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
