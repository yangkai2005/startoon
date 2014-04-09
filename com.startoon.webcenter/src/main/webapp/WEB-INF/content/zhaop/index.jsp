<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="中国游艺网——星力网,2012动漫游戏行业大型招聘会" />
<meta name="description" content="中国游艺网,星力网,2012动漫游戏行业大型招聘会" />
<title>中国游艺网,星力网,2012动漫游戏行业大型招聘会</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>

<link rel="stylesheet" type="text/css" href="${ctx}/resources/fancybox/jquery.fancybox-1.3.4.css"/>
<script type="text/javascript" src="${ctx}/resources/fancybox/jquery.fancybox-1.3.4.pack.js"></script>

<script type="text/javascript">
$(function() {
	$('a#grbm').fancybox({
		padding: 0,
		margin: 0,
		width: 300,
		height: 350,
		type: 'iframe',
		showNavArrows: false, 
		scrolling: 'no'
	});
});
</script>

</head>
<body>
<div class="wrap">
<div class="main">
  <div class="head">
    <div class="banner"><a href="#"><img src="${ctx}/zhaop/images/banner.jpg" alt="" /></a></div>
  </div>
  <div class="info">
    <div class="info_l fl">
      <p> 聚焦动漫游戏行业，名企、高校强强联手打造大型综合招盛会。动漫游艺行业专业门户网站—中国游艺网星力网，集结动漫游艺行业知名企业、动漫专业高校共同举办“2012动漫游戏行业大型网络招聘会”。中国游艺网星力网诚邀各大动漫游戏企业、有志投身动漫事业的高校毕业生以及社会专业人士共同参与，并全程提供专业的人才服务，供求方信息配对，引荐人才以及推荐就业职位等服务。</p></div>
     <div class="info_r fl">
      <div class="info_r1"><a href="http://www.chnam.com/information/attachment/attachment!show.action?requestId=34" class="button1 fl"  target="_blank"></a><a id="grbm" href="show-msg.jsp" class="button2 fl"></a></div>
      <div class="info_r2"><a href="http://www.chnam.com/information/hrservice/jobs-list.action" class="button3 fl" target="_blank"></a><a  href="http://www.chnam.com/information/hrservice/talent-list.action" class="button4 fl" target="_blank"></a></div>
      <div class="info_r3">
      <form action="">
      <input type="text"class="input_text fl" /><input type="submit" class="input_submit fl" value="" />
      </form></div>
      <div class="info_r4"><div><p>2012年6月15日至8月31日</p><p>020-39106666转市场部</p></div></div>
    </div>
    <div class="clear"></div>
    <div class="companys">
      <div class="companys_head"></div>
      <div class="companys_main">

<e:query id="mqzp1" sql="select * from t_hr_enterprise a where a.type=1 order by order_no desc, id asc limit 16"/>
<s:set var="mqzps1" value="#request.mqzp1"/>

        <ul>
        <s:iterator value="mqzps1">
          <li class="company_li fl"><a href="<s:property value='site'/>" target="_blank"><img src="${ctx}/zhaop/${ctx}/FileView?id=<s:property value='logo'/>" alt="<s:property value='name'/>" /></a></li>
        </s:iterator>
        </ul>
      </div>

<e:query id="jobs" sql="select id, name, enterprise_name, enterprise_id from t_jobs where status=0 and is_deleted=0 order by is_top desc, is_recommend desc, id desc limit 27"/>
<s:set var="items" value="#request.jobs"/>

      <div class="jobs">
        <div class="jobs_head" style="text-align:right;margin-bottom:0px;"><a href="${ctx}/information/hrservice/jobs-list.action" target="_blank">更多</a>&gt;&gt;&nbsp;&nbsp;</div>
        <div class="jobs_main">
          <ul>
			<s:iterator value="items">
            <li class="job_li fl">
              <p><a href="${ctx}/enterprises/ent-hr.action?enterpriseId=<s:property value='enterprise_id'/>" target="_blank"><s:property value="enterprise_name"/></a></p>
              <a href="${ctx}/information/hrservice/jobs!show.action?requestId=<s:property value='id'/>" target="_blank"><p class="red"><s:property value="name"/></p></a>
            </li>
			</s:iterator>
          </ul>
        </div>
        <div class="schools">
          <div class="schools_head"></div>
          <div class="schools_main">

<e:query id="ztcs" sql="select * from t_hr_enterprise a where a.type=2 order by order_no desc, id asc limit 8"/>
<s:set var="ztc" value="#request.ztcs"/>
            
            <ul>
            <s:iterator value="ztc">
              <li class="school_li fl"><a href="<s:property value='site'/>" target="_new"><img src="${ctx}/zhaop/${ctx}/FileView?id=<s:property value='logo'/>" alt="<s:property value='name'/>" /></a></li>
            </s:iterator>
            </ul>
          </div>
        </div>
        <div class="links">
          <div class="links1 fl">
            <div class="links1_head"></div>
            <div class="links1_main">
              <ul>
                <li class="link_li fl"><a href="http://www.tydw.com/" target="_new"><img src="${ctx}/zhaop/images/合作媒体/天一.jpg" alt="" /></a></li>
                <li class="link_li fl"><a href="http://www.xylgame.com/" target="_new"><img src="${ctx}/zhaop/images/合作媒体/原创.jpg" alt="" /></a></li>
                <li class="link_li fl"><a href="http://www.sydm.org/" target="_new"><img src="${ctx}/zhaop/images/合作媒体/视野动漫.jpg" alt="" /></a></li>
                <li class="link_li fl"><a href="http://www.chinaamuse.com/" target="_new"><img src="${ctx}/zhaop/images/合作媒体/游艺风.jpg" alt="" /></a></li>
                <li class="link_li fl"><a href="http://www.amu8.com/" target="_new"><img src="${ctx}/zhaop/images/合作媒体/电玩.jpg" alt="" /></a></li>
                <li class="link_li fl"><a href="http://www.chnam.com/information/attachment/index.action" target="_new"><img src="${ctx}/zhaop/images/合作媒体/星力快讯.jpg" alt="" /></a></li>
              </ul>
            </div>
          </div>
          <div class="links2 fl">
            <div class="links2_head"></div>
            <div class="links2_main">
              <ul>
                <li class="link_li fl"><a href="http://www.gaga.org.cn/" target="_new"><img src="${ctx}/zhaop/images/合作媒体/gaga.jpg" alt="" /></a></li>
                <li class="link_li fl"><a href="http://www.startooncity.com" target="_new"><img src="${ctx}/zhaop/images/合作媒体/产业园.jpg" alt="" /></a></li>
              </ul>
            </div>
          </div>
          <div class="links3 fl">
            <div class="links3_head"></div>
            <div class="links3_main">
              <ul>
                <li class="link_li fl"><a href="http://www.chnam.com" target="_new"><img src="${ctx}/zhaop/images/合作媒体/数码.jpg" alt="" /></a></li>
              </ul>
            </div>
          </div>
          <div class="links3 fl">
            <div class="links4_head"></div>
            <div class="links4_main">
              <ul>
                <li class="link_li fl"><a href="http://www.chnam.com" target="_new"><img src="${ctx}/zhaop/images/合作媒体/星力网.jpg" alt="" /></a></li>
              </ul>
            </div>
          </div>
          <div class="clear"></div>
        </div>
      </div>
    </div>
  </div>
  <div class="foot">
    <p>地址：广州市番禺区东环街迎新路8号    电话：020-339106666   传真：020-39113999 </p>
    <p>广州星力数码科技有限公司 版权所有  粤ICP备10238157号-1
</p>
  </div>
</div>
</body>
</html>