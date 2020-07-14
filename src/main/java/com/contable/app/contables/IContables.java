package com.contable.app.contables;

import java.util.List;

public interface IContables {
	/**
	 * Return all Contable Elements
	 * @return
	 */
	List<Contables> findAll();
	
	/**
	 * Persistence data db
	 * @param contable
	 * @return 0 if error, 1 if insert, 2 if update
	 */
	int save(Contables contable);
}
