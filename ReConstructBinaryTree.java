package algorithm;

public class ReConstructBinaryTree {
	
	public static class BinaryTreeNode{
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}
	
	public static BinaryTreeNode construct(int[] preorder,int[] inorder) {
		
		if(preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1)
			return null;
		
		return construct(preorder ,0, preorder.length - 1, inorder, 0, inorder.length - 1);
		
	}
	
	public static BinaryTreeNode construct(int[] preorder,int pstart,int pend,int[] inorder,int istart,int iend) {
		// ��ʼλ�ô��ڽ���λ��˵���Ѿ�û����Ҫ�����Ԫ����
		if(pstart > pend)
			return null;
		
		// ȡǰ������ĵ�һ�����֣����ǵ�ǰ�ĸ���� 
		int value = preorder[pstart];
		int index = istart;
		
		// ������������������Ҹ�����λ�� 
		while(index <= iend && inorder[index] != value)
			index ++;
		
		// ������������������������û���ҵ���˵������Ĳ����ǲ��Ϸ��ģ��׳��쳣  
        if (index > iend) {  
            throw new RuntimeException("Invalid input");  
        }
		
		// ������ǰ�ĸ���㣬����Ϊ��㸳ֵ
		BinaryTreeNode node = new BinaryTreeNode();
		node.value = value;
		
		// �ݹ鹹����ǰ����������������������Ԫ�ظ���(������)��index-istart+1��  
        // ��������Ӧ��ǰ�������λ����[pstart+1, pstart+index-istart]  
        // ��������Ӧ�����������λ����[istart, index-1]
		node.left = construct(preorder,pstart+1,pstart+index-istart,inorder,istart,index-1);
		
		// �ݹ鹹����ǰ����������������������Ԫ�ظ�����iend-index��  
        // ��������Ӧ��ǰ�������λ����[pstart+index-istart+1, pend]  
        // ��������Ӧ�����������λ����[index+1, iend] 
		node.right = construct(preorder,pstart+index-istart+1,pend,inorder,index+1,iend);
		
		//���ش����ĸ����
		return node;
		
	}
	
	// �������������
	public static void printTree(BinaryTreeNode root) {
		if(root != null) {
			printTree(root.left);
			System.out.print(root.value + "");
			printTree(root.right);
			
		}
	}
	
	//����
	
	// ��ͨ������  
    //              1  
    //           /     \  
    //          2       3  
    //         /       / \  
    //        4       5   6  
    //         \         /  
    //          7       8  
    private static void test1() {  
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};  
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};  
        BinaryTreeNode root = construct(preorder, inorder);  
        printTree(root);  
    }  
    // ���н�㶼û�����ӽ��  
    //            1  
    //           /  
    //          2  
    //         /  
    //        3  
    //       /  
    //      4  
    //     /  
    //    5  
    private static void test2() {  
        int[] preorder = {1, 2, 3, 4, 5};  
        int[] inorder = {5, 4, 3, 2, 1};  
        BinaryTreeNode root = construct(preorder, inorder);  
        printTree(root);  
    }  
    // ���н�㶼û�����ӽ��  
    //            1  
    //             \  
    //              2  
    //               \  
    //                3  
    //                 \  
    //                  4  
    //                   \  
    //                    5  
    private static void test3() {  
        int[] preorder = {1, 2, 3, 4, 5};  
        int[] inorder = {1, 2, 3, 4, 5};  
        BinaryTreeNode root = construct(preorder, inorder);  
        printTree(root);  
    }  
    // ����ֻ��һ�����  
    private static void test4() {  
        int[] preorder = {1};  
        int[] inorder = {1};  
        BinaryTreeNode root = construct(preorder, inorder);  
        printTree(root);  
    }  
    // ��ȫ������  
    //              1  
    //           /     \  
    //          2       3  
    //         / \     / \  
    //        4   5   6   7  
    private static void test5() {  
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};  
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};  
        BinaryTreeNode root = construct(preorder, inorder);  
        printTree(root);  
    }  
    // �����ָ��  
    private static void test6() {  
        construct(null, null);  
    }  
    // ������������в�ƥ��  
    private static void test7() {  
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};  
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};  
        BinaryTreeNode root = construct(preorder, inorder);  
        printTree(root);  
    }  
    public static void main(String[] args) {  
        test1();  
        System.out.println();  
        test2();  
        System.out.println();  
        test3();  
        System.out.println();  
        test4();  
        System.out.println();  
        test5();  
        System.out.println();  
        test6();  
        System.out.println();  
        test7();  
    }  
}
