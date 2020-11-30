package model.vo;

public class QnaVO {//질문과답변 게시판
	private String id;//질문과답변은 모든회원 글쓰기 가능 글쓴 회원의 id
	private String pw;//글을쓰는사람은 비밀번호를등록하여 비밀번호를 글확인
	private String grade;//글쓴사람등급
	private String q_subject;//질문 제목
	private String q_contents;//질문 내용
	private String q_regdate;//자유게시판 글등록날짜
	private String q_a;//질문글의 답변
	private int q_idx;//글 번호
	private int a_cnt;//글 조회수
	private int q_cnt;//답글 조회수
	public int getQ_cnt() {
		return q_cnt;
	}
	public void setQ_cnt(int q_cnt) {
		this.q_cnt = q_cnt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getQ_subject() {
		return q_subject;
	}
	public void setQ_subject(String q_subject) {
		this.q_subject = q_subject;
	}
	public String getQ_contents() {
		return q_contents;
	}
	public void setQ_contents(String q_contents) {
		this.q_contents = q_contents;
	}
	public String getQ_regdate() {
		return q_regdate;
	}
	public void setQ_regdate(String q_regdate) {
		this.q_regdate = q_regdate;
	}
	public String getQ_a() {
		return q_a;
	}
	public void setQ_a(String q_a) {
		this.q_a = q_a;
	}
	public int getQ_idx() {
		return q_idx;
	}
	public void setQ_idx(int q_idx) {
		this.q_idx = q_idx;
	}
	public int getA_cnt() {
		return a_cnt;
	}
	public void setA_cnt(int a_cnt) {
		this.a_cnt = a_cnt;
	}
	
}
