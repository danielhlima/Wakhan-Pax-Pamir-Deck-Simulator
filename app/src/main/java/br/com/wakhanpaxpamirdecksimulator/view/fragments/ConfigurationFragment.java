package br.com.wakhanpaxpamirdecksimulator.view.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import br.com.wakhanpaxpamirdecksimulator.R;


public class ConfigurationFragment extends Fragment {

    public static boolean isSoundEnabled = true;
    private MediaPlayer player;

    public ConfigurationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_configuration, container, false);
        player = MediaPlayer.create(getContext(), R.raw.cardflip);

        ToggleButton toggle = (ToggleButton) view.findViewById(R.id.tg_button);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    player.start();
                    ConfigurationFragment.isSoundEnabled = true;
                } else {
                    ConfigurationFragment.isSoundEnabled = false;
                }
            }
        });

        return view;
    }
}