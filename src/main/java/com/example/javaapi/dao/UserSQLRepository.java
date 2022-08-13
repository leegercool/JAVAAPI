package com.example.javaapi.dao;

import com.example.javaapi.model.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserSQLRepository  extends JpaRepository<Admin, Long> {

//    @Query("SELECT NEW com.example.polls.model.ChoiceVoteCount(v.choice.id, count(v.id)) FROM Admin v WHERE v.poll.id in :pollIds GROUP BY v.choice.id")
//    List<Admin> countByPollIdInGroupByChoiceId(@Param("pollIds") List<Long> pollIds);

//    @Query("SELECT NEW com.example.Admin.model.ChoiceVoteCount(v.choice.id, count(v.id)) FROM Admin v WHERE v.poll.id = :pollId GROUP BY v.choice.id")
//    List<Admin> countByPollIdGroupByChoiceId(@Param("pollId") Long pollId);

//    @Query("SELECT v FROM Admin v where v.user.id = :userId and v.poll.id in :pollIds")
//    List<Admin> findByUserIdAndPollIdIn(@Param("userId") Long userId, @Param("pollIds") List<Long> pollIds);

//    @Query("SELECT v FROM Admin v where v.user.id = :userId and v.poll.id = :pollId")
//    Admin findByUserIdAndPollId(@Param("userId") Long userId, @Param("pollId") Long pollId);

    @Query("SELECT COUNT(v.id) from Admin v where v.adminName = :userId")
    long countByUserId(@Param("userId") Long userId);

//    @Query("SELECT v.poll.id FROM Vote v WHERE v.user.id = :userId")
//    Page<Long> findVotedPollIdsByUserId(@Param("userId") Long userId, Pageable pageable);

}
