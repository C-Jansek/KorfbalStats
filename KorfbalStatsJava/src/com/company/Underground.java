package com.company;

public class Underground {
    private boolean isGrass;
    private boolean isArtificialGrass;

    public Underground (boolean undergroundIsGrass) {
        if (undergroundIsGrass) {
            isGrass = true;
            isArtificialGrass = false;
        } else {
            isGrass = false;
            isArtificialGrass = true;
        }
    }

    public boolean isGrass () {
        return isGrass;
    }
    public boolean isArtificialGrass () {
        return isArtificialGrass;
    }

}
