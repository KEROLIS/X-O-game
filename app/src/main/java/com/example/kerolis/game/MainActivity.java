package com.example.kerolis.game;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;





public class MainActivity extends AppCompatActivity {
MediaPlayer mediaPlayer;
   private int player=0 ;

    int gameState[]={2,2,2,2,2,2,2,2,2};

    int winningPossions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
  public  void mid (View view)
    {   ImageView red= (ImageView) view;

        if(gameState[Integer.parseInt(red.getTag().toString())]==2){
        if (player==0){
                          red.setImageResource(R.drawable.yellow);
                          player=1;
                          gameState[Integer.parseInt(red.getTag().toString())]=0;
                      }

        else{
            red.setImageResource(R.drawable.red);
            player=0;
            gameState[Integer.parseInt(red.getTag().toString())]=1 ;}
            red.setTranslationY(-1000f);
            red.animate().translationYBy(1000f).rotation(1000f).setDuration(1000);

            for(int winnigPossition[]:winningPossions)
            {
                if (gameState[winnigPossition[0]] == gameState[winnigPossition[1]]
                        && gameState[winnigPossition[1]]==gameState[winnigPossition[2]]
                        &&gameState[winnigPossition[0]]!=2)
                {
                    LinearLayout playAgainLayout= (LinearLayout) findViewById(R.id.PlayAgainLayout);
                    GridLayout gird = (GridLayout) findViewById(R.id.gird);

                    TextView wow= (TextView) findViewById(R.id.textView);
                    wow.setText("     Has won !");

                    mediaPlayer=MediaPlayer.create(this,R.raw.u);
                    mediaPlayer.start();

                    ImageView to= (ImageView) findViewById(R.id.win);
                    gird.setVisibility(View.INVISIBLE);
                    playAgainLayout.setVisibility(View.VISIBLE);


                    if (player==1){to.setImageResource(R.drawable.yellow);}

                    else {to.setImageResource(R.drawable.red);}
                    break;
                }
                else {

                    boolean gameIsOver = true;

                    for (int counterState : gameState) {

                        if (counterState == 2){ gameIsOver = false;break;}

                    } if (gameIsOver){
                        TextView wow= (TextView) findViewById(R.id.textView);
                        ImageView to= (ImageView) findViewById(R.id.win);
                        to.setImageResource(0);
                        wow.setText("     Draw !");
                        LinearLayout playAgainLayout= (LinearLayout) findViewById(R.id.PlayAgainLayout);
                        GridLayout gird = (GridLayout) findViewById(R.id.gird); gird.setVisibility(View.INVISIBLE);
                        playAgainLayout.setVisibility(View.VISIBLE);


                       }
            }
        }
    }
    }
    public  void again (View view){
        LinearLayout playAgainLayout= (LinearLayout) findViewById(R.id.PlayAgainLayout);
        GridLayout gird = (GridLayout) findViewById(R.id.gird);
        //the default of the game in logic of this
        for (int i = 0; i <gameState.length ; i++) {gameState[i]=2;}
        //the default state of the board (visible)
        for (int i = 0; i <gird.getChildCount() ; i++) {
            ((ImageView)gird.getChildAt(i)).setImageResource(0);
        }
        //the switch between the winning layout and the game board layout
        playAgainLayout.setVisibility(View.INVISIBLE);
        gird.setVisibility(View.VISIBLE);

        

    }
    public  void donky (View view){
        Toast.makeText(this, "دوس على الزرار يا حمار", Toast.LENGTH_LONG).show();}

}
