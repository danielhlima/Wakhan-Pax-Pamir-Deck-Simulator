package br.com.wakhanpaxpamirdecksimulator.device.repositories;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

import br.com.wakhanpaxpamirdecksimulator.domain.bus.DataOut;
import br.com.wakhanpaxpamirdecksimulator.domain.repositories.LoadDeckRepository;
import br.com.wakhanpaxpamirdecksimulator.domain.entities.Card;


public class LoadDeckRepositoryImpl implements LoadDeckRepository {

    public LoadDeckRepositoryImpl() {
    }

    @Override
    public void loadDeckCards(DataOut.Callback callback) {
        try{

            List<Card> cards = new ArrayList<Card>();
            cards.add(new Card("c1", "loyalty_ru_af_br", "figc1", "actionc1", 2, new int[]{3,4,5,0,1,2}, false));
            cards.add(new Card("c2", "loyalty_af_br_ru", "figc2", "actionc2", 1, new int[]{4,5,0,1,2,3}, true));
            cards.add(new Card("c3", "loyalty_br_ru_af", "figc3", "actionc3", 3, new int[]{2,3,4,5,1,1}, false));
            cards.add(new Card("c4", "loyalty_ru_af_br", "figc4", "actionc4", 4, new int[]{1,2,3,4,5,0}, true));
            cards.add(new Card("c5", "loyalty_br_af_ru", "figc5", "actionc5", 1, new int[]{4,5,0,1,2,3}, true));
            cards.add(new Card("c6", "loyalty_br_ru_af", "figc6", "actionc6", 0, new int[]{5,0,1,2,3,4}, true));
            cards.add(new Card("c7", "loyalty_af_ru_br", "figc7", "actionc7", 4, new int[]{0,1,2,3,4,5}, false));
            cards.add(new Card("c8", "loyalty_br_ru_af", "figc8", "actionc8", 4, new int[]{1,2,3,4,5,0}, false));
            cards.add(new Card("c9", "loyalty_ru_br_af", "figc9", "actionc9", 5, new int[]{1,2,3,4,5,0}, false));
            cards.add(new Card("c10", "loyalty_af_br_ru", "figc10", "actionc10", 0, new int[]{5,0,1,2,3,4}, false));
            cards.add(new Card("c11", "loyalty_af_ru_br", "figc11", "actionc11", 0, new int[]{5,0,1,2,3,4}, false));
            cards.add(new Card("c12", "loyalty_br_af_ru", "figc12", "actionc12", 4, new int[]{1,2,3,4,5,0}, false));
            cards.add(new Card("c13", "loyalty_af_br_ru", "figc13", "actionc13", 2, new int[]{3,4,5,0,1,2}, true));
            cards.add(new Card("c14", "loyalty_af_ru_br", "figc14", "actionc14", 0, new int[]{2,3,4,5,0,1}, true));
            cards.add(new Card("c15", "loyalty_ru_br_af", "figc15", "actionc15", 2, new int[]{3,4,5,0,1,2}, false));
            cards.add(new Card("c16", "loyalty_af_ru_br", "figc16", "actionc16", 5, new int[]{2,3,4,5,0,1}, true));
            cards.add(new Card("c17", "loyalty_ru_br_af", "figc17", "actionc17", 0, new int[]{5,0,1,2,3,4}, true));
            cards.add(new Card("c18", "loyalty_ru_br_af", "figc18", "actionc18", 3, new int[]{0,1,2,3,4,5}, true));
            cards.add(new Card("c19", "loyalty_ru_af_br", "figc19", "actionc19", 2, new int[]{3,4,5,0,1,2}, true));
            cards.add(new Card("c20", "loyalty_ru_af_br", "figc20", "actionc20", 1, new int[]{2,3,4,5,0,1}, false));
            cards.add(new Card("c21", "loyalty_br_af_ru", "figc21", "actionc21", 5, new int[]{0,1,2,3,4,5}, true));
            cards.add(new Card("c22", "loyalty_br_af_ru", "figc22", "actionc22", 5, new int[]{0,1,2,3,4,5}, false));
            cards.add(new Card("c23", "loyalty_br_ru_af", "figc23", "actionc23", 3, new int[]{2,3,4,5,0,1}, false));
            cards.add(new Card("c24", "loyalty_af_br_ru", "figc24", "actionc24", 1, new int[]{4,5,0,1,2,3}, false));

            callback.onSuccess(cards);
        }catch (Exception e){
            callback.onError(e);
        }
    }
}
