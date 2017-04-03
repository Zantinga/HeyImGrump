package janzantinga.com.heyimgrump;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    private AdView mAdView;
    static MediaPlayer grump;
    static MediaPlayer notSoGrump;
    static MediaPlayer gameGrumps;

    ImageButton arin;
    ImageButton dan;

    Boolean arinPressed;
    Boolean danPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        grump = MediaPlayer.create(MainActivity.this, R.raw.grump);
        notSoGrump = MediaPlayer.create(MainActivity.this, R.raw.not_so_grump);
        gameGrumps = MediaPlayer.create(MainActivity.this, R.raw.the_game_grumps);
        arinPressed = false;
        danPressed = false;

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        arin = (ImageButton) findViewById(R.id.imageButton1);
        dan = (ImageButton) findViewById(R.id.imageButton2);

        arin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(arinPressed && danPressed) {
                    gameGrumps.start();
                    resetHeads();
                } else {
                    arinPressed = true;
                    grump.start();
                }
            }
        });

        dan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(arinPressed && danPressed) {
                    gameGrumps.start();
                    resetHeads();
                } else {
                    danPressed = true;
                    notSoGrump.start();
                }
            }
        });

    }

    private void resetHeads() {
        arinPressed = false;
        danPressed = false;
    }

}
