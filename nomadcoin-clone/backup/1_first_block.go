package backup

import (
	"crypto/sha256"
	"fmt"
)

type block struct {
	data     string
	hash     string // 해쉬는 단방향이다.
	prevHash string
}

func main1() {
	genesisBlock := block{"Genesis Block", "", ""}

	hash := sha256.Sum256([]byte(genesisBlock.data + genesisBlock.prevHash))
	// SHA256은 많은 블록체인에서 사용하는 해쉬 함수
	// go에는 이미 구현이 되어 있다. 하지만 sha256.Sum256함수는 []byte형태로만 받음 string 안됨
	hexHash := fmt.Sprintf("%x", hash)
	// 보통 블록체인 브라우저에 가보면 해쉬는 16진수로 되어 있기 때문에 sprintf를 이용해 변환
	genesisBlock.hash = hexHash // 대입
	fmt.Println(genesisBlock)
}
