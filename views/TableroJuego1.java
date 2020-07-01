package views;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TableroJuego1 extends javax.swing.JFrame {
    
    private static final long serialVersionUID = 1L;
    fondopanel fondo = new fondopanel();

    
    public TableroJuego1() {
        this.setContentPane(fondo);
        initComponents();
    }

    
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );

        pack();
    }
    
   class fondopanel extends JPanel{

       private static final long serialVersionUID = 1L;
       private Image imagen;
       
       @Override
       public void paint(Graphics g){
           imagen = new ImageIcon(getClass().getResource("/img/fondo.jpg")).getImage();
           g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
           setOpaque(false);
           super.paint(g);
           
           
       }

  
       
   }
}
