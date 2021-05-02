from threading import Thread
from time import sleep

def MyThread1():
    i=0
    while(i<8):
        print(i)
        i=i+1
    

def MyThread2():
    i=0
    while(i<8):
        print('alfabeto{0}'.format(i))
        i=i+1

t1 = Thread(target=MyThread1, args=[])
t2 = Thread(target=MyThread2, args=[])
t1.start()
t2.start()

# def threaded_function(arg):
#     for i in range(arg):
#         print("running")
#         sleep(1)


# if __name__ == "__main__":
#     thread = Thread(target = threaded_function, args = (10, ))
#     thread.start()
#     thread.join()
#     print("thread finished...exiting")
