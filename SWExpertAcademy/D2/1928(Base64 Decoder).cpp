// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PR4DKAG0DFAUq

#include<iostream>
#include<string>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin>>T;
    
    string encode_table = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

	for(test_case = 1; test_case <= T; ++test_case)
	{
        string encoded_string;
        string decoded_string ="";
        
        cin >> encoded_string;
        
        for(int i = 0; i < static_cast<int>(encoded_string.length()); i ++)
        {
            for(int j = 0; j < 64; j++)
            {
				if(encoded_string[i] == encode_table[j])
                {
                    encoded_string[i] = j;
                	break;
                }
            }
        }
        
        for(int i = 0; i < static_cast<int>(encoded_string.length()); i += 4)
        {
            string decoding_string = "***";
            
			decoding_string[0] = (encoded_string[i] << 2) + (encoded_string[i + 1] >> 4);
            decoding_string[1] = (encoded_string[i + 1] << 4) + (encoded_string[i + 2] >> 2);
            decoding_string[2] = (encoded_string[i + 2] << 6) + encoded_string[i + 3];
			
           decoded_string += decoding_string;
        }

        cout << "#" << test_case << " " << decoded_string << endl;
	}
	return 0;
}