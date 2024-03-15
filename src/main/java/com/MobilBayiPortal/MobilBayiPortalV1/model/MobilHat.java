package com.MobilBayiPortal.MobilBayiPortalV1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "MobilHat")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MobilHat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MobilTarifeId", nullable = false)
    private MobilTarife mobilTarife;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MusteriId", nullable = false)
    private Musteri musteri;

    @Column(name = "MobilHatNumarasi", nullable = false)
    private String MobilHatNumarasi;

    @Column(name = "MobilHatPuan", nullable = true)
    private int MobilHatPuan;

    @Column(name = "SozlesmeBaslamaTarihi", nullable = true)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate SozlesmeBaslamaTarihi;

    @Column(name = "SozlesmeBitisTarihi", nullable = true)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate SozlesmeBitisTarihi;

    @OneToMany(mappedBy = "mobilHat", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Satis> satis = new LinkedHashSet<>();
}
