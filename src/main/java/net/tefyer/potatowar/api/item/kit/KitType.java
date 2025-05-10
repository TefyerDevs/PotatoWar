package net.tefyer.potatowar.api.item.kit;

public enum KitType {
    BLANK(false),
    BESERKER,
    MILITARY,
    SCOUT,
    KNIGHT,
    ARMY,
    FRYER,
    MILITA;

    boolean ifTag;

    KitType() {
        this(true);
    }
    KitType(boolean ifTag){
        this.ifTag = ifTag;
    }

    public boolean isIfTag() {
        return ifTag;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase()+"_kit";
    }
}
