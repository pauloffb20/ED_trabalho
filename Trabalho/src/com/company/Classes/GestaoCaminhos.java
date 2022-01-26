package com.company.Classes;

import com.company.Classes.Models.Local;
import com.company.Estruturas.Network;

public class GestaoCaminhos {

    Network<Local> localNetwork;
    double[][] paths;

    public GestaoCaminhos(Network<Local> locais){
        this.localNetwork = locais;
        this.paths = localNetwork.getPaths();
    }

    public void printPaths() {
    }


}
