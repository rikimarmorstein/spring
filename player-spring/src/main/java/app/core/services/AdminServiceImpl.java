package app.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Team;
import app.core.exceptions.NBACustomException;
import app.core.repositories.PlayerRepository;
import app.core.repositories.TeamRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public Team addTeam(Team team) throws NBACustomException {
		if (teamRepository.existsByName(team.getName())) {
			throw new NBACustomException("name is exists");
		}
		Team teamCreate = teamRepository.save(team);
		return teamCreate;
	}

	@Override
	public void updateTeam(Team team) throws NBACustomException {
		Team teamUp = teamRepository.findById(team.getId())
				.orElseThrow(() -> new NBACustomException("team not exists"));

		if (team.getEstablishedYear() != teamUp.getEstablishedYear()) {
			throw new NBACustomException("can't update EstablishedYear");
		}
		teamUp.setName(team.getName());
		teamRepository.save(teamUp);
	}

	@Override
	public void deleteTeam(int teamId) throws NBACustomException {
		Team team = teamRepository.findById(teamId)
				.orElseThrow(() -> new NBACustomException("team " + teamId + " not exists"));
		if (team.getEstablishedYear() < 1975) {
			throw new NBACustomException("can't delete team, is before 1975");
		}
		teamRepository.deleteById(teamId);
	}

	@Override
	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}

	@Override
	public Team getTeam(int teamId) throws NBACustomException {
		Team team = teamRepository.findById(teamId)
				.orElseThrow(() -> new NBACustomException("team " + teamId + " not exists"));
		return team;
	}

	@Override
	public Team getTeamYoung() throws NBACustomException {
		int meatId = teamRepository.getTeamYoung();
		Team team = teamRepository.findById(meatId).orElseThrow(() -> new NBACustomException("team Young not exists"));
		return team;
	}

	@Override
	public Team getTeamGraduate() throws NBACustomException {
		int meatId = teamRepository.getTeamGraduate();
		Team team = teamRepository.findById(meatId)
				.orElseThrow(() -> new NBACustomException("team Graduate not exists"));
		return team;
	}

	@Override
	public List<Team> getTeamsStartWith(String letter) {
		return teamRepository.findAllByNameStartingWith(letter);
	}

	@Override
	public List<Team> getTeamsEntWith(String letter) {
		return teamRepository.findAllByNameEndingWith(letter);
	}

	@Override
	public List<Team> getTeamsWith(String letter) {
		return teamRepository.findAllByNameContaining(letter);

	}

	@Override
	public List<Team> getAllTeamsBySortAscending() {
		return teamRepository.findAllByOrderByName();
	}

	@Override
	public List<Team> getAllTeamsBySortDescending() {
		return teamRepository.findAllByOrderByNameDesc();
	}

	@Override
	public List<Team> getTeamsEstablishedSortAscending() {
		return teamRepository.findAllByOrderByEstablishedYear();
	}

	@Override
	public List<Team> getTeamsEstablishedSortDescending() {
		return teamRepository.findAllByOrderByEstablishedYearDesc();
	}

}
