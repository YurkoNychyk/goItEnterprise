package ua.goit.enterprise.module1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by home on 02.02.2017.
 */
public class GraphicResults extends JFrame {

    private JTable resultTable = new JTable();

    public GraphicResults(String title) {
        super(title);
        this.setBounds( 800,500, 400, 400 );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
