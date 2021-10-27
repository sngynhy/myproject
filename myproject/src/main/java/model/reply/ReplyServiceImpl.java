package model.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("ReplyService")
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private SpringReplyDAO replyDAO;
	
	@Override
	public void insertReply(ReplyVO vo) {
		replyDAO.insertReply(vo);
	}
	@Override
	public void deleteReply(ReplyVO vo) {
		replyDAO.deleteReply(vo);
	}
	@Override
	public void updateReply(ReplyVO vo) {
		replyDAO.updateReply(vo);
	}
}
