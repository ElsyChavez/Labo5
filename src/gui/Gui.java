/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import threads.AnimalThread;

/**
 *
 * @author UCA
 */
public class Gui extends JFrame {
    
    private JLabel [] labels;
    
    private JButton inicio, reinicio;
    
    private String[] nombres = {"canguro","tortuga","dragon"};
    
    public Gui(){
        super("Carrera de animales");
        initialComponents();
    }
    
    public void initialComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        labels = new JLabel[3];
        inicio = new JButton("Inicio");
        reinicio = new JButton("Reiniciar");
        Container container = getContentPane();
        
        for (int i=0; i < 3; i++){
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i] + ".gif")));
            labels[i].setBounds(10,(i*220)+10,200,200);
            container.add(labels[i]);
        }
        inicio.setBounds(10,0,100,30);
        container.add(inicio);
        
        reinicio.setBounds(150,0,100,30);
        container.add(reinicio);
        
        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                AnimalThread canguro = new AnimalThread("canguro",labels[0].getX(),labels[0].getY(),510,labels[0]);
                AnimalThread tortuga = new AnimalThread("tortuga",labels[1].getX(),labels[1].getY(),510,labels[1]);
                AnimalThread dragon = new AnimalThread("dragon",labels[2].getX(),labels[2].getY(),510,labels[2]);
                canguro.start();
                tortuga.start();
                dragon.start();
            }
        });
        setSize(700,650);
        
        reinicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                for (int i=0; i < 3; i++){
                    labels[i].setLocation(10,(i*220));
        }
            }
        });
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run(){
                new Gui().setVisible(true);
            }
        });
               
    }
}
