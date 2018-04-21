package com.javaweb.util.help.sort;

import java.util.Arrays;


//堆排序(一句话攻略:先建最大堆,然后取堆顶值,接着堆顶值和堆末值交换,移除堆末值,最后重新建最大堆,如此反复直至堆空)
public class HeapSort implements BaseSort<Integer> {

	/**
	<<算法导论>>的伪代码如下:
	BUILD-MAX-HEAP(A)
	for i=A.length downto 2
		exchange A[1] with A[i]
		A.heap-size=A.heap-size-1
		MAX-HEAPIFY(A,1)
	*/
	public Integer[] sort(Integer[] array) {
		array = buildMaxHeap(array);//构造得到最大堆
		Integer[] newArray = new Integer[array.length];
		for(int i=0;i<newArray.length;i++){
			newArray[i] = array[0];
			array[0] = array[0]^array[array.length-1];
			array[array.length-1] = array[0]^array[array.length-1];
			array[0] = array[0]^array[array.length-1];
			array = maxHeapify(Arrays.copyOfRange(array,0,newArray.length-(i+1)),0);
		}
		return newArray;
	}
	
	/**
	<<算法导论>>的伪代码如下:
	PARENT(i)
	1 return [i/2]
	*/
	//根据某一节点下标计算其父节点下标
	public Integer getParentIndexByCurrentIndex(Integer currentIndex){
		return (currentIndex-1)>>1;//(currentIndex-1)/2
	}
	
	/**
	<<算法导论>>的伪代码如下:
	LEFT(i)
	1 return 2i
	*/
	//根据某一节点下标计算其左节点下标
	public Integer getLeftIndexByCurrentIndex(Integer currentIndex){
		return (currentIndex<<1)+1;//currentIndex*2+1
	}
	
	/**
	<<算法导论>>的伪代码如下:
	RIGHT(i)
	1 return 2i+1
	*/
	//根据某一节点下标计算其右节点下标
	public Integer getRightIndexByCurrentIndex(Integer currentIndex){
		return (currentIndex<<1)+2;//currentIndex*2+2;
	}
	
	//计算堆的高度(不算根节点所在的那一层)
	public Integer getHeapHight(Integer heapLength){
		double tmp = Math.log(heapLength)/Math.log(2);//采用换底公式
		return Integer.parseInt(String.valueOf(tmp).split("\\.")[0]);
	}
	
	/**
	<<算法导论>>的伪代码如下:
	MAX-HEAPIFY(A,i)
	l=LEFT(i)
	r=RIGHT(i)
	if l<=A.heap-size and A[l]>A[i]
		largest=l
	else largest=i
	if r<=A.heap-size and A[r]>A[largest]
		largest=r
	if largest!=i
		exchange A[i] with A[largest]
		MAX-HEAPIFY(A,largest)
	*/
	//维护最大堆的性质(使当前节点的左右节点的值不大于(不小于)当前节点)
	public Integer[] maxHeapify(Integer[] array,Integer currentIndex){
		Integer currentIndexTmp = currentIndex;//当前节点的下标
		Integer leftIndex = getLeftIndexByCurrentIndex(currentIndexTmp);//当前节点的左节点的下标
		Integer rightIndex = getRightIndexByCurrentIndex(currentIndexTmp);//当前节点的右节点的下标
		if(leftIndex<array.length&&array[leftIndex]>array[currentIndexTmp]){
			currentIndexTmp = leftIndex;
		}
		if(rightIndex<array.length&&array[rightIndex]>array[currentIndexTmp]){
			currentIndexTmp = rightIndex;
		}
		if(currentIndexTmp!=currentIndex){//两数交换
			array[currentIndexTmp] = array[currentIndexTmp]^array[currentIndex];
			array[currentIndex] = array[currentIndexTmp]^array[currentIndex];
			array[currentIndexTmp] = array[currentIndexTmp]^array[currentIndex];
			return maxHeapify(array,currentIndexTmp);
		}
		return array;//终止递归
	}
	
	/**
	<<算法导论>>的伪代码如下:
	BUILD-MAX-HEAP(A)
	A.heap-size=A.length
	for i=[A.length/2] downto 1
		MAX-HEAPIFY(A,i)
	*/
	//建最大堆
	public Integer[] buildMaxHeap(Integer[] array){
		final int end = array.length/2-1;
		for(int i=end;i>=0;i--){//关键:自底向上
			array = maxHeapify(array,i);
		}
		return array;
	}

}
