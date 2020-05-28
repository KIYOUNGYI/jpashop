package app.domain;

import javax.persistence.*;

@Entity
public class Locker
{
    @Id @GeneratedValue
    @Column(name="LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")//member에 있는 locker, 읽기 전용
    private Member member;
}
