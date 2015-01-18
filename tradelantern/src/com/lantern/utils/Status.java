package com.lantern.utils;

import com.lantern.beans.StatusMaster;
import com.lantern.impls.FindImpl;

public class Status {
	public enum LOCATION {
		
		ACTIVE(1),
		DEACTIVE(2),
		DELETED(3);
		
		int id;
		LOCATION(int id){
			this.id = id;
		}
		public int getId(){
			return this.id;
		}
		
		public StatusMaster getStatus(){
			FindImpl impl = new FindImpl();
			return impl.findStatusById(id);
		}
		
	}
	
	public enum ITEM {
		
		ACTIVE(4),
		DEACTIVE(5),
		DELETED(6);
		
		int id;
		ITEM(int id){
			this.id = id;
		}
		public int getId(){
			return this.id;
		}
		
		public StatusMaster getStatus(){
			FindImpl impl = new FindImpl();
			return impl.findStatusById(id);
		}
		
	}
	
public enum PURCHASE {
		
		ACTIVE(13),
		DEACTIVE(14),
		DELETED(15);
		
		int id;
		PURCHASE(int id){
			this.id = id;
		}
		public int getId(){
			return this.id;
		}
		
		public StatusMaster getStatus(){
			FindImpl impl = new FindImpl();
			return impl.findStatusById(id);
		}
		
	}

public enum SELL {
	
	ACTIVE(16),
	DEACTIVE(17),
	DELETED(18);
	
	int id;
	SELL(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	
	public StatusMaster getStatus(){
		FindImpl impl = new FindImpl();
		return impl.findStatusById(id);
	}
	
}
}
