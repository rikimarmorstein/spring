package app.core.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Player;
import app.core.entities.Team;
import app.core.exceptions.NBACustomException;
import app.core.repositories.PlayerRepository;
import app.core.repositories.TeamRepository;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public Player addPlayerToTeam(Player player, int teamId) throws NBACustomException {
		Team team = teamRepository.findById(teamId).orElseThrow(() -> new NBACustomException("team not exists"));
		playerRepository.save(player);
		team.addPlayer(player);
		return player;
	}

	@Override
	public void updatePlayer(Player player, int teamId) throws NBACustomException {
//		if (teamRepository.existsPlayerInTeam(teamId, player.getId()))
//			;
		int i = teamRepository.existsPlayerInTeam(teamId, player.getId());
		if (i == 1) {
			Player playerUpdate = playerRepository.findById(player.getId())
					.orElseThrow(() -> new NBACustomException("player not exists"));
			if (!playerUpdate.getPosition().equals(player.getPosition())) {
				throw new NBACustomException("can't update position");
			}
			playerUpdate.setFirstName(player.getFirstName());
			playerUpdate.setLastName(player.getLastName());
			playerUpdate.setBirthday(player.getBirthday());
			playerUpdate.setForeign(player.isForeign());
			playerUpdate.setShirtNumber(player.getShirtNumber());
			playerUpdate.setWeight(player.getWeight());
			playerRepository.save(playerUpdate);
		} else {
			throw new NBACustomException("player don't in this team");
		}
	}

	@Override
	public void deletePlayer(int teamId, int playerId) throws NBACustomException {
		Player player = playerRepository.findById(playerId)
				.orElseThrow(() -> new NBACustomException("player not exists"));
		int i = teamRepository.existsPlayerInTeam(teamId, playerId);
		if (i == 1) {
			if (player.getBirthday().toLocalDate().isBefore(LocalDate.now().minusYears(35))) {
				throw new NBACustomException("player Over the age of 35 cannot be deleted");
			}
			teamRepository.deletePlayerFromTeam(teamId, playerId);
		} else {
			throw new NBACustomException("player don't in this team");
		}
	}

	@Override
	public List<Player> getAllPlayersOfTeam(int teamId) {
		return playerRepository.findAllByPlayers(teamId);
	}

	@Override
	public Player getPlayer(int teamId, int playerId) throws NBACustomException {
		Player player = playerRepository.findById(playerId)
				.orElseThrow(() -> new NBACustomException("player not exists"));
		int i = teamRepository.existsPlayerInTeam(teamId, playerId);
		if (i == 1) {
			return player;
		} else {
			throw new NBACustomException("player don't in this team");
		}
	}

	@Override
	public Player getPlayerAdult(int teamId) throws NBACustomException {
		int a = playerRepository.findByBirthdayMin(teamId);
		Player player = playerRepository.findById(a)
				.orElseThrow(() -> new NBACustomException("player don't in this team"));
		return player;
	}
//
//	@Override
//	public Player getPlayerYoung(int teamId) throws NBACustomException {
//		int a = playerRepository.findByBirthdayMax(teamId);
//		Player player = playerRepository.findById(a)
//				.orElseThrow(() -> new NBACustomException("player don't in this team"));
//		return player;
//	}

	@Override
	public double avgShirt(int teamId) {
		return playerRepository.findByShirtNumber(teamId);
	}

	@Override
	public double sumShirt(int teamId) {
		return playerRepository.findByShirtNumberSum(teamId);
	}

}
