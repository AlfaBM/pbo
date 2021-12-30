package GUI;

import Controller.AllObjectController;
import Entity.User;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class UserGui extends JFrame{
    String email, pass, nama, noktp, notelp, alamat;
    int id, saldo;

    public UserGui(int cek){comp(cek);}
    JLabel welcome = new JLabel();
    JLabel lbsaldo = new JLabel();

    JButton btntopup = new JButton("Top Up");
    JButton btnTrans = new JButton("Tranfers");

    public void comp(final int cek){
        for (User userentity : AllObjectController.user.getByid(cek)) {
            this.id = userentity.getId();
            this.email = userentity.getEmail();
            this.pass = userentity.getPass();
            this.nama = userentity.getNama();
            this.noktp = userentity.getNoktp();
            this.notelp = userentity.getNotelp();
            this.alamat = userentity.getAlamat();
            this.saldo = userentity.getSaldo();
        }
        setTitle("DOMPET DIGITAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        welcome.setBounds(50,50,100,25);
        welcome.setText("Welcome " + nama);
        add(welcome);

        lbsaldo.setBounds(50,70,100,25);
        add(lbsaldo);

        btntopup.setBounds(250,150,100,25);
        btntopup.setForeground(Color.black);
        btntopup.setBorder(null);
        add(btntopup);

        btnTrans.setBounds(250,190,100,25);
        btnTrans.setForeground(Color.black);
        btnTrans.setBorder(null);
        add(btnTrans);
    }
}
