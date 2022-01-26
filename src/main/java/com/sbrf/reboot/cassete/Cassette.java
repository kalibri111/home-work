package com.sbrf.reboot.cassete;

import java.util.ArrayList;

public class Cassette <Nominal>{
    private ArrayList<Nominal> banknotesBuffer;
    public Cassette(ArrayList<Nominal> banknotes) {
        banknotesBuffer = banknotes;
    }

    public int getCountBanknotes() {
        return banknotesBuffer.size();
    }
}
