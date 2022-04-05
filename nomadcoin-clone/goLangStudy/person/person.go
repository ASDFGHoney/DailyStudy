// person/person.go
package person

import "fmt"

type Person struct {
	name string
	age  int
}

func (p *Person) SetDetail(name string, age int) {
	p.name = name
	p.age = age
	fmt.Println("SetDetails' nico : ", *p)
}

func (p Person) Name() string {
	return p.name
}
