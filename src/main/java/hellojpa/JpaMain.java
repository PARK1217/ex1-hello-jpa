package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // hello : persistence.xml에 설정한 유닛 name 값 을 작성하면서 데이터베이스와 연결이 마무리 됨
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code (실제 비즈니스 로직을 작성하는 부분)


        try {
//            Member findMember = em.find(Member.class, 1L);
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            for(Member member : result) {
                System.out.println("member.name = " + member.getName());
            }
            //JPA 의 모든 작업은 Transaction 안에서 실행되어야 함

//            em.persist(member); // 영속성 컨텍스트에 저장
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
