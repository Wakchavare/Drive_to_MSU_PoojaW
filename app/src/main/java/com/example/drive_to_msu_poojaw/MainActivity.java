package com.example.drive_to_msu_poojaw;

// MainActivity.java
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button driveToMSUButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Drive to MSU button by its ID
        driveToMSUButton = findViewById(R.id.driveToMSUButton);

        // Set an OnClickListener for the button
        driveToMSUButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a URI for Montclair State University's location
                Uri gmmIntentUri = Uri.parse("google.navigation:q=Montclair+State+University");

                // Create an Intent to launch Google Maps with navigation
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                // Check if Google Maps is installed
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    // Launch Google Maps with navigation
                    startActivity(mapIntent);
                } else {
                    // Handle case where Google Maps is not installed
                    // Display a message to the user or redirect to the Play Store to install Google Maps
                }
            }
        });
    }
}
