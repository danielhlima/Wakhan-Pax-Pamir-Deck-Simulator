package br.com.wakhanpaxpamirdecksimulator.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramotion.circlemenu.CircleMenuView;

import br.com.wakhanpaxpamirdecksimulator.R;


public class LandingFragment extends Fragment {

    private int optionMenuChosen = -1;

    public LandingFragment() {
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
        View view = inflater.inflate(R.layout.fragment_landing, container, false);

        final CircleMenuView menu = (CircleMenuView)view.findViewById(R.id.circle_menu);
        menu.setEventListener(new CircleMenuView.EventListener() {
            @Override
            public void onMenuOpenAnimationStart(@NonNull CircleMenuView view) {
                Log.d("DABUEK", "onMenuOpenAnimationStart");
            }

            @Override
            public void onMenuOpenAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("DABUEK", "onMenuOpenAnimationEnd");
            }

            @Override
            public void onMenuCloseAnimationStart(@NonNull CircleMenuView view) {
                Log.d("DABUEK", "onMenuCloseAnimationStart");
            }

            @Override
            public void onMenuCloseAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("DABUEK", "onMenuCloseAnimationEnd");
            }

            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int index) {
                Log.d("DABUEK", "onButtonClickAnimationStart| index: " + index);
                optionMenuChosen = index;
            }

            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuView view, int index) {
                Log.d("DABUEK", "onButtonClickAnimationEnd| index: " + index);
                switch (index){

                    case 0:
                        NavDirections navDirectionsGm = LandingFragmentDirections.actionLandingFragmentToGameFragment();
                        Navigation.findNavController(getActivity(), R.id.nav_host).navigate(navDirectionsGm);
                        break;

                    case 1:
                        NavDirections navDirectionsCr = LandingFragmentDirections.actionLandingFragmentToCreditsFragment();
                        Navigation.findNavController(getActivity(), R.id.nav_host).navigate(navDirectionsCr);
                        break;

                    case 2:
                        NavDirections navDirectionsCf = LandingFragmentDirections.actionLandingFragmentToConfigurationFragment();
                        Navigation.findNavController(getActivity(), R.id.nav_host).navigate(navDirectionsCf);
                        break;
                }
            }
        });

        return view;
    }
}