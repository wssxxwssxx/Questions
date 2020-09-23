package com.example.question.repository;


import com.example.question.results.TempResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Map;

public interface SaveResultsRepository extends JpaRepository<TempResult, Long> {

//    @Query(value = "SELECT tr.answerid, tr.userresult " +
//            "FROM t_tempresult tr, t_answer a WHERE (tr.answerId = a_id) AND (tr.userresult = a.properly)",
//            nativeQuery = true)
//    Map<Long, Boolean> tResult();
//
//
//    @Query(value = "SELECT COUNT FROM t_tempresult tr, t_answer a " +
//            "WHERE (tr.answerId = a_id) " +
//            "AND (tr.userresult = a.properly)",
//            nativeQuery = true)
//    Integer countRights();



}
