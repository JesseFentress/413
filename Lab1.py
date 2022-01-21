from random import randint
import timeit


def gcd(a, b):
    if a == 0:
        return b
    return gcd(b % a, a)


start = timeit.default_timer()
print(gcd(56, 0))
end = timeit.default_timer()
print("Elapsed time: " + str(end - start))



l = []
for items in range(1, 1000):
    l.append(randint(1, 10000))
# print(min(l, l[0]))


def merge(l, r):
    temp = []
    left = right = 0
    while left < len(l) and right < len(r):
        if l[left] < r[right]:
            temp.append(l[left])
            left += 1
        else:
            temp.append(r[right])
            right += 1
    temp.extend(l[left:])
    temp.extend(r[right:])
    return temp


def merge_sort(l):
    if len(l) == 1:
        return l
    mid = len(l) // 2
    return merge(merge_sort(l[:mid]), merge_sort(l[mid:]))


l1 = []
for items in range(1, 1000):
    l1.append(randint(1, 10000))
start = timeit.default_timer()
print(merge_sort(l1))
end = timeit.default_timer()
print("Elapsed time: " + str(end - start))
