/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author SABRINA
 */
public class TabelaCor extends JTable{
  public Component prepareRenderer(TableCellRenderer render, int row, int colum){
      Component component = super.prepareRenderer(render, row, colum);
      component.setBackground(Color.WHITE);
      //(String.class.equals(this.getColumnClass(colum))) && *outra condição do if
      if ((getValueAt(row, colum)!=null)){
        String valor = (getValueAt(row, colum).toString());
        component.setBackground(Color.blue);
      }
      return component;
  }
    
}
