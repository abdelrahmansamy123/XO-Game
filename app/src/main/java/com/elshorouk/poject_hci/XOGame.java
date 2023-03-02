package com.elshorouk.poject_hci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class XOGame extends AppCompatActivity {

    TextView player1ScoreTextView;
    TextView player2ScoreTextView;
    ConstraintLayout rootLayout;
    int counter = 0;
    int player1score = 0;
    int player2score = 0;
    ArrayList<String> boardState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1ScoreTextView = findViewById(R.id.player_1_score);
        player2ScoreTextView = findViewById(R.id.player_2_score);
        rootLayout = findViewById(R.id.root_element);
        initializeBoardState();
    }

    void initializeBoardState() {
        boardState = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            boardState.add("");
        }
        for (int i = 0; i < rootLayout.getChildCount(); i++) {
            View view = rootLayout.getChildAt(i);
            if (view instanceof Button) {
                ((Button) view).setText("");
            }
        }

    }

    public void onPlayerClick(View view) {
        Button clickedbutton = (Button) view;
        //clickedbutton.setEnabled(false);
        if (!clickedbutton.getText().toString().isEmpty()) {
            return;
        }
        String playerSympol = "";
        if (counter % 2 == 0) {
            playerSympol = "X";
            clickedbutton.setText("X");
            player1score += 0;


        } else {
            playerSympol = "O";
            clickedbutton.setText("O");
            player2score += 0;

        }
        counter++;

        writePlayerSympolInState(view.getId(), playerSympol);

        if (checkWinner("X")) {
            // X id the winner
            // inCrease score
            // reinitialize game
            player1score += 1;
            initializeBoardState();
            counter = 0;
        } else if (checkWinner("O")) {
            // X id the winner
            // inCrease score
            // reinitialize game
            player2score += 1;
            initializeBoardState();
            counter = 0;
        } else if (counter == 9) {
            // draw
            initializeBoardState();
            counter = 0;
        }
        player1ScoreTextView.setText("" + player1score);
        player2ScoreTextView.setText("" + player2score);


    }
    // ["x","x","x",
    //   "x","x","x"
    //    ,"x","x","x"]

    boolean checkWinner(String playerCode) {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (boardState.get(i).equals(playerCode) &&
                    boardState.get(i + 1).equals(playerCode) &&
                    boardState.get(i + 2).equals(playerCode)) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i += 1) {
            if (boardState.get(i).equals(playerCode) &&
                    boardState.get(i + 3).equals(playerCode) &&
                    boardState.get(i + 6).equals(playerCode)) {
                return true;
            }
        } // Check Diagonal
        if (boardState.get(0).equals(playerCode) &&
                boardState.get(4).equals(playerCode) &&
                boardState.get(8).equals(playerCode)) {
            return true;
        }
        if (boardState.get(2).equals(playerCode) &&
                boardState.get(4).equals(playerCode) &&
                boardState.get(6).equals(playerCode)) {
            return true;
        }
        return false;
    }

    void writePlayerSympolInState(int id, String playerSympol) {
        if (id == R.id.btn1) {
            boardState.set(0, playerSympol);
        }
        if (id == R.id.btn2) {
            boardState.set(1, playerSympol);
        }
        if (id == R.id.btn3) {
            boardState.set(2, playerSympol);
        }
        if (id == R.id.btn4) {
            boardState.set(3, playerSympol);
        }
        if (id == R.id.btn5) {
            boardState.set(4, playerSympol);
        }
        if (id == R.id.btn6) {
            boardState.set(5, playerSympol);
        }
        if (id == R.id.btn7) {
            boardState.set(6, playerSympol);
        }
        if (id == R.id.btn8) {
            boardState.set(7, playerSympol);
        }
        if (id == R.id.btn9) {
            boardState.set(8, playerSympol);
        }

    }


}