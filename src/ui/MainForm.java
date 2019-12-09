package ui;

import controller.ApiInterface;
import models.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Random;

public class MainForm extends JFrame implements ActionListener {
    JLabel lbTime;
    ArrayList<JButton> btnSelectQuestion;
    ArrayList<ArrayList<String>> examQuestions;
    JLabel lbQuestion[];
    ArrayList<JRadioButton[]> rbtnAnswerQuestion;
    JButton btnNext, btnEnd;
    int index;
    ApiInterface api;
    static String token = "";

    public MainForm(String user) {
        super("ONLINE EXAMINATION SYSTEM");
        lbTime = new JLabel();
        btnSelectQuestion = new ArrayList<>(10);
        examQuestions = new ArrayList<>(10);
        rbtnAnswerQuestion = new ArrayList<>(10);
        lbQuestion = new JLabel[10];
        index = 0;
        btnNext = new JButton();
        btnEnd = new JButton("  Kết thúc ");
        token = user;
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry("localhost", 7799);
            api = (ApiInterface)registry.lookup("data");
            examQuestions = api.getExamQuestions();
        } catch (RemoteException e) {
        } catch (NotBoundException e) {
        }
        initData();
        createUI();
        addEvent();
        new CountingTime().start();
    }

    private void initData() {
        for(int i = 0; i < examQuestions.size(); i++){
            lbQuestion[i] = new JLabel();
            lbQuestion[i].setText(examQuestions.get(i).get(0));
            lbQuestion[i].setFont(new Font("TimesRoman", Font.BOLD, 12));
            lbQuestion[i].setBounds(10, 10, 360, 50);
            JRadioButton radioButton[] = new JRadioButton[4];
            for (int j = 0; j < 4; j++) {
                radioButton[j] = new JRadioButton(examQuestions.get(i).get(j + 1));
                radioButton[j].setBounds(50, 60 + 40 * j, 300, 20);
                radioButton[j].setFont(new Font("TimesRoman", Font.ITALIC, 12));
            }
            rbtnAnswerQuestion.add(radioButton);
        }
    }

    public void createUI() {
        getContentPane().removeAll();
        getContentPane().validate();
        getContentPane().repaint();
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
            btnSelectQuestion.add(new JButton(String.valueOf(i)));
            btnSelectQuestion.get(i).setFont(new Font("TimesRoman", Font.PLAIN, 12));
            panelLeft.add(btnSelectQuestion.get(i));
        }
        btnSelectQuestion.get(index).setEnabled(false);
        btnEnd.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        panelLeft.add(btnEnd);

        panelRight.setLayout(null);
        ButtonGroup buttonGroup = new ButtonGroup();
        panelRight.add(lbQuestion[index]);

        for (int i = 0; i < 4; i++) panelRight.add(rbtnAnswerQuestion.get(index)[i]);
        for (int i = 0; i < 4; i++) buttonGroup.add(rbtnAnswerQuestion.get(index)[i]);
        panelBottomRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnNext.setText("Next");
        btnNext.setFont(new Font("TimesRoman", Font.BOLD, 12));
        panelBottomRight.add(btnNext);

        panelBottomLeft.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel t1 = new JLabel("Thời gian còn lại:");
        t1.setFont(new Font("TimesRoman", Font.BOLD, 20));
        lbTime.setFont(new Font("TimesRoman", Font.BOLD, 20));
        panelBottomLeft.add(t1);
        panelBottomLeft.add(lbTime);


        add(panelLeft);
        add(panelRight);
        add(panelBottomLeft);
        add(panelBottomRight);
        setBounds(400, 150, 600, 400);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    private void endUI() {
        getContentPane().removeAll();
        getContentPane().validate();
        getContentPane().repaint();
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
            btnSelectQuestion.add(new JButton(String.valueOf(i)));
            btnSelectQuestion.get(i).setFont(new Font("TimesRoman", Font.PLAIN, 12));
            panelLeft.add(btnSelectQuestion.get(i));
        }
        panelBottomRight.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnNext.setText("Nộp bài");
        btnNext.setFont(new Font("TimesRoman", Font.BOLD, 12));
        panelBottomRight.add(btnNext);
        JLabel t1 = new JLabel("Thời gian còn lại:");
        t1.setFont(new Font("TimesRoman", Font.BOLD, 20));
        lbTime.setFont(new Font("TimesRoman", Font.BOLD, 20));
        panelBottomLeft.add(t1);
        panelBottomLeft.add(lbTime);


        add(panelLeft);
//        add(panelRight);
        add(panelBottomLeft);
        add(panelBottomRight);
        setBounds(400, 150, 600, 400);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    private void addEvent() {
        for (int i = 0; i < 10; i++) {
            btnSelectQuestion.get(i).addActionListener(this);
        }
        btnEnd.addActionListener(this);
        btnNext.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                requestClose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (int i = 0; i < 10; i++) {
            if (actionEvent.getSource() == btnSelectQuestion.get(i)) {
                index = Integer.parseInt(btnSelectQuestion.get(i).getText());
            }
            btnSelectQuestion.get(i).setEnabled(true);
        }
        if (actionEvent.getSource() == btnEnd) index = 10;
        if (actionEvent.getSource() == btnNext && index >= 10) countMark();
        if (actionEvent.getSource() == btnNext && index < 10) index++;
        createUI();
    }

    private void countMark() {
        int countMark = 0;
        for(int i = 0; i < examQuestions.size(); i++){
            String t = "";
            for(int j = 0; j < rbtnAnswerQuestion.size(); j++){
                if(rbtnAnswerQuestion.get(i)[j].isSelected()){
                    t = rbtnAnswerQuestion.get(i)[j].getText();
                }
            }
            if(examQuestions.get(i).get(5).equals(t)) countMark++;
        }
        JOptionPane.showMessageDialog(this, "Bạn đã hoàn thành " + countMark + "/10");
        try {
            api.showStatistic(token);
        } catch (RemoteException e) {
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);
        System.exit(0);
    }
    private void requestClose(){
        int c = JOptionPane.showConfirmDialog(this, "Xác nhận để thoát bài thi?");
        if(c == JOptionPane.YES_OPTION){
            countMark();
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
                    lbTime.setText(tTime);
                    sleep(1000);
                    cTime--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            countMark();

        }
    }

    public static void main(String[] args) {
        new MainForm("");
    }

}
