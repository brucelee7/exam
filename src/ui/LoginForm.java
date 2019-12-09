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
    JLabel lbLogin, lbEmail, lbPassword, lbResponse;
    JTextField tfEmail;
    JButton btnLogin;
    JPasswordField tfPassword;
    LoginForm() {
        super("ONLINE EXAMINATION SYSTEM");
        lbLogin = new JLabel("USER LOGIN");
        lbLogin.setForeground(Color.blue);
        lbLogin.setFont(new Font("Serif", Font.BOLD, 20));
        lbResponse = new JLabel();
        lbResponse.setForeground(Color.red);
        lbResponse.setFont(new Font("Serif", Font.BOLD, 20));

        lbEmail = new JLabel("Email");
        lbPassword = new JLabel("Password");
        tfEmail = new JTextField();
        tfPassword = new JPasswordField();
        btnLogin = new JButton("Login");

        lbLogin.setBounds(100, 30, 400, 30);
        lbEmail.setBounds(80, 70, 200, 30);
        lbPassword.setBounds(80, 110, 200, 30);
        tfEmail.setBounds(300, 70, 200, 30);
        tfPassword.setBounds(300, 110, 200, 30);
        btnLogin.setBounds(150, 160, 100, 30);
        lbResponse.setBounds(150, 200, 300, 30);
        lbResponse.setVisible(false);
        btnLogin.addActionListener(this);

        add(lbLogin);
        add(lbEmail);
        add(tfEmail);
        add(lbPassword);
        add(tfPassword);
        add(lbResponse);
        add(btnLogin);

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
        String email = tfEmail.getText().trim();
        String pwd = new String(tfPassword.getPassword());
        String tmp[] = new String[2];
        Registry registry;
        ApiInterface api;
        try {
            registry = LocateRegistry.getRegistry("localhost", 7799);
            api = (ApiInterface) registry.lookup("data");
            tmp = api.checkUser(email, pwd);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        if(tmp[0].equals("1")){
            setVisible(false);
            new MainForm(email);
        } else {
            lbResponse.setText(tmp[1]);
            lbResponse.setVisible(true);
        }


    }
}