package br.com.wakhanpaxpamirdecksimulator.domain.entities;

public class Card {

    private String name;
    private String loyalty;
    private String figures;
    private String action;
    private int lineChosen;
    private int[] linesBack;
    private boolean isTop;
    private String[] bottomLeft;

    public Card(String name, String loyalty, String figures, String action, int lineChosen, int[] linesBack, boolean isTop, String[] bottomLeft) {
        this.name = name;
        this.loyalty = loyalty;
        this.figures = figures;
        this.action = action;
        this.lineChosen = lineChosen;
        this.linesBack = linesBack;
        this.isTop = isTop;
        this.bottomLeft = bottomLeft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty;
    }

    public String getFigures() {
        return figures;
    }

    public void setFigures(String figures) {
        this.figures = figures;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getLineChosen() {
        return lineChosen;
    }

    public void setLineChosen(int lineChosen) {
        this.lineChosen = lineChosen;
    }

    public int[] getLinesBack() {
        return linesBack;
    }

    public void setLinesBack(int[] linesBack) {
        this.linesBack = linesBack;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public String[] getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(String[] bottomLeft) {
        this.bottomLeft = bottomLeft;
    }
}
