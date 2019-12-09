package models;

import java.util.ArrayList;

public class Question {
    ArrayList<ArrayList<String>> examQuestions;

    public Question() {
        examQuestions = new ArrayList<>();
        createQuestion();
    }

    /*
     * Question:
     *
     * */
    public void createQuestion() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Nam ........... swimming twice a week.");
        arrayList.add("is going often");
        arrayList.add("is often going");
        arrayList.add("often goes");
        arrayList.add("goes often");
        arrayList.add("often goes");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
        /**/
        arrayList.add("I think the weather ........... to bad tomorrow.");
        arrayList.add("shall");
        arrayList.add("will");
        arrayList.add("is going");
        arrayList.add("could");
        arrayList.add("will");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
        /**/
        arrayList.add("He ........... here a few minutes ago");
        arrayList.add("comes");
        arrayList.add("came");
        arrayList.add("has come");
        arrayList.add("come");
        arrayList.add("came");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
        /**/
        arrayList.add("Be quite! The students ........... the best.");
        arrayList.add("are going");
        arrayList.add("do");
        arrayList.add("are going to do");
        arrayList.add("did");
        arrayList.add("are going");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
        /**/
        arrayList.add("........... this film recently?");
        arrayList.add("Have you seen");
        arrayList.add("Did you see");
        arrayList.add("Do you see");
        arrayList.add("Are you seeing");
        arrayList.add("Have you seen");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
        /**/
        arrayList.add("Mr Nick ........... books while his wife was cooking.");
        arrayList.add("was reading");
        arrayList.add("read");
        arrayList.add("has read");
        arrayList.add("reads");
        arrayList.add("was reading");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
        /**/
        arrayList.add("When I was a litle girl, I ........... swimming with my friends.");
        arrayList.add("go");
        arrayList.add("went");
        arrayList.add("was going");
        arrayList.add("am going");
        arrayList.add("went");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
        /**/
        arrayList.add("My father ........... 60 books so far.");
        arrayList.add("writes");
        arrayList.add("wrote");
        arrayList.add("had written");
        arrayList.add("has written");
        arrayList.add("has written");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
        /**/
        arrayList.add("I ........... my old friend at the airport tonight.");
        arrayList.add("will be meeting");
        arrayList.add("meet");
        arrayList.add("am going to meet");
        arrayList.add("met");
        arrayList.add("am going to meet");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
        /**/
        arrayList.add("I haven't talked to her ........... June.");
        arrayList.add("for");
        arrayList.add("in");
        arrayList.add("since");
        arrayList.add("ever");
        arrayList.add("since");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
        /**/
        arrayList.add("This is the most interesting book I ...........");
        arrayList.add("read");
        arrayList.add("have ever read");
        arrayList.add("ever have read");
        arrayList.add("had read");
        arrayList.add("have ever read");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
        /**/
        arrayList.add("He has't taught here ........... ages.");
        arrayList.add("since");
        arrayList.add("in");
        arrayList.add("on");
        arrayList.add("for");
        arrayList.add("for");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
        /**/
        arrayList.add("At this time next week I ........... in this room.");
        arrayList.add("will sit");
        arrayList.add("will have sat");
        arrayList.add("will be sitting");
        arrayList.add("will have been sitting");
        arrayList.add("will be sitting");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
        /**/
        arrayList.add("After here ........... a scholarship, he studied aboard.");
        arrayList.add("wins");
        arrayList.add("has gone");
        arrayList.add("had gone");
        arrayList.add("is winning");
        arrayList.add("had gone");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
        /**/
        arrayList.add("When I entered the room, he ........... to music.");
        arrayList.add("was listening");
        arrayList.add("listened");
        arrayList.add("has listened");
        arrayList.add("is listening");
        arrayList.add("was listening");
        examQuestions.add(arrayList);
        arrayList = new ArrayList<>();
    }

    public ArrayList<ArrayList<String>> getExamQuestions() {
        return examQuestions;
    }

    public void setExamQuestions(ArrayList<ArrayList<String>> examQuestions) {
        this.examQuestions = examQuestions;
    }
}
