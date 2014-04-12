package org.j2eeframework.information.web.actions.information.bar;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Post;
import org.j2eeframework.information.entity.PostType;
import org.j2eeframework.information.service.PostService;
import org.j2eeframework.information.service.PostTypeService;

public class PostAction extends ServiceBaseManageAction<Post, Long> {
	private static final long serialVersionUID = 2199318788059289212L;
	@Resource
	private PostService postService;
	@Resource
	private PostTypeService postTypeService;

	private Post post;
	private List<PostType> postTypes;

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
		
		postTypes = postTypeService.getAllEntity();
		
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public List<PostType> getPostTypes() {
		return postTypes;
	}

	public void setPostTypes(List<PostType> postTypes) {
		this.postTypes = postTypes;
	}

}
