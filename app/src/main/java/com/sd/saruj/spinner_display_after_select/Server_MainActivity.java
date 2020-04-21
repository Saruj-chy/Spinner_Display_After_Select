package com.sd.saruj.spinner_display_after_select;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class Server_MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //An ArrayList for Spinner Items
    private ArrayList<String> coching_name;
    private ArrayList<String> unit_probah;
    private ArrayList<String> unit_science;
    private ArrayList<String> unit_udvash;
    private ArrayList<String> unit_doctors;
    private ArrayList<String> shift;
    private ArrayList<String> location;


    //JSON Array
    private JSONArray result;

    // these are the global variables
    Spinner cochingSpin2, unitSpin2, shiftSpin2, locationSpin2;
    ImageView image12, image22, image32, image42;
    // string variable to store selected values
    String cochingclass2, unitclass2, shiftclass2, locationclass2;

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server__main);

        cochingSpin2 = (Spinner) findViewById(R.id.cochingSpin2);
        unitSpin2 = (Spinner) findViewById(R.id.unitSPin2);
        shiftSpin2 = (Spinner) findViewById(R.id.shiftSpin2);
        locationSpin2 = (Spinner) findViewById(R.id.locationSpin2);

        image12=(ImageView) findViewById(R.id.image12);
        image22=(ImageView) findViewById(R.id.image22);
        image32=(ImageView) findViewById(R.id.image32);
        image42=(ImageView) findViewById(R.id.image42);

        //=============   arraylist for json
        coching_name = new ArrayList<String>();
        unit_probah = new ArrayList<String>();
        unit_science = new ArrayList<String>();
        unit_udvash = new ArrayList<String>();
        unit_doctors = new ArrayList<String>();
        shift = new ArrayList<String>();
        location = new ArrayList<String>();

        cochingSpin2.setOnItemSelectedListener(this);

        //============  json which data from server
        getData();




       /* // Class Spinner implementing onItemSelectedListener
        cochingSpin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                cochingclass2 = parent.getItemAtPosition(position).toString();
                switch (cochingclass2)
                {
                    case "Probah":
                        // assigning div item list defined in XML to the div Spinner
                        unitSpin2.setAdapter(new ArrayAdapter<String>(Server_MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown, unit_probah));
                        break;

                    case "Science Point":
                        unitSpin2.setAdapter(new ArrayAdapter<String>(Server_MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,unit_science));
                        break;

                    case "3 Doctorts":
                        unitSpin2.setAdapter(new ArrayAdapter<String>(Server_MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,unit_doctors));
                        break;

                    case "Udvash":
                        unitSpin2.setAdapter(new ArrayAdapter<String>(Server_MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,unit_udvash));
                        break;



                    case "Select a Coching":
                        unitSpin2.setAdapter(null);
                        image22.setVisibility(View.GONE);


                        break;


                }
                //set divSpinner Visibility to Visible
                unitSpin2.setVisibility(View.VISIBLE);
                image22.setVisibility(View.VISIBLE);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });

        //   unitSpin.setAdapter(new ArrayAdapter<String>(MainActivity.this,R.layout.company_dropdown,R.id.dropdown,getResources().getStringArray(R.array.unit_doctors)));


        unitSpin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unitclass2 = parent.getItemAtPosition(position).toString();
                switch (unitclass2)
                {
                    case "Unit A":
                        // assigning div item list defined in XML to the div Spinner
                        shiftSpin2.setAdapter(new ArrayAdapter<String>(Server_MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,shift));
                        break;

                    case "Unit B":
                        shiftSpin2.setAdapter(new ArrayAdapter<String>(Server_MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,shift));
                        break;

                    case "Unit C":
                        shiftSpin2.setAdapter(new ArrayAdapter<String>(Server_MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,shift));
                        break;

                    case "Unit D":
                        shiftSpin2.setAdapter(new ArrayAdapter<String>(Server_MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,shift));
                        break;
                    case "Unit E":
                        shiftSpin2.setAdapter(new ArrayAdapter<String>(Server_MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,shift));
                        break;

                    case "Select a Unit":
                        shiftSpin2.setAdapter(null);
                        image32.setVisibility(View.GONE);


                        break;

                }
                if(unitclass2!="Select a Unit"){
                    //set divSpinner Visibility to Visible
                    shiftSpin2.setVisibility(View.VISIBLE);
                    image32.setVisibility(View.VISIBLE);}
                else{
                    shiftSpin2.setVisibility(View.INVISIBLE);
                    image32.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        shiftSpin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                shiftclass2 = parent.getItemAtPosition(position).toString();
                switch (shiftclass2)
                {
                    case "Morning Shift":
                        // assigning div item list defined in XML to the div Spinner
                        locationSpin2.setAdapter(new ArrayAdapter<String>(Server_MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,location));
                        break;
                    case "Day Shift":
                        // assigning div item list defined in XML to the div Spinner
                        locationSpin2.setAdapter(new ArrayAdapter<String>(Server_MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,location));
                        break;



                    case "Select a Shift":
                        locationSpin2.setAdapter(null);


                        break;



                }
                if(shiftclass2=="Select a Shift"){
                    //set divSpinner Visibility to Visible
                    locationSpin2.setVisibility(View.INVISIBLE);
                    image42.setVisibility(View.INVISIBLE);}
                else{
                    locationSpin2.setVisibility(View.VISIBLE);
                    image42.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/

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
                coching_name.add(json.getString(Config.TAG_coching));



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


//Setting adapter to show the items in the spinner

        cochingSpin2.setAdapter(new ArrayAdapter<String>(Server_MainActivity.this,R.layout.company_dropdown,R.id.dropdown,coching_name));






    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
