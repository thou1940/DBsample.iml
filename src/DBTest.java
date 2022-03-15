import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class DBTest {

    public String makeGETRequest(String urlName){
        BufferedReader rd = null;
        StringBuilder sb = null;
        String line = null;
        try {
            URL url = new URL(urlName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            sb = new StringBuilder();
            while ((line = rd.readLine()) != null)
            {
                sb.append(line + '\n');
            }
            conn.disconnect();
            return sb.toString();
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (ProtocolException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return "";

    }

    public String parseJSON(String jsonString){
        String var = "";

        try {
            JSONArray array = new JSONArray(jsonString);
            for (int i = 0; i < array.length(); i++)
            {
                JSONObject curObject = array.getJSONObject(i);
                var += curObject.getString("Voltage");
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return var;
    }
    public ArrayList<String> parseJSON2(String jsonString){
        ArrayList<String> list = new ArrayList<String>();
        try {
            JSONArray array = new JSONArray(jsonString);
            for (int i = 0; i < array.length(); i++)
            {
                JSONObject curObject = array.getJSONObject(i);
                list.add(curObject.getString("Voltage"));

            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return list;

    }
    public ArrayList<String> parseJSONLastDay(String jsonString){
        ArrayList<String> list = new ArrayList<String>();
        try {
            JSONArray array = new JSONArray(jsonString);
            for (int i = 0; i < array.length(); i++)
            {
                JSONObject curObject = array.getJSONObject(i);
                list.add(curObject.getString("hour"));

            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return list;

    }
    public ArrayList<String> parseJSONLastMinute(String jsonString){
        ArrayList<String> list = new ArrayList<String>();
        try {
            JSONArray array = new JSONArray(jsonString);
            for (int i = 0; i < array.length(); i++)
            {
                JSONObject curObject = array.getJSONObject(i);
                list.add(curObject.getString("second"));

            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return list;
    }



    /*
    public static void main(String[] args) {
        DBTest rc = new DBTest();
        String response = rc.makeGETRequest("https://studev.groept.be/api/a21ib2d03/highest");
        System.out.println(rc.parseJSON(response));
    }
     */
}


