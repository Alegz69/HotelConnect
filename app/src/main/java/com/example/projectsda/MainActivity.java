package com.example.projectsda;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefsFile";
    static final String PREF_EMAIL = "email";
    public static final String PREF_PASSWORD = "password";

    public static class UserData {
        private String email;
        private String password;

        public UserData() {
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public JSONObject toJSON() {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("email", getEmail());
                jsonObject.put("password", getPassword());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jsonObject;
        }

        public static UserData fromJSON(JSONObject jsonObject) {
            UserData userData = new UserData();
            try {
                userData.setEmail(jsonObject.getString("email"));
                userData.setPassword(jsonObject.getString("password"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return userData;
        }
    }

    public void menuActivity(View v) {
        Intent i = new Intent(this, ViewsActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UserData savedCredentials = getSavedCredentialsFromSharedPreferences();

        if (savedCredentials != null) {
            Intent menuIntent = new Intent(this, ViewsActivity.class);
            startActivity(menuIntent);
            finish();
            return;
        }

        EditText text = findViewById(R.id.userMail);
        EditText pass = findViewById(R.id.userPass);
        Button button = findViewById(R.id.but);

        button.setOnClickListener(v -> {

            String email = text.getText().toString().trim();
            String password = pass.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Email and password cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }


            if (email.equals("admin") && password.equals("admin")) {
                Intent adminIntent = new Intent(this, AdminActivity.class);
                startActivity(adminIntent);
                finish();
                return;
            }

            UserData userData = new UserData();
            userData.setEmail(email);
            userData.setPassword(password);

            CheckBox rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox);
            boolean rememberMe = rememberMeCheckBox.isChecked();

            performFileOperations(userData, rememberMe);

            UserData savedCredentials1 = getSavedCredentialsFromSharedPreferences();

            if (savedCredentials1 != null) {
                Intent menuIntent = new Intent(MainActivity.this, ViewsActivity.class);
                startActivity(menuIntent);
                finish();
            } else {
                menuActivity(v);
            }
        });
    }

    private void performFileOperations(UserData userData, boolean rememberMe) {
        saveUserDataToJSON(userData);

        if (rememberMe) {
            saveCredentialsToSharedPreferences(userData.getEmail(), userData.getPassword());
        } else {
            clearCredentialsFromSharedPreferences();
        }
    }

    private void saveCredentialsToSharedPreferences(String email, String password) {
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(PREF_EMAIL, email);
        editor.putString(PREF_PASSWORD, password);
        editor.apply();
    }

    private void clearCredentialsFromSharedPreferences() {
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.remove(PREF_EMAIL);
        editor.remove(PREF_PASSWORD);
        editor.apply();
    }

    private UserData getSavedCredentialsFromSharedPreferences() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String email = prefs.getString(PREF_EMAIL, null);
        String password = prefs.getString(PREF_PASSWORD, null);

        if (email != null && password != null) {
            UserData userData = new UserData();
            userData.setEmail(email);
            userData.setPassword(password);
            return userData;
        } else {
            return null;
        }
    }

    private void saveUserDataToJSON(UserData userData) {
        try {
            FileOutputStream fileOutputStream = openFileOutput("userdata.json", Context.MODE_PRIVATE);
            JSONObject jsonObject = userData.toJSON();
            String jsonString = jsonObject.toString();
            fileOutputStream.write(jsonString.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private UserData readUserDataJSON() {
        try {
            FileInputStream fileInputStream = openFileInput("userdata.json");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            fileInputStream.close();
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            return UserData.fromJSON(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
