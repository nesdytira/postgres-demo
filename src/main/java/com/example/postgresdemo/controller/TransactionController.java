package com.example.postgresdemo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresdemo.dbview.model.ViewPerformMember;
import com.example.postgresdemo.dbview.repository.ViewPerformMemberRepository;
import com.example.postgresdemo.model.MemberModel;
import com.example.postgresdemo.model.SetlistModel;
import com.example.postgresdemo.model.TeamModel;
import com.example.postgresdemo.request.RequestMemberId;
import com.example.postgresdemo.request.RequestPerformMemberId;
import com.example.postgresdemo.request.RequestPerformedSetlistNew;
import com.example.postgresdemo.request.RequestScheduleTeatherNew;
import com.example.postgresdemo.response.ResponseMessage;
import com.example.postgresdemo.service.MemberService;
import com.example.postgresdemo.service.PerformMemberService;
import com.example.postgresdemo.service.PerformedSetlistService;
import com.example.postgresdemo.service.ScheduleTeatherService;
import com.example.postgresdemo.service.SetlistService;
import com.example.postgresdemo.service.TeamService;
import com.example.postgresdemo.transaction.PerformMember;
import com.example.postgresdemo.transaction.PerformedSetlist;
import com.example.postgresdemo.transaction.ScheduleTeather;

@RestController
public class TransactionController {
	
	@Autowired
	private PerformedSetlistService performedSetlistService;
	
	@Autowired
	private ScheduleTeatherService scheduleTeatherService;
	
	@Autowired
	private PerformMemberService performMemberService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private SetlistService setlistService;
	
	@Autowired
	private ViewPerformMemberRepository viewPerformMemberRepository;
	
	//------------------------------------NEW PERFORMANCE------------------------------------------
	@RequestMapping(path = "/setlist/performed/new/add", 
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
 	public ResponseEntity<?> addNewPerformedSetlist(@RequestBody RequestPerformedSetlistNew reqperf){
		ResponseMessage response = new ResponseMessage();
		try {
			PerformedSetlist ptr = new PerformedSetlist();
			TeamModel team = new TeamModel();
			SetlistModel setlist = new SetlistModel();
			Date today = new Date();
			
			team = teamService.findById(reqperf.getTeamID());
			setlist = setlistService.findById(reqperf.getSetlistID());
			
			ptr.setSetlist(setlist);
			ptr.setTeam(team);
			ptr.setShowCount((long) 0);
			ptr.setStartDate(today);
			//ptr.setDateAdd(reqperf.getDateAdd());
			ptr.setEndDate(null);
			ptr.setPerformedStatus(1);
			
			performedSetlistService.save(ptr);
			
			response.setMessage("Saving new Performed Setlist Success!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
			
		} catch(Exception e) {
			e.getMessage();
			response.setMessage("Save new Performed Setlist Failed!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	//GET PERFORMED SETLIST
	@RequestMapping(path = "/setlist/performed/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPerformedSetlist(@PathVariable("id") Long id){
		try {
			PerformedSetlist ptr = new PerformedSetlist();
			ptr = performedSetlistService.getByID(id);
			
			return new ResponseEntity<PerformedSetlist>(ptr,HttpStatus.OK);
		}catch (Exception e) {
			ResponseMessage response = new ResponseMessage();
			e.getMessage();
			response.setMessage("Get Performed Setlist Failed!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	
	//--------------------------------------NEW SCHEDULE-------------------------------------------
	//Add new Schedule
	@RequestMapping(path = "/schedule/teather/new/add", 
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addNewScheduleTeather(@RequestBody RequestScheduleTeatherNew reqsch){
		ResponseMessage response = new ResponseMessage();
		try {
			PerformedSetlist ptr = new PerformedSetlist();
			ptr = performedSetlistService.getByID(reqsch.getPerformedSetlistID());
			
			ScheduleTeather sch = new ScheduleTeather();
			sch.setShowDate(reqsch.getShowDate());
			sch.setShowTime(reqsch.getShowTime());
			sch.setPerformedSetlist(ptr);
			
			sch = scheduleTeatherService.save(sch);
			
			performedSetlistService.addCounts(ptr); //Add counts
			
			//SAVE ALL TEAM MEMBER TO DEFAULTLY PERFORM
			Long teamID = performMemberService.getTeamBySchedule(sch);
			
			List<MemberModel> memberTeam = memberService.findByTeamID(teamID);
			
			performMemberService.saveAllTeamMemberPerform(sch, memberTeam);
			//END SAVE
			
			response.setMessage("Saving new Schedule Setlist Success!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
		} catch(Exception e) {
			e.getMessage();
			response.setMessage("Save Schedule Failed!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	//Get Schedule
	@RequestMapping(path = "/schedule/teather/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getScheduleTeather(@PathVariable("id") Long id){
		try {
			ScheduleTeather sch = new ScheduleTeather();
			sch = scheduleTeatherService.getByID(id);
			
			return new ResponseEntity<ScheduleTeather>(sch, HttpStatus.CONFLICT);
		} catch(Exception e) {
			ResponseMessage response = new ResponseMessage();
			e.getMessage();
			response.setMessage("Get Schedule Failed!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	//Get All Schedule
	@RequestMapping(path = "/schedule/teather/all", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllSchedule(){
		try {
			List<ScheduleTeather> schs = scheduleTeatherService.findAll();
			return new ResponseEntity<List<ScheduleTeather>>(schs, HttpStatus.OK);
		}catch(Exception e) {
			ResponseMessage response = new ResponseMessage();
			e.getMessage();
			response.setMessage("Get Schedule Failed!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	
	//-----------------------------------NEW PERFORM MEMBER----------------------------------------
	//ADD MEMBER TO PERFORM
	@RequestMapping(path = "/schedule/teather/{id}/add-member", 
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addPerformMember(@PathVariable("id") Long scheduleId, @RequestBody List<RequestMemberId> members){
		ResponseMessage response = new ResponseMessage();
		try {			
			members.forEach(m -> {
				try {
					ScheduleTeather sch = new ScheduleTeather();
					sch = scheduleTeatherService.getByID(scheduleId);
					
					MemberModel member = new MemberModel();
					member = memberService.findById(m.getMemberId());
					
					PerformMember p = new PerformMember();
					p.setScheduleTeather(sch);
					p.setMember(member);
					performMemberService.save(p);
					
					response.setMessage("Save Perform Member Success!");
				} catch (Exception e) {
					response.setMessage(e.getMessage());
					return;
				}
			});
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
		} catch(Exception e) {
			e.getMessage();
			response.setMessage("Save Schedule Failed!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	//DELETE PERFORM MEMBER
	@RequestMapping(path = "/schedule/teather/{id}/delete-member", 
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deletePerformMember(@PathVariable("id") Long scheduleId, @RequestBody List<RequestPerformMemberId> members){
		ResponseMessage response = new ResponseMessage();
		try {			
			members.forEach(performMemberId -> {
				try {
					performMemberService.deletePerformMember(performMemberId.getPerformMemberId());
					
					response.setMessage("Delete Perform Member Success!");
				} catch (Exception e) {
					response.setMessage(e.getMessage());
					return;
				}
			});
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
		} catch(Exception e) {
			e.getMessage();
			response.setMessage("Save Schedule Failed!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	//GET PERFORMED MEMBER BY SCHEDULE
	@RequestMapping(path = "/schedule/teather/{id}/member", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPerformMember(@PathVariable("id") Long scheduleId){
		try {
			ScheduleTeather sch = scheduleTeatherService.getByID(scheduleId);
			List<PerformMember> perf = performMemberService.findBySchedule(sch);
			return new ResponseEntity<List<PerformMember>>(perf, HttpStatus.OK);
			/*List<ViewPerformMember> vpm = viewPerformMemberRepository.getByScheduleTeatherId(scheduleId);
			return new ResponseEntity<List<ViewPerformMember>>(vpm, HttpStatus.OK);*/
		} catch(Exception e) {
			ResponseMessage response = new ResponseMessage();
			response.setMessage(e.getMessage());
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
}
