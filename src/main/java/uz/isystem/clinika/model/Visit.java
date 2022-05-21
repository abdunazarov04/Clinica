package uz.isystem.clinika.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("visits"))
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer patient_id;

    private Integer doctor_id;

    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = ("patient_id"), insertable = false,updatable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = ("doctor_id"),insertable = false,updatable = false)
    private Doctor doctor;


    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;


}
