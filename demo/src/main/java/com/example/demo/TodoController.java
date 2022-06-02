package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String showTodos(ModelMap model)
	{
		String name = (String)model.get("name");
		model.put("todos", service.retrieveTodos(name)); 
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todos", method=RequestMethod.GET)
	public String addTodos(ModelMap model)
	{
		model.addAttribute("todo", new Todos(0,(String)model.get("name"),"Default desc", new Date(),false ));
		return "addTodo";
	}
	
	@RequestMapping(value="/add-todos", method=RequestMethod.POST)
	public String addedTodos(ModelMap model,@Valid Todos todo, BindingResult result)
	{

		if (result.hasErrors()) {
			return "addTodo";
		}
		service.addTodo((String)model.get("name"),todo.getDesc(),todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String updateTodos(ModelMap model,@RequestParam int id)
	{
		Todos todo= service.retrieveTodo(id);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String updatedTodos(ModelMap model,@Valid Todos todo, BindingResult result)
	{

		if (result.hasErrors()) {
			return "addTodo";
		}
		
		todo.setUser((String)model.get("name"));
		service.updateTodo(todo);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
	public String deleteTodos(ModelMap model,@RequestParam int id)
	{
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}

}
