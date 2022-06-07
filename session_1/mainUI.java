package session_1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class mainUI {
    public static ArrayList<String> options = new ArrayList<String>();
    public static Survey survey;
    public static User user;
    public static boolean isExit = false;
    public static int intChoice;
    public static int intLog;

    public static void main(String args[]) throws IOException {
        FileSerialHandler fsh = new FileSerialHandler();
        User perdorues = new User();
        user = perdorues;
        System.out.println("Mireseerdhet.\n1) Logohu.\n2) Krijo nje user te ri.");
        Scanner logSc = new Scanner(System.in);
        String log = logSc.nextLine();

        if(isInt(log))
        {
            intLog = Integer.parseInt(log);
        }
        else
        {
            intLog = -99999;
        }
        switch (intLog) {
            case 1:
            {
                System.out.println("Vendosni emrin e perdoruesit.");
                String username = logSc.nextLine();
                user = fsh.userload(username);
                break;
            }
            case 2:
            {
                Scanner users = new Scanner(System.in);
                System.out.println("Vendosni emrin tuaj.");
                perdorues.firstName = users.nextLine();
                System.out.println("Vendosni mbiemrin tuaj.");
                perdorues.lastName = users.nextLine();
                System.out.println("Vendosni email-in tuaj.");
                perdorues.email = users.nextLine();
                System.out.println("Vendosni numrin tuaj te telefonit.");
                perdorues.phoneNumber = users.nextLine();
                fsh.save(user);
                break;
            }
        }




        while(isExit==false)
        {
            System.out.println("1) Shto nje Survey");
            System.out.println("2) Ruaj nje Survey");
            System.out.println("3) Selekto nje survey");
            System.out.println("4) Fillo nje Survey"); //9
            System.out.println("5) Ndrysho nje Survey"); //11
            System.out.println("6) Shfaq pergjigjet"); //11
            System.out.println("7) Dil"); //16



            Scanner scan = new Scanner(System.in);
            String choice = scan.nextLine();
            if(isInt(choice))
            {
                intChoice = Integer.parseInt(choice);
            }
            else
            {
                intChoice = -99999;
            }

            switch (intChoice) {
                case 1:
                {
                    Survey createdSurvey = new Survey();
                    survey = createdSurvey;

                    System.out.println("Vendos emrin e Survey-t: ");
                    survey.surveyName = scan.nextLine();
                    System.out.println("Vendos temen e Survey-t: ");
                    survey.surveyTopic = scan.nextLine();
                    System.out.println("Vendos pershkrimin e Survey-t: ");
                    survey.surveyDescription = scan.nextLine();

                    System.out.println(survey.surveyName + " filloi. Suvery juaj duhet te kete te pakten 10 pyetje.");
                    int i=0;
                    boolean isCreate = true;
                    boolean moreThanTen = false;
                    while(isCreate)
                    {

                        System.out.println("1) Shto nje pyetje");
                        System.out.println("2) Dil");
                        System.out.println("3) Kancelo");

                        choice = scan.nextLine();
                        if(isInt(choice))
                        {
                            intChoice = Integer.parseInt(choice);
                        }
                        else
                        {
                            intChoice = -99999;
                        }

                        switch (intChoice)
                        {
                            case 1:
                            {
                                Question mcq = new Question();
                                mcq.create();
                                survey.questions.add(mcq);
                                i++;
                                break;
                            }
                            case 2: {
                                if (i >=10 && i<=40){
                                    isCreate = false;
                                }else{
                                    System.out.println("Nuk mund te krijoni nje survey me me pak se 10 pyetje ose me shume se 40 pyetje.");
                                }
                                break;
                            }
                            case 3:{
                                isCreate = false;
                                survey.questions.removeAll(survey.questions);
                            }

                        }
                    }


                    break;
                }
                case 2:
                {
                    if(survey.questions.size()<10)
                    {
                        System.out.println("Nuk ka survey per t'u ruajtur.");
                    }
                    else
                    {
                        fsh.save(survey);

                        System.out.println(survey.surveyName + " u ruajt.");
                    }
                    break;
                }
                case 3:
                {
                    System.out.println("Vendos emrin e survey-t te cilit do te selektosh. ");
                    choice = scan.nextLine();
                    survey = fsh.load(choice);
                    System.out.println(survey.surveyName + " u selektua.");
                    break;
                }
                case 4:
                {
                    if(survey==null)
                    {
                        System.out.println("Nuk u gjet survey.");
                    }
                    else
                    {
                        survey.take();
//                        fsh.saveUserAnswers(survey,user);
                        fsh.saveUserSurveyData(survey,user,survey);
                    }
                    break;
                }

                case 5:
                {
                    if(survey==null)
                    {
                        System.out.println("Nuk u gjet survey.");
                    }
                    else
                    {
                        survey.edit();
                    }
                    break;
                }

                case 6:
                {
                    fsh.displayAnswersList();
//                    System.out.println("Emri i survey-t: "+survey.surveyName+"\n"+"Emri i perdoruesit: "+user.firstName+" "+user.lastName+"\n"+"Pergjigjet: "+survey.userAnswers);
                    break;
                }
                case 7:
                {
                    isExit = true;
                    break;
                }
                default:
                {
                    System.out.println("Vendos nje numer valid.");
                    break;
                }
            }
        }
    }

    private static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
        }
        catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

}
