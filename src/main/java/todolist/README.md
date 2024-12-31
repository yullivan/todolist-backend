# API
## 리스트 생성
POST /lists

## 리스트 목록 조회
GET /lists
```
My Lists
- Reminders (18)
- 구매할 상품 (16)
- 개발 (15)
- 휴지통 (39)
```
```json
[
  {
    "listId": 3,
    "title": "구매",
    "numOfTasks": 16
  },
  {
    "listId": 3,
    "title": "개발",
    "numOfTasks": 15
  }
]
```

## 리스트 수정
PUT lists/{listId}
## 리스트 삭제
DELETE lists/{listId}