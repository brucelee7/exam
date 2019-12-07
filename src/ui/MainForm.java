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
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (int i = 0; i < 10; i++) {
            if ((JButton) actionEvent.getSource() == questions.get(i)) {
                index = Integer.parseInt(questions.get(i).getText());
            }
            questions.get(i).setEnabled(true);
        }
        if (actionEvent.getSource() == end) index = 10;
        if (actionEvent.getSource() == next && index >= 10) countMark();
        if (actionEvent.getSource() == next && index < 10) index++;

        System.out.println(index);
        createUI();

    }

    private void countMark() {
        int count = 0;
        for(int i = 0; i < 10; i++){
            String t = "";
            for(int j = 0; j < 4; j++){
                if(mark.get(i)[j].isSelected()){
                    t = mark.get(i)[j].getText();
                }
            }
            if(answers.get(i).get(5).equals(t)) count++;
        }
        JOptionPane.showMessageDialog(this, "Bạn đã hoàn thành " + count + "/10");
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

    JLabel time;
    ArrayList<JButton> questions;
    ArrayList<ArrayList<String>> answers;
    JLabel title[];
    JButton next, end;
    int index;
    ArrayList<JRadioButton[]> mark;

    public MainForm() {
        super("ONLINE EXAMINATION SYSTEM");
        time = new JLabel();
        questions = new ArrayList<>(10);
        answers = new ArrayList<>(10);
        mark = new ArrayList<>(10);
        title = new JLabel[10];
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
        setData();
        createUI();
        addEvent();
        new CountingTime().start();
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
            questions.add(new JButton(String.valueOf(i)));
            questions.get(i).setFont(new Font("TimesRoman", Font.PLAIN, 12));
            panelLeft.add(questions.get(i));
        }
        questions.get(index).setEnabled(false);
        end.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        panelLeft.add(end);

        panelRight.setLayout(null);
        ButtonGroup buttonGroup = new ButtonGroup();
        panelRight.add(title[index]);

        for (int i = 0; i < 4; i++) panelRight.add(mark.get(index)[i]);
        for (int i = 0; i < 4; i++) buttonGroup.add(mark.get(index)[i]);
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
            questions.add(new JButton(String.valueOf(i)));
            questions.get(i).setFont(new Font("TimesRoman", Font.PLAIN, 12));
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
            questions.get(i).addActionListener(this);
        }
        end.addActionListener(this);
        next.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                requestClose();
            }
        });


    }

    private void setData() {
        for(int i = 0; i < answers.size(); i++){
            title[i] = new JLabel();
            title[i].setText(answers.get(i).get(0));
            title[i].setFont(new Font("TimesRoman", Font.BOLD, 12));
            title[i].setBounds(10, 10, 360, 50);
            JRadioButton radioButton[] = new JRadioButton[4];
            for (int j = 0; j < 4; j++) {
                radioButton[j] = new JRadioButton(answers.get(i).get(j + 1));
                radioButton[j].setBounds(50, 60 + 40 * j, 300, 20);
                radioButton[j].setFont(new Font("TimesRoman", Font.ITALIC, 12));
            }
            mark.add(radioButton);
        }
    }

    class CountingTime extends Thread {
        private int cTime = 1 * 60;

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
            countMark();

        }
    }

    public static void main(String[] args) {
        new MainForm();
    }

}
