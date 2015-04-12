package name.bagi.levente.pedometer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.util.Log;

import com.google.gson.Gson;



public class MyTimerTask extends TimerTask{
	private final static long ONCE_PER_DAY = 1000*60*60*24;

    //private final static int ONE_DAY = 1;
    private final static int TWO_AM = 2;
    private final static int ZERO_MINUTES = 0;

    
    
    
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read); 

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
    
    
    
    public static String POST(String url, Person person){
        InputStream inputStream = null;
        String result = "";
        try {
 
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost("http://2ff28cf1.ngrok.com/update");
 
            String json = "";
 
            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("user", person.getUser());
            jsonObject.accumulate("step", person.getStep());
            jsonObject.accumulate("dist", person.getDist());
 
            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();
 
            // ** Alternative way to convert Person object to JSON string usin Jackson Lib 
            // ObjectMapper mapper = new ObjectMapper();
            // json = mapper.writeValueAsString(person); 
 
            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);
 
            // 6. set httpPost Entity
            httpPost.setEntity(se);
 
            // 7. Set some headers to inform server about the type of the content   
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
 
            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);
 
            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();
 
            // 10. convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";
 
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
 
        // 11. return result
        return result;
    }
    

private static String convertInputStreamToString(InputStream inputStream) throws IOException{
    BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
    String line = "";
    String result = "";
    while((line = bufferedReader.readLine()) != null)
        result += line;
    inputStream.close();
    return result;

}   
    
    
    public void updateInfo()
    {
    	try {
    		String url = "http://2ff28cf1.ngrok.com/userlist";
			String json = readUrl(url);
	    	Gson gson = new Gson();
	    	Person person = gson.fromJson(json, Person.class);
	    	String user = person.getUser();
	    	int step = R.id.pace_value;
	    	int dist = R.id.distance_value;
	    	person.setStep(step);
	    	person.setDist(Integer.toString(dist));
	    	POST(url, person);
	    	
    	
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    

    @Override
    public void run() {
        long currennTime = System.currentTimeMillis();
        long stopTime = currennTime + 2000;//provide the 2hrs time it should execute 1000*60*60*2
          while(stopTime != System.currentTimeMillis()){
              updateInfo();
        	  
            System.out.println("Start Job"+stopTime);
            System.out.println("End Job"+System.currentTimeMillis());
          }
    }
    private static Date getTomorrowMorning2AM(){

        Date date2am = new java.util.Date(); 
           date2am.setHours(TWO_AM); 
           date2am.setMinutes(ZERO_MINUTES); 

           return date2am;
      }
    //call this method from your servlet init method
    public static void startTask(){
        MyTimerTask task = new MyTimerTask();
        Timer timer = new Timer();  
        timer.schedule(task,getTomorrowMorning2AM(),1000*10);// for your case u need to give 1000*60*60*24
    }
    public static void main(String args[]){
        startTask();

    }


}
