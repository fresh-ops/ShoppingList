package com.fresh.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView itemsLV;
    private EditText itemIn;
    private ImageButton btnAdd;
    private ArrayList<String> shoppingList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsLV = findViewById(R.id.itemsLV);
        btnAdd = findViewById(R.id.btnAdd);
        itemIn = findViewById(R.id.itemIn);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, shoppingList);

        itemsLV.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = itemIn.getText().toString();
                if (!item.isEmpty()) {
                    adapter.add(item);
                    itemIn.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }


}