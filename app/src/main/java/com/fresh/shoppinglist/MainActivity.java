package com.fresh.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView itemsLV;
    private EditText itemIn;
    private ImageButton btnAdd;
    private Button btnRemoveItems;
    private Button btnClearList;
    private ArrayList<String> shoppingList = new ArrayList<>();
    private ArrayList<String> checkedItems = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsLV = findViewById(R.id.itemsLV);
        itemIn = findViewById(R.id.itemIn);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, shoppingList);
        itemsLV.setAdapter(adapter);
        itemsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = adapter.getItem(position);
                if (itemsLV.isItemChecked(position)) {
                    checkedItems.add(item);
                }
                else {
                    checkedItems.remove(item);
                }
            }
        });

        btnAdd = findViewById(R.id.btnAdd);
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

        btnRemoveItems = findViewById(R.id.btnRemoveItems);
        btnRemoveItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (String item : checkedItems) {
                    adapter.remove(item);
                }
                checkedItems.clear();
                itemsLV.clearChoices();
                adapter.notifyDataSetChanged();
            }
        });

        btnClearList = findViewById(R.id.btnClearList);
        btnClearList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.clear();
                checkedItems.clear();
                adapter.notifyDataSetChanged();
            }
        });
    }
}