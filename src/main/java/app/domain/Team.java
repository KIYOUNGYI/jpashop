package app.domain;


import javax.persistence.*;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="team_id")
    private Long teamId;

    @Column(name="team_name")
    private String name;

    public Long getId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public void setId(Long teamId) {
        this.teamId = teamId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
