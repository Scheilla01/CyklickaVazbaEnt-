package sk.slavo.cyklickaVazbaEntit.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.slavo.cyklickaVazbaEntit.DTO.UserLocationDTO;
import sk.slavo.cyklickaVazbaEntit.Entities.User;
import sk.slavo.cyklickaVazbaEntit.repo.UserRepository;

// oprava cyklickej vazny entit
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<UserLocationDTO> getAllUsersLocation() {
		return userRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());

	}

	// prvy sposob opravy
	private UserLocationDTO convertEntityToDto(User user) {
		UserLocationDTO userLocationDTO = new UserLocationDTO();
		userLocationDTO.setUserId(user.getId());
		userLocationDTO.setEmail(user.getEmail());
		userLocationDTO.setPlace(user.getLocation().getPlace());
		userLocationDTO.setLongitude(user.getLocation().getLongitude());
		userLocationDTO.setLatitude(user.getLocation().getLatitude());
		return userLocationDTO;
	}

	public List<UserLocationDTO> getAllUsersLocation2() {
		return userRepository.findAll().stream().map(this::convertEntityToDto2).collect(Collectors.toList());

	}

	// druhy sposob opravy
	// pridavame strategiu pre spravne dotiahnutie entity location
	private UserLocationDTO convertEntityToDto2(User user) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UserLocationDTO userLocationDTO = new UserLocationDTO();
		userLocationDTO = modelMapper.map(user, UserLocationDTO.class);
		return userLocationDTO;
	}

	private User convertDtoToEntity(UserLocationDTO userLocationDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		User user = new User();
		user = modelMapper.map(userLocationDTO, User.class);
		return user;
	}

}
