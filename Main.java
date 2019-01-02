package Cloud_Binary;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main  extends JFrame  {
    private static JFrame frame = new JFrame();
    private static Clouds clouds = new Clouds();


    private static int screen_width = 600, screen_height = 600;
    public static void main(String[] args) {
        // Setting  visibility of the frame
        frame.setVisible(true);

        // Setting Dimensions
        frame.setSize(screen_width, screen_height);

        // Title of the Main Frame
        frame.setTitle("Clouds Binary");

        // The close method
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding game Panel into the frame
        frame.add(clouds);

        // Setting image Icon
        ImageIcon img_icon = new ImageIcon("src\\Cloud_Binary\\clouds.png");

        // Getting the image preview from the ImageIcon and setting it up
        frame.setIconImage(img_icon.getImage());

        // Setting Window resizable to false

    }
}

class Clouds extends JPanel implements ActionListener {
    private Timer timer;
    private int[][] drops;
    int x = 10;
    int y = -100;
    private String[] letters = {"0","1"};
    private Random random = new Random();



    Clouds(){
        timer = new Timer(50, this);
        drops = new int[19][20];
        for(int x = 0; x< drops.length; x++){
            for(int y = 0; y < drops[0].length; y++){
                drops[x][y] = 400;

            }
        }

        timer.start();

    }



    public void paint(Graphics g){
        try {
            String image_path = "src\\Cloud_Binary\\main_cloud.png";
            final BufferedImage img;
            img = ImageIO.read(new File(image_path));
            // Background
            g.setColor(Color.BLACK);
            g.fillRect(0,0,600,600);

           for(int row = 0; row < drops.length; row++){
               for(int col = 0; col < drops[0].length;col++) {

                       g.setColor(Color.green);
                       g.setFont(new Font("Times new Roman", Font.PLAIN, 22));
                       for (int screen = 0; screen < 600; screen += 50) {
                           g.drawString(letters[random.nextInt(2)], row * 30 + 10, (col) * drops[row][col] + screen + y);


                   }
               }
           }

            if(y > 600){
                y = -1200;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        y+=20;

        repaint();
    }


}
