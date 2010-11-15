/**
 * 
 */
package org.crow.utils;

/**
 * @author viksin
 *
 */
public class Base62Converter {
	
	public String convertTo62Base(long toBeConverted)
	{
		String[] elements = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String convertedString="";
		if(toBeConverted<63 && toBeConverted>0)
		{
			convertedString=elements[(int) (toBeConverted-1)];
		}
		else if(toBeConverted>62)
		{
			
		}
		return convertedString;
	}

}
