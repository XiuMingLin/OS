package com.os.homework.UI;
import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {
    UI(){
        this.setSize(800,400);
        this.setLayout(new FlowLayout());
        this.add(TimeClip.getInstance());
        this.add(_Process.getInstance());
        this.add(ProcessRuntime.getInstance());
        this.add(UtilInfos.getInstance());
        this.add(Source.getInstance());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){

        UI test = new UI();
    }
}
