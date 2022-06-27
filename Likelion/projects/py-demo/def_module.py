

def print_hello_world():
    print("hello world")


class Car:
    count = 0

    def __init__(self, name, color, fuel):
        self.name = name
        self.color = color
        self.fuel = fuel
        Car.count += 1

    def __init__(self, color, fuel):
        self.name = "kan"
        self.color = color
        Car.count += 1
        self.fuel = fuel

    def drive(self):
        print(f"{self.name} {self.color} {self.fuel}")

    # self print built-in function
    def __str__(self):
        return str(Car.count)


sonata = Car("소나타", "은색", "휘발유")
sonat1a = Car("은색", "휘발유")
print(sonata)
sonata2 = Car("은색", "휘발유")
sonata3 = Car("은색", "휘발유")

sonata.drive()

print(Car.count)
