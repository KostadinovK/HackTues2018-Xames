package com.theerrors.xames;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.iv_game_one)
    ImageView mIvGameOne;
    @BindView(R.id.iv_game_two)
    ImageView mIvGameTwo;
    @BindView(R.id.iv_game_three)
    ImageView mIvGameThree;
    @BindView(R.id.iv_game_four)
    ImageView mIvGameFour;
    MediaPlayer backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backgroundMusic = MediaPlayer.create(MainActivity.this, R.raw.tick_tock_game);
        ButterKnife.bind(this);
        backgroundMusic.start();
    }

    @OnClick(R.id.iv_game_one)
    public void onClickGameOne() {
        Intent intent = new Intent(MainActivity.this, BasheMenuActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.iv_game_two)
    public void OnClickImageTwo() {
        Intent intent = new Intent(this, DudeliMenuActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.iv_game_three)
    public void OnClickImageThree() {
        Intent intent = new Intent(this, EvenManiaGameActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.iv_game_four)
    public void OnClickImageFour() {
        Context context = getApplicationContext();
        Toast msg = Toast.makeText(context,R.string.coming_soon,Toast.LENGTH_LONG);
        msg.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.language_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.bulgarian_option){

            String languageToLoad  = "bg";
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            this.getResources().updateConfiguration(config,this.getResources().getDisplayMetrics());


            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("Music playing","Music is already playing!");
            startActivity(intent);
        }else{
            String languageToLoad  = "en";
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            this.getResources().updateConfiguration(config,this.getResources().getDisplayMetrics());

            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("Music playing","Music is already playing!");
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}
