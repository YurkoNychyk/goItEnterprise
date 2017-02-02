package ua.goit.enterprise.module1;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * Created by home on 02.02.2017.
 */
public class GraphicResults extends JFrame {

    private JTable resultTable;
    private String[][] data;
    private String[] colNames =  {"Add", "Get", "Remove", "Contains", "Populate", "iterator.add", "iterator.remove"};

    public GraphicResults(String title, int x ,Map data) {
        super(title);
        this.setBounds( x,500, 400, 400 );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.data = new String[data.size()][7];
        for (int i = 0; i < this.data.length; i++){
            this.data[i][0] = "First Column ";
            for (int col = 1; col < 7; col++)   {
                this.data[i][col] = Integer.toString(col);
            }
        }
        resultTable = new JTable(this.data, colNames);
        Container container = this.getContentPane();
        container.add(resultTable);
        this.pack();
        this.setVisible(true);

    }
}
