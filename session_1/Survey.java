package session_1;

import java.util.ArrayList;
import java.util.Scanner;


public class Survey implements java.io.Serializable {

    public Survey() {
    }
    public String surveyName;
    public String surveyTopic;
    public String surveyDescription;
    ArrayList<Question> questions = new ArrayList<Question>();
    ArrayList<String> userAnswers = new ArrayList<String>();
    public int input;
    public String stringInput;

    public void display()
    {

    }

    public void take()
    {
        for (Question question:questions) {
            question.take();
            switch (question.answer) {
                case 1:
                userAnswers.add(question.questionTitle+": "+ "Agree");
                break;
                case 2:
                userAnswers.add(question.questionTitle+": "+ "Slightly Agree");
                break;
                case 3:
                userAnswers.add(question.questionTitle+": "+ "Slightly Disagree");
                break;
                case 4:
                userAnswers.add(question.questionTitle+": "+ "Disagree");
                break;
            }
        }
    }

    public void edit()
    {
        for (Question question:questions)
        {
            System.out.println(question.questionTitle);
            System.out.println("Ndrysho titullin e pyetjes? y/n");
            Scanner s = new Scanner(System.in);
            String choice = s.nextLine();
            if(choice.equals("y"))
            {
                question.edit();
            }
            System.out.println("Fshi pyetjen? y/n");
            choice = s.nextLine();
            if(choice.equals("y")){
                questions.remove(question);
            }
        }
    }



}
