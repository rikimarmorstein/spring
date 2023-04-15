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

import app.core.entities.Player;
import app.core.exceptions.NBACustomException;
import app.core.services.TeamService;

@RestController
@RequestMapping("/api/team")
public class TeamController {
	@Autowired
	private TeamService teamService;

	@PostMapping("/{teamId}")
	Player addPlayerToTeam(@RequestBody Player player, @PathVariable int teamId) {
		try {
			return teamService.addPlayerToTeam(player, teamId);
		} catch (NBACustomException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@PutMapping("/{teamId}")
	public void updatePlayer(@RequestBody Player player, @PathVariable int teamId) {
		try {
			teamService.updatePlayer(player, teamId);
		} catch (NBACustomException e) {
			throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());// e.getExceptionState().getHttpStatus(),
																					// e.getExceptionState().getMsg());
		}
	}

	@DeleteMapping("/{playerId}/{teamId}")
	public void deletePlayer(@PathVariable int playerId, @PathVariable int teamId) {
		try {
			teamService.deletePlayer(playerId, teamId);
		} catch (NBACustomException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/getAllPlayersOfTeam/{teamId}")
	public List<Player> getAllPlayersOfTeam(@PathVariable int teamId) {
		return teamService.getAllPlayersOfTeam(teamId);
	}

	@GetMapping("/getPlayer/{teamId}/{playerId}")
	public Player getPlayer(@PathVariable int teamId, @PathVariable int playerId) {
		try {
			return teamService.getPlayer(teamId, playerId);
		} catch (NBACustomException e) {
			throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
		}
	}

	@GetMapping("/getPlayerAdult/{teamId}")
	public String getPlayerAdult(@PathVariable int teamId) {
		try {
			return teamService.getPlayerAdult(teamId);
		} catch (NBACustomException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}

	}

	@GetMapping("/getPlayerYoung/{teamId}")
	public String getPlayerYoung(@PathVariable int teamId) {
		try {
			return teamService.getPlayerYoung(teamId);
		} catch (NBACustomException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/avgShirt/{teamId}")
	public double avgShirt(@PathVariable int teamId) {
		return teamService.avgShirt(teamId);
	}

	@GetMapping("/sumShirt/{teamId}")
	public double sumShirt(@PathVariable int teamId) {
		return teamService.sumShirt(teamId);
	}

}
