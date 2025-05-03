import random
import time


def current_milli_time():
    return int(round(time.time() * 1000))

def add_to_end(value):
    a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    i = 1
    while i < value:
        a.insert(0, random.randint(1, 99))
        i += 1


print(40*"-", "\n")
value = 1000
print(f"Добавляем {value} элементов в начало списка:")
start_time = current_milli_time()
add_to_end(value)
end_time = current_milli_time()
print("Время выполнения: ", end_time - start_time, " ms\n")
print(40*"-", "\n")

value = 10_000
print(f"Добавляем {value} элементов в начало списка:")
start_time = current_milli_time()
add_to_end(value)
end_time = current_milli_time()
print("Время выполнения: ", end_time - start_time, " ms\n")
print(40*"-", "\n")

value = 100_000
print(f"Добавляем {value} элементов в начало списка:")
start_time = current_milli_time()
add_to_end(value)
end_time = current_milli_time()
print("Время выполнения: ", end_time - start_time, " ms\n")
print(40*"-", "\n")

value = 1_000_000
print(f"Добавляем {value} элементов в начало списка:")
start_time = current_milli_time()
add_to_end(value)
end_time = current_milli_time()
print("Время выполнения: ", end_time - start_time, " ms\n")
print(40*"-", "\n")
