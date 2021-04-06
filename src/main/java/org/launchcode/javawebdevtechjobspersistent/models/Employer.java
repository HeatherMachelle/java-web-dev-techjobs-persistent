package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;
//import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;


@Entity
public class Employer extends AbstractEntity {


    @NotNull(message = "Location required")
    @Size(max = 50, message = "Limit to 50 characters.")
    private String location;

    @OneToMany
    @JoinColumn
    private final List<Job> jobs;

    {
        jobs = new ArrayList<>();
    }


    public Employer() {
    }

    public Employer(String location) {
        this.location = location;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
