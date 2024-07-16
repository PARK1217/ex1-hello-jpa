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
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    //페이징 처리
                    //.setFirstResult(1)
                    //.setMaxResults(10)
//                    .getResultList();
//
//            for(Member member : result) {
//                System.out.println("member.name = " + member.getName());

            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            //영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            //1차 캐시에 저장
//            System.out.println("=== AFTER ===");

            //조회 sql 안나옴.. select 쿼리가 안나오고 insert 쿼리만 나옴
            //1차 캐시에 저장된 데이터를 조회
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//
//            System.out.println("result = " + (findMember1 == findMember2)); //동일성 보장 = true
            //같은 트랜잭션 안에서는 같은 인스턴스를 반환한다.

            //JPA 의 모든 작업은 Transaction 안에서 실행되어야 함

//            em.persist(member); // 영속성 컨텍스트에 저장

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//            //쓰기 지연 SQL 저장소에 쿼리를 저장해놓고 commit 시점에 쿼리를 날림

//            //찾아온 다음에
//            Member member = em.find(Member.class, 150L);
//            //변경
//            member.setName("ZZZZZ");

            //em.setFlushMode(FlushModeType.COMMIT); // 플러쉬 모드를 변경할 수 있음 (기본값은 AUTO) -> COMMIT으로 변경하면 커밋할 때만 플러쉬가 됨
            //가급적 AUTO로 사용하는 것을 권장

//            Member member = new Member (200L, "member200");
//            em.persist(member);
//
//            em.flush(); //쿼리를 날리는 시점 (영속성 컨텍스트의 내용을 데이터베이스에 반영)
//            //강제로 flush를 호출하면 쿼리를 날림

            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            em.detach(member); //영속성 컨텍스트에서 분리 (JPA가 관리하지 않음) -> 준영속 상태 update 쿼리가 나가지 않음
            System.out.println("==================");

            tx.commit();
            //commit 시점에 쿼리가 나감

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
