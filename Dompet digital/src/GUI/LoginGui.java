package GUI;

import Controller.AllObjectController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGui extends JFrame{
    public LoginGui () {comp();}
    JLabel email = new JLabel("EMAIL");
    JLabel pass = new JLabel("PASSWORD");
    JButton btnlogin = new JButton("LOGIN");
    JButton btnregis = new JButton("REGISTRASI");
    JTextField jtxtemail = new JTextField();
    JPasswordField jtxtpass = new JPasswordField();

    void kosong (){
        jtxtemail.setText(null);
        jtxtpass.setText(null);
    }
    private void comp(){
        setTitle("LOGIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        email.setBounds(35, 250, 40, 25);
        add(email);
        jtxtemail.setBounds(130, 258, 130,25);
        add(jtxtemail);

        pass.setBounds(35,290,100,25);
        add(pass);
        jtxtpass.setBounds(130, 300, 130, 25);
        add(jtxtpass);

        btnlogin.setBounds(120,350,100,25);
        btnlogin.setBackground(Color.green);
        btnlogin.setForeground(Color.white);
        btnlogin.setBorder(null);
        add(btnlogin);

        btnregis.setBounds(100,380,100,25);
        btnregis.setBorder(null);
        btnregis.setBackground(Color.white);
        add(btnregis);

        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = jtxtemail.getText();
                String pass = jtxtpass.getText();
                int cek = AllObjectController.user.login(email,pass);
                if (cek>0){
                    dispose();
                    new UserGui(cek).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "GAGAL Login");
                    kosong();
                }
            }
        });

        btnregis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisGui().setVisible(true);
            }
        });

    }
}
