package org.j2eeframework.information.web.actions.information.subject;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.Subject;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.SubjectService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 专题首页
 * 
 * @author kai
 */
public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6067383173967855624L;

	@Resource
	private InfoService infoService;
	@Resource
	private SubjectService subjectService;

	private List<Info> imgInfos; // 焦点图
	private List<Info> focusInfos; // 焦点
	private List<Info> latestInfos; // 最新
	private List<Info> hitInfos; // 人气

	private Info event; // 活动
	private List<Info> videos; // 视频
	private Info video1;
	private List<Info> video2;

	private List<Subject> subjects; // 相关专题
	private List<Info> infos; // 相关主题新闻
	private Subject currentSubject;

	@Override
	public String execute() {
		currentSubject = subjectService.getCurrentSubject();
		Long subjectId = currentSubject.getId();

		imgInfos = infoService.getImgInfoBySubjectId(subjectId, 4);
		focusInfos = infoService.getFocusInfoBySubjectId(subjectId, 3);
		latestInfos = infoService.getLatestInfoBySubjectId(subjectId, 7);
		hitInfos = infoService.getHitInfoBySubjectId(subjectId, 7);

		infos = infoService.getRelationInfos(subjectId, 2);

		event = infoService.getEventBySubjectId(subjectId);

		videos = infoService.getVideoBySubjectId(subjectId, 3);
		if (videos != null) {
			int size = videos.size();
			if (size > 0) {
				video1 = videos.get(0);
			}
			if (size > 1) {
				video2 = videos.subList(1, videos.size());
			}
		}

		return SUCCESS;
	}

	public List<Info> getImgInfos() {
		return imgInfos;
	}

	public List<Info> getFocusInfos() {
		return focusInfos;
	}

	public List<Info> getLatestInfos() {
		return latestInfos;
	}

	public List<Info> getHitInfos() {
		return hitInfos;
	}

	public Info getEvent() {
		return event;
	}

	public List<Info> getVideos() {
		return videos;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public Info getVideo1() {
		return video1;
	}

	public List<Info> getVideo2() {
		return video2;
	}

	public List<Info> getInfos() {
		return infos;
	}

	public Subject getCurrentSubject() {
		return currentSubject;
	}

	public void setCurrentSubject(Subject currentSubject) {
		this.currentSubject = currentSubject;
	}
}
