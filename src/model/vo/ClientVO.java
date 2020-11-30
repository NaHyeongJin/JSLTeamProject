package model.vo;

public class ClientVO {
	private String grade;//회원 등급 A=관리자 B=일반회원 C=비회원으로 분류
	private String pw;//회원 비밀번호
	private String id;//회원 아이디 유니큐키
	private String name;//회원 이름
	private String email;//회원 이메일 아이디
	private String email2;//회원 이메일 도메인 (naver,google)
	private String regdate;//가입날짜 db기본값 오늘날짜(sysdate)
	private String gender;//성별 M(남자),F(여자)
	private int tel1,tel2,tel3;//010-xxxx-xxxx 전화번호
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getTel1() {
		return tel1;
	}
	public void setTel1(int tel1) {
		this.tel1 = tel1;
	}
	public int getTel2() {
		return tel2;
	}
	public void setTel2(int tel2) {
		this.tel2 = tel2;
	}
	public int getTel3() {
		return tel3;
	}
	public void setTel3(int tel3) {
		this.tel3 = tel3;
	}

}