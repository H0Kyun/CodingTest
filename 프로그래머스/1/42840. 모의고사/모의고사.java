import java.util.*;


class Student {
    static Comparator<Student> byCount = Comparator
        .comparingInt(Student::getCount)
        .reversed()
        .thenComparingInt(Student::getId);
    private int id;
    private int count = 0;
    private int[] guessingMethod;
    
    Student(int id, int[] guessingMethod) {
        this.id = id;
        this.guessingMethod = guessingMethod;
    }
    
    public void checkAnswer(int[] answers) {
        for (int i = 0; i < answers.length; ++i) {
            if (answers[i] == guessingMethod[i % guessingMethod.length]) {
                ++this.count;
            }
        }
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getCount() {
        return this.count;
    }
}

class Solution {
    public int[] solution(int[] answers) {
        PriorityQueue<Student> counts = new PriorityQueue<Student>(Student.byCount);
        
        Student student1 = new Student(1, new int[]{1, 2, 3, 4, 5});
        student1.checkAnswer(answers);
        counts.offer(student1);
        
        Student student2 = new Student(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        student2.checkAnswer(answers);
        counts.offer(student2);
        
        Student student3 = new Student(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});
        student3.checkAnswer(answers);
        counts.offer(student3);
        
        List<Integer> answer  = new ArrayList();
        
        while(!counts.isEmpty()) {
            Student student = counts.poll();
            
            answer.add(student.getId());
            
            if (counts.peek() != null && student.getCount() > counts.peek().getCount()) {
                break;
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
