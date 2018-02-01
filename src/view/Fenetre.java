package view;

import java.awt.*;
import utils.Constants;

import javax.swing.*;

public class Fenetre extends JFrame implements Runnable{
    public Fenetre()
    {
        super();
        this.setTitle("Proto_IHM");
        this.setSize(new Dimension(Constants.WIDTH,Constants.HEIGHT));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public void run() {
        this.setVisible(true);
    }
}
