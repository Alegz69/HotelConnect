package com.example.projectsda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AdminActivity extends AppCompatActivity {


    private ListView listViewAllEmployees;
    private Button buttonAddEmployee;
    private Button buttonDeleteEmployee;

    private List<String> employeeList = new ArrayList<>();
    private ArrayAdapter<String> employeeListAdapter;

    private static final int ADD_EMPLOYEE_REQUEST_CODE = 1;
    private int lastSelectedItemPosition = ListView.INVALID_POSITION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);

        listViewAllEmployees = findViewById(R.id.listViewAllEmployees);
        buttonAddEmployee = findViewById(R.id.buttonAddEmployee);
        buttonDeleteEmployee = findViewById(R.id.buttonDeleteEmployee);
        employeeList = new ArrayList<>();
        employeeListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employeeList);
        listViewAllEmployees.setAdapter(employeeListAdapter);


        // Set onClick listeners
        listViewAllEmployees.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lastSelectedItemPosition = position;
            }
        });

        buttonAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, AdminActivity2.class);
                startActivityForResult(intent, ADD_EMPLOYEE_REQUEST_CODE);
            }
        });

        buttonDeleteEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastSelectedItemPosition != ListView.INVALID_POSITION) {
                    employeeList.remove(lastSelectedItemPosition);
                    employeeListAdapter.notifyDataSetChanged();
                    Toast.makeText(AdminActivity.this, "Employee deleted", Toast.LENGTH_SHORT).show();
                    lastSelectedItemPosition = ListView.INVALID_POSITION;
                } else {
                    Toast.makeText(AdminActivity.this, "Please select an employee to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_EMPLOYEE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String employeeDetails = data.getStringExtra("employeeDetails");
            employeeList.add(employeeDetails);
            employeeListAdapter.notifyDataSetChanged();
        }
    }
}
