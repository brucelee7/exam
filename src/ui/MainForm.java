package ui;

import controller.ApiInterface;
import models.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Random;

public class MainForm extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (int i = 0; i < 10; i++) {
            if (actionEvent.getSource() == questions.get(i)) {
                index = Integer.parseInt(questions.get(i).getText());
            }
        }
        if (actionEvent.getSource() == end) index = 10;
        if (actionEvent.getSource() == next && index < 10) index++;
        createUI();
        if (actionEvent.getSource() == next && index >= 10) countMark();

    }

    private void countMark() {
    }

    JLabel time;
    ArrayList<JButton> questions;
    ArrayList<ArrayList<String>> answers;
    JRadioButton radioButtons[];
    JLabel title;
    JButton next, end;
    int index;

    public MainForm() {
        super("ONLINE EXAMINATION SYSTEM");
        time = new JLabel();
        questions = new ArrayList<>(10);
        answers = new ArrayList<>(10);
        radioButtons = new JRadioButton[4];
        title = new JLabel();
        index = 0;
        next = new JButton();
        end = new JButton("  Kết thúc ");
        Registry registry;
        ApiInterface api;
        try {
            registry = LocateRegistry.getRegistry("localhost", 7799);
            api = (ApiInterface)registry.lookup("data");
            answers = api.getQuestions();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        createUI();
        addEvent();
        new CountingTime().start();
    }

    public void createUI() {
        if (index == 10) {
            endUI();
            return;
        }
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        JPanel panelBottomLeft = new JPanel();
        JPanel panelBottomRight = new JPanel();
        panelLeft.setBounds(5, 5, 200, 200);
        panelRight.setBounds(210, 5, 370, 300);
        panelBottomLeft.setBounds(5, 210, 200, 145);
        panelBottomRight.setBounds(210, 310, 370, 45);
        panelLeft.setBackground(Color.lightGray);
//        panelRight.setBackground(Color.lightGray);
        panelBottomLeft.setBackground(Color.lightGray);
//        panelBottomRight.setBackground(Color.lightGray);
        panelLeft.setLayout(new FlowLayout(FlowLayout.LEADING));
        JLabel t = new JLabel("Chọn xem các câu hỏi khác: ");
        t.setFont(new Font("TimesRoman", Font.BOLD, 12));
        panelLeft.add(t);
        for (int i = 0; i < 10; i++) {
            JButton jButton = new JButton(String.valueOf(i));
            jButton.setSize(50, 50);
            jButton.setFont(new Font("TimesRoman", Font.PLAIN, 12));
            questions.add(jButton);
            panelLeft.add(questions.get(i));
        }
        end.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        panelLeft.add(end);
        panelRight.setLayout(null);
        ButtonGroup buttonGroup = new ButtonGroup();
        setData(index);
        panelRight.add(title);
        for (int i = 0; i < 4; i++) panelRight.add(radioButtons[i]);
        for (int i = 0; i < 4; i++) buttonGroup.add(radioButtons[i]);
        panelBottomRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
        next.setText("Next");
        next.setFont(new Font("TimesRoman", Font.BOLD, 12));
        panelBottomRight.add(next);
        panelBottomLeft.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel t1 = new JLabel("Thời gian còn lại:");
        t1.setFont(new Font("TimesRoman", Font.BOLD, 20));
        time.setFont(new Font("TimesRoman", Font.BOLD, 20));
        panelBottomLeft.add(t1);
        panelBottomLeft.add(time);


        add(panelLeft);
        add(panelRight);
        add(panelBottomLeft);
        add(panelBottomRight);
        setBounds(400, 150, 600, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void endUI() {
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        JPanel panelBottomLeft = new JPanel();
        JPanel panelBottomRight = new JPanel();
        panelLeft.setBounds(5, 5, 200, 200);
//        panelRight.setBounds(210, 5, 370, 300);
        panelBottomLeft.setBounds(5, 210, 200, 145);
        panelBottomRight.setBounds(210, 210, 370, 45);
        panelLeft.setBackground(Color.lightGray);
//        panelRight.setBackground(Color.lightGray);
        panelBottomLeft.setBackground(Color.lightGray);
//        panelBottomRight.setBackground(Color.lightGray);
        panelLeft.setLayout(new FlowLayout(FlowLayout.LEADING));
        JLabel t = new JLabel("Chọn xem các câu hỏi khác: ");
        t.setFont(new Font("TimesRoman", Font.BOLD, 12));
        panelLeft.add(t);
        for (int i = 0; i < 10; i++) {
            JButton jButton = new JButton(String.valueOf(i));
            jButton.setSize(50, 50);
            jButton.setFont(new Font("TimesRoman", Font.PLAIN, 12));
            questions.add(jButton);
            panelLeft.add(questions.get(i));
        }
        panelBottomRight.setLayout(new FlowLayout(FlowLayout.CENTER));
        next.setText("Nộp bài");
        next.setFont(new Font("TimesRoman", Font.BOLD, 12));
        panelBottomRight.add(next);
        JLabel t1 = new JLabel("Thời gian còn lại:");
        t1.setFont(new Font("TimesRoman", Font.BOLD, 20));
        time.setFont(new Font("TimesRoman", Font.BOLD, 20));
        panelBottomLeft.add(t1);
        panelBottomLeft.add(time);


        add(panelLeft);
        add(panelRight);
        add(panelBottomLeft);
        add(panelBottomRight);
    }

    private void addEvent() {
        for (int i = 0; i < 10; i++) questions.get(i).addActionListener(this);
        end.addActionListener(this);
        next.addActionListener(this);

    }

    private void setData(int i) {
        index = i;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList = answers.get(index);
        title.setText(arrayList.get(0));
        title.setFont(new Font("TimesRoman", Font.BOLD, 12));
        radioButtons[0] = new JRadioButton(arrayList.get(1));
        radioButtons[1] = new JRadioButton(arrayList.get(2));
        radioButtons[2] = new JRadioButton(arrayList.get(3));
        radioButtons[3] = new JRadioButton(arrayList.get(4));
        title.setBounds(10, 10, 360, 50);
        for (int j = 0; j < 4; j++) {
            radioButtons[j].setBounds(50, 60 + 40 * j, 300, 20);
            radioButtons[j].setFont(new Font("TimesRoman", Font.ITALIC, 12));
        }
    }

    class CountingTime extends Thread {
        private int cTime = 15 * 60;

        @Override
        public void run() {
            while (cTime != -1) {
                try {
                    String tTime = (cTime / 60) + ":";
                    if (cTime % 60 == 0) tTime += "00";
                    else if (cTime % 60 < 10) tTime += "0" + cTime % 60;
                    else tTime += cTime % 60;
                    time.setText(tTime);
                    sleep(1000);
                    cTime--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        new MainForm();
    }

}
