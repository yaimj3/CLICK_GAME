package yoo.clickgame;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main extends ActionBarActivity {

    private TextView score;
    private ImageButton image;
    private MediaPlayer backgroundMusic,clickSound;
    int click = 0;
    int setNum = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        backgroundMusic = MediaPlayer.create(Main.this, R.raw.background);
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(0.1f, 0.1f);

        clickSound = MediaPlayer.create(Main.this, R.raw.click);
        score = (TextView) findViewById(R.id.scoreText);
        image = (ImageButton) findViewById(R.id.imageButton);


        backgroundMusic.start();

        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickSound.setVolume(1.0f, 1.0f);
                clickSound.start();
                clickSound.stop();

                click++;
                checksetNum(v);

            }
        });
    }


    @Override
    public void onPause() {
        super.onPause();


      backgroundMusic.pause();
    }

    @Override
    public void onStop() {
        super.onStop();

      backgroundMusic.stop();
    }

    @Override
    public void onResume() {
        super.onResume();


      backgroundMusic.start();
    }

    @Override
    public void onRestart() {
        super.onRestart();
      backgroundMusic.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
      backgroundMusic.stop();
    }

    public void checksetNum(View view)
    {
        if (click == setNum) {

            changeImage(setNum);

            click = 0;
            setNum = setNum + 5;
            String temp = click + " / " + setNum;
            score.setText(temp);

        } else {

            String temp = click + " / " + setNum;
            score.setText(temp);
        }
    }
    public void changeImage(int setNum)
    {
        switch (setNum) {
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

            default: {
                break;
            }


        }
    }
}
