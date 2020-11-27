package model.vo;

public class NoticeVO {//공지사항
	private String id;//공시사항은 관리자회원만 관리가능
	private String grade;//관리자등급
	private String n_subject;//공지사항 제목
	private String n_contents;//공지사항 내용
	private String n_regdate;//공지사항 글등록날짜
	private int n_cnt;//글 조회수
	private int idx;//글 번호
}
