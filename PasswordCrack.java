;import java.io.*;
import java.util.*;

public class PasswordCrack
{
	public static void main(String args[])
	{
		System.out.println("Program Start");
		Scanner sc = null;
		String[][] passwd_salt = new String[20][2];
		Password[] passwords = new Password[20];
		try
		{
			sc = new Scanner(new File(args[0]));
		}
		catch(Exception e){}
		String[] salt_passwd = extract("michael:atQhiiJLsT6cs:500:500:Michael Ferris:/home/michael:/bin/bash");
		long start_time = System.currentTimeMillis();
		for(int i=0;i<20;++i)
		{
			String[] temp = new String[2];
			temp = extract(sc.nextLine());
			passwd_salt[i][0] = temp[1];
			passwd_salt[i][1] = temp[0];
			passwords[i] = new Password(temp[1],temp[0]);
		}
		//dictionaryAttackSet(passwords,"wordlist.txt");
		//dictionaryAttackSet(passwords,"wordlist2.txt");
		dictionaryAttackSubtring2(passwords,"wordlist.txt");
		//dictionaryAttackToggle1(passwords,"wordlist2.txt");
		//dictionaryAttackToggle2(passwords,"wordlist2.txt");

		long endTime = System.currentTimeMillis() - start_time;
		System.out.println(endTime);
		System.out.println("Program End");
	}

	public static void dictionaryAttackSet(Password passwords[],String file)
	{
		dictionaryAttack(passwords,file);
		dictionaryAttackUpperCase(passwords,file);
		dictionaryAttackReverse(passwords,file);
		dictionaryAttackReflect1(passwords,file);
		dictionaryAttackReflect2(passwords,file);
		dictionaryAttackCap(passwords,file);
		dictionaryAttacknCap(passwords,file);
		dictionaryAttackSubtring1(passwords,file);
	}

	public static void dictionaryAttackUpperCase(Password passwords[], String file)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File(file));
		}
		catch(Exception e){}
		while(sc.hasNextLine())
		{
			String phrase = sc.nextLine();
			for(int i = 0;i<20;++i)
			{
				String password = jcrypt.crypt(passwords[i].salt,phrase.toUpperCase());
				if(!passwords[i].cracked)
				{
					if(password.equals(passwords[i].salt+passwords[i].passwd))
					{
						System.out.println("SALT: "+passwords[i].salt+" Password: "+passwords[i].passwd+" Cracked: "+phrase.toUpperCase());
						passwords[i].cracked = true;
					}
			    }
			}
		}
	}

	public static void dictionaryAttack(Password passwords[], String file)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File(file));
		}
		catch(Exception e){}
		while(sc.hasNextLine())
		{
			String phrase = sc.nextLine();
			for(int i = 0;i<20;++i)
			{
				String password = jcrypt.crypt(passwords[i].salt,phrase);
				if(!passwords[i].cracked)
				{
					if(password.equals(passwords[i].salt+passwords[i].passwd))
					{
						System.out.println("SALT: "+passwords[i].salt+" Password: "+passwords[i].passwd+" Cracked: "+phrase);
						passwords[i].cracked = true;
					}
			    }
			}
		}
	}

	public static void dictionaryAttackReverse(Password passwords[], String file)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File(file));
		}
		catch(Exception e){}
		while(sc.hasNextLine())
		{
			String phrase = sc.nextLine();
			phrase = new StringBuffer(phrase).reverse().toString();
			for(int i = 0;i<20;++i)
			{
				String password = jcrypt.crypt(passwords[i].salt,phrase);
				if(!passwords[i].cracked)
				{
					if(password.equals(passwords[i].salt+passwords[i].passwd))
					{
						System.out.println("SALT: "+passwords[i].salt+" Password: "+passwords[i].passwd+" Cracked: "+phrase);
						passwords[i].cracked = true;
					}
			    }
			}
		}
	}

	public static void dictionaryAttackDouble(Password passwords[], String file)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File(file));
		}
		catch(Exception e){}
		while(sc.hasNextLine())
		{
			String phrase = sc.nextLine();
			for(int i = 0;i<20;++i)
			{
				String password = jcrypt.crypt(passwords[i].salt,phrase+phrase);
				if(!passwords[i].cracked)
				{
					if(password.equals(passwords[i].salt+passwords[i].passwd))
					{
						System.out.println("SALT: "+passwords[i].salt+" Password: "+passwords[i].passwd+" Cracked: "+phrase+phrase);
						passwords[i].cracked = true;
					}
			    }
			}
		}
	}

	public static void dictionaryAttackReflect1(Password passwords[], String file)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File(file));
		}
		catch(Exception e){}
		while(sc.hasNextLine())
		{
			String phrase = sc.nextLine();
			String reflect = new StringBuffer(phrase).reverse().toString();
			for(int i = 0;i<20;++i)
			{
				String password = jcrypt.crypt(passwords[i].salt,phrase+reflect);
				if(!passwords[i].cracked)
				{
					if(password.equals(passwords[i].salt+passwords[i].passwd))
					{
						System.out.println("SALT: "+passwords[i].salt+" Password: "+passwords[i].passwd+" Cracked: "+phrase+reflect);
						passwords[i].cracked = true;
					}
			    }
			}
		}
	}
	public static void dictionaryAttackReflect2(Password passwords[], String file)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File(file));
		}
		catch(Exception e){}
		while(sc.hasNextLine())
		{
			String phrase = sc.nextLine();
			String reflect = new StringBuffer(phrase).reverse().toString();
			for(int i = 0;i<20;++i)
			{
				String password = jcrypt.crypt(passwords[i].salt,reflect+phrase);
				if(!passwords[i].cracked)
				{
					if(password.equals(passwords[i].salt+passwords[i].passwd))
					{
						System.out.println("SALT: "+passwords[i].salt+" Password: "+passwords[i].passwd+" Cracked: "+reflect+phrase);
						passwords[i].cracked = true;
					}
			    }
			}
		}
	}

	public static void dictionaryAttackCap(Password passwords[], String file)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File(file));
		}
		catch(Exception e){}
		while(sc.hasNextLine())
		{
			String phrase = sc.nextLine();
			String upper = phrase.toUpperCase();
			phrase = upper.charAt(0)+phrase.substring(1);
			for(int i = 0;i<20;++i)
			{
				String password = jcrypt.crypt(passwords[i].salt,phrase);
				if(!passwords[i].cracked)
				{
					if(password.equals(passwords[i].salt+passwords[i].passwd))
					{
						System.out.println("SALT: "+passwords[i].salt+" Password: "+passwords[i].passwd+" Cracked: "+phrase);
						passwords[i].cracked = true;
					}
			    }
			}
		}
	}

	public static void dictionaryAttacknCap(Password passwords[], String file)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File(file));
		}
		catch(Exception e){}
		while(sc.hasNextLine())
		{
			String phrase = sc.nextLine();
			String upper = phrase.toUpperCase();
			phrase = phrase.charAt(0)+upper.substring(1);
			for(int i = 0;i<20;++i)
			{
				String password = jcrypt.crypt(passwords[i].salt,phrase);
				if(!passwords[i].cracked)
				{
					if(password.equals(passwords[i].salt+passwords[i].passwd))
					{
						System.out.println("SALT: "+passwords[i].salt+" Password: "+passwords[i].passwd+" Cracked: "+phrase);
						passwords[i].cracked = true;
					}
			    }
			}
		}
	}

	public static void dictionaryAttackToggle1(Password passwords[], String file)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File(file));
		}
		catch(Exception e){}
		while(sc.hasNextLine())
		{
			String phrase = sc.nextLine();
			String upper = phrase.toUpperCase();
			String temp = "";
			for(int i = 0;i<phrase.length();++i)
			{
				if(i%2==0)
					temp+=phrase.charAt(i);
				else
					temp+=upper.charAt(i);
			}
			for(int i = 0;i<20;++i)
			{
				String password = jcrypt.crypt(passwords[i].salt,temp);
				if(!passwords[i].cracked)
				{
					if(password.equals(passwords[i].salt+passwords[i].passwd))
					{
						System.out.println("SALT: "+passwords[i].salt+" Password: "+passwords[i].passwd+" Cracked: "+temp);
						passwords[i].cracked = true;
					}
			    }
			}
		}
	}

	public static void dictionaryAttackToggle2(Password passwords[], String file)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File(file));
		}
		catch(Exception e){}
		while(sc.hasNextLine())
		{
			String phrase = sc.nextLine();
			String upper = phrase.toUpperCase();
			String temp = "";
			for(int i = 0;i<phrase.length();++i)
			{
				if(i%2!=0)
					temp+=phrase.charAt(i);
				else
					temp+=upper.charAt(i);
			}
			for(int i = 0;i<20;++i)
			{
				String password = jcrypt.crypt(passwords[i].salt,temp);
				if(!passwords[i].cracked)
				{
					if(password.equals(passwords[i].salt+passwords[i].passwd))
					{
						System.out.println("SALT: "+passwords[i].salt+" Password: "+passwords[i].passwd+" Cracked: "+temp);
						passwords[i].cracked = true;
					}
			    }
			}
		}
	}

	public static void dictionaryAttackSubtring1(Password passwords[], String file)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File(file));
		}
		catch(Exception e){}
		while(sc.hasNextLine())
		{
			String phrase = sc.nextLine();
			phrase = phrase.substring(1);
			for(int i = 0;i<20;++i)
			{
				String password = jcrypt.crypt(passwords[i].salt,phrase);
				if(!passwords[i].cracked)
				{
					if(password.equals(passwords[i].salt+passwords[i].passwd))
					{
						System.out.println("SALT: "+passwords[i].salt+" Password: "+passwords[i].passwd+" Cracked: "+phrase);
						passwords[i].cracked = true;
					}
			    }
			}
		}
	}

	public static void dictionaryAttackSubtring2(Password passwords[], String file)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File(file));
		}
		catch(Exception e){}
		while(sc.hasNextLine())
		{
			String phrase = sc.nextLine();
			phrase = phrase.substring(0,phrase.length()-1);
			for(int i = 0;i<20;++i)
			{
				String password = jcrypt.crypt(passwords[i].salt,phrase);
				if(!passwords[i].cracked)
				{
					if(password.equals(passwords[i].salt+passwords[i].passwd))
					{
						System.out.println("SALT: "+passwords[i].salt+" Password: "+passwords[i].passwd+" Cracked: "+phrase);
						passwords[i].cracked = true;
					}
			    }
			}
		}
	}
	



	public static String[] extract(String line)
	{
		String[] _line = line.split(":");
		String[] ret  = new String[2];
		String temp  = _line[1];
		ret[0] = temp.substring(0,2);
		ret[1]= temp.substring(2);
		return ret;
	}
















}