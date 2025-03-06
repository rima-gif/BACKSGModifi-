package com.rima.ryma_prj.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name ="radio_frequency")
public class RadioFrequency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(unique = true,nullable = false)
    private String UID;

    @OneToOne(mappedBy = "radioFrequency")

    private machine machine;

    @OneToOne(mappedBy = "radioFrequency")
    private StationMachine stationMachine;
    public RadioFrequency() {}
    public RadioFrequency(String UID) {
        this.UID = UID;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public machine getMachine() {
        return machine;
    }

    public void setMachine(machine machine) {
        this.machine = machine;
    }

    public StationMachine getStationMachine() {
        return stationMachine;
    }

    public void setStationMachine(StationMachine stationMachine) {
        this.stationMachine = stationMachine;
    }
}
