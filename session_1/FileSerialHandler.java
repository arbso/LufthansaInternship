package session_1;

import java.io.*;


public class FileSerialHandler {

	public FileSerialHandler() {
	}

	public void save(User u){
		try{
			FileOutputStream fout = new FileOutputStream(u.firstName+u.lastName+".ser");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(u);
			oout.close();
			fout.close();
		}
		catch(IOException e)
		{
			System.out.println("IOException in save");
			e.printStackTrace();
		}
	}

	public Object displayAnswers(Survey s, User u){
		Object result = null;
		try {
			FileInputStream fis = new FileInputStream(s.surveyName+u.firstName+".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			result = ois.readObject();
		} catch(IOException e)
		{
			System.out.println("IOException in save");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	return result;
	}

	public void saveUserAnswers(Survey s, User u){
		try{
			FileOutputStream fout = new FileOutputStream(s.surveyName+u.firstName+".ser");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(s);
			oout.close();
			fout.close();
		}
		catch(IOException e)
		{
			System.out.println("IOException in save");
			e.printStackTrace();
		}
	}


	public void save(Survey s)
	{
		try{
		FileOutputStream fout = new FileOutputStream(s.surveyName+".ser");
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		oout.writeObject(s);
		oout.close();
		fout.close();
		}
		catch(IOException e)
		{
			System.out.println("IOException in save");
			e.printStackTrace();
		}
		
	}
	
	public void saveUserSurveyData (Survey s, User u, Survey a) throws IOException {

		FileWriter fw = new FileWriter("userAnswers.txt",true);


		fw.append("Emri i survey-t: "+s.surveyName+" "+"Emri i perdoruesit: "+u.firstName+" " +
				" "+u.lastName+" "+"Pergjigjet: "+s.userAnswers+"\n");


		fw.close();
	}

	public void displayAnswersList(){
		try (BufferedReader br = new BufferedReader(new FileReader("userAnswers.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Survey load(String path)
	{
		try
	      {
			FileInputStream fin = new FileInputStream(path+ ".ser");
	        ObjectInputStream oin = new ObjectInputStream(fin);
	        Survey s = (Survey) oin.readObject();
	        oin.close();
	        fin.close();
	        return s;
	      }
		catch(IOException e)
	      {
			System.out.println("IOException in load");
	        e.printStackTrace();
	        return null;
	      }
		catch(ClassNotFoundException c)
	      {
			System.out.println("IOException in save");
	         c.printStackTrace();
	         return null;
	       }
	}

	public User userload(String path)
	{
		try
		{
			FileInputStream fin = new FileInputStream(path+ ".ser");
			ObjectInputStream oin = new ObjectInputStream(fin);
			User u = (User) oin.readObject();
			oin.close();
			fin.close();
			return u;
		}
		catch(IOException e)
		{
			System.out.println("IOException in load");
			e.printStackTrace();
			return null;
		}
		catch(ClassNotFoundException c)
		{
			System.out.println("IOException in save");
			c.printStackTrace();
			return null;
		}
	}

}
