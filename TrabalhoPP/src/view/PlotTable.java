/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lucas
 */
public class PlotTable {

    private static TableModel model;
    private static int step = 0;

    static void plotAll(JTable table, ArrayList listaPlot) {

        TableModel model = new DefaultTableModel(listaPlot.size(), 1);

        for (int i = 0; i < listaPlot.size(); i++) {
            model.setValueAt(listaPlot.get(i), i, 0);
        }

        table.setModel(model);

    }

    static void plotStep(JTable table, ArrayList listaPlot) {

        if (model == null) {
            model = new DefaultTableModel(listaPlot.size(), 1);
        }

        model.setValueAt(listaPlot.get(step), step, 0);

        table.setModel(model);
        step++;
    }

}
