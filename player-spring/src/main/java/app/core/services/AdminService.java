package app.core.services;

import java.util.List;

import app.core.entities.Team;
import app.core.exceptions.NBACustomException;

public interface AdminService {

	Team addTeam(Team team) throws NBACustomException;

	void updateTeam(Team team) throws NBACustomException;

	void deleteTeam(int teamId) throws NBACustomException;

	List<Team> getAllTeams();

	Team getTeam(int teamId) throws NBACustomException;

	Team getTeamYoung() throws NBACustomException;

	Team getTeamGraduate() throws NBACustomException;

	List<Team> getTeamsStartWith(String letter);

	List<Team> getTeamsEntWith(String letter);

	List<Team> getTeamsWith(String letter);

	List<Team> getAllTeamsBySortAscending();

	List<Team> getAllTeamsBySortDescending();

	List<Team> getTeamsEstablishedSortAscending();

	List<Team> getTeamsEstablishedSortDescending();

}
