package com.raouf.demo.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
	@Autowired
	private NotifactionRepository notificationRepository;
	
	public List<Notification> getAll(){
		return notificationRepository.findAll();
	}
	/*---------------------------------------------*/
	
	public long count() {
		return notificationRepository.count();
	}
	/*------------------------------------------*/
	public Optional<Notification> getOne(String ID) {
		return notificationRepository.findById(ID);
	}
	
	/*---------------------------------------------*/
	public void delete(String ID) {
		notificationRepository.deleteById(ID);
	}
	/*------------------------------------------*/
	public Boolean exist(String ID) {
		return notificationRepository.existsById(ID);
	}
	/*--------------------------------------------*/
	public void save(Notification notification) {
		notificationRepository.save(notification);
	}
}
