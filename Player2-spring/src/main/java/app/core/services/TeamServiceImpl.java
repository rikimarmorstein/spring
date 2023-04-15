package app.core.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Player;
import app.core.exceptions.NBACustomException;
import app.core.repositories.PlayerRepository;
import app.core.repositories.TeamRepository;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public Player addPlayerToTeam(Player player, int teamId) throws NBACustomException {
		int badek = playerRepository.existsPlayerInTeam(teamId, player.getTeam().getId());
		if (badek == 1) {
			return playerRepository.save(player);
		} else {
			throw new NBACustomException("A player does not belong to your team");
		}
	}

	@Override
	public void updatePlayer(Player player, int teamId) throws NBACustomException {
		int badek = playerRepository.existsPlayerInTeam(teamId, player.getTeam().getId());
		if (badek == 1) {
			Player playerUpdate = playerRepository.findById(player.getId())
					.orElseThrow(() -> new NBACustomException("id not found"));
			if (!playerUpdate.getPosition().equals(player.getPosition())) {
				throw new NBACustomException("can't update position");
			}
			playerUpdate.setBirthday(player.getBirthday());
			playerUpdate.setFirstName(player.getFirstName());
			playerUpdate.setLastName(player.getLastName());
			playerUpdate.setShirtNumber(player.getShirtNumber());
			playerUpdate.setWeight(player.getWeight());
			playerUpdate.setTeam(player.getTeam());
			playerRepository.save(playerUpdate);
		} else {
			throw new NBACustomException("A player does not belong to your team", HttpStatus.BAD_REQUEST);// ExceptionState.A_PLAYER_NOT_IN_TEAM);
		}
	}

	@Override
	public void deletePlayer(int playerId, int teamId) throws NBACustomException {
		int badek = playerRepository.existsPlayerInTeam(teamId, playerId);
		if (badek == 1) {
			Player player = playerRepository.findById(playerId)
					.orElseThrow(() -> new NBACustomException("id not found"));
			if (player.getBirthday().toLocalDate().isBefore(LocalDate.now().minusYears(35))) {
				throw new NBACustomException("player Over the age of 35 cannot be deleted");
			}
			playerRepository.deleteById(playerId);
		} else {
			throw new NBACustomException("A player does not belong to your team");
		}
	}

	@Override
	public List<Player> getAllPlayersOfTeam(int teamId) {
		return playerRepository.findByTeamId(teamId);
	}

	@Override
	public Player getPlayer(int teamId, int playerId) throws NBACustomException {
		Player player = playerRepository.findById(playerId)
				.orElseThrow(() -> new NBACustomException("player not exists", HttpStatus.NOT_FOUND));
		int badek = playerRepository.existsPlayerInTeam(teamId, playerId);
		if (badek == 1) {
			return player;
		} else {
			throw new NBACustomException("A player does not belong to your team", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public String getPlayerAdult(int teamId) throws NBACustomException {
		return playerRepository.findByBirthdayMin(teamId);

	}

	@Override
	public String getPlayerYoung(int teamId) throws NBACustomException {
		return playerRepository.findByBirthdayMax(teamId);

	}

	@Override
	public double avgShirt(int teamId) {
		return playerRepository.findByShirtNumber(teamId);
	}

	@Override
	public double sumShirt(int teamId) {
		return playerRepository.findByShirtNumberSum(teamId);
	}

}
