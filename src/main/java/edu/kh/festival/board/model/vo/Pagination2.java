package edu.kh.festival.board.model.vo;

public class Pagination2 {
	
	private int currentPage; 	
	private int listCount; 	
	
	private int limit = 20; 
	private int pageSize = 10; 
	
	private int maxPage;	
	private int startPage;	
	private int endPage;	
	
	private int prevPage;		
	private int nextPage;		
	
	public Pagination2(int currentPage, int listCount) {
		this.currentPage = currentPage;
		this.listCount = listCount;
		
		calculatePagination();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		
		calculatePagination();
		
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
		
		calculatePagination();
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
		
		calculatePagination();
		
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		
		calculatePagination();
		
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit
				+ ", pageSize=" + pageSize + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + "]";
	}
	

	private void calculatePagination() {

		maxPage = (int)Math.ceil(((double)listCount / limit)); 

		startPage = (currentPage - 1) / pageSize * pageSize + 1 ; 
	
		endPage = startPage + pageSize - 1;

		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		if(currentPage <= pageSize) { 
			prevPage = 1;
		}else {
			prevPage = startPage - 1;
		}
		
		if(endPage == maxPage) {
			nextPage = maxPage;
		}else {
			nextPage = endPage + 1;
		}
		
	}
	
}
