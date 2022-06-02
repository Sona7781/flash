package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todos>todos = new ArrayList<>();
	private static int todocount=3;

	static {
		todos.add(new Todos(1, "in28Minutes", "Learn Spring MVC", new Date(),
				false));
		todos.add(new Todos(2, "sinthu", "Learn Struts", new Date(), false));
		todos.add(new Todos(3, "in28Minutes", "Learn Hibernate", new Date(),
				false));
	}

	public List<Todos> retrieveTodos(String name)
	{
		List<Todos> filteredlist = new ArrayList<>();

		for(Todos todo: todos)
		{
			if(todo.getUser().equals(name))
				filteredlist.add(todo);
		}

		return filteredlist;
	}

	public void addTodo(String name, String desc, Date date, boolean b) {	
		todos.add(new Todos(++todocount,name,desc,date,b));		
	}

	public void deleteTodo(int id) {		
		Iterator<Todos> itr=todos.iterator();
		while(itr.hasNext())
		{
			Todos todo=itr.next();
			if(todo.getId()==id)
				itr.remove();
		}

	}

	public Todos retrieveTodo(int id) {
		for(Todos todo : todos)
		{
			if(id==todo.getId())
				return todo;
		}
		return null;
	}

	public void updateTodo(Todos todo) {		
		todos.remove(todo);
		todos.add(todo);		
	}



}
