/**
 * 
 */
package org.crow.utils;

import java.net.URL;

/**
 * @author viksin
 *
 */
public interface FeedParserInterface {
	
	public void parseRSS(URL feedurl);
	public void parseATOM(URL feedurl);

}


