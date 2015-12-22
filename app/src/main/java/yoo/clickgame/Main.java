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


    int click=0;
    int setNum = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundMusic = MediaPlayer.create(Main.this, R.raw.background);
        clickSound = MediaPlayer.create(Main.this,R.raw.click);
        score = (TextView) findViewById(R.id.scoreText);
        image = (ImageButton) findViewById(R.id.ImageButton);


        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(0.7f, 0.7f);
        backgroundMusic.start();

    }

    public void clickImage(View view)
    {
        click++;
        clickSound.start();

        if (click==setNum)
        {
            click=0;
            setNum =setNum+5;


            String temp = click+" / "+setNum;
            score.setText(temp);


            changeImage(view, setNum);

        }
        else {

            String temp = click + " / " + setNum;
            score.setText(temp);
        }
    }

    @Override
    public void onPause()
    {
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
    public void onRestart()
    {
        super.onRestart();
        backgroundMusic.start();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        backgroundMusic.stop();
    }

    public void changeImage(View view, int setNum){

        switch(setNum)
        {
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
            case 40:
            {
                image.setImageResource(R.drawable.eight);
                break;
            }
            case 45:
            {
                image.setImageResource(R.drawable.nine);
                break;
            }
            case 50:
            {
                image.setImageResource(R.drawable.ten);
                break;
            }
            case 55:
            {
                image.setImageResource(R.drawable.eleven);
                break;
            }
            case 60:
            {
                image.setImageResource(R.drawable.twelve);
                break;
            }
            case 65:
            {
                image.setImageResource(R.drawable.thirteen);
                break;
            }
            case 70:
            {
                image.setImageResource(R.drawable.fourteen);
                break;
            }
            case 75:
            {
                image.setImageResource(R.drawable.fifteen);
                break;
            }
            case 80:
            {
                image.setImageResource(R.drawable.sixteen);
                break;
            }
            case 85:
            {
                image.setImageResource(R.drawable.seventeen);
                break;
            }
            case 90:
            {
                image.setImageResource(R.drawable.eighteen);
                break;
            }
            case 95:
            {
                image.setImageResource(R.drawable.nineteen);
                break;
            }

            case 100:
            {
                image.setImageResource(R.drawable.twenty);
                break;
            }
            case 105:
            {
                image.setImageResource(R.drawable.twentyone);
                break;
            }
            default:
            {
                break;
            }


        }

    }

}
