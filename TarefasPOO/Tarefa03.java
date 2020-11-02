/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarefa03;

import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author RODRIGORICCIDEPAULAM
 */
public class Tarefa03 {
    
    //EXERCÍCIO 01
    public void ex01 (){
       
        try{
            String intervalostr = JOptionPane.showInputDialog("Insira o intervalo que deseja para exibição de números pares:");
            Integer intervalo = Integer.parseInt(intervalostr);
            ArrayList<Integer> lista = new ArrayList<>();

            for (int i = 0; i<=intervalo;i++){
                if ( i%2 == 0){
                    lista.add(i);
                }
            }

            JOptionPane.showMessageDialog(null,"Números Pares: \n"+ lista);
        
        }
        catch(ArithmeticException x){
              JOptionPane.showMessageDialog(null,"Erro Aritmético, tente um valor diferente!","Erro!",JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException x){
              JOptionPane.showMessageDialog(null,"Parece que você não inseriu um número! O programa só aceita números!","Erro!",JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception x){
              JOptionPane.showMessageDialog(null,"Algo deu Errado, tente um valor diferente!","Erro!",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    //EXERCÍCIO 02
    public void ex02(){
        try{
            String intervalostr = JOptionPane.showInputDialog("Insira o número de termos de Fibonacci que deseja:");
            Integer intervalo = Integer.parseInt(intervalostr);

            int a = 0;
            int b = 0;
            int c = 1;

            ArrayList<Integer> lista = new ArrayList<>();

            for(int i =0; i<=intervalo;i++){
               a= b+c;
               lista.add(a); 
               c=b;
               b=a; 
            }
            
            JOptionPane.showMessageDialog(null,"Números da Sequência de Fibonacci: \n"+ lista);

        }
        catch(ArithmeticException x){
              JOptionPane.showMessageDialog(null,"Erro Aritmético, tente um valor diferente!","Erro!",JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException x){
              JOptionPane.showMessageDialog(null,"Parece que você não inseriu um número! O programa só aceita números!","Erro!",JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception x){
              JOptionPane.showMessageDialog(null,"Algo deu Errado, tente um valor diferente!","Erro!",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    //EXERCÍCIO 03
    public void ex03(){
         try{
            String intervalostr = JOptionPane.showInputDialog("Insira o intervalo de números primos que deseja:");
            Integer intervalo = Integer.parseInt(intervalostr);
            ArrayList<Integer> lista = new ArrayList<>();
         
            for(int i =0; i<=intervalo;i++){
                
                int cont = 0;
                
                for(int f =1; f<=i;f++){
                    if(i%f==0){
                    cont++;
                    }
                }
            
                if(cont==2){
                    lista.add(i);
                } 
            }
            
         JOptionPane.showMessageDialog(null, "Números Primos: \n"+lista);
         
        }
        catch(ArithmeticException x){
          JOptionPane.showMessageDialog(null,"Erro Aritmético, tente um valor diferente!","Erro!",JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException x){
              JOptionPane.showMessageDialog(null,"Parece que você não inseriu um número! O programa só aceita números!","Erro!",JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception x){
              JOptionPane.showMessageDialog(null,"Algo deu Errado, tente um valor diferente!","Erro!",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    //EXERCÍCIO 04
    public void ex04(){
            try{
                String p1str = JOptionPane.showInputDialog("Insira a nota da P1:");
                double p1 = Double.parseDouble(p1str);
                String p2str = JOptionPane.showInputDialog("Insira a nota da P2:");
                double p2 = Double.parseDouble(p2str);
                String trabstr = JOptionPane.showInputDialog("Insira a nota de Trabalho:");
                double trab = Double.parseDouble(trabstr);
                double media = (p1*0.35 + p2*0.50 + trab*0.15);

                JOptionPane.showMessageDialog(null, "Média do Aluno: \n"+media);
        
            }
            catch(ArithmeticException x){
              JOptionPane.showMessageDialog(null,"Erro Aritmético, tente um valor diferente!","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            catch(NumberFormatException x){
                  JOptionPane.showMessageDialog(null,"Parece que você não inseriu um número! O programa só aceita números!","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception x){
                  JOptionPane.showMessageDialog(null,"Algo deu Errado, tente um valor diferente!","Erro!",JOptionPane.ERROR_MESSAGE);
            }
        
    }
    
    
    //EXERCÍCIO 05
    public void ex05(){
           try{
                String limitestr = JOptionPane.showInputDialog("Insira o Limite da lista:");
                Integer limite = Integer.parseInt(limitestr);
                String incrementostr = JOptionPane.showInputDialog("Insira o incremento da lista:");
                Integer incremento = Integer.parseInt(incrementostr);
                
                ArrayList<Integer> lista = new ArrayList<>();
                if(incremento<0){
                    for(int i =0;i>=limite;i=i+incremento){
                    lista.add(i);
                    }
                }
                else if(incremento>0){
                    for(int i =0;i<=limite;i+=incremento){
                    lista.add(i);
                    }
                }
                
                
                JOptionPane.showMessageDialog(null, "Lista de incremento: \n"+lista);
                
            }
            catch(ArithmeticException x){
              JOptionPane.showMessageDialog(null,"Erro Aritmético, tente um valor diferente!","Erro!",JOptionPane.ERROR_MESSAGE);
            }
            catch(NumberFormatException x){
                  JOptionPane.showMessageDialog(null,"Parece que você não inseriu um número ou ele é grande demais!\nTente outro valor!","Erro!",JOptionPane.ERROR_MESSAGE);
            } 
            catch(Exception x){
                  JOptionPane.showMessageDialog(null,"Algo deu Errado, tente um valor diferente!","Erro!",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    //MAIN
    public static void main(String[] args){
         
            Tarefa03 tarefa= new Tarefa03();
            
            int opcao;
            
            do{
                String opcaostr= JOptionPane.showInputDialog("Insira o número do exercício:\n"
                    + "\n1) Um  programa  capaz  de  imprimir  todos  os  números  pares  em  um  intervalo de números informador pelo usuário;"
                    + "\n2) Um  programa  que  imprima  até  o  “n”  termo  a  seqüência  de  Fibonacci;"
                    + "\n3) Um  programa  capaz  de  imprimir  todos  os  números  primos  em  um  intervalo  de números informado pelo usuário;"
                    + "\n4) Um programa que calcule a média de uma aluno nos moldes da Fatec Zona SUL;"
                    + "\n5) Criar um programa que leia um número que será o limite superior de um intervalo e o incremento;"
                    + "\n6) Sair.");

                opcao = Integer.parseInt(opcaostr);

                switch(opcao){
                    case 1: tarefa.ex01(); break;
                    case 2: tarefa.ex02(); break;
                    case 3: tarefa.ex03(); break;
                    case 4: tarefa.ex04(); break;
                    case 5: tarefa.ex05(); break;
                }
            }while(opcao!=6);
    }
}
