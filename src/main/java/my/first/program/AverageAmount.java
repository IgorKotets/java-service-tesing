package my.first.program;

import my.first.program.dto.ValCurs;
import my.first.program.dto.Valute;

public class AverageAmount {

    public static Double calculateAverage(ValCurs valCurs) {

        Double value = 0.0;

        for(int i = 0; i < valCurs.getValutes().size(); i++) {

            value += valCurs.getValutes().get(i).getValue();

        }

        System.out.println();

        return value/valCurs.getValutes().size();

    }

}
