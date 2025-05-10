package net.tefyer.potatowar.api.item.kit;

public enum KitType {
    BLANK,
    BESERKER,
    MILITARY,
    SCOUT,
    KNIGHT,
    ARMY,
    FRYER,
    MILITA;


    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
