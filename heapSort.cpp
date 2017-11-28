#include<iostream>
using namespace std;

void __shiftDown(int arr[],int n,int k){
    while(2 * k + 1 < n){//������ڵ�
        int j = 2 * k + 1;// �ڴ���ѭ����,data[k]Ҫ��data[j]����λ��
        if(j + 1 < n && arr[j + 1] > arr[j])
            j ++;// data[j] �� data[2*k]��data[2*k+1]�е����ֵ
        if(arr[k] >= arr[j])//������ڵ���������ӽڵ��е����ֵ�ͽ���ѭ��
            break;
        swap(arr[k],arr[j]);//���򽫸��ڵ��������ӽڵ��е����ֵ����
        k = j;
    }
}

void heapSort(int arr[],int n){
    //heapify�����������鹹����һ������
    for(int i = n - 1 / 2;i >= 0;i--){//�ӵ�һ������Ҷ�ӽ��Ľ�㿪ʼ
        __shiftDown(arr,n,i);
    }
    for(int i = n - 1;i > 0;i--){
        swap(arr[0],arr[i]);//�����е�һ��ֵ�����ģ����������һ��������
        __shiftDown(arr,i,0);
    }
}

int main(){
    int arr[10] = {10,9,8,7,6,5,4,3,2,1};
    int n = 10;
    heapSort(arr,n);
    for(int i = 0;i < n;i++)
        cout<<arr[i]<<" ";
    cout<<endl;
}
