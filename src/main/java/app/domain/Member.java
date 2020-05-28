package app.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// member <---> team n:1
@Entity
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String userName;

    // 외래키의 주인은 나야 나 ~~~
    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

//    별로 맘에 안드는 참조(이걸 굳이 양방향으로?)
//    @OneToMany(mappedBy = "member")
//    private List<Orders> orders = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="LOCKER_ID")
    private Locker locker;

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Team getTeam() {
        return team;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void changeTeam(Team team)
    {
        this.team = team;
        team.getMembers().add(this);// 나 자신을 여기에 넣어주고 바깥 라인, 아래 라인을 이 메소드로 대체한다라고 생각하자.
        //team.getMembers().add(member);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", team=" + team +
                '}';
    }
}