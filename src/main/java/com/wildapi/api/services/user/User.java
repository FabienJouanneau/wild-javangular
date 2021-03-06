package com.wildapi.api.services.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wildapi.api.services.battle.Battle;
import com.wildapi.api.services.crew.Crew;
import com.wildapi.api.services.daybook.Daybook;
import com.wildapi.api.services.solution.Solution;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"daybooks", "battles", "solutions"})
public class User {

    @Id()
    private Long id;

    private String email;

    private boolean admin;
    private String lastname;
    private String firstname;
    private String github;
    private boolean banished;
    private String fullname;
    private String main_role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_crew_id", referencedColumnName = "id")
    private Crew current_crew;


    @JsonManagedReference("creator-daybooks")
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Daybook> daybooks;

    @JsonManagedReference("battles-creator")
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Battle> battles;

    @JsonManagedReference("creator-solution")
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Solution> solutions;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Daybook> getDaybooks() {
        return daybooks;
    }

    public void setDaybooks(List<Daybook> daybooks) {
        this.daybooks = daybooks;
    }

    @Transient
//    @JsonIgnore
    public Set<GrantedAuthority> getAuthorities() {
        return new HashSet<>();
    }

    public String getEmail() {
        return email;
    }

    public boolean getAdmin() {
        return admin;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getGithub() {
        return github;
    }

    public boolean getBanished() {
        return banished;
    }

    public String getFullname() {
        return fullname;
    }

    public String getMain_role() {
        return main_role;
    }

    public Crew getCurrent_crew() {
        return current_crew;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public void setBanished(boolean banished) {
        this.banished = banished;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setMain_role(String main_role) {
        this.main_role = main_role;
    }

    public void setCurrent_crew(Crew current_crew) {
        this.current_crew = current_crew;
    }

    public List<Battle> getBattles() {
        return battles;
    }

    public void setBattles(List<Battle> battles) {
        this.battles = battles;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }
}