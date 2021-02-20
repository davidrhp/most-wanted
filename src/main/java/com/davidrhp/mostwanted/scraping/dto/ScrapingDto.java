package com.davidrhp.mostwanted.scraping.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ScrapingDto {

    private LocalDate date;

    private String city;

    private List<TechnologyDto> technologies;

    public ScrapingDto() {
    }

    public ScrapingDto(LocalDate date, String city) {
        this.date = date;
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<TechnologyDto> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<TechnologyDto> technologies) {
        this.technologies = technologies;
    }

    public void addTechnology(TechnologyDto technology) {
        if (this.technologies == null) {
            this.technologies = new ArrayList<>();
        }
        this.technologies.add(technology);
    }
}
