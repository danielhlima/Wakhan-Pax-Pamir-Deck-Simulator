package br.com.wakhanpaxpamirdecksimulator.view.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
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
    private ImageView ivBlackArrow;
    private TextView tvBottomTop;

    private MediaPlayer player;

    private LoadDeckViewModel viewModel;
    private int currentDeckIndex;
    private List<Card> cards;
    br.com.wakhanpaxpamirdecksimulator.device.entities.Card currentCard;
    br.com.wakhanpaxpamirdecksimulator.device.entities.Card nextCard;

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
        ivBlackArrow = (ImageView)view.findViewById(R.id.iv_black_arrow);
        tvBottomTop = (TextView)view.findViewById(R.id.tv_top_bottom);

        ((Button)view.findViewById(R.id.bt_pick_a_card)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivLineChosen.setVisibility(View.INVISIBLE);
                tvBottomTop.setVisibility(View.INVISIBLE);
                ivBlackArrow.setVisibility(View.INVISIBLE);
                player.start();
                pickACard();
                draw();
            }
        });

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        if(currentCard == null || cards == null){
            viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity()
                    .getApplication()).create(LoadDeckViewModel.class);
            loadDeck();
        }
    }

    @Override
    public void onSuccess(LiveData<List<Card>> parameter) {
        if(parameter != null){
            cards = parameter.getValue();
            shuffleDeck();
            pickACard();
            draw();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        Log.d("DABUEK", throwable.getMessage());
    }

    private void loadDeck(){
        viewModel.loadDeck(this);
    }

    private void shuffleDeck(){
        Collections.shuffle(cards);
        currentDeckIndex = 0;
    }

    private void pickACard() {
        player = MediaPlayer.create(getContext(), R.raw.cardflip);
        if(currentDeckIndex < cards.size()-1 && currentDeckIndex+1 < cards.size()-1){
            currentCard = (br.com.wakhanpaxpamirdecksimulator.device.entities.Card)cards.get(currentDeckIndex);
            nextCard = (br.com.wakhanpaxpamirdecksimulator.device.entities.Card)cards.get(currentDeckIndex+1);
            currentDeckIndex++;
        }else{
            shuffleDeck();
            pickACard();
        }
    }

    private void draw(){
        final Drawable drawableLoyalty = currentCard.getDrawableLoyalty();
        final Drawable drawableFigures = currentCard.getDrawableFigures();
        final Drawable drawableAction = currentCard.getDrawableAction();

        int line = nextCard.getLinesBack()[currentCard.getLineChosen()];
        switch (line){
            case 0:
                ivLineChosen.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.figl0, null));
                break;
            case 1:
                ivLineChosen.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.figl1, null));
                break;
            case 2:
                ivLineChosen.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.figl2, null));
                break;
            case 3:
                ivLineChosen.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.figl3, null));
                break;
            case 4:
                ivLineChosen.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.figl4, null));
                break;
            case 5:
                ivLineChosen.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.figl5, null));
                break;
            default:
                ivLineChosen.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.figl0, null));
                break;
        }

        if(currentCard.isTop()){
            tvBottomTop.setText(nextCard.getBottomLeft()[0]);
        }else{
            tvBottomTop.setText(nextCard.getBottomLeft()[1]);
        }

        final ImageView ivLoyalty_ = ivLoyalty;
        ivLoyalty_.setRotationY(0f);
        ivLoyalty_.animate().rotationY(90f).setListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                ivLoyalty_.setImageDrawable(drawableLoyalty);
                ivLoyalty_.setRotationY(270f);
                ivLoyalty_.animate().rotationY(360f).setListener(null);
            }
        });

        final ImageView ivFigures_ = ivFigures;
        ivFigures_.setRotationY(0f);
        ivFigures_.animate().rotationY(90f).setListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                ivFigures_.setImageDrawable(drawableFigures);
                ivFigures_.setRotationY(270f);
                ivFigures_.animate().rotationY(360f).setListener(null);
            }
        });

        final ImageView ivAction_ = ivAction;
        ivAction_.setRotationY(0f);
        ivAction_.animate().rotationY(90f).setListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                ivAction_.setImageDrawable(drawableAction);
                ivAction_.setRotationY(270f);
                ivAction_.animate().rotationY(360f).setListener(null);
                ivLineChosen.setVisibility(View.VISIBLE);
                tvBottomTop.setVisibility(View.VISIBLE);
                ivBlackArrow.setVisibility(View.VISIBLE);
            }
        });
    }
}