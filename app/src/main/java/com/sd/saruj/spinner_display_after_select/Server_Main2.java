package com.sd.saruj.spinner_display_after_select;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Server_Main2 extends AppCompatActivity implements Spinner.OnItemSelectedListener{



    public static Spinner spinner1, spinner2, spinner3, spinner4;
    private ImageView image1, image2, image3, image4;

    //An ArrayList for Spinner Items
    private ArrayList<String> students1;
    private ArrayList<String> students2;
    private ArrayList<String> students3;
    private ArrayList<String> students4;


    //JSON Array
    private JSONArray result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server__main2);


        students1 = new ArrayList<String>();
        students2 = new ArrayList<String>();
        students3 = new ArrayList<String>();
        students4 = new ArrayList<String>();

        spinner1 = findViewById(R.id.spinner21);
        spinner2 = findViewById(R.id.spinner22);
        spinner3 = findViewById(R.id.spinner23);
        spinner4 = findViewById(R.id.spinner24);

      /*  image1=(ImageView) findViewById(R.id.image1);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner1.setAdapter(new ArrayAdapter<String>(MainActivity_2.this,R.layout.company_dropdown,R.id.dropdown,students1));
            }
        });*/


        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);

        //This method will fetch the data from the URL
        getData();


    }


    //======================    1st step
    private void getData() {
        //Creating a string request
        StringRequest stringRequest = new StringRequest(Config.DATA_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            //Parsing the fetched Json String to JSON Object
                            j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            result = j.getJSONArray(Config.JSON_ARRAY);

                            //Calling method getStudents to get the students from the JSON Array
                            getStudents1(result);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }


    //========================                2nd step        =========================================
    private void getStudents1(JSONArray j) {
        //Traversing through all the items in the json array
        for (int i = 0; i < j.length(); i++) {
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                students1.add(json.getString(Config.TAG_coching));
               /* students2.add(json.getString(Config.TAG_unit));
                students3.add(json.getString(Config.TAG_shift));
                students4.add(json.getString(Config.TAG_location));*/


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


//Setting adapter to show the items in the spinner

        spinner1.setAdapter(new ArrayAdapter<String>(Server_Main2.this,R.layout.company_dropdown,R.id.dropdown,students1));
       /* spinner2.setAdapter(new ArrayAdapter<String>(Server_Main2.this,R.layout.company_dropdown,R.id.dropdown,students2));
        spinner3.setAdapter(new ArrayAdapter<String>(Server_Main2.this,R.layout.company_dropdown,R.id.dropdown,students3));
        spinner4.setAdapter(new ArrayAdapter<String>(Server_Main2.this,R.layout.company_dropdown,R.id.dropdown,students4));
*/




    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}