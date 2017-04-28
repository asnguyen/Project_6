;import java.io.*;
import java.util.*;

public class PasswordCrack
{
	public static void main(String args[])
	{
		System.out.println("Program Start");
		Scanner sc = null;
		Password[] passwords = new Password[20];
		try
		{
			sc = new Scanner(new File(args[0]));
		}
		catch(Exception e){}
		long start_time = System.currentTimeMillis();
		for(int i=0;i<20;++i)
		{
			String[] temp = new String[3];
			temp = extract(sc.nextLine());
			passwords[i] = new Password(temp[1],temp[0],temp[2]);
		}

		nameAttackSet(passwords);
		dictAttack(passwords,"wordlist.txt");

		long endTime = System.currentTimeMillis() - start_time;
		System.out.println(endTime);
		System.out.println("Program End");
	}

	public static void dictAttack(Password passwords[], String file)
	{
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File(file));
		}
		catch(Exception e){}
		long start_time = System.currentTimeMillis();
		while(sc.hasNextLine())
		{
			String phrase = sc.nextLine();
			wordAttackSet(passwords,phrase,start_time);
		}
	}

	public static void wordAttackSet(Password passwords[], String phrase, long start_time)
	{
		for(int i=0;i<20;i++)
		{
			
			if(compare(passwords[i],phrase))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],phrase.toUpperCase()))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],phrase.toLowerCase()))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],reverse(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],reflect1(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],reflect2(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i], doublePhrase(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],cap(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],ncap(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],toggle1(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],toggle2(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],substring1(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],substring2(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			
			if(compare(passwords[i],reverse(cap(phrase))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],reverse(ncap(phrase))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],reverse(doublePhrase(phrase))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");

			if(compare(passwords[i],reverse(toggle1(phrase))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],reverse(toggle2(phrase))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],reverse(substring1(phrase))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],reverse(substring1(phrase))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");

			if(compare(passwords[i],substring1(reverse(cap(phrase)))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],substring2(reverse(cap(phrase)))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");

			if(compare(passwords[i],eSub(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],aSub(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],iSub(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],oSub(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],tSub(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");

			if(compare(passwords[i],endChar(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(passwords[i],beginChar(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");


			addNumerical(passwords[i], phrase, start_time);



		}
	}

	public static void nameAttackSet(Password passwords[])
	{
		long start_time = System.currentTimeMillis();
		for(int i = 0;i<20;++i)
		{

			nameCompare(passwords[i],passwords[i].user,start_time);

			String[] name = passwords[i].user.split("\\s+");
			nameCompare(passwords[i],name[0],start_time);
			nameCompare(passwords[i],name[1],start_time);
			nameCompare(passwords[i],name[0]+name[1],start_time);

		}
	}

	public static void nameCompare(Password password, String phrase, long start_time)
	{
			if(compare(password,phrase))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,phrase.toUpperCase()))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,phrase.toLowerCase()))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,reverse(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,reflect1(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,reflect2(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password, doublePhrase(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,cap(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,ncap(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,toggle1(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,toggle2(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,substring1(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,substring2(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			
			if(compare(password,reverse(cap(phrase))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,reverse(ncap(phrase))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,reverse(doublePhrase(phrase))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,reverse(toggle1(phrase))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,reverse(toggle2(phrase))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,reverse(substring1(phrase))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,reverse(substring2(phrase))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,substring1(reverse(cap(phrase)))))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");

			if(compare(password,eSub(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,aSub(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,iSub(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,oSub(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			if(compare(password,tSub(phrase)))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
			addNumerical(password, phrase, start_time);




	}

	public static String reverse(String s)
	{
		return new StringBuffer(s).reverse().toString();
	}

	public static String reflect1(String s)
	{
		String reflect = new StringBuffer(s).reverse().toString();
		return s+reflect;
	}

	public static String reflect2(String s)
	{
		String reflect = new StringBuffer(s).reverse().toString();
		return reflect+s;
	}

	public static String doublePhrase(String s)
	{
		//System.out.println(s+s);
		String temp = s+s;
		//System.out.println(temp);
		return temp;
	}

	public static String cap(String s)
	{
		String upper = s.toUpperCase();
		String phrase = upper.charAt(0)+s.substring(1);
		return phrase;
	}

	public static String ncap(String s)
	{
		String upper = s.toUpperCase();
		String phrase = s.charAt(0)+upper.substring(1);
		return phrase;
	}

	public static String toggle1(String phrase)
	{
		String upper = phrase.toUpperCase();
		String temp = "";
		for(int i = 0;i<phrase.length();++i)
		{
			if(i%2==0)
				temp+=phrase.charAt(i);
			else
				temp+=upper.charAt(i);
		}
		return temp;
	}

	public static String toggle2(String phrase)
	{
		String upper = phrase.toUpperCase();
		String temp = "";
		for(int i = 0;i<phrase.length();++i)
		{
			if(i%2==1)
				temp+=phrase.charAt(i);
			else
				temp+=upper.charAt(i);
		}
		return temp;
	}

	public static String substring1(String phrase)
	{
		phrase = phrase.substring(1);
		return phrase;
	}

	public static String substring2(String phrase)
	{
		phrase = phrase.substring(0,phrase.length()-1);
		return phrase;
	}

	public static String eSub(String phrase)
	{
		phrase = phrase.replace("e","3");
		return phrase;
	}

	public static String aSub(String phrase)
	{
		phrase = phrase.replace("a","@");
		return phrase;
	}

	public static String iSub(String phrase)
	{
		phrase = phrase.replace("i","!");
		return phrase;
	}

	public static String oSub(String phrase)
	{
		phrase = phrase.replace("o","0");
		return phrase;
	}

	public static String tSub(String phrase)
	{
		phrase = phrase.replace("t","+");
		return phrase;
	}

	public static String endChar(String phrase)
	{
		return phrase.charAt(phrase.length()-1)+phrase;
	}

	public static String beginChar(String phrase)
	{
		return phrase+(phrase.charAt(0));
	}

	public static boolean compare(Password passwd, String phrase)
	{
		String password = jcrypt.crypt(passwd.salt,phrase);
		if(!passwd.cracked)
		{
			if(password.equals(passwd.salt+passwd.passwd))
			{
				System.out.println("SALT: "+passwd.salt+" Password: "+passwd.passwd+" Cracked: "+phrase);
				passwd.cracked = true;
				return true;
			}
		}
		return false;

	}

	public static void addNumerical(Password passwd, String phrase, long start_time)
	{
		for(int i=0;i<=9;++i)
		{
			if(compare(passwd,phrase+i))
				System.out.println("FOUND in "+(System.currentTimeMillis() - start_time)+" milliseconds");
		}

	}

	public static String[] extract(String line)
	{
		String[] _line = line.split(":");
		String[] ret  = new String[3];
		String temp  = _line[1];
		ret[0] = temp.substring(0,2);
		ret[1] = temp.substring(2);
		ret[2] = _line[4];
		return ret;
	}
















}