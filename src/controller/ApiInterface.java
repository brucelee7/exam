package controller;

import models.Question;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ApiInterface extends Remote {
    public ArrayList<ArrayList<String>> getQuestions() throws RemoteException;
    public String[] checkUser(String user, String pass) throws RemoteException;

}
