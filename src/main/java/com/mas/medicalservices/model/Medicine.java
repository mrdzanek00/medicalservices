package com.mas.medicalservices.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name = "Medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column( name = "id_medicine")
    private Integer idMedicine;

    @NotNull
    @Column( name = "name")
    private String name;

    @NotNull
    @Column( name = "avg_price")
    private Double avgPrice;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Medicine_Substitute")
    @Nullable
    private  Set<Medicine> subsitutes = new TreeSet<>((o1, o2) -> {
        if (o1.avgPrice >= o2.avgPrice)
            return 0;
        return 1;
    });

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_medicine")
    private List<HealMethod> healMethodList = new ArrayList<>();

    public List<HealMethod> getHealMethodList() {
        return healMethodList;
    }

    public void setHealMethodList(List<HealMethod> healMethodList) {
        this.healMethodList = healMethodList;
    }

    public Integer getIdMedicine() {
        return idMedicine;
    }

    public void setIdMedicine(Integer idMedicine) {
        this.idMedicine = idMedicine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Set<Medicine> getSubsitutes() {
        return subsitutes;
    }

    public void setSubsitutes(Set<Medicine> subsitutes) {
        this.subsitutes = subsitutes;
    }
}
