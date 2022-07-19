package br.com.wakhanpaxpamirdecksimulator.domain.usecases;

import java.util.List;

import br.com.wakhanpaxpamirdecksimulator.domain.bus.DataOut;
import br.com.wakhanpaxpamirdecksimulator.domain.entities.Card;
import br.com.wakhanpaxpamirdecksimulator.domain.repositories.LoadDeckRepository;


public class LoadDeckUseCase implements DataOut.Callback<List<Card>> {

    private LoadDeckRepository repository;
    private DataOut.Callback callback;

    public LoadDeckUseCase(LoadDeckRepository repository, DataOut.Callback callback) {
        this.repository = repository;
        this.callback = callback;
    }

public void loadDeck(){
    if(repository != null){
        repository.loadDeckCards(this);
    }
}

    @Override
    public void onSuccess(List<Card> parameter) {
        callback.onSuccess(parameter);
    }

    @Override
    public void onError(Throwable throwable) {
        callback.onError(throwable);
    }
}
