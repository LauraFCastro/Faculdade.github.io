import time, threading

x = 8192

lock = threading.Lock()

def double():
    global x, lock
    lock.acquire()  # tries to acquire the lock
    # if its not free we gotta wait until its free
    # if its free, we lock it
    while x < 16384: # once its locked, do the loop
        x *= 2
        print(x)
        time.sleep(1)
    print("Reached max")
    lock.release()


def halve():
    global x, lock
    lock.acquire()
    while x > 1:
        x /= 2
        print(x)
        time.sleep(1)
    print('Reached the min')
    lock.release()


threading.Thread(target=double).start()
threading.Thread(target=halve).start()

# only one thread at a time can access the resource 