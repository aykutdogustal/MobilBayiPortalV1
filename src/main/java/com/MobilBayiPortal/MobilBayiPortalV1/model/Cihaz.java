package com.MobilBayiPortal.MobilBayiPortalV1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Cihaz")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cihaz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "KategoriId", nullable = false)
    private CihazKategori cihazKategori;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MarkaId", nullable = false)
    private CihazMarka cihazMarka;

    @Column(name = "Ad", nullable = false)
    private String Ad;

    @Column(name = "Hafiza", nullable = true)
    private String Hafiza;

    @Column(name = "Renk", nullable = true)
    private String Renk;

    @OneToMany(mappedBy = "cihaz", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Kampanya> kampanyas = new LinkedHashSet<>();
}
