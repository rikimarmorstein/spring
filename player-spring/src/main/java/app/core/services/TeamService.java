package app.core.services;

import java.util.List;

import app.core.entities.Player;
import app.core.exceptions.NBACustomException;

public interface TeamService {

	Player addPlayerToTeam(Player player, int teamId) throws NBACustomException;

	void updatePlayer(Player player, int teamId) throws NBACustomException;

	void deletePlayer(int playerId, int teamId) throws NBACustomException;

	List<Player> getAllPlayersOfTeam(int teamId);

	Player getPlayer(int teamId, int playerId) throws NBACustomException;

	Player getPlayerAdult(int teamId) throws NBACustomException;

//	Player getPlayerYoung(int teamId) throws NBACustomException;

	double avgShirt(int teamId);

	double sumShirt(int teamId);

}
