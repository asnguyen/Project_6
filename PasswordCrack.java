import java.io.*;
import java.util.*;

public class PasswordCrack
{
	public static void main(String args[])
	{
		System.out.println("Program Start");
		Scanner sc = new Scanner(new File)
		extract("","","");
		System.out.println("Program End");
	}

	public static String passwordCrack(String line)
	{
		return "";
	}

	public static void extract(String line, String pass, String salt)
	{
		line = "michael:atbWfKL4etk4U:500:500:Michael Ferris:/home/michael:/bin/bash";
		String[] _line = line.split(":");
		pass = _line[1];
		salt = pass.substring(0,2);
		pass = pass.substring(2);
		System.out.println(salt);
		System.out.println(pass);

	}

	public static String passwordGen(String salt, String word)
	{
		String ret;
		
		return ret;
	}
}