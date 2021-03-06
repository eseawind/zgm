package com.pms.app.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.joda.time.DateTime;

/**
 * 质物清单
 * @author wangzz
 */
@Entity
@Table(name = "t_pledgeRecord")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PledgeRecord {
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@GeneratedValue(generator = "uuid")
	@Column(name = "pr_id")
	private String id;
	
	/**
	 * 所属仓库
	 */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "w_id")
	private Warehouse warehouse;
	
	/**
	 * 委托方
	 */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "d_id")
	private Delegator delegator;
	
	
	/**
	 * 监管客户
	 */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "sc_id")
	private SupervisionCustomer supervisionCustomer;
	
	/**
	 * 质物清单号
	 */
	@Column(name = "pr_code")
	private String code;
	
	/**
	 * 质物清单加密号
	 */
	@Column(name = "pr_passcode")
	private String passcode;
	
	/**
	 * 总重量（g）
	 */
	@Column(name = "pr_sumWeight")
	private Double sumWeight = 0.0;
	
	/**
	 * 日期
	 */
	@Column(name = "pr_date")
	private Date date = new Date();
	
	
	/**
	 * 接收日期
	 */
	@Column(name = "rec_date")
	private Date recDate = new Date();
	
	
	/**
	 * 协议编号
	 */
	private String proCode;
	
	
	/**
	 * 出质通知书编号
	 */
	private String preCode;
	
	
	/**
	 * 是否已填写
	 * 0: 未填写
	 * 1：已填写
	 */
	private Integer writeIn = 0;

	
	/**
	 * 质物清单明细
	 */
	@OneToMany(mappedBy = "pledgeRecord")
	private List<PledgeRecordDetail> pledgeRecordDetails = new ArrayList<PledgeRecordDetail>();
	
	public String getDateStr(){
		return new DateTime(date).toString("yyyy-MM-dd");
	}
	
	public String getDateYmdhmsStr(){
		return new DateTime(date).toString("yyyy-MM-dd HH:mm:ss");
	}
	
	public int getRecYear() {
		return new DateTime(recDate).getYear();
	}
	
	public int getRecMonth() {
		return new DateTime(recDate).getMonthOfYear();
	}
	
	public int getRecDay() {
		return new DateTime(recDate).getDayOfMonth();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getSumWeight() {
		return sumWeight;
	}

	public void setSumWeight(Double sumWeight) {
		this.sumWeight = sumWeight;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	public List<PledgeRecordDetail> getPledgeRecordDetails() {
		return pledgeRecordDetails;
	}

	public void setPledgeRecordDetails(List<PledgeRecordDetail> pledgeRecordDetails) {
		this.pledgeRecordDetails = pledgeRecordDetails;
	}


	public Delegator getDelegator() {
		return delegator;
	}

	public void setDelegator(Delegator delegator) {
		this.delegator = delegator;
	}

	public SupervisionCustomer getSupervisionCustomer() {
		return supervisionCustomer;
	}

	public void setSupervisionCustomer(SupervisionCustomer supervisionCustomer) {
		this.supervisionCustomer = supervisionCustomer;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public Date getRecDate() {
		return recDate;
	}

	public void setRecDate(Date recDate) {
		this.recDate = recDate;
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	public String getPreCode() {
		return preCode;
	}

	public void setPreCode(String preCode) {
		this.preCode = preCode;
	}

	public Integer getWriteIn() {
		return writeIn;
	}

	public void setWriteIn(Integer writeIn) {
		this.writeIn = writeIn;
	}
	
	
}
