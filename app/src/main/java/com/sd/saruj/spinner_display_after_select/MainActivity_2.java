package com.sd.saruj.spinner_display_after_select;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity_2 extends AppCompatActivity {


   /* // these are the global variables
    Spinner cochingSpin2, unitSpin2, shiftSpin2, locationSpin2;
    ImageView image12, image22, image32, image42;
    // string variable to store selected values
    String cochingclass2, unitclass2, shiftclass2, locationclass2;

    Button btn1, btn2;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

      /*  cochingSpin2 = (Spinner) findViewById(R.id.cochingSpin2);
        unitSpin2 = (Spinner) findViewById(R.id.unitSPin2);
        shiftSpin2 = (Spinner) findViewById(R.id.shiftSpin2);
        locationSpin2 = (Spinner) findViewById(R.id.locationSpin2);

        image12=(ImageView) findViewById(R.id.image12);
        image22=(ImageView) findViewById(R.id.image22);
        image32=(ImageView) findViewById(R.id.image32);
        image42=(ImageView) findViewById(R.id.image42);*/


       /* cochingSpin2.setAdapter(new ArrayAdapter<String>(MainActivity_2.this,R.layout.company_dropdown,R.id.dropdown,getResources().getStringArray(R.array.coching_names)));


        // Class Spinner implementing onItemSelectedListener
        cochingSpin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                cochingclass2 = parent.getItemAtPosition(position).toString();
                switch (cochingclass2)
                {
                    case "Probah":
                        // assigning div item list defined in XML to the div Spinner
                        unitSpin2.setAdapter(new ArrayAdapter<String>(MainActivity_2.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.unit_probah)));
                        break;

                    case "Science Point":
                        unitSpin2.setAdapter(new ArrayAdapter<String>(MainActivity_2.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.unit_science)));
                        break;

                    case "3 Doctorts":
                        unitSpin2.setAdapter(new ArrayAdapter<String>(MainActivity_2.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.unit_doctors)));
                        break;

                    case "Udvash":
                        unitSpin2.setAdapter(new ArrayAdapter<String>(MainActivity_2.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.unit_udvash)));
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
                        shiftSpin2.setAdapter(new ArrayAdapter<String>(MainActivity_2.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.shift_a)));
                        break;

                    case "Unit B":
                        shiftSpin2.setAdapter(new ArrayAdapter<String>(MainActivity_2.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.shift_a)));
                        break;

                    case "Unit C":
                        shiftSpin2.setAdapter(new ArrayAdapter<String>(MainActivity_2.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.shift_a)));
                        break;

                    case "Unit D":
                        shiftSpin2.setAdapter(new ArrayAdapter<String>(MainActivity_2.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.shift_a)));
                        break;
                    case "Unit E":
                        shiftSpin2.setAdapter(new ArrayAdapter<String>(MainActivity_2.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.shift_a)));
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
                        locationSpin2.setAdapter(new ArrayAdapter<String>(MainActivity_2.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.location)));
                        break;
                    case "Day Shift":
                        // assigning div item list defined in XML to the div Spinner
                        locationSpin2.setAdapter(new ArrayAdapter<String>(MainActivity_2.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.location)));
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
}
