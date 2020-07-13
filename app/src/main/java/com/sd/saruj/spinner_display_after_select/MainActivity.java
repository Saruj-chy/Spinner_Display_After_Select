package com.sd.saruj.spinner_display_after_select;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    // these are the global variables
    Spinner cochingSpin, unitSpin, shiftSpin, locationSpin;
    ImageView image1, image2, image3, image4;
    // string variable to store selected values
    String cochingclass, unitclass, shiftclass, locationclass;

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cochingSpin = (Spinner) findViewById(R.id.cochingSpin);
        unitSpin = (Spinner) findViewById(R.id.unitSPin);
        shiftSpin = (Spinner) findViewById(R.id.shiftSpin);
        locationSpin = (Spinner) findViewById(R.id.locationSpin);

        image1=(ImageView) findViewById(R.id.image1);
        image2=(ImageView) findViewById(R.id.image2);
        image3=(ImageView) findViewById(R.id.image3);
        image4=(ImageView) findViewById(R.id.image4);


        cochingSpin.setAdapter(new ArrayAdapter<String>(MainActivity.this,R.layout.company_dropdown,
                R.id.dropdown,getResources().getStringArray(R.array.coching_names)));


        // Class Spinner implementing onItemSelectedListener
        cochingSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                cochingclass = parent.getItemAtPosition(position).toString();
                switch (cochingclass)
                {
                    case "Probah":
                        // assigning div item list defined in XML to the div Spinner
                        unitSpin.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.unit_probah)));
                        break;

                    case "Science Point":
                        unitSpin.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.unit_science)));
                        break;

                    case "3 Doctorts":
                        unitSpin.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.unit_doctors)));
                        break;

                    case "Udvash":
                        unitSpin.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.unit_udvash)));
                        break;



                    case "Select a Coching":
                        unitSpin.setAdapter(null);
                        image2.setVisibility(View.GONE);


                        break;


                }
                //set divSpinner Visibility to Visible
                unitSpin.setVisibility(View.VISIBLE);
                image2.setVisibility(View.VISIBLE);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });

     //   unitSpin.setAdapter(new ArrayAdapter<String>(MainActivity.this,R.layout.company_dropdown,R.id.dropdown,getResources().getStringArray(R.array.unit_doctors)));


        unitSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unitclass = parent.getItemAtPosition(position).toString();
                switch (unitclass)
                {
                    case "Unit A":
                        // assigning div item list defined in XML to the div Spinner
                        shiftSpin.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.shift_a)));
                        break;

                    case "Unit B":
                        shiftSpin.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.shift_a)));
                        break;

                    case "Unit C":
                        shiftSpin.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.shift_a)));
                        break;

                    case "Unit D":
                        shiftSpin.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.shift_a)));
                        break;
                    case "Unit E":
                        shiftSpin.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.shift_a)));
                        break;

                    case "Select a Unit":
                        shiftSpin.setAdapter(null);
                        image3.setVisibility(View.GONE);


                        break;

                }
                if(unitclass!="Select a Unit"){
                //set divSpinner Visibility to Visible
                shiftSpin.setVisibility(View.VISIBLE);
                image3.setVisibility(View.VISIBLE);}
                else{
                    shiftSpin.setVisibility(View.INVISIBLE);
                    image3.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        shiftSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                shiftclass = parent.getItemAtPosition(position).toString();
                switch (shiftclass)
                {
                    case "Morning Shift":
                        // assigning div item list defined in XML to the div Spinner
                        locationSpin.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.location)));
                        break;
                    case "Day Shift":
                        // assigning div item list defined in XML to the div Spinner
                        locationSpin.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                R.layout.company_dropdown,R.id.dropdown,
                                getResources().getStringArray(R.array.location)));
                        break;



                    case "Select a Shift":
                        locationSpin.setAdapter(null);


                        break;



                }
                if(shiftclass=="Select a Shift"){
                    //set divSpinner Visibility to Visible
                    locationSpin.setVisibility(View.INVISIBLE);
                    image4.setVisibility(View.INVISIBLE);}
                else{
                    locationSpin.setVisibility(View.VISIBLE);
                    image4.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
