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

import com.example.postgresdemo.model.MemberModel;
import com.example.postgresdemo.model.SetlistModel;
import com.example.postgresdemo.model.TeamModel;
import com.example.postgresdemo.request.RequestMemberModel;
import com.example.postgresdemo.request.RequestSetlistModel;
import com.example.postgresdemo.request.RequestTeamModel;
import com.example.postgresdemo.response.ResponseMessage;
import com.example.postgresdemo.service.MemberService;
import com.example.postgresdemo.service.SetlistService;
import com.example.postgresdemo.service.TeamService;

@RestController
public class PostgresDemoController {
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private SetlistService setlistService;
	
	//------------------------------MEMBER SECTION-------------------------------
	//Save Member
	@RequestMapping(path = "/member/new/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveMember(@RequestBody RequestMemberModel reqMember) {
		ResponseMessage response = new ResponseMessage();
		try {
			MemberModel member = new MemberModel();
			
			member.setMemberName(reqMember.getMemberName());
			member.setMemberNick(reqMember.getMemberNick());
			member.setDateOfBirth(reqMember.getDateOfBirth());
			member.setGolDar(reqMember.getGolDar());
			member.setActiveStatus(reqMember.getActiveStatus());
			member.setGeneration(reqMember.getGeneration());
			member.setTeamID(reqMember.getTeamID());
			
			memberService.save(member);	
			
			response.setMessage("Saving new Member Success!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.getMessage();
			response.setMessage("Saving new Member Failed");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	//Get All Member
	@RequestMapping(path = "/member/all", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllMember() {
		try {
			 List<MemberModel> members = memberService.findAllMember();
			 return new ResponseEntity<List<MemberModel>>(members,HttpStatus.OK);
		} catch(Exception e) {
			ResponseMessage response = new ResponseMessage();
			e.getMessage();
			response.setMessage("Getting Member Failed!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	
	//Get Member by ID
	@RequestMapping(path = "/member/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getMemberByID(@PathVariable("id") Long id){
		try {
			MemberModel member = new MemberModel();
			member = memberService.findById(id);
			return new ResponseEntity<MemberModel>(member,HttpStatus.OK);
		} catch(Exception e) {
			ResponseMessage response = new ResponseMessage();
			e.getMessage();
			response.setMessage("Getting Member Failed!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	
	//-------------------------------TEAM SECTION---------------------------------
	//Save Team
	@RequestMapping(path = "/team/new/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveTeam(@RequestBody RequestTeamModel reqTeam) {
		ResponseMessage response = new ResponseMessage();
		try {
			TeamModel team = new TeamModel();
			
			team.setTeamSign(reqTeam.getTeamSign());
			team.setTeamDesc(reqTeam.getTeamDesc());
			
			teamService.saveTeam(team);
			
			response.setMessage("Saving new Team Success!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.getMessage();
			response.setMessage("Saving new Team Failed");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	
	//Get Team Members
	@RequestMapping(path = "/team/{id}/members", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getTeamMembers(@PathVariable("id") Long id){
		try {
			List<MemberModel> memberTeam = memberService.findByTeamID(id);
			return new ResponseEntity<List<MemberModel>>(memberTeam,HttpStatus.OK);
		} catch(Exception e) {
			ResponseMessage response = new ResponseMessage();
			e.getMessage();
			response.setMessage("Getting Team Member Failed!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	
	//------------------------------SETLIST SECTION-------------------------------
	//Get All Setlist
	@RequestMapping(path = "/setlist/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllSetlist(){
		try {
			List<SetlistModel> setlists = setlistService.findAll();
			return new ResponseEntity<List<SetlistModel>>(setlists, HttpStatus.OK);
		} catch(Exception e) {
			ResponseMessage response = new ResponseMessage();
			e.getMessage();
			response.setMessage("Getting All Setlist Failed!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	
	//Save new Setlist
	@RequestMapping(path = "/setlist/new/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveNewSetlist(@RequestBody RequestSetlistModel s){
		ResponseMessage response = new ResponseMessage();
		try {
			SetlistModel setlist = new SetlistModel();
			setlist.setSetlistTitle(s.getSetlistTitle());
			
			Date today = new Date();
			setlist.setDateAdd(today);
			setlistService.save(setlist);
			response.setMessage("Saving new Setlist Success!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.OK);
			//return new ResponseEntity<Date>(today, HttpStatus.OK);
		}catch(Exception e) {
			e.getMessage();
			response.setMessage("Save new Setlist Failed!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	
	//Get Specific Setlist
	@RequestMapping(path = "/setlist/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getSetlist(@PathVariable("id") Long id){
		try {
			SetlistModel setlists = setlistService.findById(id);
			return new ResponseEntity<SetlistModel>(setlists, HttpStatus.OK);
		} catch(Exception e) {
			ResponseMessage response = new ResponseMessage();
			e.getMessage();
			response.setMessage("Getting Setlist Failed!");
			return new ResponseEntity<ResponseMessage>(response, HttpStatus.CONFLICT);
		}
	}
	
	//------------------------------------ETC-------------------------------------
	//Get Team Members
	
}
