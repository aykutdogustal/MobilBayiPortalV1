package com.MobilBayiPortal.MobilBayiPortalV1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Satis")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Satis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MusteriId", nullable = false)
    private Musteri musteri;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MobilHatId", nullable = false)
    private MobilHat mobilHat;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "KampanyaId", nullable = false)
    private Kampanya kampanya;

    @CreationTimestamp
    @Column(name = "SatisTarihi", nullable = false, updatable = false)
    private Instant SatisTarihi;

    @Column(name = "SatisKampanyaBitisTarihi", nullable = true)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate SatisKampanyaBitisTarihi;
}
