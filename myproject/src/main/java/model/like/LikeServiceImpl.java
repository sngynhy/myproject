package model.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LikeService")
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	private SpringLikeDAO likeDAO;
	
	@Override
	public void isnertLike(LikeVO vo) {
		likeDAO.isnertLike(vo);
	}
	@Override
	public void delete(LikeVO vo) {
		likeDAO.delete(vo);
	}
}
