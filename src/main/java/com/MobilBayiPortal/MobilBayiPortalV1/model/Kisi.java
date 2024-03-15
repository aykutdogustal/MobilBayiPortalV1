package com.MobilBayiPortal.MobilBayiPortalV1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Kisi")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Kisi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int Id;

    @Column(name = "Ad", nullable = false)
    private String Ad;

    @Column(name = "Soyad", nullable = false)
    private String Soyad;

    @Column(name = "TcKimlikNumarasi", nullable = false)
    private String TcKimlikNumarasi;

    @Column(name = "DogumTarihi", nullable = true)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate DogumTarihi;

    @Column(name = "DogumYeri", nullable = true)
    private String DogumYeri;

    @OneToMany(mappedBy = "kisi", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Musteri> musteris = new LinkedHashSet<>();


}
