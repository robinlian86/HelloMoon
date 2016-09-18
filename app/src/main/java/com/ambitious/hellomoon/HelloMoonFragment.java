package com.ambitious.hellomoon;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class HelloMoonFragment extends Fragment {
    private Button mPlayButton;
    private Button mStopButton;
    private AudioPlayer mPlayer = new AudioPlayer();
    private boolean mIsPlayed = false;

    public HelloMoonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);

        mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mIsPlayed) {
                    mPlayer.play(getActivity());
                    mIsPlayed = true;
                } else {
                    mPlayer.pause();
                    mIsPlayed = false;
                }
            }
        });
        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
                mIsPlayed = false;
            }
        });

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
