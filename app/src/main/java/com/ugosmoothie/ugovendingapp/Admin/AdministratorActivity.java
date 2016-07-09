package com.ugosmoothie.ugovendingapp.Admin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.ugosmoothie.ugovendingapp.Data.Purchase;
import com.ugosmoothie.ugovendingapp.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by Michelle on 7/6/2016.
 */
public class AdministratorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administrator_activity);

        final Button quit = (Button) findViewById((R.id.quit_button));
        final Button close = (Button) findViewById((R.id.close_button));
        final Button export = (Button) findViewById((R.id.export_button));

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", "quit");
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", 0);
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });

        List<Purchase> purchases = Purchase.listAll(Purchase.class);

        String[] array = new String[purchases.size()];
        int index = 0;
        for (
                Purchase value
                : purchases)

        {
            array[index] = value.getDisplayString();
            index++;
        }

        final ListView listview = (ListView) findViewById(R.id.purchase_listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, array);

        listview.setAdapter(adapter);

        export.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = openFileOutput("Purchases", Context.MODE_APPEND | Context.MODE_WORLD_READABLE);
                    List<Purchase> purchases = Purchase.listAll(Purchase.class);

                    for (Purchase value : purchases) {
                        fos.write(value.getDisplayString().getBytes());
                    }

                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
