package curso.modelo.entity;

public class AppDetailWrapper {
	
	public AppDetail appDetail;
	public Criteria criteria;
	
	public AppDetailWrapper(AppDetail appDetail, Criteria criteria) {
		// TODO Auto-generated constructor stub
		this.appDetail = appDetail;
		this.criteria = criteria;
	}
	
	public AppDetail getAppDetail() {
		return appDetail;
	}

	public void setAppDetail(AppDetail appDetail) {
		this.appDetail = appDetail;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public String toString() {
		return "AppDetailWrapper [appDetail=" + appDetail + ", criteria=" + criteria + "]";
	}

}
