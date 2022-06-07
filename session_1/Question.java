package session_1;

import java.util.ArrayList;
import java.util.Scanner;
public class Question implements java.io.Serializable{

    ArrayList<String> Choices = new ArrayList<String>();
    ArrayList<String> Answers = new ArrayList<String>();
    public String questionTitle;
    public String stringInput;
    public int answer;
    public int input = -9999;

    public void getInput()
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (isInt(s))
        {
            this.input = Integer.parseInt(s);
            answer = Integer.parseInt(s);

        }
        else
        {
            this.stringInput = s;
            answer = Integer.parseInt(s);
        }
    }

    public void create()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Shkruani pyetjen ");
        this.questionTitle = scan.nextLine();
        boolean addingChoices = true;

        this.Choices.add("1) Agree");
        this.Choices.add("2) Slightly Agree");
        this.Choices.add("3) Slightly Disagree");
        this.Choices.add("4) Disagree");


    }

    public void take()
    {
        System.out.println(this.questionTitle);
        for(String choice:this.Choices)
        {
            System.out.println(choice);

        }
        this.getInput();
    }

    public void edit()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Vendos nje pyetje te re");
        this.questionTitle = scan.nextLine();

        for(String mcChoice: this.Choices)
        {
            System.out.println(mcChoice);
        }

    }



    protected boolean isInt(String str) {
        try {
            Integer.parseInt(str);
        }
        catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

}
