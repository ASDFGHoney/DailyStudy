# 로그인 재밌다아ㅏㅏㅏ~~~~~~

info = {
    "id": "aaaa",
    "pw": "aaaaa"
}

i = 0
while i < 5:
    print("************************************************")
    print("***********          LOGIN           ***********")
    print("************************************************")
    id_ = input("----> ID : ")
    pw_ = input("----> PW : ")

    if id_ == info["id"] and pw_ == info["pw"]:
        print("\n👍👍👍로그인 성공👍👍👍\n")
        break
    else:
        print("\n😅😅😅로그인 실패😅😅😅\n")
    i = i+1

if i == 5:
    print("**계정 잠김ㅠㅠ**")
