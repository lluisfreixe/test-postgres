package cat.dgp.openshift;

import java.util.List;

public interface IndividuoDao {
	
	List<Individuo> findAll();

	void insertIndividuo(Individuo emp);

	void updateIndividuo(Individuo emp);

	void executeUpdateIndividuo(Individuo emp);

	public void deleteIndividuo(Individuo emp);
	
	public void deleteIndividuoAll();
	
}
