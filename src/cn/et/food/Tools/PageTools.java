package cn.et.food.Tools;

import java.util.List;

import cn.et.food.entity.Student;

public class PageTools {
	/**
	 * 构造方法
	 * @param curPage 页面传来的当前页数
	 * @param pageCount 每页显示的条数
	 * @param totalCount 总记录数
	 */
	public PageTools(Integer curPage,Integer pageCount,Integer totalCount){
		this.curPage=curPage;
		this.pageCount=pageCount==null?5:pageCount;
		this.total=totalCount;
		this.prePage=(curPage==1?1:curPage-1);
		this.totalPage=(totalCount%this.pageCount==0?totalCount/this.pageCount:totalCount/this.pageCount+1);
		this.nextPage=(curPage==totalPage)?totalPage:(curPage+1);
		this.startIndex=(curPage-1)*this.pageCount+1;
		this.endIndex=curPage*this.pageCount;
	}
	/*
	 * 当前页
	 */
	private Integer curPage;
	/*
	 * 每页显示的条数
	 */
	private Integer pageCount=10;
	/*
	 * 上一页
	 * prePage= (curPage==1?1:curPage-1)
	 */
	private Integer prePage;
	/*
	 * 下一页
	 * nextPage= (curPage==totalPage?totalPage:curPage+1)
	 */
	private Integer nextPage;
	/*
	 * 总页数
	 * totalPage= (totalCount%pageCount==0?totalCount/pageCount:totalCount/pageCount+1)
	 */
	private Integer totalPage;
	/*
	 * 总记录数(从数据库查询)
	 */
	private Integer total;
	
	private List<Student> rows;
	/*
	 * 开始索引
	 * startIndex=(curPage-1)*pageCount+1
	 */
	private Integer startIndex;
	/*
	 * 结束索引
	 * endIndex=curPage*pageCount
	 */
	private Integer endIndex;
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPrePage() {
		return prePage;
	}
	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	public List<Student> getRows() {
		return rows;
	}
	public void setRows(List<Student> rows) {
		this.rows = rows;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}
	
	
}
