//
// Created by macHoney on 2022/01/28.
//

const int MAX_NUM = 1000000;
extern void putIn(int n, int a);
extern int closeDoor(int n);
extern void arrest(int n);
extern void clearRoom();

class academy{
public:
    int rono;
    academy(){
        rono = -1;

    }

    void gotojail(int nf, int nl){
        if(nl == nf) return;
        if(nl-nf == 1){
            arrest(nf);
            return;
        }
        rono++;
        for(int i = nf ; i< (nf+nl)/2 ; i++){
            putIn(rono, i);
        }if(closeDoor(rono) == 1) gotojail(nf, (nf+nl)/2);
        rono++;
        for(int i = (nf+nl)/2 ; i< nl ; i++){
            putIn(rono, i);
        }if(closeDoor(rono) == 1) gotojail((nf+nl)/2, nl);
    }
};

void investigate() {
    academy aca;

    aca.gotojail(0,MAX_NUM);
}