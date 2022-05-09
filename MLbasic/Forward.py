import numpy as np
np.set_printoptions(precision=3)


def sigmoid(x):
    return 1 / (1 + np.exp(-x))


if __name__ == '__main__':
    inpData = np.array([[0.9], [0.1], [0.8]])
    print("input data")
    print(inpData)
    print("------------------------------------------------")

    Wih = np.array([[0.9, 0.3, 0.4], [0.2, 0.8, 0.2], [0.1, 0.5, 0.6]])
    Who = np.array([[0.3, 0.7, 0.5], [0.6, 0.5, 0.2], [0.8, 0.1, 0.9]])
    Xhid = np.dot(Wih, inpData)
    print("X hidden")
    print(Xhid)
    print("------------------------------------------------")

    Ohid = sigmoid(Xhid)
    print("O hidden")
    print(Ohid)
    print("------------------------------------------------")

    Xout = np.dot(Who, Ohid)
    Oout = sigmoid(Xout)
    print("O output")
    print(Oout)
    print("------------------------------------------------")
