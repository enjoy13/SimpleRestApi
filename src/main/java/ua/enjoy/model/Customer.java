package ua.enjoy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@ToString(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Column(name = "first_name")
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    private String lastName;

    @Column(name = "address")
    @NotBlank
    private String address;

    @Column(name = "budget")
    @NotNull
    private BigDecimal budget;

}
