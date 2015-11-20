package team.hidro.highschoolsupport.dao;

import java.util.List;

public interface Dao<E, V> {
	public List<E> getList();
	
	public E getById();

	public V save(E item);

	public void remove(V id);

	public void update(E item);

}