import java.io.*;
import java.util.*;

public class Password
{
	boolean cracked;
	String passwd;
	String salt;

	public Password(String p, String s)
	{
		passwd = p;
		salt = s;
		cracked = false;
	}

}