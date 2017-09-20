package com.freshen.entity.basis;

public class Sequence {

	Integer id;
	Integer seed_i, indexNumber_i, present_i;
	String prefixion_s, business_s;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSeed_i() {
		return seed_i;
	}

	public void setSeed_i(Integer seed_i) {
		this.seed_i = seed_i;
	}

	public Integer getIndexNumber_i() {
		return indexNumber_i;
	}

	public void setIndexNumber_i(Integer indexNumber_i) {
		this.indexNumber_i = indexNumber_i;
	}

	public Integer getPresent_i() {
		return present_i;
	}

	public void setPresent_i(Integer present_i) {
		this.present_i = present_i;
	}

	public String getPrefixion_s() {
		return prefixion_s;
	}

	public void setPrefixion_s(String prefixion_s) {
		this.prefixion_s = prefixion_s;
	}

	public String getBusiness_s() {
		return business_s;
	}

	public void setBusiness_s(String business_s) {
		this.business_s = business_s;
	}

	public String getResaveds1_s() {
		return resaveds1_s;
	}

	public void setResaveds1_s(String resaveds1_s) {
		this.resaveds1_s = resaveds1_s;
	}

	public String getResaveds2_s() {
		return resaveds2_s;
	}

	public void setResaveds2_s(String resaveds2_s) {
		this.resaveds2_s = resaveds2_s;
	}

	public String getResaveds3_s() {
		return resaveds3_s;
	}

	public void setResaveds3_s(String resaveds3_s) {
		this.resaveds3_s = resaveds3_s;
	}

	public String getResaveds4_s() {
		return resaveds4_s;
	}

	public void setResaveds4_s(String resaveds4_s) {
		this.resaveds4_s = resaveds4_s;
	}

	public String getResaveds5_s() {
		return resaveds5_s;
	}

	public void setResaveds5_s(String resaveds5_s) {
		this.resaveds5_s = resaveds5_s;
	}

	@Override
	public String toString() {
		return "Sequence [id=" + id + ", seed_i=" + seed_i + ", indexNumber_i="
				+ indexNumber_i + ", present_i=" + present_i + ", prefixion_s="
				+ prefixion_s + ", business_s=" + business_s + ", resaveds1_s="
				+ resaveds1_s + ", resaveds2_s=" + resaveds2_s
				+ ", resaveds3_s=" + resaveds3_s + ", resaveds4_s="
				+ resaveds4_s + ", resaveds5_s=" + resaveds5_s + "]";
	}

	public String getSequenceStr() {
		return this.business_s + this.prefixion_s + this.present_i;
	}

}
