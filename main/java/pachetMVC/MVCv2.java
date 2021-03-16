package pachetMVC;

import pachetController.Controllerv2;
import pachetModel.Polinom;
import pachetView.View;

import java.util.ArrayList;

public class MVCv2 {
    public static void main(String[] args) {
        Polinom p = new Polinom(new ArrayList<>());
        View v = new View();
        Controllerv2 c = new Controllerv2(v);
    }
}
