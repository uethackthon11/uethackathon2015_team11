package team.hidro.highschoolsupport.service;

import java.util.List;

public interface Service<E,V>{
	public boolean save(E item);
	public E getById(V id);
	public List<E> getList();
	public void update(E item);
	public void remove(V id);
}
