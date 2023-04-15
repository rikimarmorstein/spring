package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Team;
import app.core.exceptions.NBACustomException;
import app.core.services.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping
	public Team addTeam(@RequestBody Team team) throws NBACustomException {
		return adminService.addTeam(team);
	}

	@PutMapping
	public void updateTeam(@RequestBody Team team) throws NBACustomException {
		adminService.updateTeam(team);
	}

	@DeleteMapping("/{teamId}")
	public void deleteTeam(@PathVariable int teamId) throws NBACustomException {
		adminService.deleteTeam(teamId);
	}

	@GetMapping("/allTeams")
	public List<Team> getAllTeams() {
		return adminService.getAllTeams();

	}

	@GetMapping("/oneTeam/{teamId}")
	public Team getTeam(@PathVariable int teamId) throws NBACustomException {
		return adminService.getTeam(teamId);
	}
	
	@GetMapping("/getTeamYoung")
	public Team getTeamYoung() throws NBACustomException {
					return adminService.getTeamYoung();
	}

	@GetMapping("/getTeamGraduate")
	public Team getTeamGraduate() throws NBACustomException {
			return adminService.getTeamGraduate();
	}
@GetMapping("/getTeamsStartWith")
	public List<Team> getTeamsStartWith(@RequestParam String letter) {
		return adminService.getTeamsStartWith(letter);
	}

@GetMapping("/getTeamsEntWith")
	public List<Team> getTeamsEntWith(@RequestParam String letter) {
		return adminService.getTeamsEntWith(letter);
	}

@GetMapping("/getTeamsWith")
	public List<Team> getTeamsWith(@RequestParam String letter) {
		return adminService.getTeamsWith(letter);
	}

@GetMapping("/getAllTeamsBySortAscending")
	public List<Team> getAllTeamsBySortAscending() {
		return adminService.getAllTeamsBySortAscending();
	}

@GetMapping("/getAllTeamsBySortDescending")
	public List<Team> getAllTeamsBySortDescending() {
		return adminService.getAllTeamsBySortDescending();
	}

@GetMapping("/getTeamsEstablishedSortAscending")
	public List<Team> getTeamsEstablishedSortAscending() {
		return adminService.getTeamsEstablishedSortAscending();
	}

@GetMapping("/getTeamsEstablishedSortDescending")
	public List<Team> getTeamsEstablishedSortDescending() {
		return adminService.getTeamsEstablishedSortDescending();
	}


}
