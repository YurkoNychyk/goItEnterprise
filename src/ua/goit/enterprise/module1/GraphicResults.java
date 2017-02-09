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
    private final long DEFAULT_VALUE = 999l;

    public GraphicResults(String title, int x ,Map<String, Long> data) {
        super(title);
        this.setBounds( x,500, 400, 400 );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        firstCol = new TreeSet<>();
        colNamesSet = new HashSet<>();

        for ( Map.Entry entry:data.entrySet() ) {
            String entryKey[] = {"null","null"};
            entryKey = entry.getKey().toString().split(", ");
                firstCol.add(entryKey[0]);
                colNamesSet.add(entryKey[1]);
        }

        colNames = colNamesSet.toArray(new String[colNamesSet.size()+1]);
        for (int i = colNames.length - 1; i >= 0; i --){
            if (i == 0) {
                colNames[i] = "Collection Name";
            }
            else {
                colNames[i] = colNames[i - 1];
            }
        }
        this.data = new String[(data.size() / colNamesSet.size()) + 1][colNames.length];


        Iterator iter = firstCol.iterator();
        for (int row = 0; row < this.data.length; row++)    {
            if (iter.hasNext())
            this.data[row][0] = iter.next().toString();

            for (int col = 1; col <colNames.length; col++ ) {
                    String initialKey = this.data[row][0] + ", " + colNames[col];
                    Long longItem = data.getOrDefault(initialKey, DEFAULT_VALUE);
                    String stringItem = Long.toString(longItem);
                    this.data[row][col] = (longItem == DEFAULT_VALUE) ?  "" : stringItem ;
                }

            }
        System.out.println("Data array size" + this.data.length);

        resultTable = new JTable(this.data, this.colNames);

        JScrollPane scrollPane = new JScrollPane(resultTable);
        resultTable.setFillsViewportHeight(true);

        this.add(scrollPane);
        this.setVisible(true);
        this.pack();
    }

}
