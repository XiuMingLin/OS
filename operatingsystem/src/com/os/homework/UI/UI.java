package com.os.homework.UI;
import javax.swing.*;

public class UI extends JFrame {
    UI(){
        this.add(TimeClip.getInstance());
        this.setVisible(true);
    }
    public static void main(String args[]){

        UI test = new UI();
    }
}
