package br.com.wakhanpaxpamirdecksimulator.view.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.wakhanpaxpamirdecksimulator.R;
import br.com.wakhanpaxpamirdecksimulator.domain.bus.DataOut;
import br.com.wakhanpaxpamirdecksimulator.domain.entities.Card;
import br.com.wakhanpaxpamirdecksimulator.view.viewmodel.LoadDeckViewModel;

public class GameFragment extends Fragment implements DataOut.Callback<LiveData<List<Card>>> {

    private ImageView ivLoyalty;
    private ImageView ivFigures;
    private ImageView ivLineChosen;
    private ImageView ivAction;
    private TextView tvBottomTop;

    private LoadDeckViewModel viewModel;
    private int currentDeckIndex;
    private List<Card> cards;

    public GameFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentDeckIndex = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game, container, false);

        ivLoyalty = (ImageView)view.findViewById(R.id.iv_loyalty);
        ivFigures = (ImageView)view.findViewById(R.id.iv_figures);
        ivLineChosen = (ImageView)view.findViewById(R.id.iv_line_number);
        ivAction = (ImageView)view.findViewById(R.id.iv_card_action);

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity()
                .getApplication()).create(LoadDeckViewModel.class);
        loadDeck();
    }

    @Override
    public void onSuccess(LiveData<List<Card>> parameter) {
        if(parameter != null){
            cards = parameter.getValue();
            br.com.wakhanpaxpamirdecksimulator.device.entities.Card c1 = (br.com.wakhanpaxpamirdecksimulator.device.entities.Card) cards.get(1);

            final Drawable drawableLoyalty = c1.getDrawableLoyalty();
            final Drawable drawableFigures = c1.getDrawableFigures();
            final Drawable drawableLineChosen = c1.getDrawableLineButton();
            final Drawable drawableAction = c1.getDrawableAction();

            ivLoyalty.setImageDrawable(drawableLoyalty);
            ivFigures.setImageDrawable(drawableFigures);
            ivLineChosen.setImageDrawable(drawableLineChosen);
            ivAction.setImageDrawable(drawableAction);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        Log.d("DABUEK", throwable.getMessage());
    }

    private void loadDeck(){
        viewModel.loadDeck(this);
    }
}