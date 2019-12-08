package ui;

import controller.ApiInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.StringTokenizer;
import javax.swing.*;

public class LoginForm extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JTextField tf1;
    JButton btn1;
    JPasswordField p1;
    LoginForm() {
        super("ONLINE EXAMINATION SYSTEM");
        l1 = new JLabel("USER LOGIN");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l4 = new JLabel();
        l4.setForeground(Color.red);
        l4.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Email");
        l3 = new JLabel("Password");
        tf1 = new JTextField();
        p1 = new JPasswordField();
        btn1 = new JButton("Login");

        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        p1.setBounds(300, 110, 200, 30);
        btn1.setBounds(150, 160, 100, 30);
        l4.setBounds(150, 200, 300, 30);
        l4.setVisible(false);
        btn1.addActionListener(this);

        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(p1);
        add(l4);
        add(btn1);

        setBounds(400, 150, 600, 320);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String email = tf1.getText().trim();
        String pwd = new String(p1.getPassword());
        String r[] = new String[2];
        Registry registry;
        ApiInterface api;
        try {
            registry = LocateRegistry.getRegistry("localhost", 7799);
            api = (ApiInterface) registry.lookup("data");
            r = api.checkUser(email, pwd);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        if(r[0].equals("1")){
            setVisible(false);
            new MainForm(email);
        } else {
            l4.setText(r[1]);
            l4.setVisible(true);
        }


    }
}
