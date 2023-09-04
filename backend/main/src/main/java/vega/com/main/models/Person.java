package vega.com.main.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import vega.com.main.common.RoleTag;
import vega.com.main.models.common.AbstractEntity;
import vega.com.main.models.common.IPersonValidation;

import java.util.List;

@Entity
@Table(name = "person")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person extends AbstractEntity implements IPersonValidation {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "username")
    @NotBlank(message = "username should be not blank")
    @Size(min = 4, max = 254, message = "username size should be between 4 and 254")
    //UNIQUE
    private String username;

    @Column(name = "password")
    @NotBlank(message = "password should be not blank")
    @Size(min = 4, max = 254, message = "password size should be between 4 and 254")
    private String password;


    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private RoleTag role;

    @OneToOne(mappedBy = "owner", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Details info;

    @OneToMany(mappedBy = "owner",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<Article>articles;
}
