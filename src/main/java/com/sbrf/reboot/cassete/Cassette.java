package com.sbrf.reboot.cassete;

import com.sbrf.reboot.banknote.Banknote;

import java.util.ArrayList;

public class Cassette <T extends Banknote>{
    private ArrayList<T> banknotesBuffer;
    public Cassette(ArrayList<T> banknotes) {
        banknotesBuffer = banknotes;
    }

    public int getCountBanknotes() {
        return banknotesBuffer.size();
    }
}
