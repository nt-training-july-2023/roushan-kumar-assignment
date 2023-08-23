package nucleusteq.com.grievanceManagementSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nucleusteq.com.grievanceManagementSystem.dto.UserDto;
import nucleusteq.com.grievanceManagementSystem.entity.Users;
import nucleusteq.com.grievanceManagementSystem.repository.UserRepo;
import nucleusteq.com.grievanceManagementSystem.service.UserService;

@Service
public class UsersServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	public UsersServiceImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public List<Users> getAllUser() {
		try {
			return userRepo.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Users save(Users user) {
		return userRepo.save(user);
	}

	@Override
	public Users login(UserDto userDto) {
		Users tempUser = new Users();

		try {
			tempUser = userRepo.getByUserName(userDto.getUsername());
			if (tempUser.getUserId() != null) {
				if (tempUser.getPassword().equals(userDto.getPassword())) {
					return tempUser;
				}
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public boolean authenticate(UserDto userDto) {
		Users tempUser = new Users();

		try {
			tempUser = userRepo.getByUserName(userDto.getUsername());
			if (tempUser.getUserId() != null) {
				if (tempUser.getPassword().equals(userDto.getPassword())) {
					return true;
				}
			}
		} catch (Exception e) {
		}
		return false;
	}

}
