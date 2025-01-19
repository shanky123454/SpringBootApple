package in.com.ServiceImplClass;

import java.util.ArrayList;
import java.util.List;

import in.com.Iservice.Iservice;

public class ServiceImplClass implements Iservice {
	
	public Iservice iservice;
	public ServiceImplClass(Iservice iservice2) {
		this.iservice=iservice2;
	}

	public List<String> retrieveTodos(String user) {
			List<String> filteredTodos = new ArrayList<String>();
			List<String> allTodos = iservice.retrieveTodos(user);
			for (String todo : allTodos) {
				if (todo.contains("sha")) {
					filteredTodos.add(todo);
				}
			}
			return filteredTodos;
		}
		
	}

