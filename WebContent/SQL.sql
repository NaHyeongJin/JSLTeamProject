CREATE TABLE tbl_client (
	pw	varchar2(12)		NOT NULL,
	id	varchar2(20)		NOT NULL PRIMARY key,
	grade	char(1)		NOT NULL,
	name	varchar(10)		NOT NULL,
	email	varchar2(20)		NULL,
	email2	varchar2(20)		NULL,
	tel1	number(3)		NULL,
	tel2	number(4)		NULL,
	tel3	number(4)		NULL,
	regdate	date	DEFAULT sysdate	NULL,
	gender	char(1)		NOT NULL
   
);
COMMENT ON COLUMN "tbl_client"."id" IS 'primary key';

CREATE TABLE board (
	b_id	varchar2(20)		NOT NULL,
	b_grade	char(1)		NOT NULL,
	b_subject	varchar2(100)		NULL,
	b_contents	varchar2(200)		NULL,
	b_regdate	date	DEFAULT sysdate	NULL,
	b_cnt	number(5)	DEFAULT 0	NULL,
	b_idx	number(5)		NULL,
     CONSTRAINT BOARD_FK1 FOREIGN KEY (b_id)REFERENCES tbl_client(id) on DELETE CASCADE
);

create SEQUENCE tbl_board_seq_bidx 
start with 0 increment by 1; --자유게시판 글 시퀀스

COMMENT ON COLUMN "board"."grade" IS '외래키';

CREATE TABLE notice (
	n_id	varchar2(20)		NOT NULL,
	n_grade	char(1)		NOT NULL,
	n_subject	varchar2(100)		NULL,
	n_contents	varchar2(200)		NULL,
	n_regdate	date	DEFAULT sysdate	NULL,
	n_cnt	number(5)		NULL,
	n_idx	number(5)		NULL,
     CONSTRAINT FK_notice FOREIGN KEY (n_id)REFERENCES tbl_client(id) on DELETE CASCADE
);
create SEQUENCE tbl_notice_seq_nidx 
start with 0 increment by 1; --공지사항 글 시퀀스

COMMENT ON COLUMN "notice"."grade" IS '외래키';

CREATE TABLE qna (
	q_pw	varchar2(12)		NOT NULL,
	q_id	varchar2(20)		NOT NULL,
	q_grade	char(1)		NOT NULL,
	q_subject	varchar2(100)		NULL,
	q_contetns	varchar2(200)		NULL,
	q_a	varchar2(200)		NULL,
	q_regdate	date	DEFAULT sysdate	NULL,
	a_cnt number(5) NULL,
	q_cnt number(5) NULL,
	q_idx	number(5)		NULL,
	
     CONSTRAINT QNA_FK1 FOREIGN KEY (q_id)REFERENCES tbl_client(id) on DELETE CASCADE
);

create SEQUENCE tbl_qna_seq_qidx 
start with 0 increment by 1; --질문 답변 글 시퀀스



COMMENT ON COLUMN "qna"."grade" IS '외래키';

CREATE TABLE room (
	r_id	varchar2(20)		NOT NULL,
	r_grade	char(1)		NOT NULL,
	r_subject	varchar2(100)		NULL,
	r_cotents	varchar2(200)		NULL,
	r_regdate	date	DEFAULT sysdate	NULL,
	r_cnt	number(5)DEFAULT 0	NULL,
	r_filename	varchar2(100)		NULL,
	r_idx	number(5)		NULL,
     CONSTRAINT Room_FK1 FOREIGN KEY (r_id)REFERENCES tbl_client(id) on DELETE CASCADE
);
create SEQUENCE tbl_room_seq_ridx 
start with 0 increment by 1; --자료실 글 시퀀스

COMMENT ON COLUMN "room"."grade" IS '외래키';


