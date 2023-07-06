def solution(new_id):
    # 아이디 추천
    # 아이디 규칙
        # 3~15자 길이
        # 알파벳 소문자, 숫자, -, _, . 등 의 문자 가능
        # 처음과 끝은 .을 사용할 수 없으며 또한 연속으로 사용 불가
        
    # 치환단계
    # 1. 대문자 -> 소문자
    # 2. 알파벳 소문자, 숫자, -, _, .을 제외한 문자 제거
    # 3. .가 2번 이상 연속된 부분을 하나의 마침표로 치환
    # 4. 처음과 끝에 .이 있다면 제거
    # 5. 빈 문자열이라면 a 대입
    # 6. 길이가 16이상이라면 첫 15개를 제외한 문제 제거 (단, 이후 발생한 .가 있다면 추가 제거)
    # 7. 길이가 2자 이하면 마지막 문자를 길이가 3이 될때까지 반복해서 복사
    
    import re
    
    new_id = new_id.lower() # 1번
    
    new_id = re.sub(r'[^a-z0-9-_.]', '', new_id) # 2번
    
    new_id = re.sub(r'\.{2,}', '.', new_id) # 3번

    new_id = re.sub(r'\.$', '', new_id)
    new_id = re.sub(r'^\.', '', new_id) # 4번
    
    new_id = re.sub(r'^$', 'a', new_id) # 5번
    
    new_id = new_id[:15] if len(new_id)>=16 else new_id # 6번
    new_id = re.sub(r'\.$', '', new_id)
    
    while len(new_id)<=2: new_id += new_id[-1] # 7번
    
    return new_id