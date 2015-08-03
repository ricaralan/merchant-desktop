package com.merchant.components.tableModels;

import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Zebra1 {

    public static void main(String[] args) {
        ZebraJTable table = new ZebraJTable(createItems(), createColumns());
        table.setSelectionMode(JTable.AUTO_RESIZE_OFF);
        
        JScrollPane scrollList = new JScrollPane(table);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640, 480);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(scrollList);
        frame.setVisible(true);
    }

    private static Vector createItems() {
        Vector rows = new Vector();
        Vector row = null;
        for (int i = 1; i < 15; i++) {
            row = new Vector();
            for (int j = 1; j < 11; j++) {
                row.add(String.valueOf(i * j));
            }
            rows.add(row);
        }
        return rows;
    }

    private static Vector createColumns() {
        Vector columns = new Vector();
        for (int i = 1; i < 11; i++) {
            columns.add("Column " + i);
        }
        return columns;
    }
}
