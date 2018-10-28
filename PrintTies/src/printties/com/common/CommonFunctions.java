package printties.com.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;



public class CommonFunctions {

	
	
	public static String constructMobileDevice(String url, HashMap<String, String> params,String methodtype) throws IOException 
	{
        String inputLine="";
        if(methodtype.equalsIgnoreCase("POST"))
        {
        	String exploreJSONCall = url;
    		URL myURL = new URL(exploreJSONCall);
    		HttpURLConnection yc = (HttpURLConnection) myURL.openConnection();
    		yc.setRequestMethod("POST");
    		yc.setRequestProperty("User-Agent", "Mozilla/5.0");
    		yc.setRequestProperty("followAllRedirects", "true");
    		yc.setDoOutput(true);
    		DataOutputStream wr = new DataOutputStream(yc.getOutputStream());
    		wr.writeBytes((urlParametersPostConcatenator(params)));
    		wr.flush();
    		wr.close();
    		yc.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
    		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
    		inputLine=in.readLine();
        }
        else
        {
        	String exploreJSONCall = urlParametersGetConcatenator(url, params);
    		URL myURL = new URL(exploreJSONCall);
    		HttpURLConnection yc = (HttpURLConnection) myURL.openConnection();
    		yc.setRequestMethod("GET");
    		yc.setRequestProperty("User-Agent", "Mozilla/5.0");
    		yc.setRequestProperty("followAllRedirects", "true");
    		yc.setRequestProperty("authority", "route.api.here.com");
    		yc.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
    		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
    		inputLine=in.readLine();
        }
		return inputLine;
	}
	
	
	public static String urlParametersGetConcatenator(String url, HashMap<String,String> params)
	{
		
		String finalString=""+url;
		Set<Entry<String, String>> paramSet=params.entrySet();
		
		Iterator<Entry<String, String>> i=paramSet.iterator();
		
		int counter=0;
		while(i.hasNext())
		{
			Entry<String,String> oneParam=  i.next();
			
			if(counter!=0)
			{
				finalString=finalString+"&";
			}
			else
			{
				finalString=finalString+"?";
			}
			finalString=finalString+""+oneParam.getKey()+"="+oneParam.getValue();
			counter++;
		}
		
		return finalString;
	}		
		
	public static String urlParametersPostConcatenator( HashMap<String,String> params)
	{
			
			String finalString="";
			Set<Entry<String, String>> paramSet=params.entrySet();
			
			Iterator<Entry<String, String>> i=paramSet.iterator();
			
			int counter=0;
			while(i.hasNext())
			{
				Entry<String,String> oneParam= i.next();
				
				if(counter!=0)
				{
					finalString=finalString+"&";
				}
				
				finalString=finalString+""+oneParam.getKey()+"="+oneParam.getValue();
				counter++;
			}
		
		return finalString;
	}
	
	
	
}
