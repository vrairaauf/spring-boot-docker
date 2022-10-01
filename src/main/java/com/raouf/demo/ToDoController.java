package com.raouf.demo;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo/API/V1")
public class ToDoController {
	
	@Autowired
	private ToDoService data ;
	@GetMapping(value= {"", "/"})
	public  ResponseEntity<List<ToDo>> gettodo() {
		List<ToDo> res= data.findAll();
		return new ResponseEntity<List<ToDo>>(res, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ToDo> retrieve(@PathVariable String id) {
		try {
			ToDo res=data.retrieve(id);
			return new ResponseEntity<ToDo>(res, HttpStatus.ACCEPTED);
		}catch(NoSuchElementException ex) {
			throw new NotFoundException("bad ID try with other ID");
		}
	}
	
	/*
	@PostMapping(value= {"", "/"})
	public ToDo insertdata(@Validated @RequestBody ToDo todo) {
		return data.insertData(todo);
	}
	
	*/
	@PostMapping(value= {"", "/"})
	public ResponseEntity<ToDo> insertData(@Validated @RequestBody ToDo todo) {
		
		ToDo res=data.insertData(todo);
		return new ResponseEntity<ToDo>(res, HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteToDo(@PathVariable String id) {
		data.daleteData(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
