package pl.korman.docker.familymemberapp.FamilyMember;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyMemberRepo extends JpaRepository<FamilyMember,Integer> {

    List<FamilyMember> findAllByFamilyId(int familyName);
}
