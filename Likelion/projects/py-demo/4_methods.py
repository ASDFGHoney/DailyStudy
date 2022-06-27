

def print_hello_world():
    print("hello world")


def say_hello(name):
    print(f"hello,{name} !")


say_hello("송치헌")
print_hello_world()


def read_athlete_data(athlete):
    print(athlete["name"])
    print(athlete["age"])


athlete_oh = {
    "name": "오진혁",
    "age": "20",
}

read_athlete_data(athlete_oh)


def is_leap_year(year):
    result = False
    if year % 4 == 0:
        if year % 100 == 0 and year % 400 != 0:
            result = False
        else:
            result = True
    else:
        result = False

    return result


print(is_leap_year(2016))

print(is_leap_year(2022))

print(is_leap_year(2024))


def can_group(limit, people):
    if not isinstance(people, list):
        return False
    group_count = 0
    for person in people:
        if not isinstance(person, dict):
            group_count += 1
            continue

        if "vaccinated" in person.keys() and person.get("vaccinated"):
            continue
        else:
            group_count = group_count + 1
    return group_count < limit


def calculate_age(name, born_year, current_year=2022):
    print(f"Hello {name}! you are {current_year - born_year+1} years older")


calculate_age("chihoney", 1997)
calculate_age("chihoney", 1997, 2011)
