package team.hidro.highschoolsupport.service;

import java.util.List;

public interface Service<E,V>{
	public V save(E item);
	public List<E> getList();
	public void update(E item);
	public void remove(V id);
}
