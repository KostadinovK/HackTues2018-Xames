package com.theerrors.xames;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


// game of dudeli main activity
public class DudeliGameActivity extends AppCompatActivity {
    int points = 0;
    boolean singlePlayer;
    Random rand = new Random();

    @BindView(R.id.rl_player1_game2)
    RelativeLayout mRelativeLayout1;
    @BindView(R.id.rl_player2_game2)
    RelativeLayout mRelativeLayout2;

    @BindView(R.id.btn_p1_1)
    Button mBtn1P1;
    @BindView(R.id.btn_p1_2)
    Button mBtn2P1;
    @BindView(R.id.btn_p1_3)
    Button mBtn3P1;
    @BindView(R.id.btn_p1_4)
    Button mBtn4P1;
    @BindView(R.id.btn_p1_5)
    Button mBtn5P1;
    @BindView(R.id.btn_p2_1)
    Button mBtn1P2;
    @BindView(R.id.btn_p2_2)
    Button mBtn2P2;
    @BindView(R.id.btn_p2_3)
    Button mBtn3P2;
    @BindView(R.id.btn_p2_4)
    Button mBtn4P2;
    @BindView(R.id.btn_p2_5)
    Button mBtn5P2;

    @BindView(R.id.tv_player1_points)
    TextView mP1Points;
    @BindView(R.id.tv_player2_points)
    TextView mP2Points;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dudeli_main);
        singlePlayer = (getIntent().getExtras().getInt("PlayerAmount") == 1) ? true : false;
        ButterKnife.bind(this);
        BtnsP2SetDisabled();
        mP1Points.setText(Integer.toString(points));
        mP2Points.setText(Integer.toString(points));

        mRelativeLayout1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mBtn1P1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mBtn2P1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mBtn3P1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mBtn4P1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mBtn5P1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        mBtn1P1.setTextColor(getResources().getColor(R.color.white));
        mBtn2P1.setTextColor(getResources().getColor(R.color.white));
        mBtn3P1.setTextColor(getResources().getColor(R.color.white));
        mBtn4P1.setTextColor(getResources().getColor(R.color.white));
        mBtn5P1.setTextColor(getResources().getColor(R.color.white));
        mP1Points.setTextColor(getResources().getColor(R.color.white));


    }

    @OnClick(R.id.btn_p1_1)
    public void OnP1Btn1Clicked() {
        mBtn1P2.setEnabled(false);
        mBtn2P2.setEnabled(true);
        mBtn3P2.setEnabled(true);
        mBtn4P2.setEnabled(true);
        mBtn5P2.setEnabled(true);
        reverseColors(2);
        BtnsP1SetDisabled();
        points += 1;
        mP1Points.setText(Integer.toString(points));
        CheckForWinner();
        if (singlePlayer) {
            SinglePlayer();
        }
    }

    @OnClick(R.id.btn_p1_2)
    public void OnP1Btn2Clicked() {
        mBtn2P2.setEnabled(false);
        mBtn1P2.setEnabled(true);
        mBtn3P2.setEnabled(true);
        mBtn4P2.setEnabled(true);
        mBtn5P2.setEnabled(true);
        reverseColors(2);
        BtnsP1SetDisabled();
        points += 2;
        mP1Points.setText(Integer.toString(points));
        CheckForWinner();
        if (singlePlayer) {
            SinglePlayer();
        }
    }

    @OnClick(R.id.btn_p1_3)
    public void OnP1Btn3Clicked() {
        mBtn3P2.setEnabled(false);
        mBtn2P2.setEnabled(true);
        mBtn1P2.setEnabled(true);
        mBtn4P2.setEnabled(true);
        mBtn5P2.setEnabled(true);
        reverseColors(2);
        BtnsP1SetDisabled();
        points += 3;
        mP1Points.setText(Integer.toString(points));
        CheckForWinner();

        if (singlePlayer) {
            SinglePlayer();
        }
    }

    @OnClick(R.id.btn_p1_4)
    public void OnP1Btn4Clicked() {
        mBtn4P2.setEnabled(false);
        mBtn2P2.setEnabled(true);
        mBtn3P2.setEnabled(true);
        mBtn1P2.setEnabled(true);
        mBtn5P2.setEnabled(true);
        reverseColors(2);
        BtnsP1SetDisabled();
        points += 4;
        mP1Points.setText(Integer.toString(points));
        CheckForWinner();
        if (singlePlayer) {
            SinglePlayer();
        }
    }

    @OnClick(R.id.btn_p1_5)
    public void OnP1Btn5Clicked() {
        mBtn5P2.setEnabled(false);
        mBtn2P2.setEnabled(true);
        mBtn3P2.setEnabled(true);
        mBtn4P2.setEnabled(true);
        mBtn1P2.setEnabled(true);
        reverseColors(2);
        BtnsP1SetDisabled();
        points += 5;
        mP1Points.setText(Integer.toString(points));
        CheckForWinner();
        if (singlePlayer) {
            SinglePlayer();
        }
    }

    @OnClick(R.id.btn_p2_1)
    public void OnP2Btn1Clicked() {
        mBtn1P1.setEnabled(false);
        mBtn2P1.setEnabled(true);
        mBtn3P1.setEnabled(true);
        mBtn4P1.setEnabled(true);
        mBtn5P1.setEnabled(true);
        reverseColors(1);
        BtnsP2SetDisabled();
        points += 1;
        mP2Points.setText(Integer.toString(points));
        CheckForWinner();
    }

    @OnClick(R.id.btn_p2_2)
    public void OnP2Btn2Clicked() {
        mBtn2P1.setEnabled(false);
        mBtn1P1.setEnabled(true);
        mBtn3P1.setEnabled(true);
        mBtn4P1.setEnabled(true);
        mBtn5P1.setEnabled(true);
        reverseColors(1);
        BtnsP2SetDisabled();
        points += 2;
        mP2Points.setText(Integer.toString(points));
        CheckForWinner();
    }

    @OnClick(R.id.btn_p2_3)
    public void OnP2Btn3Clicked() {
        mBtn3P1.setEnabled(false);
        mBtn2P1.setEnabled(true);
        mBtn1P1.setEnabled(true);
        mBtn4P1.setEnabled(true);
        mBtn5P1.setEnabled(true);
        reverseColors(1);
        BtnsP2SetDisabled();
        points += 3;
        mP2Points.setText(Integer.toString(points));
        CheckForWinner();
    }

    @OnClick(R.id.btn_p2_4)
    public void OnP2Btn4Clicked() {
        mBtn4P1.setEnabled(false);
        mBtn2P1.setEnabled(true);
        mBtn3P1.setEnabled(true);
        mBtn1P1.setEnabled(true);
        mBtn5P1.setEnabled(true);
        reverseColors(1);
        BtnsP2SetDisabled();
        points += 4;
        mP2Points.setText(Integer.toString(points));
        CheckForWinner();
    }

    @OnClick(R.id.btn_p2_5)
    public void OnP2Btn5Clicked() {
        mBtn5P1.setEnabled(false);
        mBtn2P1.setEnabled(true);
        mBtn3P1.setEnabled(true);
        mBtn4P1.setEnabled(true);
        mBtn1P1.setEnabled(true);
        reverseColors(1);
        BtnsP2SetDisabled();
        points += 5;
        mP2Points.setText(Integer.toString(points));
        CheckForWinner();
    }

    public void BtnsP1SetDisabled() {
        mBtn1P1.setEnabled(false);
        mBtn2P1.setEnabled(false);
        mBtn3P1.setEnabled(false);
        mBtn4P1.setEnabled(false);
        mBtn5P1.setEnabled(false);
    }

    public void BtnsP2SetDisabled() {
        mBtn1P2.setEnabled(false);
        mBtn2P2.setEnabled(false);
        mBtn3P2.setEnabled(false);
        mBtn4P2.setEnabled(false);
        mBtn5P2.setEnabled(false);
    }

    public void CheckForWinner() {
        if (points == 37) {
            Log.d("String cfw", mP1Points.getText().toString());
            if (mP1Points.getText().toString().equals("37")) {
                reverseColors(1);
            } else {
                reverseColors(2);
            }
            WinerScreen();
        } else if (points > 37) {
            if (Integer.parseInt(mP1Points.getText().toString()) > 37) {
                reverseColors(2);
            } else {
                reverseColors(1);
            }
            WinerScreen();
        }

    }

    public void WinerScreen() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(DudeliGameActivity.this);
        builder.setMessage(R.string.win_message);
        builder.setTitle(R.string.game_over);
        builder.setNegativeButton(R.string.okay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(DudeliGameActivity.this, DudeliMenuActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog endGame = builder.create();
        endGame.show();
    }

    public void SinglePlayer() {
        boolean canDoGoodMove = false;
        int lockedBtn = Integer.parseInt(mP1Points.getText().toString()) - Integer.parseInt(mP2Points.getText().toString());
        int btnToPress = 37 - points;
        if (points + 5 >= 37) {
            if (btnToPress != lockedBtn) {
                canDoGoodMove = true;
                FindBtnToPress(btnToPress);
            }
        }
        if (!canDoGoodMove) {
            while (true) {
                btnToPress = rand.nextInt(5) + 1;
                if (btnToPress != lockedBtn) {
                    FindBtnToPress(btnToPress);
                    break;
                }
            }
        }
    }

    public void FindBtnToPress(int btn) {
        switch (btn) {
            case 1:
                OnP2Btn1Clicked();
                break;
            case 2:
                OnP2Btn2Clicked();
                break;
            case 3:
                OnP2Btn3Clicked();
                break;
            case 4:
                OnP2Btn4Clicked();
                break;
            case 5:
                OnP2Btn5Clicked();
                break;
        }
    }

    private void reverseColors(int choice) {
        if (choice == 1) {
            mRelativeLayout1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mBtn1P1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mBtn2P1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mBtn3P1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mBtn4P1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mBtn5P1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            mBtn1P1.setTextColor(getResources().getColor(R.color.white));
            mBtn2P1.setTextColor(getResources().getColor(R.color.white));
            mBtn3P1.setTextColor(getResources().getColor(R.color.white));
            mBtn4P1.setTextColor(getResources().getColor(R.color.white));
            mBtn5P1.setTextColor(getResources().getColor(R.color.white));

            mP1Points.setTextColor(getResources().getColor(R.color.white));

            mRelativeLayout2.setBackgroundColor(getResources().getColor(R.color.white));
            mBtn1P2.setBackgroundColor(getResources().getColor(R.color.white));
            mBtn2P2.setBackgroundColor(getResources().getColor(R.color.white));
            mBtn3P2.setBackgroundColor(getResources().getColor(R.color.white));
            mBtn4P2.setBackgroundColor(getResources().getColor(R.color.white));
            mBtn5P2.setBackgroundColor(getResources().getColor(R.color.white));

            mBtn1P2.setTextColor(getResources().getColor(R.color.colorPrimary));
            mBtn2P2.setTextColor(getResources().getColor(R.color.colorPrimary));
            mBtn3P2.setTextColor(getResources().getColor(R.color.colorPrimary));
            mBtn4P2.setTextColor(getResources().getColor(R.color.colorPrimary));
            mBtn5P2.setTextColor(getResources().getColor(R.color.colorPrimary));

            mP2Points.setTextColor(getResources().getColor(R.color.colorPrimary));
        } else {
            mRelativeLayout2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mBtn1P2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mBtn2P2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mBtn3P2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mBtn4P2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mBtn5P2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            mBtn1P2.setTextColor(getResources().getColor(R.color.white));
            mBtn2P2.setTextColor(getResources().getColor(R.color.white));
            mBtn3P2.setTextColor(getResources().getColor(R.color.white));
            mBtn4P2.setTextColor(getResources().getColor(R.color.white));
            mBtn5P2.setTextColor(getResources().getColor(R.color.white));

            mP2Points.setTextColor(getResources().getColor(R.color.white));


            mRelativeLayout1.setBackgroundColor(getResources().getColor(R.color.white));
            mBtn1P1.setBackgroundColor(getResources().getColor(R.color.white));
            mBtn2P1.setBackgroundColor(getResources().getColor(R.color.white));
            mBtn3P1.setBackgroundColor(getResources().getColor(R.color.white));
            mBtn4P1.setBackgroundColor(getResources().getColor(R.color.white));
            mBtn5P1.setBackgroundColor(getResources().getColor(R.color.white));

            mBtn1P1.setTextColor(getResources().getColor(R.color.colorPrimary));
            mBtn2P1.setTextColor(getResources().getColor(R.color.colorPrimary));
            mBtn3P1.setTextColor(getResources().getColor(R.color.colorPrimary));
            mBtn4P1.setTextColor(getResources().getColor(R.color.colorPrimary));
            mBtn5P1.setTextColor(getResources().getColor(R.color.colorPrimary));

            mP1Points.setTextColor(getResources().getColor(R.color.colorPrimary));
        }

    }

}

