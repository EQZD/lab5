package crm.lab5.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList; // <-- Импорт
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Operators {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String department;

    @ManyToMany(mappedBy = "operators")
    private List<ApplicationRequest> requests = new ArrayList<>();
}