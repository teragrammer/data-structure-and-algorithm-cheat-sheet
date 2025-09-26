def search(array, target):
    if len(array) == 0:
        return -1

    for i in range(len(array)):
        if array[i] == target:
            return i

    return -1

array = [1, 2, 3, 4, 5, 6]
target = 3

print(search(array, target))