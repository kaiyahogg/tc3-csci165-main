import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.*;
import java.io.*;



class Drawer extends JPanel {

    final static int[][] matrix = new int [rowSnatcher(fileName)][columnSnatcher(fileName)];

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();

    public Drawer() {
        initUI();
    }

    private void initUI() {
        window.add(this);
        window.setTitle("Elevation");
        window.setSize(columnSnatcher(fileName), rowSnatcher(fileName));
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

     /*              

        ==================================================

    */

    public static columnSnatcher(String fileName){

        //Substring to extract size of column to be used in matrix
        String columns = fileName.substring(fileName.lastIndexOf("_") + 1, 
        fileName.lastIndexOf("x"));

        return columns;
        

    }

    public static rowSnatcher(String fileName){
        
        //Substring to extract size of row to be used in matrix
        String rows = strBig.substring(strBig.lastIndexOf("x")+1);

        return rows;
    }

    public static void MapDataDrawer(String fileName, int rows, int columns){

        //Try catch
        try{

            FileReader fr = new FileReader(fileName);
            Scanner sc = new Scanner(fr);


        }
        catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }



    }


    private void doDrawing(Graphics g) {

        /*
            RGB Colors:
            ================================================
            Black       => (0, 0, 0)        => low elevation
            Mid Grey    => (128, 128, 128)  => mid elevation
            White       => (255, 255, 255)  => high elevation

            Grey Scale colors are scaled in matching set of 3 numeric values
        */

        Graphics2D g2d = (Graphics2D) g;

        int x = 10, y = 10;
        for(int i = 0; i < 30; ++i){
            g2d.drawRect(x, y, 10, 10);
            y += 15;
        }

        g2d.setColor(new Color(0, 0, 0));
        y = 10; x += 15;
        for(int i = 0; i < 30; ++i){
            g2d.fillRect(x, y, 20, 10);
            y += 15;
        }

        g2d.setColor(new Color(128, 128, 128));
        y = 10; x += 15;
        for(int i = 0; i < 30; ++i){
            g2d.fillRect(x, y, 10, 10);
            y += 15;
        }

        g2d.setColor(new Color(200, 200, 200));
        y = 10; x += 15;
        for(int i = 0; i < 30; ++i){
            g2d.fillOval(x, y, 10, 10);
            y += 15;
        }

        int width = getWidth();
        int height = getHeight();
        g2d.setColor(Color.GREEN);
        String s = "I'm a graphics programmer now!!";
        g2d.drawString(s, (width / 2) - s.length() * 3 , height / 2);

        g2d.setColor(Color.RED);
        Random random = new Random();
        for(int i = 0; i < 2000; i++){
            x = Math.abs(random.nextInt()) % width;
            y = Math.abs(random.nextInt()) % height;
            g2d.drawLine(x, y, x + 2, y + 2);
        }
    }


    public static void main(String[] args) {

        if(args.length > 0){
            fileName = args[0];
            

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() { 
                    Drawer ex = new Drawer();
                    ex.setVisible(true);
                }
            });
        }
        else System.out.println("No file name specified. Program is terminated.");
    } // end main
} // end class
