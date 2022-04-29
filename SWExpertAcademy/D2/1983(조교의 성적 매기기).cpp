#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin >> T;
    
	for(test_case = 1; test_case <= T; ++test_case)
	{
		int students_number, student_k;
        float mid_test_score, final_test_score, assignment_score, student_k_score;
        vector<float> avg;
        
        cin >> students_number >> student_k;
        
        for(int i = 1; i <= students_number; i++)
        {
            cin >> mid_test_score >> final_test_score >> assignment_score;
            
            avg.push_back(mid_test_score * 0.35 + final_test_score * 0.45 + assignment_score * 0.2);
            
            if(i ==student_k)
                student_k_score = mid_test_score * 0.35 + final_test_score * 0.45 + assignment_score * 0.2;
        }
        
        sort(avg.begin(), avg.end(), greater<>());
        
        int j = 0;
        
                
        for(int i = 1; i <= 10; i++)
        {
            if(avg[(students_number / 10) * i] < student_k_score)
            {
            	j = i - 1;
            	break;
			}
        }
        
        string student_k_grade;
        
        switch(j)
        {
            case 0:
                student_k_grade = "A+";
                break;
            case 1:
                student_k_grade = "A0";
                break;
			case 2:
                student_k_grade = "A-";
                break;
			case 3:
                student_k_grade = "B+";
                break;
            case 4:
                student_k_grade = "B0";
                break;
            case 5:
                student_k_grade = "B-";
                break;
            case 6:
                student_k_grade = "C+";
                break;
            case 7:
                student_k_grade = "C0";
                break;
            case 8:
                student_k_grade = "C-";
                break;
            case 9:
                student_k_grade = "D0";
                break;
        }

        cout << "#" << test_case << " " << student_k_grade << "\n";
	}
	return 0;
}