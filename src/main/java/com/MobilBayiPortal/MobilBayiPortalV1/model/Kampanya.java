package com.MobilBayiPortal.MobilBayiPortalV1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Kampanya")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Kampanya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CihazId", nullable = false)
    private Cihaz cihaz;

    @Column(name = "TaksitSayisi", nullable = false)
    private int TaksitSayisi;

    @Column(name = "TaksitTutari", nullable = false)
    private int TaksitTutari;

    @Column(name = "Ad", nullable = false)
    private String Ad;

    @OneToMany(mappedBy = "kampanya", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Satis> satis = new LinkedHashSet<>();
}
