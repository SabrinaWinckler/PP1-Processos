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
    private static ArrayList<String> ordemProcessos;

    static void plotAll(JTable table, ArrayList<String> listaPlot, int quantidadeProcessos) {

        model = new DefaultTableModel(quantidadeProcessos, listaPlot.size());
        ordemProcessos = new ArrayList();

        for (int i = 0; i < listaPlot.size(); i++) {
            if (ordemProcessos.isEmpty()) {
                ordemProcessos.add(listaPlot.get(i));
            }
            if (!ordemProcessos.contains(listaPlot.get(i)) && !listaPlot.get(i).equals("-")) {
                ordemProcessos.add(listaPlot.get(i));
            }

        }

        for (int i = 0; i < listaPlot.size(); i++) {
            if (listaPlot.get(i).equals("-")) {
                model.setValueAt(null, 0, i);
            } else {
                int j = ordemProcessos.indexOf(listaPlot.get(i));
                model.setValueAt(listaPlot.get(i), j, i);
            }
            step++;
        }

        table.setModel(model);

    }

    static void plotStep(JTable table, ArrayList<String> listaPlot, int quantidadeProcessos) {

        if (model == null) {
            model = new DefaultTableModel(quantidadeProcessos, listaPlot.size());
        }
        if (ordemProcessos == null) {
            ordemProcessos = new ArrayList();
        }
        if (ordemProcessos.isEmpty()) {
            ordemProcessos.add(listaPlot.get(step));
        }
        if (!ordemProcessos.contains(listaPlot.get(step)) && !listaPlot.get(step).equals("-")) {
            ordemProcessos.add(listaPlot.get(step));
        }

        if (listaPlot.get(step).equals("-")) {
            model.setValueAt(null, 0, step);
        } else {
            int j = ordemProcessos.indexOf(listaPlot.get(step));
            model.setValueAt(listaPlot.get(step), j, step);
        }
        table.setModel(model);
        step++;
    }

    static void stepBack(JTable table, ArrayList<String> listaPlot) {
        step--;
        if (step >= 0) {
            if (listaPlot.get(step).equals("-")) {
                model.setValueAt(null, 0, step);
            } else {
                int j = ordemProcessos.indexOf(listaPlot.get(step));
                model.setValueAt(null, j, step);
            }
        }
    }

    static void reset() {
        model = null;
        ordemProcessos = null;
        step = 0;
    }

    public static int getStep() {
        return step;
    }

}
