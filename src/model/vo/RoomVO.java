package model.vo;

public class RoomVO {//자료실
	private String id;//자료실 등록한 회원의 id
	private String grade;//글쓴 사람의 등급
	private String r_subject;//자료실 제목
	private String r_contents;//자료실 내용
	private String r_regdate;//자료실 글등록날짜
	private String r_filename;//자료실에등록된 파일이름
	private int r_cnt;//글 조회수
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
	public String getR_subject() {
		return r_subject;
	}
	public void setR_subject(String r_subject) {
		this.r_subject = r_subject;
	}
	public String getR_contents() {
		return r_contents;
	}
	public void setR_contents(String r_contents) {
		this.r_contents = r_contents;
	}
	public String getR_regdate() {
		return r_regdate;
	}
	public void setR_regdate(String r_regdate) {
		this.r_regdate = r_regdate;
	}
	public String getR_filename() {
		return r_filename;
	}
	public void setR_filename(String r_filename) {
		this.r_filename = r_filename;
	}
	public int getR_cnt() {
		return r_cnt;
	}
	public void setR_cnt(int r_cnt) {
		this.r_cnt = r_cnt;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
}
