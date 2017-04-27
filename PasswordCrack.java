import java.io.*;
import java.util.*;

public class PasswordCrack
{
	public static void main(String args[])
	{
		System.out.println("Program Start");
		//Scanner sc = new Scanner(new File());
		String[] salt_passwd = extract("");
		System.out.println(salt_passwd[0]);
		System.out.println(salt_passwd[1]);
		System.out.println(jcrypt.crypt(salt_passwd[0],salt_passwd[1]));
		System.out.println("Program End");
	}

	public static String passwordCrack(String line)
	{
		return "";
	}

	public static String[] extract(String line)
	{
		line = "michael:atbWfKL4etk4U:500:500:Michael Ferris:/home/michael:/bin/bash";
		String[] _line = line.split(":");
		String[] ret  = new String[2];
		String temp  = _line[1];
		ret[0] = temp.substring(0,2);
		ret[1]= temp.substring(2);
		return ret;

	}

	public static String passwordGen(String salt, String word)
	{
		String ret = "";
		
		return ret;
	}
}