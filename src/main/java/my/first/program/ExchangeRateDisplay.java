package my.first.program;

import my.first.program.dto.ValCurs;
import my.first.program.dto.Valute;

import java.util.Optional;

public class ExchangeRateDisplay {

    public static void displayExchangeRate(ValCurs valCurs, String currency) {
     //   Optional<Double> first = valCurs.getValutes().stream().filter(x -> x.getCharCode().equalsIgnoreCase(currency)).map(x->x.getValue()).findFirst();


        Double value = 0.0;

        for (Valute valute : valCurs.getValutes()) {
            if (valute.getCharCode().equalsIgnoreCase(currency)) {
                value = valute.getValue();
                System.out.println(currency+ " = "+value);
                break;
            } else {
                System.out.println("No such currency");
                break;
            }
        }

    }

}
