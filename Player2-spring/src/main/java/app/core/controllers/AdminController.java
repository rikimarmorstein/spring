package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Team;
import app.core.exceptions.NBACustomException;
import app.core.services.AdminService;

@RestController
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping
	public Team addTeam(@RequestBody Team team) {
		try {
			return adminService.addTeam(team);
		} catch (NBACustomException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PutMapping
	public void updateTeam(@RequestBody Team team) {
		try {
			adminService.updateTeam(team);
		} catch (NBACustomException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@DeleteMapping("/{teamId}")
	public void deleteTeam(@PathVariable int teamId) {
		try {
			adminService.deleteTeam(teamId);
		} catch (NBACustomException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/getAllTeams")
	public List<Team> getAllTeams() {
		return adminService.getAllTeams();
	}

	@GetMapping("/{teamId}")
	public Team getTeam(@PathVariable int teamId) {
		try {
			return adminService.getTeam(teamId);
		} catch (NBACustomException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("getTeamYoung")
	public Team getTeamYoung() {
		try {
			return adminService.getTeamYoung();
		} catch (NBACustomException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/getTeamGraduate")
	public Team getTeamGraduate() {
		try {
			return adminService.getTeamGraduate();
		} catch (NBACustomException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/getTeamsStartWith")
	public List<Team> getTeamsStartWith(String letter) {
		return adminService.getTeamsStartWith(letter);
	}

	@GetMapping("/getTeamsEntWith")
	public List<Team> getTeamsEntWith(String letter) {
		return adminService.getTeamsEntWith(letter);
	}

	@GetMapping("/getTeamsWith")
	public List<Team> getTeamsWith(String letter) {
		return adminService.getTeamsWith(letter);
	}

	@GetMapping("/getAllTeamsBySortAscending")
	public List<Team> getAllTeamsBySortAscending() {
		return adminService.getAllTeamsBySortAscending();// Asc
	}

	@GetMapping("/getAllTeamsBySortDescending")
	public List<Team> getAllTeamsBySortDescending() {
		return adminService.getAllTeamsBySortDescending();
	}

	@GetMapping("/getTeamsEstablishedSortAscending")
	public List<Team> getTeamsEstablishedSortAscending() {
		return adminService.getTeamsEstablishedSortAscending();// Asc
	}

	@GetMapping("/getTeamsEstablishedSortDescending")
	public List<Team> getTeamsEstablishedSortDescending() {
		return adminService.getTeamsEstablishedSortDescending();
	}

}
