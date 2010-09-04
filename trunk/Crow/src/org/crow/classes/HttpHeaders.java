/**
 * 
 */
package org.crow.classes;

import java.util.Map;

/**
 * @author viksin
 *
 */
public class HttpHeaders {	
	    private String response;
	    private Map<String, String> headers;

	    public HttpHeaders(String response, Map<String, String> headers) {
	        this.response = response;
	        this.headers = headers;
	    }

	    public int getCode() {
	        int start = response.indexOf(' ');
	        int end = response.indexOf(' ', start + 1);

	        return Integer.parseInt(response.substring(start + 1, end));
	    }
	    public String getTransferEncoding() {
	        return headers.get("Transfer-Encoding".toUpperCase());
	    }

	    public String getContentLength() {
	        return headers.get("Content-Length".toUpperCase());
	    }

	    public String getLocation() {
	        return headers.get("Location".toUpperCase());
	    }

	    public String getContentType() {
	        String contentType = headers.get("Content-Type".toUpperCase());

	        int delimIndex = contentType.indexOf(';');
	        if(delimIndex > -1) {
	            contentType = contentType.substring(0, delimIndex);
	        }

	        return contentType;
	    }
	}


