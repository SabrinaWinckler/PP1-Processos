/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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

    static void plotAll(JTable table, ArrayList listaPlot, int quantidadeProcessos) {

        TableModel model = new DefaultTableModel(quantidadeProcessos, listaPlot.size());

        for (int i = 0; i < listaPlot.size(); i++) {
            model.setValueAt(listaPlot.get(i), 0, i);
        }

        table.setModel(model);

    }

    static void plotStep(JTable table, ArrayList listaPlot, int quantidadeProcessos) {

        if (model == null) {
            model = new DefaultTableModel(quantidadeProcessos, listaPlot.size());
        }

        model.setValueAt(listaPlot.get(step), 0, step);

        table.setModel(model);
        step++;
    }

}
