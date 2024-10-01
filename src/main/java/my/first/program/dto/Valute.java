package my.first.program.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Valute")
public class Valute {

    @XStreamAlias("ID")
    @XStreamAsAttribute
    private Integer id;

    @XStreamAlias("NumCode")
    private String NumCode;

    @XStreamAlias("CharCode")
    private String CharCode;

    @XStreamAlias("Nominal")
    private Integer Nominal;

    @XStreamAlias("Name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XStreamAlias("Value")
    private Double Value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumCode() {
        return NumCode;
    }

    public void setNumCode(String numCode) {
        NumCode = numCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public void setCharCode(String charCode) {
        CharCode = charCode;
    }

    public Integer getNominal() {
        return Nominal;
    }

    public void setNominal(Integer nominal) {
        Nominal = nominal;
    }

    public Double getValue() {
        return Value;
    }

    public void setValue(Double value) {
        Value = value;
    }
}
