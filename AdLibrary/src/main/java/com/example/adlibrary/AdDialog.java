package com.example.adlibrary;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

public class AdDialog {

    public static void showDialog(final Context context, final Intent nextIntent, int CountDownInSeconds, int imageResId, AdAnimation adAnimation, final String url){
        final Dialog adDialog = new Dialog(context);
        adDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        adDialog.setContentView(R.layout.dialog_ad);
        adDialog.setCancelable(false);

        final ShapeableImageView DialogAd_SIV_cancel = adDialog.findViewById(R.id.DialogAd_SIV_cancel);
        final MaterialTextView DialogAd_MTV_timer = adDialog.findViewById(R.id.DialogAd_MTV_timer);
        final ShapeableImageView DialogAd_SIV_Ad = adDialog.findViewById(R.id.DialogAd_SIV_Ad);

        DialogAd_SIV_Ad.setImageResource(imageResId);

        DialogAd_SIV_Ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(url!=null && !url.isEmpty()){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    context.startActivity(browserIntent);
                }
            }
        });

        new CountDownTimer((long) CountDownInSeconds * 1000L, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                DialogAd_MTV_timer.setText(String.valueOf(millisUntilFinished/1000));
                int progress = ((int)((millisUntilFinished*100) / (CountDownInSeconds*1000L)));
            }

            @Override
            public void onFinish() {
                DialogAd_SIV_cancel.setVisibility(View.VISIBLE);
                DialogAd_MTV_timer.setText("");
            }
        }.start();

        DialogAd_SIV_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adDialog.dismiss();
                context.startActivity(nextIntent);
            }
        });

        int animationResId = getAnimation(adAnimation);
        Animation animation = AnimationUtils.loadAnimation(context,animationResId);
        adDialog.findViewById(android.R.id.content).startAnimation(animation);

        adDialog.show();
    }

    private static int getAnimation(AdAnimation adAnimation){
        switch (adAnimation){
            case ENTER_FROM_LEFT:
                return R.anim.enter_from_left;
            case ENTER_FROM_BELOW:
                return R.anim.enter_from_below;
            case ENTER_FROM_ABOVE:
                return R.anim.enter_from_above;
            case ENTER_FROM_RIGHT:
                return R.anim.enter_from_right;
            case RESIZE_TO_FULL:
                return R.anim.resize_to_full;
            default:
                throw new IllegalArgumentException("Unknown animation type: " + adAnimation);
        }
    }
}