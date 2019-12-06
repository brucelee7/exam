package ui;

import models.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainForm extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
    JLabel time;
    ArrayList<JButton> questions;
    ArrayList<ArrayList<String>> answers;
    JRadioButton radioButtons[];
    JLabel title;
    int index;
    public MainForm(){
        super("ONLINE EXAMINATION SYSTEM");
        time = new JLabel();
        questions = new ArrayList<>(10);
        answers = new ArrayList<>(10);
        radioButtons = new JRadioButton[]{};
        title = new JLabel();
        index = 0;

        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        JPanel panelBottomLeft = new JPanel();
        JPanel panelBottomRight = new JPanel();
        panelLeft.setBounds(5,5, 200, 200);
        panelRight.setBounds(210, 5, 370, 300);
        panelBottomLeft.setBounds(5, 210, 200, 145);
        panelBottomRight.setBounds(210, 310, 370, 45);
        panelLeft.setBackground(Color.BLACK);
        panelRight.setBackground(Color.red);
        panelBottomLeft.setBackground(Color.CYAN);
        panelBottomRight.setBackground(Color.darkGray);
        panelLeft.setLayout(new FlowLayout(FlowLayout.LEADING));
        panelLeft.add(new JLabel("Chọn xem các câu hỏi khác: "));
        for(int i = 0; i < 10; i++){
            JButton jButton = new JButton(String.valueOf(i));
            jButton.setSize(80, 80);
            questions.add(jButton);
            panelLeft.add(questions.get(i));
        }
        panelRight.setLayout(null);
        ButtonGroup buttonGroup = new ButtonGroup();




        add(panelLeft);
        add(panelRight);
        add(panelBottomLeft);
        add(panelBottomRight);
        setBounds(400,150,600, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    private void getData(int i){
        index = i;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList = answers.get(index);
        title.setText(arrayList.get(0));
        radioButtons[0] = new JRadioButton(arrayList.get(1));
        radioButtons[1] = new JRadioButton(arrayList.get(2));
        radioButtons[2] = new JRadioButton(arrayList.get(3));
        radioButtons[3] = new JRadioButton(arrayList.get(4));
        title.setBounds(10, 10, 50, 20);
        for(int j = 0; j < 4; j++){
            radioButtons[j].setBounds(20, 10 + 2 * j, 50, 20);
        }
    }

    public static void main(String[] args) {
        new MainForm();
    }

}
