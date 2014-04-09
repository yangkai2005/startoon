package org.j2eeframework.information.web.actions.admin.information.post;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Post;
import org.j2eeframework.information.service.PostService;

public class PostAction extends ServiceBaseManageAction<Post, Long> {
	private static final long serialVersionUID = 3395120513674008670L;
	@Resource
	private PostService postService;
	private Post post;
	
	private List<Long> ids;
	private Integer status;

	@Override
	public IGenericService<Post, Long> getGenericService() {
		return postService;
	}

	public Post getModel() {
		return post;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			post = new Post();
		} else {
			post = postService.getEntityById(getRequestId());
		}
	}
	
	public String auditAll() {
		for(Long id : ids) {
			Post post = postService.getEntityById(id);
			post.setStatus(status);
			postService.update(post);
		}
		return ResultConstants.LIST;
	}
	
	public String top() {
		boolean isTop = post.getIsTop();
		post.setIsTop(!isTop);
		postService.update(post);
		return ResultConstants.LIST;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
