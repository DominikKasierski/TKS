package pl.ks.dk.tks.dtomodel.babysitters;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.ks.dk.tks.dtomodel.interfaces.EntityToSignDTO;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class BabysitterDTO implements Cloneable, EntityToSignDTO {

    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    @NotNull
    @Size(min = 2, max = 20)
    private String surname;

    @NotNull
    @DecimalMin("0.00")
    @DecimalMax("1000.00")
    private Double basePriceForHour;

    @NotNull
    @Min(0)
    @Max(15)
    private Integer minChildAge;

    @NotNull
    @Min(0)
    @Max(15)
    private Integer maxNumberOfChildrenInTheFamily;

    @AssertFalse
    private boolean employed;

    private String uuid;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public BabysitterDTO(String name, String surname, Double basePriceForHour, Integer minChildAge,
                         int maxNumberOfChildrenInTheFamily) {
        this.name = name;
        this.surname = surname;
        this.basePriceForHour = basePriceForHour;
        this.minChildAge = minChildAge;
        this.maxNumberOfChildrenInTheFamily = maxNumberOfChildrenInTheFamily;
    }

    @Override
    public String toString() {
        return "name: " + name +
                "\nsurname: " + surname +
                "\nbasePrice: " + basePriceForHour +
                "\nminChildAge: " + minChildAge +
                "\nmaxNumberOfChildrenInTheFamily: " + minChildAge;
    }

    @Override
    public Map<String, String> takePayload() {
        Map<String, String> map = new HashMap<>();
        map.put("uuid", getUuid());
        map.put("employed", String.valueOf(isEmployed()));
        return map;
    }
}
