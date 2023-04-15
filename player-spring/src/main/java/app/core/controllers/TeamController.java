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
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Player;
import app.core.exceptions.NBACustomException;
import app.core.services.TeamService;

@RestController
@RequestMapping("/api/team")
public class TeamController {
	@Autowired
	private TeamService teamServiceImpl;

	@PostMapping("/{teamId}")
	public Player addPlayerToTeam(@RequestBody Player player, @PathVariable int teamId) throws NBACustomException {
		teamServiceImpl.addPlayerToTeam(player, teamId);
		return player;
	}

	@PutMapping("/update/{teamId}")
	public void updatePlayer(@RequestBody Player player, @PathVariable int teamId) throws NBACustomException {
		teamServiceImpl.updatePlayer(player, teamId);
	}

	@DeleteMapping("/{teamId}/{playerId}")
	public void deletePlayer(@PathVariable int teamId, @PathVariable int playerId) throws NBACustomException {
		teamServiceImpl.deletePlayer(teamId, playerId);
	}

	@GetMapping("/getAllPlayersOfTeam/{teamId}")
	public List<Player> getAllPlayersOfTeam(@PathVariable int teamId) {
		return teamServiceImpl.getAllPlayersOfTeam(teamId);
	}

	@GetMapping("/{teamId}/{playerId}")
	public Player getPlayer(@PathVariable int teamId, @PathVariable int playerId) throws NBACustomException {
		return teamServiceImpl.getPlayer(teamId, playerId);
	}

	@GetMapping("/adult/{teamId}")
	public Player getPlayerAdult(@PathVariable int teamId) throws NBACustomException {
		return teamServiceImpl.getPlayerAdult(teamId);
	}
//
//	@GetMapping("/young/{teamId}")
//	public Player getPlayerYoung(@PathVariable int teamId) throws NBACustomException {
//		return teamServiceImpl.getPlayerYoung(teamId);
//	}

	@GetMapping("/avgShirt/{teamId}")
	public double avgShirt(@PathVariable int teamId) throws NBACustomException {
		return teamServiceImpl.avgShirt(teamId);
	}

	@GetMapping("/sumShirt/{teamId}")
	public double sumShirt(@PathVariable int teamId) throws NBACustomException {
		return teamServiceImpl.sumShirt(teamId);
	}
}
