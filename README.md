# jpabook-ch05
자바 ORM 표준 JPA 프로그래밍(김영한) 참고

#### 참조를 사용하는 객체의 연관관계: 단방향

```
member1.setTeam(team1);
Team findTeam = member1.getTeam();
```

#### 외래키를 사용하는 데이블의 연관관계: 양방향

```roomsql
SELECT * 
FROM member
JOIN team ON member.TEAM_ID = team.ID
WHERE member.ID = 'member1'
```

@JoinColumn: 외래키를 매핑할 때 사용.(생략 가능)
- name: 매핑할 외래키 이름
- 생략하면, name은 필드명(team)+_+참조하는 테이블의 기본키 컬럼명(TEAM_ID)으로 됨. = team_TEAM_ID

@ManyToOne: 다대일(N:1) 관계에서 사용(필수)

--- 
조회
1. 객체 그래프 탐색(객체를 통해 조회: member.getTeam();)
2. 객체지향 쿼리 사용(JPQL)
- sql 조인과 jpql 조인은 문법이 다르다.
- jpql에서는 `:변수명`로 써서 파라미터를 바인딩 한다.

---
수정

entity 값 변경

---

연관관계 삭제

연관관계를 삭제하고, 엔티티를 삭제해야 한다.
```
member1.setTeam(null);  // 연관관계 삭제
em.remove(team);        // 엔티티 삭제
```

   