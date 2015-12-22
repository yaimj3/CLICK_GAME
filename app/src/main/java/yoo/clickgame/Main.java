package yoo.clickgame;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main extends ActionBarActivity {

    private TextView score,goldView;
    private ImageButton image,reset,shop;
    private MediaPlayer backgroundMusic,clickSound;

    SharedPreferences shared;
    SharedPreferences.Editor editor;
    int click = 0;
    int setNum = 10;
    int gold = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        backgroundMusic = MediaPlayer.create(Main.this, R.raw.background);
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(0.1f, 0.1f);
        backgroundMusic.start();

        clickSound = MediaPlayer.create(Main.this, R.raw.click);
        score = (TextView) findViewById(R.id.scoreText);
        image = (ImageButton) findViewById(R.id.imageButton);
        reset = (ImageButton) findViewById(R.id.resetButton);
        shop = (ImageButton) findViewById(R.id.shopButton);
        goldView = (TextView) findViewById(R.id.goldText);

        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickSound.setVolume(1.0f, 1.0f);
                clickSound.start();
                clickSound.stop();

                click++;
                gold++;
                checksetNum();

            }
        });

       reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                click=0;
                setNum=10;
                String temp = click + " / " + setNum;
                score.setText(temp);

                changeImage(setNum - 5);

            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        backgroundMusic.start();
    }
    @Override
    public void onPause() {
        super.onPause();
        shared = getPreferences(Activity.MODE_PRIVATE);
        editor = shared.edit();
        editor.putInt("click",click);
        editor.putInt("setNum",setNum);
        editor.putInt("gold",gold);
        editor.commit();
        backgroundMusic.pause();
    }

    @Override
    public void onSaveInstanceState (Bundle saveInstanceState)
    {
        if (saveInstanceState!=null)
        {saveInstanceState.putInt("click",click);
        saveInstanceState.putInt("setNum",setNum);
        saveInstanceState.putInt("gold",gold);
        }
        super.onSaveInstanceState(saveInstanceState);

    }

    @Override
    public void onRestoreInstanceState (Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        click = savedInstanceState.getInt("click");
        setNum = savedInstanceState.getInt("setNum");
        gold = savedInstanceState.getInt("gold");

        String temp = click + " / " + setNum;
        score.setText(temp);
        temp = gold + " ";
        goldView.setText(temp);
        changeImage(setNum-5);
        backgroundMusic.start();
    }
    @Override
    public void onStop() {
        super.onStop();

        backgroundMusic.stop();
    }

    @Override
    public void onResume() {
        super.onResume();

        shared = getPreferences(Activity.MODE_PRIVATE);
        click = shared.getInt("click",0);
        setNum = shared.getInt("setNum", 10);
        gold = shared.getInt("gold",0);
        String temp = click + " / " + setNum;
        score.setText(temp);
        temp = gold + " ";
        goldView.setText(temp);
        changeImage(setNum-5);
        backgroundMusic.start();
    }

    @Override
    public void onRestart() {
        super.onRestart();
        shared = getPreferences(Activity.MODE_PRIVATE);
        click = shared.getInt("click",0);
        setNum = shared.getInt("setNum", 10);
        gold=shared.getInt("gold",0);

        String temp = click + " / " + setNum;
        score.setText(temp);
        temp = gold + " ";
        goldView.setText(temp);
        changeImage(setNum - 5);

        backgroundMusic.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        backgroundMusic.stop();
    }

    public void checksetNum()
    {
        if (click == setNum) {

            changeImage(setNum);

            click = 0;
            setNum = setNum + 5;
            String temp = click + " / " + setNum;
            score.setText(temp);
            temp = gold + " ";
            goldView.setText(temp);

        } else {

            String temp = click + " / " + setNum;
            score.setText(temp);
            temp = gold + " ";
            goldView.setText(temp);
        }
    }
    public void changeImage(int setNum)
    {
        switch (setNum) {
            case 5:
            {
                image.setImageResource(R.drawable.one);
                break;
            }
            case 10:
            {
                image.setImageResource(R.drawable.two);
                break;
            }
            case 15:
            {
                image.setImageResource(R.drawable.three);
                break;
            }
            case 20:
            {
                image.setImageResource(R.drawable.four);
                break;
            }
            case 25:
            {
                image.setImageResource(R.drawable.five);
                break;
            }
            case 30:
            {
                image.setImageResource(R.drawable.six);
                break;
            }
            case 35:
            {
                image.setImageResource(R.drawable.seven);
                break;
            }
            default: {
                break;
            }


        }
    }

}
