/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarefa05;
import javax.swing.JOptionPane;
/**
 *
 * @author RODRIGORICCIDEPAULAM
 */

   
class equacao {
    // Atributos da Equação
    int a, b, c;
    
    // Metodo para leitura
    public void SetVal(int A, int B, int C)
    {
        a = A;
        b = B;
        c = C;
    }
    // Metodo Construtor
    public equacao() 
    {
        a = 0;
        b = 0;
        c = 0;
    }
    // Metodo Calculo Equação
    public void GetRaiz()
    {
        int delta = ((b*b)-(4*a*c));
        if(delta == 0){
            float x1 = (float) (-b + Math.sqrt (delta))  / ( 2*a );
            JOptionPane.showMessageDialog(null,"Raizes iguais. Valor da raiz: "+x1);
        } 
        else if(delta < 0)
        {
            JOptionPane.showMessageDialog(null,"Não existem raizes reais");
        }
        else if(delta > 0){
            float x1 = (float) (-b + Math.sqrt (delta))  / ( 2*a );
            float x2 = (float) (-b - Math.sqrt (delta)) / ( 2*a );
            JOptionPane.showMessageDialog(null,"Raiz 1: "+x1+"\nRaiz 2: "+x2);
        }        
        
    }
}

public class Ex2 {
    public static void main(String[] args) {
        int A1, B1, C1;
        String v1 = JOptionPane.showInputDialog("Valor de A: ");
        String v2 = JOptionPane.showInputDialog("Valor de B: ");
        String v3 = JOptionPane.showInputDialog("Valor de C: ");
        
        A1 = Integer.parseInt(v1);
        B1 = Integer.parseInt(v2);
        C1 = Integer.parseInt(v3);
        
        equacao eq = new equacao();
        eq.SetVal(A1, B1, C1);
        eq.GetRaiz();
        
    }
}

