package com.raouf.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	/*
	private List<ToDo> data= new ArrayList<>(Arrays.asList(
			new ToDo(1, "raouf", "first project"),
			new ToDo(2, "raouf", "first project"),
			new ToDo(3, "raouf", "first project"),
			new ToDo(3, "raouf", "first project")
			));
			*/
	@Autowired
	private ToDoRepository todorepository;
	
	public List<ToDo> findAll(){
		//default created in unterface
		return todorepository.findAll();
	}
	
	public ToDo retrieve(String id) {
		return todorepository.findById(id).get();
	}
	
	public ToDo insertData(ToDo todo) {
		if(todorepository.findByTitle(todo.getTitle()) != null) {
			throw new ConflicException("other record with the same title");
		}/*if(todorepository.findById(todo.getId()) != null) 
			throw new ConflicException("other record with this ID");*/
		
		return todorepository.insert(todo);
	}
	
	public void daleteData(String id) {
		todorepository.deleteById(id);
	}
}
