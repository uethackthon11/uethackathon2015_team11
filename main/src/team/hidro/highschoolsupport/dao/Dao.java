package team.hidro.highschoolsupport.dao;

import java.util.List;

public interface Dao<E, V> {
	public List<E> getList();
	
	public E getById(V id);

	public boolean save(E item);

	public void remove(V id);

	public void update(E item);

}