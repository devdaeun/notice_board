## Todo List
- 게시글 구현
  - [X] 게시글 entity 작성(제목,내용,작성일,수정일,삭제여부)
  - [X] 게시글 entity 데이터베이스 연동(docker로 구현한 postgresSql과의 연결)
  - [X] 게시글 작성 API 구현 (POST) / 제목,내용 필수항목, 작성일자 자동기록
  - [X] 게시글 수정 API 구현 (PUT) / 제목,내용 수정가능, 수정일자 자동기록
    - [X] 수정하고자 하는 게시글이 존재하는지 확인
    - [X] 존재하지 않는경우 예외처리
    - [X] 존재하는경우 수정할 게시글의 내용 업데이트
  - [X] 게시글 단건 조회 API 구현 (GET) / 게시글에 포함된 모든 댓글 목록 조회, 삭제데이터 조회불가능
    - [X] 삭제된 게시글을 조회하는경우 예외처리
    - [X] 게시글 조회 시 함께 조회되는 댓글목록 페이징 처리 (10 고정 10/30/50 순)
  - [X] 게시글 삭제 API 구현 (DELETE) / 삭제시 게시글의 댓글로 삭제처리, 복구불가능, softDelete 표현
    - [X] 게시글 삭제 시 연결된 댓글도 전부 삭제되도록 구현.

- 댓글 구현
  - [X] 댓글 entity 구현
  - [X] 댓글 작성 API 구현 / 댓글내용 필수항목 등록일자 자동기록
    - [X] 게시글 번호에 맞추어 댓글 작성진행
    - [X] 게시글이 존재하는지 확인, 존재하지않는경우 예외처리
  - [X] 댓글 수정 API 구현
    - [X] 댓글이 존재하는지 확인
  - [X] 댓글 조회 API 구현
  - [X] 댓글 삭제 API 구현
    - [X] 삭제 후 조회,수정,다시삭제 불가능하도록 설정

## 어려운거
- 페이징 설정이 조금 어려웠다.