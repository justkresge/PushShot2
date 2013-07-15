package com.hooper.pushshot2;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends Activity {

	int ShotsMade;
	int ShotsMissed;
	int TotalShots;
	int ShotPer;
	int LongestStreak;
	int CurrentStreak;
	Button Missed;
	Button Made;

	// TextView total;
	// TextView shotsmissed;
	// TextView shotsmade;
	// TextView shotper;
	TextView allshotdata;
	TextView tvLongestStreak;
	TextView tvCurrentStreak;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		LongestStreak = 0;
		CurrentStreak = 0;
		ShotsMade = 0;
		ShotsMissed = 0;
		ShotPer = 0;
		TotalShots = (ShotsMissed + ShotsMade);
		Missed = (Button) findViewById(R.id.MissedBtn);
		Made = (Button) findViewById(R.id.MadeBtn);
		tvCurrentStreak = (TextView) findViewById(R.id.tvCurrentStreak);
		tvLongestStreak = (TextView) findViewById(R.id.tvLongestStreak);

		// shotsmissed = (TextView) findViewById(R.id.tvMissed);
		// shotsmade = (TextView) findViewById(R.id.tvMade);
		// total = (TextView) findViewById(R.id.tvTotal);
		// shotper = (TextView) findViewById(R.id.ShotPer);
		allshotdata = (TextView) findViewById(R.id.AllShotData);
		// Tell the Button Clicks

		Made.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (ShotsMade == 0) {
					MediaPlayer swishSong = MediaPlayer.create(
							GameActivity.this, R.raw.swish);
					swishSong.start();
				} else {
					MediaPlayer swishSong = MediaPlayer.create(
							GameActivity.this, R.raw.swish);
					swishSong.start();
				}

				ShotsMade++;
				TotalShots = (ShotsMissed + ShotsMade);
				ShotPer = (ShotsMade * 100 / TotalShots * 100) / 100;
				allshotdata.setText(ShotPer + "%    -   " + ShotsMade + " / "
						+ TotalShots + "   -   " + ShotsMissed
						+ " Missed Shots");
				CurrentStreak++;
				tvCurrentStreak.setText("Current Streak: " + CurrentStreak);
			}
		});

		Missed.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (CurrentStreak == LongestStreak && LongestStreak > 0) {

					MediaPlayer assSong = MediaPlayer.create(GameActivity.this,
							R.raw.iamasshole);
					assSong.start();
				}

				if (CurrentStreak > LongestStreak && CurrentStreak > 0) {
					tvLongestStreak.setText("Longest Streak: " + CurrentStreak);
					LongestStreak = CurrentStreak;

				}

				ShotsMissed++;
				TotalShots = (ShotsMissed + ShotsMade);
				ShotPer = (ShotsMade * 100 / TotalShots * 100) / 100;
				allshotdata.setText(ShotPer + "%    -   " + ShotsMade + " / "
						+ TotalShots + "   -   " + ShotsMissed
						+ " Missed Shots");
				CurrentStreak = 0;
				tvCurrentStreak.setText("Current Streak: " + CurrentStreak);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

}