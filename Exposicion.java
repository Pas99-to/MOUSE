/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoU2;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Juan Pastrano
 */
public class Exposicion extends JFrame {
    
   JPanel panel; 
   JLabel etiqueta_imagen;
   JLabel etiqueta_imagen2;
   JLabel etiqueta_imagen3;
   
   ImageIcon image;
   ImageIcon image2;
   ImageIcon image3;
   
   MouseMotionListener motion;
   MouseListener listener;
  public Exposicion(){
    
     panel=new JPanel();
     this.etiqueta_imagen=new JLabel();
     this.etiqueta_imagen2=new JLabel();
    this.etiqueta_imagen3=new JLabel();
    
     this.setSize(600,610);
     this.setTitle("MOUSE EVENTS");
     
     this.setLocationRelativeTo(null);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setVisible(true);
    
     this.add(panel);
     
     Imagen();
    }
 
  //Metodo imagen
 private void Imagen(){
    image=new ImageIcon("src\\proyectoU2\\calaca.jpg");
    image2=new ImageIcon("src\\proyectoU2\\calaca2.jpg");
    image3=new ImageIcon("src\\proyectoU2\\perro.jpg");
    
    panel.add(etiqueta_imagen);
    panel.add(etiqueta_imagen2);
    panel.add(etiqueta_imagen3);
    
    etiqueta_imagen.setIcon(image);
    etiqueta_imagen2.setIcon(image2);
    etiqueta_imagen3.setIcon(image3);
    
    EventosMouseMotion();
    EventosMouseListener();
 }
 
 //Metodo donde definiremos las acciones del mouse
 private void EventosMouseMotion(){
       
     //EVENTOS MOUSEMOTIONLISTENER 
     motion=new  MouseMotionListener(){
      @Override
      public void mouseDragged(MouseEvent me) {
         if(me.getSource().equals(etiqueta_imagen)
         ){
          System.out.println("DRAGGED");
          etiqueta_imagen.setLocation(etiqueta_imagen.getX()+me.getX()-etiqueta_imagen.getWidth()/2,
                                  etiqueta_imagen.getY()+me.getY()-etiqueta_imagen.getHeight()/2);
          etiqueta_imagen.repaint(); 
         }
         
         if(me.getSource().equals(etiqueta_imagen3)){
             System.out.println("DRAGGED");
             etiqueta_imagen3.setLocation(etiqueta_imagen3.getX()+me.getX()-etiqueta_imagen3.getWidth()/2,
                                  etiqueta_imagen3.getY()+me.getY()-etiqueta_imagen3.getHeight()/2);
          etiqueta_imagen.repaint(); 
         }
      }

      @Override
      public void mouseMoved(MouseEvent me) {
         if(me.getSource().equals(etiqueta_imagen2)){
         System.out.println("---MOVED---");
         etiqueta_imagen2.setLocation(etiqueta_imagen2.getX()+me.getX()-etiqueta_imagen2.getWidth()/2,
                                  etiqueta_imagen2.getY()+me.getY()-etiqueta_imagen2.getHeight()/2);
         etiqueta_imagen2.repaint();
         }
          }
       
   };//fin MouseMotionListener
  this.etiqueta_imagen.addMouseMotionListener(motion);
  this.etiqueta_imagen2.addMouseMotionListener(motion);
  this.etiqueta_imagen3.addMouseMotionListener(motion);
 }//fin EventoMouseMotion
 
 //Metodo usar MouseListener
 private void EventosMouseListener(){
    listener=new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent me) {
        if(me.getSource().equals(etiqueta_imagen)){
        System.out.println("CLICKED");   
        image2=new ImageIcon("src\\proyectoU2\\calaca2.jpg");
        etiqueta_imagen2.setIcon(image2);
        }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        System.out.println("PRESSED");
        if(me.getSource().equals(etiqueta_imagen)){
        image=new ImageIcon("src\\proyectoU2\\calaca.jpg");
        etiqueta_imagen2.setIcon(image);
        }
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        if(me.getSource().equals(etiqueta_imagen2)){
         System.out.println("RELEASED");
        image=new ImageIcon("src\\proyectoU2\\perro.jpg");
        etiqueta_imagen2.setIcon(image);
        }
        }
    
        @Override
        public void mouseEntered(MouseEvent me) {
        if(me.getSource().equals(etiqueta_imagen2)){
        System.out.println("ENTERED");
        image=new ImageIcon("src\\proyectoU2\\perro.jpg");
        etiqueta_imagen.setIcon(image);
        }
        }

        @Override
        public void mouseExited(MouseEvent me) {
        if(me.getSource().equals(etiqueta_imagen2)){
        System.out.println("EXITED");
        image=new ImageIcon("src\\proyectoU2\\calaca.jpg");
        etiqueta_imagen.setIcon(image);
        }
        }
        
    };//fin mouse listener
 this.etiqueta_imagen2.addMouseListener(listener);
 this.etiqueta_imagen.addMouseListener(listener);
    
 }//fin metodo EventosMouseListener
 
 }//fin clase
