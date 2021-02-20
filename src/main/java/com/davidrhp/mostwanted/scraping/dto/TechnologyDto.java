package com.davidrhp.mostwanted.scraping.dto;

public class TechnologyDto {

    private String technology;

    private int numAvailableJobs;

    public TechnologyDto() {
    }

    public TechnologyDto(String technology, int numAvailableJobs) {
        this.technology = technology;
        this.numAvailableJobs = numAvailableJobs;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public int getNumAvailableJobs() {
        return numAvailableJobs;
    }

    public void setNumAvailableJobs(int numAvailableJobs) {
        this.numAvailableJobs = numAvailableJobs;
    }
}
