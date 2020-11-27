package model.vo;

public class BoardVO {//자유게시판 vo
	private String id;//자유게시판은 일반회원이상 글쓰기 가능 글쓴 회원의 id
	private String grade;//글쓴사람등급
	private String b_subject;//자유게시판 제목
	private String b_contents;//자유게시판 내용
	private String b_regdate;//자유게시판 글등록날짜
	private int b_cnt;//글 조회수
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
	public String getB_subject() {
		return b_subject;
	}
	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}
	public String getB_contents() {
		return b_contents;
	}
	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}
	public String getB_regdate() {
		return b_regdate;
	}
	public void setB_regdate(String b_regdate) {
		this.b_regdate = b_regdate;
	}
	public int getB_cnt() {
		return b_cnt;
	}
	public void setB_cnt(int b_cnt) {
		this.b_cnt = b_cnt;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
}
