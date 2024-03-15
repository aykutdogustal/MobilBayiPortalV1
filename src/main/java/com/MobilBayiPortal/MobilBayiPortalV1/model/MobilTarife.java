package com.MobilBayiPortal.MobilBayiPortalV1.model;

import com.MobilBayiPortal.MobilBayiPortalV1.util.core.TarifeTuru;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "MobilTarife")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MobilTarife {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int Id;

    @Enumerated(EnumType.STRING) // Store the enum as a string in the database
    private TarifeTuru tarifeTuru;

    @Column(name = "Ad", nullable = false)
    private String Ad;

    @OneToMany(mappedBy = "mobilTarife", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MobilHat> mobilHats = new LinkedHashSet<>();
}
