package br.com.wakhanpaxpamirdecksimulator.device.entities;

import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import android.content.Context;
import android.content.res.Resources;

public class Card extends br.com.wakhanpaxpamirdecksimulator.domain.entities.Card {

    private Drawable drawableLoyalty;
    private Drawable drawableFigures;
    private Drawable drawableLineButton;
    private Drawable drawableAction;

    private Context mContext;

    public Card(Context context, String name, String loyalty, String figures, String action, int lineChosen, int[] linesBack, boolean isTop) {
        super(name, loyalty, figures, action, lineChosen, linesBack, isTop);
        this.mContext = context;

        Resources res = mContext.getResources();

        String drawableLoyaltyName = getLoyalty();
        int resIDLoyalty = res.getIdentifier(drawableLoyaltyName , "drawable", mContext.getPackageName());
        drawableLoyalty = ResourcesCompat.getDrawable(res, resIDLoyalty, null);

        String drawableFiguresName = getLoyalty();
        int resIDFigures = res.getIdentifier(drawableFiguresName , "drawable", mContext.getPackageName());
        drawableLoyalty = ResourcesCompat.getDrawable(res, resIDFigures, null);

        String drawableLineButtonName = getLoyalty();
        int resIDLineButton = res.getIdentifier(drawableLineButtonName , "drawable", mContext.getPackageName());
        drawableLoyalty = ResourcesCompat.getDrawable(res, resIDLineButton, null);

        String drawableActionName = getLoyalty();
        int resIDAction = res.getIdentifier(drawableActionName , "drawable", mContext.getPackageName());
        drawableLoyalty = ResourcesCompat.getDrawable(res, resIDAction, null);
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

    public Drawable getDrawableLineButton() {
        return drawableLineButton;
    }

    public void setDrawableLineButton(Drawable drawableLineButton) {
        this.drawableLineButton = drawableLineButton;
    }

    public Drawable getDrawableAction() {
        return drawableAction;
    }

    public void setDrawableAction(Drawable drawableAction) {
        this.drawableAction = drawableAction;
    }
}