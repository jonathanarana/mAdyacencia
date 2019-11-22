/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author master
 */
public class Matriz {
    
    private static Matriz mMatriz;
    private int[][] matriz;
    
    private Matriz(){}
    
    public static Matriz getMatriz(){
        if (mMatriz==null) {
            mMatriz=new Matriz();
        }
        return mMatriz;
    }
    
    public void inicializarMatriz(int longitud){
        matriz=new int[longitud][longitud];
    }
    
    public int getLongitud(){
        return matriz.length;
    }
    
    public int getValue(int x, int y){
        int value=matriz[x][y];
        return value;
    }
    
    public int changeValue(int x,int y){
        int value=matriz[x-1][y-1];
        
        if (value==0) {
            value=1;
        }
        else {
            value=0;
        }
        
        matriz[x-1][y-1]=value;
        
        return value;
    }
    
    public void printMatriz(){
        int longitud = matriz.length;
        for (int i = 0; i < longitud; i++) {
            for (int j = 0; j < longitud; j++) {
                System.out.print(matriz[i][j]+"   ");
            }
            System.out.println("\n");
        }
        
    }
}
