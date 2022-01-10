package sk.slavo.cyklickaVazbaEntit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.slavo.cyklickaVazbaEntit.DTO.UserLocationDTO;
import sk.slavo.cyklickaVazbaEntit.Entities.User;
import sk.slavo.cyklickaVazbaEntit.Services.UserService;
import sk.slavo.cyklickaVazbaEntit.repo.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	// vrati vela opakujucih sa zaznamov v cykle
	@GetMapping("/users-location-chyba")
	public List<User> getAllUsersLocationChyba() {
		return userRepository.findAll();
	}

	// vrati korektny pocet
	@GetMapping("/users-locationo-oprava01")
	public List<UserLocationDTO> getAllUsersLocationOprava01() {
		return userService.getAllUsersLocation();
	}

	// vrati korektny pocet
	@GetMapping("/users-locationo-oprava02")
	public List<UserLocationDTO> getAllUsersLocationOprava02() {
		return userService.getAllUsersLocation2();
	}

}
