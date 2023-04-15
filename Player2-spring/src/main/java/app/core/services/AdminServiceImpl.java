package app.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
			throw new NBACustomException("team's name exists");
		}
		return teamRepository.save(team);
	}

	@Override
	public void updateTeam(Team team) throws NBACustomException {
		Team teamFromDb = teamRepository.findById(team.getId())
				.orElseThrow(() -> new NBACustomException("id " + team.getId() + " not found"));
		if (teamFromDb.getEstablishedYear() != team.getEstablishedYear()) {
			throw new NBACustomException("can't update EstablishedYear");
		}
		teamFromDb.setName(team.getName());
		teamFromDb.setPlayers(team.getPlayers());
		teamRepository.save(teamFromDb);
	}

	@Override
	public void deleteTeam(int teamId) throws NBACustomException {
		Team teamFromDb = teamRepository.findById(teamId)
				.orElseThrow(() -> new NBACustomException("id " + teamId + " not found"));
		if (teamFromDb.getEstablishedYear() < 1975) {
			throw new NBACustomException("can't delete - EstablishedYear is before 1975");
		}
		teamRepository.deleteById(teamId);
	}

	@Override
	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}

	@Override
	public Team getTeam(int teamId) throws NBACustomException {
		return teamRepository.findById(teamId).orElseThrow(() -> new NBACustomException("id " + teamId + " not found"));
	}

	@Override
	public Team getTeamYoung() throws NBACustomException {
		Optional<Team> opt = teamRepository.findByEstablishedYearMax();
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new NBACustomException("not found");
	}

	@Override
	public Team getTeamGraduate() throws NBACustomException {
		Optional<Team> opt = teamRepository.findByEstablishedYearMin();
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new NBACustomException("not found");
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
		return teamRepository.findAllByOrderByName();// Asc
	}

	@Override
	public List<Team> getAllTeamsBySortDescending() {
		return teamRepository.findAllByOrderByNameDesc();
	}

	@Override
	public List<Team> getTeamsEstablishedSortAscending() {
		return teamRepository.findAllByOrderByEstablishedYear();// Asc
	}

	@Override
	public List<Team> getTeamsEstablishedSortDescending() {
		return teamRepository.findAllByOrderByEstablishedYearDesc();
	}

}
