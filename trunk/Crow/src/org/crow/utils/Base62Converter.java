/**
 * 
 */
package org.crow.utils;

/**
 * @author viksin
 *
 */
public class Base62Converter {
	private final int LENGTH_OF_URL_CODE=6;
	public String convertTo62Base(long toBeConverted)
	{
		String[] elements = {
				"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o",
				"p","q","r","s","t","u","v","w","x","y","z","1","2","3","4",
				"5","6","7","8","9","0","A","B","C","D","E","F","G","H","I",
				"J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X",
				"Y","Z"
				};
		String convertedString="";
		if(toBeConverted<63 && toBeConverted>0)
		{
			convertedString=elements[(int) (toBeConverted-1)];
		}
		else if(toBeConverted>62)
		{
			long mod = 0;
			long multiplier = 0;
			boolean determinedTheLength=false;
			for(int j=LENGTH_OF_URL_CODE;j>=0;j--)
			{
				multiplier=(long) (toBeConverted/Math.pow(62,j));
				if(multiplier>0 && toBeConverted>=62)
				{
					convertedString+=elements[(int) multiplier];
					determinedTheLength=true;
				}
				else if(determinedTheLength && multiplier==0)
				{
					convertedString+=elements[0];
				}
				else if(toBeConverted<62)
				{
					convertedString+=elements[(int) mod];
				}
				
				mod=(long) (toBeConverted%Math.pow(62,j));
				toBeConverted=mod;				
			}
			
		}
		System.out.print(convertedString);
		return convertedString;
	}

}
