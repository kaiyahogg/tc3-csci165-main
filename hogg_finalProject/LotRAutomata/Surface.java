import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Surface extends JPanel implements ActionListener{
    
    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();

    Map map = new Map();    
    Timer timer = new Timer(1000, this);
    
    public Surface(){
        initUI();
        timer.start();
    }

    private void initUI(){
        window.add(this);
        window.setTitle("Middle-earth???");
        window.setSize(600,600);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public void doDrawing(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(10,10,480,480);
        for(int row = 0; row<500; row++){
            for(int col = 0; col<500; col++){
                if(Map.world[row][col] != null){
                    g2d.setColor(Map.world[row][col].color());
                    g2d.fillRect(row, col, 10, 10);
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        //super.paintComponent(g);
        doDrawing(g);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource().equals(timer)){
            repaint();
            for(Creature[] f : Map.world){
                for(Creature c : f){
                    if(c != null){
                       c.chooseAction();
                       //break;
                    } 
                }
            }
            
        }
           
    }
}
