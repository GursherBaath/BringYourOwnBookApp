package com.example.bringyourownbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions2);
    }
    /*method that finishes the instructions screen so the user is back to the game screen.
    By finishing the instructions activity instead of starting the game activity again,
    the game state still exists when the user goes back
     */

    public void toGame(View view) {
        finish();
    }

}
