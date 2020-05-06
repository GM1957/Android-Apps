package com.example.ticktacktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //player representation
    // 0 - X
    // 1 - O
    boolean gameActive = true;
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    //state meanings
    // 0 - X
    // 1 - O
    // 2- null
    int [][] winPositions = {

                             {0,1,2},{3,4,5},{6,7,8},
                             {0,3,6},{1,4,7},{2,5,8},
                             {0,4,8},{2,4,6}

                            };


    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }

        if (gameState[tappedImage] == 2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O: turn tap to play");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X: turn tap to play");
            }

            img.animate().translationYBy(1000f).setDuration(300);

        }
        //check if player won
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {
                // gameState [winpositiom[0]] is won
                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    //x won
                    TextView status = findViewById(R.id.status);
                    status.setText("X: WON");

                }
                if (gameState[winPosition[0]] == 1) {
                    //o won
                    TextView status = findViewById(R.id.status);
                    status.setText("O: WON");

                }

            }
        }
    }
    public void gameReset(View view){
        gameActive = true;
        activePlayer = 0;

        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }


        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
