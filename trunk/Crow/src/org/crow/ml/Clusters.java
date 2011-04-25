/**
 * 
 */
package org.crow.ml;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author viksin
 *
 */
public class Clusters implements Serializable{
	private ConcurrentHashMap <String,Cluster> clusterMap = new ConcurrentHashMap<String,Cluster>();	
	
	public void addCluster(Cluster cluster)
	{
		int mapSize = clusterMap.size();
		clusterMap.put("C"+mapSize+1, cluster);
	}
	
	public ConcurrentHashMap <String,Cluster> getClusterMap()
	{		
		return clusterMap;
	}
	public int size()
	{
		return clusterMap.size();
	}
}
