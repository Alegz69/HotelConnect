package com.example.projectsda;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_home, container, false);

        Button bookButton = rootView.findViewById(R.id.book);
        bookButton.setOnClickListener(view -> {
            EditText rooms = rootView.findViewById(R.id.editTextNumberSigned2);
            EditText people = rootView.findViewById(R.id.editTextNumberSigned3);

            String roomsText = rooms.getText().toString();
            String peopleText = people.getText().toString();



            if (!roomsText.isEmpty() && !peopleText.isEmpty()) {
                int numRooms = Integer.parseInt(roomsText);
                int numPeople = Integer.parseInt(peopleText);

                float numPeoplePerRoom = (float) numPeople /numRooms;

                if (numRooms < 1 || numRooms>10 || numPeople<1 || numPeoplePerRoom>2 || numPeoplePerRoom<1) {
                   Toast.makeText(getContext(),"Invalid", Toast.LENGTH_LONG).show();
                } else {
                    sendEmail(numRooms, numPeople);
                }
            }
        });

        return rootView;
    }

    private void sendEmail(int numRooms, int numPeople) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@example.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Booking");
        i.putExtra(Intent.EXTRA_TEXT, "I would like to book " + numRooms + " rooms for " + numPeople + " people.");
        startActivity(Intent.createChooser(i, "Send mail..."));
    }
}
