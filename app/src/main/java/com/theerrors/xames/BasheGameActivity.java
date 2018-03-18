package com.theerrors.xames;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BasheGameActivity extends AppCompatActivity {
    int points = 21;
    boolean singlePlayer;
    Random rand = new Random();

    @BindView(R.id.rl_player1)
    RelativeLayout mRelativeLayout1;
    @BindView(R.id.rl_player2)
    RelativeLayout mRelativeLayout2;

    @BindView(R.id.btn_player1_submit)
    Button mSubmitBtn1;
    @BindView(R.id.btn_player2_submit)
    Button mSubmitBtn2;

    @BindView(R.id.sb_player1)
    SeekBar mPlayer1Bar;
    @BindView(R.id.sb_player2)
    SeekBar mPlayer2Bar;

    @BindView(R.id.tv_player1_points)
    TextView mPlayer1Points;
    @BindView(R.id.tv_player2_points)
    TextView mPlayer2Points;
    @BindView(R.id.tv_p1_remaining_score)
    TextView mP1RemainingScore;
    @BindView(R.id.tv_p2_remaining_score)
    TextView mP2RemainingScore;

    private void reverseColors(int choice) {
        if (choice == 1) {
            mRelativeLayout1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mSubmitBtn1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mSubmitBtn1.setTextColor(getResources().getColor(R.color.white));
            mPlayer1Points.setTextColor(getResources().getColor(R.color.white));
            mP1RemainingScore.setTextColor(getResources().getColor(R.color.white));

            mRelativeLayout2.setBackgroundColor(getResources().getColor(R.color.white));
            mSubmitBtn2.setBackgroundColor(getResources().getColor(R.color.white));
            mSubmitBtn2.setTextColor(getResources().getColor(R.color.colorPrimary));
            mPlayer2Points.setTextColor(getResources().getColor(R.color.colorPrimary));
            mP2RemainingScore.setTextColor(getResources().getColor(R.color.colorPrimary));
        } else {
            mRelativeLayout2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mSubmitBtn2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mSubmitBtn2.setTextColor(getResources().getColor(R.color.white));
            mPlayer2Points.setTextColor(getResources().getColor(R.color.white));
            mP2RemainingScore.setTextColor(getResources().getColor(R.color.white));

            mRelativeLayout1.setBackgroundColor(getResources().getColor(R.color.white));
            mSubmitBtn1.setBackgroundColor(getResources().getColor(R.color.white));
            mSubmitBtn1.setTextColor(getResources().getColor(R.color.colorPrimary));
            mPlayer1Points.setTextColor(getResources().getColor(R.color.colorPrimary));
            mP1RemainingScore.setTextColor(getResources().getColor(R.color.colorPrimary));
        }

    }

    private void checkForAWin() {
        if (points <= 0) {
            mSubmitBtn1.setEnabled(false);
            mSubmitBtn2.setEnabled(false);
            mPlayer1Bar.setEnabled(false);
            mPlayer2Bar.setEnabled(false);
            final AlertDialog.Builder builder = new AlertDialog.Builder(BasheGameActivity.this);
            builder.setMessage(R.string.win_message);
            builder.setTitle(R.string.game_over);
            builder.setNegativeButton(R.string.okay, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(BasheGameActivity.this, BasheMenuActivity.class);
                    startActivity(intent);
                }
            });
            AlertDialog endGame = builder.create();
            endGame.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bashe_main);
        ButterKnife.bind(this);
        singlePlayer = (getIntent().getExtras().getInt("PlayerAmount") == 1) ? true : false;
        mRelativeLayout1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSubmitBtn1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSubmitBtn1.setTextColor(getResources().getColor(R.color.white));
        mPlayer1Points.setTextColor(getResources().getColor(R.color.white));
        mP1RemainingScore.setTextColor(getResources().getColor(R.color.white));

        mPlayer1Bar.setMax(4);
        mPlayer2Bar.setMax(4);

        mPlayer2Bar.setEnabled(false);
        mSubmitBtn2.setEnabled(false);

        mPlayer1Points.setText(Integer.toString(mPlayer1Bar.getProgress() + 1));
        mPlayer2Points.setText(Integer.toString(mPlayer2Bar.getProgress() + 1));

        mP1RemainingScore.setText(Integer.toString(points));
        mP2RemainingScore.setText(Integer.toString(points));

        mPlayer1Bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mPlayer1Points.setText(Integer.toString(progress + 1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mPlayer2Bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mPlayer2Points.setText(Integer.toString(progress + 1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @OnClick(R.id.btn_player1_submit)
    public void onSubmitButton1Clicked() {
        reverseColors(2);
        points -= mPlayer1Bar.getProgress() + 1;
        if (points < 0 && singlePlayer) {
            reverseColors(1);
        }
        checkForAWin();
        mP1RemainingScore.setText(Integer.toString(Math.max(0, points)));
        mP2RemainingScore.setText(Integer.toString(Math.max(0, points)));
        mPlayer2Bar.setEnabled(true);
        mSubmitBtn2.setEnabled(true);
        mPlayer1Bar.setEnabled(false);
        mSubmitBtn1.setEnabled(false);
        if (singlePlayer) {
            boolean hardMode = rand.nextInt(2) + 1 == 1 ? false : true;
            if (hardMode) {
                mPlayer2Bar.setProgress((mPlayer2Bar.getMax() + 1) - mPlayer1Bar.getProgress());
            } else {
                mPlayer2Bar.setProgress(rand.nextInt(5) + 1);
            }
            reverseColors(1);
            points -= mPlayer2Bar.getProgress() + 1;
            if (points < 0) {
                reverseColors(2);
            }
            checkForAWin();
            mP1RemainingScore.setText(Integer.toString(Math.max(0, points)));
            mP2RemainingScore.setText(Integer.toString(Math.max(0, points)));
            mPlayer2Bar.setEnabled(false);
            mSubmitBtn2.setEnabled(false);
            mPlayer1Bar.setEnabled(true);
            mSubmitBtn1.setEnabled(true);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @OnClick(R.id.btn_player2_submit)
    public void onSubmitButton2Clicked() {
        reverseColors(1);
        points -= mPlayer2Bar.getProgress() + 1;
        checkForAWin();
        mP1RemainingScore.setText(Integer.toString(Math.max(0, points)));
        mP2RemainingScore.setText(Integer.toString(Math.max(0, points)));
        mPlayer2Bar.setEnabled(false);
        mSubmitBtn2.setEnabled(false);
        mPlayer1Bar.setEnabled(true);
        mSubmitBtn1.setEnabled(true);
    }
}
