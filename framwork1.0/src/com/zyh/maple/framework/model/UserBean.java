/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.framework.model;

import java.io.Serializable;

import com.zyh.maple.framework.commons.SysParams;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String memberId;
	private String memberName;
	private String memberSex;
	private String memberAge;
	private String memberEmail;
	private String memberPassword;
	private String memberBrthday;
	private String memberGrade;
	private String nickName;
	private String photoPath;
	private String logingTime;
	private String stateFlag;
	private String memberRole;
	private String addressProvince;
	private String addressCity;
	private String addressArea;
	private String addressTradingArea;
	private String memberSignature;
	private String infoFullRate;
	private String memberBorn;
	private String memberSchool;
	private String memberWorkUnit;
	private String point;
	private String dept;
	private String msn;
	private String skypy;
	private String qq;
	private String gtalk;
	private String industry;
	private String photo50X50Path;
	private String photo80X80Path;
	private String photo150X150Path;
	private String memberForce;
	private String isMan;

	public String getMemberId() {
		return this.memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberSex() {
		return this.memberSex;
	}

	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}

	public String getMemberAge() {
		return this.memberAge;
	}

	public void setMemberAge(String memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberBorn() {
		return this.memberBorn;
	}

	public void setMemberBorn(String memberBorn) {
		this.memberBorn = memberBorn;
	}

	public String getMemberSchool() {
		return this.memberSchool;
	}

	public void setMemberSchool(String memberSchool) {
		this.memberSchool = memberSchool;
	}

	public String getMemberWorkUnit() {
		return this.memberWorkUnit;
	}

	public void setMemberWorkUnit(String memberWorkUnit) {
		this.memberWorkUnit = memberWorkUnit;
	}

	public String getMemberEmail() {
		return this.memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPassword() {
		return this.memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberBrthday() {
		return this.memberBrthday;
	}

	public void setMemberBrthday(String memberBrthday) {
		this.memberBrthday = memberBrthday;
	}

	public String getMemberGrade() {
		return this.memberGrade;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhotoPath() {
		return this.photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getLogingTime() {
		return this.logingTime;
	}

	public void setLogingTime(String logingTime) {
		this.logingTime = logingTime;
	}

	public String getPoint() {
		return this.point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getMsn() {
		return this.msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getSkypy() {
		return this.skypy;
	}

	public void setSkypy(String skypy) {
		this.skypy = skypy;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getGtalk() {
		return this.gtalk;
	}

	public void setGtalk(String gtalk) {
		this.gtalk = gtalk;
	}

	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getStateFlag() {
		return this.stateFlag;
	}

	public void setStateFlag(String stateFlag) {
		this.stateFlag = stateFlag;
	}

	public String getMemberRole() {
		return this.memberRole;
	}

	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}

	public String getAddressProvince() {
		return this.addressProvince;
	}

	public void setAddressProvince(String addressProvince) {
		this.addressProvince = addressProvince;
	}

	public String getAddressCity() {
		return this.addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressArea() {
		return this.addressArea;
	}

	public void setAddressArea(String addressArea) {
		this.addressArea = addressArea;
	}

	public String getAddressTradingArea() {
		return this.addressTradingArea;
	}

	public void setAddressTradingArea(String addressTradingArea) {
		this.addressTradingArea = addressTradingArea;
	}

	public String getMemberSignature() {
		return this.memberSignature;
	}

	public void setMemberSignature(String memberSignature) {
		this.memberSignature = memberSignature;
	}

	public String getInfoFullRate() {
		return this.infoFullRate;
	}

	public void setInfoFullRate(String infoFullRate) {
		this.infoFullRate = infoFullRate;
	}

	public String getPhoto50X50Path() {
		this.photo50X50Path = this.getPhotoSizePath(SysParams.IMAGESAVEPATH[0]);
		return this.photo50X50Path;
	}

	public void setPhoto50X50Path(String photo50X50Path) {
		this.photo50X50Path = photo50X50Path;
	}

	public String getPhoto80X80Path() {
		this.photo80X80Path = this.getPhotoSizePath(SysParams.IMAGESAVEPATH[1]);
		return this.photo80X80Path;
	}

	public void setPhoto80X80Path(String photo80X80Path) {
		this.photo80X80Path = photo80X80Path;
	}

	public String getPhoto150X150Path() {
		this.photo150X150Path = this.getPhotoSizePath(SysParams.IMAGESAVEPATH[2]);
		return this.photo150X150Path;
	}

	public void setPhoto150X150Path(String photo150X150Path) {
		this.photo150X150Path = photo150X150Path;
	}

	private String getPhotoSizePath(String sizeStr) {
		String tempPath = null;
		if (this.getPhotoPath() != null && !"".equals(this.getPhotoPath())) {
			String path = this.getPhotoPath().replace("\\", "/");
			int namePos = path.lastIndexOf("/");
			if (namePos > 0) {
				String fileName = path.substring(namePos);
				tempPath = path.substring(0, namePos);
				tempPath = String.valueOf(tempPath) + "/" + sizeStr + fileName;
			} else {
				tempPath = this.getPhotoPath();
			}
			System.out.println("tempPath = " + tempPath);
		}
		return tempPath;
	}

	public String getMemberForce() {
		return this.memberForce;
	}

	public void setMemberForce(String memberForce) {
		this.memberForce = memberForce;
	}

	public String getIsMan() {
		return this.isMan;
	}

	public void setIsMan(String isMan) {
		this.isMan = isMan;
	}
}
