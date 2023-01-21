//https://www.javatpoint.com/how-to-convert-string-to-json-object-in-java
package javatpoint.jsonexample.jsonexample;

import org.json.JSONObject;
import org.json.JSONArray;

public class JsonStringToJsonObjectExample
{
    public static void main(String args[])
    {
        String str = "[{\"No\":\"17\",\"Name\":\"Andrew\"}," +
                      "{\"No\":\"18\",\"Name\":\"Peter\"}, " +
                      "{\"No\":\"19\",\"Name\":\"Tom\"}]";

        JSONArray array = new JSONArray(str);

        for(int i=0; i < array.length(); i++)
        {
            JSONObject object = array.getJSONObject(i);
            System.out.println(object.getString("No")+", "+object.getString("Name"));
        }
    }
}
