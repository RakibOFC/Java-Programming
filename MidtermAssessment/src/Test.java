class Sem1{
    
    float GPA_S1(float gpa_1){
        
        return gpa_1;
    }
}

class Sem2 extends Sem1{
    
    float  GPA_S2(float gpa_2){
        
        return gpa_2;
    }
}

class Sem3 extends Sem2{
    
    float avg_gpa;
    
    float  GPA_S3(float gpa_3){
        
        return gpa_3;
    }
    
    float SGPA(float gpa_1, float gpa_2, float gpa_3){
        
        avg_gpa = (gpa_1 + gpa_2 + gpa_3)/3;
        
        return avg_gpa;
    }
}

public class Test {
    
    public static void main(String[] args) {
        
        Sem3 id = new Sem3();
        
        float gpa_1 = id.GPA_S1(3.83f);
        float gpa_2 = id.GPA_S2(3.82f);
        float gpa_3 = id.GPA_S3(3.75f);
        
        System.out.println("First Semester GPA: " + gpa_1);
        System.out.println("Second Semester GPA: " + gpa_2);
        System.out.println("Third Semester GPA: " + gpa_3);
        System.out.println("\nAverage GPA (CGPA): " + id.SGPA(gpa_1, gpa_2, gpa_3));
    }
}
