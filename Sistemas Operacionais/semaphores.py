import time, threading

# Semaphores: dont stop access completly, limit through a max value
# ex: only allow 5 access, no more (multiple can access, but not unlimited)

semaphore = threading.Semaphore(5) # allow max of 5 access


# gonna run 10 threads, all numerated
# to see which is trying to access, locked
def access(thread_number):
    print("  {0} is trying to access!".format(thread_number))
    semaphore.acquire()
    print(" {0} number was granted!".format(thread_number))
    time.sleep(10)
    print("{0} is now releasing".format(thread_number))
    semaphore.release()



for thread_number in range(10):
    t = threading.Thread(target=access, args=(thread_number,))
    t.start()
    time.sleep(1)