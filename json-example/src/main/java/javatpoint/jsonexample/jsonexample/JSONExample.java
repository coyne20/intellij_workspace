package javatpoint.jsonexample.jsonexample;

//import required classes
import org.json.JSONArray;
import org.json.JSONObject;

// create JSONExample class to iterate JSON Array
public class JSONExample{
    //main() method start
    public static void main(String args[]){
        // create an string of JSON data
        String jsonData = "{\"locations\":[{\"lat\":\"23.053\",\"long\":\"72.629\",\"location\":\"ABC\",\"address\":\"DEF\",\"city\":\"Ahmedabad\",\"state\":\"Gujrat\",\"phonenumber\":\"1234567\"}," +
                          "{\"lat\":\"21.013\",\"long\":\"52.619\",\"location\":\"XYZ\",\"address\":\"MNP\",\"city\":\"Ghaziabad\",\"state\":\"UP\",\"phonenumber\":\"212321\"}]}";

        // convert JSON string into JSON Object using JSONObject() method
        JSONObject json = new JSONObject(jsonData);

        // get locations array from the JSON Object and store it into JSONArray
        JSONArray jsonArray = json.getJSONArray("locations");

        System.out.println("No of JSON objects: "+jsonArray.length());

        for (int i = 0; i < jsonArray.length(); i++) {

            // store each object in JSONObject
            JSONObject explrObject = jsonArray.getJSONObject(i);

            // Extract the address into a String object
            String address = explrObject.get("address").toString();

            // get field value from JSONObject using get() method
            System.out.println(address);
        }
    }
}
