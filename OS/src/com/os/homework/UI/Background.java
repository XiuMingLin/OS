package com.os.homework.UI;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {

    public static Background instance;
    private static final long serialVersionUID = -6352788025440244338L;

    private Image image = (Image) new ImageIcon("UI/bg.jpg").getImage();

    // 固定背景图片，允许这个JPanel可以在图片上添加其他组件
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, 869, 254, this);
//        g.drawImage(icon.getImage(), x, y,this);
    }
    public static Background getInstance(){
        if(instance==null){
            instance = new Background();
        }
        return instance;
    }

    Background()
    {
        this.setSize(869,254);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBorder(BorderFactory.createTitledBorder ("bg"));
    }
}
