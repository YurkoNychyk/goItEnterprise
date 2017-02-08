package ua.goit.enterprise.module1;

import javax.swing.*;
import java.util.*;

/**
 * Created by home on 02.02.2017.
 */
public class GraphicResults extends JFrame {

    private JTable resultTable;
    private String[][] data;
    private String[] colNames;
    private Set<String> firstCol;
    private Set<String> colNamesSet;

    public GraphicResults(String title, int x ,Map<String, Long> data) {
        super(title);
        this.setBounds( x,500, 400, 400 );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.firstCol = new TreeSet<>();
        this.colNamesSet = new HashSet<>();

        for ( Map.Entry entry:data.entrySet() ) {
            String entryKey[];
            entryKey = entry.getKey().toString().split(", ");
                this.firstCol.add(entryKey[0]);
                this.colNamesSet.add(entryKey[1]);
        }

        colNames = colNamesSet.toArray(new String[colNamesSet.size()]);
        this.data = new String[data.size()][colNames.length];
        for (int row = 0; row < this.data.length; row++)    {
            if (this.firstCol.iterator().hasNext())
            this.data[row][0] = this.firstCol.iterator().next();

            for (int col = 0; col <colNames.length; col++ ) {
                if (col == 0) this.data[0][col] = colNames[col];
            }
        }


        resultTable = new JTable(this.data, this.colNames);

        JScrollPane scrollPane = new JScrollPane(resultTable);
        resultTable.setFillsViewportHeight(true);

        this.add(scrollPane);
        this.setVisible(true);
    }

}
