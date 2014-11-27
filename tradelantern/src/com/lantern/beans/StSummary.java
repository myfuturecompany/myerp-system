package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the st_summary database table.
 * 
 */
@Entity
@Table(name="st_summary")
@NamedQuery(name="StSummary.findAll", query="SELECT s FROM StSummary s")
public class StSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="invoice_no")
	private String invoiceNo;

	@Column(name="total_particular")
	private int totalParticular;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="transaction_date")
	private Date transactionDate;

	//bi-directional many-to-one association to LocationMaster
	@ManyToOne
	@JoinColumn(name="from_loc_id")
	private LocationMaster locationMaster1;

	//bi-directional many-to-one association to StatusMaster
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster statusMaster;

	//bi-directional many-to-one association to LocationMaster
	@ManyToOne
	@JoinColumn(name="to_loc_id")
	private LocationMaster locationMaster2;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetail userDetail;

	//bi-directional many-to-one association to StTransaction
	@OneToMany(mappedBy="stSummary")
	private List<StTransaction> stTransactions;

	public StSummary() {
	}

	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getTotalParticular() {
		return this.totalParticular;
	}

	public void setTotalParticular(int totalParticular) {
		this.totalParticular = totalParticular;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LocationMaster getLocationMaster1() {
		return this.locationMaster1;
	}

	public void setLocationMaster1(LocationMaster locationMaster1) {
		this.locationMaster1 = locationMaster1;
	}

	public StatusMaster getStatusMaster() {
		return this.statusMaster;
	}

	public void setStatusMaster(StatusMaster statusMaster) {
		this.statusMaster = statusMaster;
	}

	public LocationMaster getLocationMaster2() {
		return this.locationMaster2;
	}

	public void setLocationMaster2(LocationMaster locationMaster2) {
		this.locationMaster2 = locationMaster2;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<StTransaction> getStTransactions() {
		return this.stTransactions;
	}

	public void setStTransactions(List<StTransaction> stTransactions) {
		this.stTransactions = stTransactions;
	}

	public StTransaction addStTransaction(StTransaction stTransaction) {
		getStTransactions().add(stTransaction);
		stTransaction.setStSummary(this);

		return stTransaction;
	}

	public StTransaction removeStTransaction(StTransaction stTransaction) {
		getStTransactions().remove(stTransaction);
		stTransaction.setStSummary(null);

		return stTransaction;
	}

}