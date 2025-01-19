package in.com.service;

import java.util.List;

import in.com.model.Cricketer;

public interface IService {

	public String register(Cricketer cricketer);
	public List<Cricketer> findall();
	public Cricketer findById(Integer id);
	public String updateById(Cricketer cricketer);
	public String deleteById(Integer id);
}
