package app;

import app.domain.Member;
import app.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Hello World");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        // 쓰레드 안에 공유(x) => 공유하면 장애나~
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try
        {
            // 순수 객체 상태를 고려해서 양쪽에 데이터를 넣어주자.
            Team team = new Team();
            team.setName("team b");
            // 문제의 코드(아래)
//            team.getMembers().add(member);
            entityManager.persist(team);


            Member member = new Member();
            member.setUserName("hello7");
            // 이게 중요한 거야~~
//            member.setTeam(team);
            member.changeTeam(team);//연관관계 메소드, get,set 관례가 아니라는걸 티를 내는것도 나쁘지 않아.
            entityManager.persist(member);

//            team.getMembers().add(member);

//            entityManager.flush();
//            entityManager.clear();

            Team findTeam = entityManager.find(Team.class, team.getTeamId());
            List<Member> members = findTeam.getMembers();

            System.out.println("==========================");
            System.out.println("members size : "+ members.size());
            for (Member m : members)
            {
                System.out.println("m = "+ m.getUserName());
            }
            System.out.println("==========================");
//            Member findMember = entityManager.find(Member.class,member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//            for(Member m:members)
//            {
//                System.out.println("m="+m.toString());
//            }
            entityTransaction.commit();
        }
        catch (Exception e)
        {
            System.out.println("exception error : "+e);
            entityTransaction.rollback();
        }
        finally
        {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
