package com.ambitious.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by lianhuibin on 2016/8/7.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;

    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c) {
        if (mPlayer == null) {
            mPlayer = MediaPlayer.create(c, R.raw.test);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stop();
                }
            });
        }
        mPlayer.start();
    }

    public void pause() {
        if (mPlayer != null) {
            mPlayer.pause();
        }
    }
}