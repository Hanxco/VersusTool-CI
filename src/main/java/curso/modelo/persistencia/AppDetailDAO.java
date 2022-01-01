package curso.modelo.persistencia;

import java.util.List;

import curso.modelo.entity.AppDetail;

public interface AppDetailDAO {

	void insert(AppDetail app);
	void modify(AppDetail app);
	void delete(Integer appId);
	AppDetail searchById(Integer id);
	List<AppDetail> getAllByAppId(Integer appId);
}



