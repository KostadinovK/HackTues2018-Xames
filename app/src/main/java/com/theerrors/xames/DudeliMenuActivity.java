package com.theerrors.xames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DudeliMenuActivity extends AppCompatActivity {
    @BindView(R.id.btn_one_player_menu2)
    Button mBtnOnePlayer;
    @BindView(R.id.btn_two_players_menu2)
    Button mBtnTwoPlayers;
    @BindView(R.id.btn_back_menu2)
    ImageButton mBtnBack;
    @BindView(R.id.tv_game_info_menu2)
    TextView mGameInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dudeli_menu);
        ButterKnife.bind(DudeliMenuActivity.this);
    }

    @OnClick(R.id.btn_one_player_menu2)
    public void OnePlayerGameClicked() {
        Intent intent = new Intent(DudeliMenuActivity.this, DudeliGameActivity.class);
        intent.putExtra("PlayerAmount", 1);
        startActivity(intent);
    }

    @OnClick(R.id.btn_two_players_menu2)
    public void TwoPlayersGameClicked() {
        Intent intent = new Intent(DudeliMenuActivity.this, DudeliGameActivity.class);
        intent.putExtra("PlayerAmount", 2);
        startActivity(intent);
    }

    @OnClick(R.id.btn_back_menu2)
    public void BackButtonClicked() {
        Intent intent = new Intent(DudeliMenuActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(DudeliMenuActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bashe_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.info_option) {
            mGameInfo.setVisibility(View.VISIBLE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
