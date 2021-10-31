package model.area;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AreaService")
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private SpringAreaDAO areaDAO;
	
	@Override
	public List<AreaVO> getAreaList() {
		return areaDAO.getAreaList();
	}
}
