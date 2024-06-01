package main.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.Service.UserService;

@RestController
@RequestMapping("/nagp")
public class NagpController {
	
	@Autowired
	UserService service;

    @GetMapping("/user")
    public ResponseEntity<String> userCheckIn( @RequestParam("name") String userName ){
        String response=  service.userData(userName);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/all-user")
    public ResponseEntity<String> getAllUsers(){
        String response=  service.getAll();
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/high-load")
    public String generateLoad(@RequestParam(value = "duration", defaultValue = "10") int duration) {
        long endTime = System.currentTimeMillis() + duration * 1000;
        while (System.currentTimeMillis() < endTime) {
            // CPU-intensive work
            Math.random();
        }
        return "Load generated for " + duration + " seconds";
    }

    
}
