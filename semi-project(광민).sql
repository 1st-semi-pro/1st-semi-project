------------------------------------------------MEMBER 테이블-----------------------------------------------------------
CREATE TABLE "MEMBER" (
   "MEMBER_NO"   NUMBER      PRIMARY KEY,
   "MEMBER_ID"   VARCHAR2(50)      NOT NULL,
   "MEMBER_PW"   VARCHAR2(200)      NOT NULL,
   "MEMBER_EMAIL"   VARCHAR2(50)      NOT NULL,
   "MEMBER_NICKNAME"   VARCHAR2(50)      NOT NULL,
   "MEMBER_NAME"   VARCHAR2(20)      NOT NULL,
   "MEMBER_BIRTH"   VARCHAR2(8)      NOT NULL,
   "MEMBER_REGION"   VARCHAR2(50)      NOT NULL,
   "MEMBER_GENDER"   CHAR(3)      NOT NULL,
   "MEMBER_NT"   VARCHAR(10)   DEFAULT 'KOR'   NOT NULL,
   "MEMBER_PHONE"   VARCHAR(20)      NOT NULL,
   "ENROLL_DT"   DATE   DEFAULT SYSDATE   NOT NULL,
   "ADMIN_FL"   CHAR(1)   DEFAULT 'N'   NOT NULL,
   "SECESSION_FL"   CHAR(1)   DEFAULT 'N'   NOT NULL,
   "MEMBER_PROFILE"   VARCHAR2(4000)      NULL,
   "MEMBER_MESSAGE"   VARCHAR2(400)      NULL
);
COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원번호(시퀀스)';

COMMENT ON COLUMN "MEMBER"."MEMBER_ID" IS '회원 아이디';

COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '회원 비밀번호';

COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '회원 이메일';

COMMENT ON COLUMN "MEMBER"."MEMBER_NICKNAME" IS '회원 닉네임';

COMMENT ON COLUMN "MEMBER"."MEMBER_NAME" IS '회원 이름';

COMMENT ON COLUMN "MEMBER"."MEMBER_BIRTH" IS '회원 생년월일';

COMMENT ON COLUMN "MEMBER"."MEMBER_REGION" IS '회원 활동 지역';

COMMENT ON COLUMN "MEMBER"."MEMBER_GENDER" IS '회원 성별';

COMMENT ON COLUMN "MEMBER"."MEMBER_NT" IS '내국인/외국인';

COMMENT ON COLUMN "MEMBER"."MEMBER_PHONE" IS '휴대폰 번호';

COMMENT ON COLUMN "MEMBER"."ENROLL_DT" IS '가입일';

COMMENT ON COLUMN "MEMBER"."ADMIN_FL" IS '관리자 권한';

COMMENT ON COLUMN "MEMBER"."SECESSION_FL" IS '탈퇴여부';

COMMENT ON COLUMN "MEMBER"."MEMBER_PROFILE" IS '회원 이미지파일';

COMMENT ON COLUMN "MEMBER"."MEMBER_MESSAGE" IS '프로필 메시지';

-- DROP SEQUENCE SEQ_MEMBER_NO;

CREATE SEQUENCE SEQ_MEMBER_NO INCREMENT BY 1;

INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL, '1', '1', 'testemail', 'testnick', 'testname', '19971030', '서울', '남', DEFAULT, '01033339999', DEFAULT, DEFAULT, DEFAULT, NULL, NULL);
-- INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, TO_DATE(?, 'YYYYMMDD'), ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT, NULL, NULL);
------------------------------------------------BOARD-TYPE 테이블-----------------------------------------------------------

-- 게시판 종류 

-- DROP TABLE "BOARD_TYPE";

CREATE TABLE "BOARD_TYPE" (
   "BOARD_CD"   NUMBER      PRIMARY KEY,
   "BOARD_NM"   VARCHAR2(50)      NOT NULL
);

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_CD" IS '게시판 코드';
COMMENT ON COLUMN "BOARD_TYPE"."BOARD_NM" IS '게시판 이름';

-- BOARD_TYPE 데이터 삽입
INSERT INTO BOARD_TYPE VALUES(1,'공지사항');
INSERT INTO BOARD_TYPE VALUES(2,'자유 게시판');
INSERT INTO BOARD_TYPE VALUES(3,'축제후기 게시판');
INSERT INTO BOARD_TYPE VALUES(4,'축제정보');
INSERT INTO BOARD_TYPE VALUES(5,'동행자구하기 게시판 ');

------------------------------------------------BOARD 테이블---------------------------------------------------------------
-- 게시판 (게시글 저장 테이블)
-- DROP TABLE "BOARD";

CREATE TABLE "BOARD" (
   "BOARD_NO"   NUMBER      NOT NULL,
   "BOARD_TITLE"   VARCHAR2(150)      NOT NULL,
   "BOARD_CONTENT"   VARCHAR2(4000)      NOT NULL,
   "CREATE_DT"   DATE   DEFAULT SYSDATE   NOT NULL,
   "UPDATE_DT"   DATE      NULL,
   "READ_COUNT"   NUMBER   DEFAULT 0   NOT NULL,
   "BOARD_ST"   CHAR(1)   DEFAULT 'N'   NOT NULL,
   "MEMBER_NO"   NUMBER      NOT NULL,
   "BOARD_CD"   NUMBER      NOT NULL
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글번호(시퀀스)';
COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글제목';
COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글내용';
COMMENT ON COLUMN "BOARD"."CREATE_DT" IS '작성일';
COMMENT ON COLUMN "BOARD"."UPDATE_DT" IS '마지막수정일';
COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';
COMMENT ON COLUMN "BOARD"."BOARD_ST" IS '게시글상태(정상N,삭제Y)';
COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '작성자 회원 번호';
COMMENT ON COLUMN "BOARD"."BOARD_CD" IS '게시판 코드';

-- BOARD 테이블 제약조건 추가
ALTER TABLE BOARD
ADD PRIMARY KEY(BOARD_NO); -- 제약조건명 생략(SYS_XXXX)

ALTER TABLE BOARD
ADD CONSTRAINT "FK_BOARD_CD1" -- 제약 조건명 지정
FOREIGN KEY("BOARD_CD") -- BOARD의 BOARD_CODE 컬럼에 FK 지정
REFERENCES "BOARD_TYPE"; -- 참조할 테이블

ALTER TABLE BOARD
ADD CONSTRAINT "CHK_BOARD_ST"
CHECK("BOARD_ST" IN('N','Y'));

ALTER TABLE BOARD
ADD CONSTRAINT "FK_BOARD_MEMBER"
FOREIGN KEY("MEMBER_NO")
REFERENCES MEMBER;

-- BOARD_NO용 시퀀스
CREATE SEQUENCE SEQ_BOARD_NO
       INCREMENT BY 1 -- 증가값
       START WITH 1 -- 시작값
       MINVALUE 1; -- 최솟값
    
-- BOARD 테이블 샘플 데이터 삽입(PL / SQL)
BEGIN
    FOR I IN 1..500 LOOP
        
        INSERT INTO BOARD
        VALUES(SEQ_BOARD_NO.NEXTVAL,
               SEQ_BOARD_NO.CURRVAL || '번째 게시글',
               SEQ_BOARD_NO.CURRVAL || '번째 게시글 내용입니다.',
               DEFAULT,DEFAULT,DEFAULT,DEFAULT,1,2
               
        );
        
    END LOOP;
END;
/

------------------------------------------------INFO-BOARD 축제 테이블------------------------------------------------
-- 게시판 (게시글 저장 테이블)
-- DROP TABLE "INFO_BOARD";

CREATE TABLE "INFO_BOARD" (
   "FESTIVAL_NO"   NUMBER      NOT NULL,
   "FESTIVAL_TITLE"   VARCHAR2(200)      NOT NULL,
   "FESTIVAL_CT"   VARCHAR2(4000)      NOT NULL,
   "FESTIVAL_DT"   VARCHAR2(300)      NULL,
   "READ_COUNT"   NUMBER   DEFAULT 0   NOT NULL,
   "FESTIVAL_AREA" VARCHAR2(100) DEFAULT '-' NOT NULL,
   "FESTIVAL_CAT" VARCHAR2(100) DEFAULT '-' NOT NULL,
   "BOARD_CD"   NUMBER      NOT NULL
);

COMMENT ON COLUMN "INFO_BOARD"."FESTIVAL_NO" IS '축제번호(시퀀스)';
COMMENT ON COLUMN "INFO_BOARD"."FESTIVAL_TITLE" IS '축제제목';
COMMENT ON COLUMN "INFO_BOARD"."FESTIVAL_CT" IS '축제내용';
COMMENT ON COLUMN "INFO_BOARD"."FESTIVAL_DT" IS '축제날짜';
COMMENT ON COLUMN "INFO_BOARD"."FESTIVAL_AREA" IS '축제지역';
COMMENT ON COLUMN "INFO_BOARD"."FESTIVAL_CAT" IS '축제카테고리';
COMMENT ON COLUMN "INFO_BOARD"."READ_COUNT" IS '조회수';
COMMENT ON COLUMN "INFO_BOARD"."BOARD_CD" IS '게시판 코드';

-- BOARD 테이블 제약조건 추가
ALTER TABLE INFO_BOARD
ADD PRIMARY KEY(FESTIVAL_NO); -- 제약조건명 생략(SYS_XXXX)

ALTER TABLE INFO_BOARD
ADD CONSTRAINT "FK_BOARD_CD" -- 제약 조건명 지정
FOREIGN KEY("BOARD_CD") -- BOARD의 BOARD_CODE 컬럼에 FK 지정
REFERENCES "BOARD_TYPE"; -- 참조할 테이블

-- INFO_BOARD_NO용 시퀀스
CREATE SEQUENCE SEQ_FESTIVAL_NO
       INCREMENT BY 1 -- 증가값
       START WITH 1 -- 시작값
       MINVALUE 1; -- 최솟값
       
-- INFO-BOARD 테이블 샘플 데이터 삽입(PL / SQL)

--BEGIN
--    FOR I IN 1..180 LOOP
        
--        INSERT INTO INFO_BOARD
--       VALUES(SEQ_FESTIVAL_NO.NEXTVAL,
--               SEQ_FESTIVAL_NO.CURRVAL || '번째 제목',
--               SEQ_FESTIVAL_NO.CURRVAL || '번째 게시글 내용입니다.',
--               DEFAULT,DEFAULT,4
--        );
        
--    END LOOP;
--END;
-- /

------------------------------------------------축제 이미지 테이블 ---------------------------------------------------
CREATE TABLE FESTIVAL_IMG(
    IMG_NO NUMBER NOT NULL,
    IMG_RENAME VARCHAR2(500) NOT NULL,
    IMG_LEVEL NUMBER NOT NULL
);

COMMENT ON COLUMN "FESTIVAL_IMG"."IMG_NO" IS '이미지(축제) 번호';
COMMENT ON COLUMN "FESTIVAL_IMG"."IMG_RENAME" IS '이미지 저장 경로 + 변경명';
COMMENT ON COLUMN "FESTIVAL_IMG"."IMG_LEVEL" IS '이미지위치 저장 번호';

-- 이미지 번호 시퀀스 생성
CREATE SEQUENCE SEQ_IMG_NO NOCACHE;

ALTER TABLE "FESTIVAL_IMG"
ADD CONSTRAINT "FK_FESTIVAL_IMG" -- 제약 조건명 지정
FOREIGN KEY("IMG_NO") -- BOARD의 BOARD_CODE 컬럼에 FK 지정
REFERENCES "INFO_BOARD"; -- 참조

--BEGIN
--    FOR I IN 1..180 LOOP
        
--       INSERT INTO FESTIVAL_IMG
--        VALUES(SEQ_IMG_NO.NEXTVAL,
--               '/resources/images/board/test.png',
--               0
--        );
        
--    END LOOP;
--END;
--/

-------------------------------------축제상세검색 테이블---------------------
-- DROP TABLE "FESTIVAL_DETAIL";
CREATE TABLE "FESTIVAL_DETAIL" (
   "FESTIVAL_NO"   NUMBER      NOT NULL,
   "FESTIVAL_CONTENT"   VARCHAR2(2000)      NOT NULL,
   "FESTIVAL_DETAILINFO"   VARCHAR2(500)      NOT NULL

);

COMMENT ON COLUMN "FESTIVAL_DETAIL"."FESTIVAL_NO" IS '축제번호';

COMMENT ON COLUMN "FESTIVAL_DETAIL"."FESTIVAL_CONTENT" IS '축제 상세설명';

COMMENT ON COLUMN "FESTIVAL_DETAIL"."FESTIVAL_DETAILINFO" IS '축제 상세정보';

CREATE SEQUENCE SEQ_FESTIVALDETAIL_NO
       INCREMENT BY 1 -- 증가값
       START WITH 1 -- 시작값
       MINVALUE 1; -- 최솟값

BEGIN
    FOR I IN 1..180 LOOP
        
       INSERT INTO FESTIVAL_DETAIL
        VALUES(SEQ_FESTIVALDETAIL_NO.NEXTVAL,
              '해당 축제 상세내용',
               ' 해당 축제 상세정보.'
       );
        
   END LOOP;
 END;      
/

ALTER TABLE "FESTIVAL_DETAIL"
ADD CONSTRAINT "FK_FESTIVAL_DETAIL" -- 제약 조건명 지정
FOREIGN KEY("FESTIVAL_NO") -- BOARD의 BOARD_CODE 컬럼에 FK 지정
REFERENCES "INFO_BOARD"; -- 참조할 테이블
----------------------------------------댓글 테이블-------------------------------------------
-- DROP TABLE "REPLY";

CREATE TABLE "REPLY" (
   "REPLY_NO"   NUMBER      NOT NULL,
   "REPLY_CT"   VARCHAR2(200)      NOT NULL,
   "REPLY_TI"   DATE      NOT NULL,
   "REPLY_MD"   DATE      NOT NULL,
    "REPLY_ST" VARCHAR(1) DEFAULT 'N' NOT NULL,
   "BOARD_NO"   NUMBER      NOT NULL,
   "MEMBER_NO"   NUMBER      NOT NULL
);

COMMENT ON COLUMN "REPLY"."REPLY_NO" IS '댓글번호(시퀀스)';

COMMENT ON COLUMN "REPLY"."REPLY_CT" IS '댓글내용';

COMMENT ON COLUMN "REPLY"."REPLY_TI" IS '댓글작성시간';

COMMENT ON COLUMN "REPLY"."REPLY_MD" IS '댓글수정시간';

COMMENT ON COLUMN "REPLY"."REPLY_ST" IS '댓글 삭제 여부(N,Y)';

COMMENT ON COLUMN "REPLY"."BOARD_NO" IS '게시글번호(시퀀스)';

COMMENT ON COLUMN "REPLY"."MEMBER_NO" IS '회원번호(시퀀스)';

ALTER TABLE "REPLY"
ADD CONSTRAINT "REPLY_BOARD_NO" 
FOREIGN KEY("BOARD_NO")
REFERENCES "BOARD";

ALTER TABLE "REPLY"
ADD CONSTRAINT "REPLY_MEMBER_NO" 
FOREIGN KEY("MEMBER_NO")
REFERENCES "MEMBER";

ALTER TABLE "REPLY"
ADD CONSTRAINT "CHK_REPLY_ST"
CHECK("REPLY_ST" IN('N','Y'));

--DROP SEQUENCE SEQ_REPLY_NO;

CREATE SEQUENCE SEQ_REPLY_NO
       INCREMENT BY 1 -- 증가값
       START WITH 1 -- 시작값
       MINVALUE 1; -- 최솟값
--INSERT INTO REPLY VALUES(SEQ_REPLY_NO.NEXTVAL, ?, sysdate, sysdate, default, ?, ?);

------------------------------------------------------ 보드 이미지 테이블 -------------------------------------------------
--DROP TABLE BOARD_IMG;

CREATE TABLE "BOARD_IMG" (
   "IMG_NO"   NUMBER      PRIMARY KEY,
   "IMG_LEVEL"   NUMBER      NULL,
   "IMG_RENAME"   VARCHAR(200)      NULL,
   "IMG_ORIGINAL"   VARCHAR(200)      NULL,
   "BOARD_NO"   NUMBER      NOT NULL
);

COMMENT ON COLUMN "BOARD_IMG"."IMG_NO" IS '이미지 번호';

COMMENT ON COLUMN "BOARD_IMG"."IMG_LEVEL" IS '이미지 레벨';

COMMENT ON COLUMN "BOARD_IMG"."IMG_RENAME" IS '이미지 경로 및 이름';

COMMENT ON COLUMN "BOARD_IMG"."IMG_ORIGINAL" IS '이미지 원래 이름';

COMMENT ON COLUMN "BOARD_IMG"."BOARD_NO" IS '게시글번호(시퀀스)';

CREATE SEQUENCE SEQ_BOARDIMG_NO
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1; 
       
      -- DROP SEQUENCE SEQ_BOARDIMG_NO;

ALTER TABLE "BOARD_IMG"
ADD CONSTRAINT "FK_BOARD_IMG"
FOREIGN KEY("BOARD_NO")
REFERENCES "BOARD";

-----------------------------------------------------------------찜하기 테이블 ---------------------------------------------------------------------------
CREATE TABLE "DIB" (
   "MEMBER_NO"   NUMBER      NOT NULL,
   "FESTIVAL_NO"   NUMBER      NOT NULL
);


ALTER TABLE "DIB"
ADD CONSTRAINT "FK_DIB_MEMEBERNO"
FOREIGN KEY("MEMBER_NO")
REFERENCES "MEMBER";

ALTER TABLE "DIB"
ADD CONSTRAINT "FK_DIB_FESTIVALNO"
FOREIGN KEY("FESTIVAL_NO")
REFERENCES "INFO_BOARD";

COMMENT ON COLUMN "DIB"."MEMBER_NO" IS '회원번호(시퀀스)';

COMMENT ON COLUMN "DIB"."FESTIVAL_NO" IS '축제번호';

-- MEMBER_NO로 찜한 축제의 이미지 불러오기
SELECT IMG_RENAME
FROM MEMBER
JOIN DIB USING (MEMBER_NO)
JOIN INFO_BOARD USING(FESTIVAL_NO)
JOIN FESTIVAL_IMG ON(FESTIVAL_NO = IMG_NO)
WHERE MEMBER_NO = ? AND IMG_LEVEL = 0;

--------------------------------------------------------------------------------------------------------------------------------
COMMIT;


















































-- 축제 갯수조회

SELECT * FROM(
    SELECT ROWNUM RNUM, A.* FROM(
        SELECT FESTIVAL_NO, FESTIVAL_TITLE, FESTIVAL_CT, 
              FESTIVAL_DT,READ_COUNT FROM INFO_BOARD
        WHERE BOARD_CD = 4
        ORDER BY FESTIVAL_NO DESC
    ) A
)
WHERE RNUM BETWEEN 1 AND 30;

-- 축제 일순 갯수 조회
SELECT FESTIVAL_DT FROM INFO_BOARD;

-- 축제일순 조회
SELECT * FROM(
    SELECT ROWNUM RNUM, A.* FROM(
        SELECT FESTIVAL_NO, FESTIVAL_TITLE, FESTIVAL_CT, 
              FESTIVAL_DT,READ_COUNT FROM INFO_BOARD
        ORDER BY FESTIVAL_DT
    ) A
)
WHERE RNUM BETWEEN 1 AND 30;


UPDATE INFO_BOARD SET
BOARD_CD ='1';

UPDATE INFO_BOARD SET
BOARD_CD ='1'
WHERE BOARD_CD ='4'
AND FESTIVAL_NO BETWEEN 1 AND 180;

COMMIT;

SELECT READ_COUNT FROM INFO_BOARD
WHERE READ_COUNT !='0';

SELECT * FROM(
    SELECT ROWNUM RNUM, A.* FROM(
        SELECT FESTIVAL_NO, FESTIVAL_TITLE, FESTIVAL_CT, 
              FESTIVAL_DT,READ_COUNT FROM INFO_BOARD
        WHERE READ_COUNT !='0'
        ORDER BY READ_COUNT DESC
    ) A
);

SELECT FESTIVAL_DT FROM INFO_BOARD;


SELECT * FROM(
    SELECT ROWNUM RNUM, A.* FROM(
        SELECT FESTIVAL_NO, FESTIVAL_TITLE, FESTIVAL_CT, 
              FESTIVAL_DT,READ_COUNT FROM INFO_BOARD
        WHERE BOARD_CD = 1
        AND FESTIVAL_DT LIKE '%01%'
        ORDER BY FESTIVAL_DT
    ) A
)
	WHERE RNUM BETWEEN ? AND ? ;
            
SELECT COUNT(*) FROM INFO_BOARD
			WHERE BOARD_CD = 1
AND FESTIVAL_AREA LIKE '%서울특별시%';

SELECT READ_COUNT FROM INFO_BOARD
    WHERE READ_COUNT !='0'
    AND FESTIVAL_DT LIKE '_____01%'
    AND FESTIVAL_AREA LIKE '%서울특별시%';

SELECT * FROM FESTIVAL_IMG
   WHERE IMG_NO BETWEEN 1 AND 180 
   ORDER BY IMG_LEVEL;
