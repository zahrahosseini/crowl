/**
 * 
 */
package org.crow.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author viksin
 *
 */
public class GenUtils {
	
	public String getCurrentDateTime(String format)
	{
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(format);
	    return sdf.format(cal.getTime());
	}

}
