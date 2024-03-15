package com.MobilBayiPortal.MobilBayiPortalV1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "CihazMarka")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CihazMarka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int Id;

    @Column(name = "Ad", nullable = false)
    private String Ad;

    @OneToMany(mappedBy = "cihazMarka", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cihaz> cihazs = new LinkedHashSet<>();
}
