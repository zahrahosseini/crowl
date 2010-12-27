/**
 * 
 */
package org.crow.crawler;

/**
 * @author viksin
 *
 */
public interface ICrawler {
	public void feedCrawler(String mode);
	public void imageCrawler();
	public void docCrawler();
	public void generalCrawler();
}
