import java.io.*;
import java.util.*;

public class Password
{
	boolean cracked;
	String passwd;
	String salt;
	String user;

	public Password(String p, String s, String u)
	{
		passwd = p;
		salt = s;
		user = u;
		cracked = false;
	}

}