#include <iostream>
using namespace std;

void replaceBlack(char str[],int length){//length Ϊ�ַ�����str�������������ڻ�����ַ���str��ʵ�ʳ���

    if(length <= 0)
        return;

    int originalLen = 0;//�ַ���str��ʵ�ʳ���
    int blackNum = 0;//�ո������
    int i = 0;

    while(str[i] != '\0'){
            originalLen ++;
        if(str[i] == ' ')
            blackNum ++;

        i ++;
    }

    int newLen = originalLen + 2 * blackNum;//���ѿո��滻��'%20'֮��ĳ���
    int indexOfOriginal = originalLen;
    int indexOfNew = newLen;

    while(indexOfOriginal >= 0 && indexOfNew > indexOfOriginal){

        if(str[indexOfOriginal] == ' '){
            str[indexOfNew --] = '0';
            str[indexOfNew --] = '2';
            str[indexOfNew --] = '%';
        }
        else{
            str[indexOfNew] = str[indexOfOriginal];
            indexOfNew --;
        }

            indexOfOriginal --;
    }

}

int main(){
    const int length = 100;
    char str[length] = " hello   world  ";
    replaceBlack(str,length);
    cout<<str<<endl;
}
