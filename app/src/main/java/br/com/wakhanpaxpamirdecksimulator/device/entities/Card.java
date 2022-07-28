package br.com.wakhanpaxpamirdecksimulator.device.entities;

import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import android.content.Context;
import android.content.res.Resources;

public class Card extends br.com.wakhanpaxpamirdecksimulator.domain.entities.Card {

    private Drawable drawableLoyalty;
    private Drawable drawableFigures;
    private Drawable drawableAction;

    private Context mContext;

    public Card(Context context, String name, String loyalty, String figures, String action, int lineChosen, int[] linesBack, boolean isTop, String[] bottomLeft) {
        super(name, loyalty, figures, action, lineChosen, linesBack, isTop, bottomLeft);
        this.mContext = context;

        Resources res = mContext.getResources();

        String drawableLoyaltyName = getLoyalty();
        int resIDLoyalty = res.getIdentifier(drawableLoyaltyName , "drawable", mContext.getPackageName());
        drawableLoyalty = ResourcesCompat.getDrawable(res, resIDLoyalty, null);

        String drawableFiguresName = getFigures();
        int resIDFigures = res.getIdentifier(drawableFiguresName , "drawable", mContext.getPackageName());
        drawableFigures = ResourcesCompat.getDrawable(res, resIDFigures, null);

        String drawableActionName = getAction();
        int resIDAction = res.getIdentifier(drawableActionName , "drawable", mContext.getPackageName());
        drawableAction = ResourcesCompat.getDrawable(res, resIDAction, null);
    }


    public Drawable getDrawableLoyalty() {
        return drawableLoyalty;
    }

    public void setDrawableLoyalty(Drawable drawableLoyalty) {
        this.drawableLoyalty = drawableLoyalty;
    }

    public Drawable getDrawableFigures() {
        return drawableFigures;
    }

    public void setDrawableFigures(Drawable drawableFigures) {
        this.drawableFigures = drawableFigures;
    }

    public Drawable getDrawableAction() {
        return drawableAction;
    }

    public void setDrawableAction(Drawable drawableAction) {
        this.drawableAction = drawableAction;
    }
}