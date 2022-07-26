package br.com.wakhanpaxpamirdecksimulator.presenter;

import android.content.Context;
import android.os.Handler;

import java.util.List;

import br.com.wakhanpaxpamirdecksimulator.device.executor.AppExecutors;
import br.com.wakhanpaxpamirdecksimulator.device.repositories.LoadDeckRepositoryImpl;
import br.com.wakhanpaxpamirdecksimulator.domain.bus.DataOut;
import br.com.wakhanpaxpamirdecksimulator.domain.entities.Card;
import br.com.wakhanpaxpamirdecksimulator.domain.repositories.LoadDeckRepository;
import br.com.wakhanpaxpamirdecksimulator.domain.usecases.LoadDeckUseCase;

public class LoadDeckPresenter implements DataOut.Callback<List<Card>> {

    private LoadDeckUseCase useCase;
    private LoadDeckRepository repository;
    private Context mContext;
    private DataOut.Callback<List<Card>> callback;

    public LoadDeckPresenter(Context mContext, DataOut.Callback<List<Card>> callback) {
        this.mContext = mContext;
        this.callback = callback;
        repository = new LoadDeckRepositoryImpl(mContext);
        useCase = new LoadDeckUseCase(repository, this);
    }

    public void loadDeck(){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                useCase.loadDeck();
            }
        });
    }

    @Override
    public void onSuccess(List<Card> parameter) {
        Handler handler = new Handler(mContext.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(parameter);
            }
        };
        handler.post(runnable);
    }

    @Override
    public void onError(Throwable throwable) {
        Handler handler = new Handler(mContext.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                callback.onError(throwable);
            }
        };
        handler.post(runnable);
    }
}
