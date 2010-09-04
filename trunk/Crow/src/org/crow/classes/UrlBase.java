/**
 * 
 */
package org.crow.classes;

/**
 * @author viksin
 *
 */
public class UrlBase {
	
	private String urlAddress;
	private String host; //root domain
	private HttpHeaders headers;
	/**
	 * @param urlAddress the urlAddress to set
	 */
	public void setUrlAddress(String urlAddress) {
		this.urlAddress = urlAddress;
	}
	/**
	 * @return the urlAddress
	 */
	public String getUrlAddress() {
		return urlAddress;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}
	/**
	 * @return the headers
	 */
	public HttpHeaders getHeaders() {
		return headers;
	}
	

}
