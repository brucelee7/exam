package controller;

import models.Question;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class ApiImpl extends UnicastRemoteObject implements ApiInterface {
    private ArrayList<String> users;

    protected ApiImpl() throws RemoteException {
        super();
        users = new ArrayList<>();
    }

    int count = 0;

    @Override
    public ArrayList<ArrayList<String>> getExamQuestions() throws RemoteException {
        Question ques = new Question();
        ArrayList<ArrayList<String>> questions = new ArrayList<>();
        ArrayList<ArrayList<String>> examQuestions = ques.getExamQuestions();
        Random rand = new Random();
        int c;
        int s = examQuestions.size();
        for (int i = 0; i < 10; i++) {
            c = rand.nextInt(15 - i);
            questions.add(examQuestions.get(c));
            // Xóa để không chọn lặp lại câu hỏi
            examQuestions.remove(examQuestions.get(c));
        }
        return questions;
    }

    @Override
    public String[] checkUser(String email, String pass) throws RemoteException {
        String res[] = new String[2];
        if (email.equals("") || pass.equals("")) {
            res[0] = "0";
            res[1] = "PASSWORD, EMAIL EMPTY !!!";
            return res;
        }
        String regexEmail = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)(\\.([a-zA-Z]{2,5})){1,3}$";
        // Tương ứng: A@B.C
        // A tương ứng: ^([a-zA-Z0-9_\-\.]+) -> Bắt đầu phải có các ký tự a->z, A->Z, 0->9, _, -, .
        // B tương ứng: ([a-zA-Z0-9_\-\.]+) -> Phải có các ký tự như trên
        // C tương ứng: (\\.([a-zA-Z]{2,5})){1,3}$ ->
        // Phải có các ký tự ., a->z, A->Z ít nhất 2 - 5 ký tự, lặp lại 1 - 3 lần
        if (email.matches(regexEmail) == false || !pass.equals("empty")) {
            res[0] = "0";
            res[1] = "INVALID EMAIL, PASSWORD !!!";
            return res;
        }
        if (users.contains(email)) {
            res[0] = "0";
            res[1] = "CANNOT ACCESS THIS USER !!!";
            return res;
        }
        res[0] = "1";
        res[1] = "";
        System.out.println(email + " đã bắt đầu làm bài !!!");
        users.add(email);
        return res;
    }

    @Override
    public void showStatistic(String user) throws RemoteException {
        count++;
        System.out.println("Đã nộp bài: " + count);
        users.remove(user);
        if (users.size() == 0) count = 0;

    }
}
