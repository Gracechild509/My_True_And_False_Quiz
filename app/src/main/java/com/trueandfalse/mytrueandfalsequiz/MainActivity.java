package com.trueandfalse.mytrueandfalsequiz;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    TextView tv_question;
    Button b_true, b_false;

    Questions mQuestions;
    int questionsLength;

    ArrayList<Item> questionsList;

    int currentQuestion = 0;
    boolean winner = false;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });

//                         THIS IS NOT THAT IMPORTANT,
        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
            @Override
            public void onAdClicked() {
                // Called when a click is recorded for an ad.
                Log.d(TAG, "Ad was clicked.");
            }

            @Override
            public void onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
                Log.d(TAG, "Ad dismissed fullscreen content.");
                mInterstitialAd = null;
            }

            @Override
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                // Called when ad fails to show.
                Log.e(TAG, "Ad failed to show fullscreen content.");
                mInterstitialAd = null;
            }

            @Override
            public void onAdImpression() {
                // Called when an impression is recorded for an ad.
                Log.d(TAG, "Ad recorded an impression.");
            }

            @Override
            public void onAdShowedFullScreenContent() {
                // Called when ad is shown.
                Log.d(TAG, "Ad showed fullscreen content.");
            }
        });




        tv_question = (TextView) findViewById(R.id.tv_question);
        b_true = (Button)  findViewById(R.id.b_true);


        b_false = (Button) findViewById(R.id.b_false);

        mQuestions = new Questions();
        questionsLength = mQuestions.mQuestions.length;

        questionsList = new ArrayList<>();

        for (int i = 0; i < questionsLength; i++){
            questionsList.add(new Item(mQuestions.getQuestion(i), mQuestions.getAnswer(i)));

        }

        Collections.shuffle(questionsList);

        setQuestion(currentQuestion);


        b_true.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (checkQuestion(currentQuestion)){
                    currentQuestion++;
                    if (currentQuestion < questionsLength){
                        setQuestion(currentQuestion);
                    }else {
                        winner = true;
                        endGame();
                        if (mInterstitialAd != null) {
                            mInterstitialAd.show(MainActivity.this);
                        } else {
                            Log.d("TAG", "The interstitial ad wasn't ready yet.");
                        }
                    }
                }else {
                    endGame();
                }

            }
        });

        b_false.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                if (!checkQuestion(currentQuestion)){
                    currentQuestion++;
                    if (currentQuestion < questionsLength){
                        setQuestion(currentQuestion);
                    }else {
                        winner = true;
                        endGame();
                        if (mInterstitialAd != null) {
                            mInterstitialAd.show(MainActivity.this);
                        } else {
                            Log.d("TAG", "The interstitial ad wasn't ready yet.");
                        }
                    }
                    }else {
                        endGame();
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(MainActivity.this);
                    } else {
                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                    }
                    }
                }

        });

    }

    private  void  setQuestion (int number){
        tv_question.setText(questionsList.get(number).getQuestion());
    }

    private boolean checkQuestion(int number){
        String answer = questionsList.get(number).getAnswer();
        return answer.equals("true");

    }

    private  void endGame(){
        if (winner){
            Toast.makeText(this, "Game Over! You win!", Toast.LENGTH_SHORT).show();
            finish();
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
        }else  {
            Toast.makeText(this, " Game over! You loose!", Toast.LENGTH_SHORT).show();
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
        }
    }
}