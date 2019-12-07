package controller;

import models.Question;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class ApiImpl extends UnicastRemoteObject implements ApiInterface {

    protected ApiImpl() throws RemoteException {
    }

    @Override
    public ArrayList<ArrayList<String>> getQuestions() throws RemoteException {
        Question ques = new Question();
        ArrayList<ArrayList<String>> al = new ArrayList<>();
        ArrayList<ArrayList<String>> t = ques.getQuestions();
        Random rand = new Random();
        int c;
        ArrayList<Integer> alt = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            c = rand.nextInt(15);
            if(alt.contains(c)){
                i--;
                continue;
            } else {
                al.add(t.get(c));
                alt.add(c);
            }
        }
        return al;
    }

    @Override
    public String[] checkUser(String user, String pass) throws RemoteException {
        String r[] = new String[2];
        ArrayList<String> check = new ArrayList<>();
        if(user.equals("") || pass.equals("")){
            r[0] = "0";
            r[1] = "PASSWORD, EMAIL EMPTY !!!";
            return r;
        }
        // Ky tu or: |
        String regexEmail = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
        if(user.matches(regexEmail) == false || !pass.equals("empty")){
            r[0] = "0";
            r[1] = "INVALID EMAIL, PASSWORD !!!";
            return r;
        }
        if(check.contains(user)){
            r[0] = "0";
            r[1] = "CANNOT ACCESS THIS USER !!!";
        }
        r[0] = "1";
        r[1] = "";
        check.add(user);
        return r;
    }
}
