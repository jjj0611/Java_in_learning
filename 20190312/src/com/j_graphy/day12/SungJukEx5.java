package com.j_graphy.day12;

/* [문제5] 총점으로 반등수를 계산하고 반별로 총점이 높은 순에서 낮은 순(내림차순)으로 정렬해서 list를 출력하세요.
반등수를 저장할 수 있도록 Student클래스에 인스턴스변수 classRank가 추가되어 있습니다.

calculateClassRank(List<Student> list) - 반등수(classRank)를 계산한다. */

import java.util.*; 

class SungJukEx5 { 
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
		
		calculateSchoolRank(list); // 전교등수를 계산한다.
		
		calculateClassRank(list);  // 반등수를 계산한다.
		printList(list); 
	
	} 
	
	public static void printList(List<Student> list) { 
		
		System.out.println("이름\t반\t번호\t국어\t수학\t영어\t총점\t전교등수\t반등수 "); 
		System.out.println("================================================================="); 
		
		for(Student s : list) { 
			System.out.println(s); 
		} 
		
		System.out.println("================================================================="); 
	
	} 
	
	public static void calculateSchoolRank(List<Student> list) { 
		
		Collections.sort(list); 
		
		int prevRank = -1; 
		int prevTotal = -1; 
		int length = list.size(); 
		
		for(int i=0;i < length; i++) { 
			Student s = list.get(i); 
		
		    if(s.total==prevTotal) { 
		    	s.schoolRank = prevRank; 
		    } else { 
		    	s.schoolRank = i + 1; 
		    } 
		
		    prevRank = s.schoolRank; 
		    prevTotal = s.total; 
		 } 
	} // public static void calculateSchoolRank(List<STUDENT> list) { 
	
	public static void calculateClassRank(List<Student> list) { 
		
		Collections.sort(list, new ClassTotalComparator()); // 먼저 반별 총점기준 내림차순으로 정렬한다.
		
		int prevClassNo = -1; 
		int prevRank = -1; 
		int prevTotal = -1; 
		int length = list.size();
		
		
		for (int i = 0, n = 0; i < length; i++, n++) {
			Student s = (Student) list.get(i);
			
			if (s.classNo != prevClassNo ) {
				n = 0;
				s.classRank = n + 1;
				prevRank = s.classRank;
				prevTotal = s.total;
				prevClassNo = s.classNo;
			} else {
				
				if ( s.total == prevTotal) {
					s.classRank = prevRank;
				} else {
					s.classRank = n + 1;
					prevRank = s.classRank;
					prevTotal = s.total;
				}
			}
		}
		 /*
		
		    list가 이미 정렬되어 있기 때문에... 이전 데이터하고만 총점과 반을 비교하면 된다.
		
		
		
		     다음의 코드를 완성하세요.
		
		     1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.
		
		         1.1 반이 달라지면,(classNo와 prevClassNo가 다르면)
		
		                이전등수(prevRank)와 이전총점(prevTotal)을 초기화 한다.
		
		         1.1 총점(total)이 이전총점(prevTotal)과 같으면
		
		                 이전 등수(prevRank)를 등수(schoolRank)로 한다.
		
		         1.2 총점이 서로 다르면,
		
		               등수(schoolRank)의 값을 알맞게 계산해서 저장한다.
		
		               이전에 동점자 였다면, 그 다음 등수는 동점자의 수를 고려해서 계산되어야한다.
		
		               (실행결과 화면 참고)
		
		         1.3 현재 반과 총점과 등수를 이전반(prevClassNo)와 이전총점(prevTotal)과 이전등수(prevRank)에 저장한다.
		
		 */
	} // public static void calculateClassRank(List<Student> list) { 

} 

//class Student implements Comparable<Student> { 
//	
//	String name = ""; 
//	int classNo = 0; 
//	int studentNo = 0; 
//	int koreanScore = 0; 
//	int mathScore = 0; 
//	int englishScore = 0; 
//	
//	int total = 0; 
//	
//	int schoolRank = 0; // 전교등수
//	
//	int classRank = 0;  // 반등수
//	
//	Student(String name, int classNo, int studentNo, int koreanScore, int mathScore, int englishScore) { 
//		
//		this.name = name; 
//		this.classNo = classNo; 
//		this.studentNo = studentNo; 
//		this.koreanScore = koreanScore; 
//		this.mathScore = mathScore; 
//		this.englishScore = englishScore; 
//		
//		total = koreanScore + mathScore + englishScore; 
//	
//	} 
//	
//	public String toString() { 
//		
//		return name + "\t" 
//		       + classNo + "\t" 
//		       + studentNo + "\t" 
//		       + koreanScore + "\t" 
//		       + mathScore + "\t" 
//		       + englishScore + "\t" 
//		       + total + "\t" 
//		       + schoolRank + "\t\t"
//		       + classRank + "\t";
//	}
//
//
//
//	public int compareTo(Student obj) { 
//		return obj.total - this.total; 
//		//  return this.name.compareTo(obj.name); // 이름기준으로 오름차순 정렬 
//	} 
//
//	/* 제네릭스(Generics) 사용하지 않은 버젼 
//	public int compareTo(Object obj) { 
//	 int result = -1; 
//	
//	 if(obj instanceof Student) { 
//	       Student tmp = (Student)obj; 
//	
//	       result = tmp.total - this.total; 
//	 } 
//	
//	 return result; 
//	} 
//	*/ 
//} // end of class Student 
//
//class ClassTotalComparator implements Comparator<Student> { 
//	
//	public int compare(Student s1, Student s2) { 
//		
//		int result = s1.classNo - s2.classNo; 
//		
//		if(result==0) 
//			result = s2.total - s1.total; 
//		
//		return result; 
//	} 
//} 
//
//class ClassStudentNoComparator implements Comparator<Student> { 
//	
//	public int compare(Student s1, Student s2) { 
//	
//		int result = s1.classNo - s2.classNo; 
//		
//		if(result==0)
//			result = s1.studentNo - s2.studentNo; 
//		
//		return result; 
//	} 
//}
