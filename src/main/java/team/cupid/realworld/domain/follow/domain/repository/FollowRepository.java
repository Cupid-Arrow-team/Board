package team.cupid.realworld.domain.follow.domain.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import team.cupid.realworld.domain.follow.domain.Follow;
import team.cupid.realworld.domain.member.domain.Member;

import java.util.List;
import java.util.function.LongSupplier;

public interface FollowRepository extends JpaRepository<Follow, Long> {

     boolean existsByFromMemberAndToMember(Member fromMember, Member toMember);
     void deleteByFromMemberAndToMember(Member fromMember, Member toMember);

    List<Follow> findByFromMember(Member fromMember, Pageable pageable);
    List<Follow> findByToMember(Member fromMember, Pageable pageable);

    @Query("select count(*) from Follow f")
    LongSupplier totalCount();


}
