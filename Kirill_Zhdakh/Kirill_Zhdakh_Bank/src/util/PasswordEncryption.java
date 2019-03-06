package util;

public class PasswordEncryption {
	final static private int nthUpshift = 15;
	final static private int  nthDownshift = 30;
	public static String encodePassword(String password)
	{
		StringBuilder sb = new StringBuilder();
		int i; int length = password.length();
		for(i = 0; i < length; ++i)
		{
			if (i % 2 == 0)
			{
				sb.append((char)(password.charAt(i) + nthUpshift));
			}
			else
			{
				sb.append((char)(password.charAt(i) - nthDownshift));
			}
		}
		return sb.toString();
	}
	
	public static String decodePassword(String encryption)
	{
		StringBuilder sb = new StringBuilder();
		int i; int length = encryption.length();
		for(i = 0; i < length; ++i)
		{
			if (i % 2 == 0)
			{
				sb.append((char)(encryption.charAt(i) - nthUpshift));
			}
			else
			{
				sb.append((char)(encryption.charAt(i) + nthDownshift));
			}
		}
		return sb.toString();
	}
}
