package app;

import app.domain.Member;
import app.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
            Team team = new Team();
            team.setName("team b");
            entityManager.persist(team);

            Member member = new Member();
            member.setUserName("hello2");
            member.setTeam(team);
            entityManager.persist(member);

            entityManager.flush();
            entityManager.clear();


            Member findMember = entityManager.find(Member.class,member.getId());
            Team findTeam = findMember.getTeam();
            System.out.println("findTeam = "+findTeam.getName());
            entityTransaction.commit();
        }
        catch (Exception e)
        {
            System.out.println("===>"+e);
            entityTransaction.rollback();
        }
        finally
        {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
