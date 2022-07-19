package br.com.wakhanpaxpamirdecksimulator.device.repositories;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.List;

import br.com.wakhanpaxpamirdecksimulator.domain.bus.DataOut;
import br.com.wakhanpaxpamirdecksimulator.domain.repositories.LoadDeckRepository;
import br.com.wakhanpaxpamirdecksimulator.domain.entities.Card;


public class LoadDeckRepositoryImpl implements LoadDeckRepository {

    private Context mContext;

    public LoadDeckRepositoryImpl(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void loadDeckCards(DataOut.Callback callback) {
        try{
            Resources res = mContext.getResources();

//            Drawable a21b = ResourcesCompat.getDrawable(res, R.drawable.a21b, null);
//            Drawable a21f = ResourcesCompat.getDrawable(res, R.drawable.a21f, null);

            List<Card> cards = new ArrayList<Card>();
//            cards.add(new Card("a21", false, true, false, a21b, true));

            callback.onSuccess(cards);
        }catch (Exception e){
            callback.onError(e);
        }
    }
}
