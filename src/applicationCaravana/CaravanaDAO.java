package applicationCaravana;

import java.util.List;

public interface CaravanaDAO {
	void salvar(Caravana c);
	List<Caravana> listar(String nome);
}
