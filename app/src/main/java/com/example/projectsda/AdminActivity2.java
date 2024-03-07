package com.example.projectsda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class AdminActivity2 extends AppCompatActivity {

    private EditText editTextEmployeeName;
    private EditText editTextEmployeePosition;
    private EditText editTextWorkingHours;
    private Button buttonAddEmployee;
    private CalendarView calendarView;
    private String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity2);

        editTextEmployeeName = findViewById(R.id.editTextEmployeeName);
        editTextEmployeePosition = findViewById(R.id.editTextEmployeePosition);
        buttonAddEmployee = findViewById(R.id.buttonAddEmployee);
        editTextWorkingHours = findViewById(R.id.editTextWorkingHours);
        calendarView = findViewById(R.id.calendarView);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy", Locale.getDefault());
        date = dateFormat.format(calendarView.getDate());



        buttonAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEmployee();
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Calendar selectedDate = new GregorianCalendar(year, month, dayOfMonth);
                date = dateFormat.format(selectedDate.getTime());
            }
        });



    }

    private void addEmployee() {
        String employeeName = editTextEmployeeName.getText().toString().trim();
        String employeePosition = editTextEmployeePosition.getText().toString().trim();
        String workingHours = editTextWorkingHours.getText().toString().trim();

        if (employeeName.isEmpty() || employeePosition.isEmpty() || workingHours.isEmpty()) {
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
            return;
        }

        String employeeDetails = employeeName + " - " + employeePosition + " - " + workingHours + " - " + date;
        Intent intent = new Intent();
        intent.putExtra("employeeDetails", employeeDetails);
        setResult(RESULT_OK, intent);

        Toast.makeText(this, "Employee added successfully", Toast.LENGTH_SHORT).show();

        editTextEmployeeName.setText("");
        editTextEmployeePosition.setText("");
        editTextWorkingHours.setText("");

    }
}
