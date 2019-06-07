package com.j_graphy.day12;

/* [문제3] list를 다양한 기준으로 정렬하기 위해 Comaprator를 구현한 클래스를 구현하세요.

ClassTotalComparator - 반별로 총점이 높은 순에서 낮은 순으로 정렬(반은 오름차순, 총점은 내림차순)

ClassStudentNo - 반, 번호 순으로 내림차순 정렬 */

import java.util.*; 

class SungJukEx3 { 
	public static void main(String[] args) { 
		ArrayList<Student> list = new ArrayList<Student>(); 
		
		// 이름, 반, 번호, 국어, 수학, 영어 
		list.add(new Student("남궁성", 3,2,100,100,100)); 
		list.add(new Student("왕자바", 3,1,90,100,80)); 
		list.add(new Student("자바왕", 3,3,70,100,100)); 
		list.add(new Student("킹왕짱", 1,2,100,60,90)); 
		list.add(new Student("자바짱", 1,1,100,100,100)); 
		list.add(new Student("최고수", 1,3,100,80,60)); 
		list.add(new Student("홍길동", 2,1,50,80,100)); 
		list.add(new Student("일지매", 2,3,70,80,100)); 
		list.add(new Student("변강쇠", 2,4,80,80,85)); 
		list.add(new Student("이원구", 2,2,90,90,90)); 
		
		System.out.println("[반별 총점높은 순으로 정렬]"); 
		Collections.sort(list, new ClassTotalComparator()); // 반, 총점 순으로 정렬 
		printList(list); 
		
		System.out.println(); 
		
		System.out.println("[반, 번호 순으로 정렬]"); 
		Collections.sort(list, new ClassStudentNoComparator()); // 반, 번호 순으로 정렬 
		printList(list); 
		} 
		
		public static void printList(List<Student> list) { 
			System.out.println("이름\t반\t번호\t국어\t수학\t영어\t총점 "); 
			System.out.println("===================================================="); 
			
			for(Student s : list) { 
				System.out.println(s); 
		} 
		
		System.out.println("===================================================="); 
	} 
}

//class ClassTotalComparator implements Comparator {
//
//	@Override
//	public int compare(Object o1, Object o2) {
//		
//		if ( !(o1 instanceof Student && o2 instanceof Student ) ) return -1;
//		
//		Student s1 = (Student) o1;
//		Student s2 = (Student) o2;
//		
//		if ( s1.classNo > s2.classNo )
//			return 1;
//		else if ( s1.classNo < s2.classNo)
//			return -1;
//		else {
//			return s2.total - s1.total;
//		}
//		
//	}
//	
//}

//class ClassStudentNoComparator implements Comparator {
//
//	@Override
//	public int compare(Object o1, Object o2) {
//		
//		if ( !(o1 instanceof Student && o2 instanceof Student ) ) return -1;
//		
//		Student s1 = (Student) o1;
//		Student s2 = (Student) o2;
//		
//		if ( s1.classNo > s2.classNo )
//			return 1;
//		else if ( s1.classNo < s2.classNo)
//			return -1;
//		else {
//			return s1.studentNo - s2.studentNo;
//		}
//	}
//	
//}
