package br.com.wakhanpaxpamirdecksimulator.domain.entities;

import android.graphics.drawable.Drawable;

public class Card {

    private String name;
    private boolean isFront;
    private Drawable drawable;

    public Card(String name, boolean isClassic, boolean mustHave, boolean isFront, Drawable drawable,
                boolean isRailAge) {
        this.name = name;
        this.isFront = isFront;
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public boolean isFront() {
        return isFront;
    }

    public Drawable getDrawable() {
        return drawable;
    }
}
