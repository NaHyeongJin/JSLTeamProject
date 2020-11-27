package model.vo;

public class NoticeVO {//공지사항
	private String id;//공시사항은 관리자회원만 관리가능
	private String grade;//관리자등급
	private String n_subject;//공지사항 제목
	private String n_contents;//공지사항 내용
	private String n_regdate;//공지사항 글등록날짜
	private int n_cnt;//글 조회수
	private int idx;//글 번호
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getN_subject() {
		return n_subject;
	}
	public void setN_subject(String n_subject) {
		this.n_subject = n_subject;
	}
	public String getN_contents() {
		return n_contents;
	}
	public void setN_contents(String n_contents) {
		this.n_contents = n_contents;
	}
	public String getN_regdate() {
		return n_regdate;
	}
	public void setN_regdate(String n_regdate) {
		this.n_regdate = n_regdate;
	}
	public int getN_cnt() {
		return n_cnt;
	}
	public void setN_cnt(int n_cnt) {
		this.n_cnt = n_cnt;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
}
