package com.example.postgresdemo.dbview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.postgresdemo.dbview.model.ViewPerformMember;

public interface ViewPerformMemberRepository extends JpaRepository<ViewPerformMember, Long> {
	
	@Query(value = "SELECT mt.perform_memberid, mt.schedule_teatherid, m.MEMBER_NAME, t.team_Desc, s.setlist_title, st.show_date, st.show_time FROM TR_MEMBER_TEATHER mt " + 
			"JOIN T_MEMBER m ON mt.memberid = m.memberid " + 
			"JOIN TR_SCHEDULE_TEATER st ON st.schedule_teatherid = mt.schedule_teatherid " + 
			"JOIN TR_PERFORMED_SETLIST ps ON ps.performed_setlistid = st.performed_setlistid " + 
			"JOIN T_SETLIST s ON s.setlistid = ps.setlistid " + 
			"JOIN T_TEAM t ON t.teamid = m.teamid"
			,nativeQuery = true)
    List<ViewPerformMember> getAll();
	
	@Query(value = "SELECT mt.perform_memberid, mt.schedule_teatherid, m.MEMBER_NAME, t.team_Desc, s.setlist_title, st.show_date, st.show_time FROM TR_MEMBER_TEATHER mt " + 
			"JOIN T_MEMBER m ON mt.memberid = m.memberid " + 
			"JOIN TR_SCHEDULE_TEATER st ON st.schedule_teatherid = mt.schedule_teatherid " + 
			"JOIN TR_PERFORMED_SETLIST ps ON ps.performed_setlistid = st.performed_setlistid " + 
			"JOIN T_SETLIST s ON s.setlistid = ps.setlistid " + 
			"JOIN T_TEAM t ON t.teamid = m.teamid " +
			"WHERE mt.schedule_teatherid=?1"
			,nativeQuery = true)
	List<ViewPerformMember> getByScheduleTeatherId(Long scheduleTeatherId);
}
