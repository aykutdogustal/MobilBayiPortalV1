package com.MobilBayiPortal.MobilBayiPortalV1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "CihazKategori")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CihazKategori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int Id;

    @Column(name = "Ad", nullable = false)
    private String Ad;

    @OneToMany(mappedBy = "cihazKategori", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cihaz> cihazs = new LinkedHashSet<>();
}
