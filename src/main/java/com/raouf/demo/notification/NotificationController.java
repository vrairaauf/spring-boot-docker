package com.raouf.demo.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/todo/API/V1/Notification")
public class NotificationController {
	
	
	@Autowired
	private NotificationService notificationService;
	
	@GetMapping({"/", ""})
	public ResponseEntity<List<Notification>> getAll(){
		return new ResponseEntity<List<Notification>>(notificationService.getAll(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{ID}")
	public ResponseEntity<Optional<Notification>> getOne(@PathVariable String ID){
		Optional<Notification> one=notificationService.getOne(ID);
		if (one.isEmpty()){
			return new ResponseEntity<Optional<Notification>>(one, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Notification>>(one, HttpStatus.ACCEPTED);
	}
	/*----------------------------------------*/
	@DeleteMapping("/{ID}")
	public ResponseEntity<Void> delete(@PathVariable String ID){
		notificationService.delete(ID);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	/*-------------------------------------------*/
	@PostMapping({"", "/"})
	public ResponseEntity<Notification> insert(@RequestBody Notification notification){
		notificationService.save(notification);
		return new ResponseEntity<Notification>(notification, HttpStatus.CREATED);
	}
	/*-------------------------------------------*/
	
}
