package com.example.sksha.tictactoe;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class NetFetchTask extends AsyncTask<String, Void, ArrayList<Events>> {


    public interface PostExecuteListener {
        public void postExecuteDone(ArrayList<Events> ev);
    }

    private PostExecuteListener myListener;
    int i;

    public NetFetchTask(PostExecuteListener pel,int i) {
        myListener = pel;
        this.i=i;
    }

    public NetFetchTask(TextView tv) {
    }

    @Override
    protected ArrayList<Events> doInBackground(String... params) {
       ArrayList<Events> myEv = new ArrayList<>();
        try {
            URL url = new URL(params[0]);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setConnectTimeout(10000);
            urlConn.setReadTimeout(20000);

            urlConn.connect();

            if (urlConn.getResponseCode() == 200) {
                String res = isToString(urlConn.getInputStream());
                myEv = getEventFromResponse(res);
               // Log.d("//////////////////", " "+myEv.get(0).name);
                urlConn.disconnect();
                return myEv;
//                JSONObject newObject = new JSONObject();
//                newObject.put("name", "Sahil");
//                newObject.put("scores", 70);
//                JSONObject jObj = new JSONObject(res);
//                JSONArray jArr = new JSONArray(jObj.getString("high_scores"));
//                jArr.put(3, newObject);
//                urlConn.disconnect();
//                urlConn = (HttpURLConnection) url.openConnection();
//                urlConn.setDoOutput(true);
//                urlConn.setRequestMethod("POST");

            }
            else
            {
                myEv.add(new Events("Please check internet connection",0));
            }

            // InputStream is  = urlConn.getInputStream();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
return myEv;
    }

    @Override
    protected void onPostExecute(ArrayList<Events> ev) {
        super.onPostExecute(ev);
        myListener.postExecuteDone(ev);
    }

    public String isToString(InputStream is) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(is, "utf-8"));
        StringBuilder sb = new StringBuilder();
        String line = r.readLine();
        while (line != null && !line.isEmpty()) {
            sb.append(line);
            line = r.readLine();
        }

        return sb.toString();
    }

    public ArrayList<Events> getEventFromResponse(String resp) throws JSONException {
        JSONObject jObj = new JSONObject(resp);
        JSONArray jArr = new JSONArray(jObj.getString("high_scores"));
//        JSONObject newObject = new JSONObject();
//        newObject.put("name","Sahil");
//        newObject.put("scores",70);

        // jArr.put(3,newObject);
        ArrayList<Events> list = new ArrayList<>();
        int length = jArr.length();
        for (int j = 0; j <=i&&j<length; j++) {
            JSONObject singleObject = jArr.getJSONObject(j);
            list.add(new Events(singleObject.getString("name"), singleObject.getInt("scores")));
            //Log.d("**************", "StudentsListAdapter: "+list.get(i).name);

        }
       // Log.d("//////////////////", " "+list.get(0).name);

        return list;
    }
}

//        Event event = new Event(
//                singleObject.getString("name"),
//                singleObject.getInt("scores")
//        );
