import javax.swing.*;
import java.awt.*;

class Display {
    private String value;

    Display(String value){
        this.value = value;
    }

    void createJframe() {
        JFrame frame = new JFrame ("Hex color backgorund window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground( Color.decode(value) ); // set background color
        frame.setPreferredSize(new Dimension(200, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
