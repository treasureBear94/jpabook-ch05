package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Team(String id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public void addMember(Member member) {
        this.members.add(member);

        // 무한루프에 안 빠지도록 체크
        if(member.getTeam() != this) {
            member.setTeam(this);
        }
    }
}
