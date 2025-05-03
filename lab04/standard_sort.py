import random
import time


def current_milli_time():
    return int(round(time.time() * 1000))


def generate_random_list(size, min_val=0, max_val=100):
    return [random.randint(min_val, max_val) for _ in range(size)]


def standard_sort(arr):
    return arr.sort()


value = 1000
my_list = generate_random_list(value, 0, value)
start_time = current_milli_time()
sorted_list = standard_sort(my_list)
end_time = current_milli_time()
print(f"Сортируем список размера {value}:")
print("Время выполнения: ", end_time - start_time, " ms\n")
print(40 * "-", "\n")

value = 10_000
my_list = generate_random_list(value, 0, value)
start_time = current_milli_time()
sorted_list = standard_sort(my_list)
end_time = current_milli_time()
print(f"Сортируем список размера {value}:")
print("Время выполнения: ", end_time - start_time, " ms\n")
print(40 * "-", "\n")

value = 100_000
my_list = generate_random_list(value, 0, value)
start_time = current_milli_time()
sorted_list = standard_sort(my_list)
end_time = current_milli_time()
print(f"Сортируем список размера {value}:")
print("Время выполнения: ", end_time - start_time, " ms\n")
print(40 * "-", "\n")

value = 1_000_000
my_list = generate_random_list(value, 0, value)
start_time = current_milli_time()
sorted_list = standard_sort(my_list)
end_time = current_milli_time()
print(f"Сортируем список размера {value}:")
print("Время выполнения: ", end_time - start_time, " ms\n")
print(40 * "-", "\n")
