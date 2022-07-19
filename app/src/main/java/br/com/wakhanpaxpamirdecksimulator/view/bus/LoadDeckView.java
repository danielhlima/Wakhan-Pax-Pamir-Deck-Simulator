package br.com.wakhanpaxpamirdecksimulator.view.bus;

import androidx.lifecycle.LiveData;

import java.util.List;

import br.com.wakhanpaxpamirdecksimulator.domain.bus.DataOut;
import br.com.wakhanpaxpamirdecksimulator.domain.entities.Card;


public interface LoadDeckView extends DataOut.Callback<List<Card>> {
    void loadDeck(DataOut.Callback<LiveData<List<Card>>> callback);
}
