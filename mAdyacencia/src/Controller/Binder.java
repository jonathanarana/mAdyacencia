/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Matriz;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author master
 */
public class Binder {
    
    Matriz matriz = Matriz.getMatriz(); //generamos la instancia de la matriz
    
    public DefaultTableModel llenarModelo(){
       
       
       DefaultTableModel modelo = new DefaultTableModel(); //generamos el modelo para la tabla
       int Nodos=matriz.getLongitud();
       
       int i = 0;
       String[] rowModel = new String[Nodos+1];
        
       for (i = 0; i <= Nodos; i++) { //creamos las columnas
            modelo.addColumn(i);
            rowModel[i]=i+"";//llenamos el modelo para la cabezera
        }
        
        rowModel[0]=""; //eliminamos el texto a la interseccion
        modelo.addRow(rowModel); //agregamos la cabezera
        
        for (i = 1; i <= Nodos; i++) {//Iniciamos el modelo de la fila a cero
            rowModel[i]="0";
        }
        
        for (i = 1; i <= Nodos; i++) {
            rowModel[0]=i+"";
            modelo.addRow(rowModel);
        }
       return modelo;
    }
    
    public boolean isSimple(){
        boolean res=true;
        int longitud=matriz.getLongitud();
        for (int i = 0; i < longitud; i++) { //recorremos la diagonal, que son los bucles
            if (matriz.getValue(i, i)==1) { //si tiene bucles, no es simple
                res=false;
                break;
            }
        }
        return res;
    }
    
    public boolean isDirected(){
        boolean res=true;
        int longitud=matriz.getLongitud();
        for (int i = 0; i < longitud; i++) { //recorremos la matriz de forma horizontal
            for (int j = 0; j < longitud; j++) { //recorre la matriz de forma vertical
                if (matriz.getValue(i, j) != matriz.getValue(j, i)) { //si alguno no concide, es dirigido
                    res=false;
                    break;
                }
            }
        }
        return res;
    }
}
