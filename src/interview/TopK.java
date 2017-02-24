package interview;

import util.HeapNode;

/**
 * Created by pengshuang on 17/2/24.
 */
public class TopK {
     public void swap(HeapNode[] heap, int index1, int index2) {
         HeapNode tmp = heap[index1];
         heap[index1] = heap[index2];
         heap[index2] = tmp;
     }

     public void heapInsert(HeapNode[] heap, int index) {
         while (index != 0) {
             int parent = (index - 1) / 2;
             if (heap[parent].value < heap[index].value) {
                 swap(heap, parent, index);
             } else {
                 break;
             }
         }
     }

     public void heapify(HeapNode[] heap, int index, int heapSize) {
         int left = index * 2 + 1;
         int right = index * 2 + 2;
         int largest = index;
         while (left < heapSize){
             if (heap[left].value > heap[largest].value){
                 largest = left;
             }
             if (right < heapSize && heap[right].value > heap[largest].value) {
                 largest = right;
             }
             if (largest != index) {
                 swap(heap, largest, index);
             } else {
                 break;
             }
             index = largest;
             left = index * 2 + 1;
             right = left + 1;
         }
     }

     public void PrintTopK(int[][] matrix, int topK) {
         int heapSize = matrix.length;
         HeapNode[] heap = new HeapNode[heapSize];
         for (int i = 0; i < heapSize; i++) {
             int index = matrix[i].length - 1;
             heap[i] = new HeapNode(matrix[i][index], i, index);
             heapInsert(heap, i);
         }
         System.out.print("Top " + topK + " : ");
         for (int i = 0; i != topK; i++) {
             if (heapSize == 0){
                 break;
             }
             System.out.print(heap[0].value + " ");
             if (heap[0].index != 0)
                     heap[0].value = matrix[heap[0].arrNum][--heap[0].index];
             else
                 swap(heap, 0, heapSize--);
             heapify(heap, 0, heapSize);
         }
     }
}
