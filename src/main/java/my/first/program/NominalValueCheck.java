package my.first.program;

import my.first.program.dto.ValCurs;
import my.first.program.dto.Valute;

public class NominalValueCheck {

    // Method to check if the nominal value is 1 for a given Valute
    public boolean isNominalOne(Valute valute) {
        return valute.getNominal() == 1;
    }

    // Method to validate all Valutes in a list
    public void checkNominals(ValCurs valCurs) {
        for (Valute valute : valCurs.getValutes()) {
            if (isNominalOne(valute)) {
                System.out.println("Nominal is 1 for Valute: " + valute.getName());
            } else {
                System.out.println("Nominal is not 1 for Valute: " + valute.getName());
            }
        }
    }

}
