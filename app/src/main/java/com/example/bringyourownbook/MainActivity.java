package com.example.bringyourownbook;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//Name: Gursher Baath
//Date: June 15 2020
//Purpose: Unit 4 Project - Bring Your Own Book

public class MainActivity extends AppCompatActivity {

    Deck d = new Deck();

    //variable that holds which player is the picker
    int jnum = 1;

    //variables that hold whether or not the player has been locked in as the winner of the round
    int p1lock = 0;
    int p2lock = 0;
    int p3lock = 0;
    int p4lock = 0;

    //variables that hold the score for each player
    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    int score4 = 0;

    //initializing the count down timer variable
    CountDownTimer start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //pops a card off the stack and displays its prompt information on the screen
    public void display() {
        if (!d.isEmpty()) {
            Card c = d.pop();
            TextView prompt = (TextView) findViewById(R.id.prompt);
            prompt.setText(c.getPrompt());
        }
    }
    //calls the display method
    public void pop(View view) { display(); }

    //resets the game
    public void reset(View view) {
        //shuffles the cards
        d.shuffle();
        //shows a new card on the screen
        display();
        //unlocks all the player buttons so that none of them are locked in to win the round
        unlock();
        //resets the score of all players
        score1 = 0;
        score2 = 0;
        score3 = 0;
        score4 = 0;
        //shows the scoree of all the players after the reset on the screen
        TextView p1 = (TextView) findViewById(R.id.p1);
        p1.setText("P1: ");
        TextView p2 = (TextView) findViewById(R.id.p2);
        p2.setText("P2: ");
        TextView p3 = (TextView) findViewById(R.id.p3);
        p3.setText("P3: ");
        TextView p4 = (TextView) findViewById(R.id.p4);
        p4.setText("P4: ");
        TextView judge = (TextView) findViewById(R.id.judge);
        judge.setText("Picker: P1");
        //cancels the count down timer
        start.cancel();
        //resets what the timer should display on the screen
        TextView gotit = (TextView) findViewById(R.id.gotit);
        gotit.setText("TIMER");
        //makes the timer button clickable
        gotit.setEnabled(true);
    }

    //method thats sets up a new round after one is over
    public void nextturn(View view) {
        //shows a new card on the screen
        display();
        //changes the picker
        jchange();
        //cancels the timer
        start.cancel();
        //resets what the timer should display on the screen
        TextView gotit = (TextView) findViewById(R.id.gotit);
        gotit.setText("TIMER");
        //makes the timer button clickable
        gotit.setEnabled(true);
        /*if player 1 was locked in the previous round it then,
        -increases their score
        -updates that new score on the screen
        -and if that score reached 2, reminds the players to rotate their books.
        -------------------SAME STEPS FOR ALL THE PLAYERS------------------------*/
        if (p1lock == 1) {
            score1++;
            TextView p1 = (TextView) findViewById(R.id.p1);
            p1.setText("P1: " + score1);
            if (score1 == 2) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setPositiveButton("Done", null);
                builder.setTitle("ROTATE!");
                builder.setMessage("A player has won 2 rounds. Everyone passes " +
                        "their book to the left.");
                builder.show();
            }
        } else if (p2lock == 1) {
            score2++;
            TextView p2 = (TextView) findViewById(R.id.p2);
            p2.setText("P2: " + score2);
            if (score2 == 2) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setPositiveButton("Done", null);
                builder.setTitle("ROTATE!");
                builder.setMessage("A player has won 2 rounds. Everyone passes " +
                        "their book to the left.");
                builder.show();
            }
        } else if (p3lock == 1) {
            score3++;
            TextView p3 = (TextView) findViewById(R.id.p3);
            p3.setText("P3: " + score3);
            if (score3 == 2) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setPositiveButton("Done", null);
                builder.setTitle("ROTATE!");
                builder.setMessage("A player has won 2 rounds. Everyone passes " +
                        "their book to the left.");
                builder.show();
            }
        } else if (p4lock == 1) {
            score4++;
            TextView p4 = (TextView) findViewById(R.id.p4);
            p4.setText("P4: " + score4);
            if (score4 == 2) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setPositiveButton("Done", null);
                builder.setTitle("ROTATE!");
                builder.setMessage("A player has won 2 rounds. Everyone passes " +
                        "their book to the left.");
                builder.show();
            }
        }
        //unlocks all the player buttons
        unlock();
    }
    //method that changes who the picker is and updates it on the screen (called every time there's a new round)
    public void jchange() {
        if (jnum == 4)
            jnum = 1;
        else
            jnum++;
        TextView judge = (TextView) findViewById(R.id.judge);
        judge.setText("Picker: P" + jnum);
    }
    //unlocks all player buttons and then locks in player 1 by changing the player lock variable and
    // changing the textview background colour so the user knows this player button is locked in
    //----------------------SAME FOR ALL PLAYER BUTTONS---------------------------
    public void p1click(View view) {
        unlock();
        p1lock = 1;
        TextView p1 = (TextView) findViewById(R.id.p1);
        p1.setBackgroundColor(Color.parseColor("#90c7de"));
    }

    public void p2click(View view) {
        unlock();
        p2lock = 1;
        TextView p2 = (TextView) findViewById(R.id.p2);
        p2.setBackgroundColor(Color.parseColor("#90c7de"));
    }

    public void p3click(View view) {
        unlock();
        p3lock = 1;
        TextView p3 = (TextView) findViewById(R.id.p3);
        p3.setBackgroundColor(Color.parseColor("#90c7de"));
    }

    public void p4click(View view) {
        unlock();
        p4lock = 1;
        TextView p4 = (TextView) findViewById(R.id.p4);
        p4.setBackgroundColor(Color.parseColor("#90c7de"));
    }
    /*unlocks all the player buttons by
    - changing player lock variables to 0
    - changing textview background colour to default
    */

    public void unlock() {
        p1lock = 0;
        p2lock = 0;
        p3lock = 0;
        p4lock = 0;
        TextView p1 = (TextView) findViewById(R.id.p1);
        TextView p2 = (TextView) findViewById(R.id.p2);
        TextView p3 = (TextView) findViewById(R.id.p3);
        TextView p4 = (TextView) findViewById(R.id.p4);
        p1.setBackgroundColor(Color.parseColor("#0c9cd9"));
        p2.setBackgroundColor(Color.parseColor("#0c9cd9"));
        p3.setBackgroundColor(Color.parseColor("#0c9cd9"));
        p4.setBackgroundColor(Color.parseColor("#0c9cd9"));
    }
    //changes to the instructions screen
    public void toInstructions(View view) {
        Intent i = new Intent(this, InstructionsActivity.class);
        startActivity(i);
    }
    /*
    The timer method is called when the timer button is clicked and does the following:
    - disables the timer button so it can not be clicked twice (error handling purposes)
    - initializes the alert dialogue box that will come when the timer is finished
    - starts a new count down timer for 60000 milliseconds that updates every 1000 milliseconds
     */
    public void timer(View view) {
        final TextView gotit = (TextView) findViewById(R.id.gotit);
        gotit.setEnabled(false);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Done", null);
        builder.setTitle("Time's Up");
        builder.setMessage("Seekers are out of time to find a response." +
                " They must now take turns saying their answers out loud for the Picker.");
        start = new CountDownTimer(60000, 1000) {
            //Every 1000 milliseconds updates the textview with the seconds remaining on the timer
            public void onTick(long millisUntilFinished) {
                gotit.setText("" + millisUntilFinished / 1000);
            }
            /*when the timer finishes:
            - shows the initialized alert dialogue box
            - resets the original text on the timer
            - enables the timer button to be clickable again
            */
            public void onFinish() {
                builder.show();
                gotit.setText("TIMER");
                gotit.setEnabled(true);
            }
        }.start();
    }

}