// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PjMgaALgDFAUq

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        int command_count, command, acceleration;
        int velocity = 0, shifting = 0;
        
        cin >> command_count;
        
        for(int i = 1; i <= command_count; i++)
        {
            cin >> command;
            switch(command)
            {
                case 1:
                    cin >> acceleration;
                    velocity += acceleration;
                    break;
                case 2:
                    cin >> acceleration;
                    velocity -= acceleration;                    
                    if(velocity < 0)
                        velocity = 0;
                    break;
                default:
                    break;
            }
            
            shifting += velocity;
        }
        
        cout << "#" << test_case << " " << shifting << endl;
        
	}
	return 0;
}