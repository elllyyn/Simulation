package modele;

import utils.FonctionsUtiles;

public class Bus {
    public boolean possedeDefaut;

    public Bus() {
        possedeDefaut = FonctionsUtiles.doitReparer();
    }
}
