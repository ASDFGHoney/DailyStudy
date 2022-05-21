import numpy as np

learningRate = 0.1


def sigmoid(x):
    return 1 / (1 + np.exp(-x))


def MSE(targets, values):
    res = 0
    msee = np.square(np.subtract(targets, values))/2
    for i in range(3):
        res += msee[i]
    return res


def backStep1(target_o, output_o, h, w_before):
    s1 = -(target_o-output_o)
    s2 = output_o*(1-output_o)
    s3 = h
    result = s1*s2*s3
    return w_before - learningRate*result


def backStep2(target_o, output_o, who_w, target_o1, output_o1, who_w1, target_o2, output_o2, who_w2, h, w_before):
    a1 = -(target_o - output_o)*output_o*(1-output_o)*who_w
    a2 = -(target_o1 - output_o1)*output_o1*(1-output_o1)*who_w1
    a3 = -(target_o2 - output_o2)*output_o2*(1-output_o2)*who_w2
    s1 = a1+a2+a3
    s2 = h*(1-h)
    s3 = h
    return w_before - learningRate*s1*s2*s3


if __name__ == '__main__':
    inpData = np.array([[0.9], [0.1], [0.8]])
    Wih = np.array([[0.9, 0.3, 0.4], [0.2, 0.8, 0.2], [0.1, 0.5, 0.6]])
    Who = np.array([[0.3, 0.7, 0.5], [0.6, 0.5, 0.2], [0.8, 0.1, 0.9]])
    targets = np.array([[0.6], [0.8], [0.5]])

    for i in range(10000):
        Xhid = np.dot(Wih, inpData)
        Ohid = sigmoid(Xhid)
        Xout = np.dot(Who, Ohid)
        Oout = sigmoid(Xout)

        Who = np.array([[backStep1(targets[0][0], Oout[0][0], Ohid[0][0], Who[0][0]), backStep1(targets[0][0], Oout[0][0], Ohid[1][0], Who[0][1]), backStep1(targets[0][0], Oout[0][0], Ohid[2][0], Who[0][2])], [backStep1(targets[1][0], Oout[1][0], Ohid[0][0], Who[1][0]), backStep1(
            targets[1][0], Oout[1][0], Ohid[1][0], Who[1][1]), backStep1(targets[1][0], Oout[1][0], Ohid[2][0], Who[1][2])], [backStep1(targets[2][0], Oout[2][0], Ohid[0][0], Who[2][0]), backStep1(targets[2][0], Oout[2][0], Ohid[1][0], Who[2][1]), backStep1(targets[2][0], Oout[2][0], Ohid[2][0], Who[2][2])]])

        Wih = np.array([
            [backStep2(targets[0][0], Oout[0][0], Who[0][0], targets[1][0], Oout[1][0], Who[0][1], targets[2][0], Oout[2][0], Who[0][2], Ohid[0][0], Wih[0][0]), backStep2(targets[0][0], Oout[0][0], Who[1][0], targets[1][0], Oout[1][0], Who[1][1], targets[2][0], Oout[2][0], Who[1][2], Ohid[1][0], Wih[0][1]), backStep2(targets[0][0], Oout[0][0], Who[2][0], targets[1][0], Oout[1][0], Who[2][1], targets[2][0], Oout[2][0], Who[2][2], Ohid[2][0], Wih[0][2])], [
                backStep2(targets[0][0], Oout[0][0], Who[0][0], targets[1][0], Oout[1][0], Who[0][1], targets[2][0], Oout[2][0], Who[0][2], Ohid[0][0], Wih[1][0]), backStep2(targets[0][0], Oout[0][0], Who[1][0], targets[1][0], Oout[1][0], Who[1][1], targets[2][0], Oout[2][0], Who[1][2], Ohid[1][0], Wih[1][1]), backStep2(targets[0][0], Oout[0][0], Who[2][0], targets[1][0], Oout[1][0], Who[2][1], targets[2][0], Oout[2][0], Who[2][2], Ohid[2][0], Wih[1][2])],
            [backStep2(targets[0][0], Oout[0][0], Who[0][0], targets[1][0], Oout[1][0], Who[0][1], targets[2][0], Oout[2][0], Who[0][2], Ohid[0][0], Wih[2][0]), backStep2(targets[0][0], Oout[0][0], Who[1][0], targets[1][0], Oout[1][0], Who[1][1], targets[2][0], Oout[2][0], Who[1][2], Ohid[1][0], Wih[2][1]), backStep2(targets[0][0], Oout[0][0], Who[2][0], targets[1][0], Oout[1][0], Who[2][1], targets[2][0], Oout[2][0], Who[2][2], Ohid[2][0], Wih[2][2])]])

    print(Oout)
