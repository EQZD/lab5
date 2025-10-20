package crm.lab5.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String commentary;
    private String phone;
    private boolean handled;

    @ManyToOne
    private Courses course;

    @ManyToMany
    @JoinTable(
            name = "request_operator",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "operator_id")
    )
    private List<Operators> operators;
}
