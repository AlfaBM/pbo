package GUI;

import javax.swing.*;
import java.awt.*;

public class RegisGui extends JFrame{
    public RegisGui(){comp();}

    private void comp(){
        setTitle("Registrasi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
    }
}
