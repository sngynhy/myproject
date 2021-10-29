package model.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private SpringCategoryDAO categoryDAO;
	
	@Override
	public List<CategoryVO> getCategoryList() {
		return categoryDAO.getCategoryList();
	}
}
