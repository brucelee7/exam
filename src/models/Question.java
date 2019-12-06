package models;

import java.util.ArrayList;

public class Question {
    ArrayList<ArrayList<String>> questions;
    public Question () {
        questions = new ArrayList<>();
        createQuestion();
    }
    /*
    * Question:
    *
    * */
    public void createQuestion(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Nam ........... swimming twice a week.");
        arrayList.add("is going often");
        arrayList.add("is often going");
        arrayList.add("often goes");
        arrayList.add("goes often");
        arrayList.add("often goes");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
        /**/
        arrayList.add("I think the weather ........... to bad tomorrow.");
        arrayList.add("shall");
        arrayList.add("will");
        arrayList.add("is going");
        arrayList.add("could");
        arrayList.add("will");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
        /**/
        arrayList.add("He ........... here a few minutes ago");
        arrayList.add("comes");
        arrayList.add("came");
        arrayList.add("has come");
        arrayList.add("come");
        arrayList.add("came");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
        /**/
        arrayList.add("Be quite! The students ........... the best.");
        arrayList.add("are going");
        arrayList.add("do");
        arrayList.add("are going to do");
        arrayList.add("did");
        arrayList.add("are going");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
        /**/
        arrayList.add("........... this film recently?");
        arrayList.add("Have you seen");
        arrayList.add("Did you see");
        arrayList.add("Do you see");
        arrayList.add("Are you seeing");
        arrayList.add("Have you seen");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
        /**/
        arrayList.add("Mr Nick ........... books while his wife was cooking.");
        arrayList.add("was reading");
        arrayList.add("read");
        arrayList.add("has read");
        arrayList.add("reads");
        arrayList.add("was reading");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
        /**/
        arrayList.add("When I was a litle girl, I ........... swimming with my friends.");
        arrayList.add("go");
        arrayList.add("went");
        arrayList.add("was going");
        arrayList.add("am going");
        arrayList.add("went");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
        /**/
        arrayList.add("My father ........... 60 books so far.");
        arrayList.add("writes");
        arrayList.add("wrote");
        arrayList.add("had written");
        arrayList.add("has written");
        arrayList.add("has written");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
        /**/
        arrayList.add("I ........... my old friend at the airport tonight.");
        arrayList.add("will be meeting");
        arrayList.add("meet");
        arrayList.add("am going to meet");
        arrayList.add("met");
        arrayList.add("am going to meet");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
        /**/
        arrayList.add("I haven't talked to her ........... June.");
        arrayList.add("for");
        arrayList.add("in");
        arrayList.add("since");
        arrayList.add("ever");
        arrayList.add("since");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
        /**/
        arrayList.add("This is the most interesting book I ...........");
        arrayList.add("read");
        arrayList.add("have ever read");
        arrayList.add("ever have read");
        arrayList.add("had read");
        arrayList.add("have ever read");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
        /**/
        arrayList.add("He has't taught here ........... ages.");
        arrayList.add("since");
        arrayList.add("in");
        arrayList.add("on");
        arrayList.add("for");
        arrayList.add("for");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
        /**/
        arrayList.add("At this time next week I ........... in this room.");
        arrayList.add("will sit");
        arrayList.add("will have sat");
        arrayList.add("will be sitting");
        arrayList.add("will have been sitting");
        arrayList.add("will be sitting");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
        /**/
        arrayList.add("After here ........... a scholarship, he studied aboard.");
        arrayList.add("wins");
        arrayList.add("has gone");
        arrayList.add("had gone");
        arrayList.add("is winning");
        arrayList.add("had gone");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
        /**/
        arrayList.add("When I entered the room, he ........... to music.");
        arrayList.add("was listening");
        arrayList.add("listened");
        arrayList.add("has listened");
        arrayList.add("is listening");
        arrayList.add("was listening");
        questions.add(arrayList);
        for(String s : arrayList) arrayList.remove(s);
    }

    public ArrayList<ArrayList<String>> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<ArrayList<String>> questions) {
        this.questions = questions;
    }
}
