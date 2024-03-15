package com.MobilBayiPortal.MobilBayiPortalV1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Musteri")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Musteri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int Id;

    @Column(name = "MusteriKod", nullable = false)
    private int MusteriKod;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "KisiId", nullable = false)
    private Kisi kisi;

    @Column(name = "Il", nullable = true)
    private String Il;

    @Column(name = "Ilce", nullable = true)
    private String Ilce;

    @Column(name = "TelefonNumarasi", nullable = false)
    private String TelefonNumarasi;

    @Column(name = "VergiNumarasi", nullable = true)
    private String VergiNumarasi;

    @Column(name = "AcikAdres", nullable = true)
    private String AcikAdres;

    @OneToMany(mappedBy = "musteri", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MobilHat> mobilHats = new LinkedHashSet<>();

    @OneToMany(mappedBy = "musteri", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Satis> satis = new LinkedHashSet<>();
}
