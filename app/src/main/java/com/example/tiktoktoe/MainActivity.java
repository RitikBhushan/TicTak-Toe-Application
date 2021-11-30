package com.example.tiktoktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0;

    int []store={2,2,2,2,2,2,2,2,2};
    int [][]winPosition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view){
//         0=zero and 1=cross

        ImageView zero=(ImageView) view;
        System.out.println( zero.getTag().toString());
        int tagstore=Integer.parseInt(zero.getTag().toString());

        if (store[tagstore]==2 ) {
//            gameActive=false;
            store[tagstore]=activePlayer;
            zero.setTranslationY(-1000f);
            if (activePlayer == 0) {
                zero.setImageResource(R.drawable.pngegg);
                activePlayer = 1;
            } else {
                zero.setImageResource(R.drawable.zero);
                activePlayer = 0;
            }

            zero.animate().translationYBy(1000f).rotation(360f).setDuration(200);

            for(int[]winPosition : winPosition){
                if (store[winPosition[0]]==store[winPosition[1]] &&
                     store[winPosition[1]]==store[winPosition[2]]&&
                        store[winPosition[0]]!=2){

                    String name="Zero";

                    if (store[winPosition[0]]==0){

                            name="Cross";
                    }

                    TextView winner =(TextView)findViewById(R.id.textView);
                    winner.setText(name+ "has won!");

                    LinearLayout layout =(LinearLayout)findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
//                    Toast.makeText(getApplicationContext(), "You Won", Toast.LENGTH_LONG).show();

                }

            }
        }
    }
    public void playAgainBtn(View view){
//        gameActive=true;
        LinearLayout layout =(LinearLayout)findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);
        activePlayer=0;
        for (int i=0; i<store.length; i++){

            store[i]=2;
        }
        GridLayout gridlayout=(GridLayout)findViewById(R.id.gridLayout);
        for(int i=0; i< gridlayout.getChildCount(); i++){

            ((ImageView) gridlayout.getChildAt(i)).setImageResource(0);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}