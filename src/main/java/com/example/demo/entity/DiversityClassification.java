package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "diversity_classifications")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiversityClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String code;

    private String description;
    private Boolean active = true;

    @OneToMany(mappedBy = "classification")
    private List<DiversityTarget> targets;
}
