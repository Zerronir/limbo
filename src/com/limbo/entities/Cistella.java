package com.limbo.entities;

import java.util.ArrayList;
import java.util.List;

public class Cistella {
    List<LineaCistella> linies = new ArrayList<>();

    public List<LineaCistella> getLinies() {
        return linies;
    }

    public void setLinies(List<LineaCistella> linies) {
        this.linies = linies;
    }
}
