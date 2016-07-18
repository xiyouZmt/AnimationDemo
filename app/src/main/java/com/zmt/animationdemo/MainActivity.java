package com.zmt.animationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolBar) Toolbar toolbar;
    @BindView(R.id.scale) Button scale;
    @BindView(R.id.Alpha) Button alpha;
    @BindView(R.id.Rotate) Button rotate;
    @BindView(R.id.translate) Button translate;
    @BindView(R.id.one) Button one;
    @BindView(R.id.two) Button two;
    @BindView(R.id.three) Button three;
    @BindView(R.id.four) Button four;
    @BindView(R.id.change) Button change;
    @BindView(R.id.layout) Button layout;
    @BindView(R.id.image) ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    @OnClick({R.id.scale, R.id.Alpha, R.id.Rotate, R.id.translate, R.id.one,
    R.id.two, R.id.three, R.id.four, R.id.change, R.id.layout})
    public void onClick(View v){
        Animation animation;
        switch (v.getId()){
            case R.id.scale :
                animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                image.startAnimation(animation);
                break;
            case R.id.Alpha :
                animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                image.startAnimation(animation);
                break;
            case R.id.Rotate :
                animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                image.startAnimation(animation);
                break;
            case R.id.translate :
                animation = AnimationUtils.loadAnimation(this, R.anim.translate);
                image.startAnimation(animation);
                break;
            case R.id.one :
                animation = AnimationUtils.loadAnimation(this, R.anim.translate);
                image.startAnimation(animation);
                final Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.rotate);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        image.startAnimation(animation1);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                break;
            case R.id.two :
                animation = AnimationUtils.loadAnimation(this, R.anim.continue_alpha);
                image.startAnimation(animation);
                break;
            case R.id.three :
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(100);
                alphaAnimation.setRepeatCount(10);
                //倒序重复REVERSE  正序重复RESTART
                alphaAnimation.setRepeatMode(Animation.REVERSE);
                image.startAnimation(alphaAnimation);
                break;
            case R.id.four :
                TranslateAnimation translateAnimation = new TranslateAnimation(-50, 50, 0, 0);
                translateAnimation.setDuration(1000);
                translateAnimation.setRepeatCount(Animation.INFINITE);
                translateAnimation.setRepeatMode(Animation.REVERSE);
                image.startAnimation(translateAnimation);
                break;
            case R.id.change :
                Intent intent = new Intent(MainActivity.this, Test.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
                break;
            case R.id.layout :
                intent = new Intent(MainActivity.this, ListAnimation.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
