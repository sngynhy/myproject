package model.nation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("NationService")
public class NationServiceImpl implements NationService {
	
	@Autowired
	private SpringNationDAO nationDAO;
	
	@Override
	public List<NationVO> getNavtionList() {
		return nationDAO.getNavtionList();
	}
}
