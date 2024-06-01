package main.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.Entity.UserEntity;
import main.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public String userData(String name) {
		String response = "";
		UserEntity user = userRepository.findByName(name);
		if(Objects.isNull(user)) {
			user = new UserEntity();
			user.setName(name);
			
			response =  "Hi ".concat(name).concat(", Its your first time here");
		} else {
			
			response =  "Welcome Back ".concat(name).concat(", your last login was on ").concat(user.getLastlogin().toString());
		}
		user.setLastlogin(LocalDateTime.now());
		userRepository.saveAndFlush(user);
		return response;
		
	}
	
	public String getAll() {
		List<UserEntity> users = userRepository.findAll();
		  String tableHeader = "<table><tr><th>Username</th><th>Last Login</th></tr>";
	        String tableRows = users.stream()
	                .map(user -> "<tr><td>" + user.getName() + "</td><td>" + user.getLastlogin().toString() + "</td></tr>")
	                .collect(Collectors.joining());
	        String tableFooter = "</table>";
	        return tableHeader + tableRows + tableFooter;
	}

}
