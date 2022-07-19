package br.com.wakhanpaxpamirdecksimulator.domain.repositories;

import br.com.wakhanpaxpamirdecksimulator.domain.bus.DataOut;

public interface LoadDeckRepository {

    void loadDeckCards(DataOut.Callback callback);
}
