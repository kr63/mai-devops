import random
import time


def current_milli_time():
    return int(round(time.time() * 1000))


def generate_random_list(size, min_val=0, max_val=100):
    return [random.randint(min_val, max_val) for _ in range(size)]


def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr


value = 1000
my_list = generate_random_list(value, 0, value)
start_time = current_milli_time()
sorted_list = bubble_sort(my_list)
end_time = current_milli_time()
print(f"Сортируем пузырьком список размера {value}:")
print("Время выполнения: ", end_time - start_time, " ms\n")
print(40 * "-", "\n")

value = 10_000
my_list = generate_random_list(value, 0, value)
start_time = current_milli_time()
sorted_list = bubble_sort(my_list)
end_time = current_milli_time()
print(f"Сортируем пузырьком список размера {value}:")
print("Время выполнения: ", end_time - start_time, " ms\n")
print(40 * "-", "\n")

value = 100_000
my_list = generate_random_list(value, 0, value)
start_time = current_milli_time()
sorted_list = bubble_sort(my_list)
end_time = current_milli_time()
print(f"Сортируем пузырьком список размера {value}:")
print("Время выполнения: ", end_time - start_time, " ms\n")
print(40 * "-", "\n")
