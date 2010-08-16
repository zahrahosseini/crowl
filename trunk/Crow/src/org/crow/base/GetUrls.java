package org.crow.base;
/**
 * @author viksin
 *
 */
import java.util.ArrayList;

import org.crow.data.SelectOps;
public class GetUrls {
	public ArrayList<String> getAllUrls()
	{
		SelectOps sOps = new SelectOps();
		ArrayList<String> urls = new ArrayList<String>();
		urls=sOps.getOneColumnData("", "");
		return urls;
	}

}
