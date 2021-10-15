package hojoon.web_AWS_study.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.type.BasicTypeRegistry;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BasicTypeRegistry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    private Role role;
}
